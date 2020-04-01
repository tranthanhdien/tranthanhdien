
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>Login</title>

<link href="css/cssloginlab5/style.css" rel="stylesheet" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-md-offset-4">
					<h1 class="text-center login-title">Sign in to continue</h1>
					<div class="account-wall">
						<img class="profile-img"
							src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
							alt="">
						<form class="form-signin" action="ServletLab5" method="post">
							<input type="text" class="form-control" name = "userName"value="ttdien"
								placeholder="" required autofocus> <input
								type="password" class="form-control" name = "password"value="dien1998"
								placeholder="" required>
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								Sign in</button>
							<label class="checkbox pull-left"> <input type="checkbox"
								value="remember-me"> Remember me
							</label> <a href="#" class="pull-right need-help">Need help? </a><span
								class="clearfix"></span>
						</form>
					</div>
					<a href="#" class="text-center new-account">Create an account </a>
				</div>
			</div>
		
	</div>

</body>
</html>