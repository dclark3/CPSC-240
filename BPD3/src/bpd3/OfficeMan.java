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
    
    /** Constructs an OfficeMan
     * 
     * @param fName
     * @param lName
     * @param username
     * @param password
     * @param email 
     */
    public OfficeMan(String fName, String lName, String username, String password, String email){
        super(fName, lName, username, password, email);
    }
    
    /** Finds an inventory object based on the part name
     * 
     * @param name
     * @return 
     */
    public Inventory examinePart(String name){
        Inventory part = BPD3.mainWarehouse.findPart(name);
        if (part!=null){
            return part;
        }
        return null;
    }
    
    /** Finds an
     * 
     * @param num
     * @return 
     */
    public Inventory examinePart(int num){
        Inventory part = BPD3.mainWarehouse.findPart(num);
        if (part!=null){
            return part;
        }
        return null;
    }
    
    
    public double getCommission(String startDate, String endDate, String saName) throws ParseException{
        
        SalesAssociate sa = Users.findSa(saName);
        
        if (sa != null){
       
            InvoiceFactory inf = sa.getFac();
            ArrayList<Invoice> commission = new ArrayList<>();
            double total = 0;

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date sd =  df.parse(startDate); 
            Date ed = df.parse(endDate);

            for (Invoice i : inf.getInvList()){
                if (i.getDate().after(sd) && i.getDate().before(ed)){
                    commission.add(i);
                }
            }
            for (Invoice i : commission){
                total += i.getTotal();
            }
            
            total = total * .15;
            return total;
        }
        return -1;
    }
}
