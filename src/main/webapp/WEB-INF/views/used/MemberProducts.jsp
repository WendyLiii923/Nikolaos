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
	<%@ include file="../include/Category.jsp" %>
	
	<div class="h-100 overflow-auto " style="width: calc(100% - 100px);">
		<div class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2" 
			 style="height: 50px; background-color: #515151">
				<h4>管理二手商品區</h4>
		</div>

		<div class="d-flex mx-3">
			<a class="btn btn-primary" href="<c:url value='/ProductService/showUploadForm'/>">上架商品</a>
		</div>

		<div class="d-flex">
			<div class="p-3 w-100">
				<c:forEach var="product" items="${productList}">
					<div class="d-flex shadow rounded p-2 mb-3" style="background-color: #f8f9fa!important">
						<div class="overflow-hidden position-relative" style="height: 150px; width: 150px;">
							<img class="position-absolute" style="height: 150px; left: 0; top: 0;" src="${product.cover}">
						</div>
						<div class="pl-3 px-3" style="height: 150px; width: calc(100% - 300px);">
							<h4 style="font-weight: 700">
								<a href="
										<c:url value='/ProductService/showProduct'>
											<c:param name="productId" value="${product.id}"/>
										</c:url>">${product.name}
								</a>
							</h4>
							<p>${product.content}</p>
						</div>
						<div class="pr-5" style="height: 150px; width: 150px;">
							<div class="row mt-1">
								<h4>
									價錢：$${product.price}
								</h4>
							</div>
							<c:if test="${not empty sessionScope.loginMember}">
								<div class="row mt-2">
									<button class="btn btn-warning w-100" onclick="updateProduct(${product.id})">修改商品</button>
								</div>
								<div class="row mt-2">
									<button class="btn btn-danger w-100" onclick="deleteProduct(${sessionScope.loginMember.id},${product.id})">下架商品</button>
								</div>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
</body>
<script>
	function updateProduct(productId){
		window.location.href='/nikolaos/ProductService/showUpdateForm?productId='+productId
	}

	function deleteProduct(memberId, productId){
		window.location.href='/nikolaos/ProductService/deleteProduct?productId='+productId+'&memberId='+memberId
	}
</script>
</html>