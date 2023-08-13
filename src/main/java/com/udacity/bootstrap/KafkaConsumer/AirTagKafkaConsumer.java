package com.udacity.bootstrap.KafkaConsumer;
import com.udacity.bootstrap.repo.AirTagRepo;
import org.apache.avro.generic.GenericRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import com.udacity.bootstrap.converter.Converter;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.AirTag;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class AirTagKafkaConsumer {
private final Converter converter;
private final AirTagRepo airTagRepo;
private final ObjectMapper objectMapper;

    public AirTagKafkaConsumer( Converter converter, AirTagRepo airTagRepo, ObjectMapper objectMapper) {
        this.converter = converter;
        this.airTagRepo = airTagRepo;
        this.objectMapper = objectMapper;
    }


    @KafkaListener(topics = {"topic_2"}, groupId = "2")
    public void receiveMessage(@Payload ConsumerRecord<String, GenericRecord> message ) throws IOException {

        AirTagRecord airTagRecord = objectMapper.readValue( message.value().toString(), AirTagRecord.class);
        System.out.println(airTagRecord);
        airTagRepo.save(converter.convert(airTagRecord,AirTag.class));
    }
}
