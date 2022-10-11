<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
        rel="stylesheet">

    <!-- Css Styles -->
<%--     "<c:url value='/javascript/jquery-1.9.1.js' />" --%>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/elegant-icons.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/magnific-popup.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/nice-select.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/owl.carousel.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/slicknav.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" type="text/css">
    
 <!-- Js Plugins -->
    <script src="<c:url value='/js/jquery-3.3.1.min.js' />"></script>
    <script src="<c:url value='/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/js/jquery.nice-select.min.js' />"></script>
    <script src="<c:url value='/js/jquery.nicescroll.min.js' />"></script>
    <script src="<c:url value='/js/jquery.magnific-popup.min.js' />"></script>
    <script src="<c:url value='/js/jquery.countdown.min.js' />"></script>
    <script src="<c:url value='/js/jquery.slicknav.js' />"></script>
    <script src="<c:url value='/js/mixitup.min.js' />"></script>
    <script src="<c:url value='/js/owl.carousel.min.js' />"></script>
    <script src="<c:url value='/js/main.js' />"></script>
    
<c:set var='debug' value='true' scope='application' />

<!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__option">
            <div class="offcanvas__links">
            	<c:if test="${empty LoginOK}">
                <a href="<c:url value='/login/login' />">Sign in</a>
                </c:if>
                <a href="#">FAQs</a>
            </div>
            <div class="offcanvas__top__hover">
                <span>Usd <i class="arrow_carrot-down"></i></span>
                <ul>
                    <li>USD</li>
                    <li>EUR</li>
                    <li>USD</li>
                </ul>
            </div>
        </div>
        <div class="offcanvas__nav__option">
            <a href="#" class="search-switch"><img src="<c:url value='/img/icon/search.png' />" alt=""></a>
            <a href="#"><img src="<c:url value='/img/icon/heart.png' />" alt=""></a>
            <a href="#"><img src="<c:url value='/img/icon/cart.png' />" alt=""> <span>0</span></a>
            <div class="price">$0.00</div>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__text">
            <p>Free shipping, 30-day return or refund guarantee.</p>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-7">
                        <div class="header__top__left">
                            <p>Free shipping, 30-day return or refund guarantee.</p>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-5">
                        <div class="header__top__right">
                            <div class="header__top__links">
                                <c:if test="${empty LoginOK}">
                				<a href="<c:url value='/login/login' />">Sign in</a>
                				</c:if>
                                <a href="#">FAQs</a>
                            </div>
                            <div class="header__top__hover">
                                <span>Usd <i class="arrow_carrot-down"></i></span>
                                <ul>
                                    <li>USD</li>
                                    <li>EUR</li>
                                    <li>USD</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="<c:url value='/' />"><img src="<c:url value='/img/logonew.jpg' />" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <nav class="header__menu mobile-menu">
                        <ul>
                        	<c:if test="${ funcName != 'IND' }">
                            <li class="active"><a href="<c:url value='/' />">Home</a></li>
                            </c:if>
                            <c:choose>
                			<c:when test="${ funcName != 'SHO' }">
                            <li><a href="<c:url value='/listProducts/DisplayPageProducts' />">Shop</a></li>
                            </c:when>
               				<c:otherwise>
                    			Shop
                			</c:otherwise>
              				</c:choose>
                            <li><a href="#">Used</a></li>
                            <li><a href="./memberCenter.html">Member Center</a></li>
                            <li><a href="./about.html">About us</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3 col-md-3">
                    <div class="header__nav__option">
                        <a href="#" class="search-switch"><img src="<c:url value='/img/icon/search.png' />" alt=""></a>
                        <a href="#"><img src="<c:url value='/img/icon/heart.png' />" alt=""></a>
                        <c:choose>
               			<c:when test="${ funcName != 'CHE' }">
                        <a href="#"><img src="<c:url value='/img/icon/cart.png' />" alt="" href="<c:url value='/ShoppingCart/ShowCartContent' />"> <span>0</span></a>
                        </c:when>
                <c:otherwise>
                  <img src="<c:url value='/img/icon/cart.png' />">   
                </c:otherwise>
              </c:choose>
                        <div class="price">$1.00</div>
                    </div>
                </div>
            </div>
            <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
    </header>
    <!-- Header Section End -->
    
    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->