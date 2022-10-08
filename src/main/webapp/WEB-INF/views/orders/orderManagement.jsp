<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <!DOCTYPE html>
    <html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Nikolao-訂單管理系統</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
            rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="../css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="../css/style.css" type="text/css">
        <!-- Order Css -->
        <style>
            .collapse {
                display: flex;
            }

            .tab_css {
                display: flex;
                flex-wrap: wrap;
                justify-content: left;
            }

            .tab_css input {
                display: none
            }

            .tab_css label {
                margin: 0 5px 5px 0;
                padding: 10px 16px;
                cursor: pointer;
                border-radius: 10px;
                background: #999;
                color: #fff;
                opacity: 0.5;
            }

            .tab_content {
                order: 1;
                display: none;
                width: 100%;
                line-height: 1.6;
                font-size: .9em;
                padding: 15px;
                border: 2px solid #ddd;
                border-radius: 10px;
            }

            .tab_css input:checked+label,
            .tab_css label:hover {
                opacity: 1;
                font-weight: bold;
            }

            .tab_css input:checked+label+.tab_content {
                display: initial;
            }

            .orderline_row {
                border-width: 2px;
                border-style: solid;
                border-color: #ddd;
                border-radius: 10px;
                padding: 8px;
                margin-bottom: 5px;
            }

            .orderline_topic {
                border-width: 15px;
                border-top-style: solid;
                border-bottom-style: solid;
                border-color: #34a225;
                border-radius: 10px;
                margin: 0pt;
                margin-bottom: 15px;
                background-color: #34a225;
                color: #fff;
                font-size: large;
                font-weight: bolder;
            }
        </style>
        <!-- Order Css End -->
    </head>
