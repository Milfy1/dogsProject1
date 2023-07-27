package com.udacity.bootstrap.services;

import com.udacity.bootstrap.DTO.AirTagDTO;
import com.udacity.bootstrap.DTO.OwnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AirTagService {
    public AirTagDTO createAirTag(AirTagDTO airTagDTO);
    public List<AirTagDTO> getAirTags();
    public AirTagDTO updateAirTag(AirTagDTO airTagDTO, Long id);
    public void deleteAirTag(Long id);
    public String retrieveAirTagLocationById(Long id);
}
