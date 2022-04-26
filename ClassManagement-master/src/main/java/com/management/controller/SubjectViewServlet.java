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
 * Servlet implementation class SubjectViewServlet
 */
@WebServlet("/SubjectViewServlet")
public class SubjectViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println("<h1 align = 'center'>** SUBJECTS **</h1>");
		out.println("<body>");
		//out.println("<br><br><br>");
		out.println("<table border = '4' width = '20%' align  = 'right'>");
		HttpSession session = request.getSession(); 
		out.println("<th><td>Welcome! "+ session.getAttribute("first_name") + " " +session.getAttribute("last_name")+"</td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/LogoutServlet'>LOGOUT</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '25%' align  = 'center'>");
		out.println("<th>");
		out.println("<td>Subject ID</td>");
		out.println("<td>Class Name</td>");
		out.println("<td>Teacher Name</td>");
		out.println("<td>Delete</td>");
		out.println("<td>View</td>");
		out.println("<td>Edit</td>");
		out.println("</th>");
		
		out.println("<tr>");
		
		Connection connection;
		try {
			connection = DBConnection.createConnection();
			String extract_subject_details = "SELECT * FROM subject";
			PreparedStatement ps=connection.prepareStatement(extract_subject_details);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				out.println("<td> </td>");
				out.println("<td>" + rs.getInt(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td> <a href=''>DELETE</a> </td>");
				out.println("<td> <a href=''>VIEW</a> </td>");
				out.println("<td> <a href=''>EDIT</a> </td>");
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
		out.println("<th><td><a href='"+request.getContextPath()+"/HomeServlet'>HOME PAGE</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/AddSubjectServlet'>ADD SUBJECT</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/'>BACK</a></td></th>");
		out.println("</table>");
		out.println("</body>");
	}

}
