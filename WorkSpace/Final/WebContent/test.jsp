<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Đăng ký thành viên</title>
	</head>
	<body>
		<div style="width: 500px; margin: 30px auto;">
			<h2>Đăng ký thành viên</h2>
			<form action="testxuly" method="post">
				<div>
					<label>Tên đăng nhập: </label>
					<input type="text" name="username" value="" />
				</div>
				<br />
				<div>
					<label>Mật khẩu: </label>
					<input type="password" name="password" value="" />
				</div>
				<br />
				<div>
					<input type="submit" name="submit" value="Đăng ký" />
					<input type="reset" name="reset" value="Nhập lại" />
				</div>
			</form>
		</div>
	</body>
</html>