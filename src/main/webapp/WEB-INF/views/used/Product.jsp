<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<%@ include file="../include/Header.jsp"%>
</head>
<body>
	<%@ include file="../include/TopBar.jsp"%>
	<%@ include file="../include/LoginModal.jsp" %>
	<div class="d-flex" style="height: calc(100vh - 56px)">
		<div class="h-100 p-3 border-right" style="width: 200px">
			<div class="list-group list-group-flush">
				<c:forEach var="category" items="${categoryList}">
					<tr>
						<td><a class="list-group-item list-group-item-action"
							href="<c:url value='/ProductService/showProducts'>
								<c:param name="categoryId" value="${category.id}"/>
								<c:param name="parentId" value="${category.parentId}"/>
							</c:url>">
								${category.name} </a></td>
					</tr>
				</c:forEach>
			</div>
		</div>
		<div class="h-100 overflow-hidden " style="width: calc(100% - 100px);">
			<div class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
				style="height: 50px; background-color: #515151">
				<h4>
					<a class="text-white"
						href="<c:url value='/ProductService/showProducts' />">二手拍賣</a> > 
					<a class="text-white"
						href="<c:url value='/ProductService/showProducts'>
 								<c:param name="categoryId" value="${parentCategory.id}"/>  
 								</c:url>">${parentCategory.name}</a> >  
 					<a class="text-white"  
						href="<c:url value='/ProductService/showProducts'>
								<c:param name="categoryId" value="${product.categoryId}"/>
 								<c:param name="parentId" value="${product.parentId}"/>
 								</c:url>">${product.categoryName}</a>
					> ${product.name}
				</h4>
			</div>

			<div class="d-flex">
				<div class="p-3">
					<table class="table table-striped table-bordered"
						style="table-layout: fixed;">
						<tr>
							<td>商品ID:${product.id}</td>
							<td>${product.name}</td>
							<td>${product.createTime}</td>
							<td>${product.content}</td>
							<td>賣家ID:${product.memberId}</td>
							<td>圖片：${product.cover}</td>
							<td>價格:${product.price}</td>
						</tr>
					</table>
				</div>
			</div>
			<br>
			<div align="center">
				<form action="<c:url value='/CartService/addCart' />">
					<input type="hidden" name="productId" value="${product.id}">
					<input type="hidden" name="productQty" value="1"> 
					<input type='hidden' name='memberId' value='${sessionScope.loginMember.id}'> 
					<input type="submit" value="加入購物車">
				</form>
			</div>
		</div>
	</div>
</body>
</html>