package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.management.dao.StudentDAO;
import com.management.model.Student;

/**
 * Servlet implementation class BatchStudentsServlet
 */
@WebServlet("/BatchStudentsServlet")
public class BatchStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchStudentsServlet() {
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
		out.println("<h1 align = 'center'>** Students of the class "+request.getParameter("batch_id")+" **</h1>");
		//out.println("<br><br><br>");
		out.println("<table border = '4' width = '20%' align  = 'right'>");
		HttpSession session = request.getSession(); 
		out.println("<th><td>Welcome! "+ session.getAttribute("first_name") + " " +session.getAttribute("last_name")+"</td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/LogoutServlet'>LOGOUT</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '25%' align  = 'center'>");
		out.println("<th>");
		out.println("<td>Student ID</td>");
		out.println("<td>Name</td>");
		out.println("<td>Address</td>");
		out.println("<td>Contact</td>");
		out.println("</tr>");
		int batch_id = Integer.parseInt(request.getParameter("batch_id"));
		try {
			ArrayList<Student> list = StudentDAO.studentOfBatch(batch_id);
			for(int i=0;i<list.size();i++) {
				out.println("<tr>");
				out.println("<td></td>");
				out.println("<td>"+list.get(i).getStudent_id()+"</td>");
				out.println("<td>"+list.get(i).getName()+"</td>");
				out.println("<td>"+list.get(i).getAddress()+"</td>");
				out.println("<td>"+list.get(i).getContact()+"</td>");
				out.println("<tr>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<br><br>");
		out.println("<table border = '4' width = '30%' align  = 'center'>");
		out.println("<th>");
		out.println("<td><a href='" + request.getContextPath() + "/BatchViewServlet'>VIEW CLASSES</a></td>");
		out.println("<td><a href='" + request.getContextPath() + "/HomeServlet'>HOME</a></td>");
		out.println("</th>");
		out.println("</table>");
	}

}
