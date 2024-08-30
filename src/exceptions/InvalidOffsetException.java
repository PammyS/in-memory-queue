package exceptions;

public class InvalidOffsetException extends RuntimeException {
    public InvalidOffsetException(Long topicId, long offset, Long maxoffSet) {
        super("Invalid offset: " + offset + " for Topic Id: " + topicId + " Max Offset: " + maxoffSet);
    }
}
