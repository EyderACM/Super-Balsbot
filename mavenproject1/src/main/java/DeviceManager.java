
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

    DeviceManager() {
        this.deviceDatabase = new File("deviceDatabase.txt");
    }

    public static void main(String[] args) throws IOException {
        House Casa = new House("Rafa's House", "0");
        Area Cuarto = new Area("Rafa's Room", "0");
        Room Recamara = new Room("Rafa's Bedroom", "0");
        Room Sanitario = new Room("Rafa's Bathroom", "1");
        AcPanasonic Aire = new AcPanasonic("AC", "Aire feo", "0", "0", "0", "0", "Panasonic", "Apagado");
        AcSamsung Aire2 = new AcSamsung("AC", "Aire bonito", "0", "0", "0", "1", "Samsung", "Encendido");
        TvLg Tv1 = new TvLg("TV", "Tele fea", "0", "0", "1", "0", "LG", "Apagado");
        
        Casa.addArea(Cuarto);
        Casa.getArea("0").addRoom(Recamara);
        Casa.getArea("0").addRoom(Sanitario);
        Casa.getArea("0").getRoom("0").addDevice(Aire);
        Casa.getArea("0").getRoom("0").addDevice(Aire2);
        Casa.getArea("0").getRoom("1").addDevice(Tv1);
        
        System.out.println("Imprimir todo: ");
        System.out.println("Casa Name: " + Casa.getHouseName());
        Casa.printAreas();
        
        System.out.println("");
        System.out.println("¿Cuántos dispositivos hay encendidos?: " + Casa.howManyTurnOn());
        
        System.out.println("");
        System.out.println("Encender/apagar todo en una habitacion: ");
        System.out.println("    Encendiendo (HabitacionId = 0): ");
        Casa.getArea("0").getRoom("0").turnOnAllDevices();
        System.out.println("Casa Name: " + Casa.getHouseName());
        Casa.printAreas();
        System.out.println("¿Cuántos dispositivos hay encendidos?: " + Casa.howManyTurnOn());
        System.out.println("");
        System.out.println("    Apagando (HabitacionId = 0): ");
        Casa.getArea("0").getRoom("0").turnOffAllDevices();
        System.out.println("Casa Name: " + Casa.getHouseName());
        Casa.printAreas();
        System.out.println("¿Cuántos dispositivos hay encendidos?: " + Casa.howManyTurnOn());
        
        System.out.println("");
        System.out.println("¿Cuántos AC hay en la casa?: " + Casa.howManyAC());
        System.out.println("¿Cuántos TV hay en la casa?: " + Casa.howManyTV());
        System.out.println("¿Cuántos Lights hay en la casa?: " + Casa.howManyLights());
        
        System.out.println("");
    }

    public void addDevice(Device newDevice) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(deviceDatabase, true));
            pw.append(newDevice.getDeviceType() + "," + newDevice.getDeviceName() + "," + newDevice.getHouseId() + "," + newDevice.getAreaId() + "," + newDevice.getRoomId() + "," + newDevice.getDeviceId() + "," + newDevice.getModel() + "," + newDevice.getStatus() + "\n");
            pw.close();
        } catch (Exception e) {

        }
    }

    public void removeDevice(String deviceId) throws FileNotFoundException, IOException {
        try {
            File tempFile = new File("tempDeviceDatabase.txt");
            BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                Boolean wasFound = false;
                String data[] = new String[6];
                data = currentLine.split(",");
                for (int i = 0; i < 6; i++) {
                    if (data[i].equals(deviceId)) {
                        wasFound = true;
                    }
                }
                if (!wasFound) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            deviceDatabase.delete();
            tempFile.renameTo(deviceDatabase);
        } catch (Exception e) {
        }
    }

    public void setDevice(Device newDevice, String deviceId) throws FileNotFoundException, IOException {
        File tempFile = new File("tempDeviceDatabase.txt");
        BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;

        boolean wasFound = false;

        while ((currentLine = reader.readLine()) != null) {
            String data[] = new String[7];
            data = currentLine.split(",");
            for (int i = 0; i < 6; i++) {
                if (data[i].equals(deviceId)) {
                    String newLine = newDevice.getDeviceType() + "," + newDevice.getDeviceName() + "," + newDevice.getHouseId() + "," + newDevice.getAreaId() + "," + newDevice.getRoomId() + "," + newDevice.getDeviceId() + "," + newDevice.getModel() + "," + newDevice.getStatus() + "\n";
                    writer.write(newLine + System.getProperty("line.separator"));
                    wasFound = true;
                }
            }
            if (!wasFound) {
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        }
        writer.close();
        reader.close();
        deviceDatabase.delete();
        tempFile.renameTo(deviceDatabase);
    }

    public Device getDevice(String deviceId) throws FileNotFoundException, IOException {
        Device foundDevice = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String data[] = new String[6];
                data = currentLine.split(",");
                for (int i = 0; i < 7; i++) {
                    if (data[i].equals(deviceId)) {
                        foundDevice = new Device(data[0], data[1], data[2], data[3], data[4], deviceId, data[5], data[6]);
                    }
                }
            }
            return foundDevice;
        } catch (Exception e) {
        }
        return foundDevice;
    }

}


