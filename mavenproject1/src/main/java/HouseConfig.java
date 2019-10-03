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
    private BufferedWriter bw;
    HouseConfig(House house){
        createFile();
        try {
            bw = new BufferedWriter( new FileWriter("database.txt",true) );
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            initializeDB(house);
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void createFile(){
        try {
            File data_base = new File("database.txt");
            if (data_base.createNewFile())
            {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException ex) {
            Logger.getLogger(HouseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initializeHouse(House house) throws IOException{
        //Sets the House Table
        bw.write("#House\n");
        bw.flush();
        bw.write(house.getHouseId()+";"+house.getHouseName()+";");
        for (String area : house.areas.keySet())
            bw.write(area + ",");
        bw.flush();
        bw.newLine();
    }
    private void initializeArea(House house) throws IOException{
        //Sets the Area Table
        bw.write("#Area\n");
        bw.flush();
        for (Map.Entry<String,Area> entry : house.areas.entrySet()){
            bw.write(entry.getKey() + ";" + entry.getValue().getAreaName() + ";");
            for (String room : entry.getValue().rooms.keySet()) 
                bw.write(room + ",");
            bw.flush();
            bw.newLine();
        }
    }
    private void initializeRoom(House house) throws IOException{
         //Sets the Rooms Table
        bw.write("#Rooms\n");
        bw.flush();
        for (Map.Entry<String,Area> area_ : house.areas.entrySet()){
            for (Map.Entry<String,Room> room_ : area_.getValue().rooms.entrySet()){
                bw.write(room_.getKey() + ";" + room_.getValue().getRoomName() + ";");
                for (String device : room_.getValue().devices.keySet())
                    bw.write(device + ",");
                bw.flush();
                bw.newLine();
            }   
        }
    }
    private void initializeDB(House house) throws IOException {
        String record;
        boolean jump = false;
        BufferedReader br = new BufferedReader( new FileReader("database.txt") );
        while( ( record = br.readLine() ) != null ) {
            if( record.contains("#House") ) {
                jump = true;
            }
        }
        if (!jump){
            initializeHouse(house);
            initializeArea(house);
            initializeRoom(house);
            bw.close();
            System.out.println("File initialized.");
        }else{
            System.out.println("File already initialized.");
        }	
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
