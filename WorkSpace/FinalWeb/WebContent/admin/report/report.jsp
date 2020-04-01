<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>report</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	

	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<script type="text/javascript">

window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "Thống kê sản phẩm bán ra năm 2018",
		fontSize: 18,
	},
	axisY: {
		title: "sản phẩm",
		fontSize:12,
	},
	
	data: [{        
		type: "column",  
		showInLegend: false,
		
		dataPoints: [      
			{ y: 50, label: "tháng 1" },
			{ y: 80,  label: "tháng 2" },
			{ y: 135,  label: "tháng 3" },
			{ y: 62,  label: "tháng 4" },
			{ y: 114,  label: "tháng 5" },
			{ y: 130, label: "tháng 6" },
			{ y: 149,  label: "tháng 7" },
			{ y: 170,  label: "tháng 8" },
			{ y: 69,  label: "tháng 9" },
			{ y: 99,  label: "tháng 10" },
			{ y: 120,  label: "tháng 11" },
			{ y: 156,  label: "tháng 12" }
		]
	}]
});
chart.render();
var chart = new CanvasJS.Chart("chartContainer1", {
	animationEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "Thống kê sản phẩm bán ra năm 2015",
		fontSize: 18,
	},
	axisY: {
		title: "sản phẩm",
		fontSize:12,
	},
	
	data: [{        
		type: "column",  
		showInLegend: false,
		
		dataPoints: [      
			{ y: 96, label: "tháng 1" },
			{ y: 156,  label: "tháng 2" },
			{ y: 69,  label: "tháng 3" },
			{ y: 89,  label: "tháng 4" },
			{ y: 126,  label: "tháng 5" },
			{ y: 200, label: "tháng 6" },
			{ y: 169,  label: "tháng 7" },
			{ y: 175,  label: "tháng 8" },
			{ y: 132,  label: "tháng 9" },
			{ y: 94,  label: "tháng 10" },
			{ y: 156,  label: "tháng 11" },
			{ y: 210,  label: "tháng 12" }
		]
	}]
});
chart.render();
var chart = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "Thống kê sản phẩm bán ra năm 2016",
		fontSize: 18,
	},
	axisY: {
		title: "sản phẩm",
		fontSize:12,
	},
	
	data: [{        
		type: "column",  
		showInLegend: false,
		
		dataPoints: [      
			{ y: 79, label: "tháng 1" },
			{ y: 125,  label: "tháng 2" },
			{ y: 96,  label: "tháng 3" },
			{ y: 188,  label: "tháng 4" },
			{ y: 165,  label: "tháng 5" },
			{ y: 200, label: "tháng 6" },
			{ y: 189,  label: "tháng 7" },
			{ y: 140,  label: "tháng 8" },
			{ y: 70,  label: "tháng 9" },
			{ y: 163,  label: "tháng 10" },
			{ y: 200,  label: "tháng 11" },
			{ y: 100,  label: "tháng 12" }
		]
	}]
});
chart.render();
var chart = new CanvasJS.Chart("chartContainer3", {
	animationEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "Thống kê sản phẩm bán ra năm 2017",
		fontSize: 18,
	},
	axisY: {
		title: "sản phẩm",
		fontSize:12,
	},
	
	data: [{        
		type: "column",  
		showInLegend: false,
		
		dataPoints: [      
			{ y: 100, label: "tháng 1" },
			{ y: 120,  label: "tháng 2" },
			{ y: 165,  label: "tháng 3" },
			{ y: 112,  label: "tháng 4" },
			{ y: 174,  label: "tháng 5" },
			{ y: 250, label: "tháng 6" },
			{ y: 189,  label: "tháng 7" },
			{ y: 160,  label: "tháng 8" },
			{ y: 150,  label: "tháng 9" },
			{ y: 242,  label: "tháng 10" },
			{ y: 260,  label: "tháng 11" },
			{ y: 210,  label: "tháng 12" }
		]
	}]
});
chart.render();

}

</script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/newcss/bootstrap.css"
	rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/newcss/bootstrap.min.css"
	rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/newcss/style.css"
	rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/newcss/reports.css"
	rel="stylesheet">
<!-- font-awesome icons CSS -->
<link href="<%=request.getContextPath()%>/newcss/font-awesome.css"
	rel="stylesheet">
<!-- //font-awesome icons CSS-->

