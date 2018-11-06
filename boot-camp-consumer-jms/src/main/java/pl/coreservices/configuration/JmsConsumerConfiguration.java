package pl.coreservices.configuration;

import org.springframework.context.annotation.*;
import pl.coreservices.service.StatisticsJmsListener;

@Configuration
@Profile("amq")
@PropertySource({"classpath:/amq.properties"})
@Import(JmsConfiguration.class)
public class JmsConsumerConfiguration {

    @Bean
    public StatisticsJmsListener statisticsListener() {
        return new StatisticsJmsListener();
    }
}
