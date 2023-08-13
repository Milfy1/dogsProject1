package com.udacity.bootstrap.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AirTag {
    @Id
    @SequenceGenerator(name = "air_seq", sequenceName = "air_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "air_seq")
    @Column(name = "id")
    private Long id;
    private String brand;
    private String color;
    private String location;
}