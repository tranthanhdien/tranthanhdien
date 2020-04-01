
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>MY JAVA WEB</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- width=device-width: hiển thị tuỳ theo độ rộng của thiết bi; initial-scale=1: Mức zoom mặc định ban đầu -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.jumbotron {
	background-color: #1ECBF4;
	color: #ffffff;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#myPage">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#about">GIỚI THIỆU </a></li>
					<li><a href="#services">DỊCH VỤ </a></li>
					<li><a href="#portfolio">DỰ ÁN </a></li>
					<li><a href="#pricing">GIÁ </a></li>
					<li><a href="#contact">LIÊN HỆ </a></li>
					<li><a href="#group">GROUP DIARY </a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- <body style=background-color:powderblue;> -->
	<!-- Màu cho trang web -->

	<div class="jumbotron text-center">
		<!-- <h2>LẬP TRÌNH WEB-2018</h2> -->
		<h2 style="font-size: 60px; text-align: center; color: red">GIAO TIẾP NGƯỜI MÁY</h2>
		<p>Nhiệt huyết - Năng động - Tài năng</p>
		<form class="form-inline">
			<input type="email" class="form-control" size="50"
				placeholder="Nhập địa chỉ email của bạn" required>
			<button type="button" class="btn btn-danger">Đăng kí theo
				dõi chúng tôi</button>

		</form>
	</div>
	<div>

		<p style="font-size: 50px; text-align: center;">PHÂN CÔNG NHIỆM VỤ GROUP 03:</p>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>STT</th>
					<th>Mã SV</th>
					<th>Họ tên</th>
					<th>Mức độ hoàn thành</th>
					<th>Kết quả</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>16130312</td>
					<td>Đặng Văn Đa</td>
					<td>100%</td>
					<td><a href="https://www.facebook.com/t.thanhdien">This is
							a link</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>16130326</td>
					<td>Trần Thanh Điền</td>
					<td>100%</td>
					<td><a href="https://www.facebook.com/t.thanhdien">This is
							a link</a></td>
				</tr>
				<tr>
					<td>3</td>
					<td>16130388</td>
					<td>Nguyễn Quốc An</td>
					<td>100%</td>
					<td><a href="https://www.facebook.com/t.thanhdien">This is
							a link</a></td>
				</tr>
				<tr>
					<td>4</td>
					<td>16130355</td>
					<td>Nguyễn Đình Phong</td>
					<td>100%</td>
					<td><a href="https://www.facebook.com/t.thanhdien">This is
							a link</a></td>
				</tr>
			</tbody>
		</table>
		<hr>
		<button type="button"
			onclick="document.getElementById('demo').innerHTML = Date()">
			Click me to display Date and Time.</button>

		<p id="demo"></p>


		<hr>
		<h2>HTML List1</h2>
		<ul>
			<li>Coffe</li>
			<li>Tea</li>
			<li>Milk</li>
			<li>Fruit</li>
		</ul>


		<hr>
		<h2>HTML List2</h2>
		<ol>
			<li>Coffe</li>
			<li>Tea</li>
			<li>Milk</li>
			<li>Fruit</li>
		</ol>


		<hr>
		<h2>HTML List3</h2>
		<ul style="list-style-type: square">
			<li>Coffe</li>
			<li>Tea</li>
			<li>Milk</li>
			<li>Fruit</li>
		</ul>

		<p>
			Kết quả 2 + 2 =
			<%=2 + 2%>
		<hr>

		<h2>HTML Forms</h2>

		<form action="/action_page.php">
			First name:<br> <input type="text" name="firstname"
				value="Mickey"> <br> Last name:<br> <input
				type="text" name="lastname" value="Mouse"> <br> <br>
			<input type="submit" value="Submit">
		</form>
		<!-- Phân tách nội dung -->
		<form action="orderReply.jsp" method="get">
			<table cellspacing="5">
				<tr>
					<td align="right">Number to purchase:</td>
					<td><input type="text" name="quantity"></td>
				</tr>
				<tr>
					<td align="right">Your name:</td>
					<td><input type="text" name="customerName"></td>
				</tr>
				<tr>
					<td align="right">Your email:</td>
					<td><input type="text" name="customerEmail"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Place Order"></td>
				</tr>
			</table>
			<form>
				<p>
					This is<br>a paragraph<br>with line breaks
				</p>
				<!-- Thẻ br(break) dùng để ngắt dòng mà không phải ngắt đoạn -->
				<hr/>
				<p>Trần Thanh Điền, DH16DTB, Khoa Công Nghệ Thông Tin, ĐH Nông
					Lâm.</p>
				<!-- Thẻ này nó tự động viết trên 1 dòng -->
				<pre>
			Trần Thanh Điền
			Trần Thanh Điền
			Trần Thanh Điền
			</pre>
				<!-- Thẻ này có chiều rộng font chữ cố định, bảo toàn cả khoảng trắng  và ngắt dòng -->
				<hr>
				<p>I am normal</p>
				<p style="color: red;">I am a red</p>
				<p style="color: blue;">I am a blue</p>
				<p style="font-size: 50px;">I am big</p>
	</div>
</head>

<body>

</body>
</html>