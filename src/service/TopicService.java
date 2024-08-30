package service;

import entities.Message;
import entities.Topic;

import java.util.HashMap;
import java.util.Map;

public interface TopicService {
    public void registerTopic(Topic topic);

    public void acceptMessage(Message message, Long topicId);

    public Message readMessage(Long topicId, Long offset);

    public Long getCurrentOffset(Long topicId);
}
