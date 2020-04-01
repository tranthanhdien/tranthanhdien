<% 
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị thông tin lab2</title>
</head>
<body>
<div style="text-align: center">
<h1>Thông tin người dùng đã đăng ký </h1>
	<p>First name: <%=request.getAttribute("firstName") %> </p>
	<p>Last name: <%=request.getAttribute("lastName") %> </p>
	<p>User name: <%=request.getAttribute("userName") %> </p>
	<p>Dob: <%=request.getAttribute("dob") %> </p>
	<p>Password: <%=request.getAttribute("password") %> </p>
	<p>Re-Password: <%=request.getAttribute("re_password") %> </p>
	<p>Address: <%=request.getAttribute("address") %> </p>
	<p>Sex: <%=request.getAttribute("sex") %> </p>
	</div>
</body>
</html>