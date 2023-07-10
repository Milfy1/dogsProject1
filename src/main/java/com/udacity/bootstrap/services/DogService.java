package com.udacity.bootstrap.services;

import com.udacity.bootstrap.DTO.DogDTO;

import java.util.List;

public interface DogService {
    public List<String> retrieveDogBreed();

    public DogDTO createDog(DogDTO dogDTO);

    public String retrieveDogBreedById(Long id);

    public List<String> retrieveDogNames();

    public List<DogDTO> getDogs();

    public DogDTO updateDog(DogDTO dogDTO, Long id);

    public void deleteDog(Long id);
}



