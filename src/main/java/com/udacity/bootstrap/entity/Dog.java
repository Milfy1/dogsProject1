package com.udacity.bootstrap.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dog")
public class Dog {

    @Id
    @SequenceGenerator(name = "dogs_seq", sequenceName = "dogs_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "dogs_seq")
    @Column(name = "id")
    private Long id;
    private String name;
    private String breed;
    private String origin;
    private Long fk_owner_id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_airTag_id")
    private AirTag airTag;
}
