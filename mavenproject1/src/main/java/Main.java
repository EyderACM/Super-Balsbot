
import java.io.IOException;
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
public class Main{
    public static void main(String[] args){
        /**try {       
            DeviceManager.main(null);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //DeviceManager.main(null); 
       FeatureHierarchy.main(null);
       HouseConfig.main(null);
       HouseCRUD.main(null);
    }
}
