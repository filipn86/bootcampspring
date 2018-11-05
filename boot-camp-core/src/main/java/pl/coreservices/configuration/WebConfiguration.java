package pl.coreservices.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pl.coreservices.simple.web"})
public class WebConfiguration {
}
