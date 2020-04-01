<%@page import="model_product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<title>Product</title>
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
	<!-- //navigation -->
	<!-- banner-2 
	<div class="page-head_agile_info_w3l">

	</div>
	<!-- //banner-2 -->

	<!-- top Products -->
	<div class="ads-grid">
		<div class="container">
			<!-- tittle heading 
			<h3 class="tittle-w3l">Kitchen Products
				<span class="heading-style">
					<i></i>
					<i></i>
					<i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<!-- product left -->
			<div class="side-bar col-md-3">
				<div class="search-hotel">
					<h3 class="agileits-sear-head">Search Here..</h3>
					<form action="#" method="post">
						<input type="search" placeholder="Product name..." name="search"
							required=""> <input type="submit" value=" ">
					</form>
				</div>
				<!-- price range -->
				<div class="range">
					<h3 class="agileits-sear-head">Price range</h3>
					<ul class="dropdown-menu6">
						<li>

							<div id="slider-range"></div> <input type="text" id="amount"
							style="border: 0; color: #ffffff; font-weight: normal;" />
						</li>
					</ul>
				</div>
				<!-- //price range -->

				<!-- food preference -->
				<div class="left-side">
					<h3 class="agileits-sear-head">Food Preference</h3>
					<ul>
						<li><input type="checkbox" class="checked"> <span
							class="span">Vegetarian</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Non-Vegetarian</span></li>
					</ul>
				</div>
				<!-- //food preference -->
				<!-- discounts -->
				<div class="left-side">
					<h3 class="agileits-sear-head">Discount</h3>
					<ul>
						<li><input type="checkbox" class="checked"> <span
							class="span">5% or More</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">10% or More</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">20% or More</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">30% or More</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">50% or More</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">60% or More</span></li>
					</ul>
				</div>
				<!-- //discounts -->
				<!-- reviews -->
				<div class="customer-rev left-side">
					<h3 class="agileits-sear-head">Customer Review</h3>
					<ul>
						<li><a href="#"> <i class="fa fa-star" aria-hidden="true"></i>
								<i class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star"
								aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i>
								<span>5.0</span>
						</a></li>
						<li><a href="#"> <i class="fa fa-star" aria-hidden="true"></i>
								<i class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star"
								aria-hidden="true"></i> <i class="fa fa-star-o"
								aria-hidden="true"></i> <span>4.0</span>
						</a></li>
						<li><a href="#"> <i class="fa fa-star" aria-hidden="true"></i>
								<i class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star-half-o" aria-hidden="true"></i> <i
								class="fa fa-star-o" aria-hidden="true"></i> <span>3.5</span>
						</a></li>
						<li><a href="#"> <i class="fa fa-star" aria-hidden="true"></i>
								<i class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star-o" aria-hidden="true"></i> <i
								class="fa fa-star-o" aria-hidden="true"></i> <span>3.0</span>
						</a></li>
						<li><a href="#"> <i class="fa fa-star" aria-hidden="true"></i>
								<i class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star-half-o" aria-hidden="true"></i> <i
								class="fa fa-star-o" aria-hidden="true"></i> <i
								class="fa fa-star-o" aria-hidden="true"></i> <span>2.5</span>
						</a></li>
					</ul>
				</div>
				<!-- //reviews -->
				<!-- cuisine -->
				<div class="left-side">
					<h3 class="agileits-sear-head">Cuisine</h3>
					<ul>
						<li><input type="checkbox" class="checked"> <span
							class="span">South American</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">French</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Greek</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Chinese</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Japanese</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Italian</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Mexican</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Thai</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span">Indian</span></li>
						<li><input type="checkbox" class="checked"> <span
							class="span"> Spanish </span></li>
					</ul>
				</div>
				<!-- //cuisine -->
			</div>
			<!-- //product left -->
			<!-- product right -->

			<% 
				//lay danh sach san pham loc theo nhom len
				ArrayList<Product> lisP = (ArrayList<Product>) request.getAttribute("filter");
			%>
			<div class="agileinfo-ads-display col-md-9 w3l-rightpro">
				<div class="wrapper">


					<!-- first section -->
					<div class="product-sec1">


						<%
							for (Product p : lisP) {
						%>
						<div class="col-xs-4 product-men" style="margin-top: 10px;">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="<%=p.getLinkHA1()%>" alt="">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single.html" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>
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
							}
						%>

					</div>
				</div>
				<!-- //product right -->
			</div>
		</div>
		<!-- //top products -->
		<script src="js/jquery-2.1.4.min.js"></script>
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
		<!-- for bootstrap working -->
		<script src="js/bootstrap.js"></script>
</body>

</html>