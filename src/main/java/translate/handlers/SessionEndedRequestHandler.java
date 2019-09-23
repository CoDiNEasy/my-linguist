package translate.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Session;
import com.amazon.ask.model.SessionEndedRequest;

import translate.TranslationStreamHandler;

/*terminate skill
 *objects are cleaned up
 */
public class SessionEndedRequestHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(SessionEndedRequest.class));
    }
	
	public Optional<Response> handle(HandlerInput input) {
		TranslationStreamHandler.SESSION_LOCALE = input.getRequestEnvelope().getRequest().getLocale();
		
		Request request = input.getRequestEnvelope().getRequest();
		Session session = input.getRequestEnvelope().getSession();
		
		AttributesManager attributesManager = input.getAttributesManager();
        Map<String,Object> attributes = attributesManager.getSessionAttributes();
		
		System.out.println("SessionEndedRequestHandler requestId={}, sessionId={}: " + request.getRequestId() + ", " + session.getSessionId());
		attributes.put("SESSION_STAGE", String.valueOf("SessionEndedRequestHandler"));
		attributesManager.setSessionAttributes(attributes);
		
		System.out.println("session: SessionEndedRequestHandler");
		
        return input.getResponseBuilder()
        		.build();
    }
	
}
