package com.udacity.bootstrap.servicesImpl;

import com.udacity.bootstrap.DTO.OwnerDTO;
import com.udacity.bootstrap.converter.ConverterDTO;
import com.udacity.bootstrap.deserializers.DeSerializer;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.entity.Owner;
import com.udacity.bootstrap.exceptions.OwnerNotFoundException;
import com.udacity.bootstrap.repo.OwnerRepo;
import com.udacity.bootstrap.serializers.Serializer;
import com.udacity.bootstrap.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {


    private final OwnerRepo ownerRepo;

    private final ConverterDTO converterDTO;

    private final Serializer<Dog> serializer;
    private final DeSerializer<Dog> deserializer;


    public OwnerServiceImpl(OwnerRepo ownerRepo, ConverterDTO converterDTO, Serializer<Dog> serializer, DeSerializer<Dog> deserializer) {
        this.ownerRepo = ownerRepo;
        this.converterDTO = converterDTO;
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner owner = converterDTO.convert(ownerDTO, Owner.class);
        ownerRepo.save(owner);
        return ownerDTO;
    }
    
    

    public List<OwnerDTO> getOwners(){
        List<Owner> owners = ownerRepo.findAll();
        return converterDTO.toList(owners,OwnerDTO.class);
    }

    public OwnerDTO updateOwner(OwnerDTO ownerDTO, Long id) {
        if (ownerRepo.findById(id).isPresent()){
            ownerDTO.setId(id);
            Owner owner = converterDTO.convert(ownerDTO,Owner.class);
            ownerRepo.save(owner);
            return converterDTO.convert(owner, OwnerDTO.class);
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
