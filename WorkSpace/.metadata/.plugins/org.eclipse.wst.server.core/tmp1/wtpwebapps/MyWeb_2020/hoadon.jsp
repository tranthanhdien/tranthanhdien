<%@page import="java.util.ResourceBundle"%>
<%@page import="java.text.DateFormat"%>
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
<html>

<head>
<title>check out</title>
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
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
<style>
tr {
	padding: 10px 10px;
}

tr td {
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
	
	<%
		//binh thuong thi lay ngon ngu la VN
		Locale.setDefault(new Locale("vn", "VN"));
		ResourceBundle resourcebundle = null;
		if (session.getAttribute("language") == null) {
			resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");
		} else {
			String language = (String) session.getAttribute("language");
			if (language.equals("VN")) {
				resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");
			}
			if (language.equals("EN")) {
				resourcebundle = ResourceBundle.getBundle("bundle/demoResource_en_US");
			}
		}
	%>
	<div class="privacy" style="margin-top: -6%;">
		<div class="container">
			<!-- bang thong tin nguoi giao hang  -->
			<div class="table-responsive">
				<table style="width: 100%; border: 1px solid black;">
					<tr>
						<%
							java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						%>
						<td colspan="2" style="text-align: center"><b><%=resourcebundle.getString("datetrading") %> </b> <%=df.format(invoice.getToday().getTime())%></td>
					</tr>
					<tr>
						<td style="border-right: 1px solid black; width: 50%;">
							<!-- thong tin khach hang -->
							<form action="ControllerShopping?action=infoShip" method="post">
							<div class="table-responsive">
								<table>
									<tr>
										<td colspan="2"><label><%=resourcebundle.getString("shipto") %></label><br> <a
											style="color: red">${requestScope.thieuInfo }</a></td>
									</tr>
									<tr>
										<td><label><%=resourcebundle.getString("username") %></label></td>
										<td><input value="<%=invoice.getUser().getUsername()%>"
											name="user" required="required"> <br>
											<p>${requestScope.infoName }</p></td>
									</tr>
									<tr>
										<td><label><%=resourcebundle.getString("recipientname") %></label></td>
										<td><input value="<%=invoice.getUser().getFullName()%>"
											name="fullName" required="required"><br>
											<p>${requestScope.infoFullName }</p></td>
									</tr>
									<tr>
										<td><label><%=resourcebundle.getString("phone") %></label></td>
										<td><input value="<%=invoice.getUser().getPhone()%>"
											pattern="[0-9]{10}" name="phone" title="Số điện thoại hợp lệ gồm 10 chữ số" required="required"><br>
											<p>${requestScope.infoPhone }</p>
											<p>${requestScope.erro_phone_info }</p></td>
									</tr>
									<tr>
										<td><label><%=resourcebundle.getString("address") %></label></td>
										<td><textarea rows="3" cols="40" name="address" required="required"><%=invoice.getUser().getAddress()%></textarea><br>
											<p>${requestScope.infoAddress }</p></td>
									</tr>
									<tr>
										<td colspan="2"><input value="<%=resourcebundle.getString("updateInfoHoaDon") %>"
											type="Submit" style="height: 40px;"></td>
									</tr>
								</table>
								</div>
								<!-- //thong tin khach hang -->
							</form>
						</td>
						<!-- thong tin chuyen khoan -->
						<td>
							<table>
								<tr>
									<td colspan="2"><label><%=resourcebundle.getString("sellerinformation") %></label></td>

								</tr>
								<tr>
									<td><label><%=resourcebundle.getString("seller") %></label></td>
									<td>Lightting Company</td>
								</tr>
								<tr>
									<td><label><%=resourcebundle.getString("addressSale") %></label></td>
									<td>ĐH Nông Lâm, KP6, P.Linh Trung, Q.Thủ Đức, TP.HCM</td>
								</tr>
								<tr>
									<td><label>Email</label></td>
									<td>thanhdien25598@gmail.com</td>
								</tr>
								<tr>
									<td><label><%=resourcebundle.getString("phoneSale") %></label></td>
									<td>035.735.2255</td>
								</tr>
								<tr>
									<td><label>Website</label></td>
									<td><A href="#">web2018-group02.azurewebsites.net</A></td>
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
			</div>
			<!-- //chạy for de lay san pham-->
			<br>
			<div class="checkout-right">

				<div class="table-responsive">
					<table class="timetable_sub">
						<thead>
							<tr>
								<th title="<%=resourcebundle.getString("titleSTTHD")%>"><%=resourcebundle.getString("sttHD")%></th>
								<th><%=resourcebundle.getString("quantityHD")%></th>
								<th><%=resourcebundle.getString("nameproductHD")%></th>
								<th><%=resourcebundle.getString("priceHD")%></th>

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
								<td colspan="3"><b><%=resourcebundle.getString("totalPriceHD")%></b></td>
								<td class="invert" style="text-align: right"><b><%=shop.totalPrice()%></b></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="checkout-right-basket">
				<!-- chuyen toi servlet luu hoa don va thong bao thanh cong cho khach hang -->
				<a href="ControllerShopping?action=completeOrder"><%=resourcebundle.getString("continue") %><span
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