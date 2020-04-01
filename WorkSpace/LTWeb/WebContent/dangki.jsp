<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<td><input type="text" name="email"> <br> <%
if (request.getAttribute("email_err") !=null){
out.print("<fontcolor=\"red\">"+(String)request.getAttribute("email_err")+"</color");
		

}
%></td>

</body>
</html>