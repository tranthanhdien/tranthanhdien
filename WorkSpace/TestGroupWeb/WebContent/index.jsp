
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
<script src="https://cdn.ckeditor.com/ckeditor5/11.2.0/classic/ckeditor.js"></script>
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

<!-- 'Bước 2' -->
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8&appId=351909355157812";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
	<jsp:include page="menu.jsp"></jsp:include>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators-->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1" class=""></li>
			<li data-target="#myCarousel" data-slide-to="2" class=""></li>
			<li data-target="#myCarousel" data-slide-to="3" class=""></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							Big <span>Save</span>
						</h3>
						<p>
							Get flat <span>10%</span> Cashback
						</p>
						<a class="button2" href="#">Shop Now </a>
					</div>
				</div>
			</div>
			<div class="item item2">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							Healthy <span>Saving</span>
						</h3>
						<p>
							Get Upto <span>30%</span> Off
						</p>
						<a class="button2" href="product.html">Shop Now </a>
					</div>
				</div>
			</div>
			<div class="item item3">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							Big <span>Deal</span>
						</h3>
						<p>
							Get Best Offer Upto <span>20%</span>
						</p>
						<a class="button2" href="product.html">Shop Now </a>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- //banner -->
<div class="fb-comments" data-href="https://www.facebook.com/t.thanhdien" data-numposts="5"></div>

<textarea class="form-textarea" id="noiDung">Chào mừng bạn đến với Blog Kênh Lập Trình</textarea>
<script type="text/javascript" language="javascript">
   CKEDITOR.replace('noiDung', {width: '700px',height: '300px'});
</script>
	<!-- top Products -->
	<div class="ads-grid">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">
				SẢN PHẨM NỔI BẬC<span class="heading-style"> <i></i> <i></i>
					<i></i>
				</span>
			</h3>

			<!-- product right -->
			<div class="agileinfo-ads-display col-md-12">

				<div class="wrapper">

					<!-- first section (dan dụng) -->
					<%
						ArrayList<Product> list2 = new ProductDAO().queryGroupProduct("Bóng led");
					%>
					<div class="product-sec1">
						<h3 class="heading-tittle">Bóng LED</h3>
						<%
							for (int i = 0; i < list2.size(); i++) {
								Product p = list2.get(i);
						%>


						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="<%=p.getLinkHA1()%>" alt="">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="ControllerShopping?action=single&id=<%=p.getId()%>"
												class="link-product-add-cart">Quick view</a>
										</div>
									</div>
									<span class="product-new-top">-<%=p.phanTramGiamGia()%>%
									</span>
								</div>
								<div class="item-info-product ">
									<h4>
										<a href="#"><%=p.getName()%></a>
									</h4>

									<div class="info-product-price">
										<span class="item_price"><%=p.getDiscount()%></span>
										<del><%=p.getPrice()%></del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
										<!-- chuyen danh sach san pham len servlet  -->

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

					<!-- //first section (nuts) -->
					<!-- second section (nuts special) -->
					<div class="product-sec1 product-sec2">
						<div class="col-xs-7 effect-bg">
							<h3 class="">Pure Energy</h3>
							<h6>Enjoy our all healthy Products</h6>
							<p>Get Extra 10% Off</p>
						</div>
						<h3 class="w3l-nut-middle">Nuts & Dry Fruits</h3>
						<div class="col-xs-5 bg-right-nut">
							<img src="images/nut1.png" alt="">
						</div>
						<div class="clearfix"></div>
					</div>
					<!-- //second section (nuts special) -->
					<!-- third section (oils) -->
					<div class="product-sec1">

						<h3 class="heading-tittle">Đèn LED âm trần</h3>

						<%
							for (int i = 0; i < new ProductDAO().queryGroupProduct("led âm trần").size(); i++) {
								Product p = new ProductDAO().queryGroupProduct("led âm trần").get(i);
						%>
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
									<span class="product-new-top">-<%=p.phanTramGiamGia()%>
										%
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
	<!-- special offers -->
	<div class="featured-section" id="projects">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">
				Loại Đặc Biệt <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<div class="content-bottom-in">
				<ul id="flexiselDemo1">

					<%
						for (Product p : new ProductDAO().queryGroupProduct("đặc biệt")) {
					%>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="ControllerShopping?action=addCart&id=<%=p.getId()%>">
									<img src="<%=p.getLinkHA1()%>" alt="<%=p.getName()%>">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="SingleProduct?index=<%=p.getId()%>"><%=p.getName()%></a>
								</h4>
								<div class="w3l-pricehkj">
									<h6><%=p.getPrice()%></h6>
									<p>
										Save
										<%=p.soTienGiamGia()%></p>
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
					</li>
					<%
						}
					%>



				</ul>
			</div>
		</div>
	</div>
	<!-- //special offers -->
	<div style="margin-left: 30%;">
<iframe src="https://www.google.com/maps/d/u/0/embed?mid=1OFB3xk1875E7i6qxo5cTPY8S1cTzl0tr" width="640" height="480"></iframe>

</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<!-- js-files -->
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


	<!-- cart-js -->
	<script src="js/minicart.js"></script>
	<script>
		paypalm.minicartk.render(); //use only unique class names other than paypalm.minicartk.Also Replace same class name in css and minicart.min.js
		paypalm.minicartk.cart.on('checkout', function(evt) {
			var items = this.items(), len = items.length, total = 0, i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			//if (total < 3) {
			//alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
			//evt.preventDefault();
			//}
		});
	</script>
	<!-- //cart-js -->


	<!-- price range (top products) -->
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