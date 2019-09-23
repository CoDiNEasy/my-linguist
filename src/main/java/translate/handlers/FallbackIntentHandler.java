package translate.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

/*intent not recognized in the intent schema*/
public class FallbackIntentHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.FallbackIntent"));
	}
	
	/*invalid intent in utterance schema*/
	//intent not recognized in intent schema
	public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String,Object> attributes = attributesManager.getSessionAttributes();
			
	        attributes.put("SESSION_STAGE", String.valueOf("invalid intent"));
			attributesManager.setSessionAttributes(attributes);
			System.out.println("FallbackIntent");
			
			//response parameters
	    	String speechText = "";
			String repromptText = "";
			
			//log session stage
			System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
			
			//intent not existent
			//ask to help: what to do
			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 93);
			repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 94);
			
			return input.getResponseBuilder()
					.withSpeech(speechText)
					.withReprompt(repromptText)
					.build();
		}
	
}
