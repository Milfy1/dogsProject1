package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.deserializers.DeSerializer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
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


    @KafkaListener(topics = "Dog, Owner, AirTag", groupId = "your-group-id")
    public void receiveMessage(@Payload byte[] message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the received Avro message
        T data = deSerializer.deserialize(tClass,message);
        System.out.println("Received message: " +"topic: "+topic+ data.toString());
    }
}
