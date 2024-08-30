package entities;

import service.PublisherService;

public class Publisher {

    PublisherService publisherService;
    private final Long id;

    public Publisher(Long id, PublisherService publisherService) {
        this.id = id;
        this.publisherService = publisherService;
    }

    public Long getId() {
        return id;
    }

    public void publish(Message message, Long topicId) {
        publisherService.publish(message, topicId);
    }
}
