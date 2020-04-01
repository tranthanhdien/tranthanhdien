<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>lab5_Bootstrap</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.form-control {
	width: 200px;;
}

#nut {
	margin-top: 50px;
	border-radius: 4px;
	background-color: #576372;
	border: none;
	color: #FFFFFF;
	font-size: 28px;
	padding: 10px;
	width: 300px;
	margin-bottom: 5px;
}

#khung {
	border: 1px solid #cccccc;
	margin-left: 5%;
	width: 90%;
}
</style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<ul class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#">Exercises</a></li>
		<li><a href="#">Exercise 5</a></li>
		<li class="active">Bootstrap</li>
	</ul>
	<ul class="pagination" style="margin-left: 20%; margin-top: -1%;">
		<li><a href="lab1.jsp">Exercise 1 >></a></li>
		<li><a href="lab2.jsp">Exercise 2 >></a></li>
		<li><a href="lab3.jsp">Exercise 3 >></a></li>
		<li><a href="lab4.jsp">Exercise 4 >></a></li>
		<li class="active"><a href="lab5.jsp">Exercise 5 >></a></li>
		<li><a href="lab6.jsp">Exercise 6 >></a></li>
	</ul>
	<h2>
		<button id="nut">Bài tập Bootstrap 1</button>
	</h2>
	<div id="khung">
		<h1 style="text-align: center">Quản lý nhân viên</h1>
		<div style="margin-left: 26%">
			<form class="navbar-form" role="search">
				<div class="input-group add-on">
					<input class="form-control" placeholder="Nhập giá trị tìm kiếm..."
						name="srch-term" id="srch-term" type="text" size="50" autofocus>
					<div class="input-group-btn">
						<button class="btn btn-primary" type="submit">
							<i class="glyphicon glyphicon-search"></i>&nbsp;Tìm kiếm
						</button>
						<button class="btn btn-primary" type="submit">
							<i class="	glyphicon glyphicon-plus"></i>&nbsp;Thêm mới
						</button>
					</div>
				</div>
			</form>
		</div>

		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th title="Số thứ tự">STT</th>
						<th title="Mã nhân viên">Mã NV</th>
						<th>Họ tên</th>
						<th>Ngày sinh</th>
						<th>Quê quán</th>
						<th>Thao tác</th>
					</tr>

				</thead>
				<tbody>

					<tr>
						<td>1</td>
						<td>NV0001</td>
						<td>Trần Thị Thanh Nga</td>
						<td>1/5/1982</td>
						<td>Thái Bình</td>
						<td><button type="button" class="btn btn-info">
								<span class="glyphicon glyphicon-info-sign"></span>
							</button>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button> <a href="#"><button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button></a></td>
					</tr>


					<tr>
						<td>2</td>
						<td>NV0002</td>
						<td>Nguyễn Văn An</td>
						<td>7/4/1982</td>
						<td>Thái Bình</td>
						<td><button type="button" class="btn btn-info">
								<span class="glyphicon glyphicon-info-sign"></span>
							</button>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button> <a href="#"><button type="button" class="btn btn-danger">
									<span class="	glyphicon glyphicon-trash"></span>
								</button></a></td>
					</tr>


					<tr>
						<td>3</td>
						<td>NV0003</td>
						<td>Đào Thị Mơ</td>
						<td>1/5/1982</td>
						<td>Thái Bình</td>
						<td><button type="button" class="btn btn-info">
								<span class="glyphicon glyphicon-info-sign"></span>
							</button>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button> <a href="#"><button type="button" class="btn btn-danger">
									<span class="	glyphicon glyphicon-trash"></span>
								</button></a></td>
					</tr>


					<tr>
						<td>4</td>
						<td>NV0004</td>
						<td>Trạch Văn Đoành</td>
						<td>1/5/1982</td>
						<td>Thái Bình</td>
						<td><button type="button" class="btn btn-info">
								<span class="glyphicon glyphicon-info-sign"></span>
							</button>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button> <a href="#"><button type="button" class="btn btn-danger">
									<span class="	glyphicon glyphicon-trash"></span>
								</button></a></td>
					</tr>


					<tr>
						<td>5</td>
						<td>NV0005</td>
						<td>Mai Văn Anh</td>
						<td>1/5/1982</td>
						<td>Thái Bình</td>
						<td><button type="button" class="btn btn-info">
								<span class="glyphicon glyphicon-info-sign"></span>
							</button>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button> <a href="#"><button type="button" class="btn btn-danger">
									<span class="	glyphicon glyphicon-trash"></span>
								</button></a></td>
					</tr>



				</tbody>
			</table>
		</div>
	</div>

	<h2>
		<button id="nut">Bài tập Bootstrap 2</button>
	</h2>
	<div id="khung">

		<h1 style="text-align: center">Thiết lập hệ số lương cho nhân
			viên</h1>
		<div style="margin-left: 20%">
			<form class="navbar-form" role="search">
				<div class="input-group add-on">
					<input class="form-control" placeholder="Nhập giá trị tìm kiếm..."
						name="srch-term" id="srch-term" type="text" size="90" autofocus>
					<div class="input-group-btn">
						<button class="btn btn-primary" type="submit">
							<i class="glyphicon glyphicon-search"></i>&nbsp;Tìm kiếm
						</button>

					</div>
				</div>
			</form>
		</div>
		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th title="Số thứ tự">STT</th>
						<th title="Mã nhân viên">Mã NV</th>
						<th>Họ tên</th>
						<th>Loại nhân viên</th>
						<th>Lương theo ngày</th>
						<th>Thao tác</th>
					</tr>

				</thead>
				<tbody>

					<tr>
						<td>1</td>
						<td>NV0001</td>
						<td>Trần Thị Thanh Nga</td>
						<td><select>
								<option>Nhân viên cao cấp</option>
								<option>Nhân viên giỏi</option>
								<option>Nhân viên</option>



						</select></td>
						<td><input type="text" size="20" disabled="disabled"
							value="30000.0"></td>
						<td>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button>
						</td>
					</tr>


					<tr>
						<td>2</td>
						<td>NV0002</td>
						<td>Nguyễn Văn An</td>
						<td><select><option>Nhân viên giỏi</option>
								<option>Nhân viên cao cấp</option>
								<option>Nhân viên</option>



						</select></td>
						<td><input type="text" size="20" disabled="disabled"
							value="25000.0"></td>
						<td>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button>
						</td>
					</tr>


					<tr>
						<td>3</td>
						<td>NV0003</td>
						<td>Đào Thị Mơ</td>
						<td><select><option>Nhân viên giỏi</option>
								<option>Nhân viên cao cấp</option>
								<option>Nhân viên</option>



						</select></td>
						<td><input type="text" size="20" disabled="disabled"
							value="25000.0"></td>
						<td>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button>
						</td>
					</tr>


					<tr>
						<td>4</td>
						<td>NV0004</td>
						<td>Trạch Văn Đoành</td>
						<td><select><option>Nhân viên cao cấp</option>
								<option>Nhân viên giỏi</option>
								<option>Nhân viên</option>



						</select></td>
						<td><input type="text" size="20" disabled="disabled"
							value="30000.0"></td>
						<td>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button>
						</td>
					</tr>


					<tr>
						<td>5</td>
						<td>NV0005</td>
						<td>Mai Văn Anh</td>
						<td><select><option>Nhân viên</option>
								<option>Nhân viên cao cấp</option>
								<option>Nhân viên giỏi</option>




						</select></td>
						<td><input type="text" size="20" disabled="disabled"
							value="22000.0"></td>
						<td>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-edit"></span>
							</button>
						</td>
					</tr>



				</tbody>
			</table>
		</div>

	</div>
	<br>
	<br>
	<br>

</body>
</html>