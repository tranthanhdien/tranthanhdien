<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<!-- <%Employee e = (Employee)request.getAttribute("p"); %>  -->
	<form action="ServletSua" method="post">
		<table width="400" border="2" cellpadding="5" align="center">
			<tr>
				<th colspan="2">Sửa Nhân viên</th>
			</tr>

			<tr>
				<td>STT:</td>
				<td><input type="text" name="no" value=" " size="30"></td>
			</tr>

			<tr>
				<td>Mã NV:</td>
				<td><input type="text" name="id" value="" size="30"></td>
			</tr>

			<tr>
				<td>Họ tên:</td>
				<td><input type="text" name="name" value="" size="30"></td>
			</tr>

			<tr>
				<td>Ngày sinh:</td>
				<td><input type="text" name="dob" value="" size="30"></td>
			</tr>
			<tr>
				<td>Quê quán:</td>
				<td><input type="text" name="address" value="" size="30"></td>
			</tr>




			<tr>
				<td colspan="2" align="center"><input type="submit" name="add"
					value="Sửa">
			</tr>
		</table>
	</form>
</body>
</html>