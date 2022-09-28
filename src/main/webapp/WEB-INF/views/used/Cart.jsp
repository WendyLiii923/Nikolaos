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
		<div class="h-100 overflow-auto " style="width: calc(100% - 100px);">
			<div
				class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
				style="height: 50px; background-color: #515151">
				<h4>購物車內的商品們</h4>
			</div>
			<div class="d-flex">
				<div class="p-3">
					<table class="table table-striped table-bordered"
						style="table-layout: fixed;">
						<c:forEach var="cartInfo" items="${cartInfoList}">
						<tr>
							<td>productId: ${cartInfo.productId}</td>
							<td>${cartInfo.name}</td>
							<td>productQty: ${cartInfo.productQty}</td>
							<td>price: ${cartInfo.price}</td>
							<td><a 
							href="<c:url value='/CartService/removeFromCart'>
							<c:param name="memberId" value='1'/>
							<c:param name="productId" value="${cartInfo.productId}"/>
							</c:url>">
							移除
							</a></td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div align = 'center'>
				<form action="<c:url value='/CartService/showCheckOut' />">
					<input type='hidden' name='memberId' value='1'> 
					<input type="submit" value="前往結帳">
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>