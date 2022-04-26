package com.management.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.dao.BatchDAO;
import com.management.model.Batch;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int[] subID = new int[8];
		
		subID[0]  = Integer.parseInt(request.getParameter("sub1"));
		subID[1]  = Integer.parseInt(request.getParameter("sub2"));
		subID[2]  = Integer.parseInt(request.getParameter("sub3"));
		subID[3]  = Integer.parseInt(request.getParameter("sub4"));
		subID[4]  = Integer.parseInt(request.getParameter("sub5"));
		subID[5]  = Integer.parseInt(request.getParameter("sub6"));
		subID[6]  = Integer.parseInt(request.getParameter("sub7"));
		subID[7]  = Integer.parseInt(request.getParameter("sub8"));
		
		Batch batch = new Batch();
		int curr_batchID = batch.setBatchID();
		batch.addSubjects(subID);
		
		System.out.println("Batch ID = " + curr_batchID);
		for(int i=0;i<8;i++)
			System.out.println(subID[i]);
		if(curr_batchID != 0) {
			try {
				int result = BatchDAO.createBatch(batch);
				if(result == 1) {
					response.sendRedirect(request.getContextPath()+"/ClassAddedServlet");
				}else {
					response.sendRedirect(request.getContextPath()+"/ClassAdditionFailedServlet");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("* * * Error in adding class * * *");
			response.sendRedirect(request.getContextPath()+"/ClassAdditionFailedServlet");
		}
	}

}
