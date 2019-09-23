package translate.exceptions;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

@SuppressWarnings("serial")
public class UnsupportedSpeakLanguageException extends Exception {
	
	public UnsupportedSpeakLanguageException() {
		super(LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 102));
	}

}
