package com.plantguide.plantapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Plant repository extends crud repository to get access to its functions.
public interface PlantRepository extends CrudRepository<Plant, Long> {
  // Finds user input based on the upper case version of the common name.
  List<Plant> findByComNameUpperCaseContains(String comNameUpperCase);

  // Finds by plant type (0 or 1)
  List<Plant> findByPlantType(int plantType);

  // Finds zones that are within min and max zone.
  List<Plant> findByMinZoneLessThanEqualAndMaxZoneGreaterThanEqual(int minZone, int maxZone);
}