/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class InvoiceFactory 
{
    private ArrayList<Invoice> invoiceArray;
    private int invoiceNumber; 
    private static int counter = 0;
    
    InvoiceFactory (int invoiceStartNunber)
    {
        invoiceArray = new ArrayList<>();  
        invoiceNumber = invoiceStartNunber;
    }
    
    public static InvoiceFactory createInvoiceFactory(int invoiceStartNumber)
    {
        if (counter == 0)
        {
            counter++;
            return new InvoiceFactory(invoiceStartNumber); 
        }
        else
        {
            return null; 
        }
    }
    
    /**
     *
     * @return 
     */
    public Invoice createInvoice()
    {
        Invoice invoice = new Invoice(invoiceNumber++);
        invoiceArray.add(invoice);
        return invoice;
    }
        
    public Invoice getInvoice (int invoiceNum)
    {
        for (Invoice inv1 : invoiceArray)
        {
            if (inv1.getNumber() == invoiceNum)
            {
                return inv1; 
            }
        }
        return null;
    } 
    
    public Invoice getInvoice (String date){
        
        for (Invoice inv1 : invoiceArray)
        {
            if (inv1.getFormattedDate().equals(date))
            {
                return inv1; 
            }
        }
        return null;       
    }
    
    public ArrayList<Invoice> getInvList(){
        return invoiceArray;
    }
}
