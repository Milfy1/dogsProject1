package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.AirTag;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AirTagKafkaConsumer {
//    private  final DeSerializer<AirTag> deSerializer;

    public AirTagKafkaConsumer(DeSerializer<AirTag> deSerializer) {
//        this.deSerializer = deSerializer;
    }


    @KafkaListener(topics = {"AirTag"}, groupId = "your-group-id" )
    public void receiveMessage(@Payload ConsumerRecord<String, AirTagRecord> message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the received Avro message
        System.out.println("Received message: " +"topic: "+topic+ "/"+ message);
    }
}
