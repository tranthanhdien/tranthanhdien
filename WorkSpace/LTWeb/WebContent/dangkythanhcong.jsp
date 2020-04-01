<%@page import="test.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if (session.getAttribute("Person")==null) {%>
	<jsp:forward page="dangki.jsp"></jsp:forward>
	
	<%
} else {
	Person account = (Person)session.getAttribute("Person");
	out.print(account.getEmail());
	
}
%>
</body>
</html>