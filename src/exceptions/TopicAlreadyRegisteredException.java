package exceptions;

public class TopicAlreadyRegisteredException extends RuntimeException {
    public TopicAlreadyRegisteredException(Long topicId) {
        super("Topic Already registered Topic Id: " + topicId);
    }
}
