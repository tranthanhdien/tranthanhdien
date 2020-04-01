
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
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
<title>Login</title>
<link href="css/styleLogin2.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"
	media="all">
<style>
</style>
</head>
<body>
	<%
		Customer user = (Customer) session.getAttribute("user");
		if (user != null) {
			//da dang nhap roi
	%>
	<jsp:forward page="hoadon.jsp"></jsp:forward>
	<%
		}
	%>

	<%
		//binh thuong thi lay ngon ngu la VN
		Locale.setDefault(new Locale("vn", "VN"));
		ResourceBundle resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");

		if (session.getAttribute("language") == null) {
			resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");
		} else {
			String language = (String) session.getAttribute("language");
			if (language.equals("VN")) {
				resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");
			}
			if (language.equals("EN")) {
				resourcebundle = ResourceBundle.getBundle("bundle/demoResource_en_US");
			}
		}
	%>
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"><%=resourcebundle.getString("titleLogin") %></h5>
				<br> <a style="color: red;">${requestScope.tieptuc }</a> <a
					style="color: red;">${requestScope.daDK }</a> <a
					style="color: red;">${requestScope.dkThanhCong }</a>
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
						<label for="password" class="col-form-label"><%=resourcebundle.getString("password") %></label> <input
							type="password" class="form-control" name="Password"
							id="password" required="required"
							value="${requestScope.cookiePass }">
						<%
							if (request.getAttribute("pass_err") != null) {

								out.print("<font color=\"red\">" + (String) request.getAttribute("pass_err") + "</font");
							}
						%>



					</div>

					<div class="row sub-w3l my-3">
						<div class="col sub-agile">
							<input type="checkbox" id="brand1" value=""> <label
								for="brand1" class="text-dark" > <span></span><%=resourcebundle.getString("rememberLogin") %>
							</label>
						</div>
						<div class="col forgot-w3l text-right">
							<a href="forgotPass.jsp" class="text-dark">Forgot Password?</a>
						</div>
					</div>
					<div class="right-w3l">
						<input type="submit" class="form-control" value="<%=resourcebundle.getString("loginbutton")%>">
					</div>
					<p class="text-center dont-do">
						<%=resourcebundle.getString("neuchuacotaikhoan") %> <a href="register.jsp" data-toggle="modal"
							class="text-dark"> <%=resourcebundle.getString("forgot") %></a>
					</p>
					<a
						href="https://www.facebook.com/dialog/oauth?client_id=1517204811748325&redirect_uri=https://localhost:8080/WebProject_Backup/LoginFacebook">Login
						Facebook</a>
				</form>
			</div>
		</div>
	</div>


</body>
</html>