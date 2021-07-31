package com.samir.safetynet.dao;

import com.samir.safetynet.model.FireStation;

import java.util.ArrayList;
import java.util.List;

public class FireStationImpl implements FireStationDao {
    public static List<FireStation> fireStations = new ArrayList<>();

    @Override
    public FireStation findById(long fireStation) {
        for (FireStation station : fireStations) {
            if (station.getId() == fireStation) return station;
        }
        return null;
    }

    @Override
    public FireStation findByAddress(String address) {
        return null;
    }

    @Override
    public List<FireStation> findAll() {
        return null;
    }

    @Override
    public FireStation save(FireStation firesStation) {
        return null;
    }

    @Override
    public void delete(long fireStation) {

    }
}
