<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
</head>
<body>

	<div align="left">
		<h3>分類</h3>
		<h4>
			<a href="<c:url value='/ProductService/showProducts' />">全部商品</a>
		</h4>
		<table border="1">
			<c:forEach var="category" items="${categoryList}">
				<tr>
					<td><a
						href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${category.id}"/>
					<c:param name="parentId" value="${category.parentId}"/>
					</c:url>">
							${category.name} </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
	<h3>
		<a href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${category.id}"/>
					<c:param name="parentId" value="${category.parentId}"/>
					<c:param name="status" value="新到舊"/>
				</c:url>">新到舊
		</a> | 
		<a href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${category.id}"/>
					<c:param name="parentId" value="${category.parentId}"/>
					<c:param name="status" value="舊到新"/>
				</c:url>">舊到新
		</a> | 
		
		<a href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${category.id}"/>
					<c:param name="parentId" value="${category.parentId}"/>
					<c:param name="status" value="低到高"/>
				</c:url>">低到高
		</a> | 
		
		<a href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${category.id}"/>
					<c:param name="parentId" value="${category.parentId}"/>
					<c:param name="status" value="高到低"/>
				</c:url>">高到低
		</a><br>
	</h3>
		<form action="<c:url value='/ProductService/showProducts' />" method="GET">
			<input type="hidden" name="categoryId" value="${category.id}" >
			<input type="hidden" name="parentId" value="${category.parentId}" >
			<input type="hidden" name='status'  value='價格區間' >
    		最低價:<input type='text' name='start'  value='${start}' >
  			最高價:<input type='text' name='end'  value='${end}' >
  			<input type="submit" value="確定"><P/>
		</form>
		
		<table border="1">
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>商品圖片${product.cover}</td>
				<td><a href="<c:url value='/ProductService/showProduct'>
					<c:param name="productId" value="${product.id}"/>
					</c:url>">${product.name}
					</a></td>
				<td>價格: ${product.price}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>