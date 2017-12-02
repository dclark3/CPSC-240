/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author drado_000
 */
public class FXMLOfficeManController implements Initializable {

    @FXML
    private TextField partToDisplayNameField;

    @FXML
    private TextArea partToDisplayTextAreaByName;

    @FXML
    private Button getPartInfoByNameButton;

    @FXML
    private TextField partToDisplayNumField;

    @FXML
    private TextArea partToDisplayTextAreaByNum;

    @FXML
    private Button getPartInfoByNumButton;

    @FXML
    private TextField startDateField;

    @FXML
    private TextField endDateField;

    @FXML
    private TextArea displayCommissionField;

    @FXML
    private TextField saleAssociateNameField;

    @FXML
    private Button generateCommissionButton;

    @FXML
    private Tab orderPartsTab;

    @FXML
    private TextArea displayTextField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Label nameLabel;

    @FXML
    private void logOutButtonMethod(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    
    @FXML
    private void partToDisplayNameMethod(ActionEvent event){
        String s = partToDisplayNameField.getText();
        Inventory p = BPD3.cmd.examinePart(s);
        if (p!=null){
            partToDisplayTextAreaByName.appendText(p.toString());
        }
        else {
            partToDisplayTextAreaByName.appendText("Part not found");
        }
    }
    
     @FXML
    private void partToDisplayNumMethod(ActionEvent event){
        int i = Integer.parseInt(partToDisplayNumField.getText());
        Inventory p1 = BPD3.cmd.examinePart(i);
        if (p1!=null){
            partToDisplayTextAreaByNum.appendText(p1.toString() + "\n");
        }
        else {
            partToDisplayTextAreaByNum.appendText("Part not found\n");
        }
    }
    
    @FXML
    void orderPartsTabMethod(Event event) {
        ArrayList <Inventory> parts = BPD3.mainWarehouse.getInventory();
        String partsToOrder = "";
        for (Inventory p : parts){
            if (p.getQuantity() <= BPD3.minQuantity+5){
                partsToOrder = p + "\n" + partsToOrder;
            }
        }
        displayTextField.setText(partsToOrder);
        
    }
    
    @FXML
    void getCommissionButtonMethod(ActionEvent event) {

    }
    
    @FXML
    void saveChangesMethod(ActionEvent event) {
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        
        BPD3.offMan.updateFName(fName);
        BPD3.offMan.updateLName(lName);
        BPD3.offMan.updateEmail(email);
        BPD3.offMan.updatePassword(password);
        
        firstNameField.setText(BPD3.offMan.getFName());
        lastNameField.setText(BPD3.offMan.getLName());
        emailField.setText(BPD3.offMan.getEmail());
        passwordField.setText(BPD3.offMan.getPassword());
        
        nameLabel.setText("Hello, "+ BPD3.offMan.getFName() + " " + BPD3.offMan.getLName());
        nameLabel.getText();
        
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameLabel.setText("Hello, "+ BPD3.offMan.getFName() + " " + BPD3.offMan.getLName());
        nameLabel.getText();
        firstNameField.setText(BPD3.offMan.getFName());
        lastNameField.setText(BPD3.offMan.getLName());
        emailField.setText(BPD3.offMan.getEmail());
        passwordField.setText(BPD3.offMan.getPassword());
    }    
    
}
