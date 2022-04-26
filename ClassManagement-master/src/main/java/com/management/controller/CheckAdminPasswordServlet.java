package com.management.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.dao.AdminDAO;

/**
 * Servlet implementation class CheckAdminPasswordServlet
 */
@WebServlet("/CheckAdminPasswordServlet")
public class CheckAdminPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int admin_id = Integer.parseInt(request.getParameter("admin_id"));
		String password = request.getParameter("old_password");
		if(AdminDAO.checkAdminPassword(admin_id, password)) {
			response.sendRedirect(request.getContextPath() + "/changeAdminPassword2.jsp?admin_id="+admin_id);
		}
	}

}
