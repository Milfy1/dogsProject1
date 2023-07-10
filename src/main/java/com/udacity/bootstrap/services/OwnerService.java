package com.udacity.bootstrap.services;

import com.udacity.bootstrap.DTO.OwnerDTO;
import java.util.List;

public interface OwnerService{
    public OwnerDTO createOwner(OwnerDTO ownerDTO);
    
    public List<OwnerDTO> getOwners();

    public OwnerDTO updateOwner(OwnerDTO ownerDTO, Long id);

    public void deleteOwner(Long id);
}

