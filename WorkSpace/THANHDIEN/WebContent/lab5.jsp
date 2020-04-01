<%@page import="dao.GioHangDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Trần Thanh Điền</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<!-- 
<link rel="stylesheet" href="bootstrap.min.css">
 -->
<style type="text/css">
.frame {
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

.price {
	text-align: center;
	color: red;
	margin-top: 10px;
	margin-bottom: 10px;
}

.button {
	color: red;
}
</style>
</head>
<body>
	<div class="container" style="margin-left: 15%">
		<br> <a href="lab5_cart.jsp"><button style="margin-left: 34%"
				type="button" class="btn btn-danger btn-lg" aria-label="Right Align">
				<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;Xem giỏ
				hàng
			</button></a>
		<h3 style="margin-left: 2%">Các loại sách hiện có:</h3>
		<%
			ArrayList<Product> listProducts = new GioHangDAO().getListBooks();
		%>
		<%
			for (int i = 0; i < listProducts.size(); i++) {
		%>
		<div class="frame">
			<div class="boder">
				<div class="img">
					<img src="<%=listProducts.get(i).getImage()%>" width="192px"
						height="180px">
				</div>
				<div style="text-align: center;">
					<%=listProducts.get(i).getName()%>
				</div>
				<div class="price">
					<%=listProducts.get(i).getPrice()%>
				</div>
				<div class="button" style="margin-top: -13px;">
					<center>
						<a href="ServletMua?id=<%=listProducts.get(i).getId()%>"><button
								class="btn btn-success">
								<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;Mua ngay
							</button></a>

					</center>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>

</body>
</html>
