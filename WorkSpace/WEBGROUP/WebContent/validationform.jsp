<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- Check Validation for phone number -->

<script type="text/javascript">
	function checkInput() {
		// check các trường k đc bỏ trống
		if (checkValidation.name.value == "") {
			alert("Vui lòng nhập tên đăng nhập");
			checkValidation.name.focus();
			return false;
		}
		if (checkValidation.fullname.value == "") {
			alert("Vui lòng nhập họ và tên");
			checkValidation.fullname.focus();
			return false;
		}
		if (checkValidation.pass.value == "") {
			alert("Vui lòng nhập password");
			checkValidation.pass.focus();
			return false;
		}
		if (checkValidation.phone.value == "") {
			alert("Vui lòng nhập số điện thoại");
			checkValidation.phone.focus();
			return false;
		}
		// check số điện thoại
		if (checkValidation.phone.value == "") {
			alert("Vui lòng nhập số điện thoại");
			checkValidation.phone.focus();
			return false;
		}
		if (isNaN(checkValidation.phone.value)) {
			alert("Phải là số nguyên");
			checkValidation.phone.focus();
			return false;
		}
		if ((checkValidation.phone.value).length < 10) {
			alert("Phải đủ 10 số");
			checkValidation.phone.focus();
			return false;
		}
		if (checkValidation.email.value == "") {
			alert("Vui lòng nhập email");
			checkValidation.email.focus();
			return false;
		}
		if (LoginDAO.lookUpEmail(checkValidation.email.value) != null) {
			alert("Email đã tồn tại");
			checkValidation.email.focus();
			return false;
		}
		if (checkValidation.address.value == "") {
			alert("Vui lòng nhập địa chỉ");
			checkValidation.address.focus();
			return false;
		}
		if (checkValidation.admin.value == "") {
			alert("Vui lòng chọn admin(có/không)");
			checkValidation.admin.focus();
			return false;
		}

		return true;
	}
</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<button type="button" class="btn btn-warning" data-toggle="modal"
		data-target="#myModal">
		<span class="fa fa-plus-square-o"></span>&nbsp;Thêm mới
	</button>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<form name="checkValidation"
				action="<%=request.getContextPath()%>/ControllerUser?action=add"
				method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="text-align: center">
							<b>THÊM KHÁCH HÀNG/NGƯỜI DÙNG</b>
						</h4>
					</div>
					<div class="modal-body">
						<table style="width: 100%;">
							<tr>
								<td><div class="input-group" style="display: grid;">
										<label for="ma"><b>Mã người dùng</b></label> <input
											type="text" value="cái này tự động khỏi kiểm tra" name="id">
									</div></td>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Tên đăng nhập</b></label> <input
											type="text" placeholder="Nhập tên đăng nhập" name="name"
											required>
									</div>
								</td>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Họ và tên</b></label> <input type="text"
											placeholder="Họ và tên" name="fullname" required>
									</div>
								</td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Mật khẩu</b></label> <input type="text"
											placeholder="Nhập mật khẩu" name="pass" required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Số điện thoại</b></label> <input
											type="text" placeholder="Nhập số điện thoại" name="phone"
											required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Email</b></label> <input type="email"
											placeholder="Nhập Email" name="email" required>
									</div></td>
									</tr>
									
							<tr>
								<td colspan="3"><div class="input-group "
										style="display: grid;">
										<label for="giam"><b>Địa chỉ</b></label>
										<textarea rows="3" cols="30" name="address"
											placeholder="Nhập địa chỉ" required></textarea>
									</div></td>
							</tr>
							<tr>
								<td colspan="3"><b>Admin </b> <input type="radio"
									name="admin" value="yes">Có <input type="radio"
									name="admin" value="no" required>Không</td>
							</tr>
							<tr>
								<td align="right" colspan="2">
									<div class="modal-footer">
										<button type="submit" onclick="return checkInput();"
											class="btn btn-success">Gửi</button>
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">Đóng</button>

									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>