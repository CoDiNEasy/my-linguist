package translate;

public class LocaleLanguageSettings {
	
	public static String getLanguageString(String localeCode, int offset) {
		System.out.println("inside the locale language settings method: " + localeCode + " / " + offset);
		String returnedString = "Invalid locale format.";
		
		switch (localeCode.substring(0, 2)) {
			case "en":
				returnedString = en_StringsSwitch(offset); break;
			case "fr":
				returnedString = fr_StringsSwitch(offset); break;
			case "es":
				returnedString = es_StringsSwitch(offset); break;
			case "de":
				returnedString = de_StringsSwitch(offset); break;
			case "it":
				returnedString = it_StringsSwitch(offset); break;
			default:
				System.out.println("Unknown locale");
				returnedString = "";
		}	
			
		offset = 0;
		return returnedString;
	}

	private static String en_StringsSwitch(int offset) {
		String outputString = "Invalid offset format.";
		
		switch (offset) {
			case 1:
				outputString = "Welcome to My Linguist! Just ask me to translate a word or a sentence. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 2:
				outputString = "Make sure to head over to the Alexa app for any instructions if anything goes wrong."; break;
			case 3: 
				outputString = "My Linguist: Instructions"; break;
			case 4:
				outputString = "Welcome to My Linguist! Tell me the word or the sentence that you wish to translate, and the language that you request to hear it in! \nBelow, you will find some instructions: \nSay 'ask My Linguist, to translate' followed by your word or your sentence. \nTo repeat your translation, say 'repeat'. \nIf you want me to stop translating, say 'stop'. \nNote: you can only translate a sentence up to 15 words"; break;
			case 5:
				outputString = "You have not requested a word. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 6:
				outputString = "You can ask for a word or a sentence to be translated."; break;
			case 7:
				outputString = "You have not requested a language. What language would you like to translate "; break;
			case 8:
				outputString = " in?"; break;
			case 9:
				outputString = "You requested to translate "; break;
			case 10:
				outputString = ". What language would you like to translate this in?"; break;
			case 11:
				outputString = "Something went wrong on launch."; break;
			case 12:
				outputString = "Here is your translation!"; break;
			case 13:
				outputString = " If you wish to hear the translation again, ask me to repeat. Say 'repeat'."; break;
			case 14:
				outputString = "Just ask me to repeat the translation if you wish."; break;
			case 15:
				outputString = "Sorry, I don't speak that language; however, check your Alexa app. I prepared a card for you with your translation."; break;
			case 16:
				outputString = "Here is your translation!"; break;
			case 17:
				outputString = "Sorry, I don't support that language. Please try again with another language. Check the skill description page to see all supported languages."; break;
			case 18:
				outputString = "I'm not able to playback out your translation; however, check your Alexa app. I prepared a card for you with your translation."; break;
			case 19:
				outputString = "Here is your translation!"; break;
			case 20:
				outputString = "Here is your translation!"; break;
			case 21:
				outputString = "You have not provided a language for me to translate to. Please try again."; break;
			case 22:
				outputString = "You have not provided a word or a sentence for me to translate. Please try again."; break;
			case 23:
				outputString = "Something wrong happened. Please try again."; break;
			case 24:
				outputString = "Something wrong happened. Please try again."; break;
			case 25:
				outputString = "Sorry, I didn't get that. Please try again."; break;
			case 26:
				outputString = "You have to tell me a word or a sentence, and a language for your translation."; break;
			case 27:
				outputString = "Sorry, I can't process your translation at the moment."; break;
			case 28:
				outputString = "What language would you like to translate "; break;
			case 29:
				outputString = " in?"; break;
			case 30:
				outputString = "You requested to translate "; break;
			case 31:
				outputString = ". What language would you like to translate this in?"; break;
			case 32:
				outputString = "Here is your translation!"; break;
			case 33:
				outputString = " If you wish to hear the translation again, ask me to repeat. You can also ask me for another language, or another word."; break;
			case 34:
				outputString = "Ask me to repeat the translation, or ask me for another language or another word."; break;
			case 35:
				outputString = "Here is your translation!"; break;
			case 36:
				outputString = "Sorry, I don't support that language. Please try again with another language. Check the skill description page to see all supported languages."; break;
			case 37:
				outputString = "I'm not able to playback out your translation; however, check your Alexa app. I prepared a card for you with your translation."; break;
			case 38:
				outputString = "Here is your translation!"; break;
			case 39:
				outputString = "Here is your translation!"; break;
			case 40:
				outputString = "Something wrong happened. Please try again."; break;
			case 41:
				outputString = "Ask for a word or a sentence to be translated. Say 'translate' before."; break;
			case 42:
				outputString = "You can ask for a word or a sentence to be translated."; break;
			case 43:
				outputString = "Sorry, I didn't get that. Ask for a word or a sentence to be translated. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 44:
				outputString = "You can ask for a word or a sentence to be translated."; break;
			case 45:
				outputString = "You have to tell me a word or a sentence, and a language for your translation."; break;
			case 46:
				outputString = "Sorry, I can't process your translation at the moment."; break;
			case 47:
				outputString = "I don't recognize this language. Please tell me a valid language. If you meant to ask for a word or a sentence, say 'translate' before."; break;
			case 48:
				outputString = "You can ask for a language for your translation. Say 'translate in', followed by your requested language. Or, say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 49:
				outputString = "Here is your translation!"; break;
			case 50:
				outputString = " If you wish to hear the translation again, ask me to repeat. You can also ask me for another language, or another word."; break;
			case 51:
				outputString = "Ask me to repeat the translation, or ask me for another language or another word."; break;
			case 52:
				outputString = "Here is your translation!"; break;
			case 53:
				outputString = "Sorry, I don't support that language. Please try again with another language. Check the skill description page to see all supported languages."; break;
			case 54:
				outputString = "I'm not able to playback out your translation; however, check your Alexa app. I prepared a card for you with your translation."; break;
			case 55:
				outputString = "Here is your translation!"; break;
			case 56:
				outputString = "Here is your translation!"; break;
			case 57:
				outputString = "Something wrong happened. Please try again."; break;
			case 58:
				outputString = "Something wrong happened. Please try again."; break;
			case 59:
				outputString = "I don't recognize this language. Please tell me a valid language. If you meant to ask for a word or a sentence, say 'translate' before."; break;
			case 60:
				outputString = "You can ask for a language for your translation. Say 'translate in', followed by your requested language. Or, say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 61:
				outputString = "Ask for a word or a sentence to be translated. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 62:
				outputString = "You can ask for a word or a sentence to be translated."; break;
			case 63:
				outputString = "If you meant to ask for a word or a sentence, say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 64:
				outputString = "You can ask for a word or a sentence to be translated. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 65:
				outputString = "What language would you like to translate "; break;
			case 66:
				outputString = " in?"; break;
			case 67:
				outputString = "You requested to translate "; break;
			case 68:
				outputString = ". What language would you like to translate this in?"; break;
			case 69:
				outputString = "Sorry, I didn't get that. Ask for a valid language to translate to. Say 'translate in', followed by your requested language."; break;
			case 70:
				outputString = "You can ask for a language for your translation. Say 'translate in', followed by your requested language."; break;
			case 71:
				outputString = "You have to tell me a word or a sentence, and a language for your translation."; break;
			case 72:
				outputString = "Sorry, I can't process your translation at the moment."; break;
			case 73:
				outputString = " If you wish to hear the translation again, ask me to repeat. You can also ask me for another language, or another word."; break;
			case 74:
				outputString = "Ask me to repeat the translation, or ask me for another language or another word."; break;
			case 75:
				outputString = "Something wrong happened. Please try again."; break;
			case 76:
				outputString = "Something wrong happened. Please try again."; break;
			case 77:
				outputString = "You have not requested a word to be translated, nor a language. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 78:
				outputString = "You can ask for a word or a sentence to be translated."; break;
			case 79:
				outputString = "You have not requested a word to be translated. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 80:
				outputString = "You can ask for a word or a sentence to be translated."; break;
			case 81:
				outputString = "You have not requested a language. What language would you like to translate "; break;
			case 82:
				outputString = " in?"; break;
			case 83:
				outputString = "You requested to translate "; break;
			case 84:
				outputString = ". What language would you like to translate this in?"; break;
			case 85:
				outputString = "Something went wrong when repeating your previous request."; break;
			case 86:
				outputString = "You have to tell me a word or a sentence, and a language to repeat your translation."; break;
			case 87:
				outputString = "Sorry, I can't repeat your translation at the moment."; break;
			case 88:
				outputString = "You have to provide a word or a sentence, and a language for your translation."; break;
			case 89:
				outputString = "It looks like you need help. You can visit your Alexa app for any examples of what to say to me. If I didn't understand correctly, don't be shy to ask me again. Just ask me to translate a word or a sentence. Say 'translate' followed by the word or the sentence that you wish to translate. If you want to buy an in skill product, you can say 'what can I buy'."; break;
			case 90:
				outputString = "Just ask me to translate a word or a sentence. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 91:
				outputString = "My Linguist here to help!"; break;
			case 92:
				outputString = "Here are some examples of what you can say to me: \n- 'Alexa, ask My Linguist to translate <your word or your sentence here> in <your requested language>' \n- 'Alexa, ask My Linguist to translate <your word or your sentence here>' \n- 'Alexa, ask My Linguist to translate in <your requested language>' \nNote: you can only translate a sentence up to 15 words \nNote: visit the skill description page in the skill store to see all supported languages"; break;
			case 93:
				outputString = "Sorry, I can't process your request. Ask for help if you feel in the need for some."; break;
			case 94:
				outputString = "Just ask me for help. Say 'help'."; break;
			case 95:
				outputString = "in"; break;
			case 96:
				outputString = "is"; break;
			case 97:
				outputString = "Something went terribly wrong with your translation. Please try again."; break;
			case 98:
				outputString = "Sorry, I can't playback your translation. Please visit your Alexa app and take a look at the card where you will see your translation."; break;
			case 99:
				outputString = "Something went wrong. Ask again for a language to translate to. Say 'translate in' followed by your requested language."; break;
			case 100:
				outputString = "Something went wrong. You have not requested a word to be translated, nor a language. Please try again."; break;
			case 101:
				outputString = "Something went wrong. Ask again for a word or a sentence to be translated. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 102:
				outputString = "Sorry, I don't speak that language. Visit your Alexa app and take a look at the card where you will see your translation. You can try to say another language, by saying 'translate in', followed by your requested language."; break;
			case 103:
				outputString = "Sorry, I don't support that language. Please try again with another language. Check the skill description page to see all supported languages."; break;
			case 104:
				outputString = "Sorry, I don't translate profanity."; break;
			case 105:
				outputString = "Sorry, something went wrong when retrieving your in skill product."; break;
			case 106:
				outputString = "You can buy this in skill product called "; break;
			case 107:
				outputString = ". Here is a description. "; break;
			case 108:
				outputString = ". Finally, it is of type: "; break;
			case 109:
				outputString = "It looks like you have already purchased the add on. Why don't you give it a try?"; break;
			case 110:
				outputString = "Would you like to buy the in skill product?"; break;
			case 111:
				outputString = "It looks like the product is not purchasable at the moment. Please try again later."; break;
			case 112:
				outputString = "No problem. You can ask me to sign up for translation playback anytime. Just ask me 'what can I buy'."; break;
			case 113:
				outputString = "It looks like I can't playback your translation out loud, it's too long. However, take a look at your Alexa app, I sent you a card with your translation in text. Did you know you could enable the playback feature? Just ask me 'what can I buy'."; break;
			default:
				outputString = "Wrong offset.";
		}
		
		return outputString;
	}
	
