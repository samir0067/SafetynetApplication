package com.samir.safetynet.dao;

import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationDao {

    public List<FireStation> getFirStations() {
        return SafetyRepository.getSafetyRepository().getFirestations();
    }

}
