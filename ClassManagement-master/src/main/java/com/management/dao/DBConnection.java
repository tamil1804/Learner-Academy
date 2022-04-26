package com.management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection createConnection() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/classmanagement?useSSL=false";
		String username = "root";
		String password = "@Suyash0605#";
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			if(con!= null) {
				//System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
				System.out.println("* * * Connection Established");
				//System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
			}
			
		}catch(SQLException e){System.out.println(e);}
		return con;
		
	}
}

