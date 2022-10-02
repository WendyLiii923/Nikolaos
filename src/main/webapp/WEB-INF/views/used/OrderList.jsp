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
	<div class="h-100 overflow-hidden " style="width: calc(100% - 100px);">
		<div class="d-flex justify-content-between align-items-center text-white rounded m-3 p-2" 
			 style="height: 50px; background-color: #515151">
				<h4>訂單紀錄</h4>
		</div>

		<div class="d-flex">
			<div class="p-3">
				<table class="table table-striped table-bordered" style="table-layout: fixed;">
				  <thead>
				    <tr>
				      <th scope="col">訂單編號</th>
				      <th scope="col">訂單時間</th>
				      <th scope="col">訂單金額</th>
				      <th scope="col">付款方式</th>
				      <th scope="col">明細</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="order" items="${orderList}" >
				    <tr>
				    	<td>${order.id}</td>
				        <td>${order.createTime}</td>
						<td>$${order.totalPrice}</td>
						<td>信用卡</td>
					    <td>
					    	<a href="<c:url value='/OrderService/showOrderInfo'>
							<c:param name="orderId" value="${order.id}" />
							</c:url>">檢視明細
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