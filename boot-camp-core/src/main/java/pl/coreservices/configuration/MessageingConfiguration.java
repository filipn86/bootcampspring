package pl.coreservices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import pl.coreservices.db.StatisticsDB;
import pl.coreservices.service.StatisticsKafkaListener;
import pl.coreservices.service.StatisticsListenerService;

@Configuration
@Import({KafkaConsumerConfiguration.class, KafkaProducerConfiguration.class})
public class MessageingConfiguration {

    @Bean
    @DependsOn({"statisticsDB","statisticsListener"})
    public StatisticsListenerService statisticsListenerService(StatisticsDB statisticsDB, StatisticsKafkaListener statisticsListener) {
        StatisticsListenerService statisticsListenerService = new StatisticsListenerService(statisticsDB);
        statisticsListener.addListener(statisticsListenerService);
        return statisticsListenerService;
    }

}
