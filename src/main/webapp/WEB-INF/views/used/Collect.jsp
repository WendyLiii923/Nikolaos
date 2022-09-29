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

    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <c:forEach var="collect" items="${collectPage.data}">
                    <div class="col">
                        <div class="card shadow-sm">
                            <img class="bd-placeholder-img card-img-top"
                                 width="100%" height="225"
                                 src="${collect.cover}">

                            <div class="card-body">
                                <p class="card-text">${collect.name} - $ ${collect.price}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group w-100">
                                        <button type="button" class="btn btn-sm btn-outline-secondary"
                                                onclick="window.location.href='/nikolaos/ProductService/showProduct?productId=${collect.productId}'">前往商品頁
                                        </button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">移除收藏</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
