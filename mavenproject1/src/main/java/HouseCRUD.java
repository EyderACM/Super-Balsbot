

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raulrivadeneyra
 */
public class HouseCRUD {
    private static BufferedWriter bw;
    public static List<House> houses = new ArrayList();;
    HouseCRUD() throws IOException{
        bw = new BufferedWriter( new FileWriter("database.txt",true) );
        getDataBase();
    }
    public static void updateHouse(String ID, String newName){
        for (House houseList : houses){
            if (houseList.getHouseId().equals(ID)){
                houseList.setHouseName(newName);
                break;
            }
        }
    }
    public static void updateArea(String ID, String newName){
        for (House houseList : houses){
            for(Area areaMap : houseList.areas.values()){
                if (areaMap.getAreaId().equals(ID)){
                    areaMap.setAreaName(newName);
                }
            }
        }
    }
    public static void updateRoom(String ID, String newName){
        for (House houseList : houses){
            for(Area areaMap : houseList.areas.values()){
                for(Room roomMap : areaMap.rooms.values()){
                    if (roomMap.getRoomId().equals(ID)){
                        roomMap.setRoomName(newName);
                        break;
                    }
                }
            }
        }
    }
    public static void addHouse(House temp){
        houses.add(temp);
    }
    public static void addArea(Area temp, String houseID){
        for (House houseList : houses){
            if (houseList.getHouseId().equals(houseID)){
                houseList.areas.put(temp.getAreaId(), temp);
            }
        }
    }
    public static void addRoom(Room temp, String houseID, String areaID){
        for (House houseList : houses){
            if (houseList.getHouseId().equals(houseID)){
                for(Area areaMap : houseList.areas.values()){
                    if(areaMap.getAreaId().equals(areaID)){
                        areaMap.rooms.put(temp.getRoomId(),temp);
                    }
                }
            }
        }
    }
    public static void deleteHouse(String ID){
        int index = 0;
        for (House houseList : houses){
            if (houseList.getHouseId().equals(ID)){
                houses.remove(index);
                break;
            }
            index++;
        }
    }
    public static void deleteArea(String ID){
        for (House houseList : houses){
            for(Area areaMap : houseList.areas.values()){
                if (areaMap.getAreaId().equals(ID)){
                    houseList.areas.remove(areaMap.getAreaId());

                }
            }
        }
    }
    public static void deleteRoom(String ID){
        for (House houseList : houses){
            for(Area areaMap : houseList.areas.values()){
                for(Room roomMap : areaMap.rooms.values()){
                    if (roomMap.getRoomId().equals(ID)){
                        areaMap.rooms.remove(roomMap.getRoomId());
                        break;
                    }
                }
            }
        }
    }
    public House readHouse(String ID){
        House temp = null;
        for (House houseList : houses){
            if (houseList.getHouseId().equals(ID)){
                temp = houseList;
                break;
            }
        }
        return temp;
    }
    public Area readArea(String ID){
        Area temp = null;
        for (House houseList : houses){
            for(Area areaMap : houseList.areas.values()){
                if (areaMap.getAreaId().equals(ID)){
                    temp = areaMap;
                    break;
                }
            }
        }
        return temp;
    }
    public static Room readRoom(String ID){
        Room temp = null;
        for (House houseList : houses){
            for(Area areaMap : houseList.areas.values()){
                for(Room roomMap : areaMap.rooms.values()){
                    if (roomMap.getRoomId().equals(ID)){
                        temp = roomMap;
                        break;
                    }
                }
            }
        }
        return temp;
    }
    
    private void getDataBase() throws IOException{
        String record;
        BufferedReader br = new BufferedReader( new FileReader("database.txt") );
        while ( (record = br.readLine()) != null){
            if ( !record.contains("#")){
                houses.add(getHouse(record));
            }
        }
    }
    private House getHouse(String record) throws IOException{
        List<String> areasID;
        House temp_house = new House(getID(record),getName(record));
        areasID = getListOfID(record);
        for (String temp : areasID) {
            temp_house.areas.put(temp, searchArea(temp));	
        }
        return temp_house;
    }
    
    public Area searchArea(String ID) throws IOException{
        BufferedReader br = new BufferedReader( new FileReader("database.txt") );
        String record;
        List<String> roomID;
        Area temp_area = null;
        int sharpcount = 0;
        while ( (record = br.readLine()) != null){
            if (!record.contains("#")){
                if (sharpcount == 2){
                    if ( record.contains(ID)){
                        temp_area = new Area(getName(record), getID(record));
                        roomID = getListOfID(record);
                        for (String temp : roomID) {
                            temp_area.rooms.put(temp, searchRoom(temp));
                        }
                        break;
                    }
                }
            }else{
                sharpcount++;
            }
        }
        br.close();
        return temp_area;
    }
    public Room searchRoom(String ID) throws IOException{
        BufferedReader br = new BufferedReader( new FileReader("database.txt") );
        String record;
        List<String> devicesID;
        Room temp_room = null;
        int sharpcount = 0;
        while ( (record = br.readLine()) != null){
            if (!record.contains("#")){
                if (sharpcount == 3){
                    if ( record.contains(ID)){
                        temp_room = new Room(getName(record), getID(record));
                        devicesID = getListOfID(record);
                        for (String temp : devicesID) {
                            temp_room.devices.put(temp, null);
                        }
                        break;
                    }
                }
            }else{
                sharpcount++;
            }
        }
        br.close();
        return temp_room;
    }
    private String getID(String text) throws IOException{
        return (text.substring(0, text.indexOf('/')));
    }
    private String getName(String text) throws IOException{
        return (text.substring(text.indexOf('/')+1, text.indexOf('|')));
    }
    private List<String> getListOfID(String text) throws IOException{
        List<String> stringList = null;
        int separator = text.indexOf('|');
        if ((separator + 1) <= text.length()){
            stringList = new ArrayList();
            text = text.substring(separator + 1);
            while(text.length() > 0){
                separator = text.indexOf(',');
                stringList.add(text.substring(0, separator));
                text = text.substring(separator + 1);
            }
        }
        return stringList;
    }
    public static void main(String[] args){
        HouseCRUD newcrud;
        try {
            newcrud = new HouseCRUD();
            if (readRoom("2r") == null){
                System.out.println("Doesnt exists");
            }else{
                System.out.println("Exists");
            }
            deleteRoom("2r");
            if (readRoom("2r") == null){
                System.out.println("Doesnt exists");
            }else{
                System.out.println("Exists");
            }
        } catch (IOException ex) {
            Logger.getLogger(HouseCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }   
}
