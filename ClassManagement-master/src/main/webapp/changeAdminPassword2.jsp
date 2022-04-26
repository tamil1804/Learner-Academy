<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,com.management.dao.*,com.management.model.*" %>
<% 
int adminID = Integer.parseInt(request.getParameter("admin_id"));
Admin admin = AdminDAO.getAdmin(adminID);
String old_password = admin.getPassword();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Admin Password</title>
</head>
<body>
<h1 align="center">CHANGE ADMIN PASSWORD</h1>
<form action="<%= request.getContextPath() %>/ChangeAdminPassword" method="post">
<input type="hidden" name="admin_id" value="<%= adminID%>">
<table width="35%" align="center">
<tr><td>Old Password</td><td><input type="text" value=<%= old_password%> readonly></td></tr>
<tr><td>New Password</td><td><input type="text" name="new_password"></td></tr>
<tr><td>Confirm New Password</td><td><input type="text" name="new_password1"></td></tr>
<tr><br></tr>
<tr><td><input type="submit" value="UPDATE PASSWORD"></td></tr>
<tr><td><a href="<%= request.getContextPath() %>/HomeServlet">HOME</a></td></tr>
</table>
</form>
</body>
</html>