/*
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
/**
 * public class DeviceManager {
 *
 * private final File deviceDatabase;
 *
 * DeviceManager(){ this.deviceDatabase = new File("deviceDatabase.txt"); }
 *
 * public static void main(String[] args) throws IOException{ House Casa = new
 * House("Rafa's House", "0"); Area Cuarto = new Area("Rafa's Room", "0"); Room
 * Recamara = new Room("Rafa's Bedroom", "0"); Room Sanitario = new Room("Rafa's
 * Bathroom", "1"); AcPanasonic Aire = new AcPanasonic("AC", "Aire feo", "0",
 * "0", "0", "0", "Panasonic", "Apagado"); AcSamsung Aire2 = new AcSamsung("AC",
 * "Aire bonito", "0", "0", "0", "1", "Samsung", "Encendido");
 *
 * Casa.addArea(Cuarto); Casa.getArea("0").addRoom(Recamara);
 * Casa.getArea("0").addRoom(Sanitario);
 * Casa.getArea("0").getRoom("0").addDevice(Aire);
 * Casa.getArea("0").getRoom("0").addDevice(Aire2);
 *
 * System.out.println("Imprimir todo: "); System.out.println("Casa Name: " +
 * Casa.getHouseName()); Casa.printAreas();
 *
 * System.out.println(""); System.out.println("Encender/apagar todo en una
 * habitacion: "); System.out.println(" Encendiendo: ");
 * Casa.getArea("0").getRoom("0").turnOnAllDevices(); System.out.println("Casa
 * Name: " + Casa.getHouseName()); Casa.printAreas(); System.out.println("");
 * System.out.println(" Apagando: ");
 * Casa.getArea("0").getRoom("0").turnOffAllDevices(); System.out.println("Casa
 * Name: " + Casa.getHouseName()); Casa.printAreas(); }  *
 * public void addDevice(Device newDevice){ try { try (PrintWriter pw = new
 * PrintWriter(new FileOutputStream(deviceDatabase, true))) {
 * pw.append(newDevice.getDeviceType()+","+newDevice.getDeviceName()+","+newDevice.getHouseId()+","+newDevice.getAreaId()+","+newDevice.getRoomId()+","+newDevice.getDeviceId()+","+newDevice.getModel()+","+newDevice.getStatus()+"\n");
 * } }catch(Exception e){
 *
 * }
 * }
 *
 * public void removeDevice(String deviceId) throws FileNotFoundException,
 * IOException{ try{ File tempFile = new File("tempDeviceDatabase.txt"); try
 * (BufferedReader reader = new BufferedReader(new FileReader(deviceDatabase));
 * BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
 * String currentLine;
 *
 * while((currentLine = reader.readLine()) != null){ Boolean wasFound = false;
 * String data[] = new String[8]; data=currentLine.split(","); for(int i = 0; i
 * < 5; i++){ if(data[i].equals(deviceId)) wasFound = true; } if(!wasFound){
 * writer.write(currentLine + System.getProperty("line.separator")); } } }
 * deviceDatabase.delete(); tempFile.renameTo(deviceDatabase); }catch(Exception
 * e){ } }
 *
 * public void setDevice(Device newDevice, String deviceId) throws
 * FileNotFoundException, IOException{ File tempFile = new
 * File("tempDeviceDatabase.txt"); BufferedReader reader = new
 * BufferedReader(new FileReader(deviceDatabase)); BufferedWriter writer = new
 * BufferedWriter(new FileWriter(tempFile)); String currentLine;
 *
 * boolean wasFound = false;
 *
 * while((currentLine = reader.readLine()) != null){ String data[] = new
 * String[8]; data=currentLine.split(","); for(int i = 0; i < 8; i++){
 * if(data[i].equals(deviceId)){ String newLine =
 * newDevice.getDeviceType()+","+newDevice.getDeviceName()+","+newDevice.getHouseId()+","+newDevice.getAreaId()+","+newDevice.getRoomId()+","+newDevice.getDeviceId()+","+newDevice.getModel()+","+newDevice.getStatus()+"\n";
 * writer.write(newLine + System.getProperty("line.separator")); wasFound =
 * true; } } if(!wasFound){ writer.write(currentLine +
 * System.getProperty("line.separator")); } } writer.close(); reader.close();
 * deviceDatabase.delete(); tempFile.renameTo(deviceDatabase); }
 *
 * public Device getDevice(String deviceId) throws FileNotFoundException,
 * IOException{ Device foundDevice = null; try{ File tempFile = new
 * File("tempDeviceDatabase.txt"); BufferedReader reader = new
 * BufferedReader(new FileReader(deviceDatabase)); String currentLine;
 *
 * while((currentLine = reader.readLine()) != null){ String data[] = new
 * String[7]; data = currentLine.split(","); for(int i = 0; i < 6; i++){
 * if(data[i].equals(deviceId)){ foundDevice = new Device(data[0], data[1],
 * data[2], data[3], data[4], deviceId, data[5], data[6]); } } } return
 * foundDevice; }catch(Exception e){ } return foundDevice; }
}
 */
