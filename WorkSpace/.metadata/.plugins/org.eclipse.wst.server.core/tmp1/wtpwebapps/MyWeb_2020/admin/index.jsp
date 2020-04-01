<%@page import="model_user.LoginDAO"%>
<%@page import="model_shoppingcart.InvoiceDB"%>
<%@page import="model_shoppingcart.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>index</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 








</script>

<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/newcss/bootstrap.css"
	rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/newcss/style.css"
	rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="<%=request.getContextPath()%>/newcss/font-awesome.css"
	rel="stylesheet">
<!-- //font-awesome icons CSS-->

<!-- side nav css file -->
<link href='<%=request.getContextPath()%>/newcss/SidebarNav.min.css'
	media='all' rel='stylesheet' type='text/css' />
<!-- //side nav css file -->

<!-- js-->
<script src="<%=request.getContextPath()%>/newjs/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath()%>/newjs/modernizr.custom.js"></script>

<!--webfonts-->
<link
	href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext"
	rel="stylesheet">
<!--//webfonts-->

<!-- Metis Menu -->
<script src="<%=request.getContextPath()%>/newjs/metisMenu.min.js"></script>
<script src="<%=request.getContextPath()%>/newjs/custom.js"></script>
<link href="<%=request.getContextPath()%>/newjs/custom.css"
	rel="stylesheet">
<!--//Metis Menu -->
<style>
#chartdiv {
	width: 100%;
	height: 295px;
}
/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

/* Style the close button */
.topright {
	float: right;
	cursor: pointer;
	font-size: 28px;
}

.topright:hover {
	color: red;
}
</style>

<!-- requried-jsfiles-for owl -->
<link href="<%=request.getContextPath()%>/cssAdmin/owl.carousel.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/jsAdmin/owl.carousel.js"></script>
<script>
	$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			items : 3,
			lazyLoad : true,
			autoPlay : true,
			pagination : true,
			nav : true,
		});
	});
