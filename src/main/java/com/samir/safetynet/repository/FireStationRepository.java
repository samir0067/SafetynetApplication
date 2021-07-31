package com.samir.safetynet.repository;

import com.samir.safetynet.model.FireStation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FireStationRepository extends CrudRepository<FireStation, Long> {

    @Override
    Optional<FireStation> findById(Long id);
}