	private static String fr_StringsSwitch(int offset) {
		String outputString = "Format de décalage invalide.";
		
		switch (offset) {
			case 1:
				outputString = "Bienvenue à Mon Linguiste! Demandez-moi simplement de traduire un mot ou une phrase. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 2:
				outputString = "Assurez-vous de vous rendre sur l'application Alexa pour obtenir des instructions en cas de problème."; break;
			case 3: 
				outputString = "Mon Linguiste: Instructions"; break;
			case 4:
				outputString = "Bienvenue sur Mon Linguiste! Dites-moi le mot ou la phrase que vous souhaitez traduire et la langue dans laquelle vous souhaitez l'entendre! \nCi-dessous, vous trouverez quelques instructions: \nDites 'Alexa, demande à Mon Linguiste de traduire' suivi par votre mot ou votre phrase. \nPour répéter votre traduction, dites 'répéter'. \nSi vous voulez que je cesse de traduire, dites 'arrêter'. \nNote: vous ne pouvez traduire qu'une phrase de 15 mots au maximum "; break;
			case 5:
				outputString = "Vous n'avez pas demandé de mot. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 6:
				outputString = "Vous pouvez demander la traduction d'un mot ou d'une phrase."; break;
			case 7:
				outputString = "Vous n'avez pas demandé de langue. Quelle langue aimeriez-vous traduire "; break;
			case 8:
				outputString = " dans?"; break;
			case 9:
				outputString = "Vous avez demandé de traduire "; break;
			case 10:
				outputString = ". Dans quelle langue voudriez-vous traduire cela?"; break;
			case 11:
				outputString = "Quelque chose s'est mal passé lors du lancement."; break;
			case 12:
				outputString = "Voici votre traduction!"; break;
			case 13:
				outputString = " Si vous souhaitez entendre à nouveau la traduction, demandez-moi de répéter. Dites 'répétez'."; break;
			case 14:
				outputString = "Demande-moi de répéter la traduction si tu veux."; break;
			case 15:
				outputString = "Désolé, je ne parle pas cette langue, cependant, vérifiez votre application Alexa. J'ai préparé une carte pour vous avec votre traduction."; break;
			case 16:
				outputString = "Voici votre traduction!"; break;
			case 17:
				outputString = "Désolé, cette langue n'est pas supportée. Veuillez réessayer avec une autre langue. Consultez la page de description de la skill dans le catalogue Alexa pour voir toutes les langues supportées."; break;
			case 18:
				outputString = "Je ne suis pas en mesure d'épeler votre traduction. Cependant, vérifiez votre application Alexa. J'ai préparé une carte pour vous avec votre traduction."; break;
			case 19:
				outputString = "Voici votre traduction!"; break;
			case 20:
				outputString = "Voici votre traduction!"; break;
			case 21:
				outputString = "Vous n'avez pas fourni de langue dans laquelle traduire. S'il vous plaît, essayez à nouveau."; break;
			case 22:
				outputString = "Vous n'avez pas fourni de mot ou de phrase à traduire. Veuillez réessayer."; break;
			case 23:
				outputString = "Quelque chose ne va pas. S'il vous plaît, essayez à nouveau."; break;
			case 24:
				outputString = "Quelque chose ne va pas. S'il vous plaît, essayez à nouveau."; break;
			case 25:
				outputString = "Désolé, je n'ai pas compris ça. S'il te plaît, essaye encore."; break;
			case 26:
				outputString = "Vous devez me dire un mot ou une phrase et une langue pour votre traduction."; break;
			case 27:
				outputString = "Désolé, je ne peux pas traiter votre traduction pour le moment."; break;
			case 28:
				outputString = "Dans quelle langue voulez-vous traduire "; break;
			case 29:
				outputString = "?"; break;
			case 30:
				outputString = "Vous avez demandé de traduire "; break;
			case 31:
				outputString = ". Dans quelle langue voudriez-vous traduire cela?"; break;
			case 32:
				outputString = "Voici votre traduction!"; break;
			case 33:
				outputString = " Si vous souhaitez entendre à nouveau la traduction, demandez-moi de répéter. Vous pouvez également me demander une autre langue ou un autre mot."; break;
			case 34:
				outputString = "Demandez-moi de répéter la traduction ou demandez-moi une autre langue ou un autre mot."; break;
			case 35:
				outputString = "Voici votre traduction!"; break;
			case 36:
				outputString = "Désolé, cette langue n'est pas supportée. Veuillez réessayer avec une autre langue. Consultez la page de description de la skill dans le catalogue Alexa pour voir toutes les langues supportées."; break;
			case 37:
				outputString = "Je ne suis pas en mesure d'épeler votre traduction. Cependant, vérifiez votre application Alexa. J'ai préparé une carte pour vous avec votre traduction."; break;
			case 38:
				outputString = "Voici votre traduction!"; break;
			case 39:
				outputString = "Voici votre traduction!"; break;
			case 40:
				outputString = "Quelque chose ne va pas. S'il vous plaît, essayez à nouveau."; break;
			case 41:
				outputString = "Demandez un mot ou une phrase à traduire. Dites 'traduire' avant."; break;
			case 42:
				outputString = "Vous pouvez demander la traduction d'un mot ou d'une phrase."; break;
			case 43:
				outputString = "Désolé, je n'ai pas compris. Demandez un mot ou une phrase à traduire. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 44:
				outputString = "Vous pouvez demander la traduction d'un mot ou d'une phrase."; break;
			case 45:
				outputString = "Vous devez me dire un mot ou une phrase et une langue pour votre traduction."; break;
			case 46:
				outputString = "Désolé, je ne peux pas traiter votre traduction pour le moment."; break;
			case 47:
				outputString = "Je ne reconnais pas cette langue. S'il vous plaît dites-moi une langue valide. Si vous vouliez demander un mot ou une phrase, dites 'traduire' avant."; break;
			case 48:
				outputString = "Vous pouvez demander une langue pour votre traduction. Dites 'traduire en', suivi de la langue demandée. Ou bien, dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 49:
				outputString = "Voici votre traduction!"; break;
			case 50:
				outputString = " Si vous souhaitez entendre à nouveau la traduction, demandez-moi de répéter. Vous pouvez également me demander une autre langue ou un autre mot."; break;
			case 51:
				outputString = "Demandez-moi de répéter la traduction ou demandez-moi une autre langue ou un autre mot."; break;
			case 52:
				outputString = "Voici votre traduction!"; break;
			case 53:
				outputString = "Désolé, cette langue n'est pas supportée. Veuillez réessayer avec une autre langue. Consultez la page de description de la skill dans le catalogue Alexa pour voir toutes les langues supportées."; break;
			case 54:
				outputString = "Je ne suis pas en mesure d'épeler votre traduction. Cependant, vérifiez votre application Alexa. J'ai préparé une carte pour vous avec votre traduction."; break;
			case 55:
				outputString = "Voici votre traduction!"; break;
			case 56:
				outputString = "Voici votre traduction!"; break;
			case 57:
				outputString = "Quelque chose ne va pas. S'il vous plaît, essayez à nouveau."; break;
			case 58:
				outputString = "Quelque chose ne va pas. S'il vous plaît, essayez à nouveau."; break;
			case 59:
				outputString = "Je ne reconnais pas cette langue. S'il vous plaît dites-moi une langue valide. Si vous vouliez demander un mot ou une phrase, dites 'traduire' avant."; break;
			case 60:
				outputString = "Vous pouvez demander une langue pour votre traduction. Dites 'traduire en', suivi de la langue demandée. Ou bien, dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 61:
				outputString = "Demandez un mot ou une phrase à traduire. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 62:
				outputString = "Vous pouvez demander la traduction d'un mot ou d'une phrase."; break;
			case 63:
				outputString = "Si vous vouliez demander un mot ou une phrase, dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 64:
				outputString = "Vous pouvez demander un mot ou une phrase à traduire. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 65:
				outputString = "Quelle langue voulez-vous traduire "; break;
			case 66:
				outputString = " dans?"; break;
			case 67:
				outputString = "Vous avez demandé de traduire "; break;
			case 68:
				outputString = ". Dans quelle langue voudriez-vous traduire cela?"; break;
			case 69:
				outputString = "Désolé, je n'ai pas compris ça. Demandez une langue dans laquelle traduire. Dites 'traduire en', suivi de la langue demandée."; break;
			case 70:
				outputString = "Vous pouvez demander une langue pour votre traduction. Dites 'traduire en', suivi de la langue demandée."; break;
			case 71:
				outputString = "Vous devez me dire un mot ou une phrase et une langue pour votre traduction."; break;
			case 72:
				outputString = "Désolé, je ne peux pas traiter votre traduction pour le moment."; break;
			case 73:
				outputString = " Si vous souhaitez entendre à nouveau la traduction, demandez-moi de répéter. Vous pouvez également me demander une autre langue ou un autre mot."; break;
			case 74:
				outputString = "Demandez-moi de répéter la traduction ou demandez-moi une autre langue ou un autre mot."; break;
			case 75:
				outputString = "Quelque chose ne va pas. S'il vous plaît, essayez à nouveau."; break;
			case 76:
				outputString = "Quelque chose ne va pas. S'il vous plaît, essayez à nouveau."; break;
			case 77:
				outputString = "Vous n'avez pas demandé un mot à traduire, ni une langue. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 78:
				outputString = "Vous pouvez demander la traduction d'un mot ou d'une phrase."; break;
			case 79:
				outputString = "Vous n'avez pas demandé qu'un mot soit traduit. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 80:
				outputString = "Vous pouvez demander la traduction d'un mot ou d'une phrase."; break;
			case 81:
				outputString = "Vous n'avez pas demandé de langue. Quelle langue aimeriez-vous traduire "; break;
			case 82:
				outputString = " dans?"; break;
			case 83:
				outputString = "Vous avez demandé de traduire "; break;
			case 84:
				outputString = ". Dans quelle langue voudriez-vous traduire cela?"; break;
			case 85:
				outputString = "Une erreur s'est produite lors de la répétition de votre demande précédente."; break;
			case 86:
				outputString = "Vous devez me dire un mot ou une phrase et une langue pour répéter votre traduction."; break;
			case 87:
				outputString = "Désolé, je ne peux pas répéter votre traduction pour le moment."; break;
			case 88:
				outputString = "Vous devez fournir un mot ou une phrase et une langue pour votre traduction."; break;
			case 89:
				outputString = "On dirait que vous avez besoin d'aide. Vous pouvez visiter votre application Alexa pour des exemples de ce qu'il faut me dire. Si je n'ai pas bien compris, n'hésitez pas à me le demander à nouveau. Il suffit de me demander de traduire un mot ou une phrase. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 90:
				outputString = "Il suffit de me demander de traduire un mot ou une phrase. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 91:
				outputString = "Mon Linguiste ici pour aider!"; break;
			case 92:
				outputString = "Voici quelques exemples de ce que vous pouvez me dire: \n- 'Alexa, demande à Mon Linguiste de traduire <votre mot ou votre phrase ici> dans <votre langue demandée>' \n - 'Alexa, demande à Mon Linguiste de traduire <votre mot ou votre phrase ici>' \n- 'Alexa, demande à Mon Linguiste de traduire en <votre langue demandée>' \nNote: vous ne pouvez traduire qu'une phrase de 15 mots maximum \nNote: visitez la page de description de la skill dans le catalogue Alexa pour voir toutes les langues supportées"; break;
			case 93:
				outputString = "Désolé, je ne peux pas traiter votre demande. Demandez de l'aide si vous en ressentez le besoin."; break;
			case 94:
				outputString = "Demandez-moi de l'aide. Dites 'aide'."; break;
			case 95:
				outputString = "en"; break;
			case 96:
				outputString = "se traduit"; break;
			case 97:
				outputString = "Quelque chose a mal tourné avec votre traduction. Veuillez réessayer."; break;
			case 98:
				outputString = "Désolé, je ne peux pas lire votre traduction. S'il vous plaît visitez votre application Alexa et jetez un oeil à la carte où vous verrez votre traduction."; break;
			case 99:
				outputString = "Quelque chose s'est mal passé. Demander encore une langue pour traduire. Dites 'traduire en' suivi de la langue demandée."; break;
			case 100:
				outputString = "Quelque chose s'est mal passé. Vous n'avez pas demandé un mot à traduire, ni une langue. Veuillez réessayer."; break;
			case 101:
				outputString = "Quelque chose s'est mal passé. Demander à nouveau un mot ou une phrase à traduire. Dites 'traduire' suivi du mot ou de la phrase que vous souhaitez traduire."; break;
			case 102:
				outputString = "Désolé, je ne parle pas cette langue. Visitez votre application Alexa et jetez un coup d'œil à la carte sur laquelle vous verrez votre traduction. Vous pouvez essayer de dire une autre langue en disant 'traduire en', suivi de la langue demandée."; break;
			case 103:
				outputString = "Désolé, je ne supporte pas cette langue. Veuillez réessayer avec une autre langue. Consultez la page de description des skills pour voir toutes les langues prises en charge."; break;
			case 104:
				outputString = "Désolé, je ne traduis pas de grossièretés."; break;
			case 105:
				outputString = "Désolé, une erreur s'est produite lors de la récupération de votre produit intégré."; break;
			default:
				outputString = "Mauvais offset.";
	}
		
		return outputString;
	}

