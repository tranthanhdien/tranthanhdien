<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm</title>
</head>
<body>
	<form method="post" action="Control?action=add">
		<table>
			<tr>
				<td><label>ID</label></td>
				<td><input value="" type="text" name="id"></td>
			</tr>
			<tr>
				<td><label>Name</label></td>
				<td><input value="" type="text" name="name"></td>
			</tr>
			<tr>
				<td><label>Price</label></td>
				<td><input value="" type="text" name="price"></td>
			</tr>
			<tr>
				<td><label>Cost</label></td>
				<td><input value="" type="text" name="cost"></td>
			</tr>
			<tr>
				<td><label>Image</label></td>
				<td><input value="" type="text" name="image"></td>
			</tr>
			<tr>
			
				<td colspan="2"><input value="Submit" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>