package dbConnection;

import java.sql.*;
public class Database {

	public static String DriverString="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/tpa";
	public static String username="root";
	public static String password="root";
	public static Connection conn;
	
	public static Connection getConnection()
	{
		try{
		Class.forName(DriverString);
		conn=DriverManager.getConnection(url, username, password);
		System.out.println("connection established");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return conn;
	}
	
	
	
	
}

/*
CREATE TABLE fileinfo(
fid INT(20) NOT NULL AUTO_INCREMENT,
fname VARCHAR(50),
path varchar(50),
encryption blob,
fkey varchar(128),
hashcode blob,
orignalpath varchar(50),
fkid INT(20),
PRIMARY KEY(fid),
FOREIGN KEY(fid) REFERENCES registration(autoid)
);
*/