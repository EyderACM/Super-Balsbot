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
    /**public static void main(String[] args) {
        House Casa = new House("Rafa's House", "0");
        Area Cuarto = new Area("Rafa's Room", "0");
        Room Recamara = new Room("Rafa's Bedroom", "0");
        Room Sanitario = new Room("Rafa's Bathroom", "1");
        AcPanasonic Aire = new AcPanasonic("AC", "Aire feo", "0", "0", "0", "0", "Panasonic", "Apagado");
        AcSamsung Aire2 = new AcSamsung("AC", "Aire bonito", "0", "0", "0", "1", "Samsung", "Encendido");
        
        Casa.addArea(Cuarto);
        Casa.getArea("0").addRoom(Recamara);
        Casa.getArea("0").addRoom(Sanitario);
        Casa.getArea("0").getRoom("0").addDevice(Aire);
        Casa.getArea("0").getRoom("0").addDevice(Aire2);
        
        System.out.println("Imprimir todo: ");
        System.out.println("Casa Name: " + Casa.getHouseName());
        Casa.printAreas();
        
        System.out.println("");
        System.out.println("Encender/apagar todo en una habitacion: ");
        System.out.println("    Encendiendo: ");
        Casa.getArea("0").getRoom("0").turnOnAllDevices();
        System.out.println("Casa Name: " + Casa.getHouseName());
        Casa.printAreas();
        System.out.println("");
        System.out.println("    Apagando: ");
        Casa.getArea("0").getRoom("0").turnOffAllDevices();
        System.out.println("Casa Name: " + Casa.getHouseName());
        Casa.printAreas();
        
        
        System.out.println("");
    }*/

}
