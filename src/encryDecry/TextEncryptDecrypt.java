package encryDecry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TextEncryptDecrypt {

	  public static boolean result = false;

	public static String reencrypt(InputStream orgfis, String encpath,String reenckey) throws Exception
    {
        SecretKeySpec key = new SecretKeySpec(reenckey.getBytes(), "AES");
        AlgorithmParameterSpec paramSpec = new IvParameterSpec(reenckey.getBytes());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        byte orgbytes[] = new byte[orgfis.available()];
        orgfis.read(orgbytes);
        orgfis.close();
        byte[] ecrypted = cipher.doFinal(orgbytes);
        FileOutputStream efos = new FileOutputStream(encpath);
        efos.write(ecrypted);
        efos.flush();
        efos.close();
        System.out.println("Length Of Encrypted Text:- " + ecrypted.length);
        return reenckey;
    }
	
	 public static void reDecrypt(String encTextFilePath, String redeckey, String decTextFilePath) throws Exception {
	        byte[] decFileBytes = null;
	      
	        try {
	            FileOutputStream outFile = new FileOutputStream(decTextFilePath);
	            SecretKeySpec key = new SecretKeySpec(redeckey.getBytes(), "AES");
	            AlgorithmParameterSpec paramSpec = new IvParameterSpec(redeckey.getBytes());

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

	            File encFile = new File(encTextFilePath);
	            FileInputStream encTextFileis = new FileInputStream(encFile);
	            byte[] encTextFileBytes = new byte[encTextFileis.available()];
	            encTextFileis.read(encTextFileBytes);
	            encTextFileis.close();
	            cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
	            decFileBytes = cipher.doFinal(encTextFileBytes);
	            outFile.write(decFileBytes);
	            outFile.flush();
	            outFile.close();
	            result = true;
	        } catch (Exception e) {

	            System.out.println(e);

	        }
	    }
	
	 
	 public static  byte[] Decrypt(String encTextFilePath, String redeckey) throws Exception {
	        byte[] decFileBytes = null;
	      
	        try {
	          //  FileOutputStream outFile = new FileOutputStream(decTextFilePath);
	            SecretKeySpec key = new SecretKeySpec(redeckey.getBytes(), "AES");
	            AlgorithmParameterSpec paramSpec = new IvParameterSpec(redeckey.getBytes());

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

	            File encFile = new File(encTextFilePath);
	            FileInputStream encTextFileis = new FileInputStream(encFile);
	            byte[] encTextFileBytes = new byte[encTextFileis.available()];
	            encTextFileis.read(encTextFileBytes);
	            encTextFileis.close();
	            cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
	            decFileBytes = cipher.doFinal(encTextFileBytes);
	            
	            result = true;
	        } catch (Exception e) {

	            System.out.println(e);

	        }
	        return decFileBytes;
	    }
	 
	 
	 
	 public static  byte[] DecryptInputstream(InputStream is, String redeckey) throws Exception {
	        byte[] decFileBytes = null;
	      
	        try {
	          //  FileOutputStream outFile = new FileOutputStream(decTextFilePath);
	            SecretKeySpec key = new SecretKeySpec(redeckey.getBytes(), "AES");
	            AlgorithmParameterSpec paramSpec = new IvParameterSpec(redeckey.getBytes());

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

	           /* File encFile = new File(encTextFilePath);
	            FileInputStream encTextFileis = new FileInputStream(encFile);*/
	            byte[] encTextFileBytes = new byte[is.available()];
	            is.read(encTextFileBytes);
	            is.close();
	            cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
	            decFileBytes = cipher.doFinal(encTextFileBytes);
	            
	            result = true;
	        } catch (Exception e) {

	            System.out.println(e);

	        }
	        return decFileBytes;
	    }
	
}
