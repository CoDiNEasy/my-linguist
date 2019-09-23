package translate.handlers;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
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

/*start with a word or end with a word (flow)*/
public class GetWordIntentHandler implements RequestHandler {
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("GetWordIntent"));
	}
		
	/*flow: start or end with a word; translation card; ask to repeat, other language, other word*/
	//get a word to set slot, or to translate
		public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String,Object> attributes = attributesManager.getSessionAttributes();
			
	        attributes.put("SESSION_STAGE", String.valueOf("word"));
			attributesManager.setSessionAttributes(attributes);
			
			Translation mainTranslationObject = TranslationStreamHandler.mainTranslationObject;
			
			System.out.println("GetWordIntent");

			//main object originalString set to ""
        	mainTranslationObject.setOriginalString("");
        	System.out.println("main object originalString set to empty");
        	
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
					/*main object parameters are "" or not empty*/
					if ((attributes.get("SESSION_STAGE").toString() == "word" && mainTranslationObject.getOriginalString().equals("") 
			    			&& mainTranslationObject.getDestinationLanguage().equals(""))
			    			|| (attributes.get("SESSION_STAGE").toString() == "word" && !mainTranslationObject.getOriginalString().equals("") 
			    			&& !mainTranslationObject.getDestinationLanguage().equals(""))) {
						System.out.println("1: originalString and destinationLanguage are empty or not empty");
						
						
						//log of word and language slot
						System.out.println("word slot value: " + intentRequest.getIntent().getSlots().get("Word").getValue().toString());
						//System.out.println("language slot value: " + intentRequest.getIntent().getSlots().get("Language").getValue().toString().toString());
						
						//set word slot to main object originalString
						mainTranslationObject.setOriginalString(intentRequest.getIntent().getSlots().get("Word").getValue().toString());
						
						//next: state -> language 
						System.out.println("asking for a language");
						
						speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 28) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 29);
						repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 30) + mainTranslationObject.getOriginalString() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 31);
					}
					/*main object originalString is "" and destinationLanguage is not empty*/
					else if (attributes.get("SESSION_STAGE").toString() == "word" && mainTranslationObject.getOriginalString().equals("")
								&& !mainTranslationObject.getDestinationLanguage().equals("")) {
						System.out.println("2: originalString is empty; destinationString is not empty");
						
						//log of word slot
						System.out.println("word slot value: " + intentRequest.getIntent().getSlots().get("Word").getValue().toString());
						
						//set word slot to main object originalString
		    			mainTranslationObject.setOriginalString(intentRequest.getIntent().getSlots().get("Word").getValue().toString());
		    			
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
				    		
				    		//next: state -> repeat/language/word
				    		System.out.println("asking to repeat, a language or a word");
				    		
				    		if (mainTranslationObject.IsSupportedCardLanguage(mainTranslationObject.getDestinationLanguage())) {
					        	cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 32);
					        	cardText = mainTranslationObject.toString();
					    	}
				    		
				    		speechText = streamOutputText + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 33);
				    		repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 34);
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
		    					cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 35);
		    					cardText = mainTranslationObject.toString();
		    					//next: state -> language
		    					System.out.println("next session: language");
		    				} else {
		    					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 36);
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
				    			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 37);
				    			cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 38);
				    			cardText = mainTranslationObject.toString();
				    			return input.getResponseBuilder()
				    					.withSpeech("<speak>" + speechText + "</speak>")
				    					.withSimpleCard(cardTitle, cardText)
				    					.build();
		    				}
		    				//destinationString is ""; can't set a card > proceed to exception
		    				else {
		    					return input.getResponseBuilder()
		    							.withSpeech("<speak>" + speechText + "</speak>")
		    							.build();
		    				}
		    			} catch (AudioPlaybackException APe) {
		    				speechText = APe.getMessage();
		    				System.out.println(APe.toString());
		    				cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 39);
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
		    				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 40);
				    		System.out.println(IOe.toString());
				    		return input.getResponseBuilder()
				    				.withSpeech("<speak>" + speechText + "</speak>")
				    				.build();
		    			} catch (Exception e) {
		    				speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 41);
				    		System.out.println(e.toString());
				    		return input.getResponseBuilder()
				    				.withSpeech("<speak>" + speechText + "</speak>")
				    				.build();
		    			}
					}
					//*
					//session not in word
					else if (mainTranslationObject.getOriginalString().equals("") && !mainTranslationObject.getDestinationLanguage().equals("")) {
						System.out.println("originalString is empty; destinationLanguage is not empty");
						System.out.println("error message: asking for a word");
						speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 41);
			            repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 42);
					}
					/*main object parameters might be null*/
					else {
						//set main object originalString to ""
		    			mainTranslationObject.setOriginalString("");
		    			System.out.println("originalString was set to empty");
						System.out.println("error message: asking for a word");
						speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 43);
			            repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 44);
					}
					//
				} catch (Exception e) {
					System.out.println(e.getMessage());
					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 46);
					return input.getResponseBuilder()
							.withSpeech("<speak>" + speechText + "</speak>")
							.build();
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
