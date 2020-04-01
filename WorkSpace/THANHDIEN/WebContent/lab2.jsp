<!DOCTYPE html>
<html lang="en">
<head>
<title>Lab2-Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="css/menu.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<ul class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#">Exercises</a></li>
		<li class="active">Exercise 2</li>
	</ul>
	<ul class="pagination" style="margin-left: 25%; margin-top: -1%;">
		<li><a href="lab1.jsp">Exercise 1 >></a></li>
		<li class="active"><a href="lab2.jsp">Exercise 2 >></a></li>
		<li><a href="lab3.jsp">Exercise 3 >></a></li>
		<li><a href="lab4.jsp">Exercise 4 >></a></li>
		<li><a href="lab5.jsp">Exercise 5 >></a></li>
		<li><a href="lab6.jsp">Exercise 6 >></a></li>
	</ul>
	<div class="login-form form">

		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" action="ServletLab2" method="post">
					<h2 style="margin-left: 260px;">Register</h2>
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="firstName" id="first_name"
									class="form-control input-lg" placeholder="First Name"
									tabindex="1">
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="lastName" id="last_name"
									class="form-control input-lg" placeholder="Last Name"
									tabindex="2">
							</div>
						</div>
					</div>
					<div class="form-group">
						<input type="text" name="userName" id="user_name"
							class="form-control input-lg" placeholder="User Name"
							tabindex="3">
					</div>
					<div class="form-group">

						<input type="text" name="dob" id="datepicker"
							class="form-control input-lg" placeholder="Date of birth"
							tabindex="4">
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="password" name="password" id="Password"
									class="form-control input-lg" placeholder="Password"
									tabindex="5">
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="password" name="re_password" id="password"
									class="form-control input-lg" placeholder="Confirm Password"
									tabindex="6">
							</div>
						</div>
					</div>


					<div class="form-group">
						<input type="text" name="address" id="Address"
							class="form-control input-lg" placeholder="Address" tabindex="7">
					</div>

					<div>
						<div style="margin-left: 200px;">
							<form>
								<label class="radio-inline"> <input type="radio"
									name="sex" checked>Male
								</label> <label class="radio-inline"> <input type="radio"
									name="sex">Female
								</label> <label class="radio-inline"> <input type="radio"
									name="sex">Other
								</label>
							</form>
						</div>

						<hr class="colorgraph">
						<div class="row" style="margin-left: 33%;">
							<div class="col-xs-12 col-md-6">
								<input type="submit" value="Register"
									class="btn btn-primary btn-block btn-lg" tabindex="8">
							</div>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>