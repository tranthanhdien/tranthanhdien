<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register-Đặng Văn Đa</title>
<link href="css/styleLogin2.css" type="text/css" rel="stylesheet" media="all">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"
	media="all">
</head>
<body>
	<!-- register modal -->

	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<%
					if (request.getAttribute("emailChuaDK") != null) {
				%>
				<p class="modal-title" style="color: red">
					Email chưa đăng kí, mời đăng kí hoặc trở lại <a
						href="LoginSystem.jsp"> đăng nhập</a>
				</p>
				<%
					} else {
				%>
				<h5 class="modal-title" id="exampleModalLabel1">Register</h5>
				<%
					}
				%>
			</div>
			<%
				String name = (String) request.getAttribute("name");
				String email = (String) request.getAttribute("email");
			%>

			<div class="modal-body">
				<form action="ControllerShopping?action=register" method="post" class="p-3">
					<div class="form-group">
						<label for="recipient-email" class="col-form-label">Email</label>
						<%
							if (email == null) {
						%>
						<input type="email" class="form-control" placeholder=" "
							name="Email" id="recipient-email">

						<%
							}
							if (email != null) {
						%>
						<input type="email" class="form-control" value="<%=email%>"
							name="Email" id="recipient-email">
						<%
							}
						%>

						<!-- invalidation -->
						<%
							if (request.getAttribute("email_error_register") != null) {
								out.print("<font color=\"red\">" + (String) request.getAttribute("email_error_register") + "</font");

							}
						%>
					</div>
					<div class="form-group">
						<label for="password1" class="col-form-label">Password</label> <input
							type="password" class="form-control" placeholder=" "
							name="Password" id="password1">

						<!-- invalidation -->
						<%
							if (request.getAttribute("pass_error_register") != null) {
								out.print("<font color=\"red\">" + (String) request.getAttribute("pass_error_register") + "</font");

							}
						%>
					</div>
					<div class="form-group">
						<label for="password2" class="col-form-label">Confirm
							Password</label> <input type="password" class="form-control"
							placeholder=" " name="ConfirmPassword" id="password2">
						<%
							if (request.getAttribute("repass_error_register") != null) {
								out.print("<font color=\"red\">" + (String) request.getAttribute("repass_error_register") + "</font");

							}
						%>
						<%
							if (request.getAttribute("dont_register") != null) {
								out.print("<font color=\"red\">" + (String) request.getAttribute("dont_register") + "</font");

							}
						%>
					</div>
					<div class="sub-w3l">
						<div class="sub-agile">
							<input type="checkbox" id="brand2" value="checking"> <label
								for="brand2" class="mb-3 text-dark"> <span></span>I
								Accept to the Terms & Conditions
							</label>
						</div>
					</div>
					<div class="right-w3l">
						<input type="submit" class="form-control" value="Register">
					</div>
				</form>
			</div>
		</div>

	</div>
	<!-- //register modal -->

<!-- password-script -->
	<script>
		window.onload = function () {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}

		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity("Mật khẩu xác nhân không khớp");
			else
				document.getElementById("password2").setCustomValidity('');
			//empty string means no validation error
		}
	</script>
	<!-- //password-script -->

</body>
</html>