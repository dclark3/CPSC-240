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
    
    public Customer(String fname, String lname)
    {
        super (fname, lname); 
        this.fname = fname;
        this.lname = lname;
    }
    
    public String getName()
    {
        return fname + " " + lname ; 
    }
    
    public String getfname()
    {
        return fname;
    }
    
    public String getlname()
    {
        return lname;
    }
}
