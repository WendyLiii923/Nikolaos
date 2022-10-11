<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductLaunch</title>
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
				<h4>上架二手商品</h4>
			</div>


			<div class="d-flex justify-content-center pt-5">
				<div class="card shadow">
				  <div class="card-body">
				  	<form action="<c:url value='/ProductService/uploadForm' />" method="POST" enctype="multipart/form-data">
						<input type='hidden' name='memberId' value='${sessionScope.loginMember.id}'>
						<input type='hidden' name='status' value='published'>
						<div class="form-group">
						    <label for="name">商品名稱</label>
						    <input type="text" class="form-control" id="name" name="name">
						</div>
						<div class="form-group">
						    <label for="price">價格</label>
						    <input type="number" class="form-control" id="price" name="price">
						</div>
						<div class="mb-3">
						    <label for="content">詳細資訊</label>
						    <textarea class="form-control" id="content" name="content" placeholder="......"></textarea>
					  	</div>
					  	<div class="form-group">
					      <label for="categoryId">State</label>
					      <select id="categoryId" name="categoryId" class="form-control">
					        <option selected>請選擇</option>
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
						<button class="btn btn-block btn-primary mt-3" type="submit">上架</button>
					</form>
				  </div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>