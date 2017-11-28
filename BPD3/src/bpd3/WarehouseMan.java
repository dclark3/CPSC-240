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
public class WarehouseMan extends LoginAccount{
    
    public WarehouseMan(String fName, String lName, String username, String password, String email){
        super(fName, lName, username, password, email);
    }
    
    /* this needs to be updating the mainwarehouse
    public String updateInventory(String filename)
    {
        FileStuff.readFile(filename); 
        return "Inventory Updated"; 
    }
    */
    //need to make it if the part is already in the warehouse just update the information
    
    public String enter(String[] s)
    {
        String output = "part added"; 
        Inventory inven = new Inventory(s[0], 
                        Integer.parseInt(s[1]), 
                        Double.parseDouble(s[2]), 
                        Double.parseDouble(s[3]), 
                        Boolean.parseBoolean(s[4]),
                        Integer.parseInt(s[5]));
        for (int i = 0; i < BPD3.mainWarehouse.getSize(); i++)
        {
            if (BPD3.mainWarehouse.getInventory().get(i).getName() == null ? s[1] == null : BPD3.mainWarehouse.getInventory().get(i).getName().equals(s[1]))
            {
                //mainwarehouse part using the setters
            }
        }
        
        return output;
    }
    
    //put display into the controller look at officeman
    
    
    
    
    //i should use collections.sort for these because i think that means we implement the strategy pattern.
    public ArrayList<Inventory> sortName()
    {
        Comparator<Inventory> partsToComp = new PartCompareByName();
        Collections.sort(BPD3.mainWarehouse.getInventory(), partsToComp);        
        return BPD3.mainWarehouse.getInventory();
    }
    
    public ArrayList<Inventory> sortNum()
    {
        Comparator<Inventory> partsToComp = new PartCompareByNum();
        Collections.sort(BPD3.mainWarehouse.getInventory(), partsToComp);        
        return BPD3.mainWarehouse.getInventory();
    }
    
    public ArrayList<String> sortNumber()
    {
        ArrayList<String> output = new ArrayList<>(); 
        return output;
    }
}
