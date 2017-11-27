/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;

/**
 *
 * @author drado_000
 */
public class SalesAssociate extends LoginAccount {
    String name;
    Warehouse wh; 
    
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
    
    public void SalesInvoice(String name, int num)
    {
        
    }
    
    public String SortNameVan()
    {
        return ""; 
    }
    
    public ArrayList<String> SortNumberVan()
    {
        ArrayList<String> output = new ArrayList<>();
        return output; 
    }
    
    
    
        
}
