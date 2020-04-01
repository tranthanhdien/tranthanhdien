
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="model_user.CustomerDAO"%>
<%@page import="model_user.LoginDAO"%>
<%@page import="model_user.Login"%>
<%@page import="model_user.Customer"%>
<%@page import="model_shoppingcart.ItemCart"%>
<%@page import="model_shoppingcart.ShoppingCart"%>
<%@page import="modelMenu.MenuDAO"%>
<%@page import="modelMenu.Menu"%>
<%@page import="modelCuHang.DanhSachCuaHangDAO"%>
<%@page import="modelCuHang.CuaHang"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>menu động</title>
<style>
.cart span {
	background: #f8390d;
	border-radius: 100px;
	color: #fff;
	font-size: 1em;
	width: 30px;
	height: 30px;
	display: block;
	top: 35px;
	right: 60px;
	position: absolute;
	text-align: center;
	border: 1px solid #E73737;
	padding: 2px 0 0;
}
</style>

</head>
<body>
	<%
		//binh thuong thi lay ngon ngu la VN
		Locale.setDefault(new Locale("vn", "VN"));
		ResourceBundle resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");

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
	<%
		Login user = (Login) session.getAttribute("user");
	%>
	<!-- top-header -->
	<div class="header-most-top">
		<p><%=resourcebundle.getString("titleIndex") %></p>
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
					<li><form method="post"
							action="ControllerShopping?action=languageVN"
							onsubmit="return submitForm2(this);">
							<input type="submit" name="submit" value="Việt Nam"
								class="button"
								style="background: none; border: none; font-size: 15px" />
						</form></li>
					<li>

						<form method="post" action="ControllerShopping?action=languageEN"
							onsubmit="return submitForm2(this);">
							<input type="submit" name="submit" value="English" class="button"
								style="background: none; border: none; font-size: 15px" />
						</form>
					</li>
					<%
						if (user == null) {
					%>
					<li><a href="ControllerShopping?action=checkUser"> <span
							class="fa fa-unlock-alt" aria-hidden="true"></span> <%=resourcebundle.getString("login")%>
					</a></li>
					<li><a href="register.jsp"> <span
							class="fa fa-pencil-square-o" aria-hidden="true"></span> <%=resourcebundle.getString("signin")%>
					</a></li>
					<%
						} else {
					%>


					<%
						if (new LoginDAO().findAdminByIDLogin(user.getIdUser()) == true) {
					%>
					<li><a href="ControllerAdmin?action=hasAdmin"><%=resourcebundle.getString("admin") %></a></li>
					<%
						} else {
					%>
					<li><a href="#">0357352255</a></li>
					<%
						}
					%>

					<li><a href="userinfo.jsp"><span class="fa fa-user"
							aria-hidden="true"></span><%=new CustomerDAO().mappingUserName(user.getIdUser())%></a></li>
					<li><a href="ControllerShopping?action=logout"> <span
							class="fa fa-sign-out" aria-hidden="true"></span><%=resourcebundle.getString("logout") %>
					</a></li>
					<%
						}
					%>


				</ul>
				<!-- //header lists -->
				<!-- search -->
				<div class="agileits_search">
					<form action="ControllerShopping?action=search" method="post">
						<input name="Search" type="search"
							placeholder="<%=resourcebundle.getString("inputSearch") %>"
							value="${searchTitle }" required="">
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
								type="hidden" name="display" value="1"> <a
								href="GioHang.jsp">
								<button class="w3view-cart" type="submit" name="submit" value="">
									<i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
								</button>
							</a>
							<div class="cart">
								<%
									if (session.getAttribute("numbercart") == null) {
								%>
								<a href="GioHang.jsp" class="cart-in"> <span id="resultcart">0</span>
								</a>
								<%
									} else {
								%>
								<a href="GioHang.jsp" class="cart-in"> <span id="resultcart">${sessionScope.numbercart }</span>
								</a>
								<%
									}
								%>
							</div>
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
				<form action="ControllerShopping?action=menu" method="post">
					<select id="agileinfo-nav_search" onchange="this.form.submit()"
						name="value">
						<!-- dua den servlet cho nay de loc san pham theo nhom -->
						<%
							ArrayList<String> listMenuSub = new MenuDAO().getListSub();
						%>
						<option value="${groupProduct }">${groupProduct}</option>
						<%
							for (String m : listMenuSub) {
						%>
						<option value="<%=m%>"><%=m%></option>
						<%
							}
						%>

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

	<script>
		"use strict";
		function submitForm2(oFormElement) {
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
</body>
</html>