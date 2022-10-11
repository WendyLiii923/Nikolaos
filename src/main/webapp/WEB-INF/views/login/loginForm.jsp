<%--
	執行本網頁之前，會先執行_02_login.filter.FindUserPassword.java這個過濾器。執行過濾器目的
	在檢視請求物件是否含有帳號與密碼等資料。
	  
        本網頁 login.jsp 提供登入的畫面，讓使用者輸入帳號與密碼。輸入完畢後，按下Submit按鈕，瀏覽器
        會帳號與密碼給  <Form>標籤action屬性對應的程式: _02_login.controller.LoginServlet.java，
        由該Servlet來檢查帳號與密碼是否正確。
            
--%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>sign in</title>
    
<!-- <!-- Google Font --> -->
<!--     <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap" -->
<!--         rel="stylesheet"> -->

    <!-- <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"> -->
    <!-- <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"> -->
    <!-- <link rel="stylesheet" href="css/magnific-popup.css" type="text/css"> -->
    <!-- <link rel="stylesheet" href="css/nice-select.css" type="text/css"> -->
    <!-- <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css"> -->
    <!-- <link rel="stylesheet" href="css/slicknav.min.css" type="text/css"> -->


<!--     <link rel="stylesheet" href="css/elegant-icons.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/style.css" type="text/css"> -->
    <!-- Css Styles -->
    
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
<!--     font-awesome 核心我CSS 文件 -->
<!--     <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"> -->
<!--     在bootstrap.min.js 之前引入 -->
<!--     <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script> -->
<!--     Bootstrap 核心 JavaScript 文件 -->
<!--     <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->

<script type="text/javascript">
//由<body>的onLoad事件處理函數觸發此函數
function setFocusToUserId(){   
	 document.forms[0].userId.focus();   // 將游標放在userId欄位內
}
</script>
</head>
<body>
<!-- 下列敘述設定變數funcName的值為LOG，top.jsp 會用到此變數 -->
<c:set var="funcName" value="LOG" scope="session"/>
<c:set var="msg" value="登入" />
<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->
   <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />
</c:if>
<!-- 引入共同的頁首 -->
<jsp:include page="../../fragment/header.jsp" />
<form:form method="POST" modelAttribute="loginBean">
  <div class="container form row ">
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3 container justify-content-center">
                <h3 class="form-title">登入</h3>
                <div class="col-sm-9 col-md-9">
                    <div class="form-group">
                        <!--        用戶圖標和用戶名輸入框           -->
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <form:input class="form-control" type="email" name="username" id="username"
                            placeholder="請輸入帳號(email)" path="email" />
                        <form:errors  path="email" cssClass="error" />
                    </div>
                    <!--       密碼圖片和密碼輸入框             -->
                    <div class="form-group">
                        <i class="fa fa-key" aria-hidden="true"></i>
                        <form:input class="form-control " type="password" name="password" id="password" placeholder="請輸入密碼"
                            path="password" />
                        <form:errors  path="password" cssClass="error" />
                    </div>
                    <!--        超連結跳到註冊頁面            -->
                    <div class="form-group">
                        <div class="mb-3 form-check">
<!--                             <input type="checkbox" class="form-check-input" id="rememberAccout" /> -->
                            <form:checkbox path="rememberMe"   />
                            <label class="form-check-label">記住帳號</label>
                        </div>
                        <br>

                    </div>
                    <!--         登入           -->
                    <div class="align-items-baseline">
                        <div class="form-group">
                            <a class="btn btn-primary" href="<c:url value='/register/register' />">來註冊吧</a>
                            <input type="submit" value="登入" class="btn btn-success pull-right">
                        </div>


                    </div>




                </div>
            </form>
        </div>
</form:form>
<jsp:include page="../../fragment/footer.jsp" />
</body>
</html>