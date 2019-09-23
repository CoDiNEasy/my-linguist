package translate.exceptions;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

@SuppressWarnings("serial")
public class DestinationLanguageMissingException extends Exception {
	
	public DestinationLanguageMissingException() {
		super(LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 99));
	}

}
