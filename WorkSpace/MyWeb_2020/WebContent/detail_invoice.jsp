
<%@page import="java.text.DecimalFormat"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="model_shoppingcart.ItemCart"%>
<%@page import="model_shoppingcart.ShoppingCart"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<title>Chi tiết đơn hàng</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!--//tags -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet">
<!--pop-up-box-->
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<!--//pop-up-box-->
<!-- price range -->
<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
<!-- fonts -->
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800"
	rel="stylesheet">
</head>

<body>
	<!-- top-header -->
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="privacy">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l" style="font-size: 24px; margin-top: -7%">
				CHI TIẾT ĐƠN HÀNG <span class="heading-style"> <i></i> <i></i>
					<i></i>
				</span>
			</h3>
			<!-- //tittle heading -->

			<div class="checkout-right">
				<%
					Invoice invoice = (Invoice) request.getAttribute("invoiceUser");
				%>
				<!-- ke table hien thi -->

				<table id="example" class="table table-hover" style="width: 100%">
					<thead>
						<tr>
							<th title="Số thứ tự"
								style="width: 5%; color: black; font-size: 16px;">STT</th>
							<th style="width: 10%; color: black; font-size: 16px;">Số
								lượng</th>
							<th style="width: 20%; color: black; font-size: 16px;">Sản
								phẩm</th>
							<th style="width: 10%; color: black; font-size: 16px;">Hình
								ảnh</th>
							<th style="width: 10%; color: black; font-size: 16px;">Giá</th>
						</tr>
					</thead>
					<tbody>
						<%
							int count = 1;
							for (ItemCart i : invoice.getShop().getListItemcart()) {
						%>
						<tr>
							<td style="color: black; font-size: 16px;"><%=count%></td>
							<td style="color: black; font-size: 16px;"><%=i.getQuantity()%></td>
							<%
								DecimalFormat formatter = new DecimalFormat("###,###,###");
							%>

							<td style="color: black; font-size: 16px;"><%=i.getP().getName()%></td>

							<td style="color: black; font-size: 16px;"><img
								src="<%=i.getP().getLinkHA1()%>"
								class="img-responsive img-thumbnail" style="width: 35%"></td>

							<td style="color: black; font-size: 16px;"><%=i.getPrice()%>
							</td>
						</tr>
						<%
							count++;
							}
						%>
						<tr>
							<td style="color: black; font-size: 16px;"><b>Tổng tiền</b></td>
							<td></td>
							<td></td>
							<td></td>
							<td style="color: black; font-size: 16px;"><b><%=invoice.getShop().totalPrice()%></b></td>
						</tr>
					</tbody>
				</table>

			</div>
			<a href="userinfo.jsp"><button class="submit check_out">
					<span class="fa fa-reply-all"></span>&nbsp;Trở lại
				</button></a> <a href="index.jsp"><button class="submit check_out">
					<span class="fa fa-cart-plus"></span>&nbsp;Tiếp tục mua hàng
				</button></a> <a href="#"><button class="submit check_out" id='btn'
					onclick='printFunc();'>
					<span class="fa fa-print"></span>&nbsp;In đơn hàng
				</button></a>
		</div>
	</div>

	<!-- in hoa don -->
	<div style="display: none;">
		<div id='printarea'>
			<table id="example" class="table table-hover" style="width: 100%">
				<thead>
					<tr>
						<th title="Số thứ tự"
							style="width: 10%; color: black; font-size: 16px;">STT</th>
						<th style="width: 10%; color: black; font-size: 16px;">Số
							lượng</th>
						<th style="width: 20%; color: black; font-size: 16px;">Sản
							phẩm</th>
						<th style="width: 10%; color: black; font-size: 16px;">Hình
							ảnh</th>
						<th style="width: 10%; color: black; font-size: 16px;">Giá</th>
					</tr>
				</thead>
				<tbody>
					<%
						count = 1;
						for (ItemCart i : invoice.getShop().getListItemcart()) {
					%>
					<tr>
						<td style="color: black; font-size: 16px; text-align: center;"><%=count%></td>
						<td style="color: black; font-size: 16px; text-align: center;"><%=i.getQuantity()%></td>
						<%
							DecimalFormat formatter = new DecimalFormat("###,###,###");
						%>

						<td style="color: black; font-size: 16px;"><%=i.getP().getName()%></td>

						<td style="color: black; font-size: 16px; text-align: center;"><img
							src="<%=i.getP().getLinkHA1()%>"
							class="img-responsive img-thumbnail" style="width: 35%"></td>

						<td style="color: black; font-size: 16px; text-align: center;"><%=i.getPrice()%></td>
					</tr>
					<%
						count++;
						}
					%>
					<tr>
						<td style="color: black; font-size: 16px;"><b>Tổng tiền</b></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="color: black; font-size: 16px;"><b><%=invoice.getShop().totalPrice()%></b></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

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

	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').dataTable();
		});
	</script>
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- smoothscroll -->
	<script src="js/SmoothScroll.min.js"></script>
	<!-- start-smooth-scrolling -->
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<script>
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- smooth-scrolling-of-move-up -->
	<script>
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});
		});
	</script>
	<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
</body>

</html>