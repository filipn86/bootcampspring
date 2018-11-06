package pl.coreservices.configuration;

import com.google.common.collect.Lists;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@Profile("amq")
@EnableJms
@PropertySource({"classpath:/amq.properties"})
public class JmsConfiguration {

    @Bean
    public ActiveMQConnectionFactory connectionFactory(
            @Value("${amq.broker.url}") String brokerUrl,
            @Value("${amq.broker.username}") String username,
            @Value("${amq.broker.password}") String password){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl, username, password);
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setTrustAllPackages(true);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

}
