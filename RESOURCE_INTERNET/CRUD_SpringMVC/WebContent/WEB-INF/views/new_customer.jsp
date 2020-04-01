<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel-group">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Add New Customer</h4>
			</div>
			<div class="panel-body">
				<form:form action="save" method="post" modelAttribute="customer"
					class="form-horizontal">
					<!-- Name -->
					<div class="form-group">
						<label class="control-label col-sm-2">Name: </label>
						<div class="col-sm-10">
							<form:input path="name" class="form-control"
								placeholder="Enter name" />
						</div>
					</div>
					<!-- Email -->
					<div class="form-group">
						<label class="control-label col-sm-2">Email: </label>
						<div class="col-sm-10">
							<form:input path="email" class="form-control"
								placeholder="Enter email" />
						</div>
					</div>
					<!-- Email -->
					<div class="form-group">
						<label class="control-label col-sm-2">Address: </label>
						<div class="col-sm-10">
							<form:input path="address" class="form-control"
								placeholder="Enter address" />
						</div>
					</div>

					<button class="btn btn-primary" type="submit"
						style="margin-left: 50%">
						<span class="glyphicon glyphicon-plus"></span>&nbsp;Add
					</button>
				</form:form>
			</div>


		</div>
	</div>
	</div>
</body>
</html>