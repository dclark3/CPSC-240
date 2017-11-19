/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

/**
 *
 * @author drado_000
 */
public class SalesAssociate extends LoginAccount {
    String name;
    Warehouse wh; 
    
    public SalesAssociate(String fName, 
                          String lName,
                          String username, 
                          String password, 
                          String email, 
                          String name, 
                          Warehouse wh){
        
        super(fName, lName, username, password, email);
        this.name=name;
        this.wh=wh; 
    }
    
    public Warehouse getWarehouse()
    {
        return wh; 
    }
    
    public String getName()
    {
        return name; 
    }
    
    
    
    
    
    public void SalesInvoice(String name, int num)
    {
        
    }
    
    public void SortNameVan()
    {
    }
    
        
}
