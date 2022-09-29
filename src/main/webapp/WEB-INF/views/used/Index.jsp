<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<%@ include file="../include/Header.jsp"%>
</head>
<body>
	<%@ include file="../include/TopBar.jsp"%>
	<%@ include file="../include/LoginModal.jsp" %>
	<div>
		<a href="<c:url value='/ProductService/showProducts' />">二手商品頁</a><br>

		<a href="<c:url value='/ProductService/showUploadForm' />">上架商品</a><br>
		
		<a href="<c:url value='/ProductService/showMemberProducts' >
			<c:param name='memberId' value='${sessionScope.loginMember.id}' />
		</c:url>">會員商品管理區</a><br>
	</div>

</body>
</html>