/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author drado_000
 */
public class FileStuff {
    
    public static ArrayList<Inventory> warehouseRead (String filename){
        ArrayList<Inventory> output = new ArrayList<>();
        
        try{
            File fileIn = new File(filename);
            Scanner fileInput = new Scanner(fileIn);

            String [] ss;
            Inventory part;

            while (fileInput.hasNext()){
                String s = fileInput.nextLine();
                ss = s.split(",");
                part = new Inventory(ss[0], Integer.parseInt(ss[1]), 
                       Double.parseDouble(ss[2]), 
                       Double.parseDouble(ss[3]), 
                       Boolean.parseBoolean(ss[4]), 
                       Integer.parseInt(ss[5]));
                
                output.add(part);                
            }
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
            System.out.println(filename + " not found");  
        }
        return output;
    }
    
    public static String readFile(ArrayList <Inventory> inventory, String file){
        try{
            File fileIn = new File(file);
            Scanner fileInput = new Scanner(fileIn);

            String [] ss;
            Inventory part;
            ArrayList <Inventory> listOfParts = new ArrayList<>();

            while (fileInput.hasNext()){
                String s = fileInput.nextLine();
                ss = s.split(",");
                part = new Inventory(ss[0], Integer.parseInt(ss[1]), 
                       Double.parseDouble(ss[2]), 
                       Double.parseDouble(ss[3]), 
                       Boolean.parseBoolean(ss[4]), 
                       Integer.parseInt(ss[5]));
                
                listOfParts.add(part);                
            }
            for (int i = 0; i < inventory.size(); i++){
                for (int j = 0; j < listOfParts.size(); j++){
                    if (inventory.get(i).getName().equals(listOfParts.get(j).getName()) && 
                       (inventory.get(i).getNumber() == listOfParts.get(j).getNumber())){
                        
                        inventory.get(i).setlistPrice(listOfParts.get(j).getlistPrice());
                        inventory.get(i).setsalePrice(listOfParts.get(j).getsalePrice());
                        inventory.get(i).setonSale(listOfParts.get(j).getonSale());
                        inventory.get(i).addQ(listOfParts.get(j).getQuantity());
                        listOfParts.remove(listOfParts.get(j));
                    }
                }
            }
            for (Inventory p : listOfParts){
                inventory.add(p);
            }
            return file + " successfully processed";
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
            return "File not found";
        }
    }
    
    public static void writeWarehouseToFile(Warehouse w){
        try{
            String fileName = w.getFileName();
            ArrayList <Inventory> inventory = w.getInventory();
            FileWriter file = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            
            for (Inventory bp : inventory){
                String line = bp.toString();
                bufferedWriter.write(line + "\n");
            }
            bufferedWriter.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void writeEverythingToFile(Fleet fleet){
        try{    
            FileWriter file1 = new FileWriter("fleet.txt");
            BufferedWriter bufferedWriter1 = new BufferedWriter(file1);
            ArrayList <Warehouse> warehouses = fleet.getFleet();
            
            for (Warehouse w : warehouses){
                writeWarehouseToFile(w);
                String line = w.getName() +","+ w.getFileName();
                bufferedWriter1.write(line + "\n");
            }   
            
            bufferedWriter1.close(); 
        }
        
        catch (IOException ex){
            ex.printStackTrace();
        }
        
    }

}