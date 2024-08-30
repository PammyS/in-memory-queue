package service;

import entities.Message;
import entities.Topic;

public interface PublisherService {
    public boolean publish(Message message, Long topicId);
}
