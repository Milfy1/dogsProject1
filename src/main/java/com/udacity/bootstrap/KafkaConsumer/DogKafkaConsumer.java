package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import com.udacity.bootstrap.AvroRecords.DogRecord;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.Dog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class DogKafkaConsumer {
//    private  final DeSerializer<Dog> deSerializer;

    public DogKafkaConsumer(DeSerializer<Dog> deSerializer) {

//        this.deSerializer = deSerializer;
    }


    @KafkaListener(topics = {"Dog"}, groupId = "your-group-id")
    public void receiveMessage(@Payload ConsumerRecord<String, DogRecord>  message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the received Avro message
//        Dog data = deSerializer.deserialize(Dog.class,message);
        System.out.println("Received message: " +"topic: "+topic+ "/"+ message);
    }
}
