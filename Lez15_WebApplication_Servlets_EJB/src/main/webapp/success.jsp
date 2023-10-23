<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.dto.StudentDTO" %>
<%@ page import = "com.key.SessionKey" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Correct Registration/Update</title>
</head>
<%-- Down cast --%>
<%
StudentDTO studentDTO = (StudentDTO)session.getAttribute(SessionKey.studentsDTOKey);
String lastName = studentDTO.getLastName();
String message = "Registrazione Studente " + lastName + " corretta!";
%>
<body>
	<%= message %><br/><br/>
	<a href="studentRegistration.html">Register another student</a>
	<br/>
	<a href="students">Students List</a>
</body>
</html>