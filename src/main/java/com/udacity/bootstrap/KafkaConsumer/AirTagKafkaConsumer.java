package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.AirTag;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AirTagKafkaConsumer {
    private  final DeSerializer<AirTag> deSerializer;

    public AirTagKafkaConsumer(DeSerializer<AirTag> deSerializer) {
        this.deSerializer = deSerializer;
    }


    @KafkaListener(topics = {"AirTag"}, groupId = "your-group-id")
    public void receiveMessage(@Payload byte[] message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the received Avro message
        AirTag data = deSerializer.deserialize(AirTag.class,message);
        System.out.println("Received message: " +"topic: "+topic+ data.toString());
    }
}
