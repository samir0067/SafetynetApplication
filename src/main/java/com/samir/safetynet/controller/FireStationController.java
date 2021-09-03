package com.samir.safetynet.controller;

import com.samir.safetynet.dao.FireStationDao;
import com.samir.safetynet.dto.FireStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/firestation")
public class FireStationController {

    @Autowired
    private FireStationDao fireStationDao;

    @GetMapping
    public List<FireStation> getFireStations() {
        return fireStationDao.getFirStations();
    }
}
