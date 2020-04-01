<%@page import="model.DAO"%>
<%@page import="model.Product"%>
<%@page import="java.text.DecimalFormat"%>
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
<title>Lab5</title>
<style>
#center {
	margin-left: 100px;
}
</style>
</head>
<body>
	<%
		ArrayList<Product> lstProducts = DAO.getListProduct();
	%>
		<h2 class="text-center">Danh sách sản phẩm</h2>
		<div class="container" id=center>
		<div class="row" style="margin-bottom: 30px;">
			<a href="addProduct.jsp"><button class="btn btn-sm btn-success"
					id="Them" style="margin-left: 42%;">
					<span class="glyphicon glyphicon-plus"></span> Thêm sản phẩm
				</button></a>
		</div>
		<table class="table table-striped table-hover">
			<tr>
				<th>Mã SP</th>
				<th>Tên SP</th>
				<th>Hình ảnh</th>
				<th>Giá ban đầu</th>
				<th>Giá đã giảm</th>
				<th>Thao tác</th>
			</tr>
			<%
				for (int i = 0; i < lstProducts.size(); i++) {
							Product p = lstProducts.get(i);
			%>
			<tr>
				<td><%=p.getId()%>
				<td><%=p.getName()%>
				<td><img src="<%=p.getUrl()%>">
				<td><%=p.getPrice()%>
				<td><%=p.getPerSale()%>
				<td><a href="ServletXoaSanPham?index=<%=i%>"><button
							class="btn btn-danger btn-sm">Xoá</button></a>		
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>