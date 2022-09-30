<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/nikolaos/">Nikolaos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-center" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="#">新品</a><span style="line-height: 35px">/</span>
      <a class="nav-item nav-link" href="#">熱賣</a><span style="line-height: 35px">/</span>
      <a class="nav-item nav-link" href="#">系列</a><span style="line-height: 35px">/</span>
      <a class="nav-item nav-link" href="#">所有商品</a><span style="line-height: 35px">/</span>
      <a class="nav-item nav-link" href="#">#分享</a><span style="line-height: 35px">/</span>
      <a class="nav-item nav-link" href="<c:url value='/ProductService/showProducts' />">二手拍賣</a>
    </div>
  </div>

      <ul class="navbar-nav ms-3 me-5 mb-2 mb-lg-0">
      		<li>
      		<c:choose>
      			<c:when test="${empty sessionScope.loginMember}">
	      			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#login-modal">
					  	登入
				    </button>
      			</c:when>
				<c:otherwise>
					<a class="btn btn-secondary" href="<c:url value='/Auth/Logout'/>">
						${sessionScope.loginMember.name} 登出
					</a>
				</c:otherwise>      		
      		</c:choose>
      			
      			
      		</li>
            <li class="nav-item mx-2">
              <a
                class="position-relative"
                data-bs-toggle="offcanvas"
                href="#offcanvasExample"
                role="button"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="30"
                  height="30"
                  fill="currentColor"
                  class="bi bi-search"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"
                  />
                </svg>
              </a>
            </li>
            <!-- cart -->
            <li class="nav-item mx-2">
              <a class="position-relative" href="<c:url value='/CartService/showCart' >
              <c:param name="memberId" value="${sessionScope.loginMember.id}"/>
              </c:url>">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="30"
                  height="30"
                  fill="currentColor"
                  class="bi bi-cart"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"
                  />
                </svg>
<!--                 <span -->
<!--                   class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger" -->
<!--                   >5</span> -->
              </a>
            </li>
            <!-- member -->
            <li class="nav-item mx-2 ">
              <a href="" >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="30"
                  height="30"
                  fill="currentColor"
                  class="bi bi-person-circle"
                  viewBox="0 0 16 16"
                >
                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                  <path
                    fill-rule="evenodd"
                    d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                  />
                </svg>
              </a>
            </li>
          </ul>
</nav>