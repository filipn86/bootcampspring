package pl.coreservices.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import pl.coreservices.service.StatisticsJmsProducer;

import javax.jms.ConnectionFactory;

@Configuration
@Profile("amq")
@PropertySource({"amq.properties"})
@EnableJms
public class JmsProducerConfiguration {

    @Bean
    public ActiveMQConnectionFactory connectionFactory(
            @Value("amq.broker.url") String brokerUrl,
            @Value("amq.broker.username") String username,
            @Value("amq.broker.password") String password){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl, username, password);
        connectionFactory.setBrokerURL(brokerUrl);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    public StatisticsJmsProducer statisticsProducer(JmsTemplate jmsTemplate,
                                                    @Value("${amq.statistics.queue}") String queueName) {
        return new StatisticsJmsProducer(jmsTemplate, queueName);
    }

}
