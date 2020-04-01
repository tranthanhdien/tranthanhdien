
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
				<div class="modal-dialog modal-lg" style="width: 93%;">
					<form
						action="<%=request.getContextPath()%>/ControllerProduct?action=edit"
						method="post"  enctype="multipart/form-data">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" style="text-align: center">
									<b>SỬA THÔNG TIN SẢN PHẨM</b>
								</h4>
							</div>
							<div class="modal-body">
								<table style="width: 100%;">
									<tr>
										<td><div class="input-group" style="display: grid;">
												<label for="ma"><b>Mã sản phẩm</b></label> <input
													type="text" value="${requestScope.id}" name="id"
													readonly="readonly">
											</div></td>
										<td>
											<div class="input-group" style="display: grid;">
												<label for="ten"><b>Tên sản phẩm</b></label> <input
													type="text" value="${requestScope.name}" name="name" required>
											</div>
										</td>
										<td><div class="input-group " style="display: grid;">
												<label for="gia"><b>Số lượng nhập</b></label> <input
													type="text" value="${requestScope.soLuongTrongKho}"
													name="soLuong" required>
											</div></td>

									</tr>
									<tr>
										<td colspan="3">
											<div class="input-group" style="display: grid;">
												<label for="ten"><b>Mô tả</b></label>
												<textarea rows="3" cols="50" name="description" value="${requestScope.desciption}"></textarea>
											</div>
										</td>
									</tr>
									<tr>
										<td><div class="input-group " style="display: grid;">
												<label for="gia"><b>Giá bán</b></label> <input type="text"
													value="${requestScope.price}" name="price" required>
											</div></td>
										<td><div class="input-group " style="display: grid;">
												<label for="giam"><b>Giảm giá</b></label> <input type="text"
													value="${requestScope.discount}" name="discount" required>
											</div></td>
										<td><div class="input-group " style="display: grid;">
												<label for="giam"><b>Công suất (W)</b></label> <input
													type="text" value="${requestScope.congSuat}" name="congSuat"
													required>
											</div></td>
									</tr>

									<tr>
										<td>
											<div class="input-group" style="display: grid;">
												<label for="mota"><b>Điện áp</b></label> <select
													name="dienAp" style="width: 90%; padding: 3px 3px">
													<option value="${requestScope.dienAp}"><%=p.getDienAp()%></option>
													<option value="220/56-60">220 V/50-60Hz</option>

												</select>

											</div>
										</td>
										<td><div class="input-group" style="display: grid;">
												<label for="mota"><b>Thời gian bảo hành</b></label><select
													name="baoHanh" style="width: 90%; padding: 3px 3px">
													<option value="${requestScope.baoHanh}">${requestScope.baoHanh}
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
													value="${requestScope.type}" name="loai" required>
											</div>
										</td>
										<td>

											<div class="input-group" style="display: grid;">
												<label for="mota"><b>Nhóm</b></label> <input type="text"
													value="${requestScope.nhom}" name="nhom" required>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div class="input-group" style="display: grid;">
												<label for="mota"><b>Hình ảnh</b></label> <img
													src="${requestScope.linkHA1}">
											</div>
										</td>
										<td colspan="2">
											<div class="input-group" style="display: grid;">
												<label for="mota"><b>Cập nhật hình ảnh</b></label> <input
													type="file" name="photo" value="${requestScope.linkHA1}">
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="2" align="right"></td>
									</tr>
									<tr>
										<td><input type="hidden" value="${requestScope.linkHA1}"
											name="image"></td>
									</tr>
									<tr>

										<td align="right" colspan="3">

											<div class="modal-footer">
												<div style="width: 90%; margin-right: 2%; float: right">
												
													<ul class="bt-list">
														<li><a
															href="<%=request.getContextPath()%>/ControllerProduct?action=truyXuatSanPham"
															class="hvr-icon-back col-2"
															style="background: #1bbc9b; text-align: left; width: 100%;">Trở
																lại</a></li>
														<li><button type="submit" class="hvr-icon-fade col-2"
																style="padding: 9px; width: 100%; background: #1bbc9b; border: none; color: white; text-align: left">Cập
																nhật</button></li>
													</ul>
												</div>
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