<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
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
	<h4>訂單</h4>
	<div>
		<table border="1">
			<c:forEach var="orderDetail" items="${orderDetailList}">
				<tr>
					<td>productId: ${orderDetail.productId}</td>
					<td>productQty: ${orderDetail.productQty}</td>
					<td>price: ${orderDetail.productId.price}</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
	<div>
		<form action="<c:url value='/OrderService/showOrderList' />">
				<input type="hidden" name="productId" value="${product.id}" >
				<input type="hidden" name="productQty" value="1" >
				<input type='hidden' name='memberId'  value='1' >
				<input type="submit" value="確認並送出"><P/>
		</form>
	</div>

</body>
</html>