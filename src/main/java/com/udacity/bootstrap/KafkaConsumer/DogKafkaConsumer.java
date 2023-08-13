package com.udacity.bootstrap.KafkaConsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import com.udacity.bootstrap.AvroRecords.DogRecord;
import com.udacity.bootstrap.converter.Converter;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.AirTag;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repo.AirTagRepo;
import com.udacity.bootstrap.repo.DogRepo;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DogKafkaConsumer {
//    private  final DeSerializer<Dog> deSerializer;
private final Converter converter;
    private final DogRepo dogRepo;
    private final ObjectMapper objectMapper;
    public DogKafkaConsumer( Converter converter, DogRepo dogRepo, ObjectMapper objectMapper) {

        this.converter = converter;
        this.dogRepo = dogRepo;
        this.objectMapper = objectMapper;
    }


//    @KafkaListener(topics = {"Dog"}, groupId = "2")
//    public void receiveMessage(@Payload ConsumerRecord<String, GenericRecord> message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws IOException {
//        DogRecord dogRecord = objectMapper.readValue( message.value().toString(), DogRecord.class);
//        dogRepo.save(converter.convert(dogRecord, Dog.class));
//    }
}
