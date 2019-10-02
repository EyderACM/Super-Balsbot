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
public class Room {
    private String roomName;
    private String roomId;
    Map<String, Device> Devices = new HashMap<>();
    
    public void setRoomName(String roomName){
        this.roomName = roomName;
    }
    public void setRoomId(String roomId){
        this.roomId = roomId;
    }
    public String getRoomName(){
        return roomName;
    }
    public String getRoomId(){
        return roomId;
    }
    
    Room(String roomName, String roomId){
        this.roomName = roomName;
        this.roomId = roomId;
    }
    
    public void addDevice(Device newDevice){
        Devices.put(newDevice.getDeviceId(), newDevice);
    }
}
