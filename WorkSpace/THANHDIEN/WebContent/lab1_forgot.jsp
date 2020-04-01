<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Forgot Password</title>
<link rel="stylesheet" type="text/css" href="css/forgot.css">
</head>
<body>
<%@ include file="menu.jsp" %>
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
<br><br><br><br>
	<div class="form-gap"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-center">
							<h3>
								<i class="fa fa-lock fa-4x"></i>
							</h3>
							<h2 class="text-center">Forgot Password?</h2>
							<p>You can reset your password here.</p>
							<div class="panel-body">

								<form id="register-form" role="form" autocomplete="off"
									class="form" method="post">

									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-envelope color-blue"></i></span> <input
												id="email" name="email" placeholder="email address"
												class="form-control" type="email">
										</div>
									</div>
									<div class="form-group">
										<input name="recover-submit"
											class="btn btn-lg btn-primary btn-block"
											value="Reset Password" type="submit">
									</div>

									<input type="hidden" class="hide" name="token" id="token"
										value="">
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>