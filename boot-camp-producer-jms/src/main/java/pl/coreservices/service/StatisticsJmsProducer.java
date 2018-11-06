package pl.coreservices.service;

import org.springframework.jms.core.JmsTemplate;
import pl.coreservices.model.Statistic;

import javax.jms.ObjectMessage;

public class StatisticsJmsProducer implements MessageProducer<Statistic>{

    private JmsTemplate jmsTemplate;
    private String queueName;

    public StatisticsJmsProducer(JmsTemplate jmsTemplate, String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    @Override
    public void sendMessage(Statistic message) {
        jmsTemplate.send(queueName, session -> {
            ObjectMessage objectMessage = session.createObjectMessage(message);
            return objectMessage;
        });
    }
}
