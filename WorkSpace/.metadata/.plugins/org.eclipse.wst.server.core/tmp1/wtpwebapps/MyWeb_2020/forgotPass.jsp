
<%@page import="model_user.LoginDAO"%>
<%@page import="model_user.Login"%>
<%@page import="model_user.CustomerDAO"%>
<%@page import="model_user.Customer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Quên mật khẩu</title>
<link href="css/styleLogin2.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"
	media="all">
<style>
</style>
</head>
<body>
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Quên mật khẩu</h5>
			</div>
			<div class="modal-body">
				<form action="ControllerShopping?action=forgotPass" method="post"
					class="p-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Email</label> <input
							type="email" class="form-control" name="email"
							required="required"><br>
							<p style="color: red;">${email }</p>
					</div>
					<div class="right-w3l">
						<input type="submit" class="form-control" value="Gửi">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>