<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Control?action=login" method="post">
		<table>
			<tr>
				<td><label>Name: </label></td>
				<td><input type="text" name="name"><br>
				<%if(request.getAttribute("nameErr") != null) {%>
				<a><%=request.getAttribute("nameErr") %></a>
				<%} %>
				
				</td>
			</tr>
			<tr>
				<td><label>Pass: </label></td>
				<td><input type="password" name="pass"><br>
				<%if(request.getAttribute("passErr") != null){ %>
				<a><%=request.getAttribute("passErr") %></a>
				<%} %>
				
				</td>
			</tr>
			<tr>
				<td>
				<td colspan="2"><input type="submit" name="Submit"></td>
			</tr>


		</table>


	</form>

</body>
</html>