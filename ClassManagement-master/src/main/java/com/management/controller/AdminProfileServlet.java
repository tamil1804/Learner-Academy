package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.management.dao.AdminDAO;
import com.management.model.Admin;

/**
 * Servlet implementation class AdminProfileServlet
 */
@WebServlet("/AdminProfileServlet")
public class AdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileServlet() {
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
		out.println("<h1 align = 'center'>** Administrator Profile **</h1>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '30%' align  = 'center'>");
		HttpSession session = request.getSession(); 
		int admin_id = (int) session.getAttribute("admin_id");

		Admin admin = AdminDAO.getAdmin(admin_id);
		String first_name = admin.getFirstName();
		String last_name = admin.getLastName();
		String user_name = admin.getUserName();
		//String password = admin.getPassword();
		String email = admin.getEmail();
		
		out.println("<tr><td>Admin ID</td><td>"+ admin_id +"</td></tr>");
		out.println("<tr><td>First Name</td><td>"+ first_name +"</td></tr>");
		out.println("<tr><td>Last Name</td><td>"+ last_name +"</td></tr>");
		out.println("<tr><td>User Name</td><td>"+ user_name +"</td></tr>");
		out.println("<tr><td>Password</td><td>*******</td></tr>");
		out.println("<tr><td>Email</td><td>"+ email +"</td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4'  align  = 'center'>");
		out.println("<th>");
		out.println("<td><a href='" + request.getContextPath() + "/editAdmin.jsp?admin_id="+admin_id+"'>EDIT PROFILE</a></td>");
		out.println("<td><a href='" + request.getContextPath() + "/HomeServlet'>BACK HOME</a></td>");
		out.println("</th>");
		out.println("</table>");
		out.println("</body>");
	}

}
