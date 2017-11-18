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
public class Person {
    
    String firstName;
    String lastName;
    
    public Person(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }
    
    public String getFName(){
        return this.firstName;
    }
    
    public String getLName(){
        return this.lastName;
    }
    
    public String updateFName(String name){
        this.firstName = name;
        return this.firstName;
    }
    
    public String updateLName(String name){
        this.lastName = name;
        return this.lastName;
    }
  
    
}
