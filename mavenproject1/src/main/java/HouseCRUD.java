

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author raulrivadeneyra
 */
public class HouseCRUD {
    public void createHouse(House house) throws IOException{
        String record;
        BufferedReader br = new BufferedReader( new FileReader("database.txt") );
        BufferedWriter bw = new BufferedWriter( new FileWriter("database.txt",true) );
        
        while( ( record = br.readLine() ) != null ) {
            if( record.contains("-") ) {
                bw.write(house.getHouseId()+";"+house.getHouseName()+";");
    		bw.flush();
    		bw.newLine();
    		bw.close();
            }
        }
        br.close();
    }
    public void createFloor() throws IOException{
        String record;
        BufferedReader br = new BufferedReader( new FileReader("database.txt") );
        BufferedWriter bw = new BufferedWriter( new FileWriter("database.txt",true) );
        
        while( ( record = br.readLine() ) != null ) {
            if( record.contains("-") ) {
                //bw.write(house.ID+";"+house.name+";"+floorsID+";\n-");
    		bw.flush();
    		bw.newLine();
    		bw.close();
            }
        }
        br.close();
    }
    public void createRoom() throws IOException{
        
    }
    public void readHouse() throws IOException{
        
    }
    public void readFloor() throws IOException{
        
    }
    public void readRoom() throws IOException{
        
    }
    
    
}
