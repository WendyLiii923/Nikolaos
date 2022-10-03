<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberProducts</title>
<%@ include file="../include/Header.jsp" %>
</head>
<body>
<%@ include file="../include/TopBar.jsp" %>
<%@ include file="../include/LoginModal.jsp" %>
<div class="d-flex" style="height: calc(100vh - 56px)">
	<div class="h-100 p-3 border-right" style="width: 200px">
		<div class="list-group list-group-flush">
		<c:forEach var="category" items="${categoryList}">
			<tr>
				<td>
					<a class="list-group-item list-group-item-action"
						href="<c:url value='/ProductService/showProducts'>
								<c:param name="categoryId" value="${category.id}"/>
								<c:param name="parentId" value="${category.parentId}"/>
							</c:url>">
						${category.name} </a>
				</td>
			</tr>
		</c:forEach>
		</div>
	</div>
	<div class="h-100 overflow-auto " style="width: calc(100% - 100px);">
		<div class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2" 
			 style="height: 50px; background-color: #515151">
				<h4>管理二手商品區</h4>
		</div>

		<div class="d-flex">
			<div class="p-3">
				<table class="table table-striped table-bordered" style="table-layout: fixed;">
				  <thead>
				    <tr>
				      <th scope="col" style="width: 50px">#</th>
				      <th scope="col">圖片</th>
				      <th scope="col">商品名稱</th>
				      <th scope="col">價格</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="product" items="${productList}" varStatus="status">
				    <tr>
				    	<td>${status.index + 1}</td>
				        <td><img class="bd-placeholder-img card-img-top" 
				  			width="100%" height="225"
				  			src="${product.cover}"></td>
					    <td>
					    	<a href="<c:url value='/ProductService/showProduct'>
							<c:param name="productId" value="${product.id}" />
							</c:url>">${product.name}
							</a></td>
						<td>${product.price}</td>
						<td><a 
							href="<c:url value='/ProductService/showUpdateForm'>
							<c:param name="memberId" value='${sessionScope.loginMember.id}'/>
							<c:param name="productId" value="${product.id}"/>
							</c:url>">
							修改
							</a></td>
						<td><a 
							href="<c:url value='/ProductService/deleteProduct'>
							<c:param name="memberId" value='${sessionScope.loginMember.id}'/>
							<c:param name="productId" value="${product.id}"/>
							</c:url>">
							下架
							</a></td>
				    </tr>
			      </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>