	private static String es_StringsSwitch(int offset) {
		String outputString = "Formato de desplazamiento no válido.";
		
		switch (offset) {
			case 1:
				outputString = "¡Bienvenido a Mi Lingüista! Solo pídeme que traduzca una palabra o una oración. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 2:
				outputString = "Asegúrese de dirigirse a la aplicación Alexa para obtener instrucciones si algo sale mal."; break;
			case 3: 
				outputString = "Mi Lingüista: instrucciones"; break;
			case 4:
				outputString = "¡Bienvenido a Mi Lingüista! ¡Dígame la palabra o la oración que desea traducir y el idioma en el que solicita escucharla! \nA continuación, encontrará algunas instrucciones: \nDiga 'pedirle a mi lingüista que traduzca' seguido de su palabra o su oración. \nPara repetir su traducción, diga 'repetir'. \nSi quieres que deje de traducir, di 'detener'. \nNota: solo puedes traducir una oración de hasta 15 palabras"; break;
			case 5:
				outputString = "No has solicitado una palabra. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 6:
				outputString = "Puede pedir que se traduzca una palabra o una oración."; break;
			case 7:
				outputString = "No has solicitado un idioma. ¿Qué idioma te gustaría traducir "; break;
			case 8:
				outputString = " en?"; break;
			case 9:
				outputString = "Solicitaste traducir "; break;
			case 10:
				outputString = ". ¿En qué idioma te gustaría traducir esto?"; break;
			case 11:
				outputString = "Algo salió mal en el lanzamiento."; break;
			case 12:
				outputString = "¡Aquí está tu traducción!"; break;
			case 13:
				outputString = "Si desea volver a escuchar la traducción, solicite que repita. Di 'repetir'."; break;
			case 14:
				outputString = "Solo pídeme que repita la traducción si lo deseas."; break;
			case 15:
				outputString = "Lo siento, no hablo ese idioma; sin embargo, verifique su aplicación Alexa. Te preparé una tarjeta con tu traducción."; break;
			case 16:
				outputString = "¡Aquí está tu traducción!"; break;
			case 17:
				outputString = "Lo siento, no soporto ese idioma. Por favor intente nuevamente con otro idioma. Consulte la página de descripción de la skill para ver todos los idiomas admitidos."; break;
			case 18:
				outputString = "No puedo deletrear tu traducción; sin embargo, verifique su aplicación Alexa. Te preparé una tarjeta con tu traducción."; break;
			case 19:
				outputString = "¡Aquí está tu traducción!"; break;
			case 20:
				outputString = "¡Aquí está tu traducción!"; break;
			case 21:
				outputString = "No me has proporcionado un idioma para traducir. Inténtalo de nuevo."; break;
			case 22:
				outputString = "No ha proporcionado una palabra o una frase para que yo traduzca. Inténtalo de nuevo."; break;
			case 23:
				outputString = "Algo malo paso. Inténtalo de nuevo."; break;
			case 24:
				outputString = "Algo malo paso. Inténtalo de nuevo."; break;
			case 25:
				outputString = "Lo siento, no entendí eso. Inténtalo de nuevo."; break;
			case 26:
				outputString = "Tienes que decirme una palabra o una oración, y un idioma para tu traducción."; break;
			case 27:
				outputString = "Lo siento, no puedo procesar tu traducción en este momento."; break;
			case 28:
				outputString = "¿Qué idioma te gustaría traducir "; break;
			case 29:
				outputString = " en?"; break;
			case 30:
				outputString = "Solicitaste traducir "; break;
			case 31:
				outputString = ". ¿En qué idioma te gustaría traducir esto?"; break;
			case 32:
				outputString = "¡Aquí está tu traducción!"; break;
			case 33:
				outputString = " Si desea volver a escuchar la traducción, solicite que repita. También puedes pedirme otro idioma u otra palabra."; break;
			case 34:
				outputString = "Pídeme que repita la traducción, o pídeme otro idioma u otra palabra."; break;
			case 35:
				outputString = "¡Aquí está tu traducción!"; break;
			case 36:
				outputString = "Lo siento, no soporto ese idioma. Por favor intente nuevamente con otro idioma. Consulte la página de descripción de la habilidad para ver todos los idiomas admitidos."; break;
			case 37:
				outputString = "No puedo deletrear tu traducción; sin embargo, verifique su aplicación Alexa. Te preparé una tarjeta con tu traducción."; break;
			case 38:
				outputString = "¡Aquí está tu traducción!"; break;
			case 39:
				outputString = "¡Aquí está tu traducción!"; break;
			case 40:
				outputString = "Algo malo paso. Inténtalo de nuevo."; break;
			case 41:
				outputString = "Pida que se traduzca una palabra o una oración. Di 'traducir' antes."; break;
			case 42:
				outputString = "Puede pedir que se traduzca una palabra o una oración."; break;
			case 43:
				outputString = "Lo siento, no entendí eso. Pida que se traduzca una palabra o una oración. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 44:
				outputString = "Puede pedir que se traduzca una palabra o una oración."; break;
			case 45:
				outputString = "Tienes que decirme una palabra o una oración, y un idioma para tu traducción."; break;
			case 46:
				outputString = "Lo siento, no puedo procesar tu traducción en este momento."; break;
			case 47:
				outputString = "No reconozco este lenguaje, por favor dime un idioma válido. Si tenía la intención de pedir una palabra o una oración, diga 'traducir' antes."; break;
			case 48:
				outputString = "Puede solicitar un idioma para su traducción. Diga 'traducir en', seguido de su idioma solicitado. O bien, diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 49:
				outputString = "¡Aquí está tu traducción!"; break;
			case 50:
				outputString = " Si desea volver a escuchar la traducción, solicite que repita. También puedes pedirme otro idioma u otra palabra."; break;
			case 51:
				outputString = "Pídeme que repita la traducción, o pídeme otro idioma u otra palabra."; break;
			case 52:
				outputString = "¡Aquí está tu traducción!"; break;
			case 53:
				outputString = "Lo siento, no soporto ese idioma. Por favor intente nuevamente con otro idioma. Consulte la página de descripción de la habilidad para ver todos los idiomas admitidos."; break;
			case 54:
				outputString = "No puedo deletrear tu traducción; sin embargo, verifique su aplicación Alexa. Te preparé una tarjeta con tu traducción."; break;
			case 55:
				outputString = "¡Aquí está tu traducción!"; break;
			case 56:
				outputString = "¡Aquí está tu traducción!"; break;
			case 57:
				outputString = "Algo malo paso. Inténtalo de nuevo."; break;
			case 58:
				outputString = "Algo malo paso. Inténtalo de nuevo."; break;
			case 59:
				outputString = "No reconozco este lenguaje, por favor dime un idioma válido. Si tenía la intención de pedir una palabra o una oración, diga 'traducir' antes."; break;
			case 60:
				outputString = "Puede solicitar un idioma para su traducción. Diga 'traducir en', seguido de su idioma solicitado. O bien, diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 61:
				outputString = "Pida que se traduzca una palabra o una oración. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 62:
				outputString = "Puede pedir que se traduzca una palabra o una oración."; break;
			case 63:
				outputString = "Si desea pedir una palabra o una oración, diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 64:
				outputString = "Puede pedir que se traduzca una palabra o una oración. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 65:
				outputString = "¿Qué idioma te gustaría traducir "; break;
			case 66:
				outputString = " en?"; break;
			case 67:
				outputString = "Solicitaste traducir "; break;
			case 68:
				outputString = ". ¿En qué idioma te gustaría traducir esto?"; break;
			case 69:
				outputString = "Lo siento, no entendí eso. Solicite un idioma válido para traducir. Diga 'traducir en', seguido de su idioma solicitado."; break;
			case 70:
				outputString = "Puede solicitar un idioma para su traducción. Diga 'traducir en', seguido de su idioma solicitado."; break;
			case 71:
				outputString = "Tienes que decirme una palabra o una oración, y un idioma para tu traducción."; break;
			case 72:
				outputString = "Lo siento, no puedo procesar tu traducción en este momento."; break;
			case 73:
				outputString = " Si desea volver a escuchar la traducción, solicite que repita. También puedes pedirme otro idioma u otra palabra."; break;
			case 74:
				outputString = "Pídeme que repita la traducción, o pídeme otro idioma u otra palabra."; break;
			case 75:
				outputString = "Algo malo paso. Inténtalo de nuevo."; break;
			case 76:
				outputString = "Algo malo paso. Inténtalo de nuevo."; break;
			case 77:
				outputString = "No ha solicitado que se traduzca una palabra, ni un idioma. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 78:
				outputString = "Puede pedir que se traduzca una palabra o una oración."; break;
			case 79:
				outputString = "No ha solicitado que se traduzca una palabra. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 80:
				outputString = "Puede pedir que se traduzca una palabra o una oración."; break;
			case 81:
				outputString = "No has solicitado un idioma. ¿Qué idioma te gustaría traducir "; break;
			case 82:
				outputString = " en?"; break;
			case 83:
				outputString = "Solicitaste traducir "; break;
			case 84:
				outputString = ". ¿En qué idioma te gustaría traducir esto?"; break;
			case 85:
				outputString = "Algo salió mal al repetir su solicitud anterior."; break;
			case 86:
				outputString = "Tienes que decirme una palabra o una oración, y un idioma para repetir tu traducción."; break;
			case 87:
				outputString = "Lo siento, no puedo repetir tu traducción en este momento."; break;
			case 88:
				outputString = "Debe proporcionar una palabra o una oración, y un idioma para su traducción."; break;
			case 89:
				outputString = "Parece que necesitas ayuda. Puede visitar su aplicación Alexa para ver ejemplos de qué decirme. Si no entendí correctamente, no dudes en preguntarme de nuevo. Solo pídeme que traduzca una palabra o una oración. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 90:
				outputString = "Solo pídeme que traduzca una palabra o una oración. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 91:
				outputString = "¡Mi Lingüista está aquí para ayudar!"; break;
			case 92:
				outputString = "Estos son algunos ejemplos de lo que puede decirme: \n- 'Alexa, pídale a Mi Lingüista que traduzca <su palabra o su oración aquí> en <su idioma solicitado>' \n- 'Alexa, pídale a Mi Lingüista que traduzca < tu palabra o tu oración aquí> '\n-' Alexa, pide a Mi Lingüista que traduzca en <tu idioma solicitado> '\nNota: solo puedes traducir una oración de hasta 15 palabras \nNota: visita la página de descripción de la habilidad en la habilidad almacenar para ver todos los idiomas compatibles"; break;
			case 93:
				outputString = "Lo siento, no puedo procesar su solicitud. Pida ayuda si siente la necesidad de algo."; break;
			case 94:
				outputString = "Solo pídeme ayuda. Di 'ayuda'."; break;
			case 95:
				outputString = "en"; break;
			case 96:
				outputString = "es"; break;
			case 97:
				outputString = "Algo salió terriblemente mal con tu traducción. Inténtalo de nuevo."; break;
			case 98:
				outputString = "Lo siento, no puedo reproducir tu traducción. Visite su aplicación Alexa y eche un vistazo a la tarjeta donde verá su traducción."; break;
			case 99:
				outputString = "Algo salió mal. Pida nuevamente un idioma para traducir. Diga 'traducir en' seguido de su idioma solicitado."; break;
			case 100:
				outputString = "Algo salió mal. No ha solicitado que se traduzca una palabra, ni un idioma. Inténtalo de nuevo."; break;
			case 101:
				outputString = "Algo salió mal. Pida nuevamente que se traduzca una palabra o una oración. Diga 'traducir' seguido de la palabra o la oración que desea traducir."; break;
			case 102:
				outputString = "Lo siento, no hablo ese idioma. Visite su aplicación Alexa y eche un vistazo a la tarjeta donde verá su traducción. Puede intentar decir otro idioma, diciendo 'traducir en', seguido de su idioma solicitado."; break;
			case 103:
				outputString = "Lo siento, no soporto ese idioma. Por favor intente nuevamente con otro idioma. Consulte la página de descripción de la habilidad para ver todos los idiomas admitidos."; break;
			case 104:
				outputString = "Lo siento, no traduzco blasfemias."; break;
			case 105:
				outputString = "Lo sentimos, algo salió mal al recuperar su producto en habilidad."; break;
			default:
				outputString = "Desviación incorrecta.";
		}
		
		return outputString;
	}

