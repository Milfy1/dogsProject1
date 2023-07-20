package com.udacity.bootstrap.servicesImpl;
import com.udacity.bootstrap.AvroRecords.DogRecord;
import com.udacity.bootstrap.DTO.DogDTO;
import com.udacity.bootstrap.KafkaProducer.KafkaProducer;
import com.udacity.bootstrap.converter.Converter;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exceptions.DogNotFoundException;
import com.udacity.bootstrap.repo.DogRepo;
import com.udacity.bootstrap.services.DogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    private final DogRepo dogRepo;
    private final Converter converter;
    private final KafkaProducer<DogRecord> kafkaProducer;
    public DogServiceImpl(DogRepo dogRepo, Converter converter, KafkaProducer<DogRecord> kafkaProducer) {
        this.dogRepo = dogRepo;
        this.converter = converter;
        this.kafkaProducer = kafkaProducer;
    }

    public List<String> retrieveDogBreed() {
        return dogRepo.findAllBreed();
    }

    public DogDTO createDog(DogDTO dogDTO) {
        Dog dog = converter.convert(dogDTO, Dog.class);
        dogRepo.save(dog);
        DogRecord dogRec = converter.convert(dogDTO, DogRecord.class);
        kafkaProducer.sendmessage("Dog", dogRec);
        return dogDTO;
    }

    public String retrieveDogBreedById(Long id) {
        Optional<Dog> dog = dogRepo.findById(id);
        if (dog.isPresent()){
          return dogRepo.findBreedById(id);
        } else {
            throw new DogNotFoundException(id.toString());
        }
    }

    //
    public List<String> retrieveDogNames() {
        return dogRepo.findAllNames();
    }


    public List<DogDTO> getDogs() {
        List<Dog> dogs = dogRepo.findAll();
        return converter.toList(dogs, DogDTO.class);
    }

    public DogDTO updateDog(DogDTO dogDTO, Long id) {
        if (dogRepo.findById(id).isPresent()){
            Dog dog = converter.convert(dogDTO,Dog.class);
            dog.setId(id);
            dogRepo.save(dog);
          return converter.convert(dog, DogDTO.class);
        } else {
            throw new DogNotFoundException(id.toString());
        }
//
    }

    public void deleteDog(Long id) {
        Optional<Dog> optionalDog = dogRepo.findById(id);
        if (!optionalDog.isPresent()) {
            throw new DogNotFoundException(id.toString());
        }
        dogRepo.delete(optionalDog.get());
    }
}
