package translate.exceptions;

import translate.LocaleLanguageSettings;
import translate.TranslationStreamHandler;

@SuppressWarnings("serial")
public class AudioPlaybackException extends Exception {
	
	public AudioPlaybackException() {
		super(LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 98));
	}

}
