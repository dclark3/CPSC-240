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
public class Inventory extends BikePart {
    private int quantity;
    
    /**
     * This method constructs an inventory object
     * @param partName
     * @param partNumber
     * @param listPrice
     * @param salesPrice
     * @param onSale
     * @param quantity 
     */
    public Inventory(String partName, int partNumber, Double listPrice, Double salesPrice, Boolean onSale, int quantity) {
        super(partName, partNumber, listPrice, salesPrice, onSale);
        this.quantity = quantity; 
    }
    
    /**
     * this method gets the quantity of an inventory object
     * @return int 
     */
    public int getQuantity(){
        return this.quantity;
    }
    
    /**
     * this method updates the quantity of an inventory object
     * @param q
     * @return int
     */
    public int updateQ(int q){
        this.quantity = q;
        return this.quantity;
    }
    
    /**
     * This method adds quantity to an inventory object
     * @param q
     * @return int
     */
    public int addQ(int q){
        this.quantity = this.quantity + q;
        return this.quantity;
    }
    
    /**
     * This method subtracts quantity from an inventory object
     * @param q
     * @return String
     */
    public int subtractQ(int q){
        this.quantity = quantity - q;
        return this.quantity;
    }
    
    /**
     * This method changes an inventory object into a string
     * @return String 
     */
    public String toString(){
        return this.partName + "," + 
               this.partNumber  + "," + 
               this.listPrice + "," +
               this.salesPrice + "," +
               this.onSale + "," +
               this.quantity;
    }
       
    /**
     * This method gets the price of an inventory object
     * @return double
     */
    public double getPrice()
    {
        if (onSale == true)
        {
            return salesPrice;
        }
        else
        {
            return listPrice;
        }
    }

}
