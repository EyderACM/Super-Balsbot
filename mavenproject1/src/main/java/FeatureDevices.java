/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar
 */
public class FeatureDevices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AcLg aire = new AcLg("1","1","1","1","1","test1");
        AcSamsung aire2 = new AcSamsung("2","2","2","2","2","test2");
        
        String decreaseTemp = aire.decreaseTemp();
        System.out.println(decreaseTemp);
        
        String increaseTemp = aire.increaseTemp();
        System.out.println(increaseTemp);
        
        String turnOn = Boolean.toString(aire.getStatus());
        System.out.println(turnOn);
        
        String turnOff = Boolean.toString(aire.getStatus());
        System.out.println(turnOff);
        
        String decreaseTemp2 = aire2.decreaseTemp();
        System.out.println(decreaseTemp);
        
        String increaseTemp2 = aire2.increaseTemp();
        System.out.println(increaseTemp);
        
        String turnOn2 = Boolean.toString(aire2.getStatus());
        System.out.println(turnOn);
        
        String turnOff2 = Boolean.toString(aire2.getStatus());
        System.out.println(turnOff);
    }
    
}
