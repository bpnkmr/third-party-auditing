package util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author Indraneel
 */
public class RandomString {
    


     public static String random() 
     {
        // while(true){
    String chars = "1234567890qwertyuiopasdfghjklzxcvbnm";
    Random r = new Random();
    int limit = 16;
    StringBuffer buf = new StringBuffer();

    
    for (int i = 0; i < limit ; i++) {
      buf.append(chars.charAt(r.nextInt(chars.length())));
    }
    return buf.toString();
   

  }
//}
    
     //getting random string from emailid and server key
    public static String getRandomString( String chars)
    {
 
    Random r = new Random();
    int limit = 9;
    StringBuffer buf = new StringBuffer();

 
    for (int i = 0; i < limit ; i++) {
      buf.append(chars.charAt(r.nextInt(chars.length())));
    }
    
    
     return  buf.toString();
    }
}
