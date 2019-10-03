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
public class Area {
    private String areaName;
    private String areaId;
    public Map<String, Room> rooms = new HashMap<>();
    
    Area(String areaName, String areaId){
        this.areaName = areaName;
        this.areaId = areaId;
    }
    
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
    
    public void addRoom(Room newRoom){
        rooms.put(newRoom.getRoomId(), newRoom);
    }
    
    public void removeRoom(String roomId) {
        if(rooms.containsKey(roomId)) {
            rooms.remove(roomId);
        }
    }
    
    public void printRooms() {
        for (String key : rooms.keySet()) {
            System.out.println(key + " : " + rooms.get(key).getRoomName());
            rooms.get(key).printDevices();
        }
    }
    
    public Room getRoom(String roomId){
        return rooms.get(roomId);
    }
}