	private static String de_StringsSwitch(int offset) {
		String outputString = "Ungültiges Versatzformat.";
		
		switch (offset) {
			case 1:
				outputString = "Willkommen bei Mein Linguist! Bitten Sie mich einfach, ein Wort oder einen Satz zu übersetzen. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 2:
				outputString = "Besuchen Sie die Alexa-App, um Anweisungen zu erhalten, falls etwas schief geht."; break;
			case 3: 
				outputString = "Mein Linguist: Anweisungen"; break;
			case 4:
				outputString = "Willkommen bei Mein Linguist! Sagen Sie mir das Wort oder den Satz, den Sie übersetzen möchten, und die Sprache, in der Sie es hören möchten! \nNachstehend finden Sie einige Anweisungen: \nBitten Sie Mein Linguist, zu übersetzen, gefolgt von Ihrem Wort oder Ihrem Satz. \nUm Ihre Übersetzung zu wiederholen, sagen Sie 'Wiederholen'. \nWenn Sie möchten, dass ich aufhöre zu übersetzen, sagen Sie 'Stop'. \nHinweis: Sie können nur einen Satz mit bis zu 15 Wörtern übersetzen."; break;
			case 5:
				outputString = "Sie haben kein Wort angefordert. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 6:
				outputString = "Sie können nach einem zu übersetzenden Wort oder Satz fragen."; break;
			case 7:
				outputString = "Sie haben keine Sprache angefordert. Welche Sprache möchten Sie übersetzen "; break;
			case 8:
				outputString = " im?"; break;
			case 9:
				outputString = "Sie haben um Übersetzung gebeten "; break;
			case 10:
				outputString = ". In welche Sprache möchten Sie das übersetzen?"; break;
			case 11:
				outputString = "Beim Start ist etwas schief gelaufen."; break;
			case 12:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 13:
				outputString = " Wenn Sie die Übersetzung noch einmal hören möchten, bitten Sie mich, es zu wiederholen. Sagen Sie 'wiederholen'."; break;
			case 14:
				outputString = "Bitten Sie mich einfach, die Übersetzung zu wiederholen, wenn Sie dies wünschen."; break;
			case 15:
				outputString = "Entschuldigung, ich spreche diese Sprache nicht. Überprüfen Sie jedoch Ihre Alexa-App. Ich habe eine Karte mit Ihrer Übersetzung für Sie vorbereitet."; break;
			case 16:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 17:
				outputString = "Entschuldigung, ich unterstütze diese Sprache nicht. Bitte versuchen Sie es mit einer anderen Sprache erneut. Überprüfen Sie die Skill-Beschreibungsseite, um alle unterstützten Sprachen anzuzeigen."; break;
			case 18:
				outputString = "Ich kann Ihre Übersetzung nicht abspielen. Überprüfen Sie jedoch Ihre Alexa-App. Ich habe eine Karte mit Ihrer Übersetzung für Sie vorbereitet."; break;
			case 19:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 20:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 21:
				outputString = "Sie haben mir keine Sprache zur Verfügung gestellt, in die ich übersetzen könnte. Bitte versuche es erneut."; break;
			case 22:
				outputString = "Sie haben kein Wort oder keinen Satz für mich zum Übersetzen angegeben. Bitte versuche es erneut."; break;
			case 23:
				outputString = "Etwas ist schiefgelaufen. Bitte versuche es erneut."; break;
			case 24:
				outputString = "Etwas ist schiefgelaufen. Bitte versuche es erneut."; break;
			case 25:
				outputString = "Entschuldigung, das habe ich nicht verstanden. Bitte versuche es erneut."; break;
			case 26:
				outputString = "Sie müssen mir ein Wort oder einen Satz und eine Sprache für Ihre Übersetzung sagen."; break;
			case 27:
				outputString = "Entschuldigung, ich kann Ihre Übersetzung im Moment nicht bearbeiten."; break;
			case 28:
				outputString = "Welche Sprache möchten Sie übersetzen "; break;
			case 29:
				outputString = " im?"; break;
			case 30:
				outputString = "Sie haben um Übersetzung gebeten "; break;
			case 31:
				outputString = ". In welche Sprache möchten Sie das übersetzen?"; break;
			case 32:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 33:
				outputString = " Wenn Sie die Übersetzung noch einmal hören möchten, bitten Sie mich, es zu wiederholen. Sie können mich auch nach einer anderen Sprache oder einem anderen Wort fragen."; break;
			case 34:
				outputString = "Bitten Sie mich, die Übersetzung zu wiederholen, oder bitten Sie mich um eine andere Sprache oder ein anderes Wort."; break;
			case 35:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 36:
				outputString = "Entschuldigung, ich unterstütze diese Sprache nicht. Bitte versuchen Sie es mit einer anderen Sprache erneut. Überprüfen Sie die Skill-Beschreibungsseite, um alle unterstützten Sprachen anzuzeigen."; break;
			case 37:
				outputString = "Ich kann Ihre Übersetzung nicht abspielen. Überprüfen Sie jedoch Ihre Alexa-App. Ich habe eine Karte mit Ihrer Übersetzung für Sie vorbereitet."; break;
			case 38:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 39:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 40:
				outputString = "Etwas ist schiefgelaufen. Bitte versuche es erneut."; break;
			case 41:
				outputString = "Bitten Sie um ein Wort oder einen Satz, der übersetzt werden soll. Sagen Sie vorher 'übersetzen'."; break;
			case 42:
				outputString = "Sie können nach einem zu übersetzenden Wort oder Satz fragen."; break;
			case 43:
				outputString = "Entschuldigung, das habe ich nicht verstanden. Bitten Sie um ein Wort oder einen Satz, der übersetzt werden soll. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 44:
				outputString = "Sie können nach einem zu übersetzenden Wort oder Satz fragen."; break;
			case 45:
				outputString = "Sie müssen mir ein Wort oder einen Satz und eine Sprache für Ihre Übersetzung sagen."; break;
			case 46:
				outputString = "Entschuldigung, ich kann Ihre Übersetzung im Moment nicht bearbeiten."; break;
			case 47:
				outputString = "Ich erkenne diese Sprache nicht. Bitte geben Sie eine gültige Sprache an. Wenn Sie nach einem Wort oder einem Satz fragen wollten, sagen Sie vorher 'übersetzen'."; break;
			case 48:
				outputString = "Sie können nach einer Sprache für Ihre Übersetzung fragen. Sagen Sie 'übersetzen in', gefolgt von Ihrer gewünschten Sprache. Oder sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 49:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 50:
				outputString = " Wenn Sie die Übersetzung noch einmal hören möchten, bitten Sie mich, es zu wiederholen. Sie können mich auch nach einer anderen Sprache oder einem anderen Wort fragen."; break;
			case 51:
				outputString = "Bitten Sie mich, die Übersetzung zu wiederholen, oder bitten Sie mich um eine andere Sprache oder ein anderes Wort."; break;
			case 52:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 53:
				outputString = "Entschuldigung, ich unterstütze diese Sprache nicht. Bitte versuchen Sie es mit einer anderen Sprache erneut. Überprüfen Sie die Skill-Beschreibungsseite, um alle unterstützten Sprachen anzuzeigen."; break;
			case 54:
				outputString = "Ich kann Ihre Übersetzung nicht abspielen. Überprüfen Sie jedoch Ihre Alexa-App. Ich habe eine Karte mit Ihrer Übersetzung für Sie vorbereitet."; break;
			case 55:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 56:
				outputString = "Hier ist Ihre Übersetzung!"; break;
			case 57:
				outputString = "Etwas ist schiefgelaufen. Bitte versuche es erneut."; break;
			case 58:
				outputString = "Etwas ist schiefgelaufen. Bitte versuche es erneut."; break;
			case 59:
				outputString = "Ich erkenne diese Sprache nicht. Bitte geben Sie eine gültige Sprache an. Wenn Sie nach einem Wort oder einem Satz fragen wollten, sagen Sie vorher 'übersetzen'."; break;
			case 60:
				outputString = "Sie können nach einer Sprache für Ihre Übersetzung fragen. Sagen Sie 'übersetzen in', gefolgt von Ihrer gewünschten Sprache. Oder sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 61:
				outputString = "Bitten Sie um ein Wort oder einen Satz, der übersetzt werden soll. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 62:
				outputString = "Sie können nach einem zu übersetzenden Wort oder Satz fragen."; break;
			case 63:
				outputString = "Wenn Sie nach einem Wort oder einem Satz fragen möchten, sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 64:
				outputString = "Sie können nach einem zu übersetzenden Wort oder Satz fragen. Say 'translate' followed by the word or the sentence that you wish to translate."; break;
			case 65:
				outputString = "Welche Sprache möchten Sie übersetzen "; break;
			case 66:
				outputString = " im?"; break;
			case 67:
				outputString = "Sie haben um Übersetzung gebeten "; break;
			case 68:
				outputString = ". In welche Sprache möchten Sie das übersetzen?"; break;
			case 69:
				outputString = "Entschuldigung, das habe ich nicht verstanden. Fragen Sie nach einer gültigen Sprache, in die übersetzt werden soll. Sagen Sie 'übersetzen in', gefolgt von Ihrer gewünschten Sprache."; break;
			case 70:
				outputString = "Sie können nach einer Sprache für Ihre Übersetzung fragen. Sagen Sie 'übersetzen in', gefolgt von Ihrer gewünschten Sprache."; break;
			case 71:
				outputString = "Sie müssen mir ein Wort oder einen Satz und eine Sprache für Ihre Übersetzung sagen."; break;
			case 72:
				outputString = "Entschuldigung, ich kann Ihre Übersetzung im Moment nicht bearbeiten."; break;
			case 73:
				outputString = " Wenn Sie die Übersetzung noch einmal hören möchten, bitten Sie mich, es zu wiederholen. Sie können mich auch nach einer anderen Sprache oder einem anderen Wort fragen."; break;
			case 74:
				outputString = "Bitten Sie mich, die Übersetzung zu wiederholen, oder bitten Sie mich um eine andere Sprache oder ein anderes Wort."; break;
			case 75:
				outputString = "Etwas ist schiefgelaufen. Bitte versuche es erneut."; break;
			case 76:
				outputString = "Etwas ist schiefgelaufen. Bitte versuche es erneut."; break;
			case 77:
				outputString = "Sie haben weder ein zu übersetzendes Wort noch eine Sprache angefordert. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 78:
				outputString = "Sie können nach einem zu übersetzenden Wort oder Satz fragen."; break;
			case 79:
				outputString = "Sie haben kein zu übersetzendes Wort angefordert. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 80:
				outputString = "Sie können nach einem zu übersetzenden Wort oder Satz fragen."; break;
			case 81:
				outputString = "Sie haben keine Sprache angefordert. Welche Sprache möchten Sie übersetzen "; break;
			case 82:
				outputString = " im?"; break;
			case 83:
				outputString = "Sie haben um Übersetzung gebeten "; break;
			case 84:
				outputString = ". In welche Sprache möchten Sie das übersetzen?"; break;
			case 85:
				outputString = "Bei der Wiederholung Ihrer vorherigen Anfrage ist ein Fehler aufgetreten."; break;
			case 86:
				outputString = "Sie müssen mir ein Wort oder einen Satz und eine Sprache sagen, um Ihre Übersetzung zu wiederholen."; break;
			case 87:
				outputString = "Entschuldigung, ich kann Ihre Übersetzung im Moment nicht wiederholen."; break;
			case 88:
				outputString = "Sie müssen ein Wort oder einen Satz und eine Sprache für Ihre Übersetzung angeben."; break;
			case 89:
				outputString = "Sie brauchen anscheinend Hilfe. Sie können Ihre Alexa App besuchen, um Beispiele zu finden, was Sie mir sagen sollen. Wenn ich es nicht richtig verstanden habe, scheuen Sie sich nicht, mich noch einmal zu fragen. Bitten Sie mich einfach, ein Wort oder einen Satz zu übersetzen. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 90:
				outputString = "Bitten Sie mich einfach, ein Wort oder einen Satz zu übersetzen. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 91:
				outputString = "Mein Linguist hier um zu helfen!"; break;
			case 92:
				outputString = "Hier sind einige Beispiele dafür, was Sie mir sagen können: \n- 'Alexa, bitte meinen Linguisten, <Ihr Wort oder Ihren Satz hier> in <Ihre gewünschte Sprache> zu übersetzen' \n- 'Alexa, bitte meinen Linguisten, um zu übersetzen < Ihr Wort oder Ihr Satz hier> '\n-' Alexa, fordern Sie Mein Linguist auf, in <Ihre gewünschte Sprache> zu übersetzen. \nHinweis: Sie können nur einen Satz mit bis zu 15 Wörtern übersetzen Speichern, um alle unterstützten Sprachen anzuzeigen"; break;
			case 93:
				outputString = "Entschuldigung, ich kann Ihre Anfrage nicht bearbeiten. Bitten Sie um Hilfe, wenn Sie etwas brauchen."; break;
			case 94:
				outputString = "Bitten Sie mich einfach um Hilfe. Sagen Sie 'Hilfe'."; break;
			case 95:
				outputString = "im"; break;
			case 96:
				outputString = "ist"; break;
			case 97:
				outputString = "Bei Ihrer Übersetzung ist ein furchtbarer Fehler aufgetreten. Bitte versuche es erneut."; break;
			case 98:
				outputString = "Entschuldigung, ich kann Ihre Übersetzung nicht abspielen. Bitte besuchen Sie Ihre Alexa-App und werfen Sie einen Blick auf die Karte, auf der Sie Ihre Übersetzung sehen."; break;
			case 99:
				outputString = "Etwas ist schief gelaufen. Fragen Sie erneut nach einer Sprache, in die übersetzt werden soll. Sagen Sie 'übersetzen in', gefolgt von Ihrer gewünschten Sprache."; break;
			case 100:
				outputString = "Etwas ist schief gelaufen. Sie haben weder ein zu übersetzendes Wort noch eine Sprache angefordert. Bitte versuche es erneut."; break;
			case 101:
				outputString = "Etwas ist schief gelaufen. Bitten Sie erneut um ein Wort oder einen Satz, der übersetzt werden soll. Sagen Sie 'übersetzen', gefolgt von dem Wort oder dem Satz, den Sie übersetzen möchten."; break;
			case 102:
				outputString = "Entschuldigung, ich spreche diese Sprache nicht. Besuchen Sie Ihre Alexa-App und werfen Sie einen Blick auf die Karte, auf der Sie Ihre Übersetzung sehen. Sie können versuchen, eine andere Sprache auszusprechen, indem Sie 'Übersetzen in' gefolgt von Ihrer gewünschten Sprache sagen."; break;
			case 103:
				outputString = "Entschuldigung, ich unterstütze diese Sprache nicht. Bitte versuchen Sie es mit einer anderen Sprache erneut. Überprüfen Sie die Skill-Beschreibungsseite, um alle unterstützten Sprachen anzuzeigen."; break;
			case 104:
				outputString = "Entschuldigung, ich übersetze keine Obszönitäten."; break;
			case 105:
				outputString = "Beim Abrufen Ihres In-Skill-Produkts ist ein Fehler aufgetreten."; break;
			default:
				outputString = "Falscher Versatz.";
		}
		
		return outputString;
	}

