<%@page import="java.util.List"%>
<%@page import="model_shoppingcart.ItemCart"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Invoices</title>
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
<!-- phan trang -->
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
<style type="text/css">
* {
	font-size: 16px;
}
</style>
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
				<h3 style="text-align: center">DANH SÁCH HÓA ĐƠN CHƯA XỬ LÍ</h3>
				<div class="button_set_one"
					style="width: 85%; float: right; margin-right: 8%;">
					<div style="float: right; margin-right: 2%;">
						<a
							href="<%=request.getContextPath()%>/ControllerAdmin?action=displayReport&name=unprocessInvoice"><button
								type="button" class="btn btn-default">
								<span class="fa fa-file-text-o"></span>&nbsp;Xuất excel
							</button></a>
						<button type="button" class="btn btn-default" id='btn'
							onclick='printFunc();'>
							<span class="fa fa-print"></span>&nbsp;In
						</button>
						<a
							href="<%=request.getContextPath()%>/ControllerAdmin?action=allInvoice"><button
								type="button" class="btn btn-success">
								<span class="	fa fa-files-o"></span>&nbsp;Xử lí tất cả
							</button></a> <a
							href="<%=request.getContextPath()%>/ControllerAdmin?action=removeAllInvoice"><button
								type="button" class="btn btn-danger">
								<span class="fa fa-remove-square-o"></span>&nbsp;Hủy tất cả
							</button></a>
					</div>
				</div>
				<!-- the hien noi dung o day -->
				<div
					style="width: 95%; margin-right: 2%; float: right; margin-top: -3%;">
					<div class="bs-example widget-shadow"
						data-example-id="hoverable-table">
						<table id="example" class="table table-hover">
							<thead>
								<tr>
									<th title="Số thứ tự">STT</th>
									<th>Tên khách hàng</th>
									<th>Ngày lập HD</th>
									<th>Tổng giá</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<Invoice> listInvoid = (ArrayList<Invoice>) session.getAttribute("unprocessInvoices");
									int count = 1;
									for (Invoice i : listInvoid) {
								%>
								<tr>
									<th scope="row"><%=count%></th>
									<td><%=i.getUser().getFullName()%></td>
									<%
										java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
									%>
									<td><%=df.format(i.getToday().getTime())%></td>
									<td><%=i.getShop().totalPrice()%></td>

									<td><a
										href="<%=request.getContextPath()%>/ControllerAdmin?action=displayInvoice&idInvoice=<%=i.getNumberInvoice()%>">Chọn
											để xem</a></td>
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
					for (Invoice i : listInvoid) {
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
			"language": {
				
					"sEmptyTable":   	"Không có dữ liệu để hiển thị",
					"sInfo":         	"Đang hiển thị _START_ đến _END_ của _TOTAL_ sản phẩm",
					"sInfoEmpty":    	"0 bis 0 von 0 Einträgen",
					"sInfoFiltered": 	"(Lọc từ  _MAX_ sản phẩm)",
					"sInfoPostFix":  	"",
					"sInfoThousands":  	".",
					"sLengthMenu":   	"Hiển thị _MENU_ sản phẩm",
					"sLoadingRecords": 	"Wird geladen...",
					"sProcessing":   	"Bitte warten...",
					"sSearch":       	"Tìm kiếm",
					"sZeroRecords":  	"Keine Einträge vorhanden.",
					"oPaginate": {
						"sFirst":    	"Erste",
						"sPrevious": 	"Trang trước",
						"sNext":     	"Trang sau",
						"sLast":     	"Letzte"
					},
					"oAria": {
						"sSortAscending":  ": aktivieren, um Spalte aufsteigend zu sortieren",
						"sSortDescending": ": aktivieren, um Spalte absteigend zu sortieren"
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
	<!-- //side nav js -->
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/newjs/bootstrap.js">
		
	</script>
	<!-- //Bootstrap Core JavaScript -->
</body>
</html>