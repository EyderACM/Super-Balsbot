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
    private static BufferedWriter bw;
    private static BufferedReader br;
    HouseConfig(House house){
        try {
            bw = new BufferedWriter( new FileWriter("database.txt",true) );
            br = new BufferedReader(new FileReader("database.txt"));
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        createFile();
        try {
            initializeDB(house);
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void createFile(){
        try {
            File database = new File("database.txt");

            if (database.createNewFile())
            {
                System.out.println("DB is created!");
            } else {
                System.out.println("DB already exists.");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initializeHouse(House house) throws IOException{
        //Sets the House Table
        bw.write("#\n");
        if (br.readLine() == null){
            bw.write(house.getHouseId()+"/"+house.getHouseName()+"|");
            for (String area : house.areas.keySet())
                bw.write(area + ",");
            bw.newLine();
            
        }
    }
    private void initializeArea(House house) throws IOException{
        //Sets the Area Table
        bw.write("#\n");
        if (br.readLine() == null){
            for (Map.Entry<String,Area> entry : house.areas.entrySet()){
                bw.write(entry.getKey() + "/" + entry.getValue().getAreaName() + "|");
                for (String room : entry.getValue().rooms.keySet()) 
                    bw.write(room + ",");
                bw.newLine();
            }   
        }
    }
    private void initializeRoom(House house) throws IOException{
        //Sets the Rooms Table
        bw.write("#\n");
        if (br.readLine() == null){
            for (Map.Entry<String,Area> area_ : house.areas.entrySet()){
                for (Map.Entry<String,Room> room_ : area_.getValue().rooms.entrySet()){
                    bw.write(room_.getKey() + "/" + room_.getValue().getRoomName() + "|");
                    for (String device : room_.getValue().devices.keySet())
                        bw.write(device + ",");
                    bw.newLine();
                }   
            }
        }
        
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
        try {
            br.close();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
