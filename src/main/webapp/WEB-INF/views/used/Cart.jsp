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
 					<c:param name="parentId" value="${category.parentId}"/>
					</c:url>">
							${category.name} </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<h4>購物車內的商品們</h4>
	<div>
		<table border="1">
			<c:forEach var="cartDetail" items="${cartDetailList}">
				<tr>
					<td>productId: ${cartDetail.productId}</td>
					<td>productQty: ${cartDetail.productQty}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<form action="<c:url value='/OrderService/showOrder' />">
				<input type="hidden" name="cartId" value="${cartId}" >
				<input type="hidden" name="orderId" value="${orderId}" >
				<input type='hidden' name='memberId'  value='1' >
				<input type="submit" value="結帳"><P/>
	</form>

</body>
</html>