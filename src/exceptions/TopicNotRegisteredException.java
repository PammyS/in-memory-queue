package exceptions;

public class TopicNotRegisteredException extends RuntimeException {
    public TopicNotRegisteredException(Long topicId) {
        super("Topic is not registered Topic Id: " + topicId);
    }
}
