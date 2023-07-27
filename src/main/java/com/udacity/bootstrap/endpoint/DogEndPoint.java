package com.udacity.bootstrap.endpoint;


import com.udacity.bootstrap.converter.Converter;
import com.udacity.bootstrap.entity.AirTag;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.gen.AddDogRequest;
import com.udacity.bootstrap.gen.AddDogResponse;
import com.udacity.bootstrap.gen.Dogs;
import com.udacity.bootstrap.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DogEndPoint {

    private static final String NAMESPACE_URI = "http://soapclasses/gen";

    Converter converter;
    DogRepo dogRepo;
    @Autowired
    public DogEndPoint(DogRepo dogRepo, Converter converter) {
        this.dogRepo = dogRepo;
        this.converter=converter;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addDogRequest")
    @ResponsePayload
    public AddDogResponse addDog(@RequestPayload AddDogRequest request){

    Dog dog = new Dog();
//    dog.setName(request.getDog().getName());
//    dog.setBreed(request.getDog().getBreed());
//    dog.setOrigin(request.getDog().getOrigin());
//    dog.setFk_owner_id(request.getDog().getFkOwnerId());


//    AirTag dogAirTag= new AirTag();
//    dogAirTag.setColor(request.getDog().getAirTag().getColor());
//    dogAirTag.setBrand(request.getDog().getAirTag().getBrand());
//    dogAirTag.setId(request.getDog().getAirTag().getId());
    dog.setAirTag(converter.convert(request.getDog().getAirTag(), AirTag.class));

    Dog added =dogRepo.save(converter.convert(request.getDog(), Dog.class));

    AddDogResponse response = new AddDogResponse();
response.setDog(converter.convert(added, Dogs.class));
    return response;
    }
}
