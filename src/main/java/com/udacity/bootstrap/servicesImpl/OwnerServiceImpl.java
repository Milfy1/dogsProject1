package com.udacity.bootstrap.servicesImpl;

import com.udacity.bootstrap.DTO.OwnerDTO;
import com.udacity.bootstrap.KafkaProducer.KafkaProducer;
import com.udacity.bootstrap.converter.Converter;
import com.udacity.bootstrap.entity.Owner;
import com.udacity.bootstrap.exceptions.OwnerNotFoundException;
import com.udacity.bootstrap.repo.OwnerRepo;
import com.udacity.bootstrap.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {


    private final OwnerRepo ownerRepo;

    private final Converter converter;
    private final KafkaProducer<Owner> kafkaProducer;


    public OwnerServiceImpl(OwnerRepo ownerRepo, Converter converter, KafkaProducer<Owner> kafkaProducer) {
        this.ownerRepo = ownerRepo;
        this.converter = converter;
        this.kafkaProducer = kafkaProducer;
    }

    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner owner = converter.convert(ownerDTO, Owner.class);
        ownerRepo.save(owner);
        kafkaProducer.sendmessage("Owner",owner);
        return ownerDTO;
    }
    
    

    public List<OwnerDTO> getOwners(){
        List<Owner> owners = ownerRepo.findAll();
        return converter.toList(owners,OwnerDTO.class);
    }

    public OwnerDTO updateOwner(OwnerDTO ownerDTO, Long id) {
        if (ownerRepo.findById(id).isPresent()){
            ownerDTO.setId(id);
            Owner owner = converter.convert(ownerDTO,Owner.class);
            ownerRepo.save(owner);
            return converter.convert(owner, OwnerDTO.class);
        } else {
            throw new OwnerNotFoundException(id.toString());
        }
    }

    public void deleteOwner(Long id) {
        Optional<Owner> optionalOwner = ownerRepo.findById(id);
        if (!optionalOwner.isPresent()) {
            throw new OwnerNotFoundException(id.toString());
        }
        ownerRepo.delete(optionalOwner.get());
    }

}
