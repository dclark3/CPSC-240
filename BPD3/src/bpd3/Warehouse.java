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
    
    public Warehouse(String name){
        this.inven = new ArrayList<>(); 
        this.filename = name + ".txt";
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getFileName(){
        return this.filename;
    }
    
    public ArrayList <Inventory> getInventory(){
        return this.inven;
    }
    
    public Inventory findPart(String name){
        for (Inventory p: inven){
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;       
    }
    
    public Inventory findPart(int num){
        for (Inventory p : inven){
            if (p.getNumber() == num){
                return p;
            }
        }
        return null;       
    }
    
    public String addPart(Inventory bp){
        inven.add(bp);
        return "part successfully added";
    }
    
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
    

}
