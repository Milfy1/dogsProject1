package com.udacity.bootstrap.KafkaProducer;

import com.udacity.bootstrap.serializers.Serializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer<T> {
    private final Serializer<T> serializer;
    private final KafkaTemplate<String,T> kafkaTemplate;

    public KafkaProducer(Serializer<T> serializer, KafkaTemplate<String, T> kafkaTemplate) {
        this.serializer = serializer;
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendmessage(String topicName,T data) {
        kafkaTemplate.send(topicName,data);
    }
}
