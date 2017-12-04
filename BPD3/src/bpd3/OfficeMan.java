/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
    
    public double getCommission(String startDate, String endDate, String saName) throws ParseException{
        
       InvoiceFactory inf = BPD3.sa.getFactory();
       ArrayList<Invoice> commission = new ArrayList<>();
       double total = 0;
       
        DateFormat df = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        Date sd =  df.parse(startDate); 
        Date ed = df.parse(endDate);
       
       for (Invoice i : inf.getInvList()){
           if (i.getDate().after(sd) && i.getDate().before(ed)){
               commission.add(i);
           }
       }
       
       for (Invoice i : commission){
           total = total + i.getTotal();
       }
       
       total = total * .15;
       
       return total;
    }
}
