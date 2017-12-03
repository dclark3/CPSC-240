/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author dan
 */

/**
 * Sales associate still needs to decrease the inventory from whatever warehouse is came from when it sells an item
 * also need to make it possible to search between invoices by date
 * @author Dan
 */
public class SalesAssociate extends LoginAccount {
    String name;
    static Warehouse wh; 
    public static InvoiceFactory invoiceFac; 
    Invoice invoice; 
    
    public SalesAssociate(String fName, 
                          String lName,
                          String username, 
                          String password, 
                          String email, 
                          String name, 
                          Warehouse wh){
        
        super(fName, lName, username, password, email);
        this.name=name;
        this.wh=wh; 
        InvoiceFactory invoiceFac = new InvoiceFactory(0); 
        this.invoiceFac = invoiceFac; 
    }
    
    public Warehouse getWarehouse()
    {
        return wh; 
    }
    
    public String getName()
    {
        return name; 
    }
    
    //this is how the sales assocaite will add parts to its van from main
    //possible solution is just to make 2 methods to do this
    public static String updateVan(String filename, Warehouse ware) //need to decrease from main @@@@@@@@@
    { 
        String output = ""; 
        ArrayList<Inventory> inven = FileStuff.warehouseRead(filename);
        if (inven.size() > 0 && inven != null)
        {
            for (int i = 0; i < ware.getInventory().size(); i++){
                for (int j = 0; j < inven.size(); j++){
                    if (ware.getInventory().get(i).getName().equals(inven.get(j).getName()))
                    {  
                        wh.addPart(ware.getInventory().get(i)); 
                        ware.getInventory().get(i).subtractQ(inven.get(j).getQuantity());  //need to make sure this actually decreases the quantity from teh correct warehouse
                    }
                }
            }
            output = "parts added"; 
        }
        else
        {
            output = "failure"; 
        }
        return output;
    }
    
    public static String updateVanFromMain(String filename)
    {
        String output = "";
        ArrayList<Inventory> inven = FileStuff.warehouseRead(filename);
        if (inven.size() > 0 && inven != null)
        {
            for (int i = 0; i < BPD3.mainWarehouse.getInventory().size(); i++){
                for (int j = 0; j < inven.size(); j++){
                    if (BPD3.mainWarehouse.getInventory().get(i).getName().equals(inven.get(j).getName()))
                    {  
                        wh.addPart(BPD3.mainWarehouse.getInventory().get(i)); 
                        BPD3.mainWarehouse.getInventory().get(i).subtractQ(inven.get(j).getQuantity());  //need to make sure this actually decreases the quantity from teh correct warehouse
                    }
                }
            }
            output = "parts added"; 
        }
        else
        {
            output = "failure"; 
        }
        return output;
    }
    
    //dont forget that we need to be able to search through the invoices between certain dates
    //this creates the invoice
    public Invoice CreateSalesInvoice()
    {        
        this.invoice =invoiceFac.createInvoice();  
        return invoice; 
    }
    
    public static InvoiceFactory getInvoiceFac()
    {
        return invoiceFac; 
    }
    
    public static Inventory findPart(int num){
        for (Inventory p : wh.getInventory()){
            if (p.getNumber() == num){
                return p;
            }
        }
        return null;       
    }
    
    
    //good example of decreasing the inventory
    public String addPartToInvoice(int partNum, int quantity)
    {     
        String output = invoice.addSinglePart(partNum, quantity);
        Inventory in = wh.findPart(partNum);
        if (in != null)
        {
            in.subtractQ(quantity);
        }
        return output; 
    }    
    
     public static ArrayList<Inventory> sortName()
    {
        Comparator<Inventory> partsToComp = new PartCompareByName();
        Collections.sort(wh.getInventory(), partsToComp);        
        return wh.getInventory();
    }
     
    public static ArrayList<Inventory> sortNum()
    {
        Comparator<Inventory> partsToComp = new PartCompareByNum();
        Collections.sort(wh.getInventory(), partsToComp);        
        return wh.getInventory();
    } 
}