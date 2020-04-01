<%@page import="model.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shopping Cart</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.khungsanpham {
	padding-top: 20px;
	padding-left: 30px;
	float: left;
}

.boder {
	border: solid;
	width: 200px;
	height: 270px;
}

.img {
	margin-left: 3px;
	margin-top: 3px;
	width: 192px;
	height: 180px;
}

.gia {
	text-align: center;
	color: red;
	margin-top: 10px;
	margin-bottom: 10px;
}

.mua {
	color: red;
}
</style>
</head>
<body>



	<div class="container" style="margin-left: 15%">

		<a href="lab5_cart.jsp"><button style="margin-left: 37%"
				type="button" class="btn btn-danger" aria-label="Right Align">
				<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;Xem giỏ
				hàng
			</button></a>
		<h3 style="margin-left: 2%">Các sản phẩm hiện có:</h3>
		<%
			ArrayList<Product> lstProducts = ProductDAO.getListProduct();
		%>
		<%
			for (int i = 0; i < lstProducts.size(); i++) {
		%>
		<div class="khungsanpham">
			<div class="boder">
				<div class="img">
					<img src="<%=lstProducts.get(i).getImage()%>" width="192px"
						height="180px">
				</div>
				<div class="gia">
					<%=lstProducts.get(i).getPrice()%>
				</div>
				<div class="mua">
					<center>
						<a href="ServletMuaSanPham?id=<%=lstProducts.get(i).getId()%>"><button
								class="btn btn-success">
								<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;Mua
								ngay
							</button></a>

					</center>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<div style="padding-left: 47%; padding-top: 15px;">
		<a href="DangXuat"><button type="button" class="btn btn-danger"
				aria-label="Right Align">
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;Đăng
				xuất
			</button></a>

	</div>
</body>
</html>
