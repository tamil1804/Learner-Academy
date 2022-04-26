package com.management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.management.dao.BatchDAO;
import com.management.dao.DBConnection;
import com.management.dao.SubjectDAO;

/**
 * Servlet implementation class ViewBatchServlet
 */
@WebServlet("/ViewBatchServlet")
public class ViewBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int batchID = Integer.parseInt(request.getParameter("batch_id"));
        int subID[] = new int[8];
        for(int i=0;i<8;i++) {
			subID[i] = 0;
		}
        try {
			int temp[] = BatchDAO.extractBatchSubjectsByID(batchID);
			for(int i=0;i<8;i++) {
				subID[i] = temp[i];
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		
		out.println("<h1 align = 'center'>** SCHOOL CLASSES **</h1>");
		out.println("<body>");
		//out.println("<br><br><br>");
		out.println("<table border = '4' width = '20%' align  = 'right'>");
		HttpSession session = request.getSession(); 
		out.println("<th><td>Welcome! "+ session.getAttribute("first_name") + " " +session.getAttribute("last_name")+"</td></th>");
		out.println("<th><td><a href='"+request.getContextPath()+"/LogoutServlet'>LOGOUT</a></td></th>");
		out.println("</table>");
		out.println("<br><br><br>");
		out.println("<table border = '4' width = '25%' align  = 'center'>");
		out.println("<th>");
		out.println("<td>Class ID : " + batchID + "</td>");
		out.println("</th>");
		out.println("</table>");
		
		out.println("<table border = '4' width = '25%' align  = 'center'>");
		out.println("<th>");
		out.println("<td>Subject ID</td>");
		out.println("<td>Subject Name</td>");
		out.println("<td>Subject Teacher</td>");
		out.println("</th>");
		
		for(int i=0;i<8;i++) {
			out.println("<tr>");
			int tempN = i+1;
			out.println("<td>Subject " + tempN + "</td>");
			com.management.model.Subject temp = SubjectDAO.getSubject(subID[i]);
			int curr_subID = temp.getSubjectID();
			String name = "";
			String teacher_name = "";
			if(curr_subID == 0) {
				name += "FREE PERIOD";
				teacher_name += "EMPTY";
			}else {
				name += temp.getName();
				teacher_name += temp.getTeacherName();
			}
			out.println("<td> " + curr_subID + "</td>");
			out.println("<td> " + name + "</td>");
			out.println("<td> " + teacher_name + "</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<br><br>");
		out.println("<a href='" + request.getContextPath() + "/addClass.jsp' align='center'>ADD BATCH</a>");
		out.println("</body>");
	}

}
