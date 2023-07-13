package com.udacity.bootstrap.servicesImpl;

import com.udacity.bootstrap.DTO.AirTagDTO;
import com.udacity.bootstrap.KafkaConsumer.KafkaConsumer;
import com.udacity.bootstrap.KafkaProducer.KafkaProducer;
import com.udacity.bootstrap.converter.ConverterDTO;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.AirTag;
import com.udacity.bootstrap.exceptions.AirTagNotFoundException;
import com.udacity.bootstrap.repo.AirTagRepo;
import com.udacity.bootstrap.serializers.Serializer;
import com.udacity.bootstrap.services.AirTagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirTagImpl implements AirTagService {


    private final ConverterDTO converterDTO;

    private final KafkaProducer<AirTag> kafkaProducer;
    private final KafkaConsumer<AirTag> kafkaConsumer;



    private final AirTagRepo airTagRepo;

    public AirTagImpl(ConverterDTO converterDTO, KafkaProducer<AirTag> kafkaProducer, KafkaConsumer<AirTag> kafkaConsumer, AirTagRepo airTagRepo) {
        this.converterDTO = converterDTO;
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
       this.kafkaConsumer.setTClass(AirTag.class);
        this.airTagRepo = airTagRepo;
    }

    @Override
    public AirTagDTO createAirTag(AirTagDTO airTagDTO) {
        AirTag airTag = converterDTO.convert(airTagDTO, AirTag.class);
        airTagRepo.save(airTag);
        kafkaProducer.sendmessage("AirTag", airTag);
        return airTagDTO;
    }

    @Override
    public List<AirTagDTO> getAirTags() {
        List<AirTag> airTags = airTagRepo.findAll();
        return converterDTO.toList(airTags, AirTagDTO.class);
    }

    @Override
    public AirTagDTO updateAirTag(AirTagDTO airTagDTO, Long id) {
        if (airTagRepo.findById(id).isPresent()){
            airTagDTO.setId(id);
            AirTag airTag = converterDTO.convert(airTagDTO,AirTag.class);
            airTagRepo.save(airTag);
            return converterDTO.convert(airTag, AirTagDTO.class);
        } else {
           throw new AirTagNotFoundException(id.toString());
        }
    }

    @Override
    public void deleteAirTag(Long id) {
        Optional<AirTag> optionalAirTag = airTagRepo.findById(id);
        if (!optionalAirTag.isPresent()) {
            throw new AirTagNotFoundException(id.toString());
        }
        airTagRepo.delete(optionalAirTag.get());
    }
}
