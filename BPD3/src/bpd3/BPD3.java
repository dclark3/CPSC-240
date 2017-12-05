/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author drado_000
 */

public class BPD3 extends Application {
    
    public static SysAdmin admin;
    public static OfficeMan offMan;
    public static WarehouseMan wareMan;
    public static SalesAssociate sa1;
    public static SalesAssociate sa2;
    public static SalesAssociate sa3;
    public static Warehouse mainWarehouse;
    public static Fleet fleet;
    public static ArrayList <LoginAccount> accounts = new ArrayList<>();
    public static Command cmd;
    
    /** starts all the methods for the fx
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /** main method for the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList <Warehouse> f = new ArrayList<>();
     
        fleet = new Fleet(f);  
        mainWarehouse = new Warehouse("mainWarehouse");
        Warehouse van = new Warehouse("van"); 
        fleet.addWarehouse(mainWarehouse);
        fleet.addWarehouse(van); 
        
        admin = new SysAdmin("joe", "schmo", "admin", "abc", "email");
        offMan = new OfficeMan("jane", "doe", "office", "abc", "email");
        wareMan = new WarehouseMan("Sonny","Son", "ware", "abc", "email");
        sa1 = new SalesAssociate("Bob", "Barnes", "sa1", "abc", "email", "whName", van);
        sa2 = new SalesAssociate("Sandra", "Sandy", "sa2", "abc", "email", "whName", van);
        sa3 = new SalesAssociate("Drew", "Donald", "sa3", "def", "email", "whName", van);
        
        accounts.add(admin);
        accounts.add(offMan);
        accounts.add(wareMan);
        accounts.add(sa1);
        accounts.add(sa2);
        accounts.add(sa3);
        
        cmd = new Command();
        
        Inventory b1 = new Inventory("saddle", 12345, 4.99, 2.99, true, 23784);
        Inventory b2 = new Inventory("peddle", 12343, 14.99, 12.99, false, 9);
        
        mainWarehouse.addPart(b1);
        mainWarehouse.addPart(b2);
        
        launch(args);
    }
    
    /**Verifies the users information is correct
     * 
     * @param username
     * @param password
     * @return a loginAccount
     */
    public static LoginAccount verifyUser(String username, String password){
        for (LoginAccount a: accounts){
            if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                return a;
            }
        }
        return null;
    }
    
}
