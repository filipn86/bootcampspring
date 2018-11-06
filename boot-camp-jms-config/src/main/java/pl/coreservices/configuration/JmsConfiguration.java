package pl.coreservices.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@Profile("amq")
@EnableJms
@PropertySource({"amq.properties"})
public class JmsConfiguration {

}
