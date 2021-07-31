package com.samir.safetynet.dao;

import com.samir.safetynet.model.FireStation;

import java.util.ArrayList;
import java.util.List;

public class FireStationImpl implements FireStationDao {
    public static List<FireStation> fireStations = new ArrayList<>();

    @Override
    public List<FireStation> findAll() {
        return fireStations;
    }

    @Override
    public FireStation findById(long fireStation) {
        for (FireStation station : fireStations) {
            if (station.getId() == fireStation) return station;
        }
        return null;
    }

    @Override
    public FireStation findByAddress(String address) {
        for (FireStation fireStation : fireStations) {
            if (fireStation.getAddress().getAddress().equals(address)) return fireStation;
        }
        return null;
    }

    @Override
    public FireStation save(FireStation firesStation) {
        fireStations.add(firesStation);
        return firesStation;
    }

    @Override
    public void delete(long fireStation) {
        FireStation fireStationId = findById(fireStation);
        fireStations.remove(fireStationId);
    }
}
