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
public class OfficeMan {
    LoginAccount account;
    
    public OfficeMan(String username, String password){
        account = new LoginAccount(username, password);
    }
    public LoginAccount getAccount(){
        return account;
    }
}
