<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>register</title>

<!-- Google Font --> 
<!-- <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap" -->
<!--         rel="stylesheet"> -->

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<!-- <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/elegant-icons.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/magnific-popup.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/nice-select.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/slicknav.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/style.css" type="text/css"> -->
<!-- Css Styles -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
    
<style>
/*背景圖片*/
        body {
            background: no-repeat;
            background-size: cover;
            font-size: 15px;
        }

        /*给表單邊框設置大小,颜色和不透明度*/
        .form {
            background: rgba(255, 255, 255, 0.9);
            width: 400px;
            margin: 50px auto;
        }

        /*字體和大小*/
        label {
            font-family: Arial;
            font-size: 15px
        }

        /*輸入正確，輸入框變淺綠色*/
        input.form-control:valid {
            background-color: mintcream;
        }

        /*输入錯誤,輸入框變淺紅色*/
        input.form-control:invalid {
            background-color: #ffeeed;
        }

        /*圖案是眶內元素，設定大小和顏色*/
        .fa {
            display: inline-block;
            top: 27px;
            left: 6px;
            position: relative;
            color: #575757;
        }

        /*輸入框設置padding,防止重疊*/
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            padding-left: 26px;
        }

        .form-title {
            padding-top: 20px;
        }

        #button {
            padding-bottom: 50px;
        }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!--     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script> -->

<!--     Bootstrap 核心 CSS 文件 -->
<!--     <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"> -->
<!--     font-awesome 核心CSS 文件 -->
<!--     <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"> -->
<!--     在bootstrap.min.js 之前引入 -->
<!--     <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script> -->
<!--     Bootstrap 核心 JavaScript 文件 -->
<!--     <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
</head>

<body>
<jsp:include page="../../fragment/header.jsp" />
<!--  <!-- Header Section Begin --> 
<!--     <header class="header"> -->
<!--         <div class="header__top"> -->
<!--             <div class="container"> -->
<!--                 <div class="row"> -->
<!--                     <div class="col-lg-6 col-md-7"> -->
<!--                         <div class="header__top__left"> -->
<!--                             <p>Free shipping, 30-day return or refund guarantee.</p> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="col-lg-6 col-md-5"> -->
<!--                         <div class="header__top__right"> -->
<!--                             <div class="header__top__links"> -->
<!--                                 <a href="./login.html">Sign in</a> -->
<!--                                 <a href="#">FAQs</a> -->
<!--                             </div> -->
<!--                             <div class="header__top__hover"> -->
<!--                                 <span>Usd <i class="arrow_carrot-down"></i></span> -->
<!--                                 <ul> -->
<!--                                     <li>USD</li> -->
<!--                                     <li>EUR</li> -->
<!--                                     <li>USD</li> -->
<!--                                 </ul> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--         <div class="container"> -->
<!--             <div class="row"> -->
<!--                 <div class="col-lg-3 col-md-3"> -->
<!--                     <div class="header__logo"> -->
<!--                         <a href="./index.html"><img src="img/logonew.jpg" alt=""></a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-lg-6 col-md-6"> -->
<!--                     <nav class="header__menu mobile-menu"> -->
<!--                         <ul> -->
<!--                             <li class="active"><a href="./index.html">Home</a></li> -->
<!--                             <li><a href="./shop.html">Shop</a></li> -->
<!--                             <li><a href="#">Pages</a> -->
<!--                                 <ul class="dropdown"> -->
<!--                                     <li><a href="./about.html">About Us</a></li> -->
<!--                                     <li><a href="./shop-details.html">Shop Details</a></li> -->
<!--                                     <li><a href="./shopping-cart.html">Shopping Cart</a></li> -->
<!--                                     <li><a href="./checkout.html">Check Out</a></li> -->
<!--                                     <li><a href="./blog-details.html">Blog Details</a></li> -->
<!--                                 </ul> -->
<!--                             </li> -->
<!--                             <li><a href="./blog.html">Blog</a></li> -->
<!--                             <li><a href="./contact.html">Contacts</a></li> -->
<!--                         </ul> -->
<!--                     </nav> -->
<!--                 </div> -->
<!--                 <div class="col-lg-3 col-md-3"> -->
<!--                     <div class="header__nav__option"> -->
<!--                         <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a> -->
<!--                         <a href="#"><img src="img/icon/heart.png" alt=""></a> -->
<!--                         <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a> -->
<!--                         <div class="price">$0.00</div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div class="canvas__open"><i class="fa fa-bars"></i></div> -->
<!--         </div> -->
<!--     </header> -->
<!--     Header Section End -->
  
  <form:form method="POST" modelAttribute="memberBean" enctype='multipart/form-data' >
  
  <!-- 中間填寫欄位 start -->
  <div class="container form row" >
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3 container " >

            <h3 class="form-title">註冊</h3>
            <div class="col-sm-9 col-md-9 " >
                <div class="form-group">
                    <!--        帳號圖案和帳號輸入框            -->
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <form:input class="form-control" type="text" name="username" id="username"
                        placeholder="請輸入帳號(email)" path="email" />
<%--                 <form:input type='text' path='email' /><br>&nbsp; --%>
      				<form:errors path="email" cssClass="error"/> 
                </div>
                
                <div class="form-group">
                    <!--        輸入姓名框           -->
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <form:input class="form-control" type="text" name="name" id="name" placeholder="請輸入姓名" path='name' />
<%--                 	<form:input path='name' /><br>&nbsp; --%>
      				<form:errors path="name" cssClass="error"/>
                </div>


                <div class="form-group">
                    <!--        輸入電話           -->
                    <i class="fa fa-phone" aria-hidden="true"></i>
                    <form:input class="form-control" type="text" name="phone" id="phone" placeholder="請輸入電話"
                        path="phone" />
