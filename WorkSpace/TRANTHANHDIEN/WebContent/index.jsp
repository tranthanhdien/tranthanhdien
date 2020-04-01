s
<%@page import="model_dao.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/boostrap_Cart.css">
<style>
/*dang danh sach */
.table>thead>tr.names>th {
	border-bottom: 1px;
}

.table>tbody>tr.item>td {
	padding-bottom: 20px;
	padding-top: 20px;
	vertical-align: middle;
}

.table>tfoot>tr.no-border>td {
	border-top: 0 none;
	padding-top: 20px;
}

.img-product {
	padding-top: 20px;
}

input[type=text], input[type=password] {
	padding: 5px 2px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<%
		ArrayList<Product> list = new ProductDAO().getListProduct();
	%>
	<div class="container">
		<table id="cart" class="table table-responsive">
			<!-- tieu de  -->
			<thead>
				<tr class="names">
					<th style="width: 10%">Mã SP</th>
					<th style="width: 50%">Giới thiệu sản phẩm</th>
					<th style="width: 20%">Price</th>
					<th style="width: 20%">Hoạt động</th>
				</tr>
			</thead>

			<!-- phan than -->
			<tbody>

				<%
					for (Product p : list) {
				%>
				<tr class="item">
					<!--ma SP-->
					<td><%=p.getId() %></td>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-3 hidden-xs">
								<!--link hinh anh-->
								<img src="<%=p.getImage() %>" alt="Converse"
									class="img-product img-responsive img-rounded" />
							</div>
							<div class="col-sm-9">
								<!--Name-->
								<h4 class="nomargin"><%=p.getName() %></h4>
								<!--mo ta SP -->
								<p class="hidden-xs"></p>
							</div>
						</div>
					</td>
					<!--SIze -->
					
					<td data-th="Size"><%=p.getPrice()%></td>

					<!-- chu nang xoa SP -->
					<td>
								<a href="Control?action=addCart&id=<%=p.getId()%>"><button
								class="btn btn-primary btn-sm" title="Sửa SP">Mua</button></a></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>