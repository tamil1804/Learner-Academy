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
import com.management.model.Batch;

/**
 * Servlet implementation class EditBatchServlet
 */
@WebServlet("/EditBatchServlet")
public class EditBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int batchID = Integer.parseInt(request.getParameter("batch_id"));
        int[] subID = new int[8];
		
		subID[0]  = Integer.parseInt(request.getParameter("sub1"));
		subID[1]  = Integer.parseInt(request.getParameter("sub2"));
		subID[2]  = Integer.parseInt(request.getParameter("sub3"));
		subID[3]  = Integer.parseInt(request.getParameter("sub4"));
		subID[4]  = Integer.parseInt(request.getParameter("sub5"));
		subID[5]  = Integer.parseInt(request.getParameter("sub6"));
		subID[6]  = Integer.parseInt(request.getParameter("sub7"));
		subID[7]  = Integer.parseInt(request.getParameter("sub8"));
		
		try {
			int result = BatchDAO.updateBatch(batchID, subID);
			if(result!=0) {
				response.sendRedirect(request.getContextPath()+"/BatchEditedServlet");
			}else {
				response.sendRedirect(request.getContextPath()+"/BatchNotEditedServlet");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
