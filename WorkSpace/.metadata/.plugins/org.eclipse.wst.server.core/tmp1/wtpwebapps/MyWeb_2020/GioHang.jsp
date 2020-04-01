<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.text.DecimalFormat"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>

</head>

<body>
	<c:if test="${sessionScope.cart == null }">
		<jsp:forward page="cartnull.jsp"></jsp:forward>
	</c:if>
	<jsp:include page="menu.jsp"></jsp:include>
	<!-- Câu điều kiện if else -->
	<c:choose>
		<c:when test="${sessionScope.language == 'VN' }">
			<fmt:setLocale value="vi_VN" />
			<fmt:setBundle basename="bundle.demoResource_vn_VN"
				var="resourcebundle" />
		</c:when>
		<c:when test="${sessionScope.language == 'EN' }">
			<fmt:setLocale value="en_US" />
			<fmt:setBundle basename="bundle.demoResource_en_US"
				var="resourcebundle" />
		</c:when>
		<c:otherwise>
			<fmt:setLocale value="vi_VN" />
			<fmt:setBundle basename="bundle.demoResource_vn_VN"
				var="resourcebundle" />
		</c:otherwise>
	</c:choose>
	<div class="privacy">
		<div class="container">

			<!-- //tittle heading -->
			<div class="checkout-right">
				<div class="table-responsive">
					<table class="timetable_sub">
						<thead>
							<tr>
								<th title="Số thứ tự"><fmt:message key="stt"
										bundle="${resourcebundle}" /></th>
								<th><fmt:message key="image" bundle="${resourcebundle}" /></th>
								<th><fmt:message key="quantity" bundle="${resourcebundle}" /></th>
								<th><fmt:message key="name" bundle="${resourcebundle}" /></th>
								<th><fmt:message key="price" bundle="${resourcebundle}" /></th>
								<th><fmt:message key="delete" bundle="${resourcebundle}" /></th>
							</tr>
						</thead>
						<tbody>
							<!-- danh sach item cart -->
							<c:forEach items="${sessionScope.cart.listItemcart }" var="p">
								<%
									int i = 0;
								%>
								<tr class="rem1">
									<td class="invert"><%=i + 1%></td>
									<td class="invert-image"><a href=""> <img
											src="
										${p.p.linkHA1}" alt=" " 
											class="img-responsive">
											<!-- Danh sách p.getProduct.getLink -->
									</a></td>
									<td class="invert">
										<div class="quantity">
											<div class="quantity-select">
												<table>
													<tr style="border: none">
														<td style="border: none"><form
																action="ControllerShopping?action=decreaseQuantity"
																method="post" id="form1" name="form1">
																<input type="hidden" name="index" value="<%=i%>" />
																<button type="submit"
																	style="background: none; border: none; width:">
																	<span class="entry value-minus">&nbsp;</span>
																</button>
															</form></td>

														<td style="border: none;">
															<form>
																<div class="entry value">
																	<input type="text" value="${p.quantity}" id="result"
																		style="width: 100%; height: 100%; background: none; border: none; text-align: center">
																</div>
															</form>
														</td>

														<td style="border: none">
															<form method="post"
																action="ControllerShopping?action=increaseQuantity"
																id="form2" name="form2">
																<input type="hidden" name="index" value="<%=i%>" />
																<button type="submit"
																	style="background: none; border: none">
																	<span class="entry value-plus active"
																		title="Tăng số lượng">&nbsp;</span>
																</button>
															</form>
														</td>
													</tr>
												</table>
											</div>
										</div>
									</td>
									<td class="invert" style="font-size: 16px;">${p.p.name}</td>

									<td class="invert" style="font-size: 16px;"><fmt:formatNumber
											value="${p.p.price}" type="currency" /></td>
									<td class="invert">
										<div class="rem" style="margin-left: 20px;">
											<form onsubmit="return submitForm3(this);" method="post"
												action="ControllerShopping?action=removeItemCart">
												<input type="hidden" name="index" value="<%=i%>" />
												<button type="submit" name="submit" class="button"
													style="background: none; border: none">
													<span class="close1"></span>
												</button>
											</form>
										</div>
									</td>
								</tr>
								<%
									i++;
								%>
							</c:forEach>
							<!-- hang thong tin cuoi cung -->
							<c:choose>
								<c:when test="${sessionScope.cart.sizeCart() == 0}">
									<tr class="rem1">
										<td class="invert" colspan="6" style="text-align: center"><fmt:message
												key="giohangdangtrong" bundle="${resourcebundle}" /><a
											href="index.jsp"><fmt:message key="chonsanpham"
													bundle="${resourcebundle}" /></a></td>
									</tr>
								</c:when>

								<c:otherwise>
									<tr class="rem1">
										<td class="invert"></td>
										<td class="invert-image"></td>
										<td class="invert"></td>
										<td class="invert"><b><fmt:message key="totalPrice"
													bundle="${resourcebundle}" />: </b></td>
										<td class="invert"><b id="totalResult"> <fmt:formatNumber
													value="${sessionScope.cart.totalPrice()}" type="currency" />
										</b></td>
										<td class="invert"></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<a href="index.jsp"><button class="submit check_out">
							<fmt:message key="continueShopping" bundle="${resourcebundle}" />
						</button></a>
				</div>
			</div>
			<c:choose>
				<c:when test="${sessionScope.cart.sizeCart() == 0 }">
					<button class="submit check_out"
						title="<fmt:message key="titleCartEmpty" bundle="${resourcebundle}" />"
						disabled="disabled">
						<fmt:message key="thanhToan" bundle="${resourcebundle}" />
					</button>
				</c:when>
				<c:when test="${sessionScope.cart == null }">
					<button class="submit check_out"
						title="<fmt:message key="titleCartEmpty" bundle="${resourcebundle}" />"
						disabled="disabled">
						<fmt:message key="thanhToan" bundle="${resourcebundle}" />
					</button>
				</c:when>
				<c:otherwise>
					<a href="ControllerShopping?action=checkUser"><button
							class="submit check_out">
							<fmt:message key="thanhToan" bundle="${resourcebundle}" />
						</button></a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<!-- xoa -->
	<script>
		"use strict";
		function submitForm3(oFormElement) {
			var xhr = new XMLHttpRequest();
			xhr.onload = function() {
				swal({
					position : 'top-end',
					type : 'success',
					title : xhr.responseText,
					showConfirmButton : false,
					timer : 1000
				});
				window.setTimeout(function() {
					location.reload();
				}, 1000);
			}
			xhr.open(oFormElement.method, oFormElement.action, true);
			xhr.send(new FormData(oFormElement));
			return false;
		}
	</script>

	<!-- tang giam so luong-->
	<script type="text/javascript">
		$(function() {
			$('form').on('submit', function(e) {
				$.ajax({
					type : $(this).attr('method'),
					url : $(this).attr('action'),
					data : $(this).serialize(),
					success : function(data) {
						var result2 = data;
						var array = result2.split("\t");
						$('#result').attr("value", array[0]);
						$('#totalResult').text(array[1]);
					}
				});
				return false;
			});
		});
	</script>

	<!--
	<script type="text/javascript">
		var form = $('#form1');
		form.submit(function() {

			$.ajax({
				type : form.attr('method'),
				url : form.attr('action'),
				data : form.serialize(),
				success : function(data) {
					var result = data;
					$('#result').attr("value", result);
				}

			})

			;
			return false;
		});
	</script>
	<script type="text/javascript">
		var form2 = $('#form2');
		form2.submit(function() {
			$.ajax({
				type : form2.attr('method'),
				url : form2.attr('action'),
				data : form2.serialize(),
				success : function(data) {
					var result2 = data;
					$('#result').attr("value", result2);
				}
			})

			;
			return false;
		});
	</script>

	<!-- js-files -->

	<!-- tang so luong san pham 
	<script type="text/javascript">
		function tang() {
			//get data
			index = document.form.index.value;
			//create link to server
			var url = "ControllerShopping?action=increaseQuantity&index="
					+ index;
			request.open("GET", url, false);//mo link toi url
			try {
				//send request to serverr
				request.send();
				response = request.responseText;//get response
				form.so.value = response;

			} catch (e) {

				alert("Could not");
			}

		}
	</script>
	<!-- //tang so luong san pham -->
	<!-- jquery 
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