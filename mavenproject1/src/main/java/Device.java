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

    private String deviceName;
    private String deviceId;
    private String areaId;
    private String houseId;
    private String roomId;
    private String model;
    private DeviceStatus deviceStatus;
    private String deviceType;
    
    Device(String deviceName, String houseId, String areaId, String roomId, String deviceId, String model, String deviceType){
        this.deviceName = deviceName;
        this.houseId = houseId;
        this.areaId = areaId;
        this.roomId = roomId;
        this.deviceId = deviceId;
        this.model = model;
        this.deviceStatus = DeviceStatus.TURNED_ON;
        this.deviceType = deviceType;
    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }
    public void setAreaId(String areaId){
        this.areaId = areaId;
    }
    public void setHouseId(String houseId){
        this.houseId = houseId;
    }
    public void setRoomId(String roomId){
        this.roomId = roomId;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setDeviceType(String deviceType){
        this.deviceType = deviceType;
    }
    
    public String getDeviceName(){
        return deviceName;
    }
    public String getAreaId(){
        return areaId;
    }
    public String getHouseId(){
        return houseId;
    }
    public String getRoomId(){
        return roomId;
    }
    public String getModel(){
        return model;
    }
    public String getDeviceId(){
        return deviceId;
    }
    public String getDeviceType(){
        return this.deviceType;
    }
    
    public DeviceStatus getDeviceStatus(){
        return deviceStatus;
    }
    
    public String turnOn(){
        String action = "prender";
        deviceStatus = DeviceStatus.TURNED_ON;
        return action;
    }
    public String turnOff(){
        String action = "apagar";
        deviceStatus = DeviceStatus.TURNED_OFF;
        return action;
    }
}