<%--                     <form:input type='text' path='phone' /><br>&nbsp; --%>
      				<form:errors path="phone" cssClass="error"/>
                </div>


                <div class="form-group">
                    <!--        輸入地址           -->
                    <i class="fa fa-address" aria-hidden="true"></i>
                    <form:input class="form-control" type="text" name="address" id="address" placeholder="請輸入地址"
                        path='address' />
<%--                     <form:input path='address' /><br>&nbsp; --%>
      				<form:errors path="address" cssClass="error"/> 
                </div>



                <!--        密碼圖案和密碼輸入框                -->
                <div class="form-group">
                    <i class="fa fa-key" aria-hidden="true"></i>
                    <form:input class="form-control" type="password" name="password" id="password"
                        placeholder="請輸入密碼" path="password"/>
<%--                     <form:input path='password' /><br>&nbsp; --%>
      				<form:errors path="password" cssClass="error"/> 
                </div>
                <!--          確認密碼              -->
                <div class="form-group">
                    <i class="fa fa-check-circle-o" aria-hidden="true"></i>
                    <form:input class="form-control" type="password" name="password1" id="password1"
                        placeholder="再次輸入密碼" path="password1"/>
<%--                     <form:input path='password1' /><br>&nbsp; --%>
 					<form:errors path="password1" cssClass="error"/>
                </div>
                
                <div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" class="form-check-input" id="check1" checked />
                        <label class="form-check-labelfor=" check1">我已閱讀並同意<a name="terms"
                                href="./memberTerms.html">會員條款說明</a></label>

                    </div>
                </div>
                
               <div class="form-group">
                </div>

                <!--註冊按鈕-->
                <div class="form-group align-items-baseline">
                    <input type="submit" value="註冊" class="btn btn-success pull-right">
                    <a class="btn btn-primary pull-left" href="/login/login">返回登入畫面</a>

                </div>
                <!-- οnclick="javascrtpt:window.location.href='./Login.html'" -->
                
                
                
                </div>
</form:form>
</div>
</body>
<!-- 中間填寫欄位 end -->
<jsp:include page="../../fragment/footer.jsp" />
<!-- <!-- Footer Section Begin --> -->
<!-- <footer class="footer"> -->
<!--     <div class="container"> -->
<!--         <div class="row"> -->
<!--             <div class="col-lg-3 col-md-6 col-sm-6"> -->
<!--                 <div class="footer__about"> -->
<!--                     <div class="footer__logo"> -->
<!--                         <a href="#"><img src="img/logonew.jpg" alt=""></a> -->
<!--                     </div> -->
<!--                     <p>透過衣服告訴出社會打拼的人們，我們生活就像穿搭。<br>好看與否，其實不在於衣服價格，而是你是否有用心搭配。人生也是一樣，我們都一樣是活著，但用心的活著，肯定比盲目生活的人過得還要精彩。 -->
<!--                     </p> -->
<!--                     <a href="#"><img src="img/payment.png" alt=""></a> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6"> -->
<!--                 <div class="footer__widget"> -->
<!--                     <h6>INFO</h6> -->
<!--                     <ul> -->
<!--                         <li><a href="#">How to buy</a></li> -->
<!--                         <li><a href="#">Shipping</a></li> -->
<!--                         <li><a href="#">Returns</a></li> -->
<!--                         <li><a href="#">Sale</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div class="col-lg-2 col-md-3 col-sm-6"> -->
<!--                 <div class="footer__widget"> -->
<!--                     <h6>GET IN TOUCH</h6> -->
<!--                     <ul> -->
<!--                         <li><a href="#">01-2345678</a></li> -->
<!--                         <li><a href="#">nikolaosxxx@gmail.com</a></li> -->
<!--                         <li><a href="#">165 ANTI FRAUD</a></li> -->
<!--                         <li><a href="#">Return & Exchanges</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6"> -->
<!--                 <div class="footer__widget"> -->
<!--                     <h6>NewLetter</h6> -->
<!--                     <div class="footer__newslatter"> -->
<!--                         <p>Be the first to know about new arrivals, look books, sales & promos!</p> -->
<%--                         <form action="#"> --%>
<!--                             <input type="text" placeholder="Your email"> -->
<!--                             <button type="submit"><span class="icon_mail_alt"></span></button> -->
<%--                         </form> --%>
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--         <div class="row"> -->
<!--             <div class="col-lg-12 text-center"> -->
<!--                 <div class="footer__copyright__text"> -->
<!--                     Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
<!--                     <p> -->
<!--                         國立臺北科技大學 JAVA & Android 程式設計人才養成班 第十八屆 第一組<br> -->
<!--                         專題成果展作品 非營利使用<br> -->
<!--                         版權問題請聯繫：石驥惟 g057104100@gmail.com -->
<!--                     </p> -->
<!--                     <p>Copyright ©
<!--                         <script> -->
<!--                             document.write(new Date().getFullYear()); -->
<!--                         </script>2020 -->
<!--                         All rights reserved | This template is made with <i class="fa fa-heart-o" -->
<!--                         aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> -->
<!--                     </p> --> -->
<!--                     Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
<!-- </footer> -->
<!-- <!-- Footer Section End --> -->
</body>

</html>