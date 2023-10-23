<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.vo.StudentVO" %>
<%@ page import = "com.key.SessionKey" %>
<%@ page import = "java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students List</title>
</head>
<%
ArrayList<StudentVO> students = (ArrayList<StudentVO>)session.getAttribute(SessionKey.studentsListKey);
%>
<body>
	<a href="home.html">Return to Home</a>
	<br/>
	<br/>
	<table>
    	<tr>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Age</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td style="text-align: center">${student.firstName}</td>
                <td style="text-align: center">${student.lastName}</td>
                <td style="text-align: center">${student.age}</td>
                <td style="text-align: center"><c:url value="toUpdate" var="updateUrl">
                    <c:param name="id" value="${student.id}" />
                    </c:url> <a href="${updateUrl}">update</a></td>
                <td style="text-align: center"><c:url value="delete"
                        var="deleteUrl">
                        <c:param name="id" value="${student.id}" />
                    </c:url> <a href="${deleteUrl}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
	<a href="home.html">Return to Home</a>
</body>
</html>