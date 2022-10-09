package com.plantguide.plantapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plant {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String comName;
  private String comNameUpperCase;
  private String sciName;
  private String plantTypeStr;
  private int plantType;
  private int minZone;
  private int maxZone;

  protected Plant() {
  }

  public Plant(String comName, String sciName, int minZone, int maxZone, int plantType) {
    this.comName = comName;
    this.comNameUpperCase = comName.toUpperCase();
    this.sciName = sciName;
    this.minZone = minZone;
    this.maxZone = maxZone;
    this.plantType = plantType;
    if (plantType == 0) {
      this.plantTypeStr = "TREE";
    } else if (plantType == 1) {
      this.plantTypeStr = "PERENNIAL";
    }
  }

  // Used to print tree for testing purposes
  @Override
  public String toString() {
    return comName + " (" + sciName + "): " + plantTypeStr + ", zones " + minZone + "-" + maxZone;
  }

  // Getters for the plant class
  public String getComName() {
    return comName;
  }

  public String getComNameUpperCase() {
    return comNameUpperCase;
  }

  public String getSciName() {
    return sciName;
  }

  public int getMinZone() {
    return minZone;
  }

  public int getMaxZone() {
    return maxZone;
  }

  public int getPlantType() {
    return plantType;
  }

  public String getPlantTypeStr() {
    return plantTypeStr;
  }

  // Setters for the plant class
  public void setComName(String c) {
    this.comName = c;
  }

  public void setComNameUpperCase(String cUpper) {
    this.comName = cUpper;
  }

  public void setSciName(String s) {
    this.sciName = s;
  }

  public void setMinZone(int minZ) {
    this.minZone = minZ;
  }

  public void setMaxZone(int maxZ) {
    this.maxZone = maxZ;
  }

  public void setPlantType(int p) {
    this.plantType = p;
  }

  public void setPlantType(String pString) {
    this.plantTypeStr = pString;
  }

}