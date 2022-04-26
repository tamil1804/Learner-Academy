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
 * Servlet implementation class BatchNotEditedServlet
 */
@WebServlet("/BatchNotEditedServlet")
public class BatchNotEditedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchNotEditedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<h1>Class not edited in database</h1>");
		//out.println("<br><br><br>");
		out.println("<table border = '4' width = '20%' align  = 'right'>");
		HttpSession session = request.getSession(); 
		out.println("<th><td>Welcome! "+ session.getAttribute("first_name") + " " +session.getAttribute("last_name")+"</td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/LogoutServlet'>LOGOUT</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '20%' align  = 'center'>");
		out.println("<th><td><a href='"+request.getContextPath()+"/HomeServlet'>HOME PAGE</a></td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/'>BACK</a></td></th>");
		out.println("</table>");
	}

}
