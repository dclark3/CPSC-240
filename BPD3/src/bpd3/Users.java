/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;
import java.util.ArrayList;
/**
 *
 * @author Christina
 */
 

public class Users {
    public static ArrayList <SysAdmin> adminlist = new ArrayList<SysAdmin>();
    public static ArrayList <SalesAssociate> salist = new ArrayList<SalesAssociate>();
    public static ArrayList <OfficeMan> omlist = new ArrayList<OfficeMan>();
    public static ArrayList <WarehouseMan> wmlist = new ArrayList<WarehouseMan>();
    
    /**
     * This method finds a sales associate
     * @param name
     * @return SalesAssociate
     */
    public static SalesAssociate findSa(String name){
        
        for (SalesAssociate sa : salist){
            if (sa.getFullName().equals(name)){
                return sa;
            }
        }
        return null;
    }
    
    /**
     * This method gets a sales assocaite
     * @param username
     * @return SalesAssocaite
     */
    public static SalesAssociate getSa(String username)
    {
        for (SalesAssociate sa : salist){
            if (sa.getUsername().equals(username)){
                return sa;
            }
        }
        return null;
    }
}
