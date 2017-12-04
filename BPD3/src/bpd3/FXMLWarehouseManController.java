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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author drado_000
 */
public class FXMLWarehouseManController implements Initializable {
    
    @FXML 
    private TextField MainTextField; 
    
    @FXML
    private TextArea MainTextArea;
    
    @FXML
    private Button MainSubmitButton;
    
    @FXML
    private TextField PartNameField;
    
    @FXML
    private TextField PartNumberField;
    
    @FXML
    private TextField ListPriceField;
    
    @FXML
    private TextField SalePriceField;
    
    @FXML
    private TextField OnSaleField;
    
    @FXML
    private TextField QuantityField;
    
    @FXML 
    private TextArea EnterTextArea;
    
    @FXML
    private Button EnterSubmitButton; 
    
    @FXML
    private TextField DisplayPartNameField;
    
    @FXML
    private TextField DisplayPartNumField;
    
    @FXML
    private TextArea DisplayArea;
    
    @FXML
    private Button DisplayNameButton;
    
    @FXML
    private Button DisplayNumButton;
    
    @FXML
    private TextArea SortNameTextArea;
    
    @FXML
    private Button SortNameButton; 
    
    @FXML
    private TextArea SortNumTextArea;
    
    @FXML
    private Button SortNumButton; 
    
    @FXML
    private void SortNumButtonAction(ActionEvent event)
    {
        ArrayList<Inventory> inven = WarehouseMan.sortName();
        for (int i = 0; i <inven.size(); i++)
        {
            SortNumTextArea.appendText(inven.get(i).getNumber() + ", " + inven.get(i).getName() + ", " + inven.get(i).getlistPrice() + ", " + inven.get(i).getsalePrice() + ", " + inven.get(i).getonSale() + ", " + inven.get(i).getQuantity() + '\n'); 
        }
    }
    
    @FXML
    private void SortNameButtonAction(ActionEvent event)
    {
        ArrayList<Inventory> inven = WarehouseMan.sortName();
        for (int i = 0; i <inven.size(); i++)
        {
            SortNameTextArea.appendText(inven.get(i).getName() + ", " + inven.get(i).getNumber() + ", " + inven.get(i).getlistPrice() + ", " + inven.get(i).getsalePrice() + ", " + inven.get(i).getonSale() + ", " + inven.get(i).getQuantity() + '\n'); 
        }
    }
    
    @FXML
    private void DisplayNumButtonAction(ActionEvent event)
    {
        String s = DisplayPartNumField.getText();
        int i = Integer.parseInt(s);
        Inventory p = BPD3.cmd.examinePart(i);
        if (p!=null){
            DisplayArea.setText(p.toString());
        }
        else {
            DisplayArea.setText("Part not found");
        }
    }
    
    @FXML
    private void DisplayNameButtonAction(ActionEvent event)
    {
        String s = DisplayPartNameField.getText();
        Inventory p = BPD3.cmd.examinePart(s);
        if (p!=null){
            DisplayArea.setText(p.toString());
        }
        else {
            DisplayArea.setText("Part not found");
        }
    }
    
    @FXML
    private void EnterSubmitButtonAction(ActionEvent event)
    {
        String[] sArray; 
        sArray = new String[6]; 
        sArray[0] = PartNameField.getText(); 
        sArray[1] = PartNumberField.getText();
        sArray[2] = ListPriceField.getText();
        sArray[3] = SalePriceField.getText();
        sArray[4] = OnSaleField.getText();
        sArray[5] = QuantityField.getText(); 
        String output = WarehouseMan.enter(sArray); 
        EnterTextArea.setText(output); 
    }
    
    @FXML
    private void MainSubmitButtonAction(ActionEvent event)
    {
        String s = MainTextField.getText(); 
        String output = WarehouseMan.updateInventory(s); 
        MainTextArea.setText(output); 
    }
    
    @FXML
    private void logOutButtonMethod(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
