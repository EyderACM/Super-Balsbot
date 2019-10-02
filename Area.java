/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Rafael
 */
public class Area {
    private String areaName;
    private String areaId;
    Map<String, Room> Rooms = new HashMap<>();
    
    public void setAreaName(String areaName){
        this.areaName = areaName;
    }
    public void setAreaId(String areaId){
        this.areaId = areaId;
    }
    public String getAreaName(){
        return areaName;
    }
    public String getAreaId(){
        return areaId;
    }
    
    Area(String areaName, String areaId){
        this.areaName = areaName;
        this.areaId = areaId;
    }
    
    public void addArea(Room newRoom){
        Rooms.put(newRoom.getRoomId(), newRoom);
    }
}
