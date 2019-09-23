package translate.handlers;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Session;
import com.amazon.ask.request.Predicates;

import translate.LocaleLanguageSettings;
import translate.Translation;
import translate.TranslationStreamHandler;
import translate.exceptions.AudioConversionException;
import translate.exceptions.AudioPlaybackException;
import translate.exceptions.DestinationLanguageMissingException;
import translate.exceptions.OriginalStringAndDestinationLanguageMissingException;
import translate.exceptions.OriginalStringMissingException;
import translate.exceptions.ProfanityException;
import translate.exceptions.UnsupportedSpeakLanguageException;
import translate.exceptions.UnsupportedTextLanguageException;

/*end with a language or start with a language (flow)*/
public class GetLanguageHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("GetLanguageIntent"));
	}
	
	/*flow: start or end with a language; translation card; ask to repeat, other language, other word*/
	//get a language to set slot, or to translate
		public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			Request request = input.getRequestEnvelope().getRequest();
			Session session = input.getRequestEnvelope().getSession();
			IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String,Object> attributes = attributesManager.getSessionAttributes();
			
			attributes.put("SESSION_STAGE", String.valueOf("language"));
			attributesManager.setSessionAttributes(attributes);
			
			Translation mainTranslationObject = TranslationStreamHandler.mainTranslationObject;
			
			System.out.println("GetLanguageIntent");
			
			//language intent slot must have a universal language as a value
			if (mainTranslationObject.IsSupportedUniversalLanguage(intentRequest.getIntent().getSlots().get("Language").getValue().toString())) {
				//language slot is a universal language; main object destinationString set to "" > to be overwritten
				mainTranslationObject.setDestinationLanguage("");
				System.out.println("language slot value is supported universally; main object destinationLanguage set to empty");
				
				return getLanguageInput(input, request, session, intentRequest, mainTranslationObject);
			}
			//language intent slot is not a universal language
			else {
				System.out.println("language slot value is not supported universally; main object destinationLanguage is not set to empty; so keep the previous language; remind user that to say a word, must say 'translate' before");	//must say 'translate' to say a word
				
				return getLanguageInput(input, request, session, intentRequest, mainTranslationObject);
			}
		}
		
	private Optional<Response> getLanguageInput(HandlerInput input, Request request, Session session, IntentRequest intentRequest, Translation mainTranslationObject) {
		AttributesManager attributesManager = input.getAttributesManager();
        Map<String,Object> attributes = attributesManager.getSessionAttributes();
        
		//response parameters
    	String speechText = "";
		String repromptText = "";
		String cardTitle = "";
		String cardText = "";
		String streamOutputText = "";
		
		//log session stage
		System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
		
		if (attributes.containsKey("SESSION_STAGE")) {
			try {
				//main object originalString is not "" and destinationLanguage is "" or parameters are not ""
				if ((attributes.get("SESSION_STAGE").toString() == "language" && !mainTranslationObject.getOriginalString().equals("")
						&& mainTranslationObject.getDestinationLanguage().equals(""))
						|| (session.getAttributes().get(attributes.get("SESSION_STAGE").toString()) == "language" && !mainTranslationObject.getOriginalString().equals("")
						&& !mainTranslationObject.getDestinationLanguage().equals(""))) {
					//language intent slot is not a universal language
					if (!mainTranslationObject.IsSupportedUniversalLanguage(intentRequest.getIntent().getSlots().get("Language").getValue().toString())) {
						System.out.println("1.1: user triggered language intent after saying a word, but didn't say a language (language slot not a universal language)");
						
						//log of language slot
	    				System.out.println("wrong language slot value: " + intentRequest.getIntent().getSlots().get("Languages").getValue().toString());
	    				
	    				//language not supported > instead of saying a language, the user said an invalid language
	    				//remind the user to say 'translate in' followed by the language
	    				
	    				//next: state -> language
	    				System.out.println("asking for a language, by specifiying to say 'translate in' before");
	    				
	    				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 47);
	    				repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 48);
					}
					//language intent slot is a universal language
					else {
						System.out.println("1.2: originalString is not empty; destinationLanguage is empty");
						
						//log of language slot
						System.out.println("language slot value: " + intentRequest.getIntent().getSlots().get("Language").getValue().toString());
						
						//set language slot to main object destinationLanguage
		    			mainTranslationObject.setDestinationLanguage(intentRequest.getIntent().getSlots().get("Language").getValue().toString());
		    			
		    			try {
		    				//set destinationString
		    				mainTranslationObject.setDestinationString();
		    				System.out.println("destinationString set");
		    				
		    				//log of all main object parameters (originalString, destinationString, destinationLanguage)
		    				System.out.println("'" + mainTranslationObject.getOriginalString() + "' in " + mainTranslationObject.getDestinationLanguage() + " is '" + mainTranslationObject.getDestinationString().toLowerCase() + "'");
		    				
		    				//log of main object toString
		    				System.out.println("main object toString(): " + mainTranslationObject.toString());
		    				
		    				//set up destinationString audio stream
		    				streamOutputText = mainTranslationObject.ConvertAudio(mainTranslationObject.getOriginalString(), mainTranslationObject.getDestinationLanguage());
				    		System.out.println("audio conversion done");
				    		
				    		//next:	state -> repeat or language or word
				    		System.out.println("asking to repeat, a language or a word");
				    		
				    		if (mainTranslationObject.IsSupportedCardLanguage(mainTranslationObject.getDestinationLanguage())) {
					        	cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 49);
						        cardText = mainTranslationObject.toString();
					    	}
				    		
				    		speechText = streamOutputText + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 50);
				    		repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 51);
		    			//custom exceptions
		    			} catch (UnsupportedTextLanguageException UTLe) {
		    				speechText = UTLe.getMessage();
		    				System.out.println(UTLe.toString());
		    				return input.getResponseBuilder()
		    						.withSpeech("<speak>" + speechText + "</speak>")
		    						.build();
		    			} catch (UnsupportedSpeakLanguageException USLe) {
		    				if (mainTranslationObject.IsSupportedCardLanguage(mainTranslationObject.getDestinationLanguage())) {
		    					speechText = USLe.getMessage();
		    					System.out.println(USLe.toString());
		    					cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 52);
		    					cardText = mainTranslationObject.toString();
		    					//next state -> language
		    					System.out.println("next session: language");
		    				} else {
		    					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 53);
		    					System.out.println(speechText);
		    					return input.getResponseBuilder()
		    							.withSpeech("<speak>" + speechText + "</speak>")
		    							.build();
		    				}
		    			} catch (AudioConversionException ACe) {
		    				speechText = ACe.getMessage();
		    				System.out.println(ACe.toString());
		    				//destinationString can be sent in a card
		    				if (!mainTranslationObject.getDestinationLanguage().equals("")) {
		    					System.out.println("destinationString is not empty, set a card");
		    					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 54);
		    					cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 55);
		    					cardText = mainTranslationObject.toString();
		    					return input.getResponseBuilder()
		    							.withSpeech("<speak>" + speechText + "</speak>")
		    							.withSimpleCard(cardTitle, cardText)
		    							.build();
		    				}
		    				//destinationString is "", can't set a card > proceed to exception
		    				else {
		    					return input.getResponseBuilder()
		    							.withSpeech("<speak>" + speechText + "</speak>")
		    							.build();
		    				}
		    			} catch (AudioPlaybackException APe) {
		    				speechText = APe.getMessage();
		    				System.out.println(APe.toString());
		    				cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 56);
		    				cardText = mainTranslationObject.toString();
		    				return input.getResponseBuilder()
		    						.withSpeech("<speak>" + speechText + "</speak>")
		    						.withSimpleCard(cardTitle, cardText)
		    						.build();
		    			} catch (OriginalStringAndDestinationLanguageMissingException DLOSMe) {
		    				speechText = DLOSMe.getMessage();
		    				System.out.println(DLOSMe.toString());
		    				return input.getResponseBuilder()
		    						.withSpeech("<speak>" + speechText + "</speak>")
		    						.build();
		    			} catch (DestinationLanguageMissingException DLMe) {
		    				speechText = DLMe.getMessage();
		    				System.out.println(DLMe.toString());
		    				//next: state -> language
		    				System.out.println("next session: language");
		    			} catch (OriginalStringMissingException OSMe) {
		    				speechText = OSMe.getMessage();
		    				System.out.println(OSMe.toString());
		    				//next: state -> word
		    				System.out.println("next session: word");
		    			} catch (ProfanityException Pe) {
		    				//custom outputText for the direct translation
				    		speechText = Pe.getMessage();
				    		System.out.println(Pe.toString());
				    		cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 104);
				    		cardText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 104);
				    		return input.getResponseBuilder()
				    				.withSpeech("<speak>" + speechText + "</speak>")
				    				.withSimpleCard(cardTitle, cardText)
				    				.build();
		    			} catch (IOException IOe) {
		    				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 57);
				    		System.out.println(IOe.toString());
				    		return input.getResponseBuilder()
				    				.withSpeech("<speak>" + speechText + "</speak>")
				    				.build();
		    			} catch (Exception e) {
		    				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 58);
				    		System.out.println(e.toString());
				    		return input.getResponseBuilder()
				    				.withSpeech("<speak>" + speechText + "</speak>")
				    				.build();
		    			}
					}
				}
				//main object parameters are ""
				else if (attributes.get("SESSION_STAGE").toString() == "language" && mainTranslationObject.getOriginalString().equals("")
							&& mainTranslationObject.getDestinationLanguage().equals("")) {
					//language intent slot is not a universal language
					if (!mainTranslationObject.IsSupportedUniversalLanguage(intentRequest.getIntent().getSlots().get("Language").getValue().toString())) {
						System.out.println("2.1: user triggered language intenton first shot, but didn't say a language (language slot not a universal language)");
	    				
	    				//log of language slot
	    				System.out.println("wrong language slot value: " + intentRequest.getIntent().getSlots().get("Language").getValue().toString());
	    				
	    				//language not supported > instead of saying a language, the user said an invalid language
	    				//remind the user to say 'translate in' followed by the language
	    				
	    				//next: state -> language
	        			System.out.println("asking for a language, by specifiying to say 'translate in' before");
	        			
	        			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 59);
	                    repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 60);
					}
					//language intent slot is a universal language
					else {
						System.out.println("2.2: originalString and destinationLanguage are empty");
	    				
	    				//log of language slot
						System.out.println("language slot value: " + intentRequest.getIntent().getSlots().get("Language").getValue().toString());
						
						//set language slot to main object destinationLanguage
						mainTranslationObject.setDestinationLanguage(intentRequest.getIntent().getSlots().get("Language").getValue().toString());
						
						//next: state -> word
						System.out.println("asking for a word");
						
						speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 61);
			            repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 62);
					}
				}
				//main object originalString is "" and destinationLanguage is not ""
				else if (attributes.get("SESSION_STAGE").toString() == "language" && mainTranslationObject.getOriginalString().equals("")
							&& !mainTranslationObject.getDestinationLanguage().equals("")) {
					System.out.println("3: user triggered language intent, but didn't say a language (try to say a word)");
	    			
	    			//log of language slot
	    			System.out.println("wrong language slot value: " + intentRequest.getIntent().getSlots().get("Language").getValue().toString());
	    			
	    			//language not supported > instead of saying a language, the user said a word by not saying 'translate' before the word
					//remind the user to say 'translate' followed by the word or the sentence
					
					//next: stage -> word
	    			System.out.println("asking for a word, by specifiying to say 'translate' before");
	    			
	    			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 63);
		            repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 64);
				}
				//session not in language
				else if (!mainTranslationObject.getOriginalString().equals("") && mainTranslationObject.getDestinationLanguage().equals("")) {
					System.out.println("originalString is not empty; destinationLanguage is empty");
	    			System.out.println("error message: asking for a language");
	    			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 65) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 66);
	    			repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 67) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 68);
				}
				// in case
				else {
					System.out.println("error message: asking for a language");
	    			//set main object destinationLanguage to ""
	    			mainTranslationObject.setDestinationLanguage("");
	    			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 69);
	    			repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 70);
				}
				//
			} catch (Exception e) {
				System.out.println(e.getMessage());
				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 72);
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
