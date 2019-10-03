
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
            
    public static void main(String[] args) throws IOException{
        Device deviceSimple = new Device("Ventilador", "casa123", "area123", "cuarto123", "ventilador12", "12", "AC");       
        Device deviceTwo = new Device("Super ventilador", "casa123", "area1", "cuarto45", "ventilador12", "123", "TV");
        deviceSimple.turnOn();
        deviceTwo.turnOn();
        DeviceManager newDatabase = new DeviceManager();        
        newDatabase.addDevice(deviceSimple);
        newDatabase.addDevice(deviceTwo);            
        newDatabase.printAllInHouse("casa123");
        System.out.println(newDatabase.howManyTurnedOn());
        System.out.println(newDatabase.howManyOfType("AC"));
    }      
    
    public void addDevice(Device newDevice){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(deviceDatabase, true));        
            pw.append(newDevice.getDeviceId()+","+newDevice.getDeviceName()+","+newDevice.getHouseId()+","+newDevice.getAreaId()+","+newDevice.getRoomId()+","+newDevice.getModel()+","+newDevice.getDeviceStatus()+","+newDevice.getDeviceType()+"\n");
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
            String data[] = new String[6];
            data=currentLine.split(",");
            for(int i = 0; i < 6; i++){                
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
            String data[] = new String[6];
            data=currentLine.split(",");
            for(int i = 0; i < 6; i++){                
                if(data[i].equals(deviceId)){
                    String newLine = deviceId+","+newDevice.getDeviceName()+","+newDevice.getHouseId()+","+newDevice.getAreaId()+","+newDevice.getRoomId()+","+newDevice.getModel()+","+newDevice.getDeviceStatus();
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
            BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase)); 
            String currentLine;
     
            while((currentLine = reader.readLine()) !=  null){
                String data[] = new String[6];
                data = currentLine.split(",");
                for(int i = 0; i < 6; i++){
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
    
    public int howManyTurnedOn() throws FileNotFoundException, IOException{        
        BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));        
        String currentLine;
        int turnedOn = 0;
        
        while((currentLine = reader.readLine()) != null){
            String data[] = new String[6];
            data = currentLine.split(",");            
            if(data[6].equals(DeviceStatus.TURNED_ON.toString())) turnedOn++;
        }
        return turnedOn;
    };   
    
    public int howManyOfType(String deviceType) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));        
        String currentLine;
        int deviceQuantity = 0;
        
        while((currentLine = reader.readLine()) != null){
            String data[] = new String[6];
            data = currentLine.split(",");            
            if(data[7].equals(deviceType)) deviceQuantity++;
        }
        return deviceQuantity;
    };
    
    public void printAllInHouse(String houseId) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));
        String currentLine;
        
        while((currentLine = reader.readLine()) != null){
            String data[] = new String[7];
            data = currentLine.split(",");
            if(data[2].equals(houseId)){
                System.out.println("Device ID:" + data[0]+"\n");
                System.out.println("Device Name:" + data[1]+"\n");
                System.out.println("Device Model:" + data[4]+"\n");
                System.out.println("Device Status:" + data[6]+"\n");
                System.out.println("Device Type:" + data[7]+"\n");
            }
        }
    }
}
