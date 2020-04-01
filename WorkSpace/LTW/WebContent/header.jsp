<%@page import="model.Cart"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<%
		CategoryDAO cateDAO = new CategoryDAO();
	
		Cart cart = (Cart) session.getAttribute("cart");
	%>

	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="header-top-in">
					<div class="logo">
						<a href="index.jsp"><img src="images/logo.png" alt=" "></a>
					</div>
					<div class="header-in">
						<ul class="icon1 sub-icon1">
							<li><a href="wishlist.html">WISH LIST (0)</a></li>
							<li><a href="account.html"> MY ACCOUNT</a></li>
							<li><a href="#"> SHOPPING CART</a></li>
							<li><a href="checkout.html">CHECKOUT</a></li>
							<li><div class="cart">
									<a href="#" class="cart-in"> </a> <span> <%=cart.countItem() %></span>
								</div>
								<ul class="sub-icon1 list">
									<h3>Recently added items(2)</h3>
									<div class="shopping_cart">
										<div class="cart_box">
											<div class="message">
												<div class="alert-close"></div>
												<div class="list_img">
													<img src="images/14.jpg" class="img-responsive" alt="">
												</div>
												<div class="list_desc">
													<h4>
														<a href="#">velit esse molestie</a>
													</h4>
													1 x<span class="actual"> $12.00</span>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
										<div class="cart_box1">
											<div class="message1">
												<div class="alert-close1"></div>
												<div class="list_img">
													<img src="images/15.jpg" class="img-responsive" alt="">
												</div>
												<div class="list_desc">
													<h4>
														<a href="#">velit esse molestie</a>
													</h4>
													1 x<span class="actual"> $12.00</span>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
									<div class="total">
										<div class="total_left">CartSubtotal :</div>
										<div class="total_right">$250.00</div>
										<div class="clearfix"></div>
									</div>
									<div class="login_buttons">
										<div class="check_button">
											<a href="checkout.html">Check out</a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</ul></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="container">
				<div class="h_menu4">
					<a class="toggleMenu" href="#">Menu</a>
					<ul class="nav">
						<li class="active"><a href="index.jsp"><i> </i>Trang chủ</a></li>
						<li><a href="#">Đèn LED dân dụng</a>
							<ul class="drop">
								<%
									for (Category cate : cateDAO.getListCategory()) {
								%>
								<li><a
									href="product.jsp?category=<%=cate.getCategoryID()%>"><%=cate.getCategoryName()%></a></li>

								<%
									}
								%>

							</ul></li>
						<li><a href="products.html"> Đèn LED văn phòng</a></li>
						<li><a href="products.html">Components</a></li>
						<li><a href="products.html">Software</a></li>
						<li><a href="products.html">Phones & PDAs </a></li>
						<li><a href="products.html"> Cameras </a></li>
						<li><a href="contact.jsp">Contact </a></li>

					</ul>
					<script type="text/javascript" src="js/nav.js"></script>
				</div>
			</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
				<div class="header-bottom-on">
					<p class="wel">
						<a href="#">Chào mừng bạn đến với Website của chúng tôi.</a>
					</p>
					<div class="header-can">
						<ul class="social-in">
							<li><a href="#"><i> </i></a></li>
							<li><a href="#"><i class="facebook"> </i></a></li>
							<li><a href="#"><i class="twitter"> </i></a></li>
							<li><a href="#"><i class="skype"> </i></a></li>
						</ul>
						<div class="down-top">
							<select class="in-drop">
								<option value="Dollars" class="in-of">Dollars</option>
								<option value="Euro" class="in-of">Euro</option>
								<option value="Yen" class="in-of">Yen</option>
							</select>
						</div>
						<div class="search">
							<form>
								<input type="text" value="Search" onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = '';}"> <input
									type="submit" value="">
							</form>
						</div>

						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>