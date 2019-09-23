package translate.exceptions;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

@SuppressWarnings("serial")
public class OriginalStringMissingException extends Exception {
	
	public OriginalStringMissingException() {
		super(LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 101));
	}

}
