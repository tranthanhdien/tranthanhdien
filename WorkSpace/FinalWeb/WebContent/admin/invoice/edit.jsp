<%@page import="model_product.ProductDAO"%>
<%@page import="model_product.Product"%>
<%@page import="model_shoppingcart.ShoppingCart"%>
<%@page import="model_shoppingcart.ItemCart"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>edit</title>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
#chartdiv {
	width: 100%;
	height: 295px;
}
/* Full-width input fields */
select, input[type=text], input[type=number] {
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
	<%
		Invoice invoice = (Invoice) session.getAttribute("findInvoice");
	%>
	<div id="page-wrapper">
		<div class="main-page">

			<form
				action="<%=request.getContextPath()%>/ControllerInvoice?action=edit"
				method="post">
				<div style="width: 93%; float: right; margin-right: 2%;">
					<div class="col_3">
						<h2 style="text-align: center">
							Sửa thông tin đơn hàng có ID
							<%=invoice.getNumberInvoice()%></h2>
						<!-- the hien noi dung o day -->

						<div style="width: 80%; float: right; margin-right: 15%;">
							<table style="width: 100%;">
								<tr>
									<td><table>
											<tr>
												<td><b>Ngày HD: </b></td>
												<td>&nbsp; <input id="tbDate" type="text" name="date"
													value="<%=invoice.getToday()%>" style="width: 300px;">
													<input type="hidden" name="idInvoice"
													value="<%=invoice.getNumberInvoice()%>">
												</td>
											</tr>
											<tr>

												<td colspan="2" style="text-align: right"><ul
														class="bt-list">
														<li>
															<!-- gui form len server cpa nhat lai ngay --> <a
															class="col-7" type="sumit"><input
																value="Cập nhật ngày" type="submit"
																style="background: none; border: none; width: 100%; text-align: left;"></a>
														</li>

													</ul></td>
											</tr>
											<tr>
												<td><b>&nbsp; </b></td>
												<td></td>
											</tr>
											<tr>
												<td><b>&nbsp; </b></td>
												<td></td>
											</tr>
											<tr>
												<td><b>&nbsp; </b></td>
												<td></td>
											</tr>


										</table>
									<td>
										<table>
											<tr>
												<td><b>Thông tin khách hàng: </b></td>
											</tr>

											<tr>
												<td>Tên đăng nhập:</td>
												<td>&nbsp;<%=invoice.getUser().getUsername()%></td>
											</tr>
											<tr>
												<td>Tên:</td>
												<td>&nbsp;<%=invoice.getUser().getFullName()%></td>
											</tr>
											<tr>
												<td>Điện thoại</td>
												<td>&nbsp; <%=invoice.getUser().getPhone()%></td>
											</tr>
											<tr>
												<td>Địa chỉ</td>
												<td>&nbsp; <%=invoice.getUser().getAddress()%></td>
											</tr>

										</table>
									</td>
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
											<th>Xóa</th>
										</tr>
									</thead>
									<tbody>

										<%
											ShoppingCart shop = invoice.getShop();
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
											<!-- goi servlet xoa 1 moon hang -->
											<td><A
												href="<%=request.getContextPath()%>/ControllerAdmin?action=removeCartInvoice&index=<%=i%>"><span
													class="fa fa-times-circle-o" style="font-size: 24px;"></span></A></td>
										</tr>
										<%
											}
										%>
										<tr>
											<td colspan="6" style="text-align: right">
												<button type="button" class="btn btn-warning"
													data-toggle="modal" data-target="#myModal"
													style="background: none; color: blue; text-decoration: underline;">Thêm
													sản phẩm</button>
											</td>

										</tr>
										<tr>
											<th scope="row">Tổng tiền</th>
											<td></td>
											<td></td>
											<td></td>
											<td><b><%=shop.totalPrice()%></b></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div>
								<ul class="bt-list">
									<li><a
										href="<%=request.getContextPath()%>/ControllerInvoice?action=quanlihoadon"
										class="hvr-icon-back col-2" style="background: #1bbc9b;">Trở
											lại</a></li>


								</ul>

							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- form them -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<form name="checkValidation"
				action="<%=request.getContextPath()%>/ControllerInvoice?action=addProductOfEdit"
				method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="text-align: center">
							<b>THÊM SẢN PHẨM TRONG HÓA ĐƠN</b>
						</h4>
					</div>
					<div class="modal-body">
						<table style="width: 100%;">
							<tr>
								<td><input type="hidden"
									value="<%=invoice.getNumberInvoice()%>" name="idHD"></td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Sản phẩm:</b></label> <select
											name="nameSP1">
											<option>Nhập sản phẩm cần tìm</option>
											<%
												for (Product p : new ProductDAO().getListProduct()) {
											%>
											<option value="<%=p.getId()%>"><%=p.getName()%></option>
											<%
												}
											%>

										</select>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Số lượng</b></label> <input type="number"
											placeholder="Nhập số lượng" name="soLuong1" required>
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
	<script>
		$(document).ready(function() {
			$('input[id$=tbDate]').datepicker({});
		});

		$('input[id$=tbDate]').datepicker({
			dateFormat : 'yy-mm-dd'
		});
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
	<!-- //side nav js -->
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/newjs/bootstrap.js">
		
	</script>
	<!-- //Bootstrap Core JavaScript -->
</body>
</html>