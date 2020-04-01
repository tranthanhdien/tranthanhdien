<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<!-- //Stylesheet -->
<title>lab 4</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/menu.css" />

<link href="css/style1.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="keywords"
	content="Directory Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- Custom Theme files -->
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- timeline -->
<link href="css/timeline.css" type="text/css" rel="stylesheet"
	media="all">
<!-- font-awesome icons -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!-- //Custom Theme files -->
<!-- online-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Libre+Franklin:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<style>
.topnav {
	overflow: hidden;
	background-color: #4267b2;
}

h1 {
	color: black;
}

.book-agileinfo-form input[type="text"], .book-agileinfo-form input[type="email"],
	.book-agileinfo-form input[type="password"], select#country, select#country1,
	input#datepicker, .book-agileinfo-form input[type="submit"],
	.book-agileinfo-form input[type="reset"] {
	width: 100%;
	border-radius: 10px;
	font-family: 'Libre Franklin', sans-serif;
	font-size: 16px;
}
/* inner banner */
.inner-banner-w3ls {
	background: url('images/bg.jpg') no-repeat center;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	-ms-background-size: cover;
	background-size: cover;
	min-height: 150px;
	border-bottom: 3px solid #00d255;
}

/* Style the tab */
.tab1 {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab1 button {
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
.tab1 button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab1 button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent1 {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

/* Style the close button */
.topright1 {
	float: right;
	cursor: pointer;
	font-size: 28px;
}

.topright1:hover {
	color: red;
}

/*tab 2 */
/* Style the tab */
.tab2 {
	overflow: hidden;
	border-bottom: 1px solid #ccc;
	background-color: white;
}

/* Style the buttons inside the tab */
.tab2 button {
	background-color: inherit;
	float: left;
	border-left: 1px solid;
	outline: none;
	cursor: pointer;
	padding: 7px 8px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab2 button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab2 button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent2 {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

/* Style the close button */
.topright2 {
	float: right;
	cursor: pointer;
	font-size: 28px;
}

.topright2:hover {
	color: red;
}
</style>
</head>
<body>
	<div class="tab1">
		<button class="tablinks" onclick="openCity(event, 'London')"
			id="defaultOpen">Requirement</button>
		<button class="tablinks" onclick="openCity(event, 'Paris')">Implementation</button>

	</div>

	<div id="London" class="tabcontent1">
		<span onclick="this.parentElement.style.display='none'"
			class="topright1">&times</span> <img alt=""
			src="images/requirement4.JPG">

	</div>

	<div id="Paris" class="tabcontent1">
		<span onclick="this.parentElement.style.display='none'"
			class="topright1">&times</span>
		<div class="tab2">
			<button class="tablinks2"
				style="border-bottom: none; border-left: none; border-right: none; border-top: none;">
				Chế độ xem:</button>
			<button class="tablinks2" onclick="openCity2(event, 'London2')"
				id="defaultOpen2">
				<i class="fa fa-list" style="font-size: 18px;"></i>Dạng danh sách
			</button>
			<button class="tablinks2" onclick="openCity2(event, 'Paris2')">
				<i class="fa fa-table" style="font-size: 18px;"></i>Dạng hộp (box)
			</button>
		</div>
		<div id="London2" class="tabcontent2">
			<span onclick="this.parentElement.style.display='none'"
				class="topright2">&times</span>
			<iframe src="list.jsp" style="width: 100%; height: 900px"></iframe>

		</div>
		<!-- //xem dang list -->

		<!-- xem bang box -->
		<div id="Paris2" class="tabcontent2">
			<span onclick="this.parentElement.style.display='none'"
				class="topright2">&times</span>

			<iframe src="box.jsp" style="width: 100%; height: 900px"></iframe>
		</div>
		<!-- xem dang box -->
	</div>
	<br>
	<br>

	<script>
		function openCity2(evt, cityName) {
			var i, tabcontent2, tablinks2;
			tabcontent2 = document.getElementsByClassName("tabcontent2");
			for (i = 0; i < tabcontent2.length; i++) {
				tabcontent2[i].style.display = "none";
			}
			tablinks2 = document.getElementsByClassName("tablinks2");
			for (i = 0; i < tablinks2.length; i++) {
				tablinks2[i].className = tablinks2[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen2").click();
	</script>

	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent1");
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


	<!-- smooth-scrolling-of-move-up -->
	<script src="js/jquery-2.2.3.min.js"></script>


	<!-- //js -->
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
	<script src="js/SmoothScroll.min.js"></script>
	<!-- //smooth-scrolling-of-move-up -->
	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>