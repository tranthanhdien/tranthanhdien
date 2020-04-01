
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>

	<c:choose>
		<c:when test="${sessionScope.language == 'VN' }">
			<fmt:setBundle basename="bundle.demoResource_vn_VN" var="resourcebundle" />
		</c:when>
		<c:when test="${sessionScope.language == 'EN' }">
		
			<fmt:setBundle basename="bundle.demoResource_en_US" var="resourcebundle" />
		</c:when>
		<c:otherwise>
			<fmt:setBundle basename="bundle.demoResource_vn_VN" var="resourcebundle" />
		</c:otherwise>
	</c:choose>

	<br>
	<a><fmt:message key="login" bundle="${resourcebundle}" /></a>
</body>
</html>