</script>
<!-- //requried-jsfiles-for owl -->
</head>
<body class="cbp-spmenu-push">
	<jsp:include page="/admin/menu.jsp"></jsp:include>
	<!-- main content start-->
	<br>
	<br>
	<br>
	<br>
	<div id="page-wrapper">
		<div class="main-page">
			<div class="col_3">
				<div class="col-md-3 widget widget1">
					<div class="r3_counter_box">
						<i class="pull-left fa fa-dollar icon-rounded"></i>
						<div class="stats">
							<h5>
								<strong>$452</strong>
							</h5>
							<span>Total Revenue</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 widget widget1">
					<div class="r3_counter_box">
						<i class="pull-left fa fa-laptop user1 icon-rounded"></i>
						<div class="stats">
							<h5>
								<strong>$1019</strong>
							</h5>
							<span>Online Revenue</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 widget widget1">
					<div class="r3_counter_box">
						<i class="pull-left fa fa-money user2 icon-rounded"></i>
						<div class="stats">
							<h5>
								<strong>$1012</strong>
							</h5>
							<span>Expenses</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 widget widget1">
					<div class="r3_counter_box">
						<i class="pull-left fa fa-pie-chart dollar1 icon-rounded"></i>
						<div class="stats">
							<h5>
								<strong>$450</strong>
							</h5>
							<span>Expenditure</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 widget">
					<div class="r3_counter_box">
						<i class="pull-left fa fa-users dollar2 icon-rounded"></i>
						<div class="stats">
							<h5>
								<strong><%=new LoginDAO().countUser() %></strong>
							</h5>
							<span>Total Users</span>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>

			<div style="margin-left: 5%; width: 95%;">
				<div class="row-one widgettable">
					<div class="col-md-11 content-top-2 card">
						<div class="agileinfo-cdr">
							<div class="tab">
								<button class="tablinks" onclick="openCity(event, 'London')"
									id="defaultOpen">Gửi mail cho tất cả khách hàng</button>
								<button class="tablinks" onclick="openCity(event, 'Paris')">Gửi
									mail cho cá nhân</button>

							</div>

							<div id="London" class="tabcontent">
								<span onclick="this.parentElement.style.display='none'"
									class="topright">&times</span>

								<form>
									<table>
										<tr style="background: none;">
											<td style="border: none; font-size: 17px">Tiêu đề <label
												style="color: red">*</label></td>
											<td style="border: none"><input style="width: 100%"
												required="required"></td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td></td>
										</tr>
										<tr style="background: none;; margin-top: 10px">
											<td style="border: none; font-size: 17px; margin-top: 10px">Nội
												dung <label style="color: red">*</label>
											</td>
											<td style="border: none; margin-top: 10px"><textarea
													rows="5" cols="50" style="width: 100%;"></textarea></td>
										</tr>
										<tr style="background: none;">
											<td style="border: none; font-size: 17px">Tệp đính kèm</td>
											<td style="border: none; font-size: 17px"><input
												style="width: 100%" type="file"></td>
										</tr>
										<tr style="background: none;">
											<td
												style="border: none; font-size: 17px; text-align: right; margin-right: 0px;"
												colspan="2"><input type="submit" value="Cập nhật"
												style="background: #34B67A; color: white; border: none; padding: 8px 40px"></td>
										</tr>
									</table>
								</form>
							</div>
							<div id="Paris" class="tabcontent">
								<span onclick="this.parentElement.style.display='none'"
									class="topright">&times</span>
								<form>
									<table>
										<tr style="background: none;">
											<td style="border: none; font-size: 17px">Người nhận<label
												style="color: red">*</label></td>
											<td style="border: none"><input style="width: 100%"
												required="required"></td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td></td>
										</tr>
										<tr style="background: none;">
											<td style="border: none; font-size: 17px">Tiêu đề <label
												style="color: red">*</label></td>
											<td style="border: none"><input style="width: 100%"
												required="required"></td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td></td>
										</tr>
										<tr style="background: none;; margin-top: 10px">
											<td style="border: none; font-size: 17px; margin-top: 10px">Nội
												dung <label style="color: red">*</label>
											</td>
											<td style="border: none; margin-top: 10px"><textarea
													rows="5" cols="50" style="width: 100%;"></textarea></td>
										</tr>
										<tr style="background: none;">
											<td style="border: none; font-size: 17px">Tệp đính kèm</td>
											<td style="border: none; font-size: 17px"><input
												style="width: 100%" type="file"></td>
										</tr>
										<tr style="background: none;">
											<td
												style="border: none; font-size: 17px; text-align: right; margin-right: 0px;"
												colspan="2"><input type="submit" value="Cập nhật"
												style="background: #34B67A; color: white; border: none; padding: 8px 40px"></td>
										</tr>
									</table>
								</form>

							</div>
						</div>
					</div>

				</div>


			</div>
		</div>
	</div>
	<!-- footeer -->
	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>

	<!-- Classie -->
	<!-- Thu gon menu -->
	<script src="<%=request.getContextPath()%>/newjs/classie.js"></script>
	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1'), showLeftPush = document
				.getElementById('showLeftPush'), body = document.body;

		showLeftPush.onclick = function() {
			classie.toggle(this, 'active');
			classie.toggle(body, 'cbp-spmenu-push-toright');
			classie.toggle(menuLeft, 'cbp-spmenu-open');
			disableOther('showLeftPush');
		};

		function disableOther(button) {
			if (button !== 'showLeftPush') {
				classie.toggle(showLeftPush, 'disabled');
			}
		}
	</script>
	<!-- //Classie -->
	<!-- //thu gon menu -->
	<!-- side nav js -->
	<script src='<%=request.getContextPath()%>/newjs/SidebarNav.min.js'
		type='text/javascript'></script>
	<script>
		$('.sidebar-menu').SidebarNav()
	</script>
	<!-- //side nav js -->

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/newjs/bootstrap.js">
		
	</script>
	<!-- //Bootstrap Core JavaScript -->
</body>
</html>