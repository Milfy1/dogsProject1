package com.udacity.bootstrap.servicesImpl;

import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.deserializers.DeSerializerImpl;
import com.udacity.bootstrap.entity.Dog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "Dog", groupId = "your-group-id")
    public void receiveMessage(byte[] message) {
        // Process the received Avro message
        DeSerializer<Dog> deSerializer = new DeSerializerImpl<Dog>();
        Dog dog = deSerializer.deserialize(Dog.class,message);
        System.out.println("Received message: " + dog.getName());
    }
}
