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
    public static SalesAssociate sa;
    public static Warehouse mainWarehouse;
    public static Fleet fleet;
    public static ArrayList <LoginAccount> accounts = new ArrayList<>();
    public static int minQuantity;
    public static Command cmd;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList <Warehouse> f = new ArrayList<>();
        
        mainWarehouse = new Warehouse("mainWarehouse");
        Warehouse van = new Warehouse("van");
        
        fleet = new Fleet(f);
        
        admin = new SysAdmin("joe", "schmo", "abc", "def", "email");
        offMan = new OfficeMan("jane", "doe", "ghi", "jkl", "email");
        wareMan = new WarehouseMan("","", "mno", "pqr", "email");
        sa = new SalesAssociate("", "", "stu", "vwx", "email", "whName", van);
        
        accounts.add(admin);
        accounts.add(offMan);
        accounts.add(wareMan);
        accounts.add(sa);
        
        minQuantity = 5;
        cmd = new Command();
        
        Inventory b1 = new Inventory("saddle", 12345, 4.99, 2.99, true, 6);
        Inventory b2 = new Inventory("peddle", 12343, 14.99, 12.99, false, 9);
        
        mainWarehouse.addPart(b1);
        mainWarehouse.addPart(b2);
        
        
        launch(args);
    }
    
    public static LoginAccount verifyUser(String username, String password){
        for (LoginAccount a: accounts){
            if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                return a;
            }
        }
        return null;
    }
    
}
