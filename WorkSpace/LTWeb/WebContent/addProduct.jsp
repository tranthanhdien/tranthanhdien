<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Thêm Sản phẩm</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-size: cover;
}

button {
	position: relative;
	color: rgba(255, 255, 255, 1);
	text-decoration: none;
	background-color: green;
	width: 100px;
	display: block;
	padding: 4px;
	margin: 100px auto;
	text-align: center;
	-webkit-transition: all .1s ease;
	-moz-transition: all .1s ease;
	-ms-transition: all .1s ease;
	-o-transition: all .1s ease;
	transition: all .1s ease;
	border-radius: 8px;
}

button:active {
	box-shadow: 0px 3px 0px rgba(219, 31, 5, 1), 0px 3px 6px
		rgba(0, 0, 0, .9);
	position: relative;
	top: 10px;
}
</style>


<body>

	<div class="container">
	
		<h2 style="text-align: center; margin-top: 50px; color: black">
			<strong>THÊM SẢN PHẨM MỚI</strong>
			
			
		</h2>
		<form id="#" class="form-horizontal"
			action="ServletThemSanPham"
			method="post" style="margin-top: 30px; margin-left: 250px;">

			<div class="form-group">
				<label class="control-label col-sm-2" style ="color:black;">Tên sản phẩm</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="nameProduct" id="tensp"
						placeholder="Nhập tên sản phẩm" value="" required="">
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"style ="color:black;">Giá</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="price"
						id="gia" placeholder="Nhập giá sản phẩm" value=""
						required="">
				</div>

			</div>

			<div class="form-group">
				<label class="control-label col-sm-2"style ="color:black;">Nhà sản xuất</label>
				<div class="col-sm-5">
						
						<select class="form-control" name="nsx" id="nsx"
						placeholder="Nhập tên nhà sản xuất"> 
						<option value="NSX001" > NSX001  </option>
						<option value="NSX01" > NSX01  </option>
						<option value="NSX04" > NSX04 </option>
						<option value="NSX05" > NSX05 </option>
						<option value="NSX07" > NSX07 </option> 
					 </select>
				</div>
				<div class="col-sm-5">
					<p style="color: red" id="error-sdt"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"style ="color:black;">Màu</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="mau" id="mau"
						placeholder="Nhập màu sản phẩm" value="" required="">
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"style ="color:black;">Chất liệu</label>
				<div class="col-sm-5">
					<textarea rows="4"  type="text" class="form-control" name="chatlieu" id="chatlieu"
						placeholder="Nhập chất liệu sản phẩm" value="" required=""></textarea>
				</div>

			</div>
			
		
			<div class="form-group" style="margin-left: 10px; margin-top: 20px;">
				<div class="col-sm-offset-2 col-sm-4">
					<a href="ServletThemSanPham">
					<button type="submit"
						style="height: 40px; width: 300px; background-color: green">
						<span style="color: white; font-size: 16px; text-align: right">
							<span class="glyphicon glyphicon-plus"></span> Thêm
						</span>
					</button></a>
				</div>
			</div>
		</form>
	</div>

</body>
<!-- jQuery -->
<script src="../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->


<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>

</html>
