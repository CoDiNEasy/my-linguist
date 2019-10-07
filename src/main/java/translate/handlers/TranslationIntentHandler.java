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
import translate.exceptions.PlaybackNotAvailableException;
import translate.exceptions.ProfanityException;
import translate.exceptions.UnsupportedSpeakLanguageException;
import translate.exceptions.UnsupportedTextLanguageException;

/*direct object translation*/
public class TranslationIntentHandler implements RequestHandler {
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("TranslationIntent"));
	}
	
	/*flow: direct translation using direct object with both slots; ask to repeat*/
	//get direct translation (two intents in one shot); next stage is only repeat
		public Optional<Response> handle(HandlerInput input) {
			TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
			
			IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
			
			AttributesManager attributesManager = input.getAttributesManager();
	        Map<String,Object> attributes = attributesManager.getSessionAttributes();
			
	        attributes.put("SESSION_STAGE", String.valueOf("translate"));
			attributesManager.setSessionAttributes(attributes);
			
			Translation directTranslationObject = TranslationStreamHandler.directTranslationObject;
			
			System.out.println("will be using direct object");
			System.out.println("TranslationIntent");
			
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
					if (attributes.get("SESSION_STAGE").toString() == "translate") {
						System.out.println("1: direct object parameters will be instantiated");
						
						//log of word and language slot
						System.out.println("word slot value: " + intentRequest.getIntent().getSlots().get("Word").getValue().toString());
						System.out.println("language slot value: " + intentRequest.getIntent().getSlots().get("Language").getValue().toString());
						
						//repeat condition to true
						System.out.println("setting previousStateIsTranslationIntent to true");
						TranslationStreamHandler.previousStateIsTranslationIntent = true;
						
	
						//instantiation of direct object with word and language slots
						directTranslationObject.setOriginalString(intentRequest.getIntent().getSlots().get("Word").getValue().toString());
						directTranslationObject.setDestinationLanguage(intentRequest.getIntent().getSlots().get("Language").getValue().toString());
						System.out.println("instantiated direct object; originalString and destinationLanguage are set to slot values");
						
						//log of direct object parameters
						System.out.println("direct object originalString: " + directTranslationObject.getOriginalString());
						System.out.println("direct object destinationLanguage: " + directTranslationObject.getDestinationLanguage());
						
						try {
							//set destinationString
							directTranslationObject.setDestinationString();
							System.out.println("destinationString set");
							
							//log of all direct object parameters (originalString, destinationString, destinationLanguage)
				    		System.out.println("'" + directTranslationObject.getOriginalString() + "' in " + directTranslationObject.getDestinationLanguage() + " is '" + directTranslationObject.getDestinationString().toLowerCase() + "'");
						
				    		//log of direct object toString
				    		System.out.println("direct object toString(): " + directTranslationObject.toString());
				    		
				    		//set up destinationString audio stream
				    		streamOutputText = directTranslationObject.ConvertAudio(directTranslationObject.getOriginalString(), directTranslationObject.getDestinationLanguage());
				    		System.out.println("audio conversion done");
				    		System.out.println("streamOutputText: " + streamOutputText);
				    		
				    		//next: state -> repeat
				    		System.out.println("asking to repeat");
				    		
				    		if (directTranslationObject.IsSupportedCardLanguage(directTranslationObject.getDestinationLanguage())) {
						    	cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 12);
						        cardText = directTranslationObject.toString();
				    		}
				    		
			    			speechText = streamOutputText + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 13);
			    	        repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 14);
						//custom exceptions
						} catch (PlaybackNotAvailableException PNAe) {
							System.out.println("custom PNAe for direct object");
							if (directTranslationObject.IsSupportedCardLanguage(directTranslationObject.getDestinationLanguage())) {
								speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 113);
								cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 16);
								cardText = directTranslationObject.toString();
								return input.getResponseBuilder()
										.withSpeech("<speak>" + speechText + "</speak>")
										.withSimpleCard(cardTitle, cardText)
										.build();
							} else {
								speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 17);
								return input.getResponseBuilder()
										.withSpeech("<speak>" + speechText + "</speak>")
										.withSimpleCard(cardTitle, cardText)
										.build();
							}
						} catch (UnsupportedTextLanguageException UTLe) {
							speechText = UTLe.getMessage();
							System.out.println(UTLe.toString());
							return input.getResponseBuilder()
									.withSpeech("<speak>" + speechText + "</speak")
									.build();
						} catch (UnsupportedSpeakLanguageException USLe) {
							//custom speechText for the direct object translation
							System.out.println("custom USLe for direct object");
							if (directTranslationObject.IsSupportedCardLanguage(directTranslationObject.getDestinationLanguage())) {
								speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 15);
								cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 16);
								cardText = directTranslationObject.toString();
								return input.getResponseBuilder()
										.withSpeech("<speak>" + speechText + "</speak>")
										.withSimpleCard(cardTitle, cardText)
										.build();
							} else {
								speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 17);
								return input.getResponseBuilder()
										.withSpeech("<speak>" + speechText + "</speak>")
										.withSimpleCard(cardTitle, cardText)
										.build();
							}
						} catch (AudioConversionException ACe) {
							speechText = ACe.getMessage();
							System.out.println(ACe.toString());
							//destinationString can be sent in a card
							if (!directTranslationObject.getDestinationLanguage().equals("")) {
								System.out.println("destinationString is not empty; set a card");
								speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 18);
								cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 19);
								cardText = directTranslationObject.toString();
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
							cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 20);
							cardText = directTranslationObject.toString();
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
							//custom speechText for the direct translation
							speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 21);
							System.out.println("custom DLMe for direct object");
							return input.getResponseBuilder()
									.withSpeech("<speak>" + speechText + "</speak>")
									.build();
						} catch (OriginalStringMissingException OSMe) {
							//custom speechText for direct translation
							speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 22);
							System.out.println("custom OSMe for direct object");
							return input.getResponseBuilder()
									.withSpeech("<speak>" + speechText + "</speak>")
									.build();
						} catch (ProfanityException Pe) {
							//custom speechText for the direct translation
							speechText = Pe.getMessage();
							System.out.println(Pe.toString());
							cardTitle = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 104);
							cardText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 104);
							return input.getResponseBuilder()
									.withSpeech("<speak>" + speechText + "</speak>")
									.withSimpleCard(cardTitle, cardText)
									.build();
						} catch (IOException IOe) {
							speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 23);
							System.out.println(IOe.toString());
							return input.getResponseBuilder()
									.withSpeech("<speak>" + speechText + "</speak>")
									.build();
						} catch (Exception e) {
							speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 24);
							System.out.println(e.toString());
							return input.getResponseBuilder()
									.withSpeech("<speak>" + speechText + "</speak>")
									.build();
						}
					} else {
						speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 25);
						System.out.println(speechText);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 27);
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
