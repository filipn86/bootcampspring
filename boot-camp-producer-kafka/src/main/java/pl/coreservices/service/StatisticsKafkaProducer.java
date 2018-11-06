package pl.coreservices.service;

import org.springframework.kafka.core.KafkaTemplate;
import pl.coreservices.model.Statistic;

public class StatisticsKafkaProducer implements MessageProducer<Statistic>{

    private KafkaTemplate<String, Statistic> kafkaTemplate;
    private String topic;
    public StatisticsKafkaProducer(KafkaTemplate<String, Statistic> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }


    @Override
    public void sendMessage(Statistic message) {
        kafkaTemplate.send(topic, message);
    }
}
