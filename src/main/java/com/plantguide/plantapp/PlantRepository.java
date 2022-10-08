package com.plantguide.plantapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
  List<Plant> findByComName(String comName);
  List<Plant> findBySciName(String sciName);

  List<Plant> findByMinZone(int minZone);

  List<Plant> findByMaxZone(int maxZone);

  List<Plant> findByPlantType(int plantType);

  Plant findById(long id);
}