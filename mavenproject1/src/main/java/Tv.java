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
    public String type = "TV";

    public Tv(String type, String deviceName, String houseId, String areaId, String roomId, String deviceId, String model, String status) {
        super(type, deviceName, houseId, areaId, roomId, deviceId, model, status);
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
