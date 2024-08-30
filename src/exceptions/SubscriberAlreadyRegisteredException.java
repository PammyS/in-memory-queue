package exceptions;

public class SubscriberAlreadyRegisteredException extends RuntimeException {
    public SubscriberAlreadyRegisteredException(Long subId) {
        super("Subscriber Already registered Subscriber Id: " + subId);
    }
}
