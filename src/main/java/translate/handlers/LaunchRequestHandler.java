package translate.handlers;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Session;
import com.amazon.ask.request.Predicates;

import translate.LocaleLanguageSettings;
import translate.Translation;
import translate.TranslationStreamHandler;

public class LaunchRequestHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.requestType(LaunchRequest.class));
	}

	/*welcome message; first use of the skill*/
		public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			Request request = input.getRequestEnvelope().getRequest();
			Session session = input.getRequestEnvelope().getSession();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String, Object> attributes = attributesManager.getSessionAttributes();
			
			System.out.println("launchRequestHandler requestId={}, sessionId={}: " + request.getRequestId() + ", " + session.getSessionId());
			attributes.put("SESSION_STAGE", String.valueOf("launchRequestHandler"));
			attributesManager.setSessionAttributes(attributes);
			
			Translation mainTranslationObject = TranslationStreamHandler.mainTranslationObject;
			
			System.out.println("session: launchRequestHandler");
			
			System.out.println("in handle()");
			
			//response parameters
			String speechText = "";
			String repromptText = "";
			String cardTitle = "";
			String cardText = "";
			
			//log session stage
			System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
			
			if (attributes.containsKey("SESSION_STAGE")) {
				/*main object parameters are ""*/
				if (mainTranslationObject.getOriginalString().equals("") && mainTranslationObject.getDestinationLanguage().equals("")) {
					System.out.println("1: originalString and destinationLanguage are empty");
					
					//welcome message for first use
					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 1);
					
					repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 2);
			
					//set welcome card
			        cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 3);
			        cardText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 4);
		        	
		        	//next: session.setAttribute(SESSION_STAGE, "word")
				}
				//*
				else if (attributes.get("SESSION_STAGE").toString() == "launchRequestHandler" && mainTranslationObject.getOriginalString().equals("") 
						&& !mainTranslationObject.getDestinationLanguage().equals("")) {
					System.out.println("originalString is empty; destinationLanguage is not empty");
					System.out.println("error message: asking for a word");
					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 5);
					repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 6);
				} else if (attributes.get("SESSION_STAGE").toString() == "launchRequestHandler" && !mainTranslationObject.getOriginalString().equals("") 
						&& mainTranslationObject.getDestinationLanguage().equals("")) {
					System.out.println("originalString is not empty; destinationLanguage is empty");
					System.out.println("error message: asking for a language");
					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 7) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 8);
					repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 9) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 10);
				}
				//
				else {
					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 11);
					System.out.println(speechText);
				}
			}
				
			//setting card when needed
			if (cardText != "") {
				System.out.println("setting card");
				input.getResponseBuilder().withSimpleCard(cardTitle, cardText);
			}
			//no need for a card
			else {
				System.out.println("no card set");
				return input.getResponseBuilder()
						.withSpeech(speechText)
						.withReprompt(repromptText)
						.build();
			}
	
	        return input.getResponseBuilder()
	        		.withSpeech(speechText)
	        		.withReprompt(repromptText)
	        		.build();
		}
	
}
