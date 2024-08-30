package service;

import entities.Message;
import exceptions.InvalidOffsetException;

public class ConsumerService extends Thread{
    TopicService topicService;

    SubscriberService subscriberService;

    Long subId;

    Long topicId;

    public ConsumerService(TopicService topicService, SubscriberService subscriberService, Long subId, Long topicId) {
        this.topicService = topicService;
        this.subscriberService = subscriberService;
        this.topicId = topicId;
        this.subId = subId;
    }

    public void startConsumer() {
        while(true) {
            try {
                Long offset = subscriberService.getCurrentOffset(subId, topicId);
                Message receivedMessage = topicService.readMessage(topicId, offset);
                subscriberService.updateOffset(subId, topicId, offset+1);
                System.out.println("Subscriber ID: " + subId + " Topic ID: "+ topicId + " Message Received: " + receivedMessage.getData());
                Thread.sleep(5000);
            } catch (InvalidOffsetException e) {
                System.out.println("No new message for Subscriber Id: " + subId + " For Topic ID: " + topicId + " " + e.getMessage());
                System.out.println("Will wait for 5 seconds");
                try {
                    Thread.sleep(5000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        startConsumer();
    }
}
