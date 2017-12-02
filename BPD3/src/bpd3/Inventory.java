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
    
    public Inventory(String partName, int partNumber, Double listPrice, Double salesPrice, Boolean onSale, int quantity) {
        super(partName, partNumber, listPrice, salesPrice, onSale);
        this.quantity = quantity; 
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public int updateQ(int q){
        this.quantity = q;
        return this.quantity;
    }
    
    public int addQ(int q){
        this.quantity = this.quantity + q;
        return this.quantity;
    }
    
    public int subtractQ(int q){
        this.quantity = this.quantity - q;
        return this.quantity;
    }
    
    public String toString(){
        return this.partName + "," + 
               this.partNumber  + "," + 
               this.listPrice + "," +
               this.salesPrice + "," +
               this.onSale + "," +
               this.quantity;
    }
    
    
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
