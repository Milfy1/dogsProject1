package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.Dog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private final DeSerializer<Dog> deSerializer;

    public KafkaConsumer(DeSerializer<Dog> deSerializer) {
        this.deSerializer = deSerializer;
    }


    @KafkaListener(topics = "Dog", groupId = "your-group-id")
    public void receiveMessage(byte[] message) {
        // Process the received Avro message
        Dog dog = deSerializer.deserialize(Dog.class,message);
        System.out.println("Received message: " + dog.getName());
    }
}
