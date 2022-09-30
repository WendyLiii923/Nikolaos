<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckOut</title>
<%@ include file="../include/Header.jsp"%>
</head>
<body>
	<%@ include file="../include/TopBar.jsp"%>

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
							</c:url>">${category.name} </a>
						</td>
					</tr>
				</c:forEach>
			</div>
		</div>
		<div class="h-100 overflow-auto " style="width: calc(100% - 100px);">
			<div
				class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
				style="height: 50px; background-color: #515151">
				<h4>資料確認</h4>
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
							</tr>
						</c:forEach>
					</table>
					<div align='right'>
<!-- 						<p>商品總金額: </p> -->
<!-- 						<hr> -->
						<h5>
						運費: 60<br>
						應付金額總計: ${totalPrice}
						</h5>
					</div>
				</div>
			</div>

			<div
			class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
			style="height: 50px; background-color: #515151">
				<h4>收件資料</h4>
			</div>
			<div class="d-flex">
				<div class="p-3">
					<p>收件人名: ${sessionScope.loginMember.name}</p>

					<form action="<c:url value='/OrderService/showOrderDetail' />">
					<input type='hidden' name='memberId' value='${sessionScope.loginMember.id}'>
						<label>address: </label> 
						<input type='text' name='address' value='${address}' placeholder="地址">
						<br><br>
						<label>email: </label> 
						<input type='text' name='email' value='${email}' placeholder="sample018@gmail.com">
						<br><br> 
						<label>phone: </label> <input type='text' name='phone' value='${phone}' placeholder="09xx-xxx-xxx">
						<br><br> 
						<label>付款方式: 信用卡</label> 
						<input type='hidden' name='shippingFee' value='60'>
						<input type='hidden' name='totalPrice' value='${totalPrice}'>
						<button type="submit">確認並送出</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>