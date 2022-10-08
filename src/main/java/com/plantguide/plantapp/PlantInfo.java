package com.plantguide.plantapp;

import java.util.Scanner;
import java.util.ArrayList;

// PlantInfo.java
/**
Author: Anthony Schultz
Date: 9/09/22
Assignment Name: Individual Assignment hw2
*/

public class PlantInfo {
  static Scanner input = new Scanner(System.in);
  static String strType;
  static final String type0 = "TREE";
  static final String type1 = "PERENNIAL";
  static String result = "";
  static int count = 0;
  static String data = "Users Input";

  public static void addTree(ArrayList < Plant > plantArray) {
    // Variables or option 1
    String commonName, scienceName;
    int minZone, maxZone, type;
    System.out.print("Enter the common name of the plant:");
    if (count!= 0) {input.nextLine();} // Fixes next line issue
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

  public static String typeSearch(ArrayList < Plant > plantArray) {
    // Variable for option 2 user input
    int typeMatch;
    result = "";

    System.out.print("Enter the type int to match (0 for Tree or 1 for Perennial): ");
    typeMatch = input.nextInt();
    System.out.println("Plants that might interest you:");

    // Searches all trees to find trees that match the type entered then prints them.
    for (Plant plant: plantArray) {
      if (plant.getPlantType() == typeMatch) {
        // If statement used to convert type 0/1 to TREE or PERENNIAL word as example did.
        if (plant.getPlantType() == 0) {
          strType = type0;
        } else {
          strType = type1;
        }
        // Prints out tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "): " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
    }
        return result;
  }

  public static String zoneSearch(ArrayList < Plant > plantArray) {
    // Variable for option 3 user input
    int zoneMatch;
    result = "";

    System.out.print("Enter the zone int to match (Ex: Entering 9 searches for zone 9 trees.): ");
    zoneMatch = input.nextInt();
    System.out.println("Plants that might interest you:");
    // Searches all trees to find trees that match the zone entered then prints them.
    for (Plant plant: plantArray) {
      // If statement used to convert type 0/1 to TREE or PERENNIAL word as example did.
      if (plant.getMinZone() <= zoneMatch && zoneMatch <= plant.getMaxZone()) {
        if (plant.getPlantType() == 0) {
          strType = type0;
        } else {
          strType = type1;
        }
        // Prints out tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "): " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
    }
        return result;
  }

  public static String nameSearch(ArrayList < Plant > plantArray) {
    // Variable for option 4 user input
    String nameMatch;
    result = "";
    System.out.print("Enter the string to match: ");
    input.nextLine();

    nameMatch = input.nextLine();
    System.out.println("Plants that might interest you:");
    // Searches all trees to find trees that match the name entered then prints them.
    for (Plant plant: plantArray) {
      // If statement used to convert type 0/1 to TREE or PERENNIAL word as example did.
      if (plant.getComName() != null && plant.getComName().toUpperCase().contains(nameMatch.toUpperCase())) {
        if (plant.getPlantType() == 0) {
          strType = type0;
        } else {
          strType = type1;
        }
        // Prints out tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "): " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
    }
        return result;
  }

  public static void main(String[] args) {
    // Sets initial menu choice to value outside range of while loop.
    int menuChoice = -1;
    // Scanner object used for accepting input of Ints and Strings
    Scanner input = new Scanner(System.in);
    // Variable used in multiple options to display the type of tree.
    String strType;

    ArrayList < Plant > plantArray = new ArrayList < > ();

    while (menuChoice != 0) {
      // Prints the menu options and asks user to pick one.
      System.out.println("Enter command: ");
      System.out.println("0 to Quit");
      System.out.println("1 to Add");
      System.out.println("2 to Find by type");
      System.out.println("3 to Find by zone");
      System.out.println("4 to Find by name");
      menuChoice = input.nextInt();

      //------------------------------------------------------------------
      // if statement for when user chooses to add tree. Stores all user input in variables.
      if (menuChoice == 1) {
        addTree(plantArray);
      }
      //------------------------------------------------------------------
      // If statement for when user chooses to find tree by type.
      if (menuChoice == 2) {
        System.out.println(typeSearch(plantArray));
      }

      //------------------------------------------------------------------
      // if statement for when user chooses to find tree by zone. Searches tree zone data and compares it to user input to find matches.
      if (menuChoice == 3) {
        System.out.println(zoneSearch(plantArray));
      }

      //------------------------------------------------------------------
      // Code for when user chooses to find tree name by name.
      if (menuChoice == 4) {
        System.out.println(nameSearch(plantArray));
      }
    }

    input.close();
    System.out.println("Exiting program ...");
  }
}