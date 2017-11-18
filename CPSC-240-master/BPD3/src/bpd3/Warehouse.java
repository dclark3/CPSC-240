/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class Warehouse 
{
    private ArrayList<Inventory> inven; 
    private String name;
    private String filename; 
    
    public Warehouse(String name, ArrayList<Inventory> input)
    {
        this.inven = new ArrayList<>(); 
        this.filename = name + ".txt";
    }
}
