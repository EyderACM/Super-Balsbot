/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar
 */
public abstract class Tv extends Device {
    public int volumeLevel = 0;

    public Tv(String deviceName, String houseId, String areaId, String roomId, String deviceId, String model) {
        super(deviceName, houseId, areaId, roomId, deviceId, model, "TV");
    }
    public String turnUpVolume(){
        String action = "subir volumen";
        return action;
    }
    public String turnDownVolume(){
       String action = "bajar volumen";
       return action;
    }
}
