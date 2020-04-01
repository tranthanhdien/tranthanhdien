
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="xulyform" method="post">
		Email: <input type="email" name="txtEmail"><br> Password:
		<input type="password" name="txtPass"><br> <input
			type="submit" value="Send">

		<%
			if (request.getAttribute("email_err") == null) {

			} else {
				out.print("<font color=\"red\">" + (String) request.getAttribute("email_err") + "</color");
			}
			
		%>

	</form>
</body>
</html>