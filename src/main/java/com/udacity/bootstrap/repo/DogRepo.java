package com.udacity.bootstrap.repo;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepo extends JpaRepository<Dog,Long> {

    @Query(value = "SELECT DISTINCT breed FROM Dog", nativeQuery = true)
     List<String> findAllBreed();

    @Query(value = "SELECT name FROM Dog", nativeQuery = true)
    List<String> findAllNames();

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);
}
