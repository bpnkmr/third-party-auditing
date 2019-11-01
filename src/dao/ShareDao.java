package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.UserBean;
import dbConnection.Database;

public class ShareDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	Connection conn=null;
	ResultSet rs=null;
	Statement s=null;
	String query="";
PreparedStatement ps=null;



public int insertShareRecord(String fileid,String userid,String latitude,String longitude)
{
 conn=Database.getConnection();
 int i=0;

 
 
	try{
		s=conn.createStatement();
	 i=s.executeUpdate("insert into ShareFile values (null,'"+fileid+"','"+userid+"','"+latitude+"','"+longitude+"')" );
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	return i;
}


public ResultSet ShareFile(String userid)
{
	int i=0;
	conn=Database.getConnection();
	//query="select * from sharefile where UserName=?";
	try{
	s=conn.createStatement();
	rs=s.executeQuery("select f.id, f.fname,s.userid, f.file, f.fpath, f.encpath, f.publicKey, f.hashcode, f.fkid from fileinfo f inner join sharefile s on f.id=s.fileid where s.userid='"+userid+"'");
	
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return rs;
}

}
