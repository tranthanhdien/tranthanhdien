<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<form action="ServletThem" method="post">
		<table width="400" border="2" cellpadding="5" align="center">
			<tr>
				<th colspan="2">Thêm Nhân viên</th>
			</tr>

			<tr>
				<td>STT:</td>
				<td><input type="text" name="no" size="30"
					placeholder="Nhập STT"></td>
			</tr>
			
			<tr>
				<td>Mã NV: </td>
				<td><input type="text" name="id" size="30"
					placeholder="Nhập id"></td>
			</tr>

			<tr>
				<td>Họ tên: </td>
				<td><input type="text" name="name" size="30"
					placeholder="Nhập tên NV"></td>
			</tr>
		
			<tr>
				<td>Ngày sinh: </td>
				<td><input type="text" name="dob" size="30"
					placeholder="Nhập ngày sinh"></td>
			</tr>
			<tr>
				<td>Quê quán: </td>
				<td><input type="text" name="address" size="30"
					placeholder="Nhập quê quán"></td>
			</tr>

			

	
			<tr>
				<td colspan="2" align="center"><input type="submit" name="add"
					value="Thêm">
			</tr>
		</table>
	</form>
</body>
</html>