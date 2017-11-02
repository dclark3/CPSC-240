/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication37;

/**
 *
 * @author drado_000
 */
public class JavaApplication37 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Enter a string length:");
        int lengthOfString = input.nextInt();
        
        System.out.println("Enter 4 strings:");
        
        int stringsThatMatch = 0;
        for (int i = 0; i < 4; i ++){
            String stringX = input.next();
            int stringXLength = stringX.length(); 
            
            if( stringXLength == lengthOfString){
                //int totalStrings = totalStrings + stringXLength
                stringsThatMatch++;
            }
            
        
        }
    
        
        System.out.println(stringsThatMatch + " strings of length " + lengthOfString);
    }
    
}
