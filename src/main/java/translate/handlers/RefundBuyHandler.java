package translate.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.connections.SendRequestDirective;
import com.amazon.ask.request.Predicates;

import translate.TranslationStreamHandler;

public class RefundBuyHandler implements RequestHandler {
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("RefundBuyIntent"));
	}
	
	public Optional<Response> handle(HandlerInput input) {
		TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
		
		AttributesManager attributesManager = input.getAttributesManager();
		Map<String, Object> attributes = attributesManager.getSessionAttributes();
		
		//new state
		attributes.put("SESSION_STAGE", String.valueOf("refundBuy"));
		attributesManager.setSessionAttributes(attributes);
		
		System.out.println("RefundBuyIntent");
		
		//log session stage
		System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
		
		//prepare the directive payload
		Map<String, Object> mapObject = new HashMap<String, Object>();
		Map<String, Object> inskillProduct = new HashMap<>();
		inskillProduct.put("productId", "amzn1.adg.product.d0774a86-4c7b-4aee-b931-8fd23144e33f");
		mapObject.put("InSkillProduct", inskillProduct);

		//prepare the directive request
		SendRequestDirective directive = SendRequestDirective.builder()
		    .withPayload(mapObject)
		    .withName("Cancel")
		    .withToken("sometoken")
		    .build();
		Optional<Response> response = input.getResponseBuilder()
	        .addDirective(directive)
	        .withShouldEndSession(true)
	        .build();
		
		//return directive from Skill context to trigger the action request
		return response;
	}

}