	private static String it_StringsSwitch(int offset) {
		String outputString = "Formato offset non valido.";
		
		switch (offset) {
			case 1:
				outputString = "Benvenuto in Mio Linguista! Chiedimi solo di tradurre una parola o una frase. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 2:
				outputString = "Assicurati di andare all'app Alexa per qualsiasi istruzione se qualcosa va storto."; break;
			case 3: 
				outputString = "Il mio linguista: istruzioni"; break;
			case 4:
				outputString = "Benvenuto in Mio Linguista! Dimmi la parola o la frase che desideri tradurre e la lingua in cui richiedi di ascoltarla! \nInoltre, troverai alcune istruzioni: \nDì 'chiedi a Mio Linguista, di tradurre' seguito dalla tua parola o dalla tua frase. \nPer ripetere la traduzione, dire 'ripeti'. \nSe vuoi che smetta di tradurre, dì 'stop'. \nNota: puoi tradurre solo una frase di massimo 15 parole"; break;
			case 5:
				outputString = "Non hai richiesto una parola. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 6:
				outputString = "Puoi chiedere una parola o una frase da tradurre."; break;
			case 7:
				outputString = "Non hai richiesto una lingua. Quale lingua desideri tradurre "; break;
			case 8:
				outputString = " nel?"; break;
			case 9:
				outputString = "Hai richiesto la traduzione "; break;
			case 10:
				outputString = ". In quale lingua vorresti tradurre questo?"; break;
			case 11:
				outputString = "Qualcosa è andato storto al lancio."; break;
			case 12:
				outputString = "Ecco la tua traduzione!"; break;
			case 13:
				outputString = " Se desideri ascoltare di nuovo la traduzione, chiedimi di ripetere. Pronuncia 'ripeti'."; break;
			case 14:
				outputString = "Chiedimi solo di ripetere la traduzione, se lo desideri."; break;
			case 15:
				outputString = "Scusa, non parlo quella lingua; tuttavia, controlla l'app Alexa. Ti ho preparato un biglietto con la tua traduzione."; break;
			case 16:
				outputString = "Ecco la tua traduzione!"; break;
			case 17:
				outputString = "Spiacente, non supporto quella lingua. Riprova con un'altra lingua. Controlla la pagina di descrizione delle abilità per vedere tutte le lingue supportate."; break;
			case 18:
				outputString = "Non sono in grado di riprodurre la tua traduzione; tuttavia, controlla l'app Alexa. Ti ho preparato un biglietto con la tua traduzione."; break;
			case 19:
				outputString = "Ecco la tua traduzione!"; break;
			case 20:
				outputString = "Ecco la tua traduzione!"; break;
			case 21:
				outputString = "You have not provided a language for me to translate to. Please try again."; break;
			case 22:
				outputString = "You have not provided a word or a sentence for me to translate. Please try again."; break;
			case 23:
				outputString = "È successo qualcosa di sbagliato. Per favore, riprova."; break;
			case 24:
				outputString = "È successo qualcosa di sbagliato. Per favore, riprova."; break;
			case 25:
				outputString = "Mi dispiace, non l'ho capito. Per favore, riprova."; break;
			case 26:
				outputString = "Devi dirmi una parola o una frase e una lingua per la tua traduzione."; break;
			case 27:
				outputString = "Spiacenti, al momento non posso elaborare la tua traduzione."; break;
			case 28:
				outputString = "Quale lingua desideri tradurre "; break;
			case 29:
				outputString = " nel?"; break;
			case 30:
				outputString = "Hai richiesto la traduzione "; break;
			case 31:
				outputString = ". In quale lingua vorresti tradurre questo?"; break;
			case 32:
				outputString = "Ecco la tua traduzione!"; break;
			case 33:
				outputString = " Se desideri ascoltare di nuovo la traduzione, chiedimi di ripetere. Puoi anche chiedermi un'altra lingua o un'altra parola."; break;
			case 34:
				outputString = "Chiedimi di ripetere la traduzione o chiedimi un'altra lingua o un'altra parola."; break;
			case 35:
				outputString = "Ecco la tua traduzione!"; break;
			case 36:
				outputString = "Spiacente, non supporto quella lingua. Riprova con un'altra lingua. Controlla la pagina di descrizione delle abilità per vedere tutte le lingue supportate."; break;
			case 37:
				outputString = "Non sono in grado di riprodurre la tua traduzione; tuttavia, controlla l'app Alexa. Ti ho preparato un biglietto con la tua traduzione."; break;
			case 38:
				outputString = "Ecco la tua traduzione!"; break;
			case 39:
				outputString = "Ecco la tua traduzione!"; break;
			case 40:
				outputString = "È successo qualcosa di sbagliato. Per favore, riprova."; break;
			case 41:
				outputString = "Chiedi una parola o una frase da tradurre. Di 'tradurre' prima."; break;
			case 42:
				outputString = "Puoi chiedere una parola o una frase da tradurre."; break;
			case 43:
				outputString = "Mi dispiace, non l'ho capito. Chiedi una parola o una frase da tradurre. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 44:
				outputString = "Puoi chiedere una parola o una frase da tradurre."; break;
			case 45:
				outputString = "Devi dirmi una parola o una frase e una lingua per la tua traduzione."; break;
			case 46:
				outputString = "Spiacenti, al momento non posso elaborare la tua traduzione."; break;
			case 47:
				outputString = "Non riconosco questa lingua. Per favore dimmi una lingua valida. Se intendevi chiedere una parola o una frase, pronuncia prima 'tradurre'."; break;
			case 48:
				outputString = "Puoi chiedere una lingua per la tua traduzione. Pronuncia 'traduci in', seguito dalla lingua richiesta. Oppure dì 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 49:
				outputString = "Ecco la tua traduzione!"; break;
			case 50:
				outputString = " Se desideri ascoltare di nuovo la traduzione, chiedimi di ripetere. Puoi anche chiedermi un'altra lingua o un'altra parola."; break;
			case 51:
				outputString = "Chiedimi di ripetere la traduzione o chiedimi un'altra lingua o un'altra parola."; break;
			case 52:
				outputString = "Ecco la tua traduzione!"; break;
			case 53:
				outputString = "Spiacente, non supporto quella lingua. Riprova con un'altra lingua. Controlla la pagina di descrizione delle abilità per vedere tutte le lingue supportate."; break;
			case 54:
				outputString = "Non sono in grado di riprodurre la tua traduzione; tuttavia, controlla l'app Alexa. Ti ho preparato un biglietto con la tua traduzione."; break;
			case 55:
				outputString = "Ecco la tua traduzione!"; break;
			case 56:
				outputString = "Ecco la tua traduzione!"; break;
			case 57:
				outputString = "È successo qualcosa di sbagliato. Per favore, riprova."; break;
			case 58:
				outputString = "È successo qualcosa di sbagliato. Per favore, riprova."; break;
			case 59:
				outputString = "Non riconosco questa lingua. Per favore dimmi una lingua valida. Se intendevi chiedere una parola o una frase, pronuncia prima 'tradurre'."; break;
			case 60:
				outputString = "Puoi chiedere una lingua per la tua traduzione. Pronuncia 'traduci in', seguito dalla lingua richiesta. Oppure dì 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 61:
				outputString = "Chiedi una parola o una frase da tradurre. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 62:
				outputString = "Puoi chiedere una parola o una frase da tradurre."; break;
			case 63:
				outputString = "Se intendevi chiedere una parola o una frase, pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 64:
				outputString = "Puoi chiedere una parola o una frase da tradurre. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 65:
				outputString = "Quale lingua desideri tradurre "; break;
			case 66:
				outputString = " nel?"; break;
			case 67:
				outputString = "Hai richiesto la traduzione "; break;
			case 68:
				outputString = ". In quale lingua vorresti tradurre questo?"; break;
			case 69:
				outputString = "Mi dispiace, non l'ho capito. Richiedi una lingua valida in cui tradurre. Pronuncia 'traduci in', seguito dalla lingua richiesta."; break;
			case 70:
				outputString = "Puoi chiedere una lingua per la tua traduzione. Pronuncia 'traduci in', seguito dalla lingua richiesta."; break;
			case 71:
				outputString = "Devi dirmi una parola o una frase e una lingua per la tua traduzione."; break;
			case 72:
				outputString = "Spiacenti, al momento non posso elaborare la tua traduzione."; break;
			case 73:
				outputString = " Se desideri ascoltare di nuovo la traduzione, chiedimi di ripetere. Puoi anche chiedermi un'altra lingua o un'altra parola."; break;
			case 74:
				outputString = "Chiedimi di ripetere la traduzione o chiedimi un'altra lingua o un'altra parola."; break;
			case 75:
				outputString = "È successo qualcosa di sbagliato. Per favore, riprova."; break;
			case 76:
				outputString = "È successo qualcosa di sbagliato. Per favore, riprova."; break;
			case 77:
				outputString = "Non hai richiesto una parola da tradurre, né una lingua. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 78:
				outputString = "Puoi chiedere una parola o una frase da tradurre."; break;
			case 79:
				outputString = "Non hai richiesto una parola da tradurre. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 80:
				outputString = "Puoi chiedere una parola o una frase da tradurre."; break;
			case 81:
				outputString = "Non hai richiesto una lingua. Quale lingua desideri tradurre "; break;
			case 82:
				outputString = " nel?"; break;
			case 83:
				outputString = "Hai richiesto la traduzione "; break;
			case 84:
				outputString = ". In quale lingua vorresti tradurre questo?"; break;
			case 85:
				outputString = "Si è verificato un errore durante la ripetizione della richiesta precedente."; break;
			case 86:
				outputString = "Devi dirmi una parola o una frase e una lingua per ripetere la tua traduzione."; break;
			case 87:
				outputString = "Spiacenti, al momento non posso ripetere la tua traduzione."; break;
			case 88:
				outputString = "Devi fornire una parola o una frase e una lingua per la tua traduzione."; break;
			case 89:
				outputString = "Sembra che tu abbia bisogno di aiuto. Puoi visitare la tua app Alexa per qualsiasi esempio di cosa dirmi. Se non ho capito bene, non essere timido nel chiedermelo di nuovo. Chiedimi solo di tradurre una parola o una frase. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 90:
				outputString = "Chiedimi solo di tradurre una parola o una frase. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 91:
				outputString = "Il mio linguista qui per aiutarti!"; break;
			case 92:
				outputString = "Ecco alcuni esempi di ciò che puoi dirmi:\n- 'Alexa, chiedi a Mio Linguista di tradurre <la tua parola o la tua frase qui> in <la tua lingua richiesta>'\n- 'Alexa, chiedi a Mio Linguista di tradurre < la tua parola o la tua frase qui> '\n- 'Alexa, chiedi a Mio Linguista di tradurre nella <lingua richiesta> '\nNota: puoi tradurre solo una frase fino a 15 parole\nNota: visita la pagina di descrizione dell'abilità nell'abilità negozio per vedere tutte le lingue supportate"; break;
			case 93:
				outputString = "Spiacenti, non posso elaborare la tua richiesta. Chiedi aiuto se ti senti nel bisogno di alcuni."; break;
			case 94:
				outputString = "Chiedimi solo aiuto. Dì 'aiuto'."; break;
			case 95:
				outputString = "nel"; break;
			case 96:
				outputString = "è"; break;
			case 97:
				outputString = "Qualcosa è andato terribilmente storto nella tua traduzione. Per favore, riprova."; break;
			case 98:
				outputString = "Spiacenti, non riesco a riprodurre la tua traduzione. Visita la tua app Alexa e dai un'occhiata alla scheda in cui vedrai la tua traduzione."; break;
			case 99:
				outputString = "Qualcosa è andato storto. Richiedi di nuovo una lingua in cui tradurre. Pronuncia 'traduci in' seguito dalla lingua richiesta."; break;
			case 100:
				outputString = "Qualcosa è andato storto. Non hai richiesto una parola da tradurre, né una lingua. Per favore, riprova."; break;
			case 101:
				outputString = "Qualcosa è andato storto. Chiedi di nuovo una parola o una frase da tradurre. Pronuncia 'traduci' seguito dalla parola o dalla frase che desideri tradurre."; break;
			case 102:
				outputString = "Scusa, non parlo quella lingua. Visita la tua app Alexa e dai un'occhiata alla scheda in cui vedrai la tua traduzione. Puoi provare a dire un'altra lingua, dicendo 'traduci in', seguito dalla tua lingua richiesta."; break;
			case 103:
				outputString = "Spiacente, non supporto quella lingua. Riprova con un'altra lingua. Controlla la pagina di descrizione delle abilità per vedere tutte le lingue supportate."; break;
			case 104:
				outputString = "Mi dispiace, non traduco volgarità."; break;
			case 105:
				outputString = "Spiacenti, qualcosa è andato storto durante il recupero del prodotto in skill."; break;
			default:
				outputString = "Offset errato.";
		}
		
		return outputString;
	}

