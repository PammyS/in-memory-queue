package service;

import entities.Subscriber;
import entities.Topic;

import java.util.List;

public interface SubscriberService {

    public void resigterSubscriber(Subscriber subscriber);

    public void registerSubscriberTopic(Long subscriberId, Topic topic);

    public void updateOffset(Long subscriberId, Long topicId, Long offset);

    public Long getCurrentOffset(Long subscriberId, Long topicId);

    public List<Long> getSubscribedTopics(Long subscriberId);

}
