package com.plantguide.plantapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PlantApplication {

  private static final Logger log = LoggerFactory.getLogger(PlantApplication.class);

  static String strType;
  static final String type0 = "TREE";
  static final String type1 = "PERENNIAL";
  static String result = "";
  static int count = 0;
  static String data = "Users Input";
  static Scanner input = new Scanner(System.in);

  public static void addTree(ArrayList<Plant> plantArray) {
    // Variables or option 1
    String commonName, scienceName;
    int minZone, maxZone, type;

    System.out.print("Enter the common name of the plant:");
    if (count != 0) {
      input.nextLine();
    } // Fixes next line issue
    commonName = input.nextLine();
    System.out.print("Enter the scientific name of the plant:");
    scienceName = input.nextLine();
    System.out.print("Enter the minimum planting zone of the plant:");
    minZone = input.nextInt();
    System.out.print("Enter the maximum planting zone of the plant:");
    maxZone = input.nextInt();
    System.out.print("Enter the type of the plant -- 0 for tree, 1 for perennial:");
    type = input.nextInt();

    // Adds the treeType data entered into the plant array.
    plantArray.add(new Plant(commonName, scienceName, minZone, maxZone, type));

    count++;
  }

  public static String typeSearch(ArrayList<Plant> plantArray) {
    // Variable for option 2 user input
    int typeMatch;
    result = "";

    System.out.print("Enter the type int to match (0 for Tree or 1 for Perennial): ");
    typeMatch = input.nextInt();
    System.out.println("Plants that might interest you:");

    // Searches all trees to find trees that match the type entered then prints
    // them.
    for (Plant plant : plantArray) {
      if (plant.getPlantType() == typeMatch) {
        // If statement used to convert type 0/1 to TREE or PERENNIAL word as example
        // did.
        if (plant.getPlantType() == 0) {
          strType = type0;
        } else {
          strType = type1;
        }
        // Prints out tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "): " + strType + ", zones " + plant.getMinZone()
            + "-" + plant.getMaxZone() + "\n");
      }
    }
    return result;
  }

  public static String zoneSearch(ArrayList<Plant> plantArray) {
    // Variable for option 3 user input
    int zoneMatch;
    result = "";

    System.out.print("Enter the zone int to match (Ex: Entering 9 searches for zone 9 trees.): ");
    zoneMatch = input.nextInt();
    System.out.println("Plants that might interest you:");
    // Searches all trees to find trees that match the zone entered then prints
    // them.
    for (Plant plant : plantArray) {
      // If statement used to convert type 0/1 to TREE or PERENNIAL word as example
      // did.
      if (plant.getMinZone() <= zoneMatch && zoneMatch <= plant.getMaxZone()) {
        if (plant.getPlantType() == 0) {
          strType = type0;
        } else {
          strType = type1;
        }
        // Prints out tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "): " + strType + ", zones " + plant.getMinZone()
            + "-" + plant.getMaxZone() + "\n");
      }
    }
    return result;
  }

  public static String nameSearch(ArrayList<Plant> plantArray) {
    // Variable for option 4 user input
    String nameMatch;
    result = "";
    System.out.print("Enter the string to match: ");
    input.nextLine();

    nameMatch = input.nextLine();
    System.out.println("Plants that might interest you:");
    // Searches all trees to find trees that match the name entered then prints
    // them.
    for (Plant plant : plantArray) {
      // If statement used to convert type 0/1 to TREE or PERENNIAL word as example
      // did.
      if (plant.getComName() != null && plant.getComName().toUpperCase().contains(nameMatch.toUpperCase())) {
        if (plant.getPlantType() == 0) {
          strType = type0;
        } else {
          strType = type1;
        }
        // Prints out tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "): " + strType + ", zones " + plant.getMinZone()
            + "-" + plant.getMaxZone() + "\n");
      }
    }
    return result;
  }

  public static void main(String[] args) {
    SpringApplication.run(PlantApplication.class);
  }

  @Bean
  public CommandLineRunner plantSearchDemo(PlantRepository repository) {
    return (args) -> {
      ArrayList<Plant> plantArray = new ArrayList<>();

      // save a few plants
      repository.save(new Plant("comname1", "sciname1", 1, 1, 1));
      repository.save(new Plant("comname2", "sciname2", 2, 2, 1));
      repository.save(new Plant("comname3", "sciname3", 3, 3, 1));
      repository.save(new Plant("comname4", "sciname4", 4, 4, 0));
      repository.save(new Plant("comname5", "sciname5", 5, 5, 0));
      repository.save(new Plant("comname6", "sciname6", 6, 6, 0));

      // Menu Loop
      int menuChoice = -1;
      int count = 0;

      while (menuChoice != 0) {
        // Prints the menu options and asks user to pick one.
        System.out.println("Enter command: ");
        System.out.println("0 to Quit");
        System.out.println("1 to Add");
        System.out.println("2 to Find by type");
        System.out.println("3 to Find by zone");
        System.out.println("4 to Find by name");
        menuChoice = input.nextInt();
        String nameChoice;
        int typeChoice;
        int zoneChoice;

        // ------------------------------------------------------------------
        // if statement for when user chooses to add tree. Stores all user input in
        // variables.
        if (menuChoice == 1) {
          addTree(plantArray);
          Plant plant = plantArray.get(count);
          count += 1;
          repository.save(plant);
        }
        // ------------------------------------------------------------------
        // If statement for when user chooses to find tree by type.
        if (menuChoice == 2) {
          // fetch Plant by plant type
          System.out.println("Enter the tree type (0 for Tree, 1 for Perennial): ");
          typeChoice = input.nextInt();
          System.out.println("--------------------------------");
          List<Plant> plantType = repository.findByPlantType(typeChoice);
          System.out.print("Plant found with findPlantType(:" + typeChoice + ")");
          System.out.println(plantType.toString());
          System.out.println("");
          System.out.println("--------------------------------");
        }

        // ------------------------------------------------------------------
        // if statement for when user chooses to find tree by zone. Searches tree zone
        // data and compares it to user input to find matches.
        if (menuChoice == 3) {
          System.out.println("Enter the zone of tree: ");
          zoneChoice = input.nextInt();
          // fetch Plant by min zone
          System.out.println("--------------------------------");
          List<Plant> zoneList = repository.findByMinZone(zoneChoice);
          System.out.println("Plant found with a zone of:" + zoneChoice);
          System.out.println(zoneList.toString());
          System.out.println("");
          System.out.println("--------------------------------");
        }

        // ------------------------------------------------------------------
        // Code for when user chooses to find tree name by name.
        if (menuChoice == 4) {
          System.out.println("Enter the name of tree: ");
          input.nextLine();
          nameChoice = input.nextLine();
          System.out.println("--------------------------------");
          System.out.println("Plant found that have the name : " + nameChoice);
          repository.findByComName(nameChoice).forEach(comname -> {
            System.out.println(comname.toString());
          });
          System.out.println("");
          System.out.println("--------------------------------");
        }
      }
      input.close();

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

      // fetch Plant by science name
      log.info("--------------------------------");
      log.info("Plant found with findSciName('sciname2'):");
      repository.findBySciName("sciname2").forEach(sciname2 -> {
        log.info(sciname2.toString());
      });
      log.info("");
      log.info("--------------------------------");

    };
  }

}