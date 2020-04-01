<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin đăng ký</title>
</head>
<body>
	<h1>Thông tin người dùng đã đăng ký </h1>
	<p>Username : <%=request.getAttribute("username") %> </p>
	<p>Password : <%=request.getAttribute("password") %> </p>
</body>
</html>