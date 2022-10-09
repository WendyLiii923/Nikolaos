<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改訂單-客戶-Nikolaos</title>

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
        #invisable_tab {
            display: none;
        }

        .collapse {
            display: flex;
        }

        .order_table_enterprise {
            border-width: 1px;
            border-style: solid;
            border-color: #777;
            border-radius: 10px;
            padding: 10px;
            overflow: auto;
            height: 700px;
        }

        .modify_border {
            border-width: 2px;
            border-style: solid;
            border-color: #ddd;
            border-radius: 10px;
            padding-top: 14px;
            padding-bottom: 14px;
            padding-left: 14px;
            padding-right: 14px;
            margin-bottom: 5px;
            display: flex;
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

        .column_restricted_modify {
            width: 300px;
            word-break: break-all;
        }

        #modify_shipping_Unchangeable {
            font-weight: bold;
            color: green;
            margin: 10px;
        }

        input:valid {
            border: 2px solid green;
        }

        input:invalid {
            border: 2px solid red;
        }
    </style>
    <!-- Order Css End -->
    <!-- Order script Start -->
    <script>
    window.onload = function(){
        let orderId = document.getElementById("orderid").value;
    }
        function order_modify() {
            x = document.getElementById("address").value;
            y = document.getElementById("phonenumber").value;
            z = document.getElementById("customername").value;
            if (x == "" || y == "" || z == "") {
                alert("輸入欄位不可為空值!")
            }
            else {
                let shipping_address = document.getElementById("shipping_address").value;
                let recipient = document.getElementById("recipient").value;
                let recip_phone = document.getElementById("recip_phone").value;
                var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        updateOk(xhr.responseText);
					}
				}
                var requestString = 
                "id="+orderId+
                "&shipping_address=" + shipping_address+
                "&recipient=" + recipient +
                "&recip_phone=" + recip_phone;
                var url = "<c:url value='/orders/updataOrders' />";
                xhr.open("POST", url);
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
                xhr.send(requestString);
                alert("訂單修改成功!")
                location.href = "./orderManagement.jsp";
            }
        }
    </script>
    <!-- Order script Start -->
</head>


<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
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
                        <a href="../index.html"><img src="../img/logonew.jpg" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <li><a href="../index.html">Home</a></li>
                            <li class="active"><a href="../shop.html">Shop</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="dropdown">
                                    <li><a href="../about.html">About Us</a></li>
                                    <li><a href="../shop-details.html">Shop Details</a></li>
                                    <li><a href="../shopping-cart.html">Shopping Cart</a></li>
                                    <li><a href="../checkout.html">Check Out</a></li>
                                    <!-- <li><a href="./blog-details.html">Blog Details</a></li> -->
                                </ul>
                            </li>
                            <li><a href="../blog.html">Blog</a></li>
                            <li><a href="../contact.html">Contacts</a></li>
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
    <!-- Header Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Order Modification</h4>
                        <div class="breadcrumb__links">
                            <a href="../index.html">Home</a>
                            <a href="../shop.html">Shop</a>
                            <a href="../Order_Customers.html">My Order</a>
                            <span>Order Modification</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Order Section Begin -->

    <section class="order spad">
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3 container">
            <h3 class="form-title-order" style="font-weight:bold;">修改訂單</h3>
        </form>
        <div class="form-horizontal container">
            <br>
            <div class="modify_border">
                <!-- 修改訂單 打包區塊 start -->
                <div id="modify_cart_product">
                    <div class="order_table_enterprise">
                        <div style="padding: 5px;">
                            <div style="font-size: x-small;" id="orderid"><b> ▶ 訂單編號 : </b>${order.id}</div>
                            <div style="font-size: x-small;"><b> ▶ 顧客帳號 : </b>${member.email}</div>
                        </div>
                        <table class="table table-sm" style="font-size: 8px;">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col" class="column_restricted_modify">商品名稱</th>
                                    <th scope="col">尺寸</th>
                                    <th scope="col">數量</th>
                                    <th scope="col">金額</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">
                                        已購商品名稱
                                        有做出長度的限制(透過設class，如果被占用的話可以換ID)，如果商品名稱很長，超級長，想不到的長，像這欄這個樣子的話，商品名稱該欄位就會自動換行唷^^
                                    </th>
                                    <td>M</td>
                                    <td>1</td>
                                    <td>300</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱2</th>
                                    <td>L</td>
                                    <td>2</td>
                                    <td>500</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="column_restricted_modify">已購商品名稱3</th>
                                    <td>S</td>
                                    <td>1</td>
                                    <td>400</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>

                </div>
                <!-- 中間排版用空白card Start -->
                <div class="card px-1 border-light"></div>
                <!-- 中間排版用空白card End -->
                <div class="card border-secondary card-body">
                    <form>
                        
                        <b>配送狀態</b>
                        <div>
                            <h4 id="modify_shipping_Unchangeable">未出貨</h4>
                        </div>
                        <b>配送地址</b>
                        <div class="form-floating">
                            <input class="form-control form-control-sm" id="shipping_address" placeholder="請輸入配送地址"
                                value="${order.shipping_address}" maxlength="40" required>
                        </div>
                        <b>連絡電話</b>
                        <div class="form-floating">
                            <input class="form-control form-control-sm" id="recip_phone" placeholder="請輸入連絡電話"
                                value="${order.recip_phone}" oninput="value=this.value.replace(/\D/g,'')" maxlength="10" required>
                        </div>
                        <b>配送方式</b>
                        <div>
                            <h4 id="modify_shipping_Unchangeable">宅配</h4>
                        </div>
                        <b>收件人</b>
                        <div class="form-floating">
                            <input class="form-control form-control-sm" id="recipient" placeholder="請輸入收件人姓名"
                                value="${order.recipient}" maxlength="25" required>
                        </div>
                        <b>總金額</b>
                        <div>
                            <h4 id="modify_shipping_Unchangeable">TWD 4000</h4>
                        </div>
                        <div class="custom-control custom-checkbox" style="margin-bottom: 20px">
                            <input type="checkbox" class="custom-control-input" id="customCheck1" value="1">
                            <label class="custom-control-label" for="customCheck1">確認修改訂單</label>
                        </div>
                        <input type="button" value="修改訂單" class="btn btn-success btn-block" id="confirm_modify" disabled
                            onclick="order_modify()">
                    </form>

                </div>

            </div>
            <!-- 修改訂單 打包區塊 end -->
        </div>
    </section>
    <!-- Order Section End -->


    <!-- Footer Section Begin -->
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
                            <p>Be the first to know about new arrivals, look books, sales  promos!</p>
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
                            國立臺北科技大學 JAVA and Android 程式設計人才養成班 第十八屆 第一組<br>
                            專題成果展作品 非營利使用<br>
                            版權問題請聯繫：石驥惟 g057104100@gmail.com
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

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

    <!-- Js Plugins -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery.nicescroll.min.js"></script>
    <script src="../js/jquery.magnific-popup.min.js"></script>
    <script src="../js/jquery.countdown.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/main.js"></script>


</body>
</body>

</html>