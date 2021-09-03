package com.samir.safetynet.repository;

import com.samir.safetynet.dto.Address;
import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.Person;
import com.samir.safetynet.entity.FireStationEntity;
import com.samir.safetynet.entity.MedicalRecordEntity;
import com.samir.safetynet.entity.PersonEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepositoryMapper {

    public static SafetyRepository mapTo(JsonSafetyRepository jsonSafetyRepository) {
        SafetyRepository safetyRepository = new SafetyRepository();

        // Fire Station
        List<FireStationEntity> fireStationEntities = jsonSafetyRepository.getFirestations();
        List<FireStation> fireStations = new ArrayList<>();

        fireStationEntities.forEach(element -> {
            FireStation fireStation = new FireStation();
            Address address = new Address();
            address.setStreet(element.getAddress());
            address.setFireStationIds(List.of(Integer.parseInt(element.getStation())));
            fireStation.setAddress(address);
            fireStation.setId(Integer.parseInt(element.getStation()));
            fireStations.add(fireStation);
        });
        safetyRepository.setFirestations(fireStations);

        List<PersonEntity> personEntities = jsonSafetyRepository.getPersons();
        List<MedicalRecordEntity> medicalRecordEntities = jsonSafetyRepository.getMedicalrecords();

        Map<String, MedicalRecordEntity> medicalRecordEntityByFirstNameAndLastName
                = medicalRecordEntities.stream().collect(Collectors.toMap(
                element -> element.getFirstName() + element.getLastName(), Function.identity()
        ));

        List<Person> persons = new ArrayList<>();
        int id = 0;
        personEntities.forEach(element -> {
            MedicalRecordEntity medicalRecordEntity =
                    medicalRecordEntityByFirstNameAndLastName.get(element.getFirstName() + element.getLastName());
            Person person = new Person();
            person.setId(id);
            person.setFirstName(element.getFirstName());
            person.setLastName(element.getLastName());
            person.setEmail(element.getEmail());
            person.setPhone(element.getPhone());
            person.setBirthdate(medicalRecordEntity.getBirthdate());

            Address address = new Address();
            address.setStreet(element.getAddress());
            address.setCity(element.getCity());
            address.setZip(element.getZip());
            address.setFireStationIds(getListStationForAnAddress(fireStationEntities, element.getAddress()));
            person.setAddress(address);

            MedicalRecord medicalRecord = new MedicalRecord();
            medicalRecord.setMedications(medicalRecordEntity.getMedications());
            medicalRecord.setAllergies(medicalRecordEntity.getAllergies());
            person.setMedicalRecord(medicalRecord);
            persons.add(person);
        });
        safetyRepository.setPersons(persons);

        return safetyRepository;
    }

    private static List<Integer> getListStationForAnAddress(List<FireStationEntity> fireStationEntities, String address) {
        List<Integer> stationIds = new ArrayList<>();
        fireStationEntities.forEach(element -> {
            if (address.equals(element.getAddress())) {
                stationIds.add(Integer.parseInt(element.getStation()));
            }
        });
        return stationIds;
    }
}

