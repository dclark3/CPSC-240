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
public class Command {
    
    /** 
     * 
     * @param name
     * @return part or null
     */
    public Inventory examinePart(String name){
        Inventory part = BPD3.mainWarehouse.findPart(name);
        if (part!=null){
            return part;
        }
        return null;
    }
    
    public Inventory examinePart(int num){
        Inventory part = BPD3.mainWarehouse.findPart(num);
        if (part!=null){
            return part;
        }
        return null;
    }
}
