package com.management.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.management.dao.StudentDAO;
import com.management.model.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = new Student();
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("contact"));
		System.out.println(request.getParameter("batchID"));
		student.setName(request.getParameter("name"));
		student.setAddress(request.getParameter("address"));
		student.setContact(request.getParameter("contact"));
		student.setBatch_id(Integer.parseInt(request.getParameter("batchID")));
		
		try {
			int result = StudentDAO.addStudent(student);
			if(result == 1) {
				response.sendRedirect(request.getContextPath() + "/StudentViewServlet");
			}else {
				response.sendRedirect(request.getContextPath() + "/StudentAdditionFailedServlet");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
