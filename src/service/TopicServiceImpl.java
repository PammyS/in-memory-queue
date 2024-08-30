package service;

import entities.Message;
import entities.Topic;
import exceptions.InvalidOffsetException;
import exceptions.TopicAlreadyRegisteredException;
import exceptions.TopicNotRegisteredException;

import java.util.HashMap;
import java.util.Map;

public class TopicServiceImpl implements TopicService {

    Map<Long, Topic> topicMap = new HashMap<>();

    @Override
    public void registerTopic(Topic topic) {
        if(topicMap.get(topic.getId())!=null)
            throw new TopicAlreadyRegisteredException(topic.getId());
        topicMap.put(topic.getId(), topic);
    }

    @Override
    public void acceptMessage(Message message, Long topicId) {
        if(topicMap.get(topicId)==null)
            throw new TopicNotRegisteredException(topicId);
        Topic topic = topicMap.get(topicId);
        synchronized (topic) {
            topic.getMessages().add(message);
            topic.setTotalNumberOfMessages(topic.getTotalNumberOfMessages()+1);
        }
    }

    @Override
    public Message readMessage(Long topicId, Long offset) {
        if(topicMap.get(topicId)==null)
            throw new TopicNotRegisteredException(topicId);
        Topic topic = topicMap.get(topicId);
        Long maxOffset = topic.getTotalNumberOfMessages()-1L;
        if(maxOffset<offset+1)
            throw new InvalidOffsetException(topicId, offset+1, maxOffset);
        return topic.getMessages().get(offset.intValue()+1);
    }

    @Override
    public Long getCurrentOffset(Long topicId) {
        if(topicMap.get(topicId)==null)
            throw new TopicNotRegisteredException(topicId);
        Topic topic = topicMap.get(topicId);
        return topic.getTotalNumberOfMessages()-1;
    }
}
