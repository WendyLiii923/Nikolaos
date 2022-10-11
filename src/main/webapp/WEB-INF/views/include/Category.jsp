<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<!-- 	<div class="h-100 p-3 border-right" style="width: 200px"> -->
<!-- 		<div class="list-group list-group-flush"> -->
<%-- 			<c:forEach var="category" items="${categoryList}"> --%>
<!-- 				<tr> -->
<%--  					<td><a class="list-group-item list-group-item-action --%>
<%--  							<c:if test='${param.categoryId == category.id}'>active</c:if>" --%>
<%--  							href="<c:url value='/used'> --%>
<%--  								<c:param name="categoryId" value="${category.id}" /> --%>
<%--  								<c:param name="parentId" value="${category.parentId}" /> --%>
<%--  							</c:url>"> --%>
<%--  						${category.name} </a> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</div> -->
<!-- 	</div> -->

<!-- 	新版分類 -->
<div class="h-100 p-3 border-right" style="width: 200px">
	<div class="accordion accordion-flush" id="accordionExample">
		<c:forEach var="category" items="${categoryList}">
			<c:if test="${empty category.parentId}">
				<div class="accordion-item">

					<h2 class="accordion-header" id="heading">
						<button class="accordion-button" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapse"
							aria-expanded="false" aria-controls="collapse"
							onclick="<c:url value='/used'>
						<c:param name="categoryId" value="${category.id}" />
						<c:param name="parentId" value="${category.parentId}" />
						</c:url>">
							${category.name}</button>
					</h2>

					<div id="collapse" class="accordion-collapse collapse show"
						aria-labelledby="heading" data-bs-parent="#accordionExample">
						<div>
							<c:forEach var="categoryItem" items="${categoryList}">
								<c:if test="${categoryItem.parentId == category.id}">
									<a class="list-group-item list-group-item-action
	 							<c:if test='${param.categoryId == categoryItem.id}'>active</c:if>"
										href="<c:url value='/used'>
	 								<c:param name="categoryId" value="${categoryItem.id}" />
	 								<c:param name="parentId" value="${categoryItem.parentId}" />
	 							</c:url>">
										${categoryItem.name} </a>
								</c:if>
							</c:forEach>
						</div>
					</div>

				</div>
			</c:if>
		</c:forEach>
	</div>
</div>



​
