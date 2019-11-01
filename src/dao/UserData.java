package dao;

import java.sql.*;

import bean.UserBean;

import dbConnection.Database;

public class UserData {
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Statement s=null;
	String query="";
	boolean check=false;
	
	public int insertRecord(UserBean ub)
	{
	 conn=Database.getConnection();
	 int i=0;
	 String fname=ub.getFullName();
	 String uname=ub.getUserName();
	 String email=ub.getEmail();
	 String pass=ub.getPassword();
	 String mobile=ub.getMobile();
	 
	 
		try{
			s=conn.createStatement();
		 i=s.executeUpdate("insert into register values (null,'"+fname+"','"+uname+"','"+pass+"','"+email+"','"+mobile+"')" );
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int loginCheck(String username,String password)
	{
		int i=0;
		conn=Database.getConnection();
		query="select UserName,Password from register";
		try{
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String uname=rs.getString(1);
				if(uname!=null)
				{
					if(username.equals(uname))
					{
						String upass=rs.getString(2);
						if(password.equals(upass))
						{
							i=1;
							break;
						}
					}
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
		
	}
	public int CheckUsername(String username)
	{
		int i=0;
		conn=Database.getConnection();
		query="select UserName from register";
		try{
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String uname=rs.getString(1);
				if(uname!=null)
				{
					if(username.equals(uname))
					{
						
							i=1;
							break;
						
					}
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
		
	}
	

	public int getId(String uname)
	{
		int i=0;
		conn=Database.getConnection();
		query="select Id from register where UserName=?";
		try{
		s=conn.createStatement();
		rs=s.executeQuery("select Id from register where UserName='"+uname+"'");
		while(rs.next())
		{
			i=rs.getInt(1);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	
	public String getEmail(int id)
	{
		int i=0;
		String email="";
		conn=Database.getConnection();
		query="select Email from register where id=?";
		try{
		s=conn.createStatement();
		rs=s.executeQuery("select Email from register where id="+id+"");
		while(rs.next())
		{
			email=rs.getString(1);
			//i=rs.getInt(1);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return email;
	}
	
	
	public int ChangePass(int id,String confirmPass)
	{
		int n=0;
		
		 conn=Database.getConnection();
		try
		{
			s=conn.createStatement();
			n=s.executeUpdate("update register set Password='"+confirmPass+"' where Id='"+id+"'");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return n;
	}

	
	public ResultSet getFileDB()
	{
		conn=Database.getConnection();
		try{
			s=conn.createStatement();
			rs=s.executeQuery("select id, fname from fileinfo");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet DownloadList(int id)
	{
		conn=Database.getConnection();
		try{
			s=conn.createStatement();
			rs=s.executeQuery("select fkid, fname,id from fileinfo where fkid=+"+id+"");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getUserList()
	{String query="";
		conn=Database.getConnection();
		try{
			//query="select register.id,register.UserName,register.Email from register where  register.id=thirdparty.fkid";
			query="select register.id,register.UserName,register.Email from register where register.id in (select Distinct fkid from thirdparty)";
			System.out.println("query:"+query);
			s=conn.createStatement();
			//rs=s.executeQuery("select Id, UserName,Email from register where id IN (select ");
			rs=s.executeQuery(query);
	
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	public ResultSet getAlertMessage(int id)
	{
		conn=Database.getConnection();
		try{
			s=conn.createStatement();
			rs=s.executeQuery("select * from tparesponse where fk=+"+id+"");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	
}
