package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import dbConnection.Database;

public class TpaDao {

	Connection conn=null;
	ResultSet rs=null;
	Statement s=null;
	String query="";
PreparedStatement ps=null;


	public String  batchAuditing(int id)
	{
		String str="";
		int j=0;
		conn=Database.getConnection();
		TpaDao tp=new TpaDao();

		// Get all file name from id
		ArrayList<String> tfname=tp.getFnameTpa(id);
		String fname="";
		for(int i=0;i<tfname.size();i++)
		{
			//str=new String[tfname.size()];
			fname= tfname.get(i);
			// Check file name in server
			String sername=tp.getFnameServer(fname);

			if(fname.equals(sername))
			{
				String tpaHash=tp.getHashTpa(sername,id);
				String serHash=tp.getHashServer(sername,id);
				if(tpaHash.equals(serHash))
				{
					System.out.println("File is clear Not Hack:"+fname);

				}
				else
				{		
					boolean check=	tp.UpdateHackFile(fname,id);
					if(check==false)
					{
						System.out.println("File is hack:"+fname);
						if(str.length()==0)
						{
							str=fname;
						}else{
						str=str+","+fname;
						}
						System.out.println("str[j]+++++++++:"+str);
					}
					j++;
				}
			}
			else
			{

				System.out.println("str[j]*********:"+str);
				boolean check=tp.replaceFile(fname,id);
				if(check==false)
				{
					if(str.length()==0)
					{
						str=fname;
					}else{
					str=str+","+fname;
					}
					System.out.println("*****replace to server********"+fname+id);
				}
				j++;
			}


		}
		return str;

	} 

	public String getHashServer(String name,int id)
	{
		conn=Database.getConnection();
		ArrayList al=new ArrayList();
		String hash="";
		String id1 ="";
		query="select hashcode from fileinfo where fname='"+name+"' AND fkid="+id+"";
		try{
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				//id1=rs.getString(1);
				hash=rs.getString(1);
				//System.out.println(hash);


			}



		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return hash;

	}

	public String getFnameServer(String name)
	{
		conn=Database.getConnection();
		ArrayList al=new ArrayList();
		String fname="";

		query="select fname from fileinfo where fname='"+name+"'";
		try{
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				//id1=rs.getString(1);
				fname=rs.getString(1);
				//System.out.println(fname);

				//al.add(fname);
			}



		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return fname;

	}



