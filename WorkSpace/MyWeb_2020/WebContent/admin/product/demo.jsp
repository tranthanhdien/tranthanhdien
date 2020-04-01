<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkInput() {
		if (isNaN(checkValidation.price.value)) {
			alert("Giá bán phải là số");
			checkValidation.price.focus();
			return false;
		}
		if (isNaN(checkValidation.discount.value)) {
			alert("Giảm giá phải là số");
			checkValidation.discount.focus();
			return false;
		}
		if (isNaN(checkValidation.soLuong.value)) {
			alert("Số lượng phải là số");
			checkValidation.soLuong.focus();
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
				action="<%=request.getContextPath()%>/ControllerProduct?action=add"
				method="post" enctype="multipart/form-data"
				onsubmit="return submitForm(this);">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="text-align: center">
							<b>THÊM SẢM PHẨM</b>
						</h4>
					</div>
					<div class="modal-body">
						<table style="width: 100%;">
							<tr>
								<td><div class="input-group" style="display: grid;">
										<label for="ma"><b>Mã sản phẩm</b></label> <input type="text"
											value="khong can xet" name="id">
									</div></td>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Tên sản phẩm</b></label> <input
											type="text" placeholder="Nhập tên sản phẩm" name="name"
											required>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div class="input-group" style="display: grid;">
										<label for="ten"><b>Mô tả</b></label>
										<textarea rows="2" cols="30" name="description"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Giá bán</b></label> <input type="text"
											placeholder="Giá bán sản phẩm" name="price" required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Giảm giá</b></label> <input type="text"
											placeholder="Giảm giá" name="discount" required>
									</div></td>
							</tr>
							<tr>
								<td><div class="input-group " style="display: grid;">
										<label for="gia"><b>Số lượng nhập</b></label> <input
											type="text" placeholder="Số lượng nhập" name="soLuong"
											required>
									</div></td>
								<td><div class="input-group " style="display: grid;">
										<label for="giam"><b>Công suất</b></label> <input type="text"
											placeholder="Công suât" name="congSuat" required>
									</div></td>
							</tr>
							<tr>
								<td>
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Điện áp</b></label> <input type="text"
											placeholder="Mô tả sản phẩm" name="dienAp" required>
									</div>
								</td>
								<td><div class="input-group" style="display: grid;">
										<label for="mota"><b>Thời gian bảo hành</b></label> <select
											name="baoHanh" style="width: 90%; padding: 3px 3px">
											<%
												for (int i = 1; i < 13; i++) {
											%>
											<option value="<%=i%>"><%=i%></option>
											<%
												}
											%>
										</select>
									</div></td>
							</tr>
							<tr>
								<td>
									<!-- sua lai cai select -->
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Loại</b></label> <input type="text"
											placeholder="Loại SP" name="loai" required>
									</div>
								</td>
								<td>

									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Nhóm</b></label> <input type="text"
											placeholder="Nhom SP" name="nhom" required>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div class="input-group" style="display: grid;">
										<label for="mota"><b>Hình ảnh</b></label> <input type="file"
											name="photo">
									</div>
								</td>
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