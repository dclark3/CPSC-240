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
public class SalesAssociate {
    LoginAccount account;
    
    public SalesAssociate(String username, String password, Warehouse wh){
        account = new LoginAccount(username, password);
    }
      
    public LoginAccount getAccount(){
        return account;
    }
    
     
}




//invoice chapter 5.8 look at invoice code