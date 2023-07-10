package com.udacity.bootstrap.DTO;

import com.udacity.bootstrap.entity.Dog;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AirTagDTO {

        private Long id;
        @NotNull(message = "Brand shouldn't be null")
        private String brand;
        @NotBlank(message = "Color shouldn't be null")
        private String Color;
        private Dog dog;
}
