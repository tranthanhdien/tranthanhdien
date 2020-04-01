<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>List</title>
<link rel="stylesheet"
	href="../maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/*dang danh sach */
.table>thead>tr.names>th {
	border-bottom: 1px;
}

.table>tbody>tr.item>td {
	padding-bottom: 20px;
	padding-top: 20px;
	vertical-align: middle;
}

.table>tfoot>tr.no-border>td {
	border-top: 0 none;
	padding-top: 20px;
}

.img-product {
	padding-top: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<table id="cart" class="table table-responsive">
			<!-- tieu de  -->
			<thead>
				<tr class="names">
					<th style="width: 10%">Mã SP</th>
					<th style="width: 50%">Thông tin chi tiết</th>
					<th style="width: 10%" class="text-right hidden-xs">Size</th>
					<th style="width: 10%" class="text-right hidden-xs">Giá ban
						đầu</th>

					<th style="width: 10%" class="text-right">Giá đã giảm</th>
					<th style="width: 10%">Thao tác</th>
				</tr>
			</thead>
			<tbody>

				<tr class="item">
					<td><b>d0001</b></td>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-3 hidden-xs">
								<img src=images/img1.jpg alt="Converse"
									class="img-product img-responsive img-rounded" />
							</div>
							<div class="col-sm-9">
								<h4 class="nomargin">ĐẦM DỆT KIM VIỀN ĐEN MS11871</h4>
								<p class="hidden-xs" style="color: red">220,000 VNĐ 350,000
									VNĐ</p>
								<p>Đầm dệt kim viền đen - Mã sản phẩm: MS11871 - Giá bán:
									350.000đ - Chất liệu vải: Thun dệt kim - Màu sắc: - Chi Tiết
									Sản Phẩm: Dài tay 50cm - Size: S - M - L - Chiều dài sản phẩm
									size S : 97Cm - Tăng "1Cm" mỗi size.</p>
							</div>
						</div>
					</td>
					<td data-th="Size" class="text-right hidden-xs">Free size</td>
					<td data-th="Price" class="text-right hidden-xs">275.000</td>

					<td data-th="Subtotal" class="text-right">239.000</td>
					<td class="actions" data-th="">
						<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa
						</button>
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá
						</button>
					</td>
				</tr>

				<tr class="item">
					<td><b>d0002</b></td>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-3 hidden-xs">
								<img src=images/img2.jpg alt="Converse"
									class="img-product img-responsive img-rounded" />
							</div>
							<div class="col-sm-9">
								<h4 class="nomargin">ĐẦM REN LÁ RẼ QUẠT MS11873</h4>
								<p class="hidden-xs" style="color: red">220,000 VNĐ 495,000
									VNĐ</p>
								<p>Đầm ren lá rẽ quạt - Mã sản phẩm: MS11873 - Giá bán:
									495.000đ - Chất liệu vải: Ren - Màu sắc: Nude - Chi Tiết Sản
									Phẩm: Dài tay 25cm, Đầm 2 lớp - Size: XS - S - M - L - Xl -
									Chiều dài sản phẩm size S : 89Cm - Tăng "1Cm" mỗi size.</p>
							</div>
						</div>
					</td>
					<td data-th="Size" class="text-right hidden-xs">Free size</td>
					<td data-th="Price" class="text-right hidden-xs">358.000</td>

					<td data-th="Subtotal" class="text-right">338.000</td>
					<td class="actions" data-th="">
						<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa
						</button>
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá
						</button>
					</td>
				</tr>

				<tr class="item">
					<td><b>d0003</b></td>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-3 hidden-xs">
								<img src=images/img3.jpg alt="Converse"
									class="img-product img-responsive img-rounded" />
							</div>
							<div class="col-sm-9">
								<h4 class="nomargin">ĐẦM BODY PHỐI LƯỚI MS11870</h4>
								<p class="hidden-xs" style="color: red">396,000 VNĐ 495,000
									VNĐ</p>
								<p>Đầm body phối lưới - Mã sản phẩm: MS11870 - Giá bán:
									495.000đ - Chất liệu vải: Nhung gân phối lưới - Màu sắc: Đen -
									Chi Tiết Sản Phẩm: Dài tay 41cm - Size: XS - S - M - L - Xl -
									Chiều dài sản phẩm size S : 92Cm - Tăng "1Cm" mỗi size.</p>
							</div>
						</div>
					</td>
					<td data-th="Size" class="text-right hidden-xs">Free size</td>
					<td data-th="Price" class="text-right hidden-xs">219.000</td>

					<td data-th="Subtotal" class="text-right">199.000</td>
					<td class="actions" data-th="">
						<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa
						</button>
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá
						</button>
					</td>
				</tr>

				<tr class="item">
					<td><b>d0004</b></td>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-3 hidden-xs">
								<img src=images/img4.jpg alt="Converse"
									class="img-product img-responsive img-rounded" />
							</div>
							<div class="col-sm-9">
								<h4 class="nomargin">ĐẦM XÒE RŨ TAY LƯỚI MS11869</h4>
								<p class="hidden-xs" style="color: red">396,000 VNĐ 495,000
									VNĐ</p>
								<p>Đầm xòe rũ tay lưới - Mã sản phẩm: MS11869 - Giá bán:
									495.000đ - Chất liệu vải: Tằm ý - Màu sắc: Hồng - Chi Tiết Sản
									Phẩm: 2 lớp cả đầm, dài tay 32cm - Size: XS - S - M - L - Xl -
									Chiều dài sản phẩm size S : 90Cm - Tăng "1Cm" mỗi size.</p>
							</div>
						</div>
					</td>
					<td data-th="Size" class="text-right hidden-xs">Free size</td>
					<td data-th="Price" class="text-right hidden-xs">299.000</td>

					<td data-th="Subtotal" class="text-right">259.000</td>
					<td class="actions" data-th="">
						<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa
						</button>
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá
						</button>
					</td>
				</tr>

				<tr class="item">
					<td><b>d0005</b></td>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-3 hidden-xs">
								<img src=images/img5.jpg alt="Converse"
									class="img-product img-responsive img-rounded" />
							</div>
							<div class="col-sm-9">
								<h4 class="nomargin">YẾM 2 DÂY NÚT BỌC MS11862</h4>
								<p class="hidden-xs" style="color: red">396,000 VNĐ 495,000
									VNĐ</p>
								<p>Yếm 2 dây nút bọc - Mã sản phẩm: MS11862 - Giá bán:
									495.000đ - Chất liệu vải: Cotton thái - Màu sắc: Đen - Chi Tiết
									Sản Phẩm: 2 túi sườn, Thân trên 2 lớp - Size: XS - S - M - L -
									Xl - Chiều dài sản phẩm size S : 91Cm - Tăng "1Cm" mỗi size.</p>
							</div>
						</div>
					</td>
					<td data-th="Size" class="text-right hidden-xs">Free size</td>
					<td data-th="Price" class="text-right hidden-xs">345.000</td>

					<td data-th="Subtotal" class="text-right">309.000</td>
					<td class="actions" data-th="">
						<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa
						</button>
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá
						</button>
					</td>
				</tr>

				<tr class="item">
					<td><b>d0006</b></td>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-3 hidden-xs">
								<img src=images/img6.jpg alt="Converse"
									class="img-product img-responsive img-rounded" />
							</div>
							<div class="col-sm-9">
								<h4 class="nomargin">ĐẦM BODY CỔ PHỐI LỤA MS11855</h4>
								<p class="hidden-xs" style="color: red">220,000 VNĐ 495,000
									VNĐ</p>
								<p>Đầm body cổ phối lụa - Mã sản phẩm: MS11855 - Giá bán:
									495.000đ - Chất liệu vải: Cát hàn phối lụa - Màu sắc: Đen - Chi
									Tiết Sản Phẩm: Dài tay 25cm - Size: XS - S - M - L - Xl - Chiều
									dài sản phẩm size S : 83Cm - Tăng "1Cm" mỗi size.</p>
							</div>
						</div>
					</td>
					<td data-th="Size" class="text-right hidden-xs">Free size</td>
					<td data-th="Price" class="text-right hidden-xs">275.000</td>

					<td data-th="Subtotal" class="text-right">245.000</td>
					<td class="actions" data-th="">
						<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa
						</button>
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá
						</button>
					</td>
				</tr>

			</tbody>


		</table>
	</div>

</body>

<!-- Mirrored from dangda.azurewebsites.net/lab4-dangList.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 11 Nov 2018 13:04:42 GMT -->
</html>