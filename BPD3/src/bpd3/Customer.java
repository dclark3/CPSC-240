/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;
/**
 *
 * @author Dan
 */
public class Customer extends Person {
    private String fname;
    private String lname; 
    
    /**
     * This is the constructor for a customer object
     * @param fname
     * @param lname 
     */
    public Customer(String fname, String lname)
    {
        super (fname, lname); 
        this.fname = fname;
        this.lname = lname;
    }
    
    /**
     * This method is a getter for the name of a customer
     * @return String 
     */
    public String getName()
    {
        return fname + " " + lname ; 
    }
    
    /**
     * this method is a getter for the first name of a customer
     * @return String
     */
    public String getfname()
    {
        return fname;
    }
    
    /**
     * this method is a getter of the last name of a customer
     * @return String
     */
    public String getlname()
    {
        return lname;
    }
}
