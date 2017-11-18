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
    
    public LoginAccount(String fName, String lName, String u, String p, String email){
        super(fName, lName);
        this.username = u;
        this.password = p;
        this.email = email;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String updatePassword(String pass){
        this.password = pass;
        return this.password;
    }
    
    public String updateEmail(String email){
        this.email = email;
        return this.email;
    }
    
}
