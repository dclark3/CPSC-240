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
    
    /** updates the inventory from a filename
     * 
     * @param filename
     * @returns a formatted string
     */
    public static String updateInventory(String filename)
    {
        String output = FileStuff.readFile(BPD3.mainWarehouse.getInventory(), filename);  
        return output; 
    }
   
    /**enters a new bikepart into the mainwarehouse
     * 
     * @param s
     * @returns the output as a string
     */
    public static String enter(String[] s)
    {
        System.out.println("check 1");
        String output = "initital output"; 
        Inventory inven = new Inventory(s[0],  //name 
                        Integer.parseInt(s[1]),  //number 
                        Double.parseDouble(s[2]), //list price
                        Double.parseDouble(s[3]),  //sale price
                        Boolean.parseBoolean(s[4]), //on sale
                        Integer.parseInt(s[5])); //quantity
        boolean check = true; 
        System.out.println(inven.getName()); 
        for (int i = 0; i < BPD3.mainWarehouse.getSize(); i++)
        {
            if (BPD3.mainWarehouse.getInventory().get(i).getName() == null ? inven.getName() == null : BPD3.mainWarehouse.getInventory().get(i).getName().equals(inven.getName()))
            {
                check = false;
                BPD3.mainWarehouse.getInventory().get(i).setlistPrice(inven.getlistPrice()); 
                BPD3.mainWarehouse.getInventory().get(i).setsalePrice(inven.getsalePrice()); 
                BPD3.mainWarehouse.getInventory().get(i).setonSale(inven.getonSale());
                BPD3.mainWarehouse.getInventory().get(i).addQ(inven.getQuantity()); 
                output = "part updated";
            }
            else
            {
                check = true;
                
            }
        }
        if (check)
        {
            BPD3.mainWarehouse.addPart(inven); 
            output = "part added";
        }
        
        return output;
    }
    
    /**sorts the mainwarehouse by name
     * 
     * @return an arraylist of inventory
     */
    public static ArrayList<Inventory> sortName()
    {
        Comparator<Inventory> partsToComp = new PartCompareByName();
        Collections.sort(BPD3.mainWarehouse.getInventory(), partsToComp);        
        return BPD3.mainWarehouse.getInventory();
    }
    
    /**sorts the main warehouse by number 
     * 
     * @return an arrayList of inventory 
     */
    public static ArrayList<Inventory> sortNum()
    {
        Comparator<Inventory> partsToComp = new PartCompareByNum();
        Collections.sort(BPD3.mainWarehouse.getInventory(), partsToComp);        
        return BPD3.mainWarehouse.getInventory();
    }
    
}
