
<%@page import="model_product.IProductDAO"%>
<%@page import="model_product.ProductDAO"%>
<%@page import="model_product.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<title>Group02-Website bán thiết bị chiếu sáng</title>
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
	<jsp:include page="menu.jsp"></jsp:include>
	
	<!-- top Products -->
	<div class="ads-grid">
		<div class="container">
	
			<!-- product right -->
			<div class="agileinfo-ads-display col-md-12" style="margin-top: -5%;">
				
				<div class="wrapper">

					
					<!-- second section (nuts special) -->
					<div class="product-sec1 product-sec2">
						<div class="col-xs-7 effect-bg">
							<h3 class="">Pure Energy</h3>
							<h6>Enjoy our all healthy Products</h6>
							<p>Get Extra 10% Off</p>
						</div>
						<h3 class="w3l-nut-middle">Nuts & Dry Fruits</h3>
						
						<div class="clearfix"></div>
					</div>
					<!-- //second section (nuts special) -->
					<!-- third section (oils) -->
					<div class="product-sec1">

						<h3 class="heading-tittle">Đèn LED âm trần</h3>

						
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="<%=p.getLinkHA1()%>" alt="">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="ControllerShopping?action=single&id=<%=p.getId()%>"
												class="link-product-add-cart">Quick View</a>
										</div>
									</div>
									<span class="product-new-top">-<%=p.phanTramGiamGia()%>%
									</span>
								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single.html"><%=p.getName()%></a>
									</h4>
									<div class="info-product-price">
										<span class="item_price"><%=p.getPrice()%></span>
										<del><%=p.getDiscount()%></del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
										<a href="ControllerShopping?action=addCart&id=<%=p.getId()%>">
											<input type="submit" name="submit" value="Add to cart"
											class="button" />
										</a>

									</div>

								</div>
							</div>
						</div>
						<%
							if (i == 3) {
									break;
								}
							}
						%>

						<div class="clearfix"></div>
					</div>
					<!-- //third section (oils) -->
					<!-- fourth section (noodles) -->
					<div class="product-sec1">
						<h3 class="heading-tittle">LED công nghiệp</h3>

						<%
							for (int i = 0; i < new ProductDAO().queryGroupProduct("Đèn led công nghiệp").size(); i++) {
								Product p = new ProductDAO().queryGroupProduct("Đèn led công nghiệp").get(i);
						%>

						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="<%=p.getLinkHA1()%>" alt="<%=p.getName()%>">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="ControllerShopping?action=single&id=<%=p.getId()%>"
												class="link-product-add-cart">Quick View</a>
										</div>
									</div>
									<span class="product-new-top">-<%=p.phanTramGiamGia()%>%
									</span>
								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single.html"><%=p.getName()%></a>
									</h4>
									<div class="info-product-price">
										<span class="item_price"><%=p.getPrice()%></span>
										<del><%=p.getDiscount()%></del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
										<a href="ControllerShopping?action=addCart&id=<%=p.getId()%>">
											<input type="submit" name="submit" value="Add to cart"
											class="button" />
										</a>

									</div>

								</div>
							</div>
						</div>
						<%
							if (i == 3) {
									break;
								}
							}
						%>

						<div class="clearfix"></div>
					</div>
					<!-- //fourth section (noodles) -->
				</div>
			</div>
			<!-- //product right -->
		</div>
	</div>
	<!-- //top products -->
	
	<!-- //special offers -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- js-files -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/jquery.magnific-popup.js"></script>
	
	<!-- price range (top products) 
	<script src="js/jquery-ui.js"></script>
	<script>
		//<![CDATA[ 
		$(window).load(
				function() {
					$("#slider-range").slider(
							{
								range : true,
								min : 0,
								max : 9000,
								values : [ 50, 6000 ],
								slide : function(event, ui) {
									$("#amount").val(
											"$" + ui.values[0] + " - $"
													+ ui.values[1]);
								}
							});
					$("#amount").val(
							"$" + $("#slider-range").slider("values", 0)
									+ " - $"
									+ $("#slider-range").slider("values", 1));

				}); //]]>
	</script>
	<!-- //price range (top products) -->

	<!-- flexisel (for special offers) -->
	<script src="js/jquery.flexisel.js"></script>
	<script>
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems : 3,
				animationSpeed : 1000,
				autoPlay : true,
				autoPlaySpeed : 3000,
				pauseOnHover : true,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 1
					},
					landscape : {
						changePoint : 640,
						visibleItems : 2
					},
					tablet : {
						changePoint : 768,
						visibleItems : 2
					}
				}
			});

		});
	</script>
	<!-- //flexisel (for special offers) -->

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