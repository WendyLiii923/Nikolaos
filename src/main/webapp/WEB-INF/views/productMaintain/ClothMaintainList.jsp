<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<title>產品維護頁(可瀏覽全產品+新增進入頁面)</title>






 <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
        rel="stylesheet">

    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <!-- Css Styles -->
    <style>
        /*背景圖片*/
        body {
            background: url(../img/carback.jpg) no-repeat;
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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>

    <!-- Bootstrap 核心 CSS 文件 -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <!--jquery-->
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="css/Login.css">
    <!--font-awesome    -->
    <link rel="stylesheet" href="font-awesome-4\7\0\css\font-awesome.min.css">



</head>
<body>

<!--  
  // 程式功能: 
  //  1. 顯示所有書籍(商品)資訊，書籍資訊以分頁的方式顯示，每頁顯示四筆書籍。
  //     使用者可以按下『第一頁』、『前一頁』、『下一頁』與『最後頁』逐頁地
  //     瀏覽商品。
  //  2. 提供『新增書籍』資料、『修改書籍資料』與『刪除某本書籍』的功能。
  //     
  //  3. 當使用者要新增某本書籍資料時，直接按下右上角『新增書籍』的超連結便可
  //     進入『新增書籍資料』的畫面(由BookInsert.php提供)，輸入新的書籍資料。
  //     當使用者要修改某本書籍資料時，可直接點選該本書籍的『書名』超連結，便
         可進入『更新書籍資料』的畫面(由BookUpdate.php提供)，可對該本書籍進行
         資料修改或刪除紀錄。
-->
<!-- 下列敘述設定變數funcName的值為BMT，top.jsp 會用到此變數 -->
<c:set var="funcName" value="BMT" scope="session" />
<!-- 引入共同的頁首 -->
<jsp:include page="/fragment/header.jsp" />
<div id='main' align="center">
<%-- ${ BookDeleteMsg } --%>
<c:remove var="BookDeleteMsg" />


<table border='1'>












<body>
  
<c:forEach varStatus="stVar" var="entry" items="${products_DPP}">
    <div class="container">



        <div class="card container py-3" style="max-width: 850px;">
            <div class="row g-0">
                <div class="col-md-6">
<%--                 <img height='100' width='80'src='../listClothes/getProductPhoto?id=${entry.value.id}'> --%>
                    <img height='180' width='180' src='../listClothes/getProductPhoto?id=${entry.value.id}' class="img-fluid rounded-start" alt="...">
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <h3 class="card-title">品名</h3>
                        <h4>
                        <a  href="ClothUpdate/${entry.value.id}">${entry.value.name}</a>
                        </h4>
                        

                        <h5 class="card-title mt-3">產品編號：# ${entry.value.id}</h5>
                        <h5 class="card-title mt-3">庫存：${entry.value.stock}</h5>
                        <h5 class="card-title mt-3">定價：${entry.value.actualPrice} 元</h5>
                        
          
						
                        <p class="card-text"><small class="text-muted"></small></p>
                        <div class="align-items-baseline">
                            <div class="form-group">
                                <a class="btn btn-danger" href="ClothUpdate/${entry.value.id}"><h5 class="btn btn-danger" >刪除該產品</h5></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>








    </div>
</c:forEach>
    <div class="d-flex py-3 justify-content-center">
<!--         <a class="btn btn-primary" style="width:200px" href="./productDetail.html">新增產品</a> -->
        <div id="insert">
        <a class="btn btn-primary style="width:300px"  href="<c:url value='/productMaintain/ClothInsert' />" ><h4 class="btn btn-primary">新增一項產品</h4></a>
        </div>

    </div>


    <div class="d-flex py-3 justify-content-center">
        <a class="btn btn-primary" style="width:200px"href="<c:url value='/' />">回首頁</a>

    </div>
















































 
</body>





























<!-- 引入共同的頁首 -->
<jsp:include page="/fragment/footer.jsp" />
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>

</html>
