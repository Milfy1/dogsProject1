package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.AvroRecords.DogRecord;
import com.udacity.bootstrap.AvroRecords.OwnerRecord;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.Owner;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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


    @KafkaListener(topics = {"Owner"}, groupId = "1")
    public void receiveMessage(@Payload ConsumerRecord<String, OwnerRecord> message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the received Avro message
//        Owner data = deSerializer.deserialize(Owner.class,message);
        System.out.println("Received message: " +"topic: "+topic+ "/"+ message);
    }
}
