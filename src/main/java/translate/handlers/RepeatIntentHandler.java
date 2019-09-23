package translate.handlers;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import translate.LocaleLanguageSettings;
import translate.Translation;
import translate.TranslationStreamHandler;

/*repeat main or direct object; no asking; null exception handler*/
public class RepeatIntentHandler implements RequestHandler {
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("RepeatIntent"));
	}
	
	/*repeat previous translation*/
		public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String,Object> attributes = attributesManager.getSessionAttributes();
			
	        attributes.put("SESSION_STAGE", String.valueOf("repeat"));
			attributesManager.setSessionAttributes(attributes);
			
			Translation mainTranslationObject = TranslationStreamHandler.mainTranslationObject;
			Translation directTranslationObject = (Translation) attributes.get("directTranslationObject");
			
			System.out.println("RepeatInput");
			
			//response parameters
        	String speechText = "";
			String repromptText = "";
			String streamOutputText = "";
			
			//log session stage
			System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
			
			//main object must be instantiated
        	if (mainTranslationObject != null) {
        		if (attributes.containsKey("SESSION_STAGE")) {
        			try {
        				if (attributes.get("SESSION_STAGE").toString() == "repeat" && !mainTranslationObject.getOriginalString().equals("")
        						&& !mainTranslationObject.getDestinationLanguage().equals("")) {
        					System.out.println("1: originalString and destinationLanguage are not empty");
        					
        					try {
        						//retrieve audio stream for ssml response
        						streamOutputText = mainTranslationObject.getStreamText();
        			    		System.out.println("getting streamText to repeat");
        			    		
        			    		//log of main object toString
        			    		System.out.println("main object toString(): " + mainTranslationObject.toString());
        			    		
        			    		//next: state -> repeat, language or word
        			    		System.out.println("asking to repeat, a language or a word");
        		    			
        				        speechText = streamOutputText + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 73);
        				        repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 74);
        					} catch (Exception e) {
        						speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 75);
        						System.out.println(e.toString());
        						return input.getResponseBuilder()
        								.withSpeech("<speak>" + speechText + "</speak>")
        								.build();
        					}
        				}
        				else if (attributes.get("SESSION_STAGE").toString() == "repeat" && !directTranslationObject.getOriginalString().equals("")
        							&& !directTranslationObject.getDestinationLanguage().equals("") && TranslationStreamHandler.previousStateIsTranslationIntent == true) {
        					System.out.println("2: direct object originalString and destinationLanguage are not empty");
        					
        					//log if direct object was used previously for the translation
        					System.out.println("value of previousStateIsTranslationIntent: " + String.valueOf(TranslationStreamHandler.previousStateIsTranslationIntent));
        					
        					try {
        						//retrieve audio stream for ssml response
        						streamOutputText = directTranslationObject.getStreamText();
        						System.out.println("getting streamText to repeat");
        						
        						//log of direct object toString
        						System.out.println("direct object toString(): " + directTranslationObject.toString());
        						
        						//set next session
        						attributes.put("SESSION_STAGE", "onEnd");
        						attributesManager.setSessionAttributes(attributes);
        						System.out.println("session: onEnd");
        						
        						speechText = streamOutputText;
        						
        						//set repeat condition to false, so after session ends the repeat of direct translation does not get mixed with main object 
        				        TranslationStreamHandler.previousStateIsTranslationIntent = false;
        				        
        				        return input.getResponseBuilder()
        				        		.withSpeech("<speak>" + speechText + "</speak>")
        				        		.build();
        					} catch (Exception e) {
        						speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 76);
        						System.out.println(e.toString());
        						return input.getResponseBuilder()
        								.withSpeech("<speak>" + speechText + "</speak>")
        								.build();
        					}
        				}
	        			//*
	        			//main object parameters are ""
	        			else if (attributes.get("SESSION_STAGE").toString() == "repeat" && mainTranslationObject.getOriginalString().equals("")
	        						&& mainTranslationObject.getDestinationLanguage().equals("")) {
	        				System.out.println("originalString and destinationLanguage are empty");
	    					System.out.println("error message: asking for a word");
	    					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 77);
	    					repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 78);
	        			}
	        			//main object originalString is "" and destinationLanguage is not ""
	        			else if (attributes.get("SESSION_STAGE").toString() == "repeat" && mainTranslationObject.getOriginalString().equals("")
	        						&& !mainTranslationObject.getDestinationLanguage().equals("")) {
	        				System.out.println("originalString is empty; destinationLanguage is not empty");
	    					System.out.println("error message: asking for a word");
	    					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 79);
	    					repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 80);
	        			}
	        			//main object originalString is not "" and destinationLanguage is ""*/
	        			else if (attributes.get("SESSION_STAGE").toString() == "repeat" && !mainTranslationObject.getOriginalString().equals("")
	        						&& mainTranslationObject.getDestinationLanguage().equals("")) {
	        				System.out.println("originalString is not empty; destinationLanguage is empty");
	    					System.out.println("error message: asking for a language");
	    					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 81) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 82);
			            	repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 83) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 84);
	        			}
	        			//
	        			//session not in repeat
	        			else {
	        				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 85);
	    					System.out.println(speechText);
	        			}
	        		} catch (Exception e) {
	        			System.out.println(e.getMessage());
	    				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 87);
	    				return input.getResponseBuilder()
	    						.withSpeech("<speak>" + speechText + "</speak>")
	    						.build();
	        		}
        		}
        		
        		return input.getResponseBuilder()
        				.withSpeech("<speak>" + speechText + "</speak>")
        				.withReprompt(repromptText)
        				.build();
        	}
        	//main object not instantiated
        	else {
        		System.out.println("no main object instantiated");
        		
        		speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 88);
        		
        		return input.getResponseBuilder()
        				.withSpeech("<speak>" + speechText + "</speak>")
        				.build();
        	}
		}

}
