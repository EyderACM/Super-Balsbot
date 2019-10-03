/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar
 */
public abstract class Ac extends Device {
    public int tempLevel = 16;

    public Ac(String houseId, String areaId, String roomId, String deviceId, String model) {
        super(houseId, areaId, roomId, deviceId, model);
    }
    
    public String increaseTemp(){
        String action = "se aumento la temperatura";
        return action;
    }
    
    public String decreaseTemp(){
        String action = "se desminuyo la temperatura";
        return action;
    }
}
