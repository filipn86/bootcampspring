package pl.coreservices.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jms.core.JmsTemplate;
import pl.coreservices.service.StatisticsJmsProducer;

@Configuration
@Profile("amq")
@PropertySource({"classpath:/amq.properties"})
@Import(JmsConfiguration.class)
public class JmsProducerConfiguration {

    @Bean
    public StatisticsJmsProducer statisticsProducer(JmsTemplate jmsTemplate,
                                                    @Value("${amq.statistics.queue}") String queueName) {
        return new StatisticsJmsProducer(jmsTemplate, queueName);
    }

}
