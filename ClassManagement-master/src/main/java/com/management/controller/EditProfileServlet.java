package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.dao.AdminDAO;
import com.management.model.Admin;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adminID = Integer.parseInt(request.getParameter("admin_id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Admin emp = new Admin();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setUserName(userName);
		emp.setPassword(password);
		emp.setEmail(email);
		
		
		boolean result = false;
		result = AdminDAO.updateAdmin(adminID,emp);
		if(result) {
			response.sendRedirect(request.getContextPath()+"/AdminAddedServlet");
		}else {
			response.sendRedirect(request.getContextPath()+"/AdminFailedServlet");
		}
	}

}
