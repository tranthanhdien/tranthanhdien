<!doctypehtml>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" href="css/menu.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
</head>
<body>
	<ul>
		<li><a href="">Home</a></li>
		<li><a href="about.jsp">About</a></li>
		<li><a href="#">Lab</a></li>
	</ul>
	<div class="container">
		<br /> <br /> <br /> <br />
		<center>
			<b id="login-name">LOGIN</b>
		</center>
		<div class="row">
			<div class="col-md-6 col-md-offset-3" id="login">
				<form>
					<div class="form-group">
						<label class="user"> UserName </label>
						<div class="input-group">
							<span class="input-group-addon" id="iconn"> <i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								class="form-control" id="text1" name="tl"
								placeholder="Enter Username">
						</div>
					</div>
					<div class="form-group">
						<label class="user"> Password </label>
						<div class="input-group">
							<span class="input-group-addon" id="iconn1"> <i
								class="glyphicon glyphicon-lock"></i></span> <input type="text"
								class="form-control" id="text2" name="tl"
								placeholder="Enter Password">
						</div>
					</div>

					<div class="form-group">

						<input type="submit" class="btn btn-primary" value="login"
							style="border-radius: 0px;"> <input type="reset"
							class="btn btn-danger" value="reset" style="border-radius: 0px;">

					</div>
					<br> <br> <br> <a href="forgot.jsp"
						style="color: white; font-size: 16px; float: right; margin-right: 10px;">
						Forget Password </a> <a href="register.jsp"
						style="color: white; font-size: 16px; float: right; margin-right: 10px;">
						Register </a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>