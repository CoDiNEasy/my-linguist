package translate.exceptions;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

@SuppressWarnings("serial")
public class PlaybackNotAvailableException extends Exception {
	
	public PlaybackNotAvailableException() {
		super(LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 113));
	}

}
