/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author drado_000
 */
public class OfficeMan extends LoginAccount {
    
    public OfficeMan(String fName, String lName, String username, String password, String email){
        super(fName, lName, username, password, email);
    }
    
    public Inventory examinePart(String name){
        Inventory part = BPD3.mainWarehouse.findPart(name);
        if (part!=null){
            return part;
        }
        return null;
    }
    
    public Inventory examinePart(int num){
        Inventory part = BPD3.mainWarehouse.findPart(num);
        if (part!=null){
            return part;
        }
        return null;
    }
    
    public String orderParts(){
        
        ArrayList <Inventory> parts = BPD3.mainWarehouse.getInventory();
        String partsToOrder = "";
        for (Inventory p : parts){
            if (p.getQuantity() <= BPD3.minQuantity+5){
                partsToOrder = p + "\n" + partsToOrder;
            }
        }
        return partsToOrder;
    }
    
    public String getCommission(String startDate, String endDate, String saName){
        
       InvoiceFactory inf = BPD3.sa.getFactory();
       
       for (Invoice i : inf.getInvList()){
           
           
       }
    }
    
}
