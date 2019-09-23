package translate.handlers;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.services.ServiceException;
import com.amazon.ask.model.services.monetization.InSkillProduct;
import com.amazon.ask.model.services.monetization.MonetizationServiceClient;
import com.amazon.ask.request.Predicates;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

public class WhatCanIBuyHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("WhatCanIBuyIntent"));
	}
	
	public Optional<Response> handle(HandlerInput input) {
		TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
		
		AttributesManager attributesManager = input.getAttributesManager();
        Map<String,Object> attributes = attributesManager.getSessionAttributes();
        
        attributes.put("SESSION_STAGE", String.valueOf("isp"));
		attributesManager.setSessionAttributes(attributes);
		
		System.out.println("WhatCanIBuyIntent");
		
		//response parameters
    	String speechText = "";
		String repromptText = "";
		String cardTitle = "";
		String cardText = "";
		
		//log session stage
		System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
		
		try {
			MonetizationServiceClient client = input.getServiceClientFactory().getMonetizationService();
		    String locale = input.getRequestEnvelope().getRequest().getLocale();
		    
		    String productId = "amzn1.adg.product.e14b0730-ee06-4ac1-8f5a-8a98531ab610";
		    InSkillProduct responseProduct = client.getInSkillProduct(locale, productId);
		    
		    if (responseProduct != null) {
		        System.out.println("Found the product with ID" + productId);
		        speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 106) + responseProduct.getName() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 107) + responseProduct.getSummary() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 108) + responseProduct.getType() + ". ";
		        
		        if (responseProduct.getEntitled().equals("ENTITLED")) {
		        	speechText += LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 109);
		        }
		    }
		} catch (ServiceException e) {
			System.out.println("Exception occurred in calling getInSkillProduct API. Error code: " + e.getStatusCode());
			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 105);
			return input.getResponseBuilder()
					.withSpeech("<speak>" + speechText + "</speak>")
					.build();
		}
	}
	
}
