
<%@page import="model_shoppingcart.ItemCart"%>
<%@page import="java.util.Date"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="model_user.Customer"%>
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
<style>
tr {
	border: 1px solid black;
	padding: 10px 10px;
}

tr td {
	border: 1px solid black;
	padding: 6px 6px;
}
</style>
</head>

<body>

	<%
		Invoice invoice = null;
		invoice = (Invoice) session.getAttribute("invoice");
		ShoppingCart shop = invoice.getShop();
	%>
	<!-- top-header -->
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="privacy">
		<div class="container">

			<!-- bang thong tin nguoi giao hang  -->
			<table style="width: 100%; border: 1px solid black;">
				<tr>
					<td colspan="2" style="text-align: center"><b>Ngày giao
							dịch: </b> <%=invoice.getToday()%></td>
				</tr>
				<tr>
					<td>
						<!-- thong tin khach hang -->
						<form action="ControllerShopping?action=infoShip" method="post">
							<table>
								<tr>
									<td colspan="2"><label>Ship to:</label><br> <a
										style="color: red">${requestScope.thieuInfo }</a></td>

								</tr>
								<tr>
									<td><label>UserName</label></td>
									<td><input value="<%=invoice.getUser().getUsername()%>"
										name="user"> <br>
										<p>${requestScope.infoName }</p></td>
								</tr>
								<tr>
									<td><label>FullName</label></td>
									<td><input value="<%=invoice.getUser().getFullName()%>"
										name="fullName"><br>
										<p>${requestScope.infoFullName }</p></td>
								</tr>
								<tr>
									<td><label>Phone</label></td>
									<td><input value="<%=invoice.getUser().getPhone()%>"
										name="phone"><br>
										<p>${requestScope.infoPhone }</p><p>${requestScope.erro_phone_info }</p>
										</td>
								</tr>


								<tr>
									<td><label>Address</label></td>
									<td><textarea rows="2" cols="50" name="address"><%=invoice.getUser().getAddress() %></textarea><br>
										<p>${requestScope.infoAddress }</p></td>
								</tr>
								<tr>
									<td colspan="2"><input value="Edit Info" type="Submit"></td>
								</tr>
							</table>
							<!-- //thong tin khach hang -->
						</form>
					</td>
					<!-- thong tin chuyen khoan -->
					<td>
						<table>
							<tr>
								<td colspan="2"><label>Thông tin người bán:</label></td>

							</tr>
							<tr>
								<td><label>Người bán</label></td>
								<td>Công ty Lightting</td>
							</tr>
							<tr>
								<td><label>Địa Chỉ</label></td>
								<td></td>
							</tr>
							<tr>
								<td><label>Email</label></td>
								<td></td>
							</tr>
							<tr>
								<td><label>Phone</label></td>
								<td></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td></td>
							</tr>

						</table>
					</td>
					<!-- //thong tin chuyen khoan -->
				</tr>
			</table>

			<!-- //chạy for de lay san pham-->
			<br>
			<div class="checkout-right">

				<div class="table-responsive">
					<table class="timetable_sub">
						<thead>
							<tr>
								<th>SL No.</th>
								<th>Quality</th>
								<th>Product Name</th>
								<th>Price</th>

							</tr>
						</thead>
						<tbody>

							<%
							int count = 1;
								for (ItemCart i : shop.getListItemcart()) {
							%>
							<tr class="rem1">
								<td class="invert"><%=count %></td>
								<td class="invert"><%=i.getQuantity() %></td>
								<td class="invert"><%=i.getP().getName() %></td>
								<td class="invert"><%=i.getPrice() %></td>
							</tr>
							<%
							count++;
								}
							%>
							<!-- hang thong tin cuoi cung -->
							<tr class="rem1">


								<td class="invert" colspan="4" style="text-align: right"><b>Total
										Paying: <%=shop.totalPrice() %></b></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="checkout-right-basket">
				<!-- chuyen toi servlet luu hoa don va thong bao thanh cong cho khach hang -->
				<a href="ControllerShopping?action=completeOrder">Continute<span
					class="fa fa-hand-o-right" aria-hidden="true"></span>
				</a>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>

	<!-- jquery -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- //jquery -->

	<!-- popup modal (for signin & signup)-->
	<script src="js/jquery.magnific-popup.js"></script>
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});

		});
	</script>
	<!-- Large modal -->
	<!-- <script>
		$('#').modal('show');
	</script> -->
	<!-- //popup modal (for signin & signup)-->



	<!-- cart-js 
	<script src="js/minicart.js"></script>
	<script>
		paypalm.minicartk.render(); //use only unique class names other than paypal1.minicart1.Also Replace same class name in css and minicart.min.js

		paypalm.minicartk.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});
	</script>
	<!-- //cart-js -->

	<!--quantity
	
	<script>
		$('.value-plus').on('click', function () {
			var divUpd = $(this).parent().find('.value'),
				newVal = parseInt(divUpd.text(), 10) + 1;
			divUpd.text(newVal);
		});

		$('.value-minus').on('click', function () {
			var divUpd = $(this).parent().find('.value'),
				newVal = parseInt(divUpd.text(), 10) - 1;
			if (newVal >= 1) divUpd.text(newVal);
		});
	</script>
	<!--quantity
	<script>
		$(document).ready(function (c) {
			$('.close1').on('click', function (c) {
				$('.rem1').fadeOut('slow', function (c) {
					$('.rem1').remove();
				});
			});
		});
	</script>
	
	<script>
		$(document).ready(function (c) {
			$('.close2').on('click', function (c) {
				$('.rem2').fadeOut('slow', function (c) {
					$('.rem2').remove();
				});
			});
		});
	</script>
	<script>
		$(document).ready(function (c) {
			$('.close3').on('click', function (c) {
				$('.rem3').fadeOut('slow', function (c) {
					$('.rem3').remove();
				});
			});
		});
	</script>
	<!--//quantity-->

	<!-- password-script -->
	<script>
		window.onload = function() {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}

		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity(
						"Passwords Don't Match");
			else
				document.getElementById("password2").setCustomValidity('');
			//empty string means no validation error
		}
	</script>
	<!-- //password-script -->

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