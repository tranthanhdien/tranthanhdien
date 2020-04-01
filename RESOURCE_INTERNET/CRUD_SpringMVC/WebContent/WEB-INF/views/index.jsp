<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1 style="text-align: center;">Customer Manager</h1>
		<!-- 
		<form method="get" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
 		-->
		<form method="get" action="search" class="navbar-form">
			<button class="btn btn-success" type="submit">
				<i class="glyphicon glyphicon-info-sign"></i>&nbsp;Import To Excel
			</button>
			<button class="btn btn-success" type="submit">
				<i class="glyphicon glyphicon-info-sign"></i>&nbsp;Export To Excel
			</button>
			<div class="input-group add-on">
				<input type="text" name="keyword" class="form-control"
					placeholder="Enter the search value..." size="50" autofocus>
				<div class="input-group-btn">
					<button class="btn btn-primary" type="submit">
						<i class="glyphicon glyphicon-search"></i>&nbsp;Search
					</button>
					<a href="new"><button type="button" class="btn btn-primary">
							<span class="glyphicon glyphicon-plus"></span>&nbsp;Add Customer
						</button> </a>
				</div>
			</div>
		</form>

	</div>



	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>E-mail</th>
			<th>Address</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listCustomer}" var="customer">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
				<td>${customer.address}</td>
				<td><a href="edit?id=${customer.id}"><button type="button"
							class="btn btn-warning">
							<span class="glyphicon glyphicon-info-sign"></span>&nbsp;Edit
						</button> </a> <a href="delete?id=${customer.id}"
					onclick="return confirm('Are you sure you want to remove ' + ${customer.id} + '?');"><button
							type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;Delete
						</button> </a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>