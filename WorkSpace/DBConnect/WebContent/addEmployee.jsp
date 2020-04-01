<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Nhân viên</title>
</head>
<body>
	<form action="ServletThem" method="post">
		<table width="400" border="2" cellpadding="5" align="center">
			<tr>
				<th colspan="2">Thêm Nhân viên</th>
			</tr>

			<tr>
				<td>Id:</td>
				<td><input type="text" name="stt" size="30"
					placeholder="Nhập Stt"></td>
			</tr>

			<tr>
				<td>Mã:</td>
				<td><input type="text" name="id" size="30"
					placeholder="Nhập mã"></td>
			</tr>

			<tr>
				<td>Full name:</td>
				<td><input type="text" name="fullName" size="30"
					placeholder="Nhập fullname"></td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><input type="text" name="dob" size="30"
					placeholder="Nhập Dob"></td>
			</tr>


			<tr>
				<td>Quê quán:</td>
				<td><input type="text" name="address" size="30"
					placeholder="Nhập Address"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="add"
					value="Thêm">
			</tr>



		</table>
	</form>
</body>
</html>