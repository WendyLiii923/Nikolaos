<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductUpdate</title>
<%@ include file="../include/Header.jsp"%>
</head>
<body>
	<%@ include file="../include/TopBar.jsp"%>
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
				<h4>修改商品資訊</h4>
			</div>


			<div class="d-flex justify-content-center pt-5">
				<div class="card shadow">
				  <div class="card-body">
				  	<form action="<c:url value='/ProductService/updateProduct' />" enctype="multipart/form-data">
						<input type='hidden' name='memberId' value='${sessionScope.loginMember.id}'>
						<input type='hidden' name='productId' value='${productInfo.id}'>
						<div class="form-group">
						    <label for="name">商品名稱</label>
						    <input type="text" class="form-control" id="name" name="name" value="${productInfo.name}">
						</div>
						<div class="form-group">
						    <label for="price">價格</label>
						    <input type="number" class="form-control" id="price" name="price" value="${productInfo.price}">
						</div>
						<div class="mb-3">
						    <label for="content">詳細資訊</label>
						    <textarea class="form-control" id="content" name="content" placeholder="......">${productInfo.content}</textarea>
					  	</div>
					  	<div class="form-group">
					      <label for="categoryId">分類</label>
					      <select id="categoryId" name="categoryId" class="form-control">
					        <option selected value="${productInfo.categoryId}">${productInfo.categoryName}</option>
					        <option value='4'>T恤</option>
							<option value='5'>襯衫</option>
							<option value='6'>褲子</option>
							<option value='7'>裙子</option>
							<option value='8'>帽子</option>
							<option value='9'>耳環</option>
					      </select>
					    </div>
					    <div class="form-group">
						    <label for="cover">照片</label>
						    <div class="custom-file">
							    <input type="file" name="cover" class="custom-file-input" id="cover">
							    <label class="custom-file-label" for="cover">Choose file...</label>
						  	</div>
					    </div>
						<button class="btn btn-block btn-primary mt-3" type="submit">確認修改</button>
					</form>
				  </div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>