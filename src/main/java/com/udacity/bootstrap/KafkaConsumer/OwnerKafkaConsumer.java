package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.Owner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OwnerKafkaConsumer {
//    private  final DeSerializer<Owner> deSerializer;

    public OwnerKafkaConsumer(DeSerializer<Owner> deSerializer) {

//        this.deSerializer = deSerializer;
    }


    @KafkaListener(topics = {"Owner"}, groupId = "your-group-id")
    public void receiveMessage(@Payload AirTagRecord message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the received Avro message
//        Owner data = deSerializer.deserialize(Owner.class,message);
        System.out.println("Received message: " +"topic: "+topic+ "/"+ message);
    }
}
