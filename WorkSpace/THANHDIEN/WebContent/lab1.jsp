<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab1</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
</head>
<body>
<%@ include file="menu.jsp" %>
<!-- Breadcrumb -->
<ul class="breadcrumb">
  <li><a href="index.jsp">Home</a></li>
  <li><a href="#">Exercises</a></li>
  <li class="active">Exercise 1</li> 
</ul>
 <ul class="pagination" style="margin-left: 20%; margin-top: -1%;">
    <li class="active"><a href="lab1.jsp">Exercise 1 >></a></li>
    <li><a href="lab2.jsp">Exercise 2 >></a></li>
    <li><a href="lab3.jsp">Exercise 3 >></a></li>
    <li><a href="lab4.jsp">Exercise 4 >></a></li>
    <li><a href="lab5.jsp">Exercise 5 >></a></li>
      <li><a href="lab6.jsp">Exercise 6 >></a></li>
  </ul>
<div class="container" style="background-image:
		url(https://wallpapertag.com/wallpaper/full/c/a/a/157415-simplistic-wallpapers-1920x1080-lockscreen.jpg); width: 100%; height: 600px;">
		<br /> <br /> <br /> <br />
		<center>
			<b id="login-name">LOGIN</b>
		</center>
		<div class="row">
			<div class="col-md-6 col-md-offset-3" id="login">
				<form action="ServletLab5" method="post">
					<div class="form-group">
						<label class="user"> UserName </label>
						<div class="input-group">
							<span class="input-group-addon" id="iconn"> <i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								class="form-control" id="text1" name="userName"
								placeholder="Enter Username">
						</div>
					</div>
					<div class="form-group">
						<label class="user"> Password </label>
						<div class="input-group">
							<span class="input-group-addon" id="iconn1"> <i
								class="glyphicon glyphicon-lock"></i></span> <input type="text"
								class="form-control" id="text2" name="password"
								placeholder="Enter Password">
						</div>
					</div>

					<div class="form-group">

						<input type="submit" class="btn btn-primary" value="Login"
							style="border-radius: 0px;"> <input type="reset"
							class="btn btn-danger" value="Reset" style="border-radius: 0px;">

					</div>
					<br> <br> <br> <a href="lab1_forgot.jsp"
						style="color: white; font-size: 16px; float: right; margin-right: 10px;">
						Forget Password </a> <a href="lab1_register.jsp"
						style="color: white; font-size: 16px; float: right; margin-right: 10px;">
						Register </a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>