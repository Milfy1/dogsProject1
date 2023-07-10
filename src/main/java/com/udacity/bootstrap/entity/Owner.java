package com.udacity.bootstrap.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
@Entity
public class Owner{

    @Id
    @SequenceGenerator(name = "owner_seq", sequenceName = "owner_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "owner_seq")
    @Column(name = "id")
    private Long id;
    private String name;
    private int age;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_owner_id",referencedColumnName = "id")
    private List<Dog> dogs;


}