<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="model_product.IProductDAO"%>
<%@page import="model_product.ProductDAO"%>
<%@page import="model_product.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<c:choose>
		<c:when test="${sessionScope.language == 'VN' }">
			<fmt:setBundle basename="bundle.demoResource_vn_VN"
				var="resourcebundle" />
		</c:when>
		<c:when test="${sessionScope.language == 'EN' }">

			<fmt:setBundle basename="bundle.demoResource_en_US"
				var="resourcebundle" />
		</c:when>
		<c:otherwise>
			<fmt:setBundle basename="bundle.demoResource_vn_VN"
				var="resourcebundle" />
		</c:otherwise>
	</c:choose>

	<!-- top Products -->
	<div class="ads-grid">
		<div class="container">
			<!-- product right -->
			<div class="agileinfo-ads-display col-md-12" style="margin-top: -5%;">
				<div class="wrapper">
					<!-- first section (dan dụng) -->
					<%
						ArrayList<Product> list = new ProductDAO().getListProduct();
					%>
					<div class="product-sec1">
						<h3 class="heading-tittle">
							<fmt:message key="leblight" bundle="${resourcebundle}" />
						</h3>

						<%
							for (int i = 0; i < list.size(); i++) {
								Product p = list.get(i);
						%>
						
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="<%=p.getLinkHA1()%>" alt="">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="ControllerShopping?action=single&id=<%=p.getId()%>"
												class="link-product-add-cart"><fmt:message
													key="quickview" bundle="${resourcebundle}" /></a>
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
										<form method="post"
											action="ControllerShopping?action=addCart&id=<%=p.getId()%>"
											onsubmit="return submitForm(this);">
											<input type="hidden" name="id" value="<%=p.getId()%>" /> <input
												type="submit" name="submit"
												value="<fmt:message key="addtocart" bundle="${resourcebundle}" />"
												class="button" />
										</form>
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
					
					
				</div>
			</div>
			<!-- //product right -->
		</div>
	</div>
	<!-- //top products -->
	

	
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- js-files -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/jquery.magnific-popup.js"></script>
	<!-- thêm san pham -->
	<script>
		"use strict";
		function submitForm(oFormElement) {
			var xhr = new XMLHttpRequest();
			xhr.onload = function() {
				var str = xhr.responseText;
				var array = str.split("\t");
				swal({
					position : 'top-end',
					type : 'success',
					title : array[0],
					showConfirmButton : false,
					timer : 1000
				})
				$('#resultcart').text(array[1]);
				//.text(....)
			}
			xhr.open(oFormElement.method, oFormElement.action, true);
			xhr.send(new FormData(oFormElement));
			return false;
		}
	</script>

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