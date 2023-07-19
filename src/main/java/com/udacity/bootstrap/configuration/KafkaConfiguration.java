package com.udacity.bootstrap.configuration;

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfiguration {

//    @Bean
//    public ProducerFactory<String,String> producerFactory(){
//        return new DefaultKafkaProducerFactory<>(
//                Map.of(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true"));
//    }
}
