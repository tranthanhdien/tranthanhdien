<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.tomcat.jni.Local"%>
<%@page import="model.IDAO"%>
<%@page import="model.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trần Thanh Điền</title>
<link rel="stylesheet" href="css/boostrap_Cart.css">
</head>
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
<body>
	<br>

	<div style="margin-left: 45%;">
		<a href="add.jsp"><button class="btn btn-success btn-lg">
				<span class="glyphicon glyphicon-plus"></span>Add Product
			</button></a>
	</div>
	<!-- duyet for cai nay -->



	<div class="container">
		<table id="cart" class="table table-responsive">
			<!-- tieu de  -->
			<thead>
				<tr class="names">
					<th style="width: 10%">Mã SP</th>
					<th style="width: 50%">Giới thiệu sản phẩm</th>
					<th style="width: 10%" class="text-right hidden-xs">Giá ban
						đầu</th>
					<th style="width: 10%" class="text-right">Giá đã giảm</th>
					<th style="width: 10%">Hoạt động</th>
				</tr>
			</thead>

			<!-- phan than -->
			<tbody>

				<%
					for (int i = 0; i < new ProductDAO().getListProduct().size(); i++) {
						Product p = new ProductDAO().getListProduct().get(i);
				%>

				<tr class="item">
					<!--ma SP-->
					<td><%=p.getId()%></td>
					<td data-th="Product">
						<div class="row">

							<div class="col-sm-9">
								<!--Name-->
								<h4 class="nomargin"><%=p.getName()%></h4>
								<!--mo ta SP -->
								<p class="hidden-xs"><%=p.getPrice()%></p>
							</div>
						</div>
					</td>

					<!--SIze -->
					<td data-th="Price" class="text-right hidden-xs"><%=p.getPrice()%></td>

					<td data-th="Subtotal" class="text-right"><%=p.getCost()%></td>

					<!-- chu nang xoa SP -->
					<td class="actions" data-th=""><a
						href="Control?action=remove&id=<%=p.getId()%>"><button
								class="btn btn-danger btn-sm" title="Xóa SP">Xoá</button></a> <!-- chuyen toi servlet tim SP  -->
						<a href="Control?action=findProduct&id=<%=p.getId()%>"><button
								class="btn btn-warning btn-sm" title="Sửa SP">Sửa</button></a></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<img alt="" src="image/image.png" width="80%;" style="margin-left: 10%;">

</body>
</html>