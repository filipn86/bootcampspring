package pl.coreservices.service;

import org.springframework.kafka.annotation.KafkaListener;
import pl.coreservices.model.Statistic;

public class StatisticsKafkaListener extends MessageListener<Statistic>{

    @KafkaListener(topics = "${spring.kafka.statistics-topic}" )
    @Override
    public void onMessage(Statistic object) {
        callListeners(object);
    }
}
