package translate.exceptions;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

@SuppressWarnings("serial")
public class ProfanityException extends Exception {
	
	public ProfanityException() {
		super(LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 104));
	}

}
