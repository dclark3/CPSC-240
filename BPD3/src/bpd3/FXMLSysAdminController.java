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
 * @author drado_000
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
    private PasswordField currentpass;
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
    private void logOutButtonMethod(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    
    
    
    private void checkusernameOfficeManMethod(ActionEvent event) throws IOException {
      String un = userOfficeMan.getText();
       if (un =  ) {
           OfficeManlabel.setText("Sorry, user already exists");
           OfficeManlabel.getText();
       }
    }
    private void createWHManagerMethod(ActionEvent event) throws IOException {
        String un = 
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
