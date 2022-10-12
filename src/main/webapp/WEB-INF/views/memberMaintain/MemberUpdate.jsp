<%@page import="com.java18.nikolaos.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member center</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript">

function updateMember() {
    var hiddenField = document.getElementById("updateOrDelete");
//     hiddenField.value='PUT';
    document.forms[0].method="POST";
	document.forms[0].submit();
}

</script>

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

</head>

<!-- 引入共同的頁首 -->  
<jsp:include page="../../fragment/header.jsp" />
<form:form method="post" modelAttribute="loginMember" enctype="multipart/form-data" >
      
<input type='hidden' id='updateOrDelete' name='_method' > 
  

    <div class="container form row">
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3 container">

            <div class="row">

                <h3 class="col form-title">會員資料</h3>
                
             </div>
             
            <div class="col-sm-9 col-md-9 ">
        
   <div class="form-group">

                    <!--        帳號           -->
                    <div class="row">
                        <div class="col">
                            <h4>帳號名稱</h4>
                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                            <a class="btn btn-primary pull-right" href="<c:url value='/orders/ordersIndex'/>">訂單查詢</a>
                        </div>
                        <div class="col">
                            <a class="btn btn-primary pull-left" href="./productManageSystem.html">商品上架</a>
                        </div>
                    </div>


                    <i class="fa fa-user" aria-hidden="true"></i>

                    <form:input class="form-control" type="email" name="username" id="username"
                        placeholder="請輸入帳號(email)" path="email" />
                    <form:errors path="email" cssClass="error"/> 
                </div>
   				<div class="form-group">
                    <!--        姓名框           -->
                    <h4 class="">
                        姓名
                    </h4>
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <form:input class="form-control" type="text" name="name" id="name" placeholder="請輸入姓名" path='name' />
                    <form:errors path="name" cssClass="error"/>
                </div>
   <div class="form-group">
                    <!--        輸入電話           -->
                    <h4 class="">
                        電話
                    </h4>
                    <i class="fa fa-phone" aria-hidden="true"></i>
                    <form:input class="form-control" type="number" name="phone" id="phone" placeholder="請輸入電話"
                        path="phone" />
                    <form:errors path="phone" cssClass="error"/>
                </div>

   <div class="form-group">
                    <!--        輸入地址           -->
                    <h4 class="">
                        地址
                    </h4>
                    <i class="fa fa-address" aria-hidden="true"></i>
                    <form:input class="form-control" type="text" name="address" id="address" placeholder="請輸入地址"
                        path='address' />
                    <form:errors path="address" cssClass="error"/> 
                </div>

<div class="form-group align-items-baseline py-3">
                    <input type="submit" value="確認修改" class="btn btn-success pull-left" onclick='updateMember()'/>

                </div>
<!--                        密碼圖案和密碼輸入框                -->

<!--                 <div class="form-group"> -->
<!--                     <h4 class=""> -->
<!--                         輸入原密碼 -->
<!--                     </h4> -->
<!--                     <i class="fa fa-key" aria-hidden="true"></i> -->
<%--                     <form:input class="form-control" type="password" name="password" id="password" --%>
<%--                         placeholder="輸入原密碼" path="password" /> --%>
<%--                     <form:errors path="password" cssClass="error"/> --%>
<!--                 </div> -->
                
<!--                 <div class="form-group"> -->
<!--                     <h4 class=""> -->
<!--                         輸入新密碼 -->
<!--                     </h4> -->
<!--                     <i class="fa fa-key" aria-hidden="true"></i> -->
<%--                     <form:input class="form-control" type="password" name="password2" id="password2" --%>
<%--                         placeholder="輸入新密碼" path="password2" /> --%>
<%--                     <form:errors path="password2" cssClass="error"/> --%>
<!--                 </div> -->
                
<!--                           確認密碼              -->
<!--                 <div class="form-group"> -->
<!--                     <h4 class=""> -->
<!--                         再次輸入密碼 -->
<!--                     </h4> -->
<!--                     <i class="fa fa-check-circle-o" aria-hidden="true"></i> -->
<%--                     <form:input class="form-control" type="password" name="password1" id="password1" --%>
<%--                         placeholder="再次輸入新密碼" path="password1" /> --%>
<%--                      <form:errors path="password1" cssClass="error"/> --%>
<!--                 </div> -->
<!--                 <div class="form-group"> -->
<!--                 </div> -->

<!--                 註冊按鈕 -->
<!--                 <div class="form-group align-items-baseline"> -->
<!--                     <input type="submit" value="確認修改密碼" class="btn btn-success pull-left" onclick='updateMember()'/> -->

<!--                 </div> -->
</form:form>

</div>
<jsp:include page="../../fragment/footer.jsp" />
</body>
</html>