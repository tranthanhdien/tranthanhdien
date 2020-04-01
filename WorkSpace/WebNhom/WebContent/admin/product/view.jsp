
<%@page import="model_product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>edit product</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8" />
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
/* Full-width input fields */
input[type=text] {
	width: 90%;
	padding: 3px 3px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

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
				<h3 STYLE="text-align: center">CHI TIẾT SẢN PHẨM</h3>
				<!-- phan table -->
				
				<div style="width: 92%; float: right; margin-right: 10px;">
					<table style="width: 100%" class="table-responsive">

						<tr>
							<td style="width: 26%;"><img src="${product_View.linkHA1 }"></td>
							<td>
								<table>
									<tr>
										<td><b>Mã sản phẩm:</b> ${product_View.id }</td>
									</tr>
									<tr>
										<td><b>Tên sản phẩm:</b> ${product_View.name }</td>
									</tr>
									<tr>
										<td><b>Mô tả:</b> ${product_View.description }</td>
									</tr>
									<tr>
										<td><b>Giá bán:</b> ${product_View.price } VNĐ</td>
									</tr>
									<tr>
										<td><b>Giá trước giảm giá:</b> ${product_View.discount }
											VNĐ</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
					<table style="width: 100%;" class="table-responsive">

						<tr>
							<td style="width: 20%;"><b>Loại:</b> ${product_View.type }</td>
							<td><b>Nhóm:</b> ${product_View.nhom }</td>

						</tr>


						<tr>
							<td><b>Công suất:</b> ${product_View.congSuat } W</td>
							<td><b>Điện áp:</b> ${product_View.dienAp }</td>
						</tr>
						<tr>
							<td><b>Bảo hành:</b> ${product_View.baoHanh } tháng</td>

						</tr>
					</table>

				</div>
				<!-- //phan table -->
				<div style="width: 90%; margin-right: 2%; float: right">
						<ul class="bt-list">
							<li><a
								href="<%=request.getContextPath()%>/admin/product/quanlisanpham.jsp"
								class="hvr-icon-back col-2" style="background: #1bbc9b;">Trở lại</a></li>
							<li><a
								href="<%=request.getContextPath()%>/ControllerProduct?action=find&id=${product_View.id }"
								class="hvr-icon-fade col-7">Sửa</a></li>
							<li><a
								href="ControllerProduct?action=removeview&id=${product_View.id }"
								class="hvr-icon-spin col-5">Xóa</a></li>
						</ul>
					</div>
			</div>
		</div>
	</div>

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