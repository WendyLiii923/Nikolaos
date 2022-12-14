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
	<%@ include file="../include/LoginModal.jsp" %>

	<div class="d-flex" style="height: calc(100vh - 56px)">
		<%@ include file="../include/Category.jsp" %>
		
		<div class="h-100 overflow-auto " style="width: calc(100% - 100px);">
			<div
				class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
				style="height: 50px; background-color: #515151">
				<h4>資料確認</h4>
			</div>
			<div class="d-flex justify-content-center px-5 pt-2">
				<div class="card shadow w-100">
					<div class="card-body">
						<div class="row" style="height: 30px;">
							<div class="col d-flex justify-content-center align-items-center">
								<p>商品圖片</p>
							</div>
							<div class="col d-flex justify-content-center align-items-center">
								<p>商品名稱</p>
							</div>
							<div class="col d-flex justify-content-center align-items-center">
								<p>數量</p>
							</div>
							<div class="col d-flex justify-content-center align-items-center">
								<p>價錢</p>
							</div>
						</div>
						<hr/>
						<c:set var="lastIndex" value="${cartInfoList.size() - 1}"/>
						<c:forEach var="cartInfo" items="${cartInfoList}" varStatus="loopStatus">
						<c:set var="isNotLastItem" value="${loopStatus.index != lastIndex}"/>
							<div class="row my-1" style="height: 150px;">
								<div class="col d-flex justify-content-center">
									<div class="overflow-hidden position-relative" style="height: 150px; width: 150px;">
										<img class="position-absolute" style="height: 150px; left: 0; top: 0;" src="${cartInfo.cover}">
									</div>
								</div>
								<div class="col d-flex justify-content-center align-items-center">
									<p>${cartInfo.name}</p>
								</div>
								<div class="col d-flex justify-content-center align-items-center">
									<p>${cartInfo.productQty}</p>
								</div>
								<div class="col d-flex justify-content-center align-items-center">
									<p>${cartInfo.price}</p>
								</div>
							</div>
							<c:if test="${isNotLastItem}">
								<hr/>
							</c:if>
						</c:forEach>
						<div class="d-flex justify-content-end align-items-center my-3" style="height: 50px; font-weight: 700;">
							<table class="table table-borderless" style="width: 400px;">
								<tbody style="font-weight: 700;">
									<tr>
										<td class="h3">運費：</td>
										<td class="h3">60</td>
									</tr>
									<tr>
										<td class="h3">應付金額總計：</td>
										<td class="h3">${totalPrice}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div
			class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
			style="height: 50px; background-color: #515151">
				<h4>收件資料</h4>
			</div>
			
			<div class="d-flex justify-content-center py-3">
				<div class="card shadow" style="width: 500px;">
				  <div class="card-body">
				  	<form action="<c:url value='/OrderService/showOrderDetail' />" method="POST" enctype="multipart/form-data">
				  	<div>
				  		<input type='hidden' name='memberId' value='${sessionScope.loginMember.id}'>
						<input type='hidden' name='shippingFee' value='60'>
						<input type='hidden' name='totalPrice' value='${totalPrice}'>
						<input type='hidden' name='memberId' value='${sessionScope.loginMember.id}'>
						<div class="form-group">
						    <label for="name">收件人名</label>
						    <input type="text" class="form-control" readonly id="name" name="name" value="${sessionScope.loginMember.name}">
						</div>
						<div class="form-group">
						    <label for="address">地址</label>
						    <input type="text" class="form-control" id="address" name="address" value="${sessionScope.loginMember.address}">
						</div>
						<div class="form-group">
						    <label for="email">Email</label>
						    <input type="text" class="form-control" id="email" name="email" placeholder="sample018@gmail.com" value="${sessionScope.loginMember.email}">
						</div>
						<div class="form-group">
						    <label for="phone">手機</label>
						    <input type="text" class="form-control" id="phone" name="phone" placeholder="09xx-xxx-xxx" value="${sessionScope.loginMember.phone}">
						</div>
						<div class="form-group">
						    <label for="payment">付款方式</label>
						    <input type="text" class="form-control" readonly id="payment" name="payment" value="信用卡">
						</div>
						<button type="submit" class="btn btn-block btn-primary mt-3">確認並送出</button>
					</div>
					</form>
				  </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>