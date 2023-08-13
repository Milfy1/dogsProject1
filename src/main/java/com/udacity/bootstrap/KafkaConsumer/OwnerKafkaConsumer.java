package com.udacity.bootstrap.KafkaConsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import com.udacity.bootstrap.AvroRecords.OwnerRecord;
import com.udacity.bootstrap.converter.Converter;
import com.udacity.bootstrap.entity.AirTag;
import com.udacity.bootstrap.entity.Owner;
import com.udacity.bootstrap.repo.OwnerRepo;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OwnerKafkaConsumer {
    private final Converter converter;
    private final OwnerRepo ownerRepo;
    private final ObjectMapper objectMapper;
    public OwnerKafkaConsumer(Converter converter, OwnerRepo ownerRepo, ObjectMapper objectMapper) {

        this.converter = converter;
        this.ownerRepo = ownerRepo;
        this.objectMapper = objectMapper;
    }


//    @KafkaListener(topics = {"Owner"}, groupId = "1")
//    public void receiveMessage(@Payload ConsumerRecord<String, GenericRecord> message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws IOException {
//        OwnerRecord ownerRecord = objectMapper.readValue( message.value().toString(), OwnerRecord.class);
//        ownerRepo.save(converter.convert(ownerRecord, Owner.class));
//    }
}
