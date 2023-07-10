package com.udacity.bootstrap.controllers;

import com.udacity.bootstrap.DTO.OwnerDTO;
import com.udacity.bootstrap.services.OwnerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping()
    public ResponseEntity<List<OwnerDTO>> getOwners(){
        List<OwnerDTO> list = ownerService.getOwners();
        return new ResponseEntity<List<OwnerDTO>>(list, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<OwnerDTO> saveOwner(@RequestBody @Valid OwnerDTO ownerDTO){
        return new ResponseEntity<>(ownerService.createOwner(ownerDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id){
        ownerService.deleteOwner(id);
        return new ResponseEntity("Owner is Deleted",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OwnerDTO> updateDog(@RequestBody @Valid OwnerDTO ownerDTO, @PathVariable Long id){
        OwnerDTO owner = ownerService.updateOwner(ownerDTO , id);
        return new ResponseEntity<OwnerDTO>(owner,HttpStatus.OK);
    }


}
