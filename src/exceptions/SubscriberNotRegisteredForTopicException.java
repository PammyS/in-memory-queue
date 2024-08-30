package exceptions;

public class SubscriberNotRegisteredForTopicException extends RuntimeException {
    public SubscriberNotRegisteredForTopicException(Long subId, Long topicId) {
        super("Subscriber Already registered for Topic ID: " + topicId + " Subscriber Id: " + subId);
    }
}
