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

  public static void main(String[] args) {
    SpringApplication.run(PlantApplication.class);
  }

  //----------------------------------------------------------------------
  @Bean
  public CommandLineRunner plantSearchDemo(PlantRepository repository) {
    return (args) -> {
      ArrayList<Plant> plantArray = new ArrayList<>();

      // Save a few plants to database for testing purposes
      repository.save(new Plant("comname1", "sciname1", 1, 7, 1));
      repository.save(new Plant("comname2", "sciname2", 2, 8, 1));
      repository.save(new Plant("comname3", "sciname3", 3, 9, 1));
      repository.save(new Plant("comname4", "sciname4", 4, 10, 0));
      repository.save(new Plant("comname5", "sciname5", 5, 11, 0));
      repository.save(new Plant("comname6", "sciname6", 6, 12, 0));

      // Start of main menu Loop that does not end until user quits.
      int menuChoice = -1;
      int inputCount = 0;
      String nameChoice;
      int typeChoice;
      int zoneChoice;
      String commonName, scienceName;
      int minZone, maxZone, type;

      while (menuChoice != 0) {

        // Prints the menu options and asks user to pick one.
        System.out.println("Enter command: ");
        System.out.println("0 to Quit");
        System.out.println("1 to Add");
        System.out.println("2 to Find by type");
        System.out.println("3 to Find by zone");
        System.out.println("4 to Find by name");
        menuChoice = input.nextInt();

        // ------------------------------------------------------------------
        // if statement for when user chooses to add tree. 
        // Stores all user input in temp variables then saves to H2 database.
        if (menuChoice == 1) {
          System.out.print("Enter the common name of the plant:");

          // Fixes next line format issue
          if (inputCount == 0) {
            input.nextLine();
            inputCount++;
          } 

          // Stores user input into temporary variables
          commonName = input.nextLine();
          System.out.print("Enter the scientific name of the plant:");
          scienceName = input.nextLine();
          System.out.print("Enter the minimum planting zone of the plant:");
          minZone = input.nextInt();
          System.out.print("Enter the maximum planting zone of the plant:");
          maxZone = input.nextInt();
          System.out.print("Enter the type of the plant -- 0 for tree, 1 for perennial:");
          type = input.nextInt();

          // Saves the tree using H2 database
          repository.save(new Plant(commonName, scienceName, minZone, maxZone, type));
      
        }
        // ------------------------------------------------------------------
        // If statement for when user chooses to find tree by type.
        if (menuChoice == 2) {
          // fetch Plant by plant type
          System.out.println("Enter the int to match (0 for Tree, 1 for Perennial): ");
          typeChoice = input.nextInt();
          System.out.println("--------------------------------");
          System.out.println("Plants that might interest you:");
          repository.findByPlantType(typeChoice).forEach(treeType -> {
            System.out.println(treeType.toString());
          });
          System.out.println("");
          System.out.println("--------------------------------");
        }

        // ------------------------------------------------------------------
        // if statement for when user chooses to find tree by zone. Searches tree zone
        // data and compares it to user input to find matches.
        if (menuChoice == 3) {
          System.out.println("Enter the int to match: ");
          zoneChoice = input.nextInt();
          // fetch Plant by min zone
          System.out.println("--------------------------------");
          System.out.println("Plants that might interest you:");
          repository.findByMinZone(zoneChoice).forEach(zone -> {
            System.out.println(zone.toString());
          });
          System.out.println("");
          System.out.println("--------------------------------");
        }

        // ------------------------------------------------------------------
        // if statement for when user chooses to find tree by common name. Searches tree names
        // data and compares it to user input to find matches.
        if (menuChoice == 4) {
          System.out.println("Enter the string to match: ");
          input.nextLine();
          nameChoice = input.nextLine();
          System.out.println("--------------------------------");
          System.out.println("Plants that might interest you:");
          repository.findByComName(nameChoice).forEach(comname -> {
            System.out.println(comname.toString());
          });
          System.out.println("");
          System.out.println("--------------------------------");
        }
      }
      input.close();
      //----------------------------------------------------------------------


      //----------------------------------------------------------------------
      // NOT REQUIRED - Testing code.... 
      // fetch all plants
      System.out.println("********************************");
      System.out.println("--------------------------------");
      System.out.println("Plants found with findAll():");
      for (Plant plant : repository.findAll()) {
        System.out.println(plant.toString());
      }
      System.out.println("");
      System.out.println("--------------------------------");

      // fetch an individual plant by ID
      System.out.println("--------------------------------");
      Plant plant = repository.findById(1L);
      System.out.println("Plant found with findById(1L):");
      System.out.println(plant.toString());
      System.out.println("");
      System.out.println("--------------------------------");

      // fetch Plant by science name
      System.out.println("--------------------------------");
      System.out.println("Plant found with findSciName('sciname2'):");
      repository.findBySciName("sciname2").forEach(sciname2 -> {
        System.out.println(sciname2.toString());
      });
      System.out.println("");
      System.out.println("--------------------------------");
      //----------------------------------------------------------------------

    };
  }

}