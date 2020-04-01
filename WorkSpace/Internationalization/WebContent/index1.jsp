<%@page import="DAO.NgonNguDAO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Map<String, String> result = NgonNguDAO.getEnglishLanguage();
	String lang = (String) session.getAttribute("lang");
	if (lang != null) {
		if (lang.equalsIgnoreCase("English")) {
			result = NgonNguDAO.getEnglishLanguage();
		} else if (lang.equalsIgnoreCase("Vietnamese")) {
			result = NgonNguDAO.getVietnameseLanguage();
		}

	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internationalization</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

/* style the container */
.container {
	position: relative;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px 0 30px 0;
}

/* style inputs and link buttons */
input, .btn {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 4px;
	margin: 5px 0;
	opacity: 0.85;
	display: inline-block;
	font-size: 17px;
	line-height: 20px;
	text-decoration: none; /* remove underline from anchors */
}

input:hover, .btn:hover {
	opacity: 1;
}

/* add appropriate colors to fb, twitter and google buttons */
.fb {
	background-color: #3B5998;
	color: white;
}

.twitter {
	background-color: #55ACEE;
	color: white;
}

.google {
	background-color: #dd4b39;
	color: white;
}

/* style the submit button */
input[type=submit] {
	background-color: #4CAF50;
	color: white;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

/* Two-column layout */
.col {
	float: left;
	width: 50%;
	margin: auto;
	padding: 0 50px;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* vertical line */
.vl {
	position: absolute;
	left: 50%;
	transform: translate(-50%);
	border: 2px solid #ddd;
	height: 175px;
}

/* text inside the vertical line */
.vl-innertext {
	position: absolute;
	top: 50%;
	transform: translate(-50%, -50%);
	background-color: #f1f1f1;
	border: 1px solid #ccc;
	border-radius: 50%;
	padding: 8px 10px;
}

/* hide some text on medium and large screens */
.hide-md-lg {
	display: none;
}

/* bottom container */
.bottom-container {
	text-align: center;
	background-color: #666;
	border-radius: 0px 0px 4px 4px;
}

/* Responsive layout - when the screen is less than 650px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 650px) {
	.col {
		width: 100%;
		margin-top: 0;
	}
	/* hide the vertical line */
	.vl {
		display: none;
	}
	/* show the hidden text on small screens */
	.hide-md-lg {
		display: block;
		text-align: center;
	}
}
</style>
</head>
<body>
	<div class="container">
		<!-- Row1 -->
		<a href="index1.jsp"><button class="btn btn-success lg">Test</button></a>
		<div class="row" style="float: right;">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Chọn ngôn ngữ <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="ServletNgonNgu?lang=Vietnamese">Vietnamese</a></li>
					<li><a href="ServletNgonNgu?lang=English">English</a></li>
				</ul>
			</div>
		</div>
		<!-- Row1 -->
		<div class="row" style="float: right;">
			<div class="container">
				<form action="/action_page.php">
					<div class="row">
						<h2 style="text-align: center"><%=result.get("title")%></h2>


						<div class="col">
							<a href="#" class="fb btn"> <i class="fa fa-facebook fa-fw"></i>
								<%=result.get("facebook")%>
							</a> <a href="#" class="twitter btn"> <i
								class="fa fa-twitter fa-fw"></i> <%=result.get("twitter")%>
							</a> <a href="#" class="google btn"><i class="fa fa-google fa-fw">
							</i> <%=result.get("google")%> </a>
						</div>

						<div class="col">
							<div class="hide-md-lg">
								<p>Or sign in manually:</p>
							</div>

							<input type="text" name="username"
								placeholder="<%=result.get("username")%>" required> <input
								type="password" name="password"
								placeholder="<%=result.get("password")%>" required> <input
								type="submit" value="<%=result.get("login")%>">
						</div>

					</div>
				</form>
			</div>

			<div class="bottom-container">
				<div class="row">
					<div class="col">
						<a href="#" style="color: white" class="btn"><%=result.get("signup")%></a>
					</div>
					<div class="col">
						<a href="#" style="color: white" class="btn"><%=result.get("forgot")%></a>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>