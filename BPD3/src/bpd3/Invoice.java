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
        this.total = 0.0;
        date = new Date();
        
    }
    
    public void addSalesAssociate(SalesAssociate s)
    {
        this.sa=s;
    }
    
    public void addCustomer(String fname, String lname)
    {
        this.cust= new Customer(fname, lname); 
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
    
     public Boolean addPartToInvoice(int partNum, int quantity)
    {     
        boolean output = false;
        Inventory in = sa.getWarehouse().findPart(partNum);
        in.setQuantity(quantity);
        if (in != null)
        {
            inven.add(in); 
            total += in.getPrice(); 
            sa.getWarehouse().findPart(partNum).subtractQ(quantity); 
            output = true; 
        }
        else
        {
            output = false; 
        }
        return output; 
    }
    
    public ArrayList<Inventory> getPartsArray()
    {
        return inven; 
    }

    public int getNumber()
    {
        return invoiceNumber;
    }
    
    public Date getDate(){
        return date;
    }
    
    public String getFormattedDate()
    {
        DateFormat setTime = new SimpleDateFormat("EEE, d MMM yyyy");
        Date time = new Date();
        return setTime.format(date);
        
    }
    
    public SalesAssociate getSalesAssociate()
    {
        return sa; 
    }
    
    public String getCustomer()
    {
        return cust.getfname() + " " + cust.getlname(); 
    }
    
    public double getTotal(){
        return this.total;
    }
}
