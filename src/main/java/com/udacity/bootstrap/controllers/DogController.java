package com.udacity.bootstrap.controllers;

import com.udacity.bootstrap.DTO.DogDTO;
import com.udacity.bootstrap.exceptions.DogNotFoundException;
import com.udacity.bootstrap.services.DogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController{

    private final DogService dogService;


    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/save")
    public ResponseEntity<DogDTO> addDog(@RequestBody @Valid DogDTO dogDTO){
       return new ResponseEntity<>(dogService.createDog(dogDTO),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DogDTO> updateDog(@RequestBody @Valid DogDTO dogDTO, @PathVariable Long id){
        DogDTO dog = dogService.updateDog(dogDTO , id);
        return new ResponseEntity<DogDTO>(dog,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDog(@PathVariable Long id){
         dogService.deleteDog(id);
         return new ResponseEntity("Dog is Deleted",HttpStatus.OK);
     }


    @GetMapping()
    public ResponseEntity<List<DogDTO>> getDogs(){
        List<DogDTO> list = dogService.getDogs();
        return new ResponseEntity<List<DogDTO>>(list, HttpStatus.OK) ;
    }

    @GetMapping("/breed")
    public ResponseEntity<List<String>> retrieveDogBreed(){
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list,HttpStatus.OK);
    }

    @GetMapping("/breed/{id}")
    public  ResponseEntity<String> retrieveDogBreedById(@PathVariable Long id){
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed,HttpStatus.OK) ;
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> retrieveDogNames(){
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list,HttpStatus.OK);
    }
}
