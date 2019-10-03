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
    
    public Area getArea(String areaId){
        return areas.get(areaId);
    }
}
