/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;

/**
 *
 * @author drado_000
 */
public class Fleet {
    /** Field description of fleet */
    private ArrayList <Warehouse> fleet; 
    
    /** Constructs a fleet
     * 
     * @param warehouses 
     */
    public Fleet(ArrayList warehouses){
        fleet = warehouses;
    }
    
    /** Gets the ArrayList for a Fleet
     * 
     * @return this.fleet
     */
    public ArrayList getFleet(){
        return this.fleet;
    }
    
    /** Creates a new Warehouse and adds it to the fleet
     * 
     * @param whName
     * @param fileName
     * @return 
     */
    public Warehouse createWarehouse(String whName){
        ArrayList <Inventory> inven = new ArrayList<>();
        Warehouse w = new Warehouse(whName);
        fleet.add(w);
        return w;
    }
    
    /** Creates a new part manually
     * 
     * @param whName
     * @param name
     * @param number
     * @param price
     * @param salePrice
     * @param onSale
     * @param quantity
     * @return "part successfully added" OR whName + "cannot be found"
     */
    public String enterPart(String whName, String name, int number, double price, double salePrice, boolean onSale, int quantity ){
        Warehouse w = findWarehouse(whName);
        if (w != null){
            Inventory bp = new Inventory(name, number, price, salePrice, onSale, quantity);
            w.addPart(bp);
            return "Part sucessfully processed";
        }
        return whName + "cannot be found";
    }
    
    /** Finds a warehouse in the fleet
     * 
     * @param name
     * @return wh OR null
     */
    public Warehouse findWarehouse(String name){
        for (Warehouse wh : fleet){
            if (wh.getName().equals(name)){
                return wh;
            }
        }
        return null;
    }
    
    /** Gets a string of warehouse names in the fleet
     * 
     * @return warehouses
     */
    public ArrayList getWHS(){
        ArrayList <String> warehouses = new ArrayList<>();
        for (Warehouse wh : fleet){
            String name = wh.getName();
            warehouses.add(name);
        }
        return warehouses;
    }
    
    /** Turns a fleet into a string
     * 
     * @return listOFAllParts
     */
    @Override
    public String toString(){
        String listOfAllParts = "";
        for (Warehouse w : fleet){
            listOfAllParts = w.toString() + "\n" + listOfAllParts;
        }
        return listOfAllParts;
    }
}
