/**
 *
 * @author raulrivadeneyra
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;

public class HouseConfig {
    HouseConfig(House house){
        createFile();
        try {
            initializeDB(house);
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void createFile(){
        try {
            File database_house = new File("database_house.txt");
            File database_area = new File("database_area.txt");
            File database_room = new File("database_room.txt");
            
            if (database_house.createNewFile())
            {
                System.out.println("House DB is created!");
            } else {
                System.out.println("House DB already exists.");
            }
            if (database_area.createNewFile())
            {
                System.out.println("Area DB is created!");
            } else {
                System.out.println("Area DB already exists.");
            }
            if (database_room.createNewFile())
            {
                System.out.println("Room DB is created!");
            } else {
                System.out.println("Room DB already exists.");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initializeHouse(House house) throws IOException{
        BufferedWriter bw = new BufferedWriter( new FileWriter("database_house.txt",true) );
        BufferedReader br = new BufferedReader(new FileReader("database_house.txt"));
        //Sets the House Table
        if (br.readLine() == null){
            bw.write(house.getHouseId()+";"+house.getHouseName()+":");
            for (String area : house.areas.keySet())
                bw.write(area + ",");
            bw.flush();
            bw.newLine();
            
        }
        bw.close();
        br.close();
    }
    private void initializeArea(House house) throws IOException{
        BufferedWriter bw = new BufferedWriter( new FileWriter("database_area.txt",true) );
        BufferedReader br = new BufferedReader(new FileReader("database_area.txt"));
        //Sets the Area Table
        if (br.readLine() == null){
            for (Map.Entry<String,Area> entry : house.areas.entrySet()){
                bw.write(entry.getKey() + ";" + entry.getValue().getAreaName() + ":");
                for (String room : entry.getValue().rooms.keySet()) 
                    bw.write(room + ",");
                bw.flush();
                bw.newLine();
            }   
        }
        br.close();
        bw.close();
    }
    private void initializeRoom(House house) throws IOException{
        //Sets the Rooms Table
        BufferedWriter bw = new BufferedWriter( new FileWriter("database_room.txt",true) );
        BufferedReader br = new BufferedReader(new FileReader("database_room.txt"));
        if (br.readLine() == null){
            for (Map.Entry<String,Area> area_ : house.areas.entrySet()){
                for (Map.Entry<String,Room> room_ : area_.getValue().rooms.entrySet()){
                    bw.write(room_.getKey() + ";" + room_.getValue().getRoomName() + ":");
                    for (String device : room_.getValue().devices.keySet())
                        bw.write(device + ",");
                    bw.flush();
                    bw.newLine();
                }   
            }
        }
        br.close();
        bw.close();
    }
    private void initializeDB(House house) throws IOException {

        initializeHouse(house);
        initializeArea(house);
        initializeRoom(house);
        	
    }
    public static void main(String[] args) {
        House firstHouse = new House("Casita", "1");
        Area firstArea = new Area("Level", "1a");
        Area secondArea = new Area("OtherLevel", "2a");
        Room firstRoom = new Room("newRoom", "1r");
        Room secondRoom = new Room("secondRoom", "2r");
        firstArea.addRoom(firstRoom);
        secondArea.addRoom(secondRoom);
        firstHouse.addArea(firstArea);
        firstHouse.addArea(secondArea);
        HouseConfig firstDB = new HouseConfig(firstHouse);
    }
}
