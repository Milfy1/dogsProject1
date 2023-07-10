package com.udacity.bootstrap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AirTag {
    @Id
    @SequenceGenerator(name = "air_seq", sequenceName = "air_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "air")
    @Column(name = "id")
    private Long id;
    private String brand;
    private String color;

}