	//language code found in Translation class
	public static String getLanguageCodeBasedLocale(String language, String sESSION_LOCALE) {
		String lg = "";
		
		switch (sESSION_LOCALE.substring(0, 2)) {
			case "en":
				lg = en_LanguageCodes(language); break;
			case "fr":
				lg = fr_LanguageCodes(language); break;
			case "es":
				lg = es_LanguageCodes(language); break;
			case "de":
				lg = de_LanguageCodes(language); break;
			case "it":
				lg = it_LanguageCodes(language); break;
			default:
				lg =  "";
		}
		
		return lg;
	}

	private static String en_LanguageCodes(String language) {
		String lg = "";
		switch (language.toLowerCase()) {
			case "afrikaans": lg = "af"; break;
			case "arabic": lg = "ar"; break;
			case "bosnian": lg = "bs-latin"; break;
			case "bulgarian": lg = "bg"; break;
			case "catalan": lg = "ca"; break;
			case "chinese": lg = "zh-cn"; break;
			case "croatian": lg = "hr"; break;
			case "czech": lg = "cs"; break;
			case "danish": lg = "da"; break;
			case "dutch": lg = "nl"; break;
			case "english": lg = "en"; break;
			case "estonian": lg = "et"; break;
			case "finnish": lg = "fi"; break;
			case "french": lg = "fr"; break;
			case "german": lg = "de"; break;
			case "greek": lg = "el"; break;
			case "haitian": lg = "ht"; break;
			case "hebrew": lg = "he"; break;
			case "hindi": lg = "hi"; break;
			case "hmong daw": lg = "mww"; break;
			case "hungarian": lg = "hu"; break;
			case "indonesian": lg = "id"; break;
			case "italian": lg = "it"; break;
			case "japanese": lg = "ja"; break;
			case "kiswahili": lg = "sw"; break;
			case "klingon": lg = "tlh"; break;
			case "korean": lg = "ko"; break;
			case "latvian": lg = "lv"; break;
			case "lithuanian": lg = "lt"; break;
			case "malay": lg = "ms"; break;
			case "maltese": lg = "mt"; break;
			case "norwegian": lg = "no"; break;
			case "persian": lg = "fa"; break;
			case "polish": lg = "pl"; break;
			case "portuguese": lg = "pt"; break;
			case "queretaro otomi": lg = "otq"; break;
			case "romanian": lg = "ro"; break;
			case "russian": lg = "ru"; break;
			case "serbian": lg = "sr-Cyrl"; break;
			case "slovak": lg = "sk"; break;
			case "slovenian": lg = "sl"; break;
			case "spanish": lg = "es"; break;
			case "swedish": lg = "sv"; break;
			case "thai": lg = "th"; break;
			case "turkish": lg = "tr"; break;
			case "ukrainian": lg = "uk"; break;
			case "urdu": lg = "ur"; break;
			case "vietnamese": lg = "vi"; break;
			case "welsh": lg = "cy"; break;
			case "yucatec maya": lg = "yua"; break;
				
			default: lg = "";
		}
		
		return lg;
	}

	private static String fr_LanguageCodes(String language) {
		String lg = "";
		switch (language.toLowerCase()) {
			case "afrikaans": lg = "af"; break;
			case "arabe": lg = "ar"; break;
			case "bosniaque": lg = "bs-latin"; break;
			case "bulgare": lg = "bg"; break;
			case "catalan": lg = "ca"; break;
			case "chinois": lg = "zh-cn"; break;
			case "croate": lg = "hr"; break;
			case "tchèque": lg = "cs"; break;
			case "danois": lg = "da"; break;
			case "néerlandais": lg = "nl"; break;
			case "anglais": lg = "en"; break;
			case "estonien": lg = "et"; break;
			case "finlandais": lg = "fi"; break;
			case "français": lg = "fr"; break;
			case "allemand": lg = "de"; break;
			case "grec": lg = "el"; break;
			case "haïtien": lg = "ht"; break;
			case "hébreu": lg = "he"; break;
			case "hindi": lg = "hi"; break;
			case "hmong daw": lg = "mww"; break;
			case "hongrois": lg = "hu"; break;
			case "indonésien": lg = "id"; break;
			case "italien": lg = "it"; break;
			case "japonais": lg = "ja"; break;
			case "kiswahili": lg = "sw"; break;
			case "klingon": lg = "tlh"; break;
			case "coréen": lg = "ko"; break;
			case "letton": lg = "lv"; break;
			case "lituanien": lg = "lt"; break;
			case "malais": lg = "ms"; break;
			case "maltais": lg = "mt"; break;
			case "norvégien": lg = "no"; break;
			case "persan": lg = "fa"; break;
			case "polonais": lg = "pl"; break;
			case "portugais": lg = "pt"; break;
			case "queretaro otomi": lg = "otq"; break;
			case "roumain": lg = "ro"; break;
			case "russe": lg = "ru"; break;
			case "serbe": lg = "sr-Cyrl"; break;
			case "slovaque": lg = "sk"; break;
			case "slovène": lg = "sl"; break;
			case "espagnol": lg = "es"; break;
			case "suédois": lg = "sv"; break;
			case "thaïlandais": lg = "th"; break;
			case "turc": lg = "tr"; break;
			case "ukrainien": lg = "uk"; break;
			case "ourdou": lg = "ur"; break;
			case "vietnamien": lg = "vi"; break;
			case "gallois": lg = "cy"; break;
			case "yucatec maya": lg = "yua"; break;
				
			default: lg = "";
		}
		
		return lg;
	}

	private static String es_LanguageCodes(String language) {
		String lg = "";
		switch (language.toLowerCase()) {
			case "africaans": lg = "af"; break;
			case "arábica": lg = "ar"; break;
			case "bosnio": lg = "bs-latin"; break;
			case "búlgaro": lg = "bg"; break;
			case "catalán": lg = "ca"; break;
			case "chino": lg = "zh-cn"; break;
			case "croata": lg = "hr"; break;
			case "checo": lg = "cs"; break;
			case "danés": lg = "da"; break;
			case "holandés": lg = "nl"; break;
			case "inglés": lg = "en"; break;
			case "estonio": lg = "et"; break;
			case "finlandés": lg = "fi"; break;
			case "francés": lg = "fr"; break;
			case "alemán": lg = "de"; break;
			case "griego": lg = "el"; break;
			case "haitiano": lg = "ht"; break;
			case "hebreo": lg = "he"; break;
			case "hindi": lg = "hi"; break;
			case "hmong daw": lg = "mww"; break;
			case "húngaro": lg = "hu"; break;
			case "indonesio": lg = "id"; break;
			case "italiano": lg = "it"; break;
			case "japonés": lg = "ja"; break;
			case "kiswahili": lg = "sw"; break;
			case "klingon": lg = "tlh"; break;
			case "coreano": lg = "ko"; break;
			case "letón": lg = "lv"; break;
			case "lituano": lg = "lt"; break;
			case "malayo": lg = "ms"; break;
			case "maltés": lg = "mt"; break;
			case "noruego": lg = "no"; break;
			case "persa": lg = "fa"; break;
			case "polaco": lg = "pl"; break;
			case "queretaro otomi": lg = "otq"; break;
			case "rumano": lg = "ro"; break;
			case "ruso": lg = "ru"; break;
			case "serbio": lg = "sr-Cyrl"; break;
			case "eslovaco": lg = "sk"; break;
			case "esloveno": lg = "sl"; break;
			case "español": lg = "es"; break;
			case "sueco": lg = "sv"; break;
			case "tailandés": lg = "th"; break;
			case "turco": lg = "tr"; break;
			case "ucranio": lg = "uk"; break;
			case "urdu": lg = "ur"; break;
			case "vietnamita": lg = "vi"; break;
			case "galés": lg = "cy"; break;
			case "maya yucateco": lg = "yua"; break;
				
			default: lg = "";
		}
		
		return lg;
	}

	private static String de_LanguageCodes(String language) {
		String lg = "";
		switch (language.toLowerCase()) {
			case "afrikaans": lg = "af"; break;
			case "arabisch": lg = "ar"; break;
			case "bosnisch": lg = "bs-latin"; break;
			case "bulgarisch": lg = "bg"; break;
			case "katalanisch": lg = "ca"; break;
			case "chinesisch": lg = "zh-cn"; break;
			case "kroatisch": lg = "hr"; break;
			case "tschechisch": lg = "cs"; break;
			case "dänisch": lg = "da"; break;
			case "niederländisch": lg = "nl"; break;
			case "englisch": lg = "en"; break;
			case "estnisch": lg = "et"; break;
			case "finnisch": lg = "fi"; break;
			case "französisch": lg = "fr"; break;
			case "deutsche": lg = "de"; break;
			case "griechisch": lg = "el"; break;
			case "haitianisch": lg = "ht"; break;
			case "hebräisch": lg = "he"; break;
			case "hindi": lg = "hi"; break;
			case "hmong daw": lg = "mww"; break;
			case "ungarisch": lg = "hu"; break;
			case "indonesisch": lg = "id"; break;
			case "italienisch": lg = "it"; break;
			case "japanisch": lg = "ja"; break;
			case "kiswahili": lg = "sw"; break;
			case "klingonisch": lg = "tlh"; break;
			case "koreanisch": lg = "ko"; break;
			case "lettisch": lg = "lv"; break;
			case "litauisch": lg = "lt"; break;
			case "malaiisch": lg = "ms"; break;
			case "maltesisch": lg = "mt"; break;
			case "norwegisch": lg = "no"; break;
			case "persisch": lg = "fa"; break;
			case "polieren": lg = "pl"; break;
			case "portugiesisch": lg = "pt"; break;
			case "queretaro otomi": lg = "otq"; break;
			case "rumänisch": lg = "ro"; break;
			case "russisch": lg = "ru"; break;
			case "serbisch": lg = "sr-cyrl"; break;
			case "slowakisch": lg = "sk"; break;
			case "slowenisch": lg = "sl"; break;
			case "spanisch": lg = "es"; break;
			case "schwedisch": lg = "sv"; break;
			case "thai": lg = "th"; break;
			case "türkisch": lg = "tr"; break;
			case "ukrainisch": lg = "uk"; break;
			case "urdu": lg = "ur"; break;
			case "vietnamesisch": lg = "vi"; break;
			case "walisisch": lg = "cy"; break;
			case "yucatec maya": lg = "yua"; break;
				
			default: lg = "";
		}
		
		return lg;
	}

