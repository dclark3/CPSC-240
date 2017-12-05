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
public class SalesAssociate extends LoginAccount {
    String name;
    static Warehouse wh; 
    public static InvoiceFactory invoiceFac; 
    Invoice invoice; 
    
    /**constructs a sales associate
     * 
     * @param fName
     * @param lName
     * @param username
     * @param password
     * @param email
     * @param name
     * @param wh 
     */
    public SalesAssociate(String fName, 
                          String lName,
                          String username, 
                          String password, 
                          String email,
                          String name,
                          Warehouse wh){
        
        super(fName, lName, username, password, email);
        this.wh=wh;
        this.name = name;
        InvoiceFactory invoiceFac = new InvoiceFactory(0); 
        this.invoiceFac = invoiceFac; 
    }
    
    /**gets the warehouse of the salesassociate
     * 
     * @returns a warehouse
     */
    public Warehouse getWarehouse()
    {
        return wh; 
    }
    
    /**gets the name of the salesassociate
     * 
     * @returns a string
     */
    public String getName()
    {
        return name; 
    }
    
    /**updates the salesassociate's van
     * 
     * @param filename
     * @param ware
     * @returns a formatted string
     */
    public static String updateVan(String filename, Warehouse ware)
    { 
        String output = ""; 
        ArrayList<Inventory> inven = FileStuff.warehouseRead(filename);
        if (inven.size() > 0 && inven != null)
        {
            for (int i = 0; i < ware.getInventory().size(); i++){
                for (int j = 0; j < inven.size(); j++){
                    if (ware.getInventory().get(i).getName().equals(inven.get(j).getName()))
                    {  
                        wh.addPart(ware.getInventory().get(i)); 
                        ware.getInventory().get(i).subtractQ(inven.get(j).getQuantity()); 
                    }
                }
            }
            output = "parts added"; 
        }
        else
        {
            output = "failure"; 
        }
        return output;
    }
    
    /**this updates the SalesAssociate's van from the main warehouse
     * 
     * @param filename
     * @returns a formatted string of output
     */
    public static String updateVanFromMain(String filename)
    {
        String output = FileStuff.moveParts(filename); 
        return output;
    }
    
    /**this updates the SalesAssociate's van from another van
     * 
     * @param filename
     * @returns a formatted string of output
     */
    public static String updateVanFromVan(String filename)
    {
        String output = FileStuff.moveParts(filename); 
        return output;
    }

    /**this creates a new invoice
     * 
     * @returns an invoice
     */
    public Invoice CreateSalesInvoice()
    {        
        this.invoice =invoiceFac.createInvoice();  
        return invoice; 
    }
    
    /**this method gets the invoice factory for the SalesAssociate
     * 
     * @returns an invoicefactory
     */
    public static InvoiceFactory getInvoiceFac()
    {
        return invoiceFac; 
    }
    
    public InvoiceFactory getFac()
    {
        return invoiceFac; 
    }
    
    /**this method finds a part from the SalesAssociate's warehouse
     * 
     * @param num
     * @returns an inventory object
     */
    public static Inventory findPart(int num)
    {
        for (Inventory p : wh.getInventory()){
            if (p.getNumber() == num){
                return p;
            }
        }
        return null;       
    }
    
    /**this method adds a part to a invoice
     * 
     * @param partNum
     * @param quantity
     * @returns a formatted string
     */
    public String addPartToInvoice(int partNum, int quantity)
    {     
        String output = invoice.addSinglePart(partNum, quantity);
        Inventory in = wh.findPart(partNum);
        if (in != null)
        {
            in.subtractQ(quantity);
        }
        return output; 
    }    
    
    /**this method sorts the SalesAssociate's warehouse by name
     * 
     * @returns an arraylist of inventory
     */
    public static ArrayList<Inventory> sortName()
    {
        Comparator<Inventory> partsToComp = new PartCompareByName();
        Collections.sort(wh.getInventory(), partsToComp);        
        return wh.getInventory();
    }
     
    /**this method sorts the SalesAssociate's warehouse by number
     * 
     * @returns an arraylist of inventory 
     */
    public static ArrayList<Inventory> sortNum()
    {
        Comparator<Inventory> partsToComp = new PartCompareByNum();
        Collections.sort(wh.getInventory(), partsToComp);        
        return wh.getInventory();
    } 
}
