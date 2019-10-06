

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raulrivadeneyra
 */
public class HouseCRUD {
    public void addHouse(House house) throws IOException{
        BufferedWriter bw = new BufferedWriter( new FileWriter("database_house.txt",true) );
        bw.write(house.getHouseId()+";"+house.getHouseName()+":");
        for (String area : house.areas.keySet())
            bw.write(area + ",");
        bw.flush();
        bw.newLine();
        bw.close();
    }
    public void addArea(Area area) throws IOException{
        BufferedWriter bw = new BufferedWriter( new FileWriter("database_area.txt",true) );
        bw.write(area.getAreaId()+";"+area.getAreaName()+":");
        for (String room : area.rooms.keySet())
            bw.write(room + ",");
        bw.flush();
        bw.newLine();
        bw.close();
    }
    public void addRoom(Room room) throws IOException{
        BufferedWriter bw = new BufferedWriter( new FileWriter("database_room.txt",true) );
        bw.write(room.getRoomId()+";"+room.getRoomName()+":");
        for (String device : room.devices.keySet())
            bw.write(device + ",");
        bw.flush();
        bw.newLine();
        bw.close();
    }
    
    public void deleteHouse(String ID) throws IOException{
        deleteFunction(ID, "database_house_temp.txt", "database_house.txt");
    }
    public void deleteArea(String ID) throws IOException{
        deleteFunction(ID, "database_area_temp.txt", "database_area.txt");
    }
    public void deleteRoom(String ID) throws IOException{
        deleteFunction(ID, "database_room_temp.txt", "database_room.txt");
    }
    private void deleteFunction(String ID, String temp_path, String path) throws IOException{
        String record;
        File temp_db = new File(temp_path);
        temp_db.createNewFile();
        File db = new File(path);
        BufferedWriter bw = new BufferedWriter( new FileWriter(temp_path,true) );
        BufferedReader br = new BufferedReader( new FileReader(path) );
        bw.flush();
        while ( (record = br.readLine()) != null){
            if ( !record.contains(ID)){
                bw.write(record);
                bw.flush();
                bw.newLine();
            }
        }
        db.delete();
        temp_db.renameTo(db);
        bw.close();
        br.close();
    }

    public House searchHouse(String ID) throws IOException{
        String record;
        List<String> areasID;
        House temp_house = null;
        BufferedReader br = new BufferedReader( new FileReader("database_house.txt") );
        while ( (record = br.readLine()) != null){
            if ( record.contains(ID)){
                temp_house = new House(getName(record), getID(record));
                areasID = getListOfID(record);
                for (String temp : areasID) {
                    temp_house.areas.put(temp, searchArea(temp));	
                }
                break;
            }
        }
        br.close();
        return temp_house;
    }
    
    public Area searchArea(String ID) throws IOException{
        String record;
        List<String> roomID;
        Area temp_area = null;
        BufferedReader br = new BufferedReader( new FileReader("database_area.txt") );
        while ( (record = br.readLine()) != null){
            if ( record.contains(ID)){
                temp_area = new Area(getName(record), getID(record));
                roomID = getListOfID(record);
                for (String temp : roomID) {
                    temp_area.rooms.put(temp, searchRoom(temp));
                }
                break;
            }
        }
        br.close();
        return temp_area;
    }
    public Room searchRoom(String ID) throws IOException{
        String record;
        List<String> devicesID;
        Room temp_room = null;
        BufferedReader br = new BufferedReader( new FileReader("database_room.txt") );
        while ( (record = br.readLine()) != null){
            if ( record.contains(ID)){
                temp_room = new Room(getName(record), getID(record));
                devicesID = getListOfID(record);
                for (String temp : devicesID) {
                    temp_room.devices.put(temp, null); //NOT CORRECT
                }
                break;
            }
        }
        br.close();
        return temp_room;
    }
    private String getID(String text) throws IOException{
        return (text.substring(0, text.indexOf(';')));
    }
    private String getName(String text) throws IOException{
        return (text.substring(text.indexOf(';')+1, text.indexOf(':')));
    }
    private List<String> getListOfID(String text) throws IOException{
        List<String> stringList = null;
        int separator = text.indexOf(':');
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
    public static void main(String[] args) {
        HouseCRUD newcrud = new HouseCRUD();
        House temp = null;
        Room newRoom = new Room("Holis", "1337");
        try {
            temp = newcrud.searchHouse("1");
            System.out.println(temp.areas.get("1a").rooms.get("1r").getRoomName());
            newcrud.deleteArea("1a");
         
            newcrud.deleteRoom("2r");
            newcrud.addRoom(newRoom);
            newcrud.deleteHouse("1");
        } catch (IOException ex) {
            Logger.getLogger(HouseCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
}
