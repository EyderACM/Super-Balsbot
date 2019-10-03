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
        Room SanitarioSecreto = new Room("Rafa's Secret Bathroom", "1");

        Cuarto.addRoom(Recamara);
        Cuarto.addRoom(Sanitario);
        Casa.addArea(Cuarto);

        Casa.printAreas();
        //Casa.Areas.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
        //Revisamos qué contiene cada elemento.
        //Iterator iterator = Casa.Areas.entrySet().iterator();

        
    }

}
