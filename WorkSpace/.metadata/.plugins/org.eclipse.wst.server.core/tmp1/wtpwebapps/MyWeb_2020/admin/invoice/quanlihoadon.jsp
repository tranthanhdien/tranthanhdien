
<%@page import="model_product.ProductDAO"%>
<%@page import="model_product.Product"%>
<%@page import="model_user.CustomerDAO"%>
<%@page import="model_user.Customer"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model_shoppingcart.ItemCart"%>
<%@page import="java.util.List"%>
<%@page import="model_shoppingcart.InvoiceDB"%>
<%@page import="model_shoppingcart.Invoice"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Quản lí hóa đơn</title>
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
/* Full-width input fields */
select, input[type=text] {
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
	<!--  -->
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
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
				<div class="button_set_one"
					style="width: 85%; float: right; margin-right: 8%;">
					<!--  
					<div class="search-box">
						<form class="input"
							action="/ControllerProduct?action=lookUp"
							method="post">
							<input placeholder="Tìm kiếm..." type="search" name="search"
								style="padding: 5px 5px; width: 50%;" value="${tk }"
								title="enter * to display all product"><input
								type="submit" value="Tìm kiếm" style="height: 37px;">
						</form>
					</div>
					-->
					<div style="float: right; margin-right: 2%;">

						<button type="button" class="btn btn-default">
							<span class="	fa fa-files-o"></span>&nbsp;Import excel
						</button>
						<a
							href="<%=request.getContextPath()%>/ControllerAdmin?action=displayReport&name=reportProcessInvoice"><button
								type="button" class="btn btn-default">
								<span class="fa fa-file-text-o"></span>&nbsp;Xuất excel
							</button></a>
						<button type="button" class="btn btn-default" id='btn'
							onclick='printFunc();'>
							<span class="fa fa-print"></span>&nbsp;In
						</button>
						<button type="button" class="btn btn-warning" data-toggle="modal"
							data-target="#myModal">
							<span class="fa fa-plus-square-o"></span>&nbsp;Thêm mới
						</button>
					</div>
				</div>

				<!-- the hien noi dung o day -->
				<div
					style="width: 92%; margin-right: 2%; float: right; margin-top: -2%;">
					<div class="bs-example widget-shadow"
						data-example-id="hoverable-table">
						<table id="example" class="table table-hover">
							<thead>
								<tr>
									<th title="Số thứ tự">STT</th>
									<th title="Mã hóa đơn">Mã</th>
									<th>Ngày giao dịch</th>
									<th>Tổng giá</th>
									<th>Khách hàng</th>
									<th>Điện thoại</th>
									<th>Hoạt động</th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<Invoice> list = (ArrayList<Invoice>) request.getAttribute("listInvoice");
									int count = 1;
									for (Invoice c : list) {
								%>
								<tr>
									<th scope="row"><%=count%></th>
									<td><%=c.getNumberInvoice()%></td>
									<%
										java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
									%>
									<td><%=df.format(c.getToday().getTime())%></td>
									<td><%=c.getShop().totalPrice()%></td>
									<td><%=c.getUser().getFullName()%></td>
									<td><%=c.getUser().getPhone()%></td>


									<td>
										<table>
											<tr>
												<td>
													<form
														action="<%=request.getContextPath()%>/ControllerInvoice?action=removeInvoice&idInvoice=<%=c.getNumberInvoice()%>"
														onsubmit="return submitForm(this);" method="post">
														<button type="submit" class="btn btn-danger btn-sm"
															style="font-size: 14px;"
															onclick="if (!confirm('bạn có chắc chắn xóa Hóa đơn: ' + <%=c.getNumberInvoice()%> +'?')) { return false }">
															<span class="fa fa-trash-o"></span>
														</button>
													</form>

												</td>
												<td><a
													href="<%=request.getContextPath()%>/ControllerInvoice?action=findInvoice&idInvoice=<%=c.getNumberInvoice()%>"
													class="btn btn-primary btn-sm" style="font-size: 14px;"><span
														class="fa fa-edit"></span></a></td>
												<td><a
													href="<%=request.getContextPath()%>/ControllerInvoice?action=displayInvoice1&id=<%=c.getNumberInvoice()%>"
													class="btn btn-primary btn-sm" style="font-size: 14px;"><span
														class="fa fa-info-circle"></span></a></td>
											</tr>

										</table>
									</td>
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


	<!-- form them -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<form name="checkValidation"
				action="<%=request.getContextPath()%>/ControllerInvoice?action=add"
				method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="text-align: center">
							<b>THÊM HÓA ĐƠN</b>
						</h4>
					</div>
					<div class="modal-body">
						<table style="width: 100%;">
							<tr>
								<td><div class="input-group" style="display: grid;">
										<label for="ma"><b>Mã hóa đơn</b></label> <input type="text"
											value="<%=new InvoiceDB().dynamicID() %>" name="id">
									</div></td>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Ngày giao dịch</b></label> <input
											type="text" name="date" id="tbDate"  required>
									</div>
								</td>
							</tr>
							<tr>


								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Khách hàng</b></label> <select
											name="khachhang">
											<option>Chọn khách hàng</option>
											<%
												ArrayList<Customer> listCustomer = new CustomerDAO().getListCustomer2();
												for (Customer c : listCustomer) {
											%>
											<option value="<%=c.getId()%>"><%=c.getId()%> // <%=c.getUsername()%>
											</option>
											<%
												}
											%>
										</select>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Nếu chưa có khách hàng</b></label>
										<a href="<%=request.getContextPath()%>/ControllerUser?action=quanlikhachhang">Tạo khách hàng mới</a>
									</div></td>
							</tr>
							<!-- khu vực san phâm -->
							
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Sản phẩm 1:</b></label> 
										<select name="nameSP1">
										<option>Nhập sản phẩm cần tìm</option>
										<%for(Product p : new ProductDAO().getListProduct()){ %>
										<option value="<%=p.getId()%>"><%=p.getName() %></option>
										<%} %>
										
										</select>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Số lượng</b></label> <input type="number"
											placeholder="Nhập số lượng" name="soLuong1" required>
									</div></td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Sản phẩm 2:</b></label> 
										<select name="nameSP2">
										<option value="0">Nhập sản phẩm cần tìm</option>
										<%for(Product p : new ProductDAO().getListProduct()){ %>
										<option value="<%=p.getId()%>"><%=p.getName() %></option>
										<%} %>
										
										</select>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Số lượng</b></label> <input type="number"
											value="" name="soLuong2">
									</div></td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Sản phẩm 3:</b></label> 
										<select name="nameSP3">
										<option value="0">Nhập sản phẩm cần tìm</option>
										<%for(Product p : new ProductDAO().getListProduct()){ %>
										<option value="<%=p.getId()%>"><%=p.getName() %></option>
										<%} %>
										
										</select>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Số lượng</b></label> <input type="number"
											value="" name="soLuong3">
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
	<!-- dinh dang trang in -->
	<div style="display: none;">
		<div id='printarea'>
			<table>
				<tr>
					<th title="Số thứ tự" style="width: 5%">STT</th>
					<th style="width: 10%">Mã</th>
					<th style="width: 20%">Tên khách hàng</th>
					<th style="width: 20%">Điện thoại</th>
					<th style="width: 10%">Ngày giao dịch</th>
					<th style="width: 10%">Tổng tiền</th>
				</tr>
				<%
					count = 1;
					for (Invoice i : list) {
				%>
				<tr>
					<th><%=count%></th>
					<td style="text-align: center"><%=i.getNumberInvoice()%></td>
					<td><%=i.getUser().getFullName()%></td>
					<td><%=i.getUser().getPhone()%></td>
					<td><%=i.getToday()%></td>
					<%
						DecimalFormat formatter = new DecimalFormat("###,###,###");
					%>
					<td style="text-align: center"><%=formatter.format(i.getShop().totalPrice())%></td>


				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">Danh sách sản phẩm:</td>
				</tr>
				<tr>

					<th colspan="3" style="text-align: right">STT</th>
					<th>Tên SP</th>
					<th>Giá</th>
					<th>Số lượng</th>
				</tr>
				<%
					List<ItemCart> listCart = i.getShop().getListItemcart();
						for (int y = 0; y < listCart.size(); y++) {
							ItemCart item = listCart.get(y);
				%>
				<tr>

					<td colspan="3" style="text-align: right"><%=y + 1%></td>
					<td><%=item.getP().getName()%></td>
					<td><%=item.getP().getPrice()%></td>
					<td><%=item.getQuantity()%></td>

				</tr>

				<%
					}
				%>
				<%
					count++;
					}
				%>
			</table>
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
	<!-- in trang web -->
	<script>
		function printFunc() {
			var divToPrint = document.getElementById('printarea');
			var htmlToPrint = '' + '<style type="text/css">'
					+ 'table th, table td {' + 'border:1px solid #000;'
					+ 'padding;0.5em;' + '}' + '</style>';
			htmlToPrint += divToPrint.outerHTML;
			newWin = window.open("");
			newWin.document.write("<h3 align='center'>Quản lí sản phẩm</h3>");
			newWin.document.write(htmlToPrint);
			newWin.print();
			newWin.close();
		}
	</script>
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


	<!-- dam bao xoa
	<script>
		document.querySelector('#from1').addEventListener('submit',
				function(e) {
					var form = this;
					e.preventDefault();
					swal({
						title : "Bạn có chắc chắn muốn xóa?",

						type : "warning",
						showCancelButton : true,
						confirmButtonColor : "#DD6B55",
						confirmButtonText : "Yes.",
						cancelButtonText : "No.",
						closeOnConfirm : false,
						closeOnCancel : false,
						dangerMode : true,
					}).then(function(isConfirm) {
						form.submit();
					});
				});
	</script>
	
	<!-- phan trang -->
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#example')
									.dataTable(
											{
												"language" : {

													"sEmptyTable" : "Không có dữ liệu để hiển thị",
													"sInfo" : "Đang hiển thị _START_ đến _END_ của _TOTAL_ sản phẩm",
													"sInfoEmpty" : "0 bis 0 von 0 Einträgen",
													"sInfoFiltered" : "(Lọc từ  _MAX_ sản phẩm)",
													"sInfoPostFix" : "",
													"sInfoThousands" : ".",
													"sLengthMenu" : "Hiển thị _MENU_ sản phẩm",
													"sLoadingRecords" : "Wird geladen...",
													"sProcessing" : "Bitte warten...",
													"sSearch" : "Tìm kiếm",
													"sZeroRecords" : "Keine Einträge vorhanden.",
													"oPaginate" : {
														"sFirst" : "Erste",
														"sPrevious" : "Trang trước",
														"sNext" : "Trang sau",
														"sLast" : "Letzte"
													},
													"oAria" : {
														"sSortAscending" : ": aktivieren, um Spalte aufsteigend zu sortieren",
														"sSortDescending" : ": aktivieren, um Spalte absteigend zu sortieren"
													}
												}
											});
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
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/newjs/bootstrap.js">
		
	</script>
</body>
</html>