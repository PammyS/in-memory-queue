package entities;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final Long id;
    private Long totalNumberOfMessages;
    private List<Message> messages;

    public Topic(Long id) {
        this.id = id;
        this.totalNumberOfMessages = 0L;
        this.messages = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Long getTotalNumberOfMessages() {
        return totalNumberOfMessages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setTotalNumberOfMessages(Long totalNumberOfMessages) {
        this.totalNumberOfMessages = totalNumberOfMessages;
    }
}
