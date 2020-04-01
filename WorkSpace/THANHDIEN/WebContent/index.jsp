<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Trần Thanh Điền</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/animate.min.css">
<!-- Google Fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<header class="navbar-fixed-top">
		<div class="container">
			<div class="row">
				<div class="header_top">
					<div class="col-md-2">
						<div class="logo_img">
							<a href="#"><img src="images/logo.png" alt="logoimage"></a>
						</div>
					</div>

					<div class="col-md-10">
						<div class="menu_bar">
							<nav role="navigation" class="navbar navbar-default">
								<div class="navbar-header">
									<button id="menu_slide" aria-controls="navbar"
										aria-expanded="false" data-toggle="collapse"
										class="navbar-toggle collapsed" type="button">
										<span class="sr-only">Toggle navigation</span> <span
											class="icon-bar"></span> <span class="icon-bar"></span> <span
											class="icon-bar"></span>
									</button>
								</div>

								<div class="collapse navbar-collapse" id="navbar">

									<ul class="nav navbar-nav">
										<li><a href="#index.jsp" class="js-target-scroll">Home</a></li>


										<li class="dropdown"><a href="#" data-toggle="dropdown">
												Exercises <i class="fa fa-caret-down"></i>
										</a>
											<ul class="dropdown-menu">
												<li><a href="lab1.jsp">Excercise 1</a></li>
												<li><a href="lab2.jsp">Excercise 2</a></li>
												<li><a href="lab3.jsp">Excercise 3</a></li>
												<li><a href="lab4.jsp">Excercise 4</a></li>
												<li><a href="lab5.jsp">Excercise 5</a></li>
												<li><a href="lab6.jsp">Excercise 6</a></li>
											</ul></li>
										<li><a href="about.jsp" class="js-target-scroll">About</a></li>
										<li><a href="contact.jsp" class="js-target-scroll">Contact</a></li>
										<li><a href="https://dien98.azurewebsites.net/" class="js-target-scroll">Midterm</a></li>
									</ul>
								</div>

							</nav>
						</div>
					</div>

				</div>
			</div>
		</div>
	</header>

	<section id="home" class="top_banner_bg secondary-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="top_banner"></div>

					<div class="col-md-6">
						<div class="present">
							<h1>Welcome to my website</h1>

							<h5>
								Available on <span> Login </span> and <b> Register</b>
							</h5>

							<div class="section_btn">
								<a href="loginfacebook.jsp">
									<button class="btn btn-default" type="submit">
										<i class="fa fa-apple" aria-hidden="true"></i> Login
									</button>
								</a> <span> <a href="#">
										<button class="btn btn-default" type="submit">
											<i class="fa fa-android" aria-hidden="true"></i> Register
										</button>
								</a>
								</span>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="present_img">
							<img src="images/image-1.png" alt="image">
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>

	<section id="team" class="primary-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<div class="section_heading">
						<h2>Team Members</h2>

						<h4>We're the best professionals in this. Here goes some
							simple dummy text. Lorem Ipsum is simply dummy text</h4>
					</div>

					<div class="col-md-3">
						<div class="member_detail">
							<div class="member_img">
								<img src="images/services_img1.jpg" alt="image">
							</div>
							<div class="member_name">
								<h5>John Capone</h5>
								<p>Web Art Director</p>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="member_detail">
							<div class="member_img">
								<img src="images/services_img1.jpg" alt="image">
							</div>
							<div class="member_name">
								<h5>Marlon Leend</h5>
								<p>Head Phographer</p>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="member_detail">
							<div class="member_img">
								<img src="images/services_img1.jpg" alt="image">
							</div>
							<div class="member_name">
								<h5>Robert Son</h5>
								<p>Marketing Director</p>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="member_detail">
							<div class="member_img">
								<img src="images/services_img1.jpg" alt="image">
							</div>
							<div class="member_name">
								<h5>John Capone</h5>
								<p>Web Art Director</p>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>

	<section id="contact" class="contact_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section_heading section_heading_2">
						<h2>Contact Us</h2>

						<h4>Let drop a line to us & we will be in touch soon. Here
							goes some simple dummy text. Lorem Ipsum is simply dummy text</h4>
					</div>

					<div class="col-md-6">
						<div class="contact_form">
							<form>
								<div class="form-group">
									<label>Full Name : <span> *</span></label> <input type="email"
										class="form-control" id="exampleInputEmail1">
								</div>

								<div class="form-group">
									<label>Email Address : <span> *</span></label> <input
										type="text" class="form-control" id="exampleInputPassword1">
								</div>

								<div class="form-group">
									<label>Message <span> *</span></label>
									<textarea class="form-textarea" rows="3"></textarea>
								</div>

								<div class="section_sub_btn">
									<button class="btn btn-default" type="submit">Send
										Message</button>
								</div>
							</form>
						</div>
					</div>

					<div class="col-md-6">
						<div class="contact_text">
							<ul>
								<li><span><i class="fa fa-home" aria-hidden="true"></i></span>
									<h5>29 Street, Trung Nghĩa, Nghĩa Thành, Châu Đức, BR-VT</h5></li>

								<li><span><i class="fa fa-envelope-o"
										aria-hidden="true"></i></span>
									<h5>thanhdien25598@gmail.com</h5></li>

								<li><span><i class="fa fa-phone" aria-hidden="true"></i></span>
									<h5>(03) 5735 2255</h5></li>

								<li><span><i class="fa fa-fax" aria-hidden="true"></i></span>
									<h5>(03) 8465 1970</h5></li>
							</ul>

						</div>
					</div>


				</div>
			</div>
		</div>
	</section>

	<footer class="third-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<div class="footer_top">
						<h4>Share Your Favorite Mobile Apps With Your Friends</h4>

						<ul>
							<li><a href="#"> <i
									class="fa fa-facebook" aria-hidden="true"></i>
							</a></li>
							<li><a href="#"> <i
									class="fa fa-twitter" aria-hidden="true"></i>
							</a></li>
							<li><a href="#"> <i
									class="fa fa-linkedin" aria-hidden="true"></i>
							</a></li>
							<li><a href="#"> <i
									class="fa fa-google-plus" aria-hidden="true"></i>
							</a></li>
							<li><a href="#"> <i
									class="fa fa-youtube-square" aria-hidden="true"></i>
							</a></li>
							<li><a href="#"> <i
									class="fa fa-instagram" aria-hidden="true"></i>
							</a></li>
						</ul>
					</div>




				</div>
			</div>
		</div>

		<div class="footer_bottom fourth-bg">
			<!-- Keep Footer Credit Links Intact -->
			<p>
				2018 &copy; Copyright Applayers. All rights Reserved. Powered By
				Free <a href="http://www.pfind.com/goodies/applayers/">AppLayers</a>
				Template from <a href="http://www.pfind.com/goodies/">pFind
					Goodies</a>.
			</p>
			<a href="#" class="backtop"> ^ </a>
		</div>

	</footer>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/interface.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#menu_slide").click(function() {
				$("#navbar").slideToggle('normal');
			});
		});
	</script>
	<!--Menu Js Right Menu-->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#navbar > ul > li:has(ul)').addClass("has-sub");
			$('#navbar > ul > li > a').click(function() {
				var checkElement = $(this).next();
				$('#navbar li').removeClass('dropdown');
				$(this).closest('li').addClass('dropdown');
				if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
					$(this).closest('li').removeClass('dropdown');
					checkElement.slideUp('normal');
				}
				if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
					$('#navbar ul ul:visible').slideUp('normal');
					checkElement.slideDown('normal');
				}
				if (checkElement.is('ul')) {
					return false;
				} else {
					return true;
				}
			});
		});
		<!--end-->
	</script>
	<script type="text/javascript">
		$("#navbar").on("click", function(event) {
			event.stopPropagation();
		});
		$(".dropdown-menu").on("click", function(event) {
			event.stopPropagation();
		});
		$(document).on("click", function(event) {
			$(".dropdown-menu").slideUp('normal');
		});

		$(".navbar-header").on("click", function(event) {
			event.stopPropagation();
		});
		$(document).on("click", function(event) {
			$("#navbar").slideUp('normal');
		});
	</script>

</body>
</html>
