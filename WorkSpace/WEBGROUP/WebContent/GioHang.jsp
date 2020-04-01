
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
</head>

<body>
	<!-- top-header -->
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="privacy">
		<div class="container">

			<%
				//danh sach san pham trong gio hang cua Customer
				ShoppingCart shop = (ShoppingCart) session.getAttribute("cart");
				//lay danh sach itemcart
				List<ItemCart> listP = shop.getListCart();
			%>
		<a>${requestScope.KhongTheTang }</a>
		<a>${requestScope.KhongTheTang2 }</a>
		<a>${requestScope.hetHang }</a>
			<!-- //tittle heading -->
			<div class="checkout-right">
				<div class="table-responsive">
					<table class="timetable_sub">
						<thead>
							<tr>
								<th>SL No.</th>
								<th>Product</th>
								<th>Quality</th>
								<th>Product Name</th>
								<th>Price</th>
								<th>Remove</th>
							</tr>
						</thead>
						<tbody>

							<!-- chay for cai gio hang cua Customer de lay thong tin  -->
							<%
								for (int i = 0; i < listP.size(); i++) {

									ItemCart p = listP.get(i);
							%>
							<tr class="rem1">
								<td class="invert"><%=i + 1%></td>
								<td class="invert-image"><a href=""> <img
										src="<%=p.getP().getLinkHA1()%>" alt=" "
										class="img-responsive">
								</a></td>
								<td class="invert">

									<div class="quantity">
										<div class="quantity-select">

											<a
												href="ControllerShopping?action=decreaseQuantity&index=<%=i%>"><div
													class="entry value-minus">&nbsp;</div></a>
											<div class="entry value">
												<span><%=p.getQuantity()%></span>
											</div>
											<a
												href="ControllerShopping?action=increaseQuantity&index=<%=i%>"><div
													class="entry value-plus active">&nbsp;</div></a>

										</div>
									</div>

								</td>
								<td class="invert"><%=p.getP().getName()%></td>
								<td class="invert"><%=p.getPrice()%></td>
								<td class="invert">
									<div class="rem">
										<a
											href="ControllerShopping?action=removeItemCart&index=<%=i%>"><div
												class="close1"></div></a>
									</div>
								</td>
							</tr>
							<%
								}
							%>
							<!-- hang thong tin cuoi cung -->

							<%if(listP.size() == 0){ %>
							<tr class="rem1">
								<td class="invert" colspan="6" style="text-align: center">Giỏ
									hàng đang trống. <a href="index.jsp">Chọn mua sản phẩm</a> </td>
							</tr>
							<%} else{%>
							<tr class="rem1">
								<td class="invert"></td>
								<td class="invert-image"></td>
								<td class="invert"></td>
								<td class="invert"><b>Total Paying: </b></td>
								<td class="invert"><b>${sessionScope.cart.totalPrice()}</b></td>
								<td class="invert"></td>
							</tr>
							<%} %>
						</tbody>
					</table>
					<a href="index.jsp"><button class="submit check_out">Tiếp
							tục mua hàng</button></a>
				</div>
			</div>
			<a href="ControllerShopping?action=checkUser"><button
					class="submit check_out">Check out</button></a>
		</div>
	</div>


	<!-- js-files -->
	<!-- jquery -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- //jquery -->
	<!-- smoothscroll -->
	<script src="js/SmoothScroll.min.js"></script>
	<!-- //smoothscroll -->

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
	<!-- //end-smooth-scrolling -->

	<!-- smooth-scrolling-of-move-up -->
	<script>
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			 */
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //smooth-scrolling-of-move-up -->
	<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
	<!-- //for bootstrap working -->
	<!-- //js-files -->
</body>

</html>