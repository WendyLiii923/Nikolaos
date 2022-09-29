<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
	<div>
		<a href="<c:url value='/ProductService/showProducts' />">二手商品頁</a><br>

		<a href="<c:url value='/ProductService/showUploadForm' />">上架商品</a><br>
		
		<a href="<c:url value='/ProductService/showMemberProducts' >
			<c:param name='memberId' value='1' />
		</c:url>">會員商品管理區</a><br>
	</div>

</body>
</html>