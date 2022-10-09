package com.plantguide.plantapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
  List<Plant> findByComName(String comName);

  List<Plant> findBySciName(String sciName);

  List<Plant> findByComNameUpperCaseContains(String comNameUpperCase);

  List<Plant> findByPlantType(int plantType);

  List<Plant> findByMinZoneLessThanEqualAndMaxZoneGreaterThanEqual(int minZone, int maxZone);
}