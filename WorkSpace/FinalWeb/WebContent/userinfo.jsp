<%@page import="model_user.CustomerDAO"%>
<%@page import="model_user.Customer"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model_user.Login"%>
<%@page import="model_shoppingcart.InvoiceDB"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<title>User info</title>
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

<!-- phan trang -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>

<link
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
<style type="text/css">

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 80%;
	padding: 5px 5px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>

<body>
	<%
		if (session.getAttribute("user") == null) {
	%>
	<!-- top-header -->
	<jsp:forward page="login.jsp"></jsp:forward>
	<%
		}
	%>
	<jsp:include page="menu.jsp"></jsp:include>

	<!-- payment page-->
	<div class="privacy">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l" style="font-size: 24px">
				THÔNG TIN KHÁCH HÀNG <span class="heading-style"> <i></i> <i></i>
					<i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<div class="checkout-right">
				<!--Horizontal Tab-->
				<div id="parentHorizontalTab">
					<ul class="resp-tabs-list hor_1">
						<li style="font-size: 16px;">Đơn hàng hiện tại</li>
						<li style="font-size: 16px;">Thông tin khách hàng</li>
						<li style="font-size: 16px;">Đơn hàng đã đặt</li>
					</ul>
					<div class="resp-tabs-container hor_1">
						<div>
							<div class="vertical_post check_box_agile">
								<h5>COD</h5>
								<div class="checkbox">
									<div class="check_box_one cashon_delivery">
										<label class="anim"> <input type="checkbox"
											class="checkbox"> <span> We also accept
												Credit/Debit card on delivery. Please Check with the agent.</span>
										</label>
									</div>

								</div>
							</div>
						</div>
						<div>
							<!-- thong tin ca nhan cua khach hang -->
							<table>
								<tr>
									<!-- thong tin -->
									<%
										Login user = (Login) session.getAttribute("user");
										Customer c = new CustomerDAO().mappingUserInfo(user.getIdUser());
									%>
									<td>
										<table>
											<tr>
												<td><b>Tên đăng nhập: &nbsp; &nbsp; &nbsp; &nbsp;
														&nbsp; &nbsp; &nbsp;</b></td>
												<td><%=c.getUsername()%></td>
											</tr>
											<tr>
												<td><b>Tên thực: </b></td>
												<td><%=c.getFullName()%></td>
											</tr>
											<tr>
												<td><b>Email: </b></td>
												<td><%=user.getEmail()%></td>
											</tr>
											<tr>
												<td><b>Số điện thoại: </b></td>
												<td><%=c.getPhone()%></td>
											</tr>
											<tr>
												<td><b>Địa chỉ: </b></td>
												<td><%=c.getAddress()%></td>
											</tr>
										</table>
									</td>
									<!-- button cap nhat -->
								</tr>
								<tr>
									<td><button class="btn btn-success"
											onclick="document.getElementById('id01').style.display='block'"
											style="width: auto;">
											<span>Thay đổi</span>
										</button></td>
								</tr>
							</table>
						</div>
						<div>
							<div class="vertical_post">
								<!-- hien thi danh sach don hang cua khach hang -->
								<%
									ArrayList<Invoice> list = new InvoiceDB().getListInvoiceOfAUser(user.getIdUser());
								%>
								<!-- ke table hien thi -->
								<table id="example" class="table table-hover"
									style="width: 100%">
									<thead>
										<tr>
											<td colspan="6">${numberSearch }</td>
										</tr>
										<tr>
											<th title="Số thứ tự"
												style="width: 10%; color: black; font-size: 16px;">STT</th>
											<th style="width: 10%; color: black; font-size: 16px;">Mã
												hóa đơn</th>
											<th style="width: 20%; color: black; font-size: 16px;">Ngày
												đặt hàng</th>
											<th style="width: 10%; color: black; font-size: 16px;">Tổng
												giá</th>
											<th style="width: 10%; color: black; font-size: 16px;">Trạng
												thái</th>
											<th style="width: 15%; color: black; font-size: 16px;"></th>
										</tr>
									</thead>
									<tbody>
										<%
											int count = 1;
											for (Invoice i : list) {
										%>
										<tr>
											<td style="color: black; font-size: 16px;"><%=count%></td>
											<td style="color: black; font-size: 16px;"><%=i.getNumberInvoice()%></td>
											<%
												DecimalFormat formatter = new DecimalFormat("###,###,###");
											%>
											<%
												java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
											%>
											<td style="color: black; font-size: 16px;"><%=df.format(i.getToday().getTime())%></td>

											<td style="color: black; font-size: 16px;"><%=formatter.format(i.getShop().totalPrice())%></td>
											<%if(i.isProcess() == false){ %>
											<td style="color: red; font-size: 16px;">Chưa xử lí</td>
											<%}else{ %>
											<td style="color: green; font-size: 16px;">Đã xử lí</td>
											<%} %>
											<td style="color: black; font-size: 16px; text-align: center">
												<a
												href="ControllerShopping?action=detailInvoice&id=<%=i.getNumberInvoice()%>"
												style="font-size: 24px;"> <span
													class="fa fa-info-circle"></span>
											</a>
											</td>
										</tr>
										<%
											count++;
											}
										%>
									</tbody>
								</table>

							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
		<!--Plug-in Initialisation-->
	</div>

	<!-- //payment page -->


	<div id="id01" class="modal">
		<form class="modal-content animate"
			onsubmit="return submitForm2(this);"
			action="ControllerShopping?action=userInfoUpdate" method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div>
				<table style="width: 100%;">
					<tr>
						<td><label><b>Tên đăng nhập</b></label></td>
						<td><input type="text" name="userName"
							value="<%=c.getUsername()%>"></td>
					</tr>
					<tr>
						<td><label><b>Tên thực</b></label></td>
						<td><input type="text" name="realName"
							value="<%=c.getFullName()%>"></td>
					</tr>
					<tr>
						<td><label><b>Email</b></label></td>
						<td><input type="text" name="email"
							value="<%=user.getEmail()%>"></td>
					</tr>
					<tr>
						<td><label><b>Số điện thoại</b></label></td>
						<td><input type="text" name="phone" value="<%=c.getPhone()%>"></td>
					</tr>

					<tr>
						<td><label><b>Địa chỉ</b></label></td>
						<td><textarea rows="3" cols="50" name="address"><%=c.getAddress()%></textarea>
						</td>
					</tr>
				</table>
			</div>

			<div style="background-color: #f1f1f1; text-align: center">
				<button type="submit" class="btn btn-success">Cập nhật</button>
				<button class="btn btn-danger"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Cancel</button>

			</div>
		</form>
	</div>
	<!-- goi servlet -->
	<script>
	
		function submitForm2(oFormElement) {
			"use strict";
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
				
				//.text(....)
			}
			xhr.open(oFormElement.method, oFormElement.action, true);
			xhr.send(new FormData(oFormElement));
			return false;
		}
	</script>
	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
	<script>
		var coll = document.getElementsByClassName("collapsible1");
		var i;

		for (i = 0; i < coll.length; i++) {
			coll[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var content = this.nextElementSibling;
				if (content.style.display === "block") {
					content.style.display = "none";
				} else {
					content.style.display = "block";
				}
			});
		}
	</script>


	<!-- easy-responsive-tabs -->
	<link rel="stylesheet" type="text/css"
		href="css/easy-responsive-tabs.css ">
	<script src="js/easyResponsiveTabs.js"></script>

	<script>
		$(document).ready(function() {
			//Horizontal Tab
			$('#parentHorizontalTab').easyResponsiveTabs({
				type : 'default', //Types: default, vertical, accordion
				width : 'auto', //auto or any width like 600px
				fit : true, // 100% fit in a container
				tabidentify : 'hor_1', // The tab groups identifier
				activate : function(event) { // Callback function if tab is switched
					var $tab = $(this);
					var $info = $('#nested-tabInfo');
					var $name = $('span', $info);
					$name.text($tab.text());
					$info.show();
				}
			});
		});
	</script>
	<!-- //easy-responsive-tabs -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').dataTable();
		});
	</script>
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