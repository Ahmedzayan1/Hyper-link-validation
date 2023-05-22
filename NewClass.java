/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class NewClass {
     public static boolean
    digits(String str)
    {
     
        for (int i = 0; i < str.length(); i++) {
  
            // Check if character is
            // digit from 0-9
            // then return true
            // else false
            if (str.charAt(i) >= '0'
                && str.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    
    
    
}
