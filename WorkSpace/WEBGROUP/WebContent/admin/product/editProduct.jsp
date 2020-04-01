
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
				<%
					Product p = (Product) request.getAttribute("p");
				%>
				<div
					style="width: 800px; float: left; margin-left: 15%; margin-top: 2%;">
					<form
						action="<%=request.getContextPath()%>/ControllerProduct?action=edit"
						method="post" enctype="multipart/form-data">
						<table style="width: 100%;">
							<tr>
								<td><div class="input-group" style="display: grid;">
										<label for="ma"><b>Mã sản phẩm</b></label> <input type="text"
											value="<%=p.getId()%>" name="id" readonly="readonly">
									</div></td>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Tên sản phẩm</b></label> <input
											type="text" value="<%=p.getName()%>" name="name" required>
									</div>
								</td>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Số lượng nhập</b></label> <input
											type="text" value="<%=p.getSoLuongTrongKho()%>"
											name="soLuong" required>
									</div></td>

							</tr>
							<tr>
								<td colspan="3">
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Mô tả</b></label>
										<textarea rows="3" cols="50" name="description"><%=p.getDescription()%></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Giá bán</b></label> <input type="text"
											value="<%=p.getPrice()%>" name="price" required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Giảm giá</b></label> <input type="text"
											value="<%=p.getDiscount()%>" name="discount" required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Công suất (W)</b></label> <input
											type="text" value="<%=p.getCongSuat()%>" name="congSuat"
											required>
									</div></td>
							</tr>

							<tr>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Điện áp</b></label> <select name="dienAp"
											style="width: 90%; padding: 3px 3px">
											<option value="<%=p.getDienAp()%>"><%=p.getDienAp()%></option>
											<option value="220/56-60">220 V/50-60Hz</option>

										</select>

									</div>
								</td>
								<td><div class="input-group" style="display: grid;">
										<label for="mota"><b>Thời gian bảo hành</b></label><select
											name="baoHanh" style="width: 90%; padding: 3px 3px">
											<option value="<%=p.getBaoHanh()%>"><%=p.getBaoHanh()%>
												tháng
											</option>
											<%
												for (int i = 1; i < 13; i++) {
											%>
											<option value="<%=i%>"><%=i%> tháng
											</option>
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
											value="<%=p.getType()%>" name="loai" required>
									</div>
								</td>
								<td>

									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Nhóm</b></label> <input type="text"
											value="<%=p.getNhom()%>" name="nhom" required>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Hình ảnh</b></label> <img
											src="<%=p.getLinkHA1()%>">
									</div>
								</td>
								<td colspan="2">
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Cập nhật hình ảnh</b></label> <input
											type="file" name="photo" value="<%=p.getLinkHA1()%>">
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="right">
									<button type="submit" class="btn btn-success"
										style="width: 200px;">Cập nhật</button>
								</td>
							</tr>
							<tr><td>
							<input type="hidden" value="<%=p.getLinkHA1()%>" name="image"></td>
							</tr>
						</table>
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