<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>report</title>
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
<link href="<%=request.getContextPath()%>/newcss/style.css"
	rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="<%=request.getContextPath()%>/newcss/font-awesome.css"
	rel="stylesheet">
<!-- //font-awesome icons CSS-->

<!-- side nav css file -->
<link href='<%=request.getContextPath()%>/newcss/SidebarNav.min.css'
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
	<br>

	<div id="page-wrapper">
		<div class="main-page">

			<div class="wrap" style="width: 90%; float: right; margin-right: 3%;">
				<div class="bg-effect">
					<h2>Chọn loại báo cáo</h2>
					<ul class="bt-list">

						<li><a href="<%=request.getContextPath()%>/ControllerAdmin?action=displayReport&name=userReport&title=KhachHang" class="hvr-icon-grow-rotate col-1">Khách
								hàng mua hàng</a></li>
						<li><a href="#" class="hvr-icon-forward col-2">Sản phẩm bán ra</a></li>
						<li><a href="#" class="hvr-icon-down col-3">Chi tiết hóa
								đơn từng khách hàng</a></li>
						<li><a
							href="<%=request.getContextPath()%>/admin/report/parameter.jsp?Name=DanhSachHoaDon&title=Danh sách hóa đơn"
							class="hvr-icon-up col-4">Toàn bộ hóa đơn(Tổng quát)</a></li>
						<li><a href="#" class="hvr-icon-spin col-5">Biểu đồ thống
								kê</a></li>
						<li><a href="#" class="hvr-icon-drop col-6">Số lượt truy cập web</a></li>
					</ul>
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
	<!-- Classie -->
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
	<!-- //Classie -->
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