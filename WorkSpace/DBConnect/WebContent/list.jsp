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
									<h4 class="nomargin">Váy...</h4>
									<p class="hidden-xs">abc...</p>
								</div>
							</div>
						</td>
						<td data-th="Size" class="text-right hidden-xs">Free size</td>
						<td data-th="Price" class="text-right hidden-xs">275.000</td>

						<td data-th="Subtotal" class="text-right">239.000</td>
						<td class="actions" data-th="">
							<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</button>
							<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá</button>
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
									<h4 class="nomargin">Váy...</h4>
									<p class="hidden-xs">abc...</p>
								</div>
							</div>
						</td>
						<td data-th="Size" class="text-right hidden-xs">Free size</td>
						<td data-th="Price" class="text-right hidden-xs">358.000</td>

						<td data-th="Subtotal" class="text-right">338.000</td>
						<td class="actions" data-th="">
							<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</button>
							<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá</button>
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
									<h4 class="nomargin">Váy...</h4>
									<p class="hidden-xs">abc...</p>
								</div>
							</div>
						</td>
						<td data-th="Size" class="text-right hidden-xs">Free size</td>
						<td data-th="Price" class="text-right hidden-xs">219.000</td>

						<td data-th="Subtotal" class="text-right">199.000</td>
						<td class="actions" data-th="">
							<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</button>
							<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá</button>
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
									<h4 class="nomargin">Váy...</h4>
									<p class="hidden-xs">abc...</p>
								</div>
							</div>
						</td>
						<td data-th="Size" class="text-right hidden-xs">Free size</td>
						<td data-th="Price" class="text-right hidden-xs">299.000</td>

						<td data-th="Subtotal" class="text-right">259.000</td>
						<td class="actions" data-th="">
						<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</button>
							<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá</button>
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
									<h4 class="nomargin">Váy...</h4>
									<p class="hidden-xs">abc...</p>
								</div>
							</div>
						</td>
						<td data-th="Size" class="text-right hidden-xs">Free size</td>
						<td data-th="Price" class="text-right hidden-xs">345.000</td>

						<td data-th="Subtotal" class="text-right">309.000</td>
						<td class="actions" data-th="">
							<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</button>
							<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá</button>
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
									<h4 class="nomargin">Váy...</h4>
									<p class="hidden-xs">abc...</p>
								</div>
							</div>
						</td>
						<td data-th="Size" class="text-right hidden-xs">Free size</td>
						<td data-th="Price" class="text-right hidden-xs">275.000</td>

						<td data-th="Subtotal" class="text-right">245.000</td>
						<td class="actions" data-th="">
							<button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</button>
							<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp;Xoá</button>
						</td>
					</tr>
					
				</tbody>


			</table>
		</div>

</body>

<!-- Mirrored from dangda.azurewebsites.net/lab4-dangList.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 11 Nov 2018 13:04:42 GMT -->
</html>