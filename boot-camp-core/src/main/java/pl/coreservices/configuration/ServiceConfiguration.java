package pl.coreservices.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.coreservices.service.HelloWorldService;
import pl.coreservices.service.StatisticsService;

@Configuration
public class ServiceConfiguration {

    @Bean
    public HelloWorldService helloWorldService(@Value("${name:World}:MyWorld") String worldName) {
        return new HelloWorldService(worldName);
    }

    @Bean
    public StatisticsService statisticsService() {
        return new StatisticsService();
    }

}
