package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.dao.BatchDAO;

/**
 * Servlet implementation class DeleteBatchServlet
 */
@WebServlet("/DeleteBatchServlet")
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<h1>Delete Batch Servlet</h1>");
		int batchID = Integer.parseInt(request.getParameter("batch_id"));
		int result = 0;
		try {
			result = BatchDAO.deleteBatch(batchID);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(result == 1) {
			response.sendRedirect(request.getContextPath() + "/BatchDeletedServlet");
		}else {
			response.sendRedirect(request.getContextPath() + "/BatchDeletionFailedServlet");
		}
	}

}
