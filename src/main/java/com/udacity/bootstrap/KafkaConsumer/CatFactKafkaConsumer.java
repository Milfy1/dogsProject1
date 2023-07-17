package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.deserializers.DeSerializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CatFactKafkaConsumer {
    private  final DeSerializer<String> deSerializer;

    public CatFactKafkaConsumer(DeSerializer<String> deSerializer) {
        this.deSerializer = deSerializer;
    }


    @KafkaListener(topics = {"Cat_Facts"}, groupId = "your-group-id")
    public void receiveMessage(@Payload byte[] message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the received Avro message
        String data = deSerializer.deserialize(String.class,message);
        System.out.println("Received message: " +"topic: "+topic+ "/"+ data.toString());
    }
}
