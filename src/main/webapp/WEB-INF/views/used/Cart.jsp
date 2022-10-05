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
							href="<c:url value='/used'>
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
			<div class="d-flex justify-content-center p-5">
				<div class="card shadow w-100">
					<div class="card-body">
					<c:set var="isCartEmpty" value="${cartInfoList.isEmpty()}"/>
					<c:choose>
						<c:when test="${isCartEmpty}">
							<div class="d-flex justify-content-center">
								<h3>購物車內尚無商品，請繼續選購！</h3>
							</div>
						</c:when>
						<c:otherwise>
							<div class="row" style="height: 30px;">
								<div class="col-3 d-flex justify-content-center align-items-center">
									<p>商品圖片</p>
								</div>
								<div class="col-3 d-flex justify-content-center align-items-center">
									<p>商品名稱</p>
								</div>
								<div class="col-2 d-flex justify-content-center align-items-center">
									<p>數量</p>
								</div>
								<div class="col-2 d-flex justify-content-center align-items-center">
									<p>價錢</p>
								</div>
								<div class="col-2 d-flex justify-content-center align-items-center">
									<p>操作</p>
								</div>
							</div>
							<hr/>
							<c:set var="lastIndex" value="${cartInfoList.size() - 1}"/>
							<c:forEach var="cartInfo" items="${cartInfoList}" varStatus="loopStatus">
							<c:set var="isNotLastItem" value="${loopStatus.index != lastIndex}"/>
								<div class="row my-1" style="height: 150px;">
									<div class="col-3 d-flex justify-content-center">
										<div class="overflow-hidden position-relative" style="height: 150px; width: 150px;">
											<img class="position-absolute" style="height: 150px; left: 0; top: 0;" src="${cartInfo.cover}">
										</div>
									</div>
									<div class="col-3 d-flex justify-content-center align-items-center">
										<p>${cartInfo.name}</p>
									</div>
									<div class="col-2 d-flex justify-content-center align-items-center">
										<p>${cartInfo.productQty}</p>
									</div>
									<div class="col-2 d-flex justify-content-center align-items-center">
										<p>${cartInfo.price}</p>
									</div>
									<div class="col-2 d-flex justify-content-center align-items-center">
										<a class="btn btn-danger" href="
											<c:url value='/CartService/removeFromCart'>
												<c:param name="memberId" value='${sessionScope.loginMember.id}'/>
												<c:param name="productId" value="${cartInfo.productId}"/>
											</c:url>">
										移除
										</a>
									</div>
								</div>
								<c:if test="${isNotLastItem}">
									<hr/>
								</c:if>
							</c:forEach>
							<div class="d-flex justify-content-center">
								<form action="<c:url value='/CartService/showCheckOut' />">
									<input type='hidden' name='memberId' value='${sessionScope.loginMember.id}'> 
									<input type="submit" class="btn btn-primary" value="前往結帳">
								</form>
							</div>
						</c:otherwise>
					</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>