package translate.exceptions;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

@SuppressWarnings("serial")
public class OriginalStringAndDestinationLanguageMissingException extends Exception {
	
	public OriginalStringAndDestinationLanguageMissingException() {
		super(LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 100));
	}

}
