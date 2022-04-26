<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String admin_id = request.getParameter("admin_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Admin Password</title>
</head>
<body>
<h1 align="center">CHANGE ADMIN PASSWORD</h1>
<form action="<%= request.getContextPath() + "/CheckAdminPasswordServlet" %>" method="post">
<input type="hidden" name="admin_id" value="<%= admin_id %>">
<table width="35%" align="center">
<tr><td>Old Password</td><td><input type="text" name="old_password"></td>
<td><input type="submit" value="CHECK PASSWORD"></td>
</tr>
<tr><td>New Password</td><td><input type="text" name="new_password"></td></tr>
<tr><td><a href="<%= request.getContextPath() %>/HomeServlet">HOME</a></td></tr>
</table>
</form>
</body>
</html>