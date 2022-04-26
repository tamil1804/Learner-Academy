package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.dao.AdminDAO;

/**
 * Servlet implementation class ChangeAdminPassword
 */
@WebServlet("/ChangeAdminPassword")
public class ChangeAdminPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAdminPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int admin_id = Integer.parseInt(request.getParameter("admin_id"));
		String new_password = request.getParameter("new_password");
		String new_password1 = request.getParameter("new_password1");
		if(new_password.equals(new_password1)) {
			if(AdminDAO.updateAdminPassword(admin_id, new_password)) {
				response.sendRedirect(request.getContextPath() + "/AdminProfileServlet");
			}else {
				out.println("Database Error! Password not changed.");
				response.sendRedirect(request.getContextPath() + "/changeAdminPassword2.jsp?admin_id="+admin_id);
			}
		}else {
			out.println("Enter same password in both! Password not changed.");
			response.sendRedirect(request.getContextPath() + "/changeAdminPassword2.jsp?admin_id="+admin_id);
		}
		
	}

}
