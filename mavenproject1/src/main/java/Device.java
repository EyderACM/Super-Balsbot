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
    private boolean status;
    
    Device(String deviceName, String houseId, String areaId, String roomId,String deviceId, String model){
        this.houseId = houseId;
        this.areaId = areaId;
        this.roomId = roomId;
        this.deviceId = deviceId;
        this.model = model;
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
    public boolean getStatus(){
        return status;
    }
    public void statusToggle(){
        status = !status;
    }
}
