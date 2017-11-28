/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dan
 */
public class Invoice 
{
    private int invoiceNumber; 
    private Date date; 
    private SalesAssociate sa; 
    private ArrayList<Inventory> inven = new ArrayList<>();
    
    public Invoice(int num)
    {
        this.invoiceNumber = num; 
        this.date = new Date(); 
    }
    
    public ArrayList<Inventory> getPartsArray()
    {
        return inven; 
    }

    public int getNumber()
    {
        return invoiceNumber;
    }
    
    //need to decrease the quantity in the sales associate warehouse
    public String addSinglePart(int partNum, int quantity)
    {
        Warehouse wh = sa.getWarehouse();
        BikePart bp = wh.findPart(partNum); 
        Inventory inv = new Inventory(bp.getName(), bp.getNumber(), bp.getlistPrice(), bp.getsalePrice(), bp.getonSale(), quantity); 
        inven.add(inv); 
        return "part added"; 
    }
    
    
}
