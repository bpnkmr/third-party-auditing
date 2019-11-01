package dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import bean.FileBean;


import dbConnection.Database;

public class FileDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Statement s=null;
	String query="";
	boolean check=true;
	
	
	
	 public static  String generateString(Random rng, String characters, int length)
	    {
	    System.out.println("String  "+characters);
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	        //System.out.println("text:"+text[i]);
	    }
	    return new String(text);
	}
	 
	 public boolean insertFileInfo(FileBean fb)
	 {
		 conn=Database.getConnection();
		 try{
		 query="insert into fileinfo(id,fname,file,fpath,encpath,publicKey,hashcode,fkid)values(null,?,?,?,?,?,?,?)";
        ps=conn.prepareStatement(query);
       
        ps.setString(1, fb.getFileName());
        ps.setBlob(2, fb.getFile());
        ps.setString(3, fb.getFilePath());
        ps.setString(4, fb.getEncFileName());
        ps.setString(5, fb.getPublicKey());
        ps.setString(6, fb.getHashCode());
        ps.setInt(7, fb.getFk());
       check= ps.execute();
       
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return check;
		 
	 }
	 
	 public  boolean saveFileTpa(FileBean fb) 
	    { 
	    	try{
	    	conn=Database.getConnection();
	    	query="insert into thirdparty(id,fname,file,encpath,publicKey,hashcode,fkid)values(null,?,?,?,?,?,?)";
	        ps=conn.prepareStatement(query);
	       
	        ps.setString(1, fb.getFileName());
	        ps.setBlob(2, fb.getFileTpa());
	       // ps.setString(3, fb.getFilePath());
	        ps.setString(3, fb.getEncFileName());
	        ps.setString(4, fb.getPublicKey());
	        ps.setString(5, fb.getHashCode());
	        ps.setInt(6, fb.getFk());
	    	check=ps.execute();
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return check;
	    }
	 
	 public  int getFile(String filename,int fileid) 
	    {
		 System.out.println("filenamei in getFile:"+filename);
	    	int a=0; 
	    	String fname="";
	    	try{
	    	conn=Database.getConnection();
	    	s=conn.createStatement();
	    	rs=s.executeQuery("select fname from fileinfo where fkid="+fileid+"");	    	 
	         
	         while(rs.next())
	        	 
	            fname=rs.getString(1);
	        	 
		         if(filename.equals(fname))
		         {
		        	 a=1;
		         }
		        
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		         
	         return a;
	    	
	    }
	    
	 
	 

	 public InputStream getFileData(String filename,int fileid) 
	    {
		 System.out.println("filenamei ******************* in getFile:"+filename+fileid);
	    	int a=0; 
	    	byte[] f=null;
	    	Blob blob=null;
	    	InputStream is=null;
	    	//ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	try{
	    	conn=Database.getConnection();
	    	s=conn.createStatement();
	    	rs=s.executeQuery("select file from fileinfo where id="+fileid+" AND fname='"+filename+"'");	    	 
	         
	         while(rs.next())
	         {
	        	 System.out.println("filenamei ******************* in getFile:"+filename+fileid);
	            blob=rs.getBlob(1);    
	        	// f=rs.getBytes(1);
	        // is=new ByteArrayInputStream(f);
		      is=blob.getBinaryStream();  
		      		try {
		      				System.out.println("is in fileDao:"+is.available());
		      			} catch (IOException e)
		      			{
		      					// TODO Auto-generated catch block
		      					e.printStackTrace();
		      			}
	         }
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		         
	         return is;
	    	
	    }
	    

	 
	 
	 
	 

	 public String getFilePath(String filename,int id)
	 {
		 conn=Database.getConnection();
		 String path="";
		try{
			s=conn.createStatement();
			rs=s.executeQuery("select encpath from fileinfo where fname='"+filename+"' And fkid="+id+"");
			while(rs.next())
			{
				path=rs.getString(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return path;
	 }
	 
	 
	 public InputStream getEncFile(String filename,int id)
	 {
		 conn=Database.getConnection();
		 InputStream path=null;
		try{
			s=conn.createStatement();
			rs=s.executeQuery("select file from fileinfo where fname='"+filename+"' And fkid="+id+"");
			while(rs.next())
			{
				path=rs.getBinaryStream(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return path;
	 }
	 
	 
	 public String getPublicKey(String filename)
	 {
		 conn=Database.getConnection();
		 String key="";
		 try{
		 s=conn.createStatement();
		 rs=s.executeQuery("select publicKey from fileinfo where fname='"+filename+"'");
		 while(rs.next())
		 {
			 key=rs.getString(1);
		 }
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return key;
	 }


	 public  byte[] getOrgFile(String filename,int fileid) 
	    {
		 System.out.println("filenamei in getFile:"+filename+fileid);
	    	int a=0; 
	    	byte[] file=null;
	    	try{
	    	conn=Database.getConnection();
	    	s=conn.createStatement();
	    	rs=s.executeQuery("select file from fileinfo where id="+fileid+" AND fname='"+filename+"'");	    	 
	         
	         while(rs.next())
	         {	        	 
	            file=rs.getBytes(1);
	        	System.out.println(file);
		        
	         }   
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		         
	         return file;
	    	
	    }

	 public boolean deleteFile(String filename,int id)
	 {
		 conn=Database.getConnection();
		 boolean check1=false;
		 String key="";
		 try{
		 s=conn.createStatement();
		query= "delete from fileinfo where fname='"+filename+"' AND id="+id+"";
		//query= "update table  fileinfo set file=NULL  where fname='"+filename+"' AND id="+id+"";
		check1 =s.execute(query);
		System.out.println("check in fileDao:"+check1);
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return check1;
	 }
	 
	 public boolean deleteFile1(String filename,int id)
	 {
		 conn=Database.getConnection();
		 boolean check1=false;
		 String key="";
		 try{
		 s=conn.createStatement();
		query= "delete from fileinfo where fname='"+filename+"' AND fkid="+id+"";
		check1 =s.execute(query);
		System.out.println("check in fileDao:"+check1);
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return check1;
	 }
	 public boolean deleteFile2(String filename,int id)
	 {
		 conn=Database.getConnection();
		 boolean check1=false;
		 String key="";
		 try{
		 s=conn.createStatement();
		query= "delete from thirdparty where fname='"+filename+"' AND fkid="+id+"";
		check1 =s.execute(query);
		System.out.println("check in fileDao:"+check1);
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return check1;
	 }
	 public boolean deleteUserFile(String filename,int id)
	 {
		 boolean c=true;
		 FileDao fd=new FileDao();
		boolean ch= fd.deleteFile1(filename, id);
		System.out.println("ch:"+ch);
		boolean ch1= fd.deleteFile2(filename, id);
		System.out.println("ch1:"+ch1);
		if(ch==false && ch1==false)
		{
			return c=false;
		}
		
		return c;
	 }
	 
	 
	 
	 public boolean updateFile(FileBean fb) throws IOException
	 {
		 conn=Database.getConnection();
		 boolean check1=true;
		 String key="";
		 InputStream is=null;
		is=fb.getFile();
		 try{
			 System.out.println("size in is  file dao:"+is.available());
		 s=conn.createStatement();
		query= "update fileinfo set file=?,hashcode=? where id=?";
		ps=conn.prepareStatement(query);
		ps.setBlob(1, is);
		ps.setString(2, fb.getHashCode());
		ps.setInt(3, fb.getFk());
		
		check1=ps.execute();
		System.out.println("check in fileDao:"+check1);
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return check1;
	 }
}
