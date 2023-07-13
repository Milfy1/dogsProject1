package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.deserializers.DeSerializer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer<T> {
    private  final DeSerializer<T> deSerializer;
    @Setter
    private  String topic;
    @Setter
    private  Class<T> tClass;

    public KafkaConsumer(DeSerializer<T> deSerializer) {
        this.deSerializer = deSerializer;
    }


    @KafkaListener(topics = "Dog", groupId = "your-group-id")
    public void receiveMessage(byte[] message) {
        // Process the received Avro message
        T data = deSerializer.deserialize(tClass,message);
        System.out.println("Received message: " + data.toString());
    }
}
