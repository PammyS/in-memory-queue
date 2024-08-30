package service;

import entities.Subscriber;
import entities.Topic;
import exceptions.SubscriberAlreadyRegisteredException;
import exceptions.SubscriberAlreadyRegisteredForTopicException;
import exceptions.SubscriberNotRegisteredException;
import exceptions.SubscriberNotRegisteredForTopicException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriberServiceImpl implements SubscriberService{

    Map<Long, Subscriber> subscriberMap = new HashMap<>();

    Map<Long, List<Long>> subscriberTopicMapping = new HashMap<>();
    @Override
    public void resigterSubscriber(Subscriber subscriber) {
        if(subscriberMap.get(subscriber.getId())!=null)
            throw new SubscriberAlreadyRegisteredException(subscriber.getId());
        subscriberMap.put(subscriber.getId(), subscriber);
    }

    @Override
    public void registerSubscriberTopic(Long subscriberId, Topic topic) {
        if(subscriberMap.get(subscriberId)==null)
            throw new SubscriberNotRegisteredException(subscriberId);
        Subscriber subscriber = subscriberMap.get(subscriberId);
        if(subscriber.getTopicOffsetMapping().get(topic.getId())!=null)
            throw new SubscriberAlreadyRegisteredForTopicException(subscriberId, topic.getId());
        subscriber.getTopicOffsetMapping().put(topic.getId(), -1L);
        subscriberTopicMapping.getOrDefault(subscriberId, new ArrayList<>()).add(topic.getId());
    }

    @Override
    public void updateOffset(Long subscriberId, Long topicId, Long offset) {
        if(subscriberMap.get(subscriberId)==null)
            throw new SubscriberNotRegisteredException(subscriberId);
        Subscriber subscriber = subscriberMap.get(subscriberId);
        if(subscriber.getTopicOffsetMapping().get(topicId)==null)
            throw new SubscriberNotRegisteredForTopicException(subscriberId, topicId);
        subscriber.getTopicOffsetMapping().put(topicId, offset);
    }

    @Override
    public Long getCurrentOffset(Long subscriberId, Long topicId) {
        if(subscriberMap.get(subscriberId)==null)
            throw new SubscriberNotRegisteredException(subscriberId);
        Subscriber subscriber = subscriberMap.get(subscriberId);
        if(subscriber.getTopicOffsetMapping().get(topicId)==null)
            throw new SubscriberNotRegisteredForTopicException(subscriberId, topicId);
        return subscriber.getTopicOffsetMapping().get(topicId);
    }

    @Override
    public List<Long> getSubscribedTopics(Long subscriberId) {
        return subscriberTopicMapping.getOrDefault(subscriberId, new ArrayList<>());
    }

}
