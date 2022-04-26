package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.println("<h1 align = 'center'>** Learner's Academy **</h1>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '30%' align  = 'center'>");
		HttpSession session = request.getSession(); 
		out.println("<th><td>Welcome! "+ session.getAttribute("first_name") + " " +session.getAttribute("last_name")+"</td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/addAdmin.jsp'>ADD ADMIN</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/AdminProfileServlet'>PROFILE</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/LogoutServlet'>LOGOUT</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '50%' align  = 'center'>");
		out.println("<th>");
		out.println("<td><a href='" + request.getContextPath() + "/addClass.jsp'>ADD CLASS</a></td>");
		out.println("<td><a href='" + request.getContextPath() + "/BatchViewServlet'>VIEW CLASSES</a></td>");
		out.println("<td><a href='" + request.getContextPath() + "/SubjectViewServlet'>VIEW SUBJECTS</a></td>");
		out.println("<td><a href='" + request.getContextPath() + "/StudentViewServlet'>VIEW STUDENTS</a></td>");
		out.println("</th>");
		out.println("</table>");
		out.println("</body>");
	}

}
