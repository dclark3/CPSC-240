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
public class WarehouseMan extends LoginAccount{
    
    public WarehouseMan(String fName, String lName, String username, String password, String email){
        super(fName, lName, username, password, email);
    }
    
    public String updateInventory(String filename)
    {
        FileStuff fs = new FileStuff(); 
        ArrayList<Inventory> inven = fs.warehouseRead(filename);
        //add a line to put inven into the main warehouse
        return "Inventory Updated"; 
    }
    
    //need to make it if the part is already in the warehouse just update the information
    /*
    public String enter(String[] s)
    {
        String output = "part added"; 
        Inventory inven = new Inventory(s[0], 
                        Integer.parseInt(s[1]), 
                        Double.parseDouble(s[2]), 
                        Double.parseDouble(s[3]), 
                        Boolean.parseBoolean(s[4]),
                        Integer.parseInt(s[5]));
        for (int i = 0; i < "mainwarehouse"; i++)
        {
            if ("main warehouse part number" == s[1])
            {
                //mainwarehouse part using the setters
            }
        }
        
        return output;
    }
    
    
    //need to be able to enter either a string or int
    /see what my group thinks
    public ArrayList<String> display(int input)
    {
        ArrayList<String> output = new ArrayList<>(); 
        for (Inventory inven : "mainwarehouse")
        {
            if ("mainwarehouse number" == input)
            {
                output.add("mainwarehouse inventory"); 
            }
        }
        
        return output; 
    }
    */ 
    
    public ArrayList<String> sortName()
    {
        ArrayList<String> output = new ArrayList<>();    
        return output;
    }
    
    public ArrayList<String> sortNumber()
    {
        ArrayList<String> output = new ArrayList<>(); 
        return output;
    }
}
