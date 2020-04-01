<%@page import="model.EmployeeSalaryDAO"%>
<%@page import="model.EmployeeSalary"%>
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
<title>Lab5-HSL</title>
<style>
#center {
	margin-left: 100px;
}
</style>
</head>
<body>
	<%
		ArrayList<EmployeeSalary> lstEmployees = EmployeeSalaryDAO.getListEmployee();
	%>
	
	<h2 class="text-center">Thiết lập hệ số lương cho nhân viên</h2>
	<div>
		<input type="text" placeholder="Nhập giá trị tìm kiếm..."
			style="margin-left: 30%; width: 39%; height: 33px;"
			autofocus="autofocus">
		<button type="button" class="btn btn-primary">
			<span class="glyphicon glyphicon-search"></span>&nbsp;Tìm kiếm
		</button>
	</div>
	<br>
	<div class="container" id=center>
		<table class="table table-striped table-hover">
			<tr>
				<th>STT</th>
				<th>Mã NV</th>
				<th>Họ tên</th>
				<th>Loại nhân viên</th>
				<th>Lương theo ngày</th>
				<th>Thao tác</th>
			</tr>
			<%
				for (int i = 0; i < lstEmployees.size(); i++) {
					EmployeeSalary e = lstEmployees.get(i);
			%>
			<tr>
				<td><%=e.getNo()%>
				<td><%=e.getId()%>
				<td><%=e.getName()%>
				<td><%=e.getEmployeeType()%>
				<td><%=e.getSalary()%>
				<td><a href="ServletXoaSanPham?index=<%=i%>"><button
							type="button" class="btn btn-primary">
							<span class="glyphicon glyphicon-edit"></span>
						</button></a>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>