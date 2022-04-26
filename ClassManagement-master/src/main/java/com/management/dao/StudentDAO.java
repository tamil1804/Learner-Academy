package com.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.management.model.Student;
import com.management.model.Subject;

public class StudentDAO {
	
	public static int getStudentId() {
		int id=0;
		try{
			Connection connection = DBConnection.createConnection();
			PreparedStatement ps=connection.prepareStatement("SELECT MAX( student_id ) AS last_id FROM student1");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				id=rs.getInt("last_id");
				id++;
			}
		}catch(Exception e){System.out.println(e);}
		return id;
	}
	
	public static int addStudent(Student student) throws ClassNotFoundException, SQLException{
		String insert_emp_query = "INSERT INTO student1 (student_id,batch_id,name,address,contact)" +
			                      " VALUES (?,?,?,?,?)";
		int result = 0;
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps = connection.prepareStatement(insert_emp_query);
		ps.setInt(1,getStudentId());
		ps.setInt(2, student.getBatch_id());
		ps.setString(3, student.getName());
		ps.setString(4, student.getAddress());
		ps.setString(5, student.getContact());
	
		System.out.println("preparedStatement");
		//executing query
		result = ps.executeUpdate();
		return result;
	}
	
	public static int deleteStudent(int student_id) throws ClassNotFoundException, SQLException{
		String delete_student = "DELETE FROM student1 WHERE student_id = " + student_id;
		int result = 0;
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps = connection.prepareStatement(delete_student);
		System.out.println("preparedStatement");
		//executing query
		result = ps.executeUpdate();
		return result;
	}
	
	public static ArrayList<Student> studentOfBatch(int batch_id) throws ClassNotFoundException, SQLException{
		ArrayList<Student> list = new ArrayList<Student>();
		String query = "SELECT * FROM student1 WHERE batch_id="+batch_id;
		Connection connection = DBConnection.createConnection();
		PreparedStatement ps = connection.prepareStatement(query);
		System.out.println("preparedStatement");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int student_id = rs.getInt(1);
			String name = rs.getString(3);
			String address = rs.getString(4);
			String contact = rs.getString(5);
			Student temp = new Student();
			temp.setName(name);
			temp.setStudent_id(student_id);
			temp.setBatch_id(batch_id);
			temp.setAddress(address);
			temp.setContact(contact);
			list.add(temp);
		}
		return list;
	}
}
