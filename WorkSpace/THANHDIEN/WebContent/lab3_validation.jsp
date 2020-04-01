<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min1.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min2.css">
<link rel="stylesheet" href="bootstrap/js/bootstrap.min.js">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min3.css">
<script src="bootstrap/js/menu.js"></script>
<link rel="stylesheet" href="css/form1.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Đăng kí</title>
<style>
#groove {
	border-style: groove;
	width: 50%;
}
</style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<ul class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#">Exercises</a></li>
		<li class="active">Exercise 3</li>
	</ul>
	<ul class="pagination" style="margin-left: 25%; margin-top: -1%;">
		<li><a href="lab1.jsp">Exercise 1 >></a></li>
		<li><a href="lab2.jsp">Exercise 2 >></a></li>
		<li class="active"><a href="lab3.jsp">Exercise 3 >></a></li>
		<li><a href="lab4.jsp">Exercise 4 >></a></li>
		<li><a href="lab5.jsp">Exercise 5 >></a></li>
		<li><a href="lab6.jsp">Exercise 6 >></a></li>
	</ul>
	<div id="groove" style="margin-left: 25%;">
		<div class="container" style="width: 500px;">
			<div style="color: black;" class="dangnhap">
				<form action="ServletLab3" method="post">

					<h2 id="dn" style="margin-left: 100px">THÔNG TIN ĐĂNG NHẬP</h2>

					<div class="row">
						<label class="control-label col-sm-3" for="email">Email:</label>
						<div class="col-sm-8">
							<input style="margin-bottom: 10px" type="email" name="email"
								class="form-control" id="email"
								placeholder="Nhập vào địa chỉ email..." value="">
						</div>
					</div>
					<div  style="color: red; text-align: center;">Re-type email!</div> 
					<h5 style="color: red; font-size: 13px;"></h5>
					<div class="row">
						<label class="control-label col-sm-3" for="pwd">Mật khẩu:</label>
						<div class="col-sm-8">
							<input style="margin-bottom: 10px" type="password" name="matkhau"
								class="form-control" id="pwd" placeholder="Nhập mật khẩu..."
								value="">
						</div>
					</div>
					<div  style="color: red; text-align: center;">Re-type password</div>
					<div class="row">
						<label class="control-label col-sm-3" for="pwd">Nhập lại
							mật khẩu:</label>
						<div class="col-sm-8">
							<input style="margin-bottom: 10px" type="password"
								name="nhaplaimatkhau" class="form-control" id="re-pwd"
								placeholder="Nhập lại mật khẩu..." value="">
						</div>
					</div>
					<div  style="color: red; text-align: center;">Re-enter password</div>
					<h5 style="color: red; font-size: 13px;"></h5>
					<h5 style="color: red; font-size: 13px;"></h5>
					<div class="canhan">
						<h2 id="dn" style="margin-left: 80px">THÔNG TIN CÁ NHÂN</h2>
						<div class="row">
							<label class="control-label col-sm-3" for="">Họ và
								tên:(*) </label>
							<div class="col-sm-8">
								<input style="margin-bottom: 10px" type="text" name="hovaten"
									class="form-control" id=""
									placeholder="Nhập vào tên của bạn..." value="">
							</div>
						</div>
						<div  style="color: red; text-align: center;">Re-type name</div>
						<h5 style="color: red; font-size: 13px;"></h5>
						<div class="row">
							<label class="control-label col-sm-3" for="pwd">Phái</label>
							<div class="col-sm-8">
								<label class="radio-inline"><input
									style="margin-bottom: 10px" type="radio" name="sex" value="Nam"
									checked>Nam</label> <label class="radio-inline"><input
									type="radio" name="sex" value="Nữ">Nữ</label> <label
									class="radio-inline"><input type="radio" name="sex"
									value="Nữ">Khác</label>
							</div>
						</div>
						<div class="row" style="margin-bottom: 10px">
							<label class="control-label col-sm-3" for="pwd">Ngày
								sinh:</label>
							<div class="col-sm-2" >
								<select name="day" style="width: 100%; height: 34px;">
								<%
								for (int i=1; i <32; i++)
									out.print("<option value=\"" + i + "\">" + i + "</option>");
									
								%>
								
								</select>
							</div>
							<div class="col-sm-3">
								<select name="month" style="width: 100%; height: 34px;">
								<%
								for (int i=1; i <13; i++)
									out.print("<option value=\"" + i + "\">" + i + "</option>");
									
								%>
								
								</select>
							</div>
							<div class="col-sm-3">
								<select name="year" style="width: 100%; height: 34px;">
								<%
								for (int i=1900; i <2020; i++)
									out.print("<option value=\"" + i + "\">" + i + "</option>");
									
								%>
								
								</select>
							</div>
						</div>
						<div class="row" style="margin-bottom: 10px">
							<label class="control-label col-sm-3" for="sdt">Số điện
								thoại: (*)</label>
							<div class="col-sm-8">
								<input type="number" name="sodienthoai" class="form-control"
									id="txtPhone" placeholder="Nhập vào số điện thoại liên lạc.."
									value="">
							</div>
						</div>
						<div  style="color: red; text-align: center;">Re-type your phone</div>
						<h5 style="color: red; font-size: 13px;"></h5>
						<div class="row">
							<label class="control-label col-sm-3" for="">Số di động:</label>
							<div class="col-sm-8">
								<input type="number" name="sodidong" class="form-control"
									id="txtPhone2" placeholder="Nhập vào số di động..." value="">
							</div>
						</div>
						<div  style="color: red; text-align: center;">Re-type your phone</div>
						<h5 style="color: red"></h5>
					</div>
					<div class="diachi">
						<h2 id="dn" style="margin-left: 70px">ĐỊA CHỈ</h2>
						<div class="row" style="margin-bottom: 10px">
							<label class="control-label col-sm-3" for="">Quốc gia: </label>
							<div class="col-sm-8">
								<select name="quocgia" style="width: 300px; height: 35px;">
								<%
								String[] arr = {"Việt Nam", "Hàn Quốc", "Nhật Bản", "Trung Quốc", "Campuchia", "Anh"};
								for (String tp : arr)
									out.print("<option value=\"" + tp + "\">" + tp + "</option>");
								%>
								
								</select>
							</div>
						</div>
						<div class="row" style="margin-bottom: 10px">
							<label class="control-label col-sm-3" for="tinhthanh">Tỉnh
								/Thành:</label>
							<div class="col-sm-8">
								<select name="quocgia" style="width: 300px; height: 35px;">
								<%
								String[] arrProvince = {"Tp. Hồ Chí Minh", "Tp. Vũng Tàu", "Hà Nội", "Hải Phòng", "Bình Phước", "Nghệ An"};
								for (String tp : arrProvince)
									out.print("<option value=\"" + tp + "\">" + tp + "</option>");
								%>
								
								</select>
							</div>
						</div>
						<div class="row" style="margin-bottom: 10px">
							<label class="control-label col-sm-3" for="tinhthanh">Quận/Huyện:
								</label>
							<div class="col-sm-8">
								<select name="quocgia" style="width: 300px; height: 35px;">
								<%
								String[] arrDistrict = {"Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12", "Quận Bình Thạnh", "Quận Thủ Đức", "Quận Phú Nhuận", "Quận Tân Bình", "Quận Bình Tân", "Quận Gò Vấp", "Huyện Củ Chi", "Huyện Nhà Bè", "Huyện Hóc Môn", "Huyện Cần Giờ", "Huyện Bình Chánh" };
								
								
								for (String dis : arrDistrict)
									out.print("<option value=\"" + dis + "\">" + dis + "</option>");
								%>
								
								</select>
														
							</div>
						</div>
						<div class="row" style="margin-bottom: 10px">
							<label class="control-label col-sm-3" for="sdt">Địa chỉ:
							</label>
							<div class="col-sm-8">
								<textarea rows="5" cols="40" name="diachinha"
									class="form-control"></textarea>
							</div>
						</div>
						<div  style="color: red; text-align: center;">Re-type your address</div>
					</div>
					<div style="margin-left: 30%">
						<button type="submit" class="btn btn-success">
							<span class="glyphicon glyphicon-plus"></span> Đăng kí
						</button>
						<button type="submit" class="btn btn-success">
							<span class="glyphicon glyphicon-refresh"></span> Làm mới
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>