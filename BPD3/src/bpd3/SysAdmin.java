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
    private String fName;
    private String lName;
    private String username;
    private String password;
    private String email;
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
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.username = username;
        this.email = email; 
    }
    
    public String getLname()
    {
        return lName;
    }
    
    public String getfName()
    {
        return fName; 
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getEmail()
    {
        return email;
    }
}
