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
    
    /**
     * This method constructs an invoice factory
     * @param invoiceStartNunber 
     */
    InvoiceFactory (int invoiceStartNunber)
    {
        invoiceArray = new ArrayList<>();  
        invoiceNumber = invoiceStartNunber;
    }
    
    /**
     * This method creates a new invoice factory
     * @param invoiceStartNumber
     * @return InvoiceFactory
     */
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
     *This method creates a new invoice
     * @return Invoice
     */
    public Invoice createInvoice()
    {
        Invoice invoice = new Invoice(invoiceNumber++);
        invoiceArray.add(invoice);
        return invoice;
    }
     
    /**
     * This method gets a invoice off a number
     * @param invoiceNum
     * @return Invoice
     */
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
    
    /**
     * This method gets the invoice off a date
     * @param date
     * @return invoice
     */
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
    
    /**
     * This method gets the invoice array of the factory
     * @return ArrayList<Invoice>
     */
    public ArrayList<Invoice> getInvList(){
        return invoiceArray;
    }
}
