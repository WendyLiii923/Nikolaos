<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderDetail</title>
<%@ include file="../include/Header.jsp"%>
</head>
<body>
	<%@ include file="../include/TopBar.jsp"%>
	<%@ include file="../include/LoginModal.jsp"%>
	<div class="d-flex" style="height: calc(100vh - 56px)">

		<%@ include file="../include/Category.jsp"%>

		<div class="h-100 overflow-auto " style="width: calc(100% - 100px);">
			<div
				class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2"
				style="height: 50px; background-color: #515151">
				<h4>訂單詳情</h4>
			</div>
			<div class="d-flex">
				<div class="p-3">
					<table class="table table-striped table-bordered"
						style="table-layout: fixed;">
						<c:forEach var="orderInfo" items="${orderInfoList}" varStatus="loopStatus">
							<c:set var="isNotLastItem" value="${loopStatus.index != lastIndex}" />
							<div class="row my-1" style="height: 150px;">
								<div class="col-3 d-flex justify-content-center">
									<div class="overflow-hidden position-relative"
										style="height: 150px; width: 150px;">
										<img class="position-absolute" style="height: 150px; left: 0; top: 0;"
											src="${orderInfo.cover}">
									</div>
								</div>
								<div
									class="col-3 d-flex justify-content-center align-items-center">
									<p>${orderInfo.name}</p>
								</div>
								<div
									class="col-2 d-flex justify-content-center align-items-center">
									<p>${orderInfo.productQty}</p>
								</div>
								<div
									class="col-2 d-flex justify-content-center align-items-center">
									<p>${orderInfo.price}</p>
								</div>
							</div>
							<c:if test="${isNotLastItem}">
								<hr />
							</c:if>
						</c:forEach>
					</table>
					<div align='left'>
						<h5>訂單金額: ${order.totalPrice}</h5>
						<br>
						<p>
							訂單號碼: ${order.id}<br> 訂單時間: ${order.createTime}<br>
							付款方式: 信用卡<br>
						</p>
						<hr>
						<p>
							收件人: ${sessionScope.loginMember.name}<br> 手機號碼:
							${order.phone}<br> 收件地址: ${order.address}<br> 電子郵件:
							${order.email}<br>
						</p>

					</div>
				</div>
			</div>
			<div class="d-flex justify-content-center m-5">
			<a class="btn btn-secondary" href="
					<c:url value='/OrderService/showOrderList' >
						<c:param name='memberId' value='${sessionScope.loginMember.id}' />
					</c:url>">回上頁</a>
			</div>
		</div>
	</div>
</body>
</html>