<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Category</title>
<%@ include file="../include/Header.jsp" %>
</head>

<body>
<%@ include file="../include/TopBar.jsp" %>
<%@ include file="../include/LoginModal.jsp" %>

	
<div class="d-flex" style="height: calc(100vh - 56px)">
<%@ include file="../include/Category.jsp" %>
	
	<div class="h-100 overflow-auto" style="width: calc(100% - 100px);">
		<div class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
			style="height: 50px; background-color: #515151">
			<div>
				<a class="text-white" href="<c:url value='/used'>
				<c:param name="categoryId" value="${category.id}" />
				<c:param name="parentId" value="${category.parentId}" />
				<c:param name="status" value="新到舊" />
				</c:url>">新到舊
				</a> | <a class="text-white" href="<c:url value='/used'>
				<c:param name="categoryId" value="${category.id}" />
				<c:param name="parentId" value="${category.parentId}" />
				<c:param name="status" value="舊到新" />
				</c:url>">舊到新
				</a> | <a class="text-white" href="<c:url value='/used'>
				<c:param name="categoryId" value="${category.id}" />
				<c:param name="parentId" value="${category.parentId}" />
				<c:param name="status" value="低到高" />
				</c:url>">低到高
				</a> | <a class="text-white" href="<c:url value='/used'>
				<c:param name="categoryId" value="${category.id}" />
				<c:param name="parentId" value="${category.parentId}" />
				<c:param name="status" value="高到低" />
				</c:url>">高到低
				</a>
			</div>
			<div class="d-flex align-items-center">
				價格區間：
				<form class="d-flex" action="<c:url value='/used' />" method="GET">
					<input type="hidden" name="categoryId" value="${category.id}">
					<input type="hidden" name="parentId" value="${category.parentId}">
					<input type="hidden" name='status' value='價格區間'> <input type='text'
						style="width: 80px;" name='start' value='${start}' placeholder="最低價"> 
						<span style="line-height: 35px">~</span>
					<input type='text' style="width: 80px;" name='end' value='${end}'
						placeholder="最高價"> <input type="submit" class="d-none" value="確定">
					<P />
				</form>
			</div>

			<div>
				<c:set var="q" value="${pageContext.request.queryString}" scope="page" />
				<a class="text-white mx-2" href='<c:url value="/used?${q.contains('&type') ?
					q.substring(0,q.indexOf('&type')) : q}&type=card" />'>
				<i class="fa fa-2x fa-th-large mr-3 " aria-hidden="true"></i>
				</a> 
				<a class="text-white mx-2" href='<c:url value="/used?${q.contains('&type') ?
					q.substring(0,q.indexOf('&type')) : q}&type=list" />'>
				<i class="fa fa-2x fa-th-list" aria-hidden="true"></i>
				</a>
			</div>
		</div>
		<div class="d-flex">
			<div class="p-3 w-100">
				<c:if test="${empty param.type or param.type == 'list'}">
					<c:forEach var="product" items="${productList}">
						<div class="d-flex shadow rounded p-2 mb-3"
							style="background-color: #f8f9fa !important">
							<div class="overflow-hidden position-relative"
								style="height: 150px; width: 150px;">
								<img class="position-absolute"
									style="height: 150px; left: 0; top: 0;" src="${product.cover}">
							</div>
							<div class="pl-3 px-3" style="height: 150px; width: calc(100% - 300px);">
								<h4 style="font-weight: 700">
									<a href="
					<c:url value='/ProductService/showProduct'>
						<c:param name="productId" value="${product.id}" />
									</c:url>">${product.name}
									</a>
								</h4>
								<p>${product.content}</p>
							</div>
							<div class="pr-5" style="height: 150px; width: 150px;">
								<div class="row mt-1">
									<h4>價錢：$${product.price}</h4>
								</div>
								<c:if test="${not empty sessionScope.loginMember}">
									<div class="row mt-2">
										<button class="btn btn-warning w-100"
											onclick="addCollect(${product.id})">加入收藏</button>
									</div>
									<div class="row mt-2">
										<button class="btn btn-primary w-100"
											onclick="addToCart(${product.id})">加入購物車</button>
									</div>
								</c:if>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${param.type == 'card'}">
					<c:set var="rowCount" value="${productList.size() / 4}" />
					<c:set var="maxIndex" value="${productList.size() - 1}" />
					<c:forEach begin="0" step="4" end="${4 * rowCount}" varStatus="loopStatus">
						<div class="d-flex">
							<c:forEach begin="${loopStatus.index}"
								end="${loopStatus.index + 3 > maxIndex ? maxIndex : loopStatus.index + 3}"
								varStatus="innerLoopStatus">
								<c:set var="product"
									value="${productList.get(innerLoopStatus.index)}" />
								<div class="w-25 p-3">
									<div class="card shadow">
										<div class="card-body">
											<div class="w-100 d-flex justify-content-center"
												style="height: 150px">
												<div class="overflow-hidden position-relative"
													style="height: 150px; width: 150px;">
													<img class="position-absolute"
														style="height: 150px; left: 0; top: 0;"
														src="${product.cover}">
												</div>
											</div>
											<div class="w-100 mt-3 px-3">
												<h4 style="font-weight: 700">
													<a href="
									<c:url value='/ProductService/showProduct'>
										<c:param name="productId" value="${product.id}" />
													</c:url>">${product.name}
													</a> <span style="font-weight: 400;"> -
														$${product.price}</span>
												</h4>
												<p>${product.content}</p>
											</div>
											<c:if test="${not empty sessionScope.loginMember}">
												<div class="w-100 d-flex mt-2">
													<div class="w-50 pr-1">
														<button class="btn btn-warning w-100"
															onclick="addCollect(${product.id})">加入收藏</button>
													</div>
													<div class="w-50 pl-1">
														<button class="btn btn-primary w-100"
															onclick="addToCart(${product.id})">加入購物車</button>
													</div>
												</div>
											</c:if>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<br />
					</c:forEach>

				</c:if>
			</div>
		</div>
	</div>
</div>
<script>
	function addCollect(productId) {
		fetch(`/nikolaos/CollectService/add?productId=\${productId}`)
		.then(res => {
			return res.json()
		}).then(result => {
			Object.keys(result).forEach(function (key, index) {
				let msg = result[key];
				window.alert(msg);
			});
		})
	}

	function addToCart(productId) {
		console.log('this is log' + productId);
		fetch(`/nikolaos/CartService/addCart?productId=\${productId}`)
		.then(res => {
			return res.json()
		}).then(result => {
			Object.keys(result).forEach(function (key, index) {
				let msg = result[key];
				window.alert(msg);
			});
		})
	}
</script>

</body>

</html>