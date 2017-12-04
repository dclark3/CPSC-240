/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;
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
    Warehouse wh; 
    InvoiceFactory invoiceFac; 
    Invoice invoice; 
    
    public SalesAssociate(String fName, 
                          String lName,
                          String username, 
                          String password, 
                          String email, String name, 
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
    public String updateVan(String filename, Warehouse ware) //need to decrease from main @@@@@@@@@
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
    
    //dont forget that we need to be able to search through the invoices between certain dates
    //this creates the invoice
    public Invoice CreateSalesInvoice()
    {        
        this.invoice =invoiceFac.createInvoice();  
        return invoice; 
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
    
    public ArrayList<String> SortNumberVan()
    {
        ArrayList<String> output = new ArrayList<>();
        boolean flag = true; 
        while (flag)
        {
            flag = false;
            Inventory temp;
            for (int i =0; i<wh.getSize(); i++)
            {
                if (wh.getInventory().get(i).getNumber() > (wh.getInventory().get(i+1).getNumber()))
                {
                    temp = wh.getInventory().get(i); 
                    wh.getInventory().set(i, wh.getInventory().get(i+1)); 
                    wh.getInventory().set(i+1, temp);
                    flag = true;
                }
            }
        }
        for (Inventory in : wh.getInventory())
        {
            output.add(in.getNumber() + " " +
                       in.getName() + " " + 
                        in.getlistPrice() + " " + 
                        in.getsalePrice() + " " + 
                        in.getonSale() + " " + 
                        in.getQuantity()); 
        }
        return output; 
    }
    
    public ArrayList<String> SortName()
    {
        ArrayList<String> output = new ArrayList<>();
        boolean flag = true; 
        while (flag)
        {
            flag = false;
            Inventory temp;
            for (int i =0; i<wh.getSize(); i++)
            {
                if (wh.getInventory().get(i).getName().compareToIgnoreCase(wh.getInventory().get(i+1).getName()) > 0)
                {
                    temp = wh.getInventory().get(i); 
                    wh.getInventory().set(i, wh.getInventory().get(i+1)); 
                    wh.getInventory().set(i+1, temp);
                    flag = true;
                }
            }
        }
        for (Inventory in : wh.getInventory())
        {
            output.add(in.getName() + " " +
                       in.getNumber() + " " + 
                        in.getlistPrice() + " " + 
                        in.getsalePrice() + " " + 
                        in.getonSale() + " " + 
                        in.getQuantity()); 
        }
        return output; 
    }    
     
}
