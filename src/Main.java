import entities.Message;
import entities.Publisher;
import entities.Subscriber;
import entities.Topic;
import service.*;


public class Main {
    public static void main(String[] args) {

        TopicService topicService = new TopicServiceImpl();
        SubscriberService subscriberService = new SubscriberServiceImpl();
        PublisherService publisherService = new PublisherServiceImpl(topicService);

        Topic topic1 = new Topic(1L);
        topicService.registerTopic(topic1);

        Topic topic2 = new Topic(2L);
        topicService.registerTopic(topic2);

        Publisher publisher1 = new Publisher(1L, publisherService);
        Publisher publisher2 = new Publisher(2L, publisherService);

        Subscriber sub1 = new Subscriber(1L);
        Subscriber sub2 = new Subscriber(2L);
        Subscriber sub3 = new Subscriber(3L);
        Subscriber sub4 = new Subscriber(4L);
        Subscriber sub5 = new Subscriber(5L);

        subscriberService.resigterSubscriber(sub1);
        subscriberService.resigterSubscriber(sub2);
        subscriberService.resigterSubscriber(sub3);
        subscriberService.resigterSubscriber(sub4);
        subscriberService.resigterSubscriber(sub5);

        subscriberService.registerSubscriberTopic(sub1.getId(), topic1);
        subscriberService.registerSubscriberTopic(sub2.getId(), topic1);
        subscriberService.registerSubscriberTopic(sub3.getId(), topic1);
        subscriberService.registerSubscriberTopic(sub4.getId(), topic1);
        subscriberService.registerSubscriberTopic(sub5.getId(), topic1);

        subscriberService.registerSubscriberTopic(sub1.getId(), topic2);
        subscriberService.registerSubscriberTopic(sub3.getId(), topic2);
        subscriberService.registerSubscriberTopic(sub4.getId(), topic2);


        Message message1 = new Message(1L, "Message 1");
        Message message2 = new Message(1L, "Message 2");
        Message message3 = new Message(1L, "Message 3");
        Message message4 = new Message(1L, "Message 4");
        Message message5 = new Message(1L, "Message 5");

        publisher1.publish(message1, topic1.getId());
        publisher1.publish(message2, topic1.getId());

        publisher2.publish(message3, topic1.getId());
        publisher1.publish(message4, topic2.getId());
        publisher1.publish(message5, topic2.getId());

        new ConsumerService(topicService, subscriberService, sub1.getId(), topic1.getId()).start();
        new ConsumerService(topicService, subscriberService, sub2.getId(), topic1.getId()).start();
        new ConsumerService(topicService, subscriberService, sub3.getId(), topic1.getId()).start();
        new ConsumerService(topicService, subscriberService, sub4.getId(), topic1.getId()).start();
        new ConsumerService(topicService, subscriberService, sub5.getId(), topic1.getId()).start();

        new ConsumerService(topicService, subscriberService, sub1.getId(), topic2.getId()).start();
        new ConsumerService(topicService, subscriberService, sub3.getId(), topic2.getId()).start();
        new ConsumerService(topicService, subscriberService, sub4.getId(), topic2.getId()).start();

    }
}