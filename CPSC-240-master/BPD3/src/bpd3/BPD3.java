/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

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
        
        admin = new SysAdmin("abc", "def");
        offMan = new OfficeMan("ghi", "jkl");
        wareMan = new WarehouseMan("mno", "pqr");
        sa = new SalesAssociate("stu", "vwx");
        
        launch(args);
    }
    
}
