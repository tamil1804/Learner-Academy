<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,com.management.dao.*,com.management.model.*" %>
<% int admin_id = Integer.parseInt(request.getParameter("admin_id")); %>
<% Admin admin = AdminDAO.getAdmin(admin_id); 
   String first_name = admin.getFirstName();
   String last_name = admin.getLastName();
   String user_name = admin.getUserName();
   String password = admin.getPassword();
   String email = admin.getEmail();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Edit</title>
</head>
<body>
<div align="center">
 <h1>Admin Edit form</h1>
 <form action = "<%= request.getContextPath() %>/EditProfileServlet" method="post">
   <table style="width: 30%">
   <tr>
       <td>Admin ID: </td>
       <td><input type="text" name="admin_id" value="<%= admin_id %>" readonly></td>
    </tr>
    <tr>
       <td>First Name: </td>
       <td><input type="text" name="firstName" value="<%= first_name %>"></td>
    </tr>
    <tr>
       <td>Last Name: </td>
       <td><input type="text" name="lastName" value="<%= last_name %>"></td>
    </tr>
    <tr>
       <td>User Name: </td>
       <td><input type="text" name="userName" value="<%= user_name %>"></td>
    </tr>
    <tr>
       <td>Password: </td>
       <td>
       <input type="password" name="password" value="<%= password %>"readonly>
       </td>
       <td>
       <% String path = "" + request.getContextPath() + "/changeAdminPassword.jsp?admin_id="+admin_id; %>
       <a href="<%= path %>">CHANGE PASSWORD</a>
       </td>
    </tr>
    <tr>
       <td>Address: </td>
       <td><input type="email" name="email" value="<%= email %>"></td>
    </tr>
    <tr>
       <td>Submit: </td>
       <td><input type="submit" name="REGISTER"></td>
    </tr>
    <tr><td><a href="<%= request.getContextPath() %>/HomeServlet">HOME</a></td></tr>
   </table>
 </form>
</div>
</body>
