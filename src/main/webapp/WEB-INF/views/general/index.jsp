<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
<%@ include file="../include/Header.jsp"%>
</head>
<body>
	<%@ include file="../include/TopBar.jsp"%>
	
<!-- 登入功能 -->
	<%@ include file="../include/LoginModal.jsp" %>

	<a href="<c:url value='/used' />">二手商品頁</a><br>

</body>
</html>