package pl.coreservices.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.coreservices.db.StatisticsDB;
import pl.coreservices.model.Statistic;
import pl.coreservices.service.*;

@Configuration
@Import(MessageingConfiguration.class)
public class ServiceConfiguration {

    @Bean
    public HelloWorldService helloWorldService(@Value("${name:World}:MyWorld") String worldName) {
        return new HelloWorldService(worldName);
    }

    @Bean
    public StatisticsDB statisticsDB() {
        return new StatisticsDB();
    }

    @Bean
    public StatisticsService statisticsService(StatisticsDB statisticsDB) {
        return new StatisticsService(statisticsDB);
    }

    @Bean
    public MessageService messageService(MessageProducer<Statistic> messageProducer) {
        return new MessageService(messageProducer);
    }

}
