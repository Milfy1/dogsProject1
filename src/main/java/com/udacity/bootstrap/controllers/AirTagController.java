package com.udacity.bootstrap.controllers;

import com.udacity.bootstrap.DTO.AirTagDTO;
import com.udacity.bootstrap.DTO.OwnerDTO;
import com.udacity.bootstrap.repo.AirTagRepo;
import com.udacity.bootstrap.services.AirTagService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AirTag")
public class AirTagController {

    private final AirTagService airTagService;


    public AirTagController(AirTagRepo airTagRepo, AirTagService airTagService) {
        this.airTagService = airTagService;
    }

    @GetMapping()
    public ResponseEntity<List<AirTagDTO>> getAirTags(){
        List<AirTagDTO> list = airTagService.getAirTags();
        return new ResponseEntity<List<AirTagDTO>>(list, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AirTagDTO> saveAirTag(@RequestBody @Valid AirTagDTO airTagDTO){
        return new ResponseEntity<>(airTagService.createAirTag(airTagDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAirTag(@PathVariable Long id){
        airTagService.deleteAirTag(id);
        return new ResponseEntity("Air Tag is Deleted",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AirTagDTO> updateAir(@RequestBody @Valid AirTagDTO airTagDTO, @PathVariable Long id){
        AirTagDTO airTag = airTagService.updateAirTag(airTagDTO , id);
        return new ResponseEntity<AirTagDTO>(airTagDTO,HttpStatus.OK);
    }
//
//    @PostMapping("/save")
//    public ResponseEntity<AirTag> addDog(@RequestBody @Valid AirTag airTagDTO){
//        return new ResponseEntity<>(airTagRepo.save(airTagDTO), HttpStatus.CREATED);
//    }
//
//    @GetMapping()
//    public List<AirTag> getAirs(){
//        return airTagRepo.findAll();
//    }

}
