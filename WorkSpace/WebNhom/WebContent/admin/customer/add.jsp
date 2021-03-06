<%@page import="model_user.Customer"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Quản lí khách hàng</title>
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
<!-- -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<style>
#chartdiv {
	width: 100%;
	height: 295px;
}

input[type=text] {
	width: 90%;
	padding: 3px 3px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
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
			
					<div class="modal-dialog modal-lg">
						<form
							action="<%=request.getContextPath()%>/ControllerUser?action=add"
							method="post" enctype="multipart/form-data">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title" style="text-align: center">
										<b>THÊM KHÁCH HÀNG/NGƯỜI DÙNG</b>
									</h4>
								</div>
								<div class="modal-body">
									<table style="width: 100%;">
										<tr>
											<td><div class="input-group" style="display: grid;">
													<label for="ma"><b>Mã người dùng</b></label> <input
														type="text" value="" name="id">
												</div></td>
											<td>
												<div class="input-group" style="display: grid;">
													<label for="ten"><b>Tên đăng nhập</b></label> <input
														type="text" placeholder="Nhập tên đăng nhập" name="name"
														required>
												</div>
											</td>
											<td>
												<div class="input-group" style="display: grid;">
													<label for="ten"><b>Họ và tên</b></label> <input
														type="text" placeholder="Họ và tên" name="fullname"
														required>
												</div>
											</td>
										</tr>
										<tr>
											<td><div class="input-group " style="display: grid;">
													<label for="gia"><b>Mật khẩu</b></label> <input type="text"
														placeholder="Nhập mật khẩu" name="pass" required>
												</div></td>
											<td><div class="input-group " style="display: grid;">
													<label for="giam"><b>Số điện thoại</b></label> <input
														type="text" placeholder="Nhập số điện thoại" name="phone"
														required>
												</div></td>
											<td><div class="input-group " style="display: grid;">
													<label for="gia"><b>Email</b></label> <input type="email"
														placeholder="Nhập Email" name="email" required>
												</div></td>
										<tr>
											<td colspan="3"><div class="input-group "
													style="display: grid;">
													<label for="giam"><b>Địa chỉ</b></label>
													<textarea rows="3" cols="30" name="address"
														placeholder="Nhập địa chỉ"></textarea>
												</div></td>
										</tr>
										<tr>
											<td align="right" colspan="2">
												<div class="modal-footer">
													<button type="submit" class="btn btn-success">Gửi</button>
													<button type="button" class="btn btn-danger"
														data-dismiss="modal">Đóng</button>

												</div>
											</td>

										</tr>
									</table>
								</div>
							</div>

						</form>
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