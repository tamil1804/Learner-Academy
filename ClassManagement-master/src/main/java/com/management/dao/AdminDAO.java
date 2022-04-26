package com.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.management.model.Admin;

public class AdminDAO {
	public static int setAdminId() {
		int id=0;
		try{
			Connection connection = DBConnection.createConnection();
			PreparedStatement ps=connection.prepareStatement("SELECT MAX(admin_id) AS last_id FROM admin");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				id=rs.getInt("last_id");
				id++;
			}
			System.out.println("setAdminID(). ID set to - " + id);
		}catch(Exception e){System.out.println(e);}
		System.out.println("setAdminID(). ID set to - " + id);
		return id;
	}
	
	public static boolean checkAdminPassword(int adminID,String password) {
		int id=adminID;
		try{
			Connection connection = DBConnection.createConnection();
			String query = "Select password FROM admin WHERE admin_id='"+id+"'";
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String curr_password=rs.getString("password");
				if(curr_password.equals(password)) {
					return true;
				}
			}
		}catch(Exception e){System.out.println(e);}
		return false;
	}
	
	public static boolean updateAdminPassword(int adminID,String password) {
		int id=adminID;
		try{
			Connection connection = DBConnection.createConnection();
			String query = "UPDATE admin SET password = '"+password+"' WHERE admin_id="+id;
			PreparedStatement ps=connection.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 1){
				return true;
			}
		}catch(Exception e){System.out.println(e);}
		return false;
	}
	
	public static boolean updateAdmin(int adminID,Admin admin) {
		int id=adminID;
		try{
			Connection connection = DBConnection.createConnection();
			String query = "UPDATE admin SET first_name=?, last_name=?, user_name=?, email=? WHERE admin_id="+id;
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, admin.getFirstName());
			ps.setString(2, admin.getLastName());
			ps.setString(3, admin.getUserName());
			ps.setString(4, admin.getEmail());
			int result = ps.executeUpdate();
			if(result == 1){
				return true;
			}
		}catch(Exception e){System.out.println(e);}
		return false;
	}
	
	public static int getAdminId(String username) {
		int id=0;
		try{
			Connection connection = DBConnection.createConnection();
			String query = "Select admin_id FROM admin WHERE user_name='"+username+"'";
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				id=rs.getInt(1);
				System.out.println(id);
			}else {
				System.out.println("no r.next()");
			}
		}catch(Exception e){System.out.println(e + "yo");}
		System.out.println("getAdminID(). ID set to - " + id);
		return id;
	}
	
	public static Admin getAdmin(int admin_id) {
		Admin admin = new Admin();
		try{
			Connection connection = DBConnection.createConnection();
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM admin WHERE admin_id="+admin_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setFirstName(rs.getString("first_name"));
				admin.setLastName(rs.getString("last_name"));
				admin.setUserName(rs.getString("user_name"));
				admin.setPassword(rs.getString("password"));
				admin.setEmail(rs.getString("email"));
			}
		}catch(Exception e){System.out.println(e);}
		System.out.println("Admin returned");
		return admin;
	}
	
	public static int registerAdmin(Admin admin) throws ClassNotFoundException, SQLException{
		System.out.print("registerAdmin(). New Admin Register.");
		String insert_emp_query = "INSERT INTO admin" + 
	                              " (admin_id,first_name,last_name,user_name,password,email)" +
				                  " VALUES (?,?,?,?,?,?)";
		int result = 0;
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps = connection.prepareStatement(insert_emp_query);
		ps.setInt(1,setAdminId());
		ps.setString(2, admin.getFirstName());
		ps.setString(3, admin.getLastName());
		ps.setString(4, admin.getUserName());
		ps.setString(5, admin.getPassword());
		ps.setString(6, admin.getEmail());
		
		System.out.println("preparedStatement");
		//executing query
		result = ps.executeUpdate();
		return result;
	}
}
