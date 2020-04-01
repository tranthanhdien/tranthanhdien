<%@page import="model.ItemCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/boostrap_Cart.css">
</head>
<body>

	<%
		ShoppingCart shop = null;
	ArrayList<ItemCart> listItem = null;
		if (session.getAttribute("shopping") == null) {
	%>
	<!-- chuyen toi trang -->
	<jsp:forward page="login.jsp"></jsp:forward>

	<%
		} else {
			shop = (ShoppingCart) session.getAttribute("shopping");
			listItem = shop.getListCart();
		}
	%>
	<h2>
		Gio hang cua:
		<%=shop.getCustomer().getName()%></h2>
	<table style="width: 100%;">
		<tr>
			<th style="width: 20%;">MaSP</th>
			<th style="width: 30%;">Ten</th>
			<th style="width: 30%;">So luong</th>
			<th style="width: 10%;">Price</th>
			<th style="width: 10%;">action</th>
		<tr>
			<%
				for (int j = 0; j < listItem.size(); j++) {
					ItemCart i = listItem.get(j);
			%>
		
		<tr>
			<td><%=i.getP().getId()%></td>
			<td><%=i.getP().getName()%></td>
			<td><a href="Control?action=giam&index=<%=j%>"><button>-</button></a><input
				type="text" value="<%=i.getQuantity()%> "><a
				href="Control?action=tang&index=<%=j%>"><button>+</button></a></td>
			<td><%=i.price()%>
			<td><A href="Control?action=deleteCart&index=<%=j%>"><button
						class="btn btn-success">Xoa</button></A></td>
		</tr>
		<%
			}
		%>

		<%
			if (listItem.size() == 0) {
		%>
		<tr>
			<td colspan="5" style="text-align: center"><a>Khong co du
					lieu</a></td>
		</tr>
		<%
			}
		%>

		<tr>
			<td colspan="5">Tong gia: <%=shop.totalPrice()%></td>
		</tr>
	</table>
	<a href="index.jsp"><button class="btn btn-danger">Tiep
			tuc mua San pham</button></a>
	<a href="Control?action=logout"><button class="btn btn-primary">Log
			out</button></a>

</body>
</html>