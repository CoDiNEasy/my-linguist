package translate;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import translate.handlers.CancelIntentHandler;
import translate.handlers.FallbackIntentHandler;
import translate.handlers.GetLanguageHandler;
import translate.handlers.GetWordIntentHandler;
import translate.handlers.HelpIntentHandler;
import translate.handlers.LaunchRequestHandler;
import translate.handlers.NoBuyHandler;
import translate.handlers.RefundBuyHandler;
import translate.handlers.RepeatIntentHandler;
import translate.handlers.SessionEndedRequestHandler;
import translate.handlers.StopIntentHandler;
import translate.handlers.TranslationIntentHandler;
import translate.handlers.WhatCanIBuyHandler;
import translate.handlers.YesBuyHandler;


public class TranslationStreamHandler extends SkillStreamHandler {

	public static String SESSION_LOCALE = "";		//session locale to configure the session's language settings based on the region
	
	//translation objects
	public static Translation mainTranslationObject = new Translation();		//handles all combinations of possible intents
	public static Translation directTranslationObject = new Translation();		//handles one intent (translationIntent)
	
	public static boolean previousStateIsTranslationIntent = false;		//associated to directTranslationObject; condition for getRepeatIntent() method
	
	public static boolean isEntitledProduct = false;		//ISP global variable
	
	@SuppressWarnings("unchecked")
	private static Skill getSkill() {
        return Skills.standard()
        		//.withSkillId("amzn1.ask.skill.547ffd4d-47e4-4709-93e4-dea728caed2f")	//Company: Dany Stefan  //deprecated
        		.withSkillId("amzn1.ask.skill.7db16082-d402-4da2-81ee-917f828acbf1")	//Company: CoDiN
                .addRequestHandlers(
                        new CancelIntentHandler(),
                        new FallbackIntentHandler(),
                        new GetLanguageHandler(),
                        new GetWordIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new RepeatIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new StopIntentHandler(),
                        new TranslationIntentHandler(),
                        new WhatCanIBuyHandler(),
                		new YesBuyHandler(),
                		new RefundBuyHandler(),
                		new NoBuyHandler())
                .build();
    }

    public TranslationStreamHandler() {
    	super(getSkill());
    }
	
}
