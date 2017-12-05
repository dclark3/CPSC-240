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
public class LoginAccount extends Person{
    final String username;
    String password;
    String email;
    
    /**
     * This method constructs a login account
     * @param fName
     * @param lName
     * @param u
     * @param p
     * @param email 
     */
    public LoginAccount(String fName, String lName, String u, String p, String email){
        super(fName, lName);
        this.username = u;
        this.password = p;
        this.email = email;
    }
    
    /**
     * This method gets the user name of a login account
     * @return String
     */
    public String getUsername(){
        return username;
    }
    
    /**
     * This method gets the password of a login account
     * @return String
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * This method gets the email of a login account
     * @return String 
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * This method updates the password of a login account
     * @param pass
     * @return String
     */
    public String updatePassword(String pass){
        this.password = pass;
        return this.password;
    }
    
    /**
     * This method updates the email of a login account
     * @param email
     * @return String
     */
    public String updateEmail(String email){
        this.email = email;
        return this.email;
    }
    
}
