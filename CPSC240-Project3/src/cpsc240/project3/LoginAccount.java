/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPSC240.project3;

/**
 *
 * @author drado_000
 */
public class LoginAccount {
    
    String username;
    String password;
    
    public LoginAccount(String u, String p){
        username = u;
        password = p;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    
}