<%--     <script type="text/javascript" src="<%=basePath%>orders.js" > --%>
    <script type="text/javascript" >
    window.onload = function () {
        var UnOkOrders = document.getElementById("UnOkOrders");
        var OkOrders = document.getElementById("OkOrders")
        var cancelOrders = document.getElementById("cancelOrders")
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                getOrder(xhr.responseText);
            }
        }
        xhr.open("GET", "<c:url value='/orders/ordersAll'/>");
        xhr.send();
    }
    function addTableHead() {
        var result = "<div class='orderline_topic row align-items-center'><div class='col-sm-3'>訂單編號</div><div class='col-sm-5'>顧客帳號</div><div class='col-sm-4'>訂單管理</div></div>"
        return result;
    }
    function result01(){
        var result ="<div class='orderline_row col-sm-12'><div class='row'><div class='col-sm-3 align-self-center'>"
        return result;
    }
    function result02(){
        var result ="</div><div class='col-sm-5 align-self-center'>"
        return result;
    }
    function result03(){
        var result ="</div><div class='col-sm-4 justify-content-right align-self-center'><button class='btn btn-success btn-sm' type='button'data-toggle='collapse' data-target='#collapseExample"
        return result;
    }
    function result04(){
        var result ="'aria-expanded='false' aria-controls='collapseExample'>詳細資訊</button>" 
        return result;
    }
    function resultAlterStr(){
       var result ="<a href=<c:url value='/orders/orderAlter'/>?id="
            return result
    }
    function resultAlterEnd(){
       var result ="><button class='btn btn-primary btn-sm' >修改訂單</button></a>" 
            return result
    }
    function resultCancelStr() {
        var result = "<a href=<c:url value='/orders/cancelOrder'/>?id="
        return result;
    }
    function resultCancelEnd() {
        var result = "><button class='btn btn-danger btn-sm'>取消訂單</button></a>"
        return result;
    }
    function result05(){
        var result =
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "<div class='collapse' id='collapseExample" 
        return result;
    }
    function result06(){
        var result ="'" +
                    "style='text-align: left; padding: 20px;'>" +
                    "<div class='card border-secondary card-body'>" +
                    "<table class='table table-sm' style='font-size: 8px;'>" +
                    "<tr>" +
                    "<th scope='row'>配送狀態</th>" +
                    "<td>"
        return result;
    }
    function result07(){
        var result ="</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<th scope='row'>配送地址</th>" +
                    "<td>" 
        return result;
    }
    function result08(){
        var result ="</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<th scope='row'>連絡電話</th>" +
                    "<td>"
        return result;
    }
    function result09(){
        var result = "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<th scope='col'>配送方式</th>" +
                    "<td>宅配</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<th scope='row'>收件人</th>" +
                    "<td>"
        return result;
    }
    function result10(){
        var result = "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<th scope='row'>總金額</th>" +
                    "<td>" 
        return result;
    }
    function result11(){
        var result ="</td>" +
                    "</tr>" +
                    "</table>" +
                    "</div>" +
                    "<div class='card px-3 border-light'></div>" +
                    "<div class='card border-secondary card-body'>" +
                    "<table class='table table-sm' style='font-size: 8px;'>" +
                    "<thead class='table-dark'>" +
                    "<tr>" +
                    "<th scope='col'>商品名稱</th>" +
                    "<th scope='col'>尺寸</th>" +
                    "<th scope='col'>數量</th>" +
                    "<th scope='col'>金額</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr>" +
                    "<th scope='row'>條紋上衣</th>" +
                    "<td>M</td>" +
                    "<td>1</td>" +
                    "<td>300</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<th scope='row'>超寬牛仔褲</th>" +
                    "<td>L</td>" +
                    "<td>2</td>" +
                    "<td>500</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<th scope='row'>氣質小裙子</th>" +
                    "<td>S</td>" +
                    "<td>1</td>" +
                    "<td>400</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "</div>" +
                    "</div>"
        return result;
    }

    function getOrder(data) {
            var orders = JSON.parse(data);
            resultUnOkOrder = addTableHead();
            resultOrderOk = addTableHead();
            resultCancelOrder = addTableHead();
            for (n = 0; n < orders.length; n++) {
                var order = orders[n];
                resultStr = result01() + order.id + result02() + order.email + result03() + order.id + result04();
                resultEnd = result05() + order.id + result06() + order.ok_tag + result07() +order.shipping_address + result08() +
                             order.recip_phone +result09() + order.recipient + result10() + order.total_amount + result11()
                if (order.cancel_tag) {
                    resultCancelOrder += resultStr + resultEnd
                } else if (!order.ok_tag) {
                    resultUnOkOrder += resultStr + resultAlterStr() + order.id + resultAlterEnd() + resultCancelStr() 
                                     + order.id + resultCancelEnd() +resultEnd
                } else if (order.ok_tag) {
                    resultOrderOk += resultStr + resultCancelStr() + order.id + resultCancelEnd() + resultEnd

                }
            }
            UnOkOrders.innerHTML = resultUnOkOrder;
            OkOrders.innerHTML = resultOrderOk;
            cancelOrders.innerHTML = resultCancelOrder;
        }
    </script>
    <body>
        <div id="preloder">
            <div class="loader"></div>
        </div>
        <div class="offcanvas-menu-overlay"></div>
        <div class="offcanvas-menu-wrapper">
            <div class="offcanvas__option">
                <div class="offcanvas__links">
                    <a href="#">Sign in</a>
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
                <a href="#" class="search-switch"><img src="../img/icon/search.png" alt=""></a>
                <a href="#"><img src="../img/icon/heart.png" alt=""></a>
                <a href="#"><img src="../img/icon/cart.png" alt=""> <span>0</span></a>
                <div class="price">$0.00</div>
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="offcanvas__text">
                <p>Free shipping, 30-day return or refund guarantee.</p>
            </div>
        </div>
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
                                    <a href="#">Sign in</a>
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
                            <a href="./index.html"><img src="../img/logonew.jpg" ></a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="./index.html">Home</a></li>
                                <li class="active"><a href="./shop.html">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="./about.html">About Us</a></li>
                                        <li><a href="./shop-details.html">Shop Details</a></li>
                                        <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                        <li><a href="./checkout.html">Check Out</a></li>
                                    </ul>
                                </li>
                                <li><a href="./blog.html">Blog</a></li>
                                <li><a href="./contact.html">Contacts</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3 col-md-3">
                        <div class="header__nav__option">
                            <a href="#" class="search-switch"><img src="../img/icon/search.png" alt=""></a>
                            <a href="#"><img src="../img/icon/heart.png" alt=""></a>
                            <a href="#"><img src="../img/icon/cart.png" alt=""> <span>0</span></a>
                            <div class="price">$0.00</div>
                        </div>
                    </div>
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>
        </header>
        <section class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__text">
                            <h4>Order Management</h4>
                            <div class="breadcrumb__links">
                                <a href="./index.html">Home</a>
                                <a href="./shop.html">Shop</a>
                                <span>Order Management</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="order spad">
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3 container">
                <h3 class="form-title-order" style="font-weight:bold;">訂單管理系統</h3>
            </form>
            <div class="form-horizontal container">
                <div class="form-inline pull-right">
                    <div class="form-group-inline">
                        <input id="floatingInputValue" placeholder="請輸入訂單編號" class="form-control form-control-sm"
                            oninput="value=this.value.replace(/\D/g,'')" maxlength="5">
                        <!-- value=this.value.replace(/\D/g,'') 限制 input 輸入框只能輸入數字 -->
                    </div>
                    <a href="./Order_Ente_To_Search copy.html">
                        <button class="btn btn-success col-xs-3 btn-sm">搜尋</button>
                    </a>
                </div>
                <br>
                <br>
                <br>
                <div class="tab_css">
                    <input id="tab1" type="radio" name="tab" checked="checked" />
                    <label for="tab1">待完成訂單</label>
                    <div class="tab_content" id="UnOkOrders">
                    </div>
                    <input id="tab2" type="radio" name="tab" />
                    <label for="tab2" >歷史訂單</label>
                    <div class="tab_content" id="OkOrders">
                    </div>
                    <input id="tab3" type="radio" name="tab" />
                    <label for="tab3">不成立訂單</label>
                    
                    <div class="tab_content" id="cancelOrders">
                        
                    </div>
                  
                </div>
            </div>
        </section>
        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__logo">
                                <a href="#"><img src="../img/logonew.jpg" alt=""></a>
                            </div>
                            <p>透過衣服告訴出社會打拼的人們，我們生活就像穿搭。<br>好看與否，其實不在於衣服價格，而是你是否有用心搭配。人生也是一樣，我們都一樣是活著，但用心的活著，肯定比盲目生活的人過得還要精彩。
                            </p>
                            <a href="#"><img src="../img/payment.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                        <div class="footer__widget">
                            <h6>INFO</h6>
                            <ul>
                                <li><a href="#">How to buy</a></li>
                                <li><a href="#">Shipping</a></li>
                                <li><a href="#">Returns</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-6">
                        <div class="footer__widget">
                            <h6>GET IN TOUCH</h6>
                            <ul>
                                <li><a href="#">01-2345678</a></li>
                                <li><a href="#">nikolaosxxx@gmail.com</a></li>
                                <li><a href="#">165 ANTI FRAUD</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                        <div class="footer__widget">
                            <h6>NewLetter</h6>
                            <div class="footer__newslatter">
                                <p>Be the first to know about new arrivals, look books, sales promos!</p>
                                <form action="#">
                                    <input type="text" placeholder="Your email">
                                    <button type="submit"><span class="icon_mail_alt"></span></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="footer__copyright__text">
                            <p>
                                國立臺北科技大學 JAVA Android 程式設計人才養成班 第十八屆 第一組<br>
                                專題成果展作品 非營利使用<br>
                                版權問題請聯繫：石驥惟 g057104100@gmail.com
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/jquery.nice-select.min.js"></script>
        <script type="text/javascript" src="../js/jquery.nicescroll.min.js"></script>
        <script type="text/javascript" src="../js/jquery.magnific-popup.min.js"></script>
        <script type="text/javascript" src="../js/jquery.countdown.min.js"></script>
        <script type="text/javascript" src="../js/jquery.slicknav.js"></script>
        <script type="text/javascript" src="../js/mixitup.min.js"></script>
        <script type="text/javascript" src="../js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
    </body>

    </html>