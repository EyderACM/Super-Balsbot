

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eyder
 */
public class DeviceManager {
    
    private final File deviceDatabase;
    
    DeviceManager(){
        this.deviceDatabase = new File("deviceDatabase.txt");                    
    }
    public void printAllHouseDevices(String houseId){
        Device foundDevice = null;
        try{
            File tempFile = new File("tempDeviceDatabase.txt");
            BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase)); 
            String currentLine;
     
            while((currentLine = reader.readLine()) !=  null){
                String data[] = new String[8];
                data = currentLine.split(",");
                   if(data[2].equals(houseId)){
                       System.out.println("Device Id: "+data[0]+ "Device Name: "+ data[1]+"House id: "+ data[2]+"Area Id: "+ data[3]+"Room Id: "+data[4]+"Model: "+ data[5]+ "Type: "+ data[6]);                           
                   }
            }
        }catch(Exception e){
        }    
    }
            
    public static void main(String[] args) throws IOException{
        DeviceManager newDatabase = new DeviceManager();
        Device deviceTest = new Device("Ac", "aire perron", "casa1", "0", "0", "0", "samsung");
        newDatabase.addDevice(deviceTest);
        Device deviceTest2 = new Device("Tv", "tv perrona","casa1", "1", "1", "1", "Lg");
        newDatabase.addDevice(deviceTest2);
        newDatabase.printAllHouseDevices("casa1");
    }      
    
    public void addDevice(Device newDevice){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(deviceDatabase, true));        
            pw.append(newDevice.getDeviceId()+","+newDevice.getDeviceName()+","+newDevice.getHouseId()+","+newDevice.getAreaId()+","+newDevice.getRoomId()+","+newDevice.getModel()+","+newDevice.getType()+"\n");
            pw.close();
        }catch(Exception e){
            
        }   
    }
    
    public void removeDevice(String deviceId) throws FileNotFoundException, IOException{
        try{
        File tempFile = new File("tempDeviceDatabase.txt");        
        BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));        
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        
        while((currentLine = reader.readLine()) != null){
            Boolean wasFound = false;
            String data[] = new String[5];
            data=currentLine.split(",");
            for(int i = 0; i < 5; i++){                
                if(data[i].equals(deviceId)) wasFound = true;
            }
            if(!wasFound){
                writer.write(currentLine + System.getProperty("line.separator"));
            }            
        }
        writer.close();
        reader.close();
        deviceDatabase.delete();
        tempFile.renameTo(deviceDatabase);
        }catch(Exception e){
        }
    }
    
    public void setDevice(Device newDevice, String deviceId) throws FileNotFoundException, IOException{                
        File tempFile = new File("tempDeviceDatabase.txt");
        BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));        
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        
        boolean wasFound = false;
        
        while((currentLine = reader.readLine()) != null){
            String data[] = new String[5];
            data=currentLine.split(",");
            for(int i = 0; i < 5; i++){                
                if(data[i].equals(deviceId)){
                    String newLine = deviceId+","+newDevice.getDeviceName()+","+newDevice.getHouseId()+","+newDevice.getAreaId()+","+newDevice.getRoomId();
                    writer.write(newLine + System.getProperty("line.separator"));
                    wasFound = true;
                }
            }
            if(!wasFound){
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        }
        writer.close();
        reader.close();
        deviceDatabase.delete();
        tempFile.renameTo(deviceDatabase);
    }
    
    public Device getDevice(String deviceId) throws FileNotFoundException, IOException{
        Device foundDevice = null;
        try{
            File tempFile = new File("tempDeviceDatabase.txt");
            BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase)); 
            String currentLine;
     
            while((currentLine = reader.readLine()) !=  null){
                String data[] = new String[8];
                data = currentLine.split(",");
                for(int i = 0; i < 8; i++){
                    if(data[i].equals(deviceId)){
                        foundDevice = new Device(deviceId, data[1], data[2], data[3], data[4], data[5], data[6]);                            
                    }
                }
            }
            return foundDevice;
        }catch(Exception e){
            }    
        return foundDevice;
    }
}
