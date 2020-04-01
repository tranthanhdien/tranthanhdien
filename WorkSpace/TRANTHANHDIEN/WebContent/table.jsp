<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/boostrap_Cart.css">
<style>
</style>
</head>
<body>
	<table style="width: 100%">

		<tr>
			<th style="width: 20%">ID</th>
			<th style="width: 20%">Name</th>
			<th style="width: 20%">Price</th>
			<th style="width: 20%">Cost</th>
			<th style="width: 20%">Action</th>
		</tr>


		<tr>
			<td>122</td>
			<td>222</td>
			<td>222</td>
			<td>222</td>
			<td><a href="Control?action=addCart&id=xxxxx"><button
						class="btn btn-primary btn-sm" title="Sửa SP">Mua</button></a></td>

		</tr>

	</table>

</body>
</html>