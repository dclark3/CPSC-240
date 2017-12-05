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
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
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
    private TextArea userlistarea;
    @FXML
    private Button userbutton;
    
    
    @FXML
    private void logOutButtonMethod(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    
    
    @FXML
    protected void checkOfficeManAction(ActionEvent event) throws IOException {
      String oun = userOfficeMan.getText();
      if (BPD3.accounts.contains(oun)) {
          OfficeManlabel.setText("Sorry, user already exists");
           }
      else {
          OfficeManlabel.setText("Name available");
    } }
    @FXML
 protected void createOfficeManAction(ActionEvent event) {
     String opw = passOfficeMan.getText();
     String confirmopw = confirmpassOfficeMan.getText();
     if (opw.equals(confirmopw)) {
         String oemail = emailOfficeMan.getText();
         String ofname = firstnameOfficeMan.getText();
         String olname = lastnameOfficeMan.getText();
         String omun = userOfficeMan.getText();
         OfficeMan o = new OfficeMan(ofname,olname,omun,opw,oemail);
         BPD3.accounts.add(o);
         Users.omlist.add(o);
         createOfficeManlabel.setText("User created!");
     }
     else {
         createOfficeManlabel.setText("Passwords do not match!");
             
     } 
}
     @FXML
 protected void checkWHmanAction(ActionEvent event) throws IOException {
      String whun = userWHman.getText();
      
      if (BPD3.accounts.contains(whun)) {
          WHmanuserlabel.setText("Sorry, user already exists");
           }
      else {
          WHmanuserlabel.setText("Name available");
    } }
     @FXML
  protected void createWHmanAction(ActionEvent event) {
     String whpw = passWHman.getText();
     String confirmwhpw = confirmpassWHman.getText();
     if (whpw.equals(confirmwhpw)) {
         String whemail = emailWHman.getText();
         String whfname = firstnameWHman.getText();
         String whlname = lastnameWHman.getText();
         String whun = userWHman.getText();
         WarehouseMan a = new WarehouseMan(whfname,whlname,whun,whpw,whemail);
         BPD3.accounts.add(a);
         Users.wmlist.add(a);
         createWHmanlabel.setText("New Warehouse Manager Created!");
         createWHmanlabel.getText();
     }
     else {
         createWHmanlabel.setText("Passwords do not match!");
         createWHmanlabel.getText();
   
     } 
}
      @FXML
  protected void checkSAAction(ActionEvent event) throws IOException {
      String saun = userSA.getText();
     
      if (BPD3.accounts.contains(saun)) {
          SAlabel.setText("Sorry, user already exists");
          SAlabel.getText();
           }
      else {
          SAlabel.setText("Name available");
          SAlabel.getText();
    } } 
      @FXML
  protected void checkSVAction(ActionEvent event) throws IOException {
      String SV = SVname.getText();
      if (Users.salist.contains(SV)) {
          SVlabel.setText("Sorry, van already exists");
          SVlabel.getText();
           }
      else {
          SVlabel.setText("Name available");
          SVlabel.getText();
    } }  
      @FXML
  protected void createSAAction(ActionEvent event) {
     String sapw = passSA.getText();
     String confirmsapw = confirmpassSA.getText();
     if (sapw.equals(confirmsapw)) {
         String saemail = emailSA.getText();
         String safname = firstnameSA.getText();
         String salname = lastnameSA.getText();
         String saun = userSA.getText();
         String sv = SVname.getText();
         Warehouse w = new Warehouse(sv);
         String wn = SVname.getText();
         SalesAssociate s = new SalesAssociate(safname,salname,saun,sapw,saemail,wn,w);
         BPD3.accounts.add(s);
         Users.salist.add(s);
         BPD3.fleet.addWarehouse(w);
         createSAlabel.setText("New Sales Associate Created!");
         createSAlabel.getText();
     }
     else {
         createSAlabel.setText("Passwords do not match!");
         createSAlabel.getText();
   
     } 
}
      @FXML
  protected void changepassAction() {
      String user = changepassUser.getText();
      String newpw = newpass.getText();
      String confirmnewpw = confirmnewpass.getText();
      if (newpw.equals(confirmnewpw)) {
        if(user.equals(BPD3.wareMan.getUsername())) {
          BPD3.wareMan.updatePassword(newpw);
      changepasslabel.setText("Change of password successful!");
      changepasslabel.getText();
  }
      else if(user.equals(BPD3.offMan.getUsername())) {
          BPD3.offMan.updatePassword(newpw);
      changepasslabel.setText("Change of password successful!");
      changepasslabel.getText();
  }
       else if(user.equals(BPD3.sa1.getUsername())) {
          BPD3.sa1.updatePassword(newpw);
      changepasslabel.setText("Change of password successful!");
      changepasslabel.getText();
  }
    else if(user.equals(BPD3.sa2.getUsername())) {
      BPD3.sa2.updatePassword(newpw);
      changepasslabel.setText("Change of password successful!");
      changepasslabel.getText();
  } 
    else  if(user.equals(BPD3.sa3.getUsername())) {
      BPD3.sa3.updatePassword(newpw);
      changepasslabel.setText("Change of password successful!");
      changepasslabel.getText();
  }
      }
      else {
       changepasslabel.setText("Passwords do not match!");
       changepasslabel.getText();
      }
  }
      @FXML
  protected void confirmdeleteuserAction(ActionEvent event) {
      String delete = deleteuser.getText();
      String adminpass = systemadminpass.getText();
      String confirmadminpass = confirmsystemadminpass.getText();
      if (adminpass.equals(BPD3.admin.getPassword()) && confirmadminpass.equals(BPD3.admin.getPassword()))  {
          if(delete.equals(BPD3.wareMan.getUsername())) {
          BPD3.wareMan.updatePassword("delete");
          deleteuserlabel.setText( delete + " successfully deleted!");
          deleteuserlabel.getText();
      }
          else if(delete.equals(BPD3.offMan.getUsername())) {
          BPD3.offMan.updatePassword("delete");
          deleteuserlabel.setText( delete + " successfully deleted!");
          deleteuserlabel.getText();
      }
          else if(delete.equals(BPD3.sa1.getUsername())) {
          BPD3.sa1.updatePassword("delete");
          deleteuserlabel.setText( delete + " successfully deleted!");
          deleteuserlabel.getText();
      }
            else if(delete.equals(BPD3.sa2.getUsername())) {
          BPD3.sa2.updatePassword("delete");
          deleteuserlabel.setText( delete + " successfully deleted!");
          deleteuserlabel.getText();
      }
            else if(delete.equals(BPD3.sa3.getUsername())) {
          BPD3.sa3.updatePassword("delete");
          deleteuserlabel.setText( delete + " successfully deleted!");
          deleteuserlabel.getText();
      }
          }
      else {
          deleteuserlabel.setText("System admin pass wrong! Try again.");
          deleteuserlabel.getText();
      }
  }
      @FXML
protected void changeuserinfoAction(ActionEvent event) {
        
        String fName = changefirstname.getText();
        String lName = changelastname.getText();
        String email = changeemail.getText();
        
        BPD3.admin.updateFName(fName);
        BPD3.admin.updateLName(lName);
        BPD3.admin.updateEmail(email);
          
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          changefirstname.setText(BPD3.admin.getFName());
        changelastname.setText(BPD3.admin.getLName());
        changeemail.setText(BPD3.admin.getEmail());
        
    }    

    @FXML
    private void displayallusersAction(ActionEvent event) {
        
        userlistarea.setText(" Username: " +BPD3.admin.getUsername() + " First Name: "  + BPD3.admin.getFName() +  " Last Name: " + BPD3.admin.getLName() +"\n Username: " + BPD3.offMan.getUsername() +  " First Name: " + BPD3.offMan.getFName() + " Last Name:  " + BPD3.offMan.getLName() 
                +"\n Username: " + BPD3.wareMan.getUsername() + " First Name: " + BPD3.wareMan.getFName() +  " Last Name: " + BPD3.wareMan.getLName() +"\n Username: " +BPD3.sa1.getUsername() + " First Name: "  + BPD3.sa1.getFName() +  " Last Name: " + BPD3.sa1.getLName() +"\n Username: "  +BPD3.sa2.getUsername() + " First Name: "  + BPD3.sa2.getFName() +  " Last Name: " + BPD3.sa2.getLName() );
        
    }
    
}
