package com.plantguide.plantapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String comName;
    private String sciName;
    private int plantType;
    private int minZone;
    private int maxZone;

    protected Plant() {}

    public Plant(String comName, String sciName, int minZone, int maxZone, int plantType) {
      this.comName = comName;
      this.sciName = sciName;
      this.minZone = minZone;
      this.maxZone = maxZone;
      this.plantType = plantType;
    }
  
    // Used to print tree for testing purposes
    @Override
    public String toString() {
      return comName + "," + sciName + "," + minZone + "," + maxZone + "," + plantType;
    }
  
    // Getters for the plant class
    public String getComName() {
      return comName;
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
  
    // Setters for the plant class
    public void setComName(String c) {
      this.comName = c;
    }
    public void setSciName(String s) {
      this.sciName = s;
    }
    public void setMinZone(int minZ) {
      this.plantType = minZ;
    }
    public void setMaxZone(int maxZ) {
      this.plantType = maxZ;
    }
    public void setPlantType(int p) {
      this.plantType = p;
    }
  
  }