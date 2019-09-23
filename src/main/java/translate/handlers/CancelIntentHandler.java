package translate.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import translate.TranslationStreamHandler;

/*terminate intent*/
public class CancelIntentHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.CancelIntent"));
	}
	
	/*terminate skill*/
	//terminate session
		public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String,Object> attributes = attributesManager.getSessionAttributes();
			
	        attributes.put("SESSION_STAGE", String.valueOf("cancel"));
			attributesManager.setSessionAttributes(attributes);
			System.out.println("CancelIntent");
			
			//response parameters
	    	String speechText = "";
			
			//log session stage
			System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
			
			return input.getResponseBuilder()
					.withSpeech(speechText)
					.build();
		}
	
}
