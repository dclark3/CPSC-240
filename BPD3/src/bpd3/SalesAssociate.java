/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author drado_000
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
    public String updateMain(String filename) //need to decrease from main
    {
        String output = "Error";
        ArrayList<Inventory> input = new ArrayList<>();
        
        if (input.size() > 0)
        {
           for (int i =0; i<input.size(); i++)
            {
                wh.addPart(input.get(i)); 
            } 
           output = "parts added"; 
        }
        return output;
    }
    
    //this is where the sales assocaite will add parts to its van from another van
    //look at moveParts method
    public String updateVan(String filename, String vanName) //need to decrease from other van
    {
        String output = "Error"; 
        //Warehouse sa = Fleet.findWarehouse(vanName);   ask this as a question tomorrow
        
        ArrayList<Inventory> input = new ArrayList<>(); 
        
        if (input.size() > 0)
        {
           for (int i =0; i<input.size(); i++)
            {
                wh.addPart(input.get(i)); 
            } 
           output = "parts added"; 
        }
        return output;     
    }
    
    //this creates the invoice
    public Invoice CreateSalesInvoice()
    {
        Invoice inv = invoiceFac.createInvoice();   
        this.invoice=inv; 
        return inv; 
    }
    
    //this would be adding parts to the invoice
    public String addPart(int partNum, int quantity)
    {     
        String output = invoice.addSinglePart(partNum, quantity); 
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
