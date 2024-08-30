package exceptions;

public class SubscriberNotRegisteredException extends RuntimeException {
    public SubscriberNotRegisteredException(Long subId) {
        super("Subscriber is not registered Subscriber Id: " + subId);
    }
}
