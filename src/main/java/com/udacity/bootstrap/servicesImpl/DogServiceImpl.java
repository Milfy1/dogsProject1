package com.udacity.bootstrap.servicesImpl;
import com.udacity.bootstrap.DTO.DogDTO;
import com.udacity.bootstrap.converter.ConverterDTO;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exceptions.DogNotFoundException;
import com.udacity.bootstrap.repo.DogRepo;
import com.udacity.bootstrap.serializers.Serializer;
import com.udacity.bootstrap.services.DogService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    private final DogRepo dogRepo;
    private final ConverterDTO converterDTO;
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final Serializer<Dog> serializer;

    public DogServiceImpl(DogRepo dogRepo, ConverterDTO converter, KafkaTemplate<String, Object> kafkaTemplate, Serializer<Dog> serializer) {
        this.dogRepo = dogRepo;
        this.converterDTO = converter;
        this.kafkaTemplate = kafkaTemplate;
        this.serializer = serializer;
    }

    public List<String> retrieveDogBreed() {
        return dogRepo.findAllBreed();
    }

    public DogDTO createDog(DogDTO dogDTO) {
        Dog dog = converterDTO.convert(dogDTO, Dog.class);
        dogRepo.save(dog);
        kafkaTemplate.send("MS.confluent", "check", serializer.serialize(dog));
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
        return converterDTO.toList(dogs, DogDTO.class);
    }

    public DogDTO updateDog(DogDTO dogDTO, Long id) {
        if (dogRepo.findById(id).isPresent()){
            Dog dog = converterDTO.convert(dogDTO,Dog.class);
            dog.setId(id);
            dogRepo.save(dog);
          return converterDTO.convert(dog, DogDTO.class);
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
