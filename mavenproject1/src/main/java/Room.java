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
    Map<String, Device> devices = new HashMap<>();
    
    Room(String roomName, String roomId){
        this.roomName = roomName;
        this.roomId = roomId;
    }
    
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
    
    public void addDevice(Device newDevice){
        devices.put(newDevice.getDeviceId(), newDevice);
    }
    
    public void removeDevice(String deviceId) {
        if(devices.containsKey(deviceId)) {
            devices.remove(deviceId);
        }
    }
    
    public void printDevices() {
        for (String key : devices.keySet()) {
            System.out.println("            House Id: " + devices.get(key).getHouseId() + " Area Id: " + devices.get(key).getAreaId() + " Room Id: " + devices.get(key).getRoomId() + " Device Id: " + key + " Device Name: " + devices.get(key).getDeviceName() + " Status: " + devices.get(key).getStatus());
        }
    }
    
    public Device getDevice(String deviceId) {
        return devices.get(deviceId);
    }
    
    public void turnOnAllDevices() {
        for (String key : devices.keySet()) {
            System.out.println(key + " : " + devices.get(key).getDeviceName());
            devices.get(key).turnOn();
        }
    }
    
    public void turnOffAllDevices() {
        for (String key : devices.keySet()) {
            System.out.println(key + " : " + devices.get(key).getDeviceName());
            devices.get(key).turnOff();
        }
    }
    
    public int howManyTurnOn() {
        int count = 0;
        for (Device device : devices.values()) {
            if(device.getStatus().equals("Encendido")) {
                count++;
            }
        }
        return count;
    }
    
    public int howManyAC() {
        int count = 0;
        for (Device device : devices.values()) {
            if(device.getDeviceType().equals("AC")) {
                count++;
            }
        }
        return count;
    }
    
    public int howManyTV() {
        int count = 0;
        for (Device device : devices.values()) {
            if(device.getDeviceType().equals("TV")) {
                count++;
            }
        }
        return count;
    }
    
    public int howManyLights() {
        int count = 0;
        for (Device device : devices.values()) {
            if(device.getDeviceType().equals("Lights")) {
                count++;
            }
        }
        return count;
    }
    
}
