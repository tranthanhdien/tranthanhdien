
<%@page import="model_user.CustomerDAO"%>
<%@page import="model_user.Customer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login-Đặng Văn Đa</title>
<link href="css/styleLogin2.css" type="text/css" rel="stylesheet" media="all">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"
	media="all">
<style>
</style>
</head>
<body>

	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<%
					if (request.getAttribute("dkThanhCong") != null) {
						out.print("<font color=\"red\">" + (String) request.getAttribute("dkThanhCong") + "</font");
					}
				%>

				<%
					if (request.getAttribute("daDK") != null) {
						out.print("<font color=\"red\">" + (String) request.getAttribute("daDK") + "</font");
					} else {
				%>
				<h5 class="modal-title" id="exampleModalLabel">Login</h5>
				<%
					}
				%>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="ControllerShopping?action=login" method="post"
					class="p-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Email</label>

						<%
							if (request.getAttribute("emailRe") == null) {
						%>
						<input type="email" class="form-control" name="Name"
							id="recipient-name" required="required">
						<%
							} else {
						%>
						<input type="email" class="form-control" name="Name"
							id="recipient-name" required="required"
							value="<%=request.getAttribute("emailRe")%>">
						<%
							}
						%>
					</div>
					<div class="form-group">
						<label for="password" class="col-form-label">Password</label> <input
							type="password" class="form-control" name="Password"
							id="password" required="required">
						<%
							if (request.getAttribute("pass_err") != null) {

								out.print("<font color=\"red\">" + (String) request.getAttribute("pass_err") + "</font");
							}
						%>



					</div>

					<div class="row sub-w3l my-3">
						<div class="col sub-agile">
							<input type="checkbox" id="brand1" value=""> <label
								for="brand1" class="text-dark"> <span></span>Remember
								me?
							</label>
						</div>
						<div class="col forgot-w3l text-right">
							<a href="forgot.jsp" class="text-dark">Forgot Password?</a>
						</div>
					</div>
					<div class="right-w3l">
						<input type="submit" class="form-control" value="Login">
					</div>
					<p class="text-center dont-do">
						Don't have an account? <a href="register.jsp"
							data-toggle="modal" class="text-dark"> Register Now</a>
					</p>
					<a>Các User có thể đăng nhập, hãy test tất cả trường hợp</a>
					<%
						for (Customer u : CustomerDAO.getListCustomer()) {
					%>
					<p><%=u%></p>
					<%
						}
					%>
				</form>
			</div>
		</div>
	</div>


</body>
</html>