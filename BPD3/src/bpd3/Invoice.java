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
    private SalesAssociate sa = Users.getSa(FXMLDocumentController.username);  //just added this
    private Customer cust; 
    private ArrayList<Inventory> inven;
    private double total;
    
    /**
     * This method constructs an invoice
     * @param num 
     */
    public Invoice(int num)
    {
        this.inven = new ArrayList<>();
        this.invoiceNumber = num; 
        this.total = 0.0;
        date = new Date();       
    }
    
    /**
     * This method adds a customer to an invoice
     * @param fname
     * @param lname 
     */
    public void addCustomer(String fname, String lname)
    {
        this.cust= new Customer(fname, lname); 
    }
    
    /**
     * This method adds a part to an invioce
     * @param partNum
     * @param quantity
     * @return String
     */
    public String addSinglePart(int partNum, int quantity)
    {
        Warehouse wh = sa.getWarehouse();
        BikePart bp = wh.findPart(partNum); 
        Inventory inv = new Inventory(bp.getName(), bp.getNumber(), bp.getlistPrice(), bp.getsalePrice(), bp.getonSale(), quantity); 
        inven.add(inv); 
        return "part added"; 
    }
    
    /**
     * This method adds a part to an invoice
     * @param partNum
     * @param quantity
     * @return boolean
     */
    public Boolean addPartToInvoice(int partNum, int quantity)
    {     
        boolean output = false;
        Inventory in = sa.wh.findPart(partNum); 
        if (in != null)
        {
            total += in.getPrice() * quantity; 
            BikePart bp = new BikePart(in.getName(), in.getNumber(), in.getlistPrice(), in.getsalePrice(), in.getonSale()); 
            Inventory invoiceIn = Warehouse.makeInventory(bp, quantity); 
            inven.add(invoiceIn); 
            in.updateQ(in.getQuantity() - quantity);  
            output = true; 
        }
        else
        {
            output = false; 
        }
        return output; 
    }
     
    /**
     * This method updates the total of an invoice
     * @param price
     * @param quantity
     * @return double
     */
    public double updateTotal(double price, int quantity)
    {
        
        return total; 
    }
     
    /**
     * This method gets the total for an invoice
     * @return double
     */
    public double getTotal()
    {
        return total;
    }
    
    /**
     * This method gets the parts of an invoice
     * @return ArrayList<Inventory>
     */
    public ArrayList<Inventory> getPartsArray()
    {
        return inven; 
    }
    
    /**
     * This method gets the number of the invoice
     * @return int
     */
    public int getNumber()
    {
        return invoiceNumber;
    }
    
    /**
     * This method gets the date of an invoice
     * @return Date
     */
    public Date getDate(){
        return date;
    }
    
    /**
     * This method gets the formatted date of an invoice
     * @return String
     */
    public String getFormattedDate()
    {
        DateFormat setTime = new SimpleDateFormat("EEE, d MMM yyyy");
        Date time = new Date();
        return setTime.format(date);        
    }
    
    /**
     * This method gets the sales assocaite for an invoice
     * @return SalesAssociate
     */
    public SalesAssociate getSalesAssociate()
    {
        return sa; 
    }
    
    /**
     * This method gets the customer of an invoice
     * @return String
     */
    public String getCustomer()
    {
        if (cust.getfname() == null || cust.getlname() == null)
        {
            return "no customer found";
        }
        else
        {
            return cust.getfname() + "" + cust.getlname(); 
        }
    }   
}
