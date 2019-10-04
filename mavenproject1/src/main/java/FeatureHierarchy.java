/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Rafael
 */
public class FeatureHierarchy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        House Casa = new House("Rafa's House", "0");
        Area Cuarto = new Area("Rafa's Room", "0");
        Room Recamara = new Room("Rafa's Bedroom", "0");
        Room Sanitario = new Room("Rafa's Bathroom", "1");
        Room Sanitario2 = new Room("Edgar's Bathroom", "0");
        AcPanasonic Aire1 = new AcPanasonic("Ac","Aire todo poderoso", "0", "0", "0", "0", "Panasonic", "Apagado");
        AcSamsung Aire2 = new AcSamsung("Ac","Aire menos poderoso", "0", "0", "0", "0", "samsung", "encendido");
       //String type, String deviceName, String houseId, String areaId, String roomId,String deviceId, String model, String status
        Casa.addArea(Cuarto);
        Casa.getArea("0").addRoom(Recamara);
        Casa.getArea("0").getRoom("0").addDevice(Aire1);
        Casa.getArea("0").getRoom("0").addDevice(Aire2);
        
        Casa.getArea("0").getRoom("0").turnOnDevices();
        Casa.getArea("0").getRoom("0").turnOffDevices();
        
        
    }

}
