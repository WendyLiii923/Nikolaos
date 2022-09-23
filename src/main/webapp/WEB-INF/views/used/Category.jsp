<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
<%@ include file="../include/Header.jsp" %>
</head>
<body>
<%@ include file="../include/TopBar.jsp" %>

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
	<div class="h-100 overflow-hidden " style="width: calc(100% - 100px);">
		<div class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2" 
			 style="height: 50px; background-color: #515151">
			<div>
				<a class="text-white" href="<c:url value='/ProductService/showProducts'>
					<c:param name="categoryId" value="${category.id}"/>
					<c:param name="parentId" value="${category.parentId}"/>
					<c:param name="status" value="新到舊"/>
				</c:url>">新到舊
				</a> | 
				<a class="text-white" href="<c:url value='/ProductService/showProducts'>
							<c:param name="categoryId" value="${category.id}"/>
							<c:param name="parentId" value="${category.parentId}"/>
							<c:param name="status" value="舊到新"/>
						</c:url>">舊到新
				</a> | 
				
				<a class="text-white" href="<c:url value='/ProductService/showProducts'>
							<c:param name="categoryId" value="${category.id}"/>
							<c:param name="parentId" value="${category.parentId}"/>
							<c:param name="status" value="低到高"/>
						</c:url>">低到高
				</a> | 
				
				<a class="text-white" href="<c:url value='/ProductService/showProducts'>
							<c:param name="categoryId" value="${category.id}"/>
							<c:param name="parentId" value="${category.parentId}"/>
							<c:param name="status" value="高到低"/>
						</c:url>">高到低
				</a>
			</div>
			<div>
				<i class="fa fa-2x fa-th-large mr-3 " aria-hidden="true"></i>
				<i class="fa fa-2x fa-th-list" aria-hidden="true"></i>
			</div>
		</div>
		<div class="w-100 m-3">
			<table class="table table-striped table-bordered w-100">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">圖片</th>
			      <th scope="col">商品名稱</th>
			      <th scope="col">價格</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="product" items="${productList}" varStatus="status">
			    <tr>
			    	<td>${status.index}</td>
			        <td>${product.cover}</td>
				    <td>
				    	<a href="<c:url value='/ProductService/showProduct'>
						<c:param name="productId" value="${product.id}"/>
						</c:url>">${product.name}
						</a></td>
					<td>${product.price}</td>
			    </tr>
		      </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>