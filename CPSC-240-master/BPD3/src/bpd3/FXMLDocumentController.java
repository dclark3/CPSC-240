/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author drado_000
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private Label errorMsg;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        String u = usernameField.getText();
        String p = passwordField.getText();
        
        if (BPD3.admin.getAccount().getUsername().equals(u) || BPD3.admin.getAccount().getUsername().equals(u)){
            Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLSysAdmin.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }
        else if (BPD3.offMan.getAccount().getUsername().equals(u) || BPD3.offMan.getAccount().getUsername().equals(u)){
            Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLOfficeMan.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }
        else if (BPD3.wareMan.getAccount().getUsername().equals(u) || BPD3.wareMan.getAccount().getUsername().equals(u)){
            Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLWarehouseMan.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }
        else if (BPD3.sa.getAccount().getUsername().equals(u) || BPD3.sa.getAccount().getUsername().equals(u)){
            Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLSalesAssociate.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }
        else{
            errorMsg.setText("Username or password is incorrect");
            errorMsg.getText();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}