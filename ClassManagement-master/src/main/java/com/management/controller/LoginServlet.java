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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
  
        String username = request.getParameter("admin_name");
		String password = request.getParameter("password");
		
		int admin_id = AdminDAO.getAdminId(username);
		System.out.println(admin_id);
		Admin admin = AdminDAO.getAdmin(admin_id);
		
		
		if(username.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
			HttpSession session=request.getSession();
			session.setAttribute("admin_id",admin.getAdmin_id());
			session.setAttribute("user_name",admin.getUserName());
            session.setAttribute("first_name",admin.getFirstName());
            session.setAttribute("last_name",admin.getLastName());
            request.getRequestDispatcher("/HomeServlet").include(request, response);
			//response.sendRedirect(request.getContextPath() + "/HomeServlet");
		}else {
			response.sendRedirect(request.getContextPath() + "/LoginFailed");
		} 
        out.close();  
	}

}
