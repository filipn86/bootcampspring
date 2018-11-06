package pl.coreservices.service;

import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import pl.coreservices.model.Statistic;

public class StatisticsJmsListener extends MessageListener<Statistic>{

    @Override
    public void onMessage(Statistic object) {
        callListeners(object);
    }

    @JmsListener(destination = "${amq.statistics.queue}")
    public void receiveMessage(final Message<Statistic> message) {
        this.onMessage(message.getPayload());
    }

}
