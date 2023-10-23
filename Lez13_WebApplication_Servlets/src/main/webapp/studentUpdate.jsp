<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.vo.StudentVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Update</title>
</head>
<%
StudentVO studentVO = (StudentVO)session.getAttribute("sessionVO");
%>
<body>
<form method="post" action="update">
	<input type="hidden" name="id" value="${studentVO.id}"/>
	<label for="FirstName">FirstName</label>
	<input type="text" name="firstName" value="${studentVO.firstName}"/><br/><br/><br/>
	<label for="LastName">LastName</label>
	<input type="text" name="lastName" value="${studentVO.lastName}"/><br/><br/><br/>
	<label for="Age">Age</label>
	<input type="text" name="age" value="${studentVO.age}"/><br/><br/><br/>
	<input type="submit" value="Update"/>
	<br/>
	<br/>
	<a href="home.html">Return to Home</a>
</form>
</body>
</html>