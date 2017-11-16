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
public class Inventory extends BikePart
{
    private int quantity;
    
    public Inventory(String partName, int partNumber, Double listPrice, Double salesPrice, Boolean onSale, int quantity) {
        super(partName, partNumber, listPrice, salesPrice, onSale);
        this.quantity = quantity; 
    }  
}
