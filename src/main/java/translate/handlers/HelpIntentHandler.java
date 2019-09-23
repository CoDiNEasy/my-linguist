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

/*help message (i.e. instructions on using the skill)*/
public class HelpIntentHandler implements RequestHandler {
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.HelpIntent"));
	}
	
	/*terminate skill*/
	//call to say help message (i.e. instructions on using the skill)
		public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String,Object> attributes = attributesManager.getSessionAttributes();
			
	        attributes.put("SESSION_STAGE", String.valueOf("help"));
			attributesManager.setSessionAttributes(attributes);
			System.out.println("HelpIntent");
			
			//response parameters
	    	String speechText = "";
			String repromptText = "";
			String cardTitle = "";
			String cardText = "";
			
			//log session stage
			System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
			
			//help: what to do (i.e. instructions)
			
			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 89);
			repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 90);
			
			cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 91);
			cardText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 92);
			
			return input.getResponseBuilder()
					.withSpeech(speechText)
					.withSimpleCard(cardTitle, cardText)
					.withReprompt(repromptText)
					.build();
		}

}
