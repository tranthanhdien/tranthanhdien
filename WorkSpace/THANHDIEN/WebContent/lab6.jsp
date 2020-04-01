<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab6</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
#nut {
	margin-top: 50px;
	border-radius: 4px;
	background-color: #576372;
	border: none;
	color: #FFFFFF;
	font-size: 28px;
	padding: 10px;
	width: 300px;
	margin-bottom: 5px;
}
</style>
<body>
	<%@ include file="menu.jsp"%>
	<ul class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#">Exercises</a></li>
		<li class="active">Exercise 6</li>
	</ul>
	<ul class="pagination" style="margin-left: 20%; margin-top: -1%;">
		<li><a href="lab1.jsp">Exercise 1 >></a></li>
		<li><a href="lab2.jsp">Exercise 2 >></a></li>
		<li><a href="lab3.jsp">Exercise 3 >></a></li>
		<li><a href="lab4.jsp">Exercise 4 >></a></li>
		<li><a href="lab5.jsp">Exercise 5 >></a></li>
		<li class="active"><a href="lab6.jsp">Exercise 6 >></a></li>
	</ul>
	<h2>
		<button id="nut">Cài đặt SQL Server</button>
	</h2>
	<img src=images/1.png alt="Converse" style="width: 80%; margin-left: 10%;"
		class="img-product img-responsive img-rounded" />
		<br>
		<img src=images/2.png alt="Converse" style="width: 80%; margin-left: 10%;"
		class="img-product img-responsive img-rounded" />
		<br>
		<img src=images/5.png alt="Converse" style="width: 80%; margin-left: 10%;"
		class="img-product img-responsive img-rounded" />
		<br>
	<h2>
		<button id="nut">Thao tác Product</button>
	</h2>
	<img src=images/3.png alt="Converse" style="width: 80%; margin-left: 10%;"
		class="img-product img-responsive img-rounded" />
		<br>
		<img src=images/6.png alt="Converse" style="width: 80%; margin-left: 10%;"
		class="img-product img-responsive img-rounded" />
		<br>
		<img src=images/4.png alt="Converse" style="width: 80%; margin-left: 10%;"
		class="img-product img-responsive img-rounded" />
		<br>
</body>
</html>