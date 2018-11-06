package pl.coreservices.service;

import pl.coreservices.model.Statistic;

public class MessageService {

    private MessageProducer<Statistic> messageProducer;

    public MessageService(MessageProducer<Statistic> messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void sendMessage(Statistic statistic) {
        messageProducer.sendMessage(statistic);
    }
}
