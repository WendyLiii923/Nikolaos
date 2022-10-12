<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
   span.error {
	color: red;
	display: inline-block;
	font-size: 10pt;
}
</style>

<meta charset="UTF-8">
<title>${AppName}</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function setFocus(fld) {
     document.getElementById(fld).focus();
}


// function insertOk() {
// 	if (confirm("確定新增此筆資料") ) {
// 		document.forms[0].action="<c:url value='/productMaintain/ClothInsert'  />" ;
// 		document.forms[0].method="GET";
// 		document.forms[0].submit();
// 	} else {
// 	}
// }
</script>
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
            background: url(../../img/carback.jpg) no-repeat;
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
<script type="text/javascript">

$(document).ready(function(){
	$(".owl‑carousel").owlCarousel();
	});
	</script>



</head>
<body >
<!-- onload="setFocus('title')" background="../images/bookMaintain.jpg" -->
<!-- 引入共同的頁首 -->  
<jsp:include page="../../fragment/header.jsp" />






<form:form  id="form1" modelAttribute='clothBean' method="post"  enctype="multipart/form-data" >
<div class="container py-5 " id="outSide">
    <div class="container  ">
        <div class="col-md-6 d-flex flex-column align-items-center">
            <div class="card-body d-flex justify-content-center">
                <img class="border border-3 rounded-2" style="width: 300px;" src="../img/product/product-3.jpg" alt="">
            </div>
            <div class="mt-5  ml-3">
                <div class="btn btn-primary " style="width: 200px;">
                <form:input path="productImage" type='file' />
                </div>

            </div>

        </div>

        <div class="col-md-6" id="rightColumn">

                <div class="container justify-content-center">
                    <div class="container px-3">
                        <div class="d-inline-block ">
                            <h4>產品名稱</h4>
                        </div>
                        <div class="d-inline-block px-3">
                              <form:input path="name" size='40'/>
           					<form:errors path="name" cssClass="error"/>
<!--                             <input type="text" name="" id=""> -->
                        </div>
                    </div>


                    <div class="container px-3">
                        <div class="d-inline-block ">
                            <h4>庫存數量</h4>
                        </div>
                        <div class="d-inline-block px-3">
                           <form:input path="stock" size='40'/>
                        </div>
                    </div>


                    <div class="container px-3">
                        <div class="d-inline-block">
                            <h4>產品售價</h4>
                        </div>
                        <div class="d-inline-block px-3">
                              <form:input path="actualPrice" size='40'/>
                        </div>
                    </div>

<!--                     <div class="container px-3"> -->
<!--                         <div class="d-inline-block"> -->
<!--                             <h4>產品庫存</h4> -->
<!--                         </div> -->
<!--                         <div class="d-inline-block px-3"> -->
<%--                                                          <form:input path="stock" size='40'/> --%>
                           

<!--                         </div> -->
<!--                     </div> -->
                    <div class="container px-3">
                            <h4>產品類別</h4>
                        <div class="d-inline-block">
                        </div>
                        
                         <form:select path="clothCategoryBean.id" id="123"  >
          				<form:option value="0" label="請挑選" />
          				<form:options items="${ClothCategoryList}" itemLabel="category" itemValue="id" />
            			</form:select>
         				 <form:errors path="category" cssClass="error"/>       
 
                    </div>

                    <div class="form-floating px-3">
                        <div class=" py-3">
                        <h5>產品亮點</h5>
                    </div>
                            <form:input placeholder="輸入產品亮點" path="highlight" size='54'/>
          					 <form:errors path="highlight" cssClass="error"/>
                </div>


                <div class="form-floating px-3">
                    <div class=" py-3">
                        <h5>產品詳細描述</h5>
<%--                         <form:textarea      path="descrip"  style="height: 90px width:250px"    /> --%>
                         <form:textarea class="form-control py-4" path="descrip"  id="TextareaDescrip" style="height: 90px"/>
<%--            						<form:input placeholder="輸入產品詳細描述" path="descrip" size='60'/> --%>
<%--            						<form:errors path="descrip" cssClass="error"/> --%>
                    </div>
                </div>

      
        </div>
    </div>
</div>
</div>



<div class="row justify-content-center align-items-center py-4 ">
    <div class="col-2 mt-3">
<!--      		<input type="submit" name="Submit" value="新增" onclick='insertOk()'/> -->
<!--         <input type="submit" value="更新" class="btn btn-primary" style="width:100px"> -->
         	<input type="submit" name="Submit"  class="btn btn-success" value="新增產品" style="width:100px" onclick='insertOk()'/>
    </div>
    <div class="col-2 mt-3">
      <a href="DisplayPageProducts?pageNo=${param.pageNo}" class="btn btn-primary" style="width:100px">回維護首頁</a>   
    </div>

    
</div>




</form:form>



<!-- 引入共同的頁首 -->  
<jsp:include page="../../fragment/footer.jsp" />
</body>
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" -->
<!--     integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" -->
<!--     crossorigin="anonymous"></script> -->
</html>