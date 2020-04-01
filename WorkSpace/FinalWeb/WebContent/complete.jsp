
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
<title>Group02-check out</title>
<!--/tags -->
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
<style type="text/css">
th, td {
	border: 1px solid;
}

tr th {
	text-align: center;
}
</style>
</head>

<body>
	<!-- top-header -->
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="privacy" style="margin-top: -6%;">
		<div class="container">
			<!-- //tittle heading -->
			<a href="userinfo.jsp"><button class="submit check_out">
					<span class="fa fa-reply-all"></span>&nbsp;Trở lại
				</button></a> <a href="index.jsp"><button class="submit check_out">
					<span class="fa fa-cart-plus"></span>&nbsp;Tiếp tục mua hàng
				</button></a> <a href="#"><button class="submit check_out" id='btn'
							onclick='printFunc();'>
					<span class="fa fa-print"></span>&nbsp;In đơn hàng
				</button></a>

			<!-- hien lại hóa đơn 1 lần nữa, thông báo thành công -->
			<div id='printarea'>
				<div class="checkout-right">
					<%
						ShoppingCart shop = (ShoppingCart) request.getAttribute("tempCart");
					%>
					<br>
					<div class="table-responsive">
						<table style="width: 100%">
							<thead>
								<tr>
									<th title="Số thứ tự">STT</th>
									<th>Số lượng</th>
									<th>Tên sản phẩm</th>
									<th>Giá</th>

								</tr>
							</thead>
							<tbody>

								<%
									int count = 1;
									for (ItemCart i : shop.getListItemcart()) {
								%>
								<tr class="rem1">
									<td class="invert" style="text-align: center"><%=count%></td>
									<td class="invert" style="text-align: center"><%=i.getQuantity()%></td>
									<td class="invert"><%=i.getP().getName()%></td>
									<td class="invert"><%=i.getPrice()%></td>
								</tr>
								<%
									count++;
									}
								%>
								<!-- hang thong tin cuoi cung -->
								<tr class="rem1">

									<td colspan="3"><b>Tổng tiền</b></td>
									<td class="invert" style="text-align: right"><b>Total
											Paying: <%=shop.totalPrice()%></b></td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- dinh dang trang in -->

	<!-- in trang web -->
	<script>
		function printFunc() {
			var divToPrint = document.getElementById('printarea');
			var htmlToPrint = '' + '<style type="text/css">'
					+ 'table th, table td {' + 'border:1px solid #000;'
					+ 'padding;0.5em;' + '}' + '</style>';
			htmlToPrint += divToPrint.outerHTML;
			newWin = window.open("");
			newWin.document.write("<h3 align='center'>Đơn hàng</h3>");
			newWin.document.write(htmlToPrint);
			newWin.print();
			newWin.close();
		}
	</script>

	<jsp:include page="footer.jsp"></jsp:include>


	<!-- jquery -->
	<script src="js/jquery-2.1.4.min.js"></script>
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