<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<form action="ServletThemSP" method="post">
		<table width="400" border="2" cellpadding="5" align="center">
			<tr>
				<th colspan="2">Thêm Nhân viên</th>
			</tr>

			<tr>
				<td>Mã SP:</td>
				<td><input type="text" name="id" size="30"
					placeholder="Nhập mã"></td>
			</tr>

			<tr>
				<td>Tên SP:</td>
				<td><input type="text" name="name" size="30"
					placeholder="Nhập tên sản phẩm"></td>
			</tr>

			<tr>
				<td>Đơn vị tính:</td>
				<td><input type="text" name="dvt" size="30"
					placeholder="Nhập đơn vị tính"></td>
			</tr>

			<tr>
				<td>Nước sản xuất:</td>
				<td><input type="text" name="nsx" size="30"
					placeholder="Nhập tên nước sx"></td>
			</tr>

			<tr>
				<td>Giá:</td>
				<td><input type="text" name="gia" size="30"
					placeholder="Nhập giá"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="add"
					value="Thêm">
			</tr>
		</table>
	</form>
</body>
</html>