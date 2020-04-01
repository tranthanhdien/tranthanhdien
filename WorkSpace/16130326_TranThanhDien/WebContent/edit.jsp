<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sửa</title>
</head>
<body>

	<form action="Control?action=edit" method="post">
		<table>
			<tr>
				<td><label>ID</label></td>
				<td><input type="text" value="${requestScope.sp.id}" name="id"></td>
			</tr>
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" value="${requestScope.sp.name}"
					name="name"></td>
			</tr>
			<tr>
				<td><label>Price</label></td>
				<td><input type="text" value="${requestScope.sp.price}"
					name="price"></td>
			</tr>
			<tr>
				<td><label>Cost</label></td>
				<td><input type="text" value="${requestScope.sp.cost}"
					name="cost"></td>
			</tr>
			<tr>
				<td><label>Cost</label></td>
				<td><input type="text" value="${requestScope.sp.linkImage}" name="link"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="sent"></td>
			</tr>
		</table>

	</form>

</body>
</html>