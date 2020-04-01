
<%@page import="model_product.ProductDAO"%>
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
				<div
					style="width: 600px; float: left; margin-left: 25%; margin-top: 5%;">
					<form
						action="<%=request.getContextPath()%>/ControllerProduct?action=add"
						method="post" enctype="multipart/form-data">
						<table style="width: 100%;">
							<tr>
								<td><div class="input-group" style="display: grid;">
										<label for="ma"><b>Mã sản phẩm</b></label> <input type="text"
											value="<%=ProductDAO.idDynamic()%>" name="id">
									</div></td>
								<td><label><b>Tên sản phẩm</b></label> <input type="text"
									placeholder="Nhập tên sản phẩm" name="name" required></td>
							</tr>
							<tr>
								<td colspan="2"><label for="ten"><b>Mô tả</b></label> <textarea
										rows="3" cols="50" name="description"></textarea></td>
							</tr>
							<tr>
								<td><label for="gia"><b>Giá bán</b></label> <input
									type="text" placeholder="Giá bán sản phẩm" name="price"
									required></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Giảm giá</b></label> <input type="text"
											placeholder="Giảm giá" name="discount" required>
									</div></td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Số lượng nhập</b></label> <input
											type="text" placeholder="Giá bán sản phẩm" name="soLuong"
											required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Công suất</b></label> <input type="text"
											placeholder="Giảm giá" name="congSuat" required>
									</div></td>
							</tr>
							<tr>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Điện áp</b></label> <input type="text"
											placeholder="Mô tả sản phẩm" name="dienAp" required>
									</div>
								</td>
								<td><div class="input-group" style="display: grid;">
										<label for="mota"><b>Thời gian bảo hành</b></label> <select
											name="baoHanh" style="width: 90%; padding: 3px 3px">

											<%
														for (int i = 1; i < 13; i++) {
													%>
											<option value="<%=i%>"><%=i%></option>
											<%
														}
													%>


										</select>
									</div></td>
							</tr>
							<tr>
								<td>

									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Loại</b></label> <input type="text"
											placeholder="Loaji SP" name="loai" required>
									</div>
								</td>
								<td>

									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Nhóm</b></label> <input type="text"
											placeholder="Nhom SP" name="nhom" required>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Hình ảnh</b></label> <input type="file"
											name="photo">
									</div>
								</td>
							</tr>
						</table>

						<div class="modal-footer">
							<button type="submit" class="btn btn-success">Gửi</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>

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