<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="model_product.ProductDAO"%>
<%@page import="model_product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Quản lí sản phẩm</title>
<script type="text/javascript">
	function checkInput() {
		if (isNaN(checkValidation.price.value)) {
			alert("Giá bán phải là số");
			checkValidation.price.focus();
			return false;
		}
		if (isNaN(checkValidation.discount.value)) {
			alert("Giảm giá phải là số");
			checkValidation.discount.focus();
			return false;
		}
		if (isNaN(checkValidation.soLuong.value)) {
			alert("Số lượng phải là số");
			checkValidation.soLuong.focus();
			return false;
		}

		return true;
	}
</script>

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
<!--//Metis Menu -->
<style>
#chartdiv {
	width: 100%;
	height: 295px;
}
/* Full-width input fields */
input[type=text],input[type=number] {
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
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

				<h2 style="text-align: center">QUẢN LÍ SẢN PHẨM</h2>
				<div class="button_set_one"
					style="width: 85%; float: right; margin-right: 8%;">
					<div style="float: right; margin-right: 2%;">

						<button type="button" class="btn btn-default">
							<span class="	fa fa-files-o"></span>&nbsp;Import excel
						</button>
						<a
							href="<%=request.getContextPath()%>/ControllerProduct?action=displayReport"><button
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
					style="width: 92%; margin-right: 2%; float: right; margin-top: -3%;">
					<div class="bs-example widget-shadow table-responsive"
						data-example-id="hoverable-table">
						<table id="example" class="table table-hover" style="width: 100%">
							<thead>
								<tr>
									<td colspan="6">${numberSearch }</td>
								</tr>
								<tr>
									<th title="Số thứ tự" style="width: 5%">STT</th>
									<th title="Mã sản phẩm" style="width: 10%">Mã</th>
									<th style="width: 20%" title="Tên SP">Tên</th>
									<th style="width: 10%">Giá bán</th>
									<th style="width: 10%">Hình ảnh</th>
									<th style="width: 10%">Hoạt động</th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<Product> list = new ProductDAO().getDemo();
									ArrayList<Product> listSearch = (ArrayList<Product>) request.getAttribute("listSearchID");
									if (listSearch != null) {
										list = listSearch;
									}
									int count = 1;
									for (Product c : list) {
								%>
								<tr>
									<th><%=count%></th>
									<td><%=c.getId()%></td>
									<td><%=c.getName()%></td>
									<%
										DecimalFormat formatter = new DecimalFormat("###,###,###");
									%>
									<td><%=formatter.format(c.getPrice())%></td>
									<td><img
										src="<%=request.getContextPath()%>/<%=c.getLinkHA1()%>"
										class="img-responsive" style="width: 30%"></td>
									<td>
										<table>
											<tr>
												<td>
													<form
														action="<%=request.getContextPath()%>/ControllerProduct?action=remove&id=<%=c.getId()%>"
														onsubmit="return submitForm(this);" method="post">
														<button type="submit" class="btn btn-danger btn-sm"
															style="font-size: 14px;"
															onclick="if (!confirm('bạn có chắc chắn xóa SP: ' + <%=c.getId()%> +'?')) { return false }">
															<span class="fa fa-trash-o"></span>
														</button>
													</form>
												</td>
												<td>&nbsp;<a
													href="<%=request.getContextPath()%>/ControllerProduct?action=find&id=<%=c.getId()%>"
													class="btn btn-primary btn-sm" style="font-size: 13px;"><span
														class="fa fa-edit"></span></a></td>
												<td>&nbsp;<a
													href="<%=request.getContextPath()%>/ControllerProduct?action=view&id=<%=c.getId()%>"
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
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<form name="checkValidation"
				action="<%=request.getContextPath()%>/ControllerProduct?action=add"
				method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="text-align: center">
							<b>THÊM SẢM PHẨM</b>
						</h4>
					</div>
					<div class="modal-body">
						<table style="width: 100%;">
							<tr>
								<td><div class="input-group" style="display: grid;">
										<label for="ma"><b>Mã sản phẩm</b></label> <input type="text"
											value="<%=ProductDAO.idDynamic()%>" name="id">
									</div></td>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Tên sản phẩm</b></label> <input
											type="text" placeholder="Nhập tên sản phẩm" name="name"
											required>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Mô tả</b></label>
										<textarea rows="2" cols="30" name="description"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Giá bán</b></label> <input type="number"
											placeholder="Giá bán sản phẩm" min="0" name="price" required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Giảm giá</b></label> <input type="number"
											placeholder="Giảm giá" min="0" name="discount" required>
									</div></td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Số lượng nhập</b></label> <input
											type="number" min="0" placeholder="Giá bán sản phẩm" name="soLuong"
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
									<!-- sua lai cai select -->
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Loại</b></label> <input type="text"
											placeholder="Loại SP" name="loai" required>
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
					<th title="Mã san pham" style="width: 10%">Mã</th>
					<th style="width: 20%">Tên</th>
					<th style="width: 10%">Giá bán</th>
					<th style="width: 10%">Hình ảnh</th>
				</tr>
				<%
					int count2 = 1;
					for (Product c : list) {
				%>
				<tr>
					<th><%=count2%></th>
					<td style="text-align: center"><%=c.getId()%></td>
					<td><%=c.getName()%></td>
					<%
						DecimalFormat formatter = new DecimalFormat("###,###,###");
					%>
					<td style="text-align: center"><%=formatter.format(c.getPrice())%></td>
					<td style="text-align: center"><img
						src="<%=request.getContextPath()%>/<%=c.getLinkHA1()%>"
						class="img-responsive img-thumbnail" style="width: 30%"></td>
				</tr>
				<%
					count2++;
					}
				%>
			</table>
		</div>
	</div>
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
	<!-- phan trang -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').dataTable({
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

	<!-- xac nhan xoa SP 
	<script>
		document.querySelector('#from1').addEventListener('click',
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
						form.click();
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