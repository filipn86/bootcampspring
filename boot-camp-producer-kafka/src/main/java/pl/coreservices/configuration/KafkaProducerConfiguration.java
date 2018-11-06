package pl.coreservices.configuration;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import pl.coreservices.model.Statistic;
import pl.coreservices.service.StatisticsKafkaProducer;

import java.util.Map;

@Configuration
@Profile("kafka")
@PropertySource({"classpath:/kafka.properties"})
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = Maps.newHashMap();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, Statistic> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Statistic> kafkaTemplate(ProducerFactory<String, Statistic> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public StatisticsKafkaProducer statisticsProducer(@Value("${spring.kafka.statistics-topic}") String statisticsTopic,
                                                      KafkaTemplate<String, Statistic> kafkaTemplate) {
        return new StatisticsKafkaProducer(kafkaTemplate, statisticsTopic);
    }

}
