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
 * @author dan
 */
public class FXMLSalesAssociateController implements Initializable {
    private Invoice in; 
    
    @FXML
    private TextField MoveFromMainTextField;
    
    @FXML
    private TextArea MoveFromMainTextArea;
    
    @FXML
    private Button MoveFromMainButton;
    
    @FXML
    private TextField MoveFromVanFileTextField;
    
    @FXML
    private TextField MoveFromVanWarehouseTextField;
    
    @FXML
    private TextArea MoveFromVanTextArea;
    
    @FXML
    private Button MoveFromVanButton;
    
    @FXML
    private TextArea SortNameTextArea;
    
    @FXML
    private Button SortNameButton;
    
    @FXML
    private TextArea SortNumberTextArea;
    
    @FXML
    private Button SortNumberButton;
    
    @FXML
    private TextArea InvoiceTextArea;
    
    @FXML
    private TextField InvoiceTextField;
    
    @FXML 
    private Button InvoiceStartButton;
    
    @FXML
    private Button InvoiceFinishButton;
    
    @FXML
    private Button InvoiceAddButton;
    
    @FXML
    private TextField InvoiceQuantityTextField; 
    
    @FXML
    private TextField InvoiceAddCustomerTextField;
    
    @FXML
    private Button InvoiceAddCustomerButton;
    
    @FXML
    private void InvoiceAddCustomerButtonAction(ActionEvent event)
    {
        String s = InvoiceAddCustomerTextField.getText(); 
        String [] sArray = s.split(","); 
        
        
        InvoiceTextArea.appendText(sArray[0]);
        InvoiceTextArea.appendText(sArray[1]); 
        InvoiceTextArea.appendText(in.getDate()); 
    }
    
    @FXML
    private void InvoiceFinishButtonAction(ActionEvent event)
    {
        InvoiceTextArea.setText("You have created Invoice: " + in.getNumber()); 
    }
    
    @FXML
    private void InvoiceAddButtonAction(ActionEvent event)
    {
        String s1 = InvoiceTextField.getText();
        String s2 = InvoiceQuantityTextField.getText();
        in.addPartToInvoice(Integer.parseInt(s1), Integer.parseInt(s2));       
    }
    
    @FXML
    private void InvoiceStartButtonAction(ActionEvent event)
    {
        Invoice in = SalesAssociate.invoiceFac.createInvoice(); 
        InvoiceTextArea.setText(""); 
        this.in = in;
    }  
    
    @FXML
    private void SortNumberButtonAction(ActionEvent event)
    {
        ArrayList<Inventory> inven = SalesAssociate.sortNum(); 
        if (inven != null)
        {
            for (int i = 0; i < inven.size(); i++)
            {
                SortNumberTextArea.appendText(inven.get(i).getNumber() + ", " + inven.get(i).getName() + ", " + inven.get(i).getlistPrice() + ", " + inven.get(i).getsalePrice() + ", " + inven.get(i).getonSale() + ", " + inven.get(i).getQuantity() + '\n'); 
            }
        }
        else
        {
            SortNumberTextArea.setText("Error"); 
        }
    }
    
    @FXML
    private void SortNameButtonAction(ActionEvent event)
    {
        ArrayList<Inventory> inven = SalesAssociate.sortName(); 
        if (inven != null)
        {
            for (int i = 0; i < inven.size(); i++)
            {
                SortNameTextArea.appendText(inven.get(i).getName() + ", " + inven.get(i).getNumber() + ", " + inven.get(i).getlistPrice() + ", " + inven.get(i).getsalePrice() + ", " + inven.get(i).getonSale() + ", " + inven.get(i).getQuantity() + '\n'); 
            }
        }
        else
        {
            SortNameTextArea.setText("Error"); 
        }
    }
    
    @FXML
    private void MoveFromVanButtonAction(ActionEvent event)
    {
        String file = MoveFromVanFileTextField.getText();
        String str = MoveFromVanWarehouseTextField.getText(); 
        Warehouse ware = BPD3.fleet.findWarehouse(str);
        String Warehouse = MoveFromVanWarehouseTextField.getText(); 
        
        if (file != null && Warehouse != null)
        {
            MoveFromVanTextArea.setText(SalesAssociate.updateVan(file, ware)); 
        }
        else
        {
            MoveFromVanTextArea.setText("Error"); 
        }
        
    }
    
    
    @FXML
    private void MoveFromMainButtonAction(ActionEvent event)
    {
        String s = MoveFromMainTextField.getText();
        if (s != null)
        {
            MoveFromMainTextArea.setText (SalesAssociate.updateVanFromMain(s)); 
        }
        else
        {
            MoveFromMainTextArea.setText("error"); 
        }
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
