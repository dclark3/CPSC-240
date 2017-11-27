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
    private static ArrayList<Invoice> invoiceArray;
    private int invoiceNumber; 
    private static int counter = 0;
    
    private InvoiceFactory (int invoiceStartNunber)
    {
        invoiceArray = new ArrayList<>();  
        invoiceNumber = invoiceStartNunber; 
    }
    
    public static InvoiceFactory createInvoice(int startnum)
    {
        if (counter == 0)
        {
            counter++;
            return new InvoiceFactory(startnum); 
        }
        else
        {
            return null; 
        }
    }
    
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
            if (inv1.getNumber() == invoiceNumber)
            {
                return inv1; 
            }
        }
        return null;
    }   
}
