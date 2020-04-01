<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<!-- Include header và footer vào trang index -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="account">
			<h2 class="account-in">Đăng nhập</h2>
				<form>
				<div>
					<span>Email*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="username">
				</div> 	

				<div> 
					<span class="word">Password* </span>
					<input type="password" name="pass">
				</div>				
					<input type="submit" value="Login"> 
				</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>