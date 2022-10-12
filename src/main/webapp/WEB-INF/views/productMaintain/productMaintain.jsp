<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- Google Font -->
<!--     <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap" -->
<!--         rel="stylesheet"> -->

<!--     <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/elegant-icons.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/magnific-popup.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/nice-select.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/slicknav.min.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="css/style.css" type="text/css"> -->
    <!-- Css Styles -->
    <style>
        /*背景圖片*/
        #TextareaHighlight {
            width: 380px;
        }

        #rightColumn {
            border-color: black;
            border-width: 10px;
        }

        #TextareaDescrip {
            width: 380px;
        }

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

        floatingTextarea1 {
            width: 300px;
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
    <!--font-awesome 核心CSS 文件-->
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>








</head>

<!-- Header Section Begin -->


<div class="container py-5 " id="outSide">
    <div class="container  ">
        <div class="col-md-6 d-flex flex-column align-items-center">
            <div class="card-body d-flex justify-content-center">
                <img class="border border-3 rounded-2" style="width: 300px;" src="./img/product/product-3.jpg" alt="">
            </div>
            <div class="mt-5  ml-3">
                <div class="btn btn-primary " style="width: 200px;">
                    <input type="file">
                </div>

            </div>

        </div>

        <div class="col-md-6" id="rightColumn">

            <body>
            <!-- 引入共同的頁首 -->  
<jsp:include page="../../fragment/header.jsp" />
                <div class="container justify-content-center">
                    <div class="container px-3">
                        <div class="d-inline-block ">
                            <h4>產品名稱</h4>
                        </div>
                        <div class="d-inline-block px-3">
                            <input type="text" name="" id="">
                        </div>
                    </div>


                    <div class="container px-3">
                        <div class="d-inline-block ">
                            <h4>產品編號</h4>
                        </div>
                        <div class="d-inline-block px-3">
                            <input type="text" name="" id="">
                        </div>
                    </div>


                    <div class="container px-3">
                        <div class="d-inline-block">
                            <h4>產品金額</h4>
                        </div>
                        <div class="d-inline-block px-3">
                            <input type="number" name="" id="" style="width:208px">

                        </div>
                    </div>

                    <div class="container px-3">
                        <div class="d-inline-block">
                            <h4>產品尺寸</h4>
                        </div>
                        <div class="d-inline-block px-3">
                            <select type="form-select" name="" id="" style="width:208px">
                                <option selected>選擇商品尺寸</option>
                                <option value="1">S</option>
                                <option value="2">M</option>
                                <option value="3">L</option>
                                <option value="4">XL</option>
                            </select>

                        </div>
                    </div>
                    <div class="container px-3">
                        <div class="d-inline-block">
                            <h4>產品類別</h4>
                        </div>
                        <div class="d-inline-block px-3">
                            <select type="form-select" name="" id="" style="width:208px">
                            <c:forEach var="Category" items="${ClothCategories}">
                                <option value="${Category.id}">${Category.category}</option>
                            
                            </c:forEach>
                            	
<!--                                 <option selected>選擇商品類別</option> -->
<!--                                 <option value="2">下著</option> -->
<!--                                 <option value="3">配件</option> -->
<!--                                 <option value="4">T恤</option> -->
<!--                                 <option value="5">襯衫</option> -->
<!--                                 <option value="6">褲子</option> -->
<!--                                 <option value="7">裙子</option> -->
<!--                                 <option value="8">帽子</option> -->
<!--                                 <option value="9">耳環</option> -->
                            </select>

                        </div>
                    </div>

                    <div class="form-floating px-3"">
                        <div class=" py-3">
                        <h4>產品亮點</h4>
                    </div>
                    <textarea class="form-control" placeholder="Leave a comment here" id="TextareaHighlight"
                        style="height: 60px "></textarea>
                    <!-- <label for="floatingTextare1">產品描述</label> -->
                </div>


                <div class="form-floating px-3">
                    <div class=" py-3">
                        <h4>產品描述</h4>
                    </div>
                    <textarea class="form-control py-4" placeholder="產品描述一百字內" id="TextareaDescrip"
                        style="height: 100px"></textarea>
                    <!-- <label for="floatingTextarea2">產品描述</label> -->
                </div>










                <!-- <div>
                        <div class="d-inline-block px-3">
                            <h4>產品類別</h4>
                        </div>
                        <div class="form-floating py-5 d-inline-block">
                            <select class="form-select" id="floatingSelect" aria-label="Floating label select example"
                                style="width:208px;">
                                <option selected>選擇商品類別</option>
                                <option value="1">上衣</option>
                                <option value="2">下著</option>
                                <option value="3">配件</option>
                                <option value="4">T恤</option>
                                <option value="5">襯衫</option>
                                <option value="6">褲子</option>
                                <option value="7">裙子</option>
                                <option value="8">帽子</option>
                                <option value="9">耳環</option>
                            </select>
                            <!-- <label for="floatingSelect">產品類別</label> -->


                <!-- <div class="d-inline-block px-3">
                        <h4>尺寸</h4>
                    </div>

                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example"
                        style="width:208px;">
                        <option selected>選擇商品尺寸</option>
                        <option value="1">S</option>
                        <option value="2">M</option>
                        <option value="3">L</option>
                        <option value="4">XL</option>
                    </select> -->
                <!-- <label for="floatingSelect">產品類別</label> -->






        </div>





    </div>


</div>





<!-- 引入共同的頁尾 -->  
<jsp:include page="../../fragment/footer.jsp" />
</body>

</div>
<div class=" justify-content-center">

</div>


<div class="row justify-content-center align-items-center py-4 ">
    <div class="col-2 mt-3">
        <input type="submit" value="更新" class="btn btn-primary" style="width:100px">
    </div>

    <div class="col-2 mt-3">
        <input type="submit" value="刪除" class="btn btn-danger" style="width:100px">
    </div>
</div>


</div>

</div>


















<!-- Footer Section Begin -->

<!-- Footer Section End -->






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>

</html>