<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
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
<!------ Include the above in your HEAD tag ---------->
<body>
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#contact">About</a></li>
		<li><a href="#">Lab</a></li>
	</ul>
	<div class="login-form form">

		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form">
					<h2 style="margin-left: 260px;">Register</h2>
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="first_name" id="first_name"
									class="form-control input-lg" placeholder="First Name"
									tabindex="1">
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="last_name" id="last_name"
									class="form-control input-lg" placeholder="Last Name"
									tabindex="2">
							</div>
						</div>
					</div>
					<div class="form-group">
						<input type="text" name="user_name" id="user_name"
							class="form-control input-lg" placeholder="User Name"
							tabindex="3">
					</div>
					<div class="form-group">

						<input type="text" name="datepicker" id="datepicker"
							class="form-control input-lg" placeholder="Date of birth"
							tabindex="4">
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="Password" id="Password"
									class="form-control input-lg" placeholder="Password"
									tabindex="5">
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="password" id="password"
									class="form-control input-lg" placeholder="Confirm Password"
									tabindex="6">
							</div>
						</div>
					</div>


					<div class="form-group">
						<input type="text" name="Address" id="Address"
							class="form-control input-lg" placeholder="Address" tabindex="7">
					</div>

					<div style="margin-left: 200px";>
						
						<form>
							<label class="radio-inline"> <input type="radio"
								name="optradio" checked>Male
							</label> <label class="radio-inline"> <input type="radio"
								name="optradio">Female
							</label> <label class="radio-inline"> <input type="radio"
								name="optradio">Other
							</label>
						</form>

				
			</div>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6">
					<input type="submit" value="Register"
						class="btn btn-primary btn-block btn-lg" tabindex="8">
				</div>
				<div class="col-xs-12 col-md-6">
					<a href="#" class="btn btn-success btn-block btn-lg">Sign In</a>
				</div>
			</div>


			</form>
		</div>
	</div>
	</div>
</body>
</html>