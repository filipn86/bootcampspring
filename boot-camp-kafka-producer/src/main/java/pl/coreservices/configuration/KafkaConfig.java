package pl.coreservices.configuration;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@Configuration
@ImportResource({"classpath:/kafka.properties"})
public class KafkaConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = Maps.newHashMap();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic bootCampTopic(){
        return new NewTopic("bootCamp", 10, (short)2);
    }

}
