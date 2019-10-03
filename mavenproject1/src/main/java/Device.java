/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar
 */
public class Device {
    public String deviceName;
    public String deviceId;
    public String areaId;
    public String houseId;
    public String roomId;
    public String model;
    public boolean status;
    
    Device(String deviceName, String houseId, String areaId, String roomId,String deviceId, String model){
        this.houseId = houseId;
        this.areaId = areaId;
        this.roomId = roomId;
        this.deviceId = deviceId;
        this.model = model;
    }
    
    public String turnOn(){
        String action = "prender";
        status = true;
        return action;
    }
    public String turnOff(){
        String action = "apagar";
        status = false;
        return action;
    }
}
