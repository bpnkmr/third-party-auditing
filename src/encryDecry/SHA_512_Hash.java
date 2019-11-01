package encryDecry;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class SHA_512_Hash {
	
	 public static String getSHA_512_Hash(String filename) throws Exception 
	   {
	       byte[] b = createChecksum(filename);
	       String result = "";
	       for (int i=0; i < b.length; i++) {
	           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	       }
	       return result;
	   }

	 
	 public static byte[] createChecksum(String filename) throws Exception 
	   {
	       InputStream fis =  new FileInputStream(filename);
	       byte[] buffer = new byte[1024];
	       MessageDigest complete = MessageDigest.getInstance("SHA-512");
	       int numRead;
	       do {
	           numRead = fis.read(buffer);
	           if (numRead > 0) {
	               complete.update(buffer, 0, numRead);
	           }
	       } while (numRead != -1);
	       fis.close();
	       return complete.digest();
	   }

	 
	 public static String getSHA_512_Hash1(InputStream filename) throws Exception 
	   {
	       byte[] b = createChecksum1(filename);
	       String result = "";
	       for (int i=0; i < b.length; i++) {
	           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	       }
	       return result;
	   }

	 
	 public static byte[] createChecksum1(InputStream fis) throws Exception 
	   {
	       //InputStream fis =  new FileInputStream(filename);
	       byte[] buffer = new byte[1024];
	       MessageDigest complete = MessageDigest.getInstance("SHA-512");
	       int numRead;
	       do {
	           numRead = fis.read(buffer);
	           if (numRead > 0) {
	               complete.update(buffer, 0, numRead);
	           }
	       } while (numRead != -1);
	       fis.close();
	       return complete.digest();
	   }

}
