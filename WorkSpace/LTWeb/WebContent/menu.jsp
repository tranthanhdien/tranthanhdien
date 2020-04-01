<%@page import="model.MenuDAO"%>
<%@page import="model.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Menu"%>
<%@page import="model.MenuDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
<!--  
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" />
-->

</head>
<body>
	<%
		ArrayList<Menu> lstMenus = MenuDAO.getMenuList();
		for (int i = 0; i < lstMenus.size(); i++) {
			Menu menu = lstMenus.get(i);
	%>
	<ul>
		<li><a href=<%=menu.getName()%>><%=menu.getPath()%></a></li>
		<%
			}
		%>
	</ul>
</body>
</html>