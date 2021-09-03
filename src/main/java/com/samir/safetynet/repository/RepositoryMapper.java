package com.samir.safetynet.repository;

import com.samir.safetynet.dto.Address;
import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.entity.FireStationEntity;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMapper {

    public static SafetyRepository mapTo(SafetyGrossRepository safetyGrossRepository) {
        SafetyRepository safetyRepository = new SafetyRepository();

        List<FireStationEntity> fireStationEntities = safetyGrossRepository.getFirestations();
        List<FireStation> fireStations = new ArrayList<>();

        fireStationEntities.forEach(element -> {
            FireStation fireStation = new FireStation();
            Address address = new Address();
            address.setStreet(element.getAddress());
            fireStation.setAddress(address);
            fireStation.setId(Integer.parseInt(element.getStation()));
            fireStations.add(fireStation);

        });

        return null;
    }
}

