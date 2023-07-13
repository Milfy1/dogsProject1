package com.udacity.bootstrap.producer;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class DogProducer {

    private final KafkaTemplate<String,Dog> kafkaTemplate;

    public DogProducer(KafkaTemplate<String, Dog> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void SendAvroData(String topicName, Dog dog){

    }

}
