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
public class BikePart {
    String partName;
    int partNumber;
    double listPrice;
    double salesPrice;
    boolean onSale;
    
    //this method constructs bikepart objects
    /**
     * 
     * @param partName
     * @param partNumber
     * @param listPrice
     * @param salesPrice
     * @param onSale 
     */
    public BikePart (String partName, int partNumber, Double listPrice, Double salesPrice, Boolean onSale)   {
    this.partName = partName;
    this.partNumber = partNumber;
    this.listPrice = listPrice;
    this.salesPrice = salesPrice;
    this.onSale = onSale;    
    }      
    
    /** gets the name of a bikePart
     * 
     * @return the name of a bikePart
     */
    public String getName(){
        return partName; 
    }
    
    //this methid gets the number of a bikepart object
    /**
     * 
     * @return number of bikepart
     */
    public int getNumber(){
        return partNumber;
    }
    
    //this method gets the list price of a bikepart object
    /**
     * 
     * @return the listprice of a bikepart
     */
    public double getlistPrice(){
        return listPrice;
    }
    
    //this method gets the sale price of a bikepart object
    /**
     * 
     * @return salesprice
     */
    public double getsalePrice(){
        return salesPrice;
    }
    
    //this method gets if a bikepart object is on sale
    /**
     * 
     * @return onsale
     */
    public boolean getonSale(){
        return onSale;
    }
    
    /**
     * 
     * @param newName
     * @return partname
     */
    public String setName(String newName){
        partName = newName;
        return partName;
    }
    
    /**
     * 
     * @return this.partName + "," + 
               this.partNumber  + "," + 
               this.listPrice + "," +
               this.salesPrice + "," +
               this.onSale + ",";
     */
    public String toString(){
        return this.partName + "," + 
               this.partNumber  + "," + 
               this.listPrice + "," +
               this.salesPrice + "," +
               this.onSale + ",";
    }
    
    /**
     * 
     * @param newNumber
     * @return int
     */
    public int setNumber(int newNumber){
        partNumber = newNumber;
        return partNumber; 
    }
    
    /**
     * 
     * @param newlistPrice
     * @return double
     */
    public double setlistPrice(double newlistPrice){
        listPrice = newlistPrice;
        return listPrice;
    }
    
    /**
     * 
     * @param newsalePrice
     * @return double
     */
    public double setsalePrice(double newsalePrice){
        salesPrice = newsalePrice;
        return salesPrice;
    }
    
    /**
     * 
     * @param newonSale
     * @return boolean onsale
     */
    public boolean setonSale(boolean newonSale){
        onSale = newonSale;
        return onSale;
    }

}
