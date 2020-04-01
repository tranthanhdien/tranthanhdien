<%@page import="model_shoppingcart.ShoppingCart"%>
<%@page import="model_shoppingcart.ItemCart"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Invoice</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 






</script>

<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/newcss/bootstrap.css"
	rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/newcss/style.css" />


<!-- font-awesome icons CSS -->
<link href="<%=request.getContextPath()%>/newcss/font-awesome.css"
	rel="stylesheet">
<!-- //font-awesome icons CSS-->

<!-- side nav css file -->
<link href="<%=request.getContextPath()%>/newcss/SidebarNav.min.css"
	media='all' rel='stylesheet' type='text/css' />
<!-- //side nav css file -->

<!-- js-->
<script src="<%=request.getContextPath()%>/newjs/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath()%>/newjs/modernizr.custom.js"></script>

<!--webfonts-->
<link
	href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext"
	rel="stylesheet">
<!--//webfonts-->

<!-- Metis Menu -->
<script src="<%=request.getContextPath()%>/newjs/metisMenu.min.js"></script>
<script src="<%=request.getContextPath()%>/newjs/custom.js"></script>
<link href="<%=request.getContextPath()%>/newjs/custom.css"
	rel="stylesheet">
<!--//Metis Menu -->
<style>
#chartdiv {
	width: 100%;
	height: 295px;
}
</style>

<!-- requried-jsfiles-for owl -->
<link href="<%=request.getContextPath()%>/cssAdmin/owl.carousel.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/jsAdmin/owl.carousel.js"></script>
<script>
	$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			items : 3,
			lazyLoad : true,
			autoPlay : true,
			pagination : true,
			nav : true,
		});
	});
</script>
<!-- //requried-jsfiles-for owl -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
</head>
<body class="cbp-spmenu-push">

	<jsp:include page="/admin/menu.jsp"></jsp:include>
	<!-- main content start-->
	<br>
	<br>
	<br>
	<div id="page-wrapper">
		<div class="main-page">
			<div class="col_3">
				<h2 style="text-align: center">Chi tiết đơn hàng</h2>
				<!-- the hien noi dung o day -->
				<div style="width: 80%; float: right; margin-right: 15%;">
					<table style="width: 100%;">
						<tr>
							<!-- bang trai -->
							<td>
								<table>
									<tr>
										<td><b>Ngày lập HD: </b></td>
										<%
											java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
										%>
										<td>${requestScope.invoiceInvoice1.today }</td>
									</tr>
									<tr>
										<td><b>&nbsp; </b></td>
										<td></td>
									</tr>
									<tr>
										<td><b>&nbsp; </b></td>
										<td></td>
									</tr>
									<tr>
										<td><b>&nbsp; </b></td>
										<td></td>
									</tr>
									<tr>
										<td><b>&nbsp; </b></td>
										<td></td>
									</tr>


								</table>
							</td>

							<!-- bang phai -->
							<td>
								<table>
									<tr>
										<td colspan="2"><b>Thông tin khách hàng</b></td>
									</tr>
									<tr>
										<td>Tên đăng nhập:</td>
										<td>&nbsp; ${requestScope.userInvoice1.username }</td>
									</tr>
									<tr>
										<td>Họ tên:</td>
										<td>&nbsp; ${requestScope.userInvoice1.fullName }</td>
									</tr>
									<tr>
										<td>Điện thoại:</td>
										<td>&nbsp; ${requestScope.userInvoice1.phone }</td>
									</tr>
									<tr>
										<td>Địa chỉ:</td>
										<td>&nbsp; ${requestScope.userInvoice1.address }</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<div style="width: 95%; margin-right: 2%; float: right;">
					<div class="bs-example widget-shadow"
						data-example-id="hoverable-table">

						<table class="table table-hover">
							<thead>
								<tr>
									<th title="Số thứ tự">STT</th>
									<th>Số lượng</th>
									<th>Tên sản phẩm</th>
									<th>Hình ảnh</th>
									<th>Giá</th>
								</tr>
							</thead>
							<tbody>

								<%
									ShoppingCart shop = (ShoppingCart) request.getAttribute("shopInvoice1");

									for (int i = 0; i < shop.getListCart().size(); i++) {
										ItemCart item = shop.getListCart().get(i);
								%>
								<tr>
									<th scope="row"><%=i + 1%></th>
									<td><%=item.getQuantity()%></td>
									<td><%=item.getP().getName()%></td>
									<td><img src="<%=item.getP().getLinkHA1()%>"
										class="img-responsive img-thumbnail" style="width: 15%"></td>
									<td><%=item.getP().getPrice()%></td>
								</tr>
								<%
									}
								%>

								<tr>
									<th scope="row">Tổng giá</th>
									<td></td>
									<td></td>
									<td></td>
									<td><b><%=shop.totalPrice()%></b></td>

								</tr>

							</tbody>
						</table>
					</div>

					<div>

						<ul class="bt-list">
							<li><a
								href="<%=request.getContextPath()%>/ControllerInvoice?action=quanlihoadon"
								class="hvr-icon-back col-2" style="background: #1bbc9b;">Trở
									lại</a></li>
							<li><a
								href="<%=request.getContextPath()%>/ControllerInvoice?action=findInvoice&idInvoice=${requestScope.invoiceInvoice1.numberInvoice }"
								class="hvr-icon-fade col-7">Sửa hóa đơn</a></li>
							<li>
							
									<a style="height: 40px;" class="hvr-icon-spin col-5" href="<%=request.getContextPath()%>/ControllerInvoice?action=removeview&idInvoice=${requestScope.invoiceInvoice1.numberInvoice }"><button
											type="submit"
											style="width: 100%; border: none; background: none; text-align: left"
											onclick="if (!confirm('bạn có chắc chắn xóa Hóa đơn: ' + ${requestScope.invoiceInvoice1.numberInvoice } +'?')) { return false }">
											Xóa</button></a>
								</li>
						</ul>


					</div>


				</div>
			</div>
		</div>
	</div>
	<!-- dam bao xoa -->
	<script>
		"use strict";
		function submitForm(oFormElement) {
			var xhr = new XMLHttpRequest();
			xhr.onload = function() {
				swal({
					position : 'top-end',
					type : 'success',
					title : xhr.responseText,
					showConfirmButton : false,
					timer : 1000,
				});
				window.setTimeout(function() {
					location.reload();
				}, 1000);
			}
			xhr.open(oFormElement.method, oFormElement.action, true);
			xhr.send(new FormData(oFormElement));

			return false;
		}
	</script>

	<!-- Thu gon menu -->
	<script src="<%=request.getContextPath()%>/newjs/classie.js"></script>
	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1'), showLeftPush = document
				.getElementById('showLeftPush'), body = document.body;

		showLeftPush.onclick = function() {
			classie.toggle(this, 'active');
			classie.toggle(body, 'cbp-spmenu-push-toright');
			classie.toggle(menuLeft, 'cbp-spmenu-open');
			disableOther('showLeftPush');
		};

		function disableOther(button) {
			if (button !== 'showLeftPush') {
				classie.toggle(showLeftPush, 'disabled');
			}
		}
	</script>
	<!-- //thu gon menu -->

	<!-- side nav js -->
	<script src='<%=request.getContextPath()%>/newjs/SidebarNav.min.js'
		type='text/javascript'></script>
	<script>
		$('.sidebar-menu').SidebarNav()
	</script>
	<!-- //side nav js -->
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/newjs/bootstrap.js">
		
	</script>
	<!-- //Bootstrap Core JavaScript -->
</body>
</html>