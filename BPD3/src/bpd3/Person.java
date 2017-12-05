/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

/**
 *
 * 
 */
public class Person {
    
    String firstName;
    String lastName;
    
    /**
     * This method constructs a person
     * @param fName
     * @param lName 
     */
    public Person(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }
    
    /**
     * This method gets the first name of a person
     * @return String
     */
    public String getFName(){
        return this.firstName;
    }
    
    /**
     * This method gets the last name of a person
     * @return String
     */
    public String getLName(){
        return this.lastName;
    }
    
    /**
     * This method gets the full name of a person
     * @return String
     */
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    
    /**
     * This method updates the first name of a person
     * @param name
     * @return String
     */
    public String updateFName(String name){
        this.firstName = name;
        return this.firstName;
    }
    
    /**
     * This method updates the last name of a person
     * @param name
     * @return String
     */
    public String updateLName(String name){
        this.lastName = name;
        return this.lastName;
    }
  
    
}
