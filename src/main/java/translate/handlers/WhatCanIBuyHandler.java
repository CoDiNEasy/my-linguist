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
        
        //new state
        attributes.put("SESSION_STAGE", String.valueOf("isp"));
		attributesManager.setSessionAttributes(attributes);
		
		System.out.println("WhatCanIBuyIntent");
		
		//response parameters
    	String speechText = "";
		String repromptText = "";
		
		//log session stage
		System.out.println("session stage: " + attributes.get("SESSION_STAGE").toString());
		
		try {
			MonetizationServiceClient client = input.getServiceClientFactory().getMonetizationService();
		    String locale = input.getRequestEnvelope().getRequest().getLocale();
		    
		    String productId = "amzn1.adg.product.d0774a86-4c7b-4aee-b931-8fd23144e33f";
		    InSkillProduct responseProduct = client.getInSkillProduct(locale, productId);
		    
		    if (responseProduct != null) {
		        System.out.println("Found the product with ID" + productId);
		        speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 106) + responseProduct.getName() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 107) + responseProduct.getSummary() + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 108) + responseProduct.getType() + ". ";
		        
		        //isEntitled = true
		        if (responseProduct.getEntitled().toString().equals("ENTITLED")) {
		        	speechText += LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 109);
		        	
		        	//set global var to true to unlock
		        	attributes.put("isEntitled", String.valueOf("true"));
		        	attributesManager.setSessionAttributes(attributes);
		        	TranslationStreamHandler.isEntitledProduct = true;
		        	
		        	return input.getResponseBuilder()
		        			.withSpeech("<speak>" + speechText + "</speak>")
		        			.build();
	        	//isEntitled = false
		        } else if (responseProduct.getEntitled().toString().equals("NOT_ENTITLED")) {
		        	//can purchase
		        	if (responseProduct.getPurchasable().toString().equals("PURCHASABLE")) {
		        		speechText += LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 110);
		        		repromptText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 110);
		        		return input.getResponseBuilder()
		        				.withSpeech("<speak>" + speechText + "</speak>")
		        				.withReprompt("<speak>" + repromptText + "</speak>")
		        				.build();
		        	//can't purchase
		        	} else if (responseProduct.getPurchasable().toString().equals("NOT_PURCHASABLE")) {
		        		speechText += LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 111);
		        		return input.getResponseBuilder()
		        				.withSpeech("<speak>" + speechText + "</speak>")
		        				.withShouldEndSession(true)
		        				.build();
		        	//error
		        	} else {
		        		speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 105);
		    			return input.getResponseBuilder()
		    					.withSpeech("<speak>" + speechText + "</speak>")
		    					.withShouldEndSession(true)
		    					.build();
		        	}
		        //error
		        } else {
		        	speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 105);
					return input.getResponseBuilder()
							.withSpeech("<speak>" + speechText + "</speak>")
							.withShouldEndSession(true)
							.build();
		        }
		    //error
		    } else {
		    	speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 105);
				return input.getResponseBuilder()
						.withSpeech("<speak>" + speechText + "</speak>")
						.withShouldEndSession(true)
						.build();
		    }
	    //API error
		} catch (ServiceException e) {
			System.out.println("Exception occurred in calling getInSkillProduct API. Error code: " + e.getStatusCode());
			speechText = LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 105);
			return input.getResponseBuilder()
					.withSpeech("<speak>" + speechText + "</speak>")
					.withShouldEndSession(true)
					.build();
		}
	}
	
}
