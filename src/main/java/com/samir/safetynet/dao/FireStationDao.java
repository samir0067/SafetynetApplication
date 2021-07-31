package com.samir.safetynet.dao;

import com.samir.safetynet.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireStationDao {

    List<FireStation> findAll();

    FireStation findById(long fireStation);

    FireStation findByAddress(String address);

    FireStation save(FireStation firesStation);

    void delete(long fireStation);

}