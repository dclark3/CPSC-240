/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import java.util.Comparator;

/**
 *
 * @author Danielle Radosta
 */
public class PartCompareByName implements Comparator <Inventory>{
    public int compare(Inventory p1, Inventory p2){
        return p1.getName().compareTo(p2.getName());
    }
}
