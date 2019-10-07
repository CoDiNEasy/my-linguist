package translate.handlers;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

public class NoBuyHandler implements RequestHandler {
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("NoBuyIntent"));
	}
	
	public Optional<Response> handle(HandlerInput input) {
		TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
		
		AttributesManager attributesManager = input.getAttributesManager();
		Map<String, Object> attributes = attributesManager.getSessionAttributes();
		
		//new state
		attributes.put("SESSION_STAGE", String.valueOf("noBuy"));
		attributesManager.setSessionAttributes(attributes);
		
		System.out.println("NoBuyIntent");
		
		//response parameters
    	String speechText = "";
		
		//log session stage
		System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
		
		speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 112);
		return input.getResponseBuilder()
				.withSpeech("<speak>" + speechText + "</speak>")
				.withShouldEndSession(true)
				.build();
	}

}
