
<%@page import="model_product.ProductDAO"%>
<%@page import="model_product.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<title>Chi tiết sản phẩm</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
		addEventListener("load", function () {
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
<!-- flexslider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<!-- fonts -->
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800"
	rel="stylesheet">
</head>

<body>
	<!-- top-header -->
	<jsp:include page="menu.jsp"></jsp:include>
	<!-- //navigation -->
	<!-- banner-2 
	<div class="page-head_agile_info_w3l">

	</div>
	<!-- //banner-2 -->
	<!-- page 
	<div class="services-breadcrumb">
		<div class="agile_inner_breadcrumb">
			<div class="container">
				<ul class="w3_short">
					<li>
						<a href="index.html">Home</a>
						<i>|</i>
					</li>
					<li>Single Page</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- //page -->
	<!-- Single Page -->
	<div class="banner-bootom-w3-agileits">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">
				Chi tiết sản phẩm <span class="heading-style"> <i></i> <i></i>
					<i></i>
				</span>
			</h3>


			<!-- bat dau san pham -->
			<%Product p = (Product)request.getAttribute("singleProduct"); %>

			<!-- //tittle heading -->
			<div class="col-md-5 single-right-left ">
				<div class="grid images_3_of_2">
					<div class="flexslider">
						<ul class="slides">

							<li data-thumb="${requestScope.singleProduct.getLinkHA1() }">
								<div class="thumb-image">
									<img src="${requestScope.singleProduct.getLinkHA1() }"
										data-imagezoom="true" class="img-responsive" alt="">
								</div>
							</li>
							<li data-thumb="${requestScope.singleProduct.getLinkHA1() }">
								<div class="thumb-image">
									<img src="${requestScope.singleProduct.getLinkHA1() }" data-imagezoom="true"
										class="img-responsive" alt="">
								</div>
							</li>
							<li data-thumb="${requestScope.singleProduct.getLinkHA1() }">
								<div class="thumb-image">
									<img src="${requestScope.singleProduct.getLinkHA1() }" data-imagezoom="true"
										class="img-responsive" alt="">
								</div>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<div class="col-md-7 single-right-left simpleCart_shelfItem">
				<h3><%=p.getName() %></h3>
				<div class="rating1">
					<span class="starRating"> <input id="rating5" type="radio"
						name="rating" value="5"> <label for="rating5">5</label> <input
						id="rating4" type="radio" name="rating" value="4"> <label
						for="rating4">4</label> <input id="rating3" type="radio"
						name="rating" value="3" checked=""> <label for="rating3">3</label>
						<input id="rating2" type="radio" name="rating" value="2">
						<label for="rating2">2</label> <input id="rating1" type="radio"
						name="rating" value="1"> <label for="rating1">1</label>
					</span>
				</div>
				<p>
					<span class="item_price"><%=p.getPrice() %></span>
					<del><%=p.getDiscount() %></del>
					<label>Free ship cho đơn hàng từ 150.000đ</label>
				</p>
				<div class="single-infoagile">
					<ul>
						<li>Công suất: <%=p.getCongSuat() %> W
						</li>
						<li>Điện áp: <%=p.getDienAp() %>
						</li>
						<li>Bảo hành: <%=p.getBaoHanh() %> năm
						</li>
						<!-- 
						<li>
							1 offer from
							<span class="item_price">$950.00</span>
						</li>-->
					</ul>
				</div>
				<div class="product-single-w3l">
					<p>
						<i class="fa fa-hand-o-right" aria-hidden="true"></i>Thuộc loại
						sản phẩm <label><%=p.getType() %></label>
					</p>
					<ul>
						<li><%=p.getDescription() %></li>

					</ul>
					<p>
						<i class="fa fa-refresh" aria-hidden="true"></i>Cam kết <label>
							đổi trả dễ dàng</label>, Bảo hành <label> uy tín</label>
					</p>
				</div>
				<div class="occasion-cart">
					<div
						class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
						<a href="ControllerShopping?action=addCart&id=<%=p.getId()%>">
							<input type="submit" name="submit" value="Add to cart"
							class="button" />
						</a>
					</div>

				</div>

			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //Single Page -->

	<!-- special offers -->
	<div class="featured-section" id="projects">
		<div class="container">
			<!-- tittle heading -->
			<!-- lay len danh sach sản ph -->
			<h3 class="tittle-w3l">
				Sản phẩm khác <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<div class="content-bottom-in">
				<ul id="flexiselDemo1">

					<%for(Product pro : new ProductDAO().queryGroupProduct("đặc biệt")){ %>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="SingleProduct?index=<%=pro.getId()%>"> <img
									src="<%=pro.getLinkHA1() %>" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="SingleProduct?index=<%=pro.getId()%>"><%=pro.getName() %></a>
								</h4>
								<div class="w3l-pricehkj">
									<h6><%=pro.getPrice() %></h6>
									<p>
										Save
										<%=pro.soTienGiamGia() %></p>
								</div>
								<div
									class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
									<form action="#" method="post">
										<fieldset>
											<input type="hidden" name="cmd" value="_cart" /> <input
												type="hidden" name="add" value="1" /> <input type="hidden"
												name="business" value=" " /> <input type="hidden"
												name="item_name" value="<%=pro.getName() %>" /> <input
												type="hidden" name="amount" value="<%=pro.getPrice() %>" />
											<input type="hidden" name="discount_amount"
												value="<%=pro.soTienGiamGia() %>" /> <input type="hidden"
												name="currency_code" value="VND" /> <input type="hidden"
												name="return" value=" " /> <input type="hidden"
												name="cancel_return" value=" " /> <input type="submit"
												name="submit" value="Add to cart" class="button" />
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</li>
					<%} %>

				</ul>
			</div>
		</div>
	</div>
	<!-- //special offers -->

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- js-files -->
	<!-- jquery -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- //jquery -->

	<!-- popup modal (for signin & signup)-->
	<script src="js/jquery.magnific-popup.js"></script>
	<script>
		$(document).ready(function () {
			$('.popup-with-zoom-anim').magnificPopup({
				type: 'inline',
				fixedContentPos: false,
				fixedBgPos: true,
				overflowY: 'auto',
				closeBtnInside: true,
				preloader: false,
				midClick: true,
				removalDelay: 300,
				mainClass: 'my-mfp-zoom-in'
			});

		});
	</script>
	<!-- Large modal -->
	<!-- <script>
		$('#').modal('show');
	</script> -->
	<!-- //popup modal (for signin & signup)-->

	<!-- cart-js -->
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

	<!-- password-script -->
	<script>
		window.onload = function () {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}

		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity("Passwords Don't Match");
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
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->

	<!-- smooth-scrolling-of-move-up -->
	<script>
		$(document).ready(function () {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<!-- //smooth-scrolling-of-move-up -->

	<!-- imagezoom -->
	<script src="js/imagezoom.js"></script>
	<!-- //imagezoom -->

	<!-- FlexSlider -->
	<script src="js/jquery.flexslider.js"></script>
	<script>
		// Can also be used with $(document).ready()
		$(window).load(function () {
			$('.flexslider').flexslider({
				animation: "slide",
				controlNav: "thumbnails"
			});
		});
	</script>
	<!-- //FlexSlider-->

	<!-- flexisel (for special offers) -->
	<script src="js/jquery.flexisel.js"></script>
	<script>
		$(window).load(function () {
			$("#flexiselDemo1").flexisel({
				visibleItems: 3,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: {
					portrait: {
						changePoint: 480,
						visibleItems: 1
					},
					landscape: {
						changePoint: 640,
						visibleItems: 2
					},
					tablet: {
						changePoint: 768,
						visibleItems: 2
					}
				}
			});

		});
	</script>
	<!-- //flexisel (for special offers) -->

	<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
	<!-- //for bootstrap working -->
	<!-- //js-files -->

</body>

</html>