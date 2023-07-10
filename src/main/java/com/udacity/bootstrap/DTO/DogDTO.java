package com.udacity.bootstrap.DTO;

import com.udacity.bootstrap.entity.AirTag;
import com.udacity.bootstrap.entity.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class DogDTO {

    private Long id;
    @NotNull(message = "Name shouldn't be null")
    private String name;
    @NotBlank(message = "Breed shouldn't be blank")
    private String breed;
    @NotBlank(message = "Origin shouldn't be blank")
    private String origin;
    private Long fk_owner_id;
    private AirTag airTag;
}
