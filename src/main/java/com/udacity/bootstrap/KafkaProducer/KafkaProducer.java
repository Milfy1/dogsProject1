package com.udacity.bootstrap.KafkaProducer;

import com.udacity.bootstrap.serializers.Serializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer<T> {
    private final Serializer<T> serializer;
    private final KafkaTemplate<String,byte[]> kafkaTemplate;

    public KafkaProducer(Serializer<T> serializer, KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.serializer = serializer;
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendmessage(String topicName,T data, Class<T> tClass) {
        kafkaTemplate.send(topicName,serializer.serialize(data));
    }
}
