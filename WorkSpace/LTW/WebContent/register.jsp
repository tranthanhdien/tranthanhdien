<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí thành viên</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var x_timer;
		$("#username").keyup(function(e) {
			clearTimeout(x_timer);
			var user_name = $(this).val();
			x_timer = setTimeout(function() {
				check_username_ajax(user_name);
			}, 1000);
		});

		function check_username_ajax(username) {
			$("#user-result").html('<img src="img/ajax-loader.gif" />');
			$.post('CheckEmailServlet', {
				'username' : username
			}, function(data) {
				$("#user-result").html(data);
			});
		}
	});
</script>
</head>
<body>
	<!-- Include header và footer vào trang index -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="account">
			<h2 class="account-in">Đăng kí thành viên</h2>
			<form action="ServletThemUser" method="post">
				<div>
					<span>First Name*</span> <input type="text" name="firstname">
				</div>
				<div>
					<span class="name-in">Last Name*</span> <input type="text"
						name="lastname">
				</div>
				<div>
					<span class="name-in">User Name*</span> <input type="text"
						name="username"> <span id="user-result"></span>
				</div>
				<div>
					<span class="mail">Email*</span> <input type="text" name="email">
				</div>
				<div>
					<span class="word">Password*</span> <input type="password"
						name="pass">
				</div>
				<input type="submit" value="Login">
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>