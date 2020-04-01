
<%@page import="model_DAO.Data"%>
<%@page import="model_DAO.DataDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Test</title>
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

#khung {
	border: 1px solid #cccccc;
	margin-left: 5%;
	width: 90%;
}
</style>
</head>
<body>
	<%
		ArrayList<Data> listData = DataDAO.getListData();
	%>
	<div id="khung">
		<h1 style="text-align: center">Thông Tin Dữ Liệu</h1>
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
							<i class="glyphicon glyphicon-plus"></i>&nbsp;Thêm mới
						</button>
						
						<button type="button" class="btn btn-primary" id='btn'
							onclick='printFunc();'>
							<i class="glyphicon glyphicon-print"></i>&nbsp;In
						</button>
					</div>
				</div>
			</form>
		</div>

		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th title="Số thứ tự">Mã KH</th>
						<th title="Mã nhân viên">Mã HĐ</th>
						<th>Tên đăng nhập</th>
						<th>Mật khẩu</th>
						<th>Địa chỉ</th>
						<th>Email</th>
						<th>Ngày lập HĐ</th>
						<th>Tổng</th>
					</tr>
					<%
						for (int i = 0; i < listData.size(); i++) {
							Data data = listData.get(i);
					%>
				</thead>
				<tbody>

					<tr>
						<td><%=data.getIdUser()%>
						<td><%=data.getIdInvoice()%>
						<td><%=data.getUsername()%>
						<td><%=data.getPassword()%>
						<td><%=data.getAddress()%>
						<td><%=data.getEmail()%>
						<td><%=data.getDate()%>
						<td><%=data.getAmount()%>
						<td><a href="#"><button type="button"
									class="btn btn-info">
									<span class="glyphicon glyphicon-info-sign"></span>
								</button></a> <a href="editEmployee.jsp"><button type="button"
									class="btn btn-primary">
									<span class="glyphicon glyphicon-edit"></span>
								</button></a> <a href="ServletXoaEmp?no=<%=i%>"><button type="button"
									class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button></a>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	<br>
	<br>
	<!-- dinh dang trang in -->
	<div style="display: none;">
		<div id='printarea'>
			<table>
				<tr>
					<th style="width: 5%">Mã KH</th>
					<th style="width: 10%">Mã HĐ</th>
					<th style="width: 20%">Tên đăng nhập</th>
					<th style="width: 10%">Mật khẩu</th>
					<th style="width: 10%">Địa chỉ</th>
					<th style="width: 10%">Email</th>
					<th style="width: 10%">Ngày lập HĐ</th>
					<th style="width: 10%">Tổng</th>
				</tr>
				<%
					
				for (int i = 0; i < listData.size(); i++) {
					Data data = listData.get(i);
				%>
				<tr>
					
					<td style="text-align: center"><%=data.getIdUser()%></td>
					<td style="text-align: center"><%=data.getIdInvoice()%></td>
					<td style="text-align: center"><%=data.getUsername()%></td>
					<td style="text-align: center"><%=data.getPassword()%></td>
					<td style="text-align: center"><%=data.getAddress()%></td>
					<td style="text-align: center"><%=data.getEmail()%></td>
					<td style="text-align: center"><%=data.getDate()%></td>
					<td style="text-align: center"><%=data.getAmount()%></td>
					
				</tr>
				<%
					
					}
				%>
			</table>
		</div>
	</div>
	<!-- in trang web -->
	<script>
		function printFunc() {
			var divToPrint = document.getElementById('printarea');
			var htmlToPrint = '' + '<style type="text/css">'
					+ 'table th, table td {' + 'border:1px solid #000;'
					+ 'padding;0.5em;' + '}' + '</style>';
			htmlToPrint += divToPrint.outerHTML;
			newWin = window.open("");
			newWin.document
					.write("<h3 align='center'>DANH SÁCH KHÁCH HÀNG</h3>");
			newWin.document.write(htmlToPrint);
			newWin.print();
			newWin.close();
		}
	</script>
</body>
</html>