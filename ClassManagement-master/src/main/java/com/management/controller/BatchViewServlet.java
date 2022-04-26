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

import com.management.dao.*;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/BatchViewServlet")
public class BatchViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.println("<h1 align = 'center'>** CLASSES **</h1>");
		//out.println("<br><br><br>");
		out.println("<table border = '4' width = '20%' align  = 'right'>");
		HttpSession session = request.getSession(); 
		out.println("<th><td>Welcome! "+ session.getAttribute("first_name") + " " +session.getAttribute("last_name")+"</td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/LogoutServlet'>LOGOUT</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '25%' align  = 'center'>");
		out.println("<th>");
		out.println("<td>Class ID</td>");
		for(int i=1;i<=8;i++) {
			out.println("<td>Subject</td>");
		}
		out.println("<td>Delete</td>");
		out.println("<td>View</td>");
		out.println("<td>Edit</td>");
		out.println("<td>View Students</td>");
		out.println("</th>");
		
		out.println("<tr>");
		
		Connection connection;
		try {
			connection = DBConnection.createConnection();
			String extract_batch_details = "SELECT * FROM batch1";
			PreparedStatement ps=connection.prepareStatement(extract_batch_details);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int curr_batchID = rs.getInt(1);
				out.println("<td> </td>");
				out.println("<td>" + curr_batchID + "</td>");
				for(int i=2;i<=9;i++) {
					int curr_subID = rs.getInt(i);
					String query = "SELECT * FROM subject WHERE subject_id = " + curr_subID;
					PreparedStatement ps1=connection.prepareStatement(query);
					ResultSet rs1=ps1.executeQuery();
					String subName = "";
					//String teacherName = "";
					if(rs1.next()) {
						subName += rs1.getString(2);
						//teacherName += rs1.getString(3);
					}
					if(subName == "")
						out.println("<td> FREE </td>");
					else
					    out.println("<td>" + subName + "</td>");
				}
				out.println("<td>");
				out.println("<a href='" + request.getContextPath() + "/DeleteBatchServlet?batch_id="+ curr_batchID +"'>DELETE</a>");
				out.println("</td>");
				
				out.println("<td>");
				out.println("<a href='" + request.getContextPath() + "/ViewBatchServlet?batch_id="+ curr_batchID +"'>VIEW</a>");
				out.println("</td>");
				
				out.println("<td>");
				out.println("<a href='" + request.getContextPath() + "/editClass.jsp?batch_id="+ curr_batchID +"'>EDIT</a>");
				out.println("</td>");
				
				out.println("<td>");
				out.println("<a href='" + request.getContextPath() + "/BatchStudentsServlet?batch_id="+ curr_batchID +"'>STUDENTS</a>");
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
		out.println("<th><td><a href='"+request.getContextPath()+"/addClass.jsp'>ADD CLASS</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/HomeServlet'>HOME PAGE</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/'>BACK</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("</body>");
	}


}
