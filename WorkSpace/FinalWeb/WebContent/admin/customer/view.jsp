<%@page import="model_user.User"%>
<%@page import="model_user.Login"%>
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
<style>
</style>
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
					<form>
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" style="text-align: center">
									<b>THÔNG TIN KHÁCH HÀNG/NGƯỜI DÙNG</b>
								</h4>
							</div>
							<div class="modal-body">
								<table style="width: 100%;">
									<tr>
										<td><b>Mã người dùng:</b> ${lookUser.c.id }</td>
										<td><b>Tên đăng nhập: </b>${lookUser.c.username }</td>
										<td><b>Họ và tên: </b>${lookUser.c.fullName }</td>
									</tr>

									<tr>
										<td><b>Mật khẩu: </b>${lookUser.l.pass }</td>
										<td><b>Số điện thoại: </b>${lookUser.c.phone }</td>
										<td><b>Email: </b>${lookUser.l.email }</td>
									<tr>
										<td><b>Địa chỉ: </b>${lookUser.c.address }</td>
									</tr>
									<tr>
										<td><b>Admin: </b> <%
													User u = (User) request.getAttribute("lookUser");
													Login l = u.getL();
													if (l.isAdmin() == true) {
												%> <input type="checkbox" value="Admin" name="admin"
											checked="checked"> <%
													} else {
												%> <input type="checkbox" value="Admin" name="admin">
											<%
													}
												%></td>
									</tr>
									<tr>
										<td align="right" colspan="3">

											<div style="width: 90%; margin-right: 2%; float: right">
												<ul class="bt-list">
													<li><a
														href="<%=request.getContextPath()%>/ControllerUser?action=quanlikhachhang"
														class="hvr-icon-back col-2" style="background: #1bbc9b;">Trở
															lại</a></li>
													<li><a
														href="<%=request.getContextPath()%>/ControllerUser?action=lookToEdit&id=${lookUser.c.id }"
														class="hvr-icon-fade col-7">Sửa</a></li>
													<li>
														<form
															action="<%=request.getContextPath()%>/ControllerUser?action=removeview&id=${lookUser.c.id }"
															onsubmit="return submitForm(this);" method="post">
															<a class="hvr-icon-spin col-5"><button type="submit"
																	style="font-size: 14px; width: 100%; height: 100%; background: none; border: none"
																	onclick="if (!confirm('bạn có chắc chắn xóa SP: ' + ${lookUser.c.id } +'?')) { return false }">
																	Xóa</button></a>
														</form>

													</li>
												</ul>
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
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/newjs/bootstrap.js">
		
	</script>
</body>
</html>