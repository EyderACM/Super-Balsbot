
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
    public static void main(String[] args) throws IOException{
        DeviceManager newDatabase = new DeviceManager();
        newDatabase.addDevice();
        newDatabase.removeDevice("APPLE123");
        newDatabase.addDevice();
        newDatabase.setDevice("APPLE123");
        
    }      
    
    public void addDevice(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(deviceDatabase, true));        
            String deviceId = "APPLE123";
            String deviceName = "Apple Home";
            String houseId = "casa123";
            String areaId = "area123";
            String roomId = "room123";
            pw.append(deviceId+","+deviceName+","+houseId+","+areaId+","+roomId);
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
    
    public void setDevice(String deviceId) throws FileNotFoundException, IOException{        
        String deviceName = "Apple max max";
        String houseId = "casa123";
        String areaId = "area123";
        String roomId = "room123";
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
                    String newLine = deviceId+","+deviceName+","+houseId+","+areaId+","+roomId;
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
    
    public void getDevice(String deviceId){
        
    }
}
