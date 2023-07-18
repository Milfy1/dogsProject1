package com.udacity.bootstrap.servicesImpl;
import com.udacity.bootstrap.DTO.DogDTO;
import com.udacity.bootstrap.KafkaConsumer.DogKafkaConsumer;
import com.udacity.bootstrap.KafkaProducer.KafkaProducer;
import com.udacity.bootstrap.converter.ConverterDTO;
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
    private final ConverterDTO converterDTO;
    private final KafkaProducer<Dog> kafkaProducer;
    private final DogKafkaConsumer kafkaConsumer;
    public DogServiceImpl(DogRepo dogRepo, ConverterDTO converter, KafkaProducer<Dog> kafkaProducer, DogKafkaConsumer kafkaConsumer) {
        this.dogRepo = dogRepo;
        this.converterDTO = converter;
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
    }

    public List<String> retrieveDogBreed() {
        return dogRepo.findAllBreed();
    }

    public DogDTO createDog(DogDTO dogDTO) {
        Dog dog = converterDTO.convert(dogDTO, Dog.class);

        dogRepo.save(dog);
        kafkaProducer.sendmessage("Dog", dog);
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