<!-- side nav css file -->
<link href='<%=request.getContextPath()%>/newcss/SidebarNav.min.css'
	media='all' rel='stylesheet' type='text/css' />
<!-- //side nav css file -->

<!-- js-->
<script src="<%=request.getContextPath()%>/newjs/jquery-3.2.1.min.js"></script>
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
@charset "UTF-8";

/**/


.mainSVG {
	position: absolute;
	width: 100%;
	height: 500px;
	visibility: hidden;
	/*  top:200px; */
	left: 50%;
	transform: translate(-50%, 0%);
	overflow: visible;
}

#boxLabel {
	text-anchor: middle;
	fill: #115F9A;
	font-size: 21px;
	user-select: none;
	-webkit-user-select: none;
	pointer-events: none;
	font-family: 'Roboto', sans-serif;
	font-weight: 700;
}

.box {
	opacity: 0;
}

circle {
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}


/**/
.wrapper {
	background: #152B39;
	display: block;
	border: 1px solid #555;
	width: 900px;
	height: 450px;
	position: relative;
}

p {
	text-align: center;
}

.label {
	height: 1em;
	padding: 1em;
	line-height: 0.4em;
	background: rgba(255, 255, 255, .8);
	position: absolute;
	display: none;
	color: #333;
	font-size: 14px;
}

#containers {
	width: 900px;
	height: 450px;
}
#containers1,#containers2,#containers3{
	width: 850px;
	height: 450px;
}

.modal svg .highcharts-exporting-group{
	display: none;
}
.highcharts-title tspan{
	font-weight: 700;
	font-size:18px;
}
.modal svg .highcharts-legend{
	transform: translate(220,210);
}
.modal canvas[class="canvasjs-chart-canvas"]{
	   margin:2px 10px;
	    width:550px;
}
tspan{
	font-size:12px;
}
.mat-btn {
  width: 62px;
  height: 62px;
  overflow: hidden;
  position: fixed;
  bottom: 10px;
  right: 20px;
  text-align: center;
  cursor: pointer;
  transition: height 1s;
}

.mat-btn:hover {
  height: 220px;
  transition: height 0s;
  transition-delay: height 2s;
}

.mat-btn ul {
  margin: 0;
  padding: 0;
  position: absolute;
  bottom: 5px;
}

.mat-btn ul ul {
  position: relative;
  bottom: 220px;
}

.mat-btn li {
  list-style: none;
}

.mat-btn a {
  font-family: "helvetica neue" sans-serif;
  height: 100%;
  width: 100%;
  line-height: 45px;
  text-align: center;
  display: block;
  color: #fff;
  text-decoration: none;
}

.mat-btn ul li {
  height: 56px;
  width: 56px;
  border-radius: 50%;
  box-shadow: 2px 2px 8px -3px #000;
  background: #FF99FF;
  transition: 0.2s;
}

.mat-btn ul .spin-btn {
  background-image: url("https://ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/2x/bt_speed_dial_2x.png");
  background-size: 20px;
  background-repeat: no-repeat;
  background-position: center;
  transition: 0.2s;
}

.mat-btn:hover ul .spin-btn {
  transform: rotate(360deg);
  background-image: url("https://ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/2x/bt_compose2_2x.png ");
}

.mat-btn ul li ul li {
  margin: 8px auto;

  height: 45px;
  width: 45px;
  transition: 0.1s;
}

.mat-btn ul li ul li:hover {
  box-shadow: 3px 3px 15px -3px #000;
}

.mat-btn ul li ul li:nth-child(1) {
  background: #aed581;
  opacity: 0;
  transition-delay: 0.01s;
}

.mat-btn ul li ul li:nth-child(2) {
  background: #3c80f6;
  opacity: 0;
  transition-delay: 0.05s;
}

.mat-btn ul li ul li:nth-child(3) {
  background: #d2a518;
  opacity: 0;
  transition-delay: 0.09s;
}

.mat-btn:hover ul li ul li:nth-child(1) {
  opacity: 1;
  transition-delay: 0.09s;
}

.mat-btn:hover ul li ul li:nth-child(2) {
  opacity: 1;
  transition-delay: 0.05s;
}

