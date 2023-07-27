package com.udacity.bootstrap.repo;

import com.udacity.bootstrap.entity.AirTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirTagRepo extends JpaRepository<AirTag,Long> {
    @Query("select d.id, d.location from AirTag d where d.id=:id")
    String findLocationById(Long id);
}
