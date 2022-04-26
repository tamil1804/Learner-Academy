<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
<div align="center">
 <h1>Student Registration form</h1>
 <form action = "<%= request.getContextPath() %>/AddStudentServlet" method="post">
   <table style="width: 80%">
   <tr>
       <td>Batch ID: </td>
       <td><input type="text" name="batchID"></td>
    </tr>
    <tr>
       <td>Name: </td>
       <td><input type="text" name="name"></td>
    </tr>
    <tr>
       <td>Address: </td>
       <td><input type="text" name="address"></td>
    </tr>
    <tr>
       <td>Contact: </td>
       <td><input type="text" name="contact"></td>
    </tr>
    <tr>
       <td>Submit: </td>
       <td><input type="submit" name="REGISTER"></td>
    </tr>
   </table>
 </form>
</div>
</body>
</html>