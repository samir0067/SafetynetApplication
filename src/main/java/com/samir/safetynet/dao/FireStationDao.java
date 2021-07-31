package com.samir.safetynet.dao;

import com.samir.safetynet.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireStationDao {

    FireStation findById(long fireStation);

    FireStation findByAddress(String address);

    List<FireStation> findAll();

    FireStation save(FireStation firesStation);

    void delete(long fireStation);

}