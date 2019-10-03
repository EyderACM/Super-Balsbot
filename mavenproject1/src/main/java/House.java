/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rafael
 */
public class House {

    private String houseName;
    private String houseId;
    Map<String, Area> areas = new HashMap<>();

    House(String houseName, String houseId) {
        this.houseName = houseName;
        this.houseId = houseId;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getHouseId() {
        return houseId;
    }

    public void addArea(Area newArea) {
        areas.put(newArea.getAreaId(), newArea);
    }

    public void removeArea(String areaId) {
        if (areas.containsKey(areaId)) {
            areas.remove(areaId);
        }
    }

    public void printAreas() {
        for (String key : areas.keySet()) {
            System.out.println("    Area Id: " + key + " Area Name: " + areas.get(key).getAreaName());
            areas.get(key).printRooms();
        }
    }
    
    public Area getArea(String areaId){
        return areas.get(areaId);
    }
    
    public int howManyTurnOn() {
        int count = 0;
        for (Area area : areas.values()) {
            count += area.howManyTurnOn();
        }
        return count;
    }
    
    public int howManyAC() {
        int count = 0;
        for (Area area : areas.values()) {
            count += area.howManyAC();
        }
        return count;
    }
    
    public int howManyTV() {
        int count = 0;
        for (Area area : areas.values()) {
            count += area.howManyTV();
        }
        return count;
    }
    
    public int howManyLights() {
        int count = 0;
        for (Area area : areas.values()) {
            count += area.howManyLights();
        }
        return count;
    }
}
