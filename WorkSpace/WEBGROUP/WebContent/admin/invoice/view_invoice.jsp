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
					<table>
						<tr>
							<td><b>Ngày HD: </b></td>
							<td>&nbsp;  ${sessionScope.invoiceInvoice1.today }</td>
						</tr>
						<tr>
							<td><b>Thông tin khách hàng: </b></td>
							<td>&nbsp; ${sessionScope.userInvoice1.username }</td>
						</tr>
						<tr>
							<td></td>
							<td>&nbsp; ${sessionScope.userInvoice1.fullName }</td>
						</tr>
						<tr>
							<td></td>
							<td>&nbsp; ${sessionScope.userInvoice1.phone }</td>
						</tr>
						<tr>
							<td></td>
							<td>&nbsp; ${sessionScope.userInvoice1.address }</td>
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
									ShoppingCart shop = (ShoppingCart) session.getAttribute("shopInvoice1");

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
							<li><a href="<%=request.getContextPath()%>/admin/invoice/quanlihoadon.jsp" class="hvr-icon-fade col-7">Trở lại</a></li>
							<li><a href="<%=request.getContextPath()%>/ControllerAdmin?action=displayInvoiceProcess" class="hvr-icon-forward col-2">Xem danh sách hóa đơn chưa xử lí</a></li>
						</ul>

					</div>


				</div>
			</div>
		</div>
	</div>
	<!--footer-->
	<div class="footer">
		<p>
			&copy; 2018 Glance Design Dashboard. All Rights Reserved | Design by
			<a href="#" target="_blank">Template</a>
		</p>
	</div>
	<!--//footer-->

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