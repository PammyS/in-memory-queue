package exceptions;

public class SubscriberAlreadyRegisteredForTopicException extends RuntimeException {
    public SubscriberAlreadyRegisteredForTopicException(Long subId, Long topicId) {
        super("Subscriber Already registered for Topic ID: " + topicId + " Subscriber Id: " + subId);
    }
}
