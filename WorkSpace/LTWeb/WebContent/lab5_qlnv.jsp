<%@page import="model.EmployeeDAO"%>
<%@page import="model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Lab5-QLNV</title>
<style>
#center {
	margin-left: 100px;
}
</style>
</head>
<body>
	<%
		ArrayList<Employee> lstEmployees = EmployeeDAO.getListEmployee();
	%>
	<h2 class="text-center">Quản lý nhân viên</h2>
	<div>
	<input type="text" placeholder="Nhập giá trị tìm kiếm..." style="margin-left: 30%; width: 39%; height: 33px;" autofocus="autofocus">
	<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;Tìm kiếm</button>
	<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;Thêm mới</button>
	</div>
	<br>
	<div class="container" id=center>
		<table class="table table-striped table-hover">
			<tr>
				<th>STT</th>
				<th>Mã NV</th>
				<th>Họ tên</th>
				<th>Ngày sinh</th>
				<th>Quê quán</th>
				<th>Thao tác</th>
			</tr>
			<%
				for (int i = 0; i < lstEmployees.size(); i++) {
					Employee e = lstEmployees.get(i);
			%>
			<tr>
				<td><%=e.getNo()%>
				<td><%=e.getId()%>
				<td><%=e.getName()%>
				<td><%=e.getDob()%>
				<td><%=e.getAddress()%>
				<td><a href="#"><button type="button" class="btn btn-info"><span class="glyphicon glyphicon-info-sign"></span></button></a>
				<a href="#"><button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span></button></a> <a
					href="#"><button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></a>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>