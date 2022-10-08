package com.plantguide.plantapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PlantApplication {

  private static final Logger log = LoggerFactory.getLogger(PlantApplication.class); 

  public static void main(String[] args) {
    SpringApplication.run(PlantApplication.class);
  }

  @Bean
  public CommandLineRunner plantSearchDemo(PlantRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Plant("comname1", "sciname1", 1, 1, 1));
      repository.save(new Plant("comname2", "sciname2", 2, 2, 1));
      repository.save(new Plant("comname3", "sciname3", 3, 3, 1));
      repository.save(new Plant("comname4", "sciname4", 4, 4, 0));
      repository.save(new Plant("comname5", "sciname5", 5, 5, 0));
      repository.save(new Plant("comname6", "sciname6", 6, 6, 0));


      // fetch all customers
      log.info("********************************");
      log.info("********************************");
      log.info("********************************");
      log.info("********************************");
      log.info("********************************");
      log.info("********************************");
      log.info("********************************");
      log.info("--------------------------------");
      log.info("Plants found with findAll():");
      for (Plant plant : repository.findAll()) {
        log.info(plant.toString());
      }
      log.info("");
      log.info("--------------------------------");

      // fetch an individual plant by ID
      log.info("--------------------------------");
      Plant plant = repository.findById(1L);
      log.info("Plant found with findById(1L):");
      log.info(plant.toString());
      log.info("");
      log.info("--------------------------------");

      // fetch Plant by common name
      log.info("--------------------------------");
      log.info("Plant found with findComName('comname1'):");
      repository.findByComName("comname1").forEach(comname1 -> {
        log.info(comname1.toString());
      });
      log.info("");
      log.info("--------------------------------");

      // fetch Plant by science name
      log.info("--------------------------------");
      log.info("Plant found with findSciName('sciname2'):");
      repository.findBySciName("sciname2").forEach(sciname2 -> {
        log.info(sciname2.toString());
      });
      log.info("");
      log.info("--------------------------------");

      // fetch Plant by min zone
      log.info("--------------------------------");
      List<Plant> minZone = repository.findByMinZone(4);
      log.info("Plant found with findMinZone(4):");
      log.info(minZone.toString());
      log.info("");
      log.info("--------------------------------");

      // fetch Plant by max zone
      log.info("--------------------------------");
      List<Plant> maxZone = repository.findByMaxZone(5);
      log.info("Plant found with findMaxZone(5):");
      log.info(maxZone.toString());
      log.info("");
      log.info("--------------------------------");

      // fetch Plant by plant type
      log.info("--------------------------------");
      List<Plant> plantType = repository.findByPlantType(1);
      log.info("Plant found with findPlantType(1):");
      log.info(plantType.toString());
      log.info("");
      log.info("--------------------------------");
    };
  }

}