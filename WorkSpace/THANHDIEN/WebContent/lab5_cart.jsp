<%@page import="model.Customer"%>
<%@page import="dao.GioHangDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Giỏ hàng của bạn</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <!--
	  <link rel="stylesheet" href="bootstrap.min.css">
	  -->
</head>
<body>
	<center>
		<div class="container" id="">
			<div class="row">
				<!--  <table id="datatable-buttons" class="table table-striped table-bordered">-->
				<center>
					<h1>
						Giỏ hàng của
						<%
						Customer cus = (Customer) session.getAttribute("Customer");
															if (cus != null) {
																out.print(cus.getName());
															}
					%>
					</h1>
				</center>
				<p style="text-align: center">
				<div class="col-lg-6 col-lg-push-3">
					<div class="input-group">
						<span class="input-group-btn"> <a href="lab5.jsp"><button
									type="button" class="btn btn-primary" aria-label="Right Align">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Tiếp
									tục mua hàng
								</button></a>
						</span>
					</div>
				</div>

				</p>
				<br>
				<%
					ArrayList<Product> listCart = new GioHangDAO().getListCart();
				%>


				<table class="table table-hover">
					<thead>
						<tr>
							<th>Mã sách</th>
							<th>Tên sách</th>

							<th>Hình ảnh</th>
							<th>Giá</th>
							<th>Số lượng</th>
							<th>Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<%
							//	int count = 0;
							for (int i = 0; i < listCart.size(); i++) {
								//		count++;
						%>
						<tr>
							<!--  
							<th scope="row">
						//	out.print(count);				%>
							</th>
							-->
							<td>
								<%
									out.print(listCart.get(i).getId());
								%>
							</td>
							<td>
								<%
									out.print(listCart.get(i).getName());
								%>
							</td>
							<td><img src="<%=listCart.get(i).getImage()%>" width="70px"
								height="50px"></td>

							<td>
								<%
									out.print(listCart.get(i).getPrice());
								%>
							</td>
							<td>
								<%
									out.print(listCart.get(i).getQuantity());
								%>
							</td>

							<td><a
								href="ServletXoa?id=<%=listCart.get(i).getId()%>">
									<button type="button" class="btn btn-danger"
										aria-label="Right Align">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</button>
							</a></td>
						</tr>
						<%
							}
						%>
						<%
							double total = 0;
							for (int i = 0; i < listCart.size(); i++) {
								total += listCart.get(i).getPrice() * listCart.get(i).getQuantity();

							}
						%>
					</tbody>
				</table>
				<h4 style="margin-left: 70%;">
					Tổng tiền:
					<%=total%></h4>

				<br> <br> <a href="ServletDangXuat">
					<button type="button" class="btn btn-danger"
						aria-label="Right Align">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						Đăng xuất
					</button>
				</a>
			</div>
		</div>
	</center>
</body>
</html>