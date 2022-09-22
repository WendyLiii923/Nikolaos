<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>

	<div align="left">
		<h4>
			<a href="<c:url value='/ProductService/showProducts' />">全部商品</a>
		</h4>
		<table border="1">
			<c:forEach var="category" items="${categoryList}">
				<tr>
					<td><a href="<c:url value='/ProductService/showProducts'>
 					<c:param name="categoryId" value="${category.id}"/> 
					</c:url>">
							${category.name} </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	商品們
	<div>
	
	</div>
	
	<div>
<%-- 	<a href="<c:url value='/ProductService/showCheckout' />">結帳</a> --%>
	<a>結帳</a>
	</div>

</body>
</html>