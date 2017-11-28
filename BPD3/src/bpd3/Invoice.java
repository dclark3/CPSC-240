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
    private Customer cust; 
    private ArrayList<Inventory> inven;
    private double total;
    
    public Invoice(int num)
    {
        this.inven = new ArrayList<>();
        this.invoiceNumber = num; 
        this.date = new Date(); 
        this.total = 0.0; 
    }
    
    public void addSalesAssociate(SalesAssociate s)
    {
        this.sa=s;
    }
    
    public void addCustomer(Customer c)
    {
        this.cust=c;
    }
    
    //need to decrease the quantity in the sales associate warehouse @@@@@@@@@@@@@@@@@@@@ look in the sales assocaite class
    public String addSinglePart(int partNum, int quantity)
    {
        Warehouse wh = sa.getWarehouse();
        BikePart bp = wh.findPart(partNum); 
        Inventory inv = new Inventory(bp.getName(), bp.getNumber(), bp.getlistPrice(), bp.getsalePrice(), bp.getonSale(), quantity); 
        inven.add(inv); 
        total += inv.getPrice();
        return "part added"; 
    }
    
    public ArrayList<Inventory> getPartsArray()
    {
        return inven; 
    }

    public int getNumber()
    {
        return invoiceNumber;
    }
    
    public Date getDate()
    {
        return date; 
    }
    
    public SalesAssociate getSalesAssociate()
    {
        return sa; 
    }
    
    public Customer getCustomer()
    {
        return cust; 
    }
   
    
    
}