	private static String it_LanguageCodes(String language) {
		String lg = "";
		switch (language.toLowerCase()) {
			case "afrikaans": lg = "af"; break;
			case "arabo": lg = "ar"; break;
			case "bosniaco": lg = "bs-latin"; break;
			case "bulgaro": lg = "bg"; break;
			case "catalano": lg = "ca"; break;
			case "cinese": lg = "zh-cn"; break;
			case "croato": lg = "hr"; break;
			//TODO
			case "czech": lg = "cs"; break;
			case "danish": lg = "da"; break;
			case "dutch": lg = "nl"; break;
			case "english": lg = "en"; break;
			case "estonian": lg = "et"; break;
			case "finnish": lg = "fi"; break;
			case "french": lg = "fr"; break;
			case "german": lg = "de"; break;
			case "greek": lg = "el"; break;
			case "haitian": lg = "ht"; break;
			case "hebrew": lg = "he"; break;
			case "hindi": lg = "hi"; break;
			case "hmong daw": lg = "mww"; break;
			case "hungarian": lg = "hu"; break;
			case "indonesian": lg = "id"; break;
			case "italian": lg = "it"; break;
			case "japanese": lg = "ja"; break;
			case "kiswahili": lg = "sw"; break;
			case "klingon": lg = "tlh"; break;
			case "korean": lg = "ko"; break;
			case "latvian": lg = "lv"; break;
			case "lithuanian": lg = "lt"; break;
			case "malay": lg = "ms"; break;
			case "maltese": lg = "mt"; break;
			case "norwegian": lg = "no"; break;
			case "persian": lg = "fa"; break;
			case "polish": lg = "pl"; break;
			case "portuguese": lg = "pt"; break;
			case "queretaro otomi": lg = "otq"; break;
			case "romanian": lg = "ro"; break;
			case "russian": lg = "ru"; break;
			case "serbian": lg = "sr-Cyrl"; break;
			case "slovak": lg = "sk"; break;
			case "slovenian": lg = "sl"; break;
			case "spanish": lg = "es"; break;
			case "swedish": lg = "sv"; break;
			case "thai": lg = "th"; break;
			case "turkish": lg = "tr"; break;
			case "ukrainian": lg = "uk"; break;
			case "urdu": lg = "ur"; break;
			case "vietnamese": lg = "vi"; break;
			case "welsh": lg = "cy"; break;
			case "yucatec maya": lg = "yua"; break;
				
			default: lg = "";
		}
		
		return lg;
	}

	public static Boolean IsSupportedUniversalLanguageBasedLocale(String language, String sESSION_LOCALE) {
		boolean bool = false;
		
		switch (sESSION_LOCALE.substring(0, 2)) {
			case "en":
				bool = en_SupportedUniversalLanguage(language); break;
			case "fr":
				bool = fr_SupportedUniversalLanguage(language); break;
			case "es":
				bool = es_SupportedUniversalLanguage(language); break;
			case "de":
				bool = de_SupportedUniversalLanguage(language); break;
			default:
				bool = false;
		}
		
		return bool;
	}

	private static boolean en_SupportedUniversalLanguage(String language) {
		switch (language.toLowerCase()) {
			case "afrikaans": break;
			case "albanian": break;
			case "amharic": break;
			case "arabic": break;
			case "arabic punjabi": break;
			case "armenian": break;
			case "assamese": break;
			case "azerbaijani": break;
			case "bangla": break;
			case "basque": break;
			case "belarusian": break;
			case "bosnian": break;
			case "brazilian portuguese": break;
			case "bulgarian": break;
			case "catalan": break;
			case "central kurdish": break;
			case "cherokee": break;
			case "chinese": break;
			case "croatian": break;
			case "czech": break;
			case "danish": break;
			case "dari": break;
			case "dutch": break;
			case "english": break;
			case "estonian": break;
			case "filipino": break;
			case "finnish": break;
			case "french": break;
			case "galician": break;
			case "georgian": break;
			case "german": break;
			case "greek": break;
			case "gujarati": break;
			case "haitian": break;
			case "hausa": break;
			case "hebrew": break;
			case "hindi": break;
			case "hmong daw": break;
			case "hungarian": break;
			case "icelandic": break;
			case "igbo": break;
			case "indonesian": break;
			case "irish": break;
			case "isixhosa": break;
			case "isizulu": break;
			case "italian": break;
			case "japanese": break;
			case "kannada": break;
			case "kazakh": break;
			case "khmer": break;
			case "kiche": break;
			case "kinyarwanda": break;
			case "kiswahili": break;
			case "klingon": break;
			case "konkani": break;
			case "korean": break;
			case "kurdish": break;
			case "kyrgyz": break;
			case "latvian": break;
			case "lithuanian": break;
			case "luxembourgish": break;
			case "macedonian": break;
			case "malay": break;
			case "malayalam": break;
			case "maltese": break;
			case "maori": break;
			case "marathi": break;
			case "mongolian": break;
			case "mongolian cyrillic": break;
			case "nepali": break;
			case "norwegian": break;
			case "odia": break;
			case "persian": break;
			case "polish": break;
			case "portuguese": break;
			case "punjabi": break;
			case "quechua": break;
			case "queretaro otomi": break;
			case "romanian": break;
			case "russian": break;
			case "scottish": break;
			case "scottish gaelic": break;
			case "serbian": break;
			case "sesotho": break;
			case "setswana": break;
			case "sindhi": break;
			case "sinhala": break;
			case "slovak": break;
			case "slovenian": break;
			case "spanish": break;
			case "swedish": break;
			case "tajik": break;
			case "tajik cyrillic": break;
			case "tamil": break;
			case "tatar": break;
			case "telugu": break;
			case "thai": break;
			case "tigrinya": break;
			case "turkish": break;
			case "turkmen": break;
			case "ukrainian": break;
			case "urdu": break;
			case "uyghur": break;
			case "uzbek": break;
			case "valencian": break;
			case "vietnamese": break;
			case "welsh": break;
			case "wolof": break;
			case "yoruba": break;
			case "yucatec maya": break;
			
			default: return false;
		}
		
		return true;
	}

	private static boolean fr_SupportedUniversalLanguage(String language) {
		switch (language.toLowerCase()) {
			case "afrikaans": break;
			case "albanais": break;
			case "amharique": break;
			case "arabe": break;
			case "punjabi arabe": break;
			case "arménien": break;
			case "assamais": break;
			case "azerbaïdjanais": break;
			case "bangla": break;
			case "basque": break;
			case "biélorusse": break;
			case "bosniaque": break;
			case "portugais brésilien": break;
			case "bulgare": break;
			case "catalan": break;
			case "kurde centrale": break;
			case "cherokee": break;
			case "chinois": break;
			case "croate": break;
			case "tchèque": break;
			case "danois": break;
			case "dari": break;
			case "néerlandais": break;
			case "anglais": break;
			case "estonien": break;
			case "philippin": break;
			case "finlandais": break;
			case "français": break;
			case "galicien": break;
			case "géorgien": break;
			case "allemand": break;
			case "grec": break;
			case "gujarati": break;
			case "haïtien": break;
			case "hausa": break;
			case "hébreu": break;
			case "hindi": break;
			case "hmong daw": break;
			case "hongrois": break;
			case "islandais": break;
			case "igbo": break;
			case "indonésien": break;
			case "irlandais": break;
			case "isixhosa": break;
			case "isizulu": break;
			case "italien": break;
			case "japonais": break;
			case "kannada": break;
			case "kazakh": break;
			case "khmer": break;
			case "kiche": break;
			case "kinyarwanda": break;
			case "kiswahili": break;
			case "klingon": break;
			case "konkani": break;
			case "coréen": break;
			case "kurde": break;
			case "kirghize": break;
			case "letton": break;
			case "lituanien": break;
			case "luxembourgeois": break;
			case "macédonien": break;
			case "malais": break;
			case "malayalam": break;
			case "maltais": break;
			case "maori": break;
			case "marathi": break;
			case "mongol": break;
			case "mongol cyrillique": break;
			case "népalais": break;
			case "norvégien": break;
			case "odia": break;
			case "persan": break;
			case "polonais": break;
			case "portugais": break;
			case "punjabi": break;
			case "quechua": break;
			case "queretaro otomi": break;
			case "roumain": break;
			case "russe": break;
			case "écossais": break;
			case "écossais gaélique": break;
			case "serbe": break;
			case "sesotho": break;
			case "setswana": break;
			case "sindhi": break;
			case "sinhala": break;
			case "slovaque": break;
			case "slovène": break;
			case "espagnol": break;
			case "suédois": break;
			case "tadjik": break;
			case "tadjik cyrillique": break;
			case "tamil": break;
			case "tatar": break;
			case "telugu": break;
			case "thaïlandais": break;
			case "tigrinya": break;
			case "turc": break;
			case "turkmène": break;
			case "ukrainien": break;
			case "ourdou": break;
			case "ouïghour": break;
			case "ouzbek": break;
			case "valencien": break;
			case "vietnamien": break;
			case "gallois": break;
			case "wolof": break;
			case "yoruba": break;
			case "yucatec maya": break;
			
			default: return false;
		}
		
		return true;
	}

	private static boolean es_SupportedUniversalLanguage(String language) {
		switch (language.toLowerCase()) {
			case "africaans": break;
			case "albanés": break;
			case "amárico": break;
			case "arábica": break;
			case "punjabi árabe": break;
			case "armenio": break;
			case "asalto": break;
			case "azerbaiyano": break;
			case "bangla": break;
			case "vasco": break;
			case "bielorruso": break;
			case "bosnio": break;
			case "portugués brasileño": break;
			case "búlgaro": break;
			case "catalán": break;
			case "kurdo central": break;
			case "cherokee": break;
			case "chino": break;
			case "croata": break;
			case "checo": break;
			case "danés": break;
			case "dari": break;
			case "holandés": break;
			case "inglés": break;
			case "estonio": break;
			case "filipino": break;
			case "finlandés": break;
			case "francés": break;
			case "gallego": break;
			case "georgiano": break;
			case "alemán": break;
			case "griego": break;
			case "gujarati": break;
			case "haitiano": break;
			case "hausa": break;
			case "hebreo": break;
			case "hindi": break;
			case "hmong daw": break;
			case "húngaro": break;
			case "islandés": break;
			case "igbo": break;
			case "indonesio": break;
			case "irlandés": break;
			case "isixhosa": break;
			case "isizulu": break;
			case "italiano": break;
			case "japonés": break;
			case "kannada": break;
			case "kazakh": break;
			case "khmer": break;
			case "kiche": break;
			case "kinyarwanda": break;
			case "kiswahili": break;
			case "klingon": break;
			case "konkani": break;
			case "coreano": break;
			case "kurdo": break;
			case "kirguís": break;
			case "letón": break;
			case "lituano": break;
			case "luxemburgués": break;
			case "macedónio": break;
			case "malayo": break;
			case "malayalam": break;
			case "maltés": break;
			case "maorí": break;
			case "marathi": break;
			case "mongol": break;
			case "cirílico mongol": break;
			case "nepalí": break;
			case "noruego": break;
			case "odia": break;
			case "persa": break;
			case "polaco": break;
			case "punjabi": break;
			case "quechua": break;
			case "queretaro otomi": break;
			case "rumano": break;
			case "ruso": break;
			case "escocés": break;
			case "gaélico escocés": break;
			case "serbio": break;
			case "sesotho": break;
			case "setswana": break;
			case "sindhi": break;
			case "cingalés": break;
			case "eslovaco": break;
			case "esloveno": break;
			case "español": break;
			case "sueco": break;
			case "tayiko": break;
			case "cirílico tayiko": break;
			case "tamil": break;
			case "tártaro": break;
			case "telugu": break;
			case "tailandés": break;
			case "tigrinya": break;
			case "turco": break;
			case "turkmen": break;
			case "ucranio": break;
			case "urdu": break;
			case "uigur": break;
			case "uzbeko": break;
			case "valenciano": break;
			case "vietnamita": break;
			case "galés": break;
			case "lobo": break;
			case "yoruba": break;
			case "maya yucateco": break;
			
			default: return false;
		}
		
		return true;
	}

