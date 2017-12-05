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
public class Warehouse {
    private ArrayList<Inventory> inven; 
    private String name;
    private String filename; 
    
    /**
     * This method constructs a warehouse
     * @param name 
     */
    public Warehouse(String name){
        this.inven = new ArrayList<>(); 
        this.name = name; 
        this.filename = name + ".txt";
    }
    
    /**
     * This method gets the name of a warehouse
     * @return String
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * This method gets the filename of a warehouse
     * @return String
     */
    public String getFileName(){
        return this.filename;
    }
    
    /**
     * This method gets the inventory of a warehouse
     * @return ArrayList<Inventory>
     */
    public ArrayList <Inventory> getInventory(){
        return this.inven;
    }
    
    /**
     * This method finds a part in the warehouse using a String
     * @param name
     * @return Inventory
     */
    public Inventory findPart(String name){
        for (Inventory p: inven){
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;       
    }
    
    /**
     * This method finds a part in the warehouse using a number
     * @param num
     * @return Inventory
     */
    public Inventory findPart(int num){
        for (Inventory p : inven){
            if (p.getNumber() == num){
                return p;
            }
        }
        return null;       
    }
    
    /**
     * This method adds a part to the warehouse
     * @param bp
     * @return String
     */
    public String addPart(Inventory bp){
        inven.add(bp);
        return "part successfully added";
    }
    
    /**
     * This method gets the size of the warehouse=
     * @return int
     */
    public int getSize()
    {
        return inven.size(); 
    }
    
    /**
     * This method turns the inventory in the warehouse into a string
     * @return String
     */
    @Override
    public String toString(){
        String part = "";
        for (Inventory p : inven){
            if (!part.contains(p.toString())){
                part = p.toString() + "\n" + part;
            }
        }    
        return part;
    }
    
    /**
     * This method makes a bikepart and quantity into an inventory object
     * @param b
     * @param q
     * @return Inventory
     */
    public static Inventory makeInventory(BikePart b, int q)
    {
        Inventory output = new Inventory(b.getName(), b.getNumber(), b.getlistPrice(), b.getsalePrice(), b.getonSale(), q);
        return output; 
    }
    

}
