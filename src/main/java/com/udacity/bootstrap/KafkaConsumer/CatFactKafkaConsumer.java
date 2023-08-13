package com.udacity.bootstrap.KafkaConsumer;

import com.udacity.bootstrap.AvroRecords.CatFactRecord;
import com.udacity.bootstrap.deserializers.DeSerializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CatFactKafkaConsumer {

    public CatFactKafkaConsumer() {
    }

//
//    @KafkaListener(topics = {"Cat_Facts"}, groupId = "1")
//    public void receiveMessage(@Payload ConsumerRecord<String, CatFactRecord> message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//
//        System.out.println("Received message: " +"topic: "+topic+ "/"+ message.value());
//    }
}
