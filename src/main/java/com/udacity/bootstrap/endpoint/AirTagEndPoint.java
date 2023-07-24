package com.udacity.bootstrap.endpoint;


import com.udacity.bootstrap.entity.AirTag;
import com.udacity.bootstrap.gen.AddAirTagRequest;
import com.udacity.bootstrap.gen.AddAirTagResponse;
import com.udacity.bootstrap.gen.AirTags;
import com.udacity.bootstrap.gen.DeleteAirTagRequest;
import com.udacity.bootstrap.repo.AirTagRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Slf4j

@Endpoint
public class AirTagEndPoint {
    private static final String NAMESPACE_URI = "http://soapclasses/gen";

    AirTagRepo airTagRepo;

    @Autowired
    public AirTagEndPoint(AirTagRepo airTagRepo) {
        this.airTagRepo = airTagRepo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAirTagRequest")
    @ResponsePayload
    public AddAirTagResponse addAirTag(@RequestPayload AddAirTagRequest request) {
        log.info("inside addAirTag");
        AddAirTagResponse response = new AddAirTagResponse();
        AirTag airTag= new AirTag();
        airTag.setBrand(request.getAirTag().getBrand());
        airTag.setColor(request.getAirTag().getColor());
        AirTag addedAirTag= airTagRepo.save(airTag);

        //you have to use converter(not work -> configure why?)

        AirTags airTagResponse = new AirTags();
        airTagResponse.setBrand(addedAirTag.getBrand());
        airTagResponse.setColor(addedAirTag.getColor());
        airTagResponse.setId(addedAirTag.getId());

        response.setAirTag(airTagResponse);

          return response;
    }

//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAirTagRequest")
//    @ResponsePayload
//    public List<GetAirTagResponse> getAllAirTags(@RequestPayload GetAirTagRequest request) {
//        log.info("inside getStudentRequest");
//        GetAirTagResponse response = new GetAirTagResponse();
//        List<AirTag> listofAirTags = airTagRepo.findAll();
//
//
//
//        return response;
//    }
@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteAirTagRequest")
@ResponsePayload
public void deleteAirTag(@RequestPayload DeleteAirTagRequest request) {
        log.info(String.format("inside delete"));
        Optional<AirTag> founded= airTagRepo.findById(request.getId());
        if(founded.isPresent()){
            log.info(String.format(" airTga with id %s will be deleted ",request.getId()));
            airTagRepo.deleteById(request.getId());
        }


}

}