.mat-btn:hover ul li ul li:nth-child(3) {
  opacity: 1;
  transition-delay: 0.01s;
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
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 7% 25% 15% 25%; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 860;
  height: 460px;
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

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
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

			<div class="wrap" style="width: 90%; float: right; margin-right: 3%;">
				<div class="bg-effect">
					<div class="col-md-11 col-sm-5">
						<div class="tabs-left">
							<ul class="nav nav-tabs">
								<li class="active"><a data-placement="top"
									title="Thống kê sản phẩm" href="#a" data-toggle="tab"><span
										class="fas fa-lightbulb"></span></a></li>
								<li><a data-placement="top" title="Thống kê doanh thu"
									href="#b" data-toggle="tab"><span
										class="fas fa-dollar-sign"></span></a></li>
								<li><a data-placement="top" title="Thống kê hóa đơn"
									href="#c" data-toggle="tab"><span class="fas fa-file"></span></a></li>

							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="a">
									<div id="chartContainer" style="height: 450px; width: 100%;"></div>
									<div class="mat-btn">
										<ul>
											<li><a class="spin-btn" href="#"></a>
												<ul>
													<li><a href="#"
														onclick="document.getElementById('id04').style.display='block'">2015</a></li>
													<li><a href="#"
														onclick="document.getElementById('id05').style.display='block'">2016</a></li>
													<li><a href="#"
														onclick="document.getElementById('id06').style.display='block'">2017</a></li>
												</ul></li>
										</ul>
									</div>
									<div id="id04" class="modal">
										 <form class="modal-content animate">
											<span
												onclick="document.getElementById('id04').style.display='none'"
												class="close" title="Close Modal">&times;</span>
											<div id="chartContainer1" style="height: 450px; width: 100%;"></div>
										</form>
									</div>
									<div id="id05" class="modal">
										 <form class="modal-content animate">
											<span
												onclick="document.getElementById('id05').style.display='none'"
												class="close" title="Close Modal">&times;</span>
											<div id="chartContainer2" style="height: 450px; width: 100%;"></div>
										</form>
									</div>
									<div id="id06" class="modal">
										 <form class="modal-content animate">
											<span
												onclick="document.getElementById('id06').style.display='none'"
												class="close" title="Close Modal">&times;</span>
											<div id="chartContainer3" style="height: 450px; width: 100%;"></div>
										</form>
									</div>
								</div>
								<div class="tab-pane" id="b">
									<div class="wrapper">
										<span
											style="position: absolute; top: 5%; left: 35%; color: #eee; font-size: 21px">Thống
											kê lợi nhuận các năm</span>
										<canvas id='z'></canvas>
										<div class="label">text</div>
									</div>
								</div>
								<div class="tab-pane" id="c">
									<div id="containers"></div>
									<div class="mat-btn">
										<ul>
											<li><a class="spin-btn" href="#"></a>
												<ul>
													<li><a href="#"
														onclick="document.getElementById('id01').style.display='block'">2015</a></li>
													<li><a href="#"
														onclick="document.getElementById('id02').style.display='block'">2016</a></li>
													<li><a href="#"
														onclick="document.getElementById('id03').style.display='block'">2017</a></li>
												</ul></li>
										</ul>
									</div>
									<div id="id01" class="modal">
										 <form class="modal-content animate">
											<span
												onclick="document.getElementById('id01').style.display='none'"
												class="close" title="Close Modal">&times;</span>
											<div id="containers1"></div>
										</form>
									</div>
									<div id="id02" class="modal">
										 <form class="modal-content animate">
											<span
												onclick="document.getElementById('id02').style.display='none'"
												class="close" title="Close Modal">&times;</span>
											<div id="containers2"></div>
										</form>
									</div>
									<div id="id03" class="modal">
										 <form class="modal-content animate">
											<span
												onclick="document.getElementById('id03').style.display='none'"
												class="close" title="Close Modal">&times;</span>
											<div id="containers3"></div>
										</form>
									</div>
								</div>
							</div>
							<!-- /tab-content -->
						</div>
						<!-- /tabbable -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--footer
	<div class="footer">
		<p>
			&copy; 2018 Glance Design Dashboard. All Rights Reserved | Design by
			<a href="#" target="_blank">w3layouts</a>
		</p>
	</div>
	<!--//footer-->
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

	<!-- js tab -->
	<script type="text/javascript">
		var tabsFn = (function() {

			function init() {
				setHeight();
			}

			function setHeight() {
				var $tabPane = $('.tab-pane'), tabsHeight = $('.nav-tabs')
						.height();

				$tabPane.css({
					height : tabsHeight
				});
			}
			$(init);
		});
	</script>
	<script>
// Get the modal
var modal = document.getElementByClass('modal');


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
	<!-- sảm phẩm -->


	<!-- doanh thu-->
	<script type="text/javascript">
		/*
		SANDER SAYS:
		NO WARRANTIES EXPRESSED OR IMPLIED
		FOR USING THIS CODE: "ALL THIS"
		HAS HAPPENED BEFORE, AND IT WILL
		HAPPEN AGAIN... BUT IT DOESN'T
		MATTER - BECAUSE WE ARE IN THIS
		TOGETHER. EVERY PATH IS THE RIGHT
		PATH: EVERYTHING COULD HAVE BEEN
		ANYTHING ELSE, AND IT WOULD HAVE
		JUST AS MUCH MEANING. ENJOY. SHARE.
		COMPLIMENTS? PARTY INVITATIONS?
		RIGHT ON! CONTACT @HYPERABSOLUTE
		ON TWITTER OR VISIT UXRIG.COM
		STAY AWESOME | HYPERABSOLUTE
		 */

		var label = document.querySelector(".label");
		var c = document.getElementById("z");
		var ctx = c.getContext("2d");
		var cw = c.width = 935;
		var ch = c.height = 450;
		var cx = cw / 2, cy = ch / 2;
		var rad = Math.PI / 180;
		var frames = 0;

		ctx.lineWidth = 1;
		ctx.strokeStyle = "#999";
		ctx.fillStyle = "#ccc";
		ctx.font = "14px monospace";

		var grd = ctx.createLinearGradient(0, 0, 0, cy);
		grd.addColorStop(0, "hsla(167,72%,60%,1)");
		grd.addColorStop(1, "hsla(167,72%,60%,0)");

		var oData = {
			"2009" : 11.7,
			"2010" : 10.1,
			"2011" : 9.9,
			"2012" : 17.3,
			"2013" : 30.1,
			"2014" : 5.3,
			"2015" : 38.4,
			"2016" : 18.7,
			"2017" : 23.3,
			"2018" : 22.8,
		};

		var valuesRy = [];
		var propsRy = [];
		for ( var prop in oData) {

			valuesRy.push(oData[prop]);
			propsRy.push(prop);
		}

		var vData = 4;
		var hData = valuesRy.length;
		var offset = 50.5; //offset chart axis
		var chartHeight = ch - 2 * offset;
		var chartWidth = cw - 2 * offset;
		var t = 1 / 7;
		var speed = 2; // for the animation

		var A = {
			x : offset,
			y : offset
		}
		var B = {
			x : offset,
			y : offset + chartHeight
		}
		var C = {
			x : offset + chartWidth,
			y : offset + chartHeight
		}

		/*
		 A  ^
		 |  |  
		 + 25
		 |
		 |
		 |
		 + 25  
		 |__|_________________________________  C
		 B
		 */

		//CHART AXIS -------------------------
		ctx.beginPath();
		ctx.moveTo(A.x, A.y);
		ctx.lineTo(B.x, B.y);
		ctx.lineTo(C.x, C.y);
		ctx.stroke();

		//vertical ( A - B )
		var aStep = (chartHeight - 50) / (vData);

		var Max = Math.ceil(arrayMax(valuesRy) / 10) * 10;
		var Min = Math.floor(arrayMin(valuesRy) / 10) * 10;
		var aStepValue = (Max - Min) / (vData);
		console.log("aStepValue: " + aStepValue); //8 units
		var verticalUnit = aStep / aStepValue;

		var a = [];
		ctx.textAlign = "right";
		ctx.textBaseline = "middle";
		for (var i = 0; i <= vData; i++) {

			if (i == 0) {
				a[i] = {
					x : A.x,
					y : A.y + 25,
					val : Max
				}
			} else {
				a[i] = {}
				a[i].x = a[i - 1].x;
				a[i].y = a[i - 1].y + aStep;
				a[i].val = a[i - 1].val - aStepValue;
			}
			drawCoords(a[i], 3, 0);
		}

		//horizontal ( B - C )
		var b = [];
		ctx.textAlign = "center";
		ctx.textBaseline = "hanging";
		var bStep = chartWidth / (hData + 1);

		for (var i = 0; i < hData; i++) {
			if (i == 0) {
				b[i] = {
					x : B.x + bStep,
					y : B.y,
					val : propsRy[0]
				};
			} else {
				b[i] = {}
				b[i].x = b[i - 1].x + bStep;
				b[i].y = b[i - 1].y;
				b[i].val = propsRy[i]
			}
			drawCoords(b[i], 0, 3)
		}

		function drawCoords(o, offX, offY) {
			ctx.beginPath();
			ctx.moveTo(o.x - offX, o.y - offY);
			ctx.lineTo(o.x + offX, o.y + offY);
			ctx.stroke();

			ctx.fillText(o.val, o.x - 2 * offX, o.y + 2 * offY);
		}
		//----------------------------------------------------------

		//DATA
		var oDots = [];
		var oFlat = [];
		var i = 0;

		for ( var prop in oData) {
			oDots[i] = {}
			oFlat[i] = {}

			oDots[i].x = b[i].x;
			oFlat[i].x = b[i].x;

			oDots[i].y = b[i].y - oData[prop] * verticalUnit - 25;
			oFlat[i].y = b[i].y - 25;

			oDots[i].val = oData[b[i].val];

			i++
		}

		///// Animation Chart ///////////////////////////
		//var speed = 3;
		function animateChart() {
			requestId = window.requestAnimationFrame(animateChart);
			frames += speed; //console.log(frames)
			ctx.clearRect(60, 0, cw, ch - 60);

			for (var i = 0; i < oFlat.length; i++) {
				if (oFlat[i].y > oDots[i].y) {
					oFlat[i].y -= speed;
				}
			}
			drawCurve(oFlat);
			for (var i = 0; i < oFlat.length; i++) {
				ctx.fillText(oDots[i].val, oFlat[i].x, oFlat[i].y - 25);
				ctx.beginPath();
				ctx.arc(oFlat[i].x, oFlat[i].y, 3, 0, 2 * Math.PI);
				ctx.fill();
			}

			if (frames >= Max * verticalUnit) {
				window.cancelAnimationFrame(requestId);

			}
		}
		requestId = window.requestAnimationFrame(animateChart);

		/////// EVENTS //////////////////////
		c.addEventListener("mousemove", function(e) {
			label.innerHTML = "";
			label.style.display = "none";
			this.style.cursor = "default";

			var m = oMousePos(this, e);
			for (var i = 0; i < oDots.length; i++) {

				output(m, i);
			}

		}, false);

		function output(m, i) {
			ctx.beginPath();
			ctx.arc(oDots[i].x, oDots[i].y, 20, 0, 2 * Math.PI);
			if (ctx.isPointInPath(m.x, m.y)) {
				//console.log(i);
				label.style.display = "block";
				label.style.top = (m.y + 10) + "px";
				label.style.left = (m.x + 10) + "px";
				label.innerHTML = "<strong>" + propsRy[i] + "</strong>: "
						+ valuesRy[i] + "%";
				c.style.cursor = "pointer";
			}
		}

		//CURVATURE
		function controlPoints(p) {
			// given the points array p calculate the control points
			var pc = [];
			for (var i = 1; i < p.length - 1; i++) {
				var dx = p[i - 1].x - p[i + 1].x; // difference x
				var dy = p[i - 1].y - p[i + 1].y; // difference y
				// the first control point
				var x1 = p[i].x - dx * t;
				var y1 = p[i].y - dy * t;
				var o1 = {
					x : x1,
					y : y1
				};

				// the second control point
				var x2 = p[i].x + dx * t;
				var y2 = p[i].y + dy * t;
				var o2 = {
					x : x2,
					y : y2
				};

				// building the control points array
				pc[i] = [];
				pc[i].push(o1);
				pc[i].push(o2);
			}
			return pc;
		}

		function drawCurve(p) {

			var pc = controlPoints(p); // the control points array

			ctx.beginPath();
			//ctx.moveTo(p[0].x, B.y- 25);
			ctx.lineTo(p[0].x, p[0].y);
			// the first & the last curve are quadratic Bezier
			// because I'm using push(), pc[i][1] comes before pc[i][0]
			ctx.quadraticCurveTo(pc[1][1].x, pc[1][1].y, p[1].x, p[1].y);

			if (p.length > 2) {
				// central curves are cubic Bezier
				for (var i = 1; i < p.length - 2; i++) {
					ctx.bezierCurveTo(pc[i][0].x, pc[i][0].y, pc[i + 1][1].x,
							pc[i + 1][1].y, p[i + 1].x, p[i + 1].y);
				}
				// the first & the last curve are quadratic Bezier
				var n = p.length - 1;
				ctx.quadraticCurveTo(pc[n - 1][0].x, pc[n - 1][0].y, p[n].x,
						p[n].y);
			}

			//ctx.lineTo(p[p.length-1].x, B.y- 25);
			ctx.stroke();
			ctx.save();
			ctx.fillStyle = grd;
			ctx.fill();
			ctx.restore();
		}

		function arrayMax(array) {
			return Math.max.apply(Math, array);
		};

		function arrayMin(array) {
			return Math.min.apply(Math, array);
		};

		function oMousePos(canvas, evt) {
			var ClientRect = canvas.getBoundingClientRect();
			return { //objeto
				x : Math.round(evt.clientX - ClientRect.left),
				y : Math.round(evt.clientY - ClientRect.top)
			}
		}
	</script>
	<!-- hoa don -->
	<script type="text/javascript">
		$(function() {
			$("#containers").highcharts(
					{
						chart : {
							zoomType : 'xy'
						},
						title : {
							text : "Thống kê hóa đơn năm 2018 "
						},

						xAxis : [ {
							categories : [ 'tháng 1', 'tháng 2', 'tháng 3',
									'tháng 4', 'tháng 5', 'tháng 6', 'tháng 7',
									'tháng 8', 'tháng 9', 'tháng 10',
									'tháng 11', 'tháng 12' ]
							
						} ],
						yAxis : [ { //Primary yAxis
							labels : {
								format : '{value}',
								style : {
									color : '#89A54E'
								}
							},
							title : {
								text : 'Đơn hàng bị hủy',
								style : {
									color : '#89A54E'
								}
							}
						}, {//Secondary yAxis
							title : {
								text : 'Hóa đơn',
								style : {
									color : '#4572A7'
								}
							},
							labels : {
								format : '{value}',
								style : {
									color : '#4572A7'
								}
							},
							opposite : true
						} ],
						tooltip : {
							shared : true
						},
						legend : {
							layout : 'vertical',
							align : 'left',
							x : 120,
							verticalAlign : 'top',
							y : 100,
							floating : true,
							backgroundColor : '#FFFFFF'
						},
						series : [
								{
									name : 'Hóa đơn',
									color : '#4572A7',
									type : 'column',
									yAxis : 1,
									data : [ 45, 70, 56, 69, 60, 47, 75, 66,
											59, 70, 81, 110 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								},
								{
									name : 'Đơn hàng bị hủy',
									color : '#89A54E',
									type : 'spline',
									yAxis : 0,
									data : [ 7, 6, 2, 14, 8, 4, 13, 2, 7, 4, 6,
											9 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								} ]
					});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#containers1").highcharts(
					{
						chart : {
							zoomType : 'xy'
						},
						title : {
							text : "Thống kê hóa đơn năm 2015 "
						},

						xAxis : [ {
							categories : [ 'tháng 1', 'tháng 2', 'tháng 3',
									'tháng 4', 'tháng 5', 'tháng 6', 'tháng 7',
									'tháng 8', 'tháng 9', 'tháng 10',
									'tháng 11', 'tháng 12' ]
							
						} ],
						yAxis : [ { //Primary yAxis
							labels : {
								format : '{value}',
								style : {
									color : '#89A54E'
								}
							},
							title : {
								text : 'Đơn hàng bị hủy',
								style : {
									color : '#89A54E'
								}
							}
						}, {//Secondary yAxis
							title : {
								text : 'Hóa đơn',
								style : {
									color : '#4572A7'
								}
							},
							labels : {
								format : '{value}',
								style : {
									color : '#4572A7'
								}
							},
							opposite : true
						} ],
						tooltip : {
							shared : true
						},
						legend : {
							layout : 'vertical',
							align : 'left',
							x : 120,
							verticalAlign : 'top',
							y : 100,
							floating : true,
							backgroundColor : '#FFFFFF'
						},
						series : [
								{
									name : 'Hóa đơn',
									color : '#4572A7',
									type : 'column',
									yAxis : 1,
									data : [ 25, 30, 36, 59, 60, 37, 55, 46,
											49, 60, 71, 56 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								},
								{
									name : 'Đơn hàng bị hủy',
									color : '#89A54E',
									type : 'spline',
									yAxis : 0,
									data : [ 7, 9, 2, 7, 3, 4, 8, 2, 4, 13, 6,
											9 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								} ]
					});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#containers2").highcharts(
					{
						chart : {
							zoomType : 'xy'
						},
						title : {
							text : "Thống kê hóa đơn năm 2016 "
						},

						xAxis : [ {
							categories : [ 'tháng 1', 'tháng 2', 'tháng 3',
									'tháng 4', 'tháng 5', 'tháng 6', 'tháng 7',
									'tháng 8', 'tháng 9', 'tháng 10',
									'tháng 11', 'tháng 12' ]
							
						} ],
						yAxis : [ { //Primary yAxis
							labels : {
								format : '{value}',
								style : {
									color : '#89A54E'
								}
							},
							title : {
								text : 'Đơn hàng bị hủy',
								style : {
									color : '#89A54E'
								}
							}
						}, {//Secondary yAxis
							title : {
								text : 'Hóa đơn',
								style : {
									color : '#4572A7'
								}
							},
							labels : {
								format : '{value}',
								style : {
									color : '#4572A7'
								}
							},
							opposite : true
						} ],
						tooltip : {
							shared : true
						},
						legend : {
							layout : 'vertical',
							align : 'left',
							x : 120,
							verticalAlign : 'top',
							y : 100,
							floating : true,
							backgroundColor : '#FFFFFF'
						},
						series : [
								{
									name : 'Hóa đơn',
									color : '#4572A7',
									type : 'column',
									yAxis : 1,
									data : [ 46, 50, 36, 39, 50, 37, 34, 36,
											49, 50, 71, 69 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								},
								{
									name : 'Đơn hàng bị hủy',
									color : '#89A54E',
									type : 'spline',
									yAxis : 0,
									data : [ 7, 5, 2, 4, 12, 4, 8, 2, 7, 10, 6,
											9 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								} ]
					});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#containers3").highcharts(
					{
						chart : {
							zoomType : 'xy'
						},
						title : {
							text : "Thống kê hóa đơn năm 2017 "
						},

						xAxis : [ {
							categories : [ 'tháng 1', 'tháng 2', 'tháng 3',
									'tháng 4', 'tháng 5', 'tháng 6', 'tháng 7',
									'tháng 8', 'tháng 9', 'tháng 10',
									'tháng 11', 'tháng 12' ]
							
						} ],
						yAxis : [ { //Primary yAxis
							labels : {
								format : '{value}',
								style : {
									color : '#89A54E'
								}
							},
							title : {
								text : 'Đơn hàng bị hủy',
								style : {
									color : '#89A54E'
								}
							}
						}, {//Secondary yAxis
							title : {
								text : 'Hóa đơn',
								style : {
									color : '#4572A7'
								}
							},
							labels : {
								format : '{value}',
								style : {
									color : '#4572A7'
								}
							},
							opposite : true
						} ],
						tooltip : {
							shared : true
						},
						legend : {
							layout : 'vertical',
							align : 'left',
							x : 120,
							verticalAlign : 'top',
							y : 100,
							floating : true,
							backgroundColor : '#FFFFFF'
						},
						series : [
								{
									name : 'Hóa đơn',
									color : '#4572A7',
									type : 'column',
									yAxis : 1,
									data : [ 40, 30, 37, 69, 60,76, 55, 46,
											49, 37, 66, 80 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								},
								{
									name : 'Đơn hàng bị hủy',
									color : '#89A54E',
									type : 'spline',
									yAxis : 0,
									data : [ 7, 6, 9, 6, 8, 4, 5, 13, 7, 4, 6,
											9 ],
									tooltip : {
										valueSuffix : ' Đơn'
									}
								} ]
					});
		});
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
	<script type="text/javascript"
		src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/35984/AnticipateEase.min.js"></script>
	<script type="text/javascript"
		src="//s3-us-west-2.amazonaws.com/s.cdpn.io/16327/MorphSVGPlugin.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.0/Chart.js"></script>
	<script type="text/javascript"
		src="https://code.highcharts.com/highcharts.js"></script>
	<script type="text/javascript"
		src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</body>
</html>