package com.udacity.bootstrap.servicesImpl;

import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import com.udacity.bootstrap.DTO.AirTagDTO;
import com.udacity.bootstrap.KafkaProducer.KafkaProducer;
import com.udacity.bootstrap.converter.Converter;
import com.udacity.bootstrap.entity.AirTag;
import com.udacity.bootstrap.exceptions.AirTagNotFoundException;
import com.udacity.bootstrap.repo.AirTagRepo;
import com.udacity.bootstrap.services.AirTagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirTagImpl implements AirTagService {


    private final Converter converter;

    private final KafkaProducer<AirTagRecord> kafkaProducer;



    private final AirTagRepo airTagRepo;

    public AirTagImpl(Converter converter, KafkaProducer<AirTagRecord> kafkaProducer, AirTagRepo airTagRepo) {
        this.converter = converter;
        this.kafkaProducer = kafkaProducer;
        this.airTagRepo = airTagRepo;
    }

    @Override
    public AirTagDTO createAirTag(AirTagDTO airTagDTO) {
        AirTag airTag = converter.convert(airTagDTO, AirTag.class);
        airTagRepo.save(airTag);
        AirTagRecord a = converter.convert(airTagDTO, AirTagRecord.class);
        kafkaProducer.sendmessage("AirTag", a);
        return airTagDTO;
    }

    @Override
    public List<AirTagDTO> getAirTags() {
        List<AirTag> airTags = airTagRepo.findAll();
        return converter.toList(airTags, AirTagDTO.class);
    }

    @Override
    public AirTagDTO updateAirTag(AirTagDTO airTagDTO, Long id) {
        if (airTagRepo.findById(id).isPresent()){
            airTagDTO.setId(id);
            AirTag airTag = converter.convert(airTagDTO,AirTag.class);
            airTagRepo.save(airTag);
            return converter.convert(airTag, AirTagDTO.class);
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
