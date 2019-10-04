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
        //AcPanasonic Aire1 = new AcPanasonic("Aire feo", "0", "0", "0", "0", "Panasonic","Apagado");
        //AcSamsung Aire2 = new AcSamsung("Aire de lujo", "0", "0", "0", "1", "Samsung", "Encendido");
        
        //Casa.addArea(Cuarto);
        //Casa.getArea("0").addRoom(Recamara);
        //Casa.getArea("0").addRoom(Sanitario);
        //Casa.getArea("0").addRoom("0").addDevice(Aire1);
        //Casa.getArea("0").addRoom().addDevice(Aire2);
        
        
        System.out.println("Prueba 1:");
        Casa.printAreas();
        
        System.out.println("Prueba 2:");
        Casa.getArea("0").removeRoom("0");
        Casa.printAreas();
        
        System.out.println("Prueba 3:");
        Casa.getArea("0").addRoom(Sanitario2);
        Casa.printAreas();
        
        System.out.println("Prueba 4:");
        //Casa.getArea("0").getRoom("0").addDevice(Aire1);
        Casa.printAreas();
        
    }

}
