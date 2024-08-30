package entities;

import java.util.HashMap;
import java.util.Map;

public class Subscriber {
    private final Long id;

    Map<Long, Long> topicOffsetMapping;

    public Subscriber(Long id) {
        this.id = id;
        this.topicOffsetMapping = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public Map<Long, Long> getTopicOffsetMapping() {
        return topicOffsetMapping;
    }
}
