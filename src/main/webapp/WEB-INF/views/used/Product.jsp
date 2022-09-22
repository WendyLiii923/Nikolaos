<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
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
					</c:url>">${category.name} </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<h4>
			<a href="<c:url value='/ProductService/showProducts' />">二手拍賣</a>
			>
			<a href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${parentCategory.id}"/>
					</c:url>">${parentCategory.name}</a>
			>
			<a href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${product.category.id}"/>
					<c:param name="parentId" value="${product.category.parentId}"/>
					</c:url>">${product.category.name}</a>
			>
			${product.name}
		</h4>
		<table border="1">
			<tr>
				<td>商品ID:${product.id}</td>
				<td>${product.createTime}</td>
				<td>${product.content}</td>
				<td>賣家ID:${product.member.id}</td>
				<td>分類:${product.category.name}</td>
				<td>圖片：${product.cover}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
			</tr>
		</table>
		<a href="<c:url value='/ProductService/showCart' >
					<c:param name="productId" value="${product.id}"/>
				</c:url>">加入購物車</a>
	</div>
</body>
</html>