	public String getHashTpa(String sername, int id)
	{
		conn=Database.getConnection();
		ArrayList al1=new ArrayList();
		String hash="";

		query="select hashcode from thirdparty where fkid="+id+" AND fname='"+sername+"'";
		try{
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{

				hash=rs.getString(1);
				//System.out.println(hash);
				//al1.add(id1);

			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return hash;

	}


	public boolean replaceFile(String sername, int id)
	{
		conn=Database.getConnection();
		ArrayList al1=new ArrayList();
		String hash="";
		boolean check=true;
		System.out.println("sername:"+sername+"id:"+id);
		String query="insert into fileinfo(id,fname,file,fpath,encpath,publicKey,hashcode,fkid) (select null,fname,file,null,encpath,publicKey,hashcode,fkid from thirdparty where fkid="+id+" AND fname='"+sername+"')";
		//String query="update fileinfo  set file=(select file from thirdparty where fkid="+id+" AND fname='"+sername+"') where fkid="+id+" AND fname='"+sername+"' ";
		
		
		try{
			s=conn.createStatement();
			check=s.execute(query);
			System.out.println("check:"+check);
			/*while(rs.next())
			{

				hash=rs.getString(1);
				System.out.println(hash);
				//al1.add(id1);

			}*/


		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return check;

	}

	public boolean UpdateHackFile(String sername, int id)
	{
		conn=Database.getConnection();
		ArrayList al1=new ArrayList();
		String hash="";
		boolean check=true;
		System.out.println("sername:"+sername+"id:"+id);
		//String query="insert into fileinfo(id,fname,file,fpath,encpath,publicKey,hashcode,fkid) (select null,fname,file,null,encpath,publicKey,hashcode,fkid from thirdparty where fkid="+id+" AND fname='"+sername+"')";
		String query="update fileinfo  set file=(select file from thirdparty where fkid="+id+" AND fname='"+sername+"'), hashcode=(select hashcode from thirdparty where fkid="+id+" AND fname='"+sername+"') where fkid="+id+" AND fname='"+sername+"' ";
		
		
		try{
			s=conn.createStatement();
			check=s.execute(query);
			System.out.println("check:"+check);
			/*while(rs.next())
			{

				hash=rs.getString(1);
				System.out.println(hash);
				//al1.add(id1);

			}*/


		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return check;

	}

	
	public ArrayList<String> getFnameTpa(int id)
	{
		conn=Database.getConnection();
		ArrayList<String> al2=new ArrayList<String>();
		String fname="";

		String query1="select fname from thirdparty where fkid="+id+"";
		try{
			s=conn.createStatement();
			rs=s.executeQuery(query1);
			while(rs.next())
			{

				fname=rs.getString(1);
				//System.out.println(fname);
				//al1.add(id1);
				al2.add(fname);
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al2;

	}

	public int setFlag(String id)
	{
		int n=0;
		
		 conn=Database.getConnection();
		try
		{
			s=conn.createStatement();
			n=s.executeUpdate("update thirdparty set status='1' where fkid='"+id+"'");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return n;
	}

	public int setAgainFlag(int id)
	{
		int n=0;
		
		 conn=Database.getConnection();
		try
		{
			s=conn.createStatement();
			n=s.executeUpdate("update thirdparty set status='0' where fkid="+id+"");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return n;
	}

	public String getFlag(int id)
	{
		String n="";
		
		 conn=Database.getConnection();
		try
		{
			s=conn.createStatement();
			rs=s.executeQuery("select status from thirdparty where fkid="+id+"");
			while(rs.next())
			{
				n=rs.getString(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return n;
	}

	public boolean storedTpaResponse(String filename, int id)
	{
		conn=Database.getConnection();
		String query="";
		String hash="";
		boolean check=true;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		
		
		
		query="select * from tparesponse where fk="+id;
		try{
			s=conn.createStatement();
			rs=s.executeQuery(query);
			
		
			if(rs.next())
			{
				
				query="update tparesponse where ";
				
				
			}else{
			
		
		
		 query="insert into tparesponse value(null,?,?,?)";
		System.out.println("query:"+query);
		//String query="update fileinfo  set file=(select file from thirdparty where fkid="+id+" AND fname='"+sername+"') where fkid="+id+" AND fname='"+sername+"' ";
		
		
		ps=conn.prepareStatement(query);
			//s=conn.createStatement();
			ps.setString(1, filename);
			ps.setTimestamp(2, ts);
			ps.setInt(3, id);
			check=ps.execute();
			//check=s.execute(query);
			System.out.println("check:"+check);
			/*while(rs.next())
			{

				hash=rs.getString(1);
				System.out.println(hash);
				//al1.add(id1);

			}*/

			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
		return check;

	}

	
	
	
	public boolean storedTpaHackFileResponse(String filename, int id)
	{
		conn=Database.getConnection();
		String query="";
		
		boolean check=true;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		
		try{
		
	
		 query="insert into tparesponse value(null,?,?,?)";
		System.out.println("query:"+query);
		//String query="update fileinfo  set file=(select file from thirdparty where fkid="+id+" AND fname='"+sername+"') where fkid="+id+" AND fname='"+sername+"' ";
		
		
		ps=conn.prepareStatement(query);
			//s=conn.createStatement();
			ps.setString(1, filename);
			ps.setTimestamp(2, ts);
			ps.setInt(3, id);
			check=ps.execute();
			//check=s.execute(query);
			System.out.println("check:"+check);
			/*while(rs.next())
			{

				hash=rs.getString(1);
				System.out.println(hash);
				//al1.add(id1);

			}*/

		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
		return check;

	}

	
	
	
	public static void main(String[] args) {
		TpaDao tp=new TpaDao();
		tp.batchAuditing(4);
	}
}
