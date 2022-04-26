package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.management.dao.DBConnection;

/**
 * Servlet implementation class StudentViewServlet
 */
@WebServlet("/StudentViewServlet")
public class StudentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.println("<h1 align = 'center'>** Students **</h1>");
		//out.println("<br><br><br>");
		out.println("<table border = '4' width = '25%' align  = 'right'>");
		HttpSession session = request.getSession(); 
		out.println("<th><td>Welcome! "+ session.getAttribute("first_name") + " " +session.getAttribute("last_name")+"</td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/LogoutServlet'>LOGOUT</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		
		out.println("<table border = '4' width = '75%' align  = 'center'>");
		out.println("<th>");
		out.println("<td>Student ID</td>");
		out.println("<td>Name</td>");
		out.println("<td>Address</td>");
		out.println("<td>Contact</td>");
		out.println("<td>Batch ID</td>");
		out.println("<td>Delete Student</td>");
		out.println("</th>");
		
		out.println("<tr>");
		
		Connection connection;
		try {
			connection = DBConnection.createConnection();
			String extract_student_details = "SELECT * FROM student1";
			PreparedStatement ps=connection.prepareStatement(extract_student_details);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int student_id = rs.getInt(1);
				int batch_id = rs.getInt(2);
				String name = rs.getString(3);
				String address = rs.getString(4);
				String contact = rs.getString(5);
				out.println("<td> </td>");
				out.println("<td>" + student_id + "</td>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + address + "</td>");
				out.println("<td>" + contact + "</td>");
				out.println("<td>" + batch_id + "</td>");
				out.println("<td>");
				out.println("<a href='" + request.getContextPath() + "/DeleteStudentServlet?student_id="+ student_id +"'>DELETE</a>");
				out.println("</td>");
				out.println("</tr>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '20%' align  = 'center'>");
		out.println("<th><td><a href='"+request.getContextPath()+"/addStudent.jsp'>ADD Student</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/HomeServlet'>HOME PAGE</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("</body>");
	}

}