	private static boolean de_SupportedUniversalLanguage(String language) {
		switch (language.toLowerCase()) {
			case "afrikaans": break;
			case "albanisch": break;
			case "amharisch": break;
			case "arabisch": break;
			case "arabischer punjabi": break;
			case "armenisch": break;
			case "assamisch": break;
			case "aserbaidschanisch": break;
			case "bangla": break;
			case "baskisch": break;
			case "belarussisch": break;
			case "bosnisch": break;
			case "brasilianisches portugiesisch": break;
			case "bulgarisch": break;
			case "katalanisch": break;
			case "zentral kurdisch": break;
			case "cherokee": break;
			case "chinesisch": break;
			case "kroatisch": break;
			case "tschechisch": break;
			case "dänisch": break;
			case "dari": break;
			case "niederländisch": break;
			case "englisch": break;
			case "estnisch": break;
			case "philippinisch": break;
			case "finnisch": break;
			case "französisch": break;
			case "galizisch": break;
			case "georgisch": break;
			case "deutsche": break;
			case "griechisch": break;
			case "gujarati": break;
			case "haitianisch": break;
			case "hausa": break;
			case "hebräisch": break;
			case "hindi": break;
			case "hmong daw": break;
			case "ungarisch": break;
			case "isländisch": break;
			case "igbo": break;
			case "indonesisch": break;
			case "irisch": break;
			case "isixhosa": break;
			case "isizulu": break;
			case "italienisch": break;
			case "japanisch": break;
			case "kannada": break;
			case "kasachisch": break;
			case "khmer": break;
			case "kiche": break;
			case "kinyarwanda": break;
			case "kiswahili": break;
			case "klingonisch": break;
			case "konkani": break;
			case "koreanisch": break;
			case "kurdish": break;
			case "kirgisisch": break;
			case "lettisch": break;
			case "litauisch": break;
			case "luxemburgisch": break;
			case "mazedonisch": break;
			case "malaiisch": break;
			case "malayalam": break;
			case "maltesisch": break;
			case "maori": break;
			case "marathi": break;
			case "mongolisch": break;
			case "mongolisch kyrillisch": break;
			case "nepali": break;
			case "norwegisch": break;
			case "odia": break;
			case "persisch": break;
			case "polieren": break;
			case "portugiesisch": break;
			case "punjabi": break;
			case "quechua": break;
			case "queretaro otomi": break;
			case "rumänisch": break;
			case "russisch": break;
			case "schottisch": break;
			case "schottisch gälisch": break;
			case "serbisch": break;
			case "sesotho": break;
			case "setswana": break;
			case "sindhi": break;
			case "singhalesisch": break;
			case "slowakisch": break;
			case "slowenisch": break;
			case "spanisch": break;
			case "schwedisch": break;
			case "tadschikisch": break;
			case "tadschikisch kyrillisch": break;
			case "tamil": break;
			case "tatar": break;
			case "telugu": break;
			case "thai": break;
			case "tigrinya": break;
			case "türkisch": break;
			case "türken": break;
			case "ukrainisch": break;
			case "urdu": break;
			case "uigurisch": break;
			case "usbekisch": break;
			case "valencia": break;
			case "vietnamesisch": break;
			case "walisisch": break;
			case "wolof": break;
			case "yoruba": break;
			case "yucatec maya": break;
			
			default: return false;
		}
		
		return true;
	}

	public static Boolean IsSupportedAudioLanguageBasedLocale(String language, String sESSION_LOCALE) {
		boolean bool = false;
		
		switch (sESSION_LOCALE.substring(0, 2)) {
			case "en":
				bool = en_SupportedAudioLanguage(language); break;
			case "fr":
				bool = fr_SupportedAudioLanguage(language); break;
			case "es":
				bool = es_SupportedAudioLanguage(language); break;
			case "de":
				bool = de_SupportedAudioLanguage(language); break;
			default:
				bool = false;
		}
		
		return bool;
	}

	private static boolean en_SupportedAudioLanguage(String language) {
		switch (language.toLowerCase()) {
			case "arabic": break;
			case "catalan": break;
			case "chinese": break;
			case "danish": break;
			case "dutch": break;
			case "english": break;
			case "finnish": break;
			case "french": break;
			case "german": break;
			case "hindi": break;
			case "italian": break;
			case "japanese": break;
			case "korean": break;
			case "norwegian": break;
			case "polish": break;
			case "portuguese": break;
			case "russian": break;
			case "spanish": break;
			case "swedish": break;
			
			default: return false;
		}
		
		return true;
	}

	private static boolean fr_SupportedAudioLanguage(String language) {
		switch (language.toLowerCase()) {
			case "arabe": break;
			case "catalan": break;
			case "chinois": break;
			case "danois": break;
			case "néerlandais": break;
			case "anglais": break;
			case "finlandais": break;
			case "français": break;
			case "allemand": break;
			case "hindi": break;
			case "italien": break;
			case "japonais": break;
			case "coréen": break;
			case "norvégien": break;
			case "polonais": break;
			case "portugais": break;
			case "russe": break;
			case "espagnol": break;
			case "suédois": break;
			
			default: return false;
		}
		
		return true;
	}

	private static boolean es_SupportedAudioLanguage(String language) {
		switch (language.toLowerCase()) {
			case "arábica": break;
			case "catalán": break;
			case "chino": break;
			case "danés": break;
			case "holandés": break;
			case "inglés": break;
			case "finlandés": break;
			case "francés": break;
			case "alemán": break;
			case "hindi": break;
			case "italiano": break;
			case "japonés": break;
			case "coreano": break;
			case "noruego": break;
			case "polaco": break;
			case "ruso": break;
			case "español": break;
			case "sueco": break;
			
			default: return false;
		}
		
		return true;
	}

	private static boolean de_SupportedAudioLanguage(String language) {
		switch (language.toLowerCase()) {
			case "arabisch": break;
			case "katalanisch": break;
			case "chinesisch": break;
			case "dänisch": break;
			case "niederländisch": break;
			case "englisch": break;
			case "finnisch": break;
			case "französisch": break;
			case "deutsche": break;
			case "hindi": break;
			case "italienisch": break;
			case "japanisch": break;
			case "koreanisch": break;
			case "norwegisch": break;
			case "polieren": break;
			case "portugiesisch": break;
			case "russisch": break;
			case "spanisch": break;
			case "schwedisch": break;
			
			default: return false;
		}
		
		return true;
	}
	
	public static Boolean IsSupportedCardLanguageBasedLocale(String language, String sESSION_LOCALE) {
		boolean bool = false;
		
		switch (sESSION_LOCALE.substring(0, 2)) {
			case "en":
				bool = en_SupportedCardLanguage(language); break;
			case "fr":
				bool = fr_SupportedCardLanguage(language); break;
			case "es":
				bool = es_SupportedCardLanguage(language); break;
			case "de":
				bool = de_SupportedCardLanguage(language); break;
			default:
				bool = false;
		}
		
		return bool;
	}

	private static boolean en_SupportedCardLanguage(String language) {
		switch (language.toLowerCase()) {
			case "afrikaans": break;
			case "arabic": break;
			case "bosnian": break;
			case "bulgarian": break;
			case "catalan": break;
			case "chinese": break;
			case "croatian": break;
			case "czech": break;
			case "danish": break;
			case "dutch": break;
			case "english": break;
			case "estonian": break;
			case "finnish": break;
			case "french": break;
			case "german": break;
			case "greek": break;
			case "haitian": break;
			case "hebrew": break;
			case "hindi": break;
			case "hmong daw": break;
			case "hungarian": break;
			case "indonesian": break;
			case "italian": break;
			case "japanese": break;
			case "kiswahili": break;
			case "klingon": break;
			case "korean": break;
			case "latvian": break;
			case "lithuanian": break;
			case "malay": break;
			case "maltese": break;
			case "norwegian": break;
			case "persian": break;
			case "polish": break;
			case "portuguese": break;
			case "queretaro otomi": break;
			case "romanian": break;
			case "russian": break;
			case "serbian": break;
			case "slovak": break;
			case "slovenian": break;
			case "spanish": break;
			case "swedish": break;
			case "thai": break;
			case "turkish": break;
			case "ukrainian": break;
			case "urdu": break;
			case "vietnamese": break;
			case "welsh": break;
			case "yucatec maya": break;
				
			default: return false;
		}
		
		return true;
	}

	private static boolean fr_SupportedCardLanguage(String language) {
		switch (language.toLowerCase()) {
			case "afrikaans": break;
			case "arabe": break;
			case "bosniaque": break;
			case "bulgare": break;
			case "catalan": break;
			case "chinois": break;
			case "croate": break;
			case "tchèque": break;
			case "danois": break;
			case "néerlandais": break;
			case "anglais": break;
			case "estonien": break;
			case "finlandais": break;
			case "français": break;
			case "allemand": break;
			case "grec": break;
			case "haïtien": break;
			case "hébreu": break;
			case "hindi": break;
			case "hmong daw": break;
			case "hongrois": break;
			case "indonésien": break;
			case "italien": break;
			case "japonais": break;
			case "kiswahili": break;
			case "klingon": break;
			case "coréen": break;
			case "letton": break;
			case "lituanien": break;
			case "malais": break;
			case "maltais": break;
			case "norvégien": break;
			case "persan": break;
			case "polonais": break;
			case "portugais": break;
			case "queretaro otomi": break;
			case "roumain": break;
			case "russe": break;
			case "serbe": break;
			case "slovaque": break;
			case "slovène": break;
			case "espagnol": break;
			case "suédois": break;
			case "thaïlandais": break;
			case "turc": break;
			case "ukrainien": break;
			case "ourdou": break;
			case "vietnamien": break;
			case "gallois": break;
			case "yucatec maya": break;
				
			default: return false;
		}
		
		return true;
	}

	private static boolean es_SupportedCardLanguage(String language) {
		switch (language.toLowerCase()) {
			case "africaans": break;
			case "arábica": break;
			case "bosnio": break;
			case "búlgaro": break;
			case "catalán": break;
			case "chino": break;
			case "croata": break;
			case "checo": break;
			case "danés": break;
			case "holandés": break;
			case "inglés": break;
			case "estonio": break;
			case "finlandés": break;
			case "francés": break;
			case "alemán": break;
			case "griego": break;
			case "haitiano": break;
			case "hebreo": break;
			case "hindi": break;
			case "hmong daw": break;
			case "húngaro": break;
			case "indonesio": break;
			case "italiano": break;
			case "japonés": break;
			case "kiswahili": break;
			case "klingon": break;
			case "coreano": break;
			case "letón": break;
			case "lituano": break;
			case "malayo": break;
			case "maltés": break;
			case "noruego": break;
			case "persa": break;
			case "polaco": break;
			case "queretaro otomi": break;
			case "rumano": break;
			case "ruso": break;
			case "serbio": break;
			case "eslovaco": break;
			case "esloveno": break;
			case "español": break;
			case "sueco": break;
			case "tailandés": break;
			case "turco": break;
			case "ucranio": break;
			case "urdu": break;
			case "vietnamita": break;
			case "galés": break;
			case "maya yucateco": break;
				
			default: return false;
		}
		
		return true;
	}

	private static boolean de_SupportedCardLanguage(String language) {
		switch (language.toLowerCase()) {
			case "afrikaans": break;
			case "arabisch": break;
			case "bosnisch": break;
			case "bulgarisch": break;
			case "katalanisch": break;
			case "chinesisch": break;
			case "kroatisch": break;
			case "tschechisch": break;
			case "dänisch": break;
			case "niederländisch": break;
			case "englisch": break;
			case "estnisch": break;
			case "finnisch": break;
			case "französisch": break;
			case "deutsche": break;
			case "griechisch": break;
			case "haitianisch": break;
			case "hebräisch": break;
			case "hindi": break;
			case "hmong daw": break;
			case "ungarisch": break;
			case "indonesisch": break;
			case "italienisch": break;
			case "japanisch": break;
			case "kiswahili": break;
			case "klingonisch": break;
			case "koreanisch": break;
			case "lettisch": break;
			case "litauisch": break;
			case "malaiisch": break;
			case "maltesisch": break;
			case "norwegisch": break;
			case "persisch": break;
			case "polieren": break;
			case "portugiesisch": break;
			case "queretaro otomi": break;
			case "rumänisch": break;
			case "russisch": break;
			case "serbisch": break;
			case "slowakisch": break;
			case "slowenisch": break;
			case "spanisch": break;
			case "schwedisch": break;
			case "thai": break;
			case "türkisch": break;
			case "ukrainisch": break;
			case "urdu": break;
			case "vietnamesisch": break;
			case "walisisch": break;
			case "yucatec maya": break;
				
			default: return false;
		}
		
		return true;
	}

}
