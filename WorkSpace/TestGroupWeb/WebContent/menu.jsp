
<%@page import="modelMenu.MenuDAO"%>
<%@page import="modelMenu.Menu"%>
<%@page import="modelCuHang.DanhSachCuaHangDAO"%>
<%@page import="modelCuHang.CuaHang"%>
<%@page import="model_product.ShoppingCart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>menu động</title>
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
<style type="text/css">
</style>
</head>
<body>
	<%
		ShoppingCart shop = (ShoppingCart) session.getAttribute("customer");
	%>
	<!-- top-header -->
	<div class="header-most-top">
		<p>Hệ thống phân phối sỉ và lẻ thiết bị chiếu sáng</p>
	</div>
	<!-- //top-header -->
	<!-- header-bot-->
	<div class="header-bot">
		<div class="header-bot_inner_wthreeinfo_header_mid">
			<!-- header-bot-->
			<div class="col-md-4 logo_agile">
				<h1>
					<a href="index.html"> <span>L</span>ighting <span>S</span>hopping
						<img src="images/logo2.png" alt=" ">
					</a>
				</h1>
			</div>
			<!-- header-bot -->
			<div class="col-md-8 header">
				<!-- header lists -->
				<ul>
					<li><a class="play-icon popup-with-zoom-anim"
						href="#small-dialog1"> <span class="fa fa-map-marker"
							aria-hidden="true"></span> Shop Locator
					</a></li>
					<li><a href="contact.jsp"> <span class="fa fa-truck"
							aria-hidden="true"></span>Liên hệ
					</a></li>
					<li><span class="fa fa-phone" aria-hidden="true"></span> 034
						9146 791</li>
					<%
						if (shop == null) {
					%>
					<li><a href="login.jsp"> <span class="fa fa-unlock-alt"
							aria-hidden="true"></span> Đăng nhập
					</a></li>
					<li><a href="register.jsp"> <span
							class="fa fa-pencil-square-o" aria-hidden="true"></span> Đăng kí
					</a></li>
					<%
						} else {
					%>
					<li><a href="#"><span class="fa fa-user"
							aria-hidden="true"></span><%=shop.getCustomer().getUsername()%> </a></li>
					<li><a href="ControllerShopping?action=logout"> <span
							class="fa fa-sign-out" aria-hidden="true"></span>Logout
					</a></li>
					<%
						}
					%>


				</ul>
				<!-- //header lists -->
				<!-- search -->
				<div class="agileits_search">
					<form action="#" method="post">
						<input name="Search" type="search"
							placeholder="Nhập thông tin cần tìm kiếm..." required="">
						<button type="submit" class="btn btn-default"
							aria-label="Left Align">
							<span class="fa fa-search" aria-hidden="true"> </span>
						</button>
					</form>
				</div>
				<!-- //search -->
				<!-- cart details -->
				<div class="top_nav_right">
					<div class="wthreecartaits wthreecartaits2 cart cart box_1">
						<form action="#" method="post" class="last">
							<input type="hidden" name="cmd" value="_cart"> <input
								type="hidden" name="display" value="1">
							<button class="w3view-cart" type="submit" name="submit" value="">
								<i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
							</button>
						</form>
					</div>
				</div>
				<!-- //cart details -->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- shop locator (popup) -->
	<!-- Button trigger modal(shop-locator) -->
	<div id="small-dialog1" class="mfp-hide">
		<div class="select-city">
			<h3>Please Select Your Location</h3>
			<select class="list_of_cities">
				<optgroup label="Thành Phố Hồ Chí Minh">
					<option selected style="display: none; color: #eee;">Select
						City</option>
					<%
						for (CuaHang c : DanhSachCuaHangDAO.getListCH("TP.HCM")) {
					%>
					<option><%=c.getName()%></option>
					<%
						}
					%>

				</optgroup>

				<optgroup label="Long An">
					<%
						for (CuaHang c : DanhSachCuaHangDAO.getListCH("Long An")) {
					%>
					<option><%=c.getName()%></option>
					<%
						}
					%>

				</optgroup>

			</select>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //shop locator (popup) -->
	<!-- signin Model -->
	<!-- Modal1 -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body modal-body-sub_agile">
					<div class="main-mailposi">
						<span class="fa fa-envelope-o" aria-hidden="true"></span>
					</div>
					<div class="modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">Sign In</h3>
						<p>
							Sign In now, Let's start your Grocery Shopping. Don't have an
							account? <a href="#" data-toggle="modal" data-target="#myModal2">
								Sign Up Now</a>
						</p>
						<form action="#" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="text" placeholder="User Name" name="Name"
									required="">
							</div>
							<div class="styled-input">
								<input type="password" placeholder="Password" name="password"
									required="">
							</div>
							<input type="submit" value="Sign In">
						</form>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
	<!-- //Modal1 -->
	<!-- //signin Model -->
	<!-- signup Model -->
	<!-- Modal2 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body modal-body-sub_agile">
					<div class="main-mailposi">
						<span class="fa fa-envelope-o" aria-hidden="true"></span>
					</div>
					<div class="modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">Sign Up</h3>
						<p>Come join the Grocery Shoppy! Let's set up your Account.</p>
						<form action="#" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="text" placeholder="Name" name="Name" required="">
							</div>
							<div class="styled-input">
								<input type="email" placeholder="E-mail" name="Email"
									required="">
							</div>
							<div class="styled-input">
								<input type="password" placeholder="Password" name="password"
									id="password1" required="">
							</div>
							<div class="styled-input">
								<input type="password" placeholder="Confirm Password"
									name="Confirm Password" id="password2" required="">
							</div>
							<input type="submit" value="Sign Up">
						</form>
						<p>
							<a href="#">By clicking register, I agree to your terms</a>
						</p>
					</div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
	<!-- //Modal2 -->
	<!-- //signup Model -->
	<!-- //header-bot -->
	<!-- navigation -->

	<%
		ArrayList<Menu> lisMenu = MenuDAO.getListMenu();
	%>

	<div class="ban-top">
		<div class="container">
			<div class="agileits-navi_search" style="margin-left: -100px;">
				<form action="#" method="post">
					<select id="agileinfo-nav_search" name="agileinfo_search"
						required="">
						<option value="all">All</option>
						<option value="bongLed">Bóng LED</option>
						<option value="bongLed">Đèn âm trần</option>
						<option value="bongLed">Đèn LED ốp trần</option>
						<option value="bongLed">LED treo thả</option>
						<option value="bongLed">Đèn pha LED</option>
						<option value="bongLed">Đèn đường LED</option>
						<option value="bongLed">Đèn đường LED</option>
						<option value="bongLed">Đèn LED sân vườn</option>

					</select>
				</form>
			</div>
			<div class="top_nav_left">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1"
								aria-expanded="false">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->


						<!-- chay for de lay menu -->
						<div class="collapse navbar-collapse menu--shylock"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav menu__list" style="margin-top: -5%;">

								<%
									for (Menu m : lisMenu) {
										if (m.isDropdown() == false) {
								%>
								<li class=""><a class="nav-stylehead"
									href="<%=m.getLink()%>"><%=m.getName()%></a></li>
								<%
									} else if (m.isDropdown() == true) {
								%>


								<li class="dropdown"><a href="<%=m.getLink()%>"
									class="dropdown-toggle nav-stylehead" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false"><%=m.getName()%>
										<span class="caret"></span> </a>
									<ul class="dropdown-menu agile_short_dropdown">



										<%
											for (Menu sub : m.getListSubMenu()) {
										%>

										<li><a href="<%=sub.getLink()%>"><%=sub.getName()%></a></li>
										<%
											}
										%>

									</ul></li>


								<%
									}
									}
								%>

							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- //navigation -->



	<!-- js-files -->

	<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
	<!-- //for bootstrap working -->
	<!-- //js-files -->
</body>
</html>