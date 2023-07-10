package com.udacity.bootstrap.DTO;

import com.udacity.bootstrap.entity.Dog;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

    private Long id;
    @NotNull(message = "Name shouldn't be null")
    private String name;
    @Min(10)
    @Max(70)
    private int age;

    @NotNull(message = "fk dog shouldn't be null")
    private List<Dog> dogs;

}
