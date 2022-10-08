package com.plantguide.plantapp;

import java.util.ArrayList;
import java.util.Scanner;
// PlantInfo.java
/**
Author: Anthony Schultz
Date: 9/09/22
Assignment Name: Individual Assignment hw2
*/

public class PlantInfo {
  static Scanner input = new Scanner(System.in);
  static String strType;
  static final String type0 = "Tree";
  static final String type1 = "Perennial";
  static String result = "";
  
  static ArrayList <Plant> plantArray = new ArrayList <>();

  Integer count=0;
  
  public void addTree(String ComName, String sciName, Integer minZone, Integer maxZone, Integer type) {

    // Adds the TreeType data entered into the plant array.
    plantArray.add(new Plant(ComName, sciName, minZone, maxZone, type));
    count++;
  }

  public String typeSearch(Integer typeMatch) {
    result="";
    // Variable for option 2 user input
 
    // Searches all Trees to find Trees that match the type entered then prints them.
    for (Plant plant: plantArray) {
      if (plant.getPlantType() == typeMatch) {
        // If statement used to convert type 0/1 to Tree or Perennial word as example did.
        if (plant.getPlantType() == 0) {
          strType = "Tree";
        } else {
          strType = "Perennial";
        }
        // Prints out Tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "), " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
    }
      if (result=="") {return "None";}
      else {return result;}
  }

  public  String zoneSearch(Integer zoneMatch) {
    // Variable for option 3 user input
    //int zoneMatch;
    result = "";

    for (Plant plant: plantArray) {
      
      // If statement used to convert type 0/1 to Tree or Perennial word as example did.
      if (plant.getMinZone() <= zoneMatch && zoneMatch <= plant.getMaxZone()) {
        if (plant.getPlantType() == 0) {
          strType = "Tree";
        } else {
          strType = "Perennial";
        }
        //System.out.println(m.zoneSearch(plantArray));
      result += (plant.getComName() + "(" + plant.getSciName() + "), " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
        // Prints out Tree in the same format example in directions did.
 
      }
      if (result=="") {return "None";}
      else {return result;}
  }

  public String nameSearch(String nameMatch) {
     result = "";
     //System.out.println("Name Match ="+nameMatch);
    // Searches all Trees to find Trees that match the name entered then prints them.
    for (Plant plant: plantArray) {
      // If statement used to convert type 0/1 to Tree or Perennial word as example did.
      //System.out.println("plant=" + plant.getComName());
      if (plant.getComName() !=null && plant.getComName().toUpperCase().contains(nameMatch.toUpperCase())) {
        if (plant.getPlantType() == 0) {
          strType = "Tree";
        } else {
          strType = "Perennial";
        }
        // Prints out Tree in the same format example in directions did.
        result += (plant.getComName() + "(" + plant.getSciName() + "), " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
    } // for loop
      if (result=="") {return "None";}
      else {return result;}
  }










  

  
  public String SciNameSearch(String nameMatch) {
     result = "";
     //System.out.println("Name Match ="+nameMatch);
    // Searches all Trees to find Trees that match the name entered then prints them.
    for (Plant plant: plantArray) {
      //System.out.println("plant=" + plant.getComName());
      String SciName=plant.getSciName();
      String delimSpace = " ";
      String[] arr1  = SciName.split(delimSpace);
      String[] arr2 = nameMatch.split(delimSpace);
      
      if(arr1.length<2||arr2.length<2){      
      if (SciName !=null && (SciName.toUpperCase().contains(nameMatch.toUpperCase()))) {
        if (plant.getPlantType() == 0) {
          strType = "Tree";
        } else {
          strType = "Perennial";
        }


      String sciName = plant.getSciName();
      String[] sciNameSplited = sciName.split("\\s+");
      String[] nameMatchSplited = sciName.split("\\s+");

        System.out.println("\n\n\n************");
        System.out.println(sciNameSplited[0]);
        System.out.println(nameMatchSplited[0]);

      if(nameMatch.charAt(0)!=sciName.charAt(0))
      {
        return "None";
      }


        result += (plant.getComName() + "(" + plant.getSciName() + "), " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
    }
        
      else{
        
      //System.out.println("SciNameSearch: Test Two Sci Names");
      String Part1=arr1[0].toUpperCase();
      String Part2=arr1[1].toUpperCase();
  
      //String[] arr2 = nameMatch.split(delimSpace);
      String nM1 = arr2[0].toUpperCase();
      String nM2 = arr2[1].toUpperCase();

        if(SciName !=null && (Part1.contains(nM1) && Part2.contains(nM2))){
        if (plant.getPlantType() == 0) {
          strType = "Tree";
        } else {
          strType = "Perennial";
        }

      String sciName = plant.getSciName();
      String[] sciNameSplited = sciName.split("\\s+");
      String[] nameMatchSplited = nameMatch.split("\\s+");
        if(sciNameSplited[0].charAt(0)!=nameMatchSplited[0].charAt(0))
        {
        return "None";
        }
      
        if(sciNameSplited[1].charAt(0)!=nameMatchSplited[1].charAt(0))
        {
        return "None";
        }
        
        result += (plant.getComName() + "(" + plant.getSciName() + "), " + strType + ", zones " + plant.getMinZone() + "-" + plant.getMaxZone() + "\n");
      }
      }
    
        // Prints out Tree in the same format example in directions did.

    } // for loop   

      if (result=="") {return "None";}
      else {return result;}
  }
}
