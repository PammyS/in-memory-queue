package service;

import entities.Message;
import entities.Topic;
import exceptions.TopicNotRegisteredException;

public class PublisherServiceImpl implements PublisherService{

    private TopicService topicService;

    public PublisherServiceImpl(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public boolean publish(Message message, Long topicId) {
        try {
            topicService.acceptMessage(message, topicId);
        } catch (TopicNotRegisteredException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
