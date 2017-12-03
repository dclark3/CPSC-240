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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author christina
 */
public class FXMLSysAdminController implements Initializable {

    @FXML
    private Button logOutButton;
    @FXML
    private TextField userOfficeMan;
    @FXML
    private Button checkOfficeMan;
    @FXML
    private Label OfficeManlabel;
    @FXML
    private TextField firstnameOfficeMan;
    @FXML
    private TextField lastnameOfficeMan;
    @FXML
    private TextField emailOfficeMan;
    @FXML
    private Button createOfficeMan;
    @FXML
    private PasswordField passOfficeMan;
    @FXML
    private PasswordField confirmpassOfficeMan;
    @FXML
    private Label createOfficeManlabel;
    @FXML
    private TextField userWHman;
    @FXML
    private Button checkWHman;
    @FXML
    private TextField firstnameWHman;
    @FXML
    private TextField lastnameWHman;
    @FXML
    private TextField emailWHman;
    @FXML
    private Button createWHman;
    @FXML
    private Label WHmanuserlabel;
    @FXML
    private PasswordField passWHman;
    @FXML
    private PasswordField confirmpassWHman;
    @FXML
    private Label createWHmanlabel;
    @FXML
    private TextField userSA;
    @FXML
    private Button checkSA;
    @FXML
    private TextField firstnameSA;
    @FXML
    private TextField lastnameSA;
    @FXML
    private TextField emailSA;
    @FXML
    private Button createSA;
    @FXML
    private Label SAlabel;
    @FXML
    private TextField SVname;
    @FXML
    private Button checkSV;
    @FXML
    private Label SVlabel;
    @FXML
    private PasswordField passSA;
    @FXML
    private PasswordField confirmpassSA;
    @FXML
    private Label createSAlabel;
    @FXML
    private TextField changepassUser;
    @FXML
    private Button changepass;
    @FXML
    private Label changepasslabel;
    @FXML
    private PasswordField newpass;
    @FXML
    private PasswordField confirmnewpass;
    @FXML
    private TextField deleteuser;
    @FXML
    private Button confirmdeleteuser;
    @FXML
    private Label deleteuserlabel;
    @FXML
    private PasswordField systemadminpass;
    @FXML
    private PasswordField confirmsystemadminpass;
    @FXML
    private TextField changefirstname;
    @FXML
    private TextField changelastname;
    @FXML
    private TextField changeemail;
    @FXML
    private Button changeuserinfo;
    
    
    @FXML
    private void logOutButtonMethod(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    
    
    
    private void checkOfficeMan(ActionEvent event) throws IOException {
      String oun = userOfficeMan.getText();
      if (oun.equals(BPD3.offMan.getUsername())) {
          OfficeManlabel.setText("Sorry, user already exists");
           }
      else {
          OfficeManlabel.setText("Name available");
    } }
 private void createOfficeMan(ActionEvent event) {
     String opw = passOfficeMan.getText();
     String confirmopw = confirmpassOfficeMan.getText();
     if (opw.equals(confirmopw)) {
         String oemail = emailOfficeMan.getText();
         String ofname = firstnameOfficeMan.getText();
         String olname = lastnameOfficeMan.getText();
     }
     else {
         createOfficeManlabel.setText("Passwords do not match!");
             
     } 
}
 private void checkWHman(ActionEvent event) throws IOException {
      String whun = userWHman.getText();
      if (whun.equals(BPD3.wareMan.getUsername())) {
          WHmanuserlabel.setText("Sorry, user already exists");
           }
      else {
          WHmanuserlabel.setText("Name available");
    } }
  private void createWHman(ActionEvent event) {
     String whpw = passWHman.getText();
     String confirmwhpw = confirmpassWHman.getText();
     if (whpw.equals(confirmwhpw)) {
         String whemail = emailWHman.getText();
         String whfname = firstnameWHman.getText();
         String whlname = lastnameWHman.getText();
         createWHmanlabel.setText("New Warehouse Manager Created!");
     }
     else {
         createWHmanlabel.setText("Passwords do not match!");
         
   
     } 
}
  private void checkSA(ActionEvent event) throws IOException {
      String saun = userSA.getText();
      if (saun.equals(BPD3.sa.getUsername())) {
          SAlabel.setText("Sorry, user already exists");
           }
      else {
          SAlabel.setText("Name available");
    } }
  
  private void checkSV(ActionEvent event) throws IOException {
      String SV = SVname.getText();
      if (SV.equals(BPD3.sa.getUsername())) {
          SVlabel.setText("Sorry, van already exists");
           }
      else {
          SVlabel.setText("Name available");
    } }  
  private void createSA(ActionEvent event) {
     String sapw = passSA.getText();
     String confirmsapw = confirmpassSA.getText();
     if (sapw.equals(confirmsapw)) {
         String saemail = emailSA.getText();
         String safname = firstnameSA.getText();
         String salname = lastnameSA.getText();
         createSAlabel.setText("New Sales Associate Created!");
     }
     else {
         createSAlabel.setText("Passwords do not match!");
         
   
     } 
}
  private void changePass() {
      String user = changepassUser.getText();
      String newpw = newpass.getText();
      String confirmnewpw = confirmnewpass.getText();
      if (newpw.equals(confirmnewpw)) {
      changepasslabel.setText("Change of password successful!");
  }
      else {
       changepasslabel.setText("Passwords do not match!");   
      }
  }
  private void confirmdeleteuser(ActionEvent event) {
      String delete = deleteuser.getText();
      String adminpass = systemadminpass.getText();
      String confirmadminpass = confirmsystemadminpass.getText();
      if (adminpass.equals(confirmadminpass)) {
          deleteuserlabel.setText( delete + " successfully deleted!");
      }
      else {
          deleteuserlabel.setText("System admin pass wrong! Try again.");
      }
  }
private void changeuserinfo(ActionEvent event) {
        
        String fName = changefirstname.getText();
        String lName = changelastname.getText();
        String email = changeemail.getText();
        
        BPD3.admin.updateFName(fName);
        BPD3.admin.updateLName(lName);
        BPD3.admin.updateEmail(email);
          
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
