package com.udacity.bootstrap.repo;

import com.udacity.bootstrap.entity.AirTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirTagRepo extends JpaRepository<AirTag,Long> {
}
