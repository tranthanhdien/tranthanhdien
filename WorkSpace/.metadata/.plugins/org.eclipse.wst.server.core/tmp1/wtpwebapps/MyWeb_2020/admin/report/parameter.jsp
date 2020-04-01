<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Parameter</title>
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
<!-- datepicker -->
<link
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>
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
					<%
						String name = request.getParameter("Name");
						String tilte = request.getParameter("title");
					%>


					<div class="inline-form widget-shadow">
						<div class="form-title">
							<h4>
								Loại báo cáo:
								<%=tilte%>
							</h4>
							<p>Nhập theo định dạng ngày: yyyy-mm-dd</p>
						</div>
						<div class="form-body">
							<div data-example-id="simple-form-inline">
								<form class="form-inline"
									action="<%=request.getContextPath()%>/ControllerAdmin?action=displayReport"
									method="post">
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="Ngày bắt đầu" id="tbDate" name="startDate">
									</div>
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="Ngày kết thúc" id="tbDate2" name="endDate">
									</div>
									<div class="form-group">
										<input type="hidden" class="form-control" value="<%=name %>"
											name="name">
									</div>
									<div class="form-group">
										<input type="hidden" class="form-control" value="<%=tilte %>"
											name="title">
									</div>
									<button type="submit" class="btn btn-default">Tiếp tục</button>

								</form>
								<div style="float: right; margin-right: 30%;margin-top: -3.5%;">
									<A href="<%=request.getContextPath()%>/admin/report/reports.jsp"><button
											class="btn btn-default">Trở lại</button></A>
								</div>
							</div>

						</div>

					</div>

				</div>
			</div>

		</div>
	</div>
	<!--footer-->
	<div style="height: 500px; width: 100%"></div>
	<div class="footer">
		<p>
			&copy; 2018 Glance Design Dashboard. All Rights Reserved | Design by
			<a href="#" target="_blank">w3layouts</a>
		</p>
	</div>
	<!--//footer-->
	<script>
		$(document).ready(function() {
			$('input[id$=tbDate]').datepicker({});
		});

		$('input[id$=tbDate]').datepicker({
			dateFormat : 'yy-mm-dd'
		});
	</script>
	<script>
		$(document).ready(function() {
			$('input[id$=tbDate2]').datepicker({});
		});

		$('input[id$=tbDate2]').datepicker({
			dateFormat : 'yy-mm-dd'
		});
	</script>
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