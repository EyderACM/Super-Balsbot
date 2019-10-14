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
    private String model;
    
    Device(String deviceName, String houseId, String areaId, String roomId,String deviceId, String model){
        this.deviceId = deviceId;
        this.model = model;
    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }
    public void setModel(String model){
        this.model = model;
    }
    
    public String getDeviceName(){
        return deviceName;
    }
    public String getModel(){
        return model;
    }
    public String getDeviceId(){
        return deviceId;
    }
}
