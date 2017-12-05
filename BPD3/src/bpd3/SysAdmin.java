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
public class SysAdmin extends LoginAccount{
    
    /**
     * This method constructs a systemAdmin
     * @param fName
     * @param lName
     * @param username
     * @param password
     * @param email 
     */
    public SysAdmin(String fName, String lName, String username, String password, String email){
        super(fName, lName, username, password, email);
    }
}
