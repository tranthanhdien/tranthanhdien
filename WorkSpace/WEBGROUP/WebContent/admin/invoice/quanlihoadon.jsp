
<%@page import="model_shoppingcart.InvoiceDB"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="hethongthongtin.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Quản lí sản phẩm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/newcss/bootstrap.css"
	rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/newcss/style.css" />


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
				<h2 style="text-align: center">QUẢN LÍ HÓA ĐƠN</h2>
				<a href="<%=request.getContextPath()%>/admin/addProduct.jsp"
					class="btn btn-success" style="float: right; margin-right: 5%;">Thêm
					mới</a>
				<!-- the hien noi dung o day -->
				<div style="width: 95%; margin-right: 2%; float: right;">
					<div class="bs-example widget-shadow"
						data-example-id="hoverable-table">
						<table class="table table-hover">
							<thead>
								<tr>
									<td colspan="8" style="color: red">${removeInvoiceDone }</td>

								</tr>
								<tr>
									<th title="Số thứ tự">STT</th>
									<th title="Mã hóa đơn">Mã</th>
									<th>Ngày giao dịch</th>
									<th>Tổng giá</th>
									<th>Khách hàng</th>
									<th>Điện thoại</th>
									<th>Xem chi tiết</th>
									<th>Hoạt động</th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<Invoice> list = new InvoiceDB().getListInvoice();
									int count = 1;
									for (Invoice c : list) {
								%>
								<tr>
									<th scope="row"><%=count%></th>
									<td><%=c.getNumberInvoice()%></td>
									<td><%=c.getToday()%></td>
									<td><%=c.getShop().totalPrice()%></td>
									<td><%=c.getUser().getFullName()%></td>
									<td><%=c.getUser().getPhone()%></td>
									<td><a
										href="<%=request.getContextPath()%>/ControllerAdmin?action=displayInvoice1&id=<%=c.getNumberInvoice()%>">Xem
											chi tiết</a></td>

									<td><a
										href="<%=request.getContextPath()%>/ControllerAdmin?action=removeInvoice&idInvoice=<%=c.getNumberInvoice()%>"
										class="btn btn-danger">Xóa</a> <a
										href="<%=request.getContextPath()%>/ControllerAdmin?action=findInvoice&idInvoice=<%=c.getNumberInvoice()%>"
										class="btn btn-primary">Sửa</a></td>
								</tr>
								<%
									count++;
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--footer-->
	<div class="footer">
		<p>
			&copy; 2018 Glance Design Dashboard. All Rights Reserved | Design by
			<a href="#" target="_blank">w3layouts</a>
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
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/newjs/bootstrap.js">
		
	</script>
</body>
</html>