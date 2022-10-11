<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<%@ include file="../include/Category.jsp" %>
		
		<div class="h-100 overflow-hidden " style="width: calc(100% - 100px);">
			<div class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
				style="height: 50px; background-color: #515151">
				<h4>
					<a class="text-white"
						href="<c:url value='/used' />">二手拍賣</a> > 
					<a class="text-white"
						href="<c:url value='/used'>
 								<c:param name="categoryId" value="${parentCategory.id}"/>  
 								</c:url>">${parentCategory.name}</a> >  
 					<a class="text-white"  
						href="<c:url value='/used'>
								<c:param name="categoryId" value="${product.categoryId}"/>
 								<c:param name="parentId" value="${product.parentId}"/>
 								</c:url>">${product.categoryName}</a>
					> ${product.name}
				</h4>
			</div>

			<div class="d-flex justify-content-center pt-5 px-5">
				<div class="card shadow w-100">
				  <div class="card-body">
				  	<div class="row" style="height: 300px;">
				  		<div class="col-4 p-3 px-4">
				  			<div class="overflow-hidden position-relative" style="height: 100%; width: 100%;">
								<img class="position-absolute" style="height: 100%; left: 0; top: 0;" src="${product.cover}">
							</div>
				  		</div>
				  		<div class="col-8 p-3 px-4">
				  			<h3 style="font-weight: 700;">${product.name}</h3>
				  			<h4>$${product.price}</h4>
	  						<p>
	  							上架時間：${product.createTime}
	  						</p>
				  		</div>
				  	</div>
				  	<hr/>
				  	<p>
				  		${product.content}
				  	</p>
				  	<c:if test="${not empty sessionScope.loginMember}">
						<div class="d-flex justify-content-center">
							<div style="width: 150px">
								<button class="btn btn-warning " onclick="addCollect(${product.id})">加入收藏</button>
							</div>
							<div style="width: 150px">
								<button class="btn btn-primary " onclick="addToCart(${product.id})">加入購物車</button>
							</div>
						</div>
					</c:if>
				  </div>
			  	</div>
		  	</div>
		</div>
	</div>
</body>
<script>
	function addCollect(productId){
		fetch('/nikolaos/CollectService/add?productId='+productId,
			{
				method: 'POST',
				headers: {'Content-Type': 'application/json'},
			}
		).then(res => {
			return res.json()
		}).then(result => {
			Object.keys(result).forEach(function(key, index) {
				let msg = result[key];
				window.alert(msg);
			});
		})
	}
	
	function addToCart(productId) {
		console.log('this is log' + productId);
		fetch('/nikolaos/CartService/addCart?productId=' + productId,
			{
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
			}
		).then(res => {
			return res.json()
		}).then(result => {
			Object.keys(result).forEach(function (key, index) {
				let msg = result[key];
				window.alert(msg);
			});
		})
	}
</script>
</html>