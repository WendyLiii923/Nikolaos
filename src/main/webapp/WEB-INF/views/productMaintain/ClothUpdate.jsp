<%-- <%@page import="listColth.model" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}</title>

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







<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function setFocus()
{
     document.getElementById("title").focus();
}

function confirmDelete(id) {
	if (confirm("確定刪除此項書籍資料(編號:${clothBean.id})?") ) {
		document.forms[0].action="<c:url value='/productMaintain/ClothDelete/${clothBean.id}'  />" ;
		document.forms[0].method="GET";
		document.forms[0].submit();
	} else {
	}
}


function updateCloth() {
    var hiddenField = document.getElementById("updateOrDelete");
//     hiddenField.value='PUT';
    document.forms[0].method="POST";
	document.forms[0].submit();
}

</script>
<style>


</style>

</head>

<!-- <body onload="setFocus()" background="../images/bookMaintain.jpg"> -->

<!-- 引入共同的頁首 -->  
<jsp:include page="/fragment/header.jsp" />



<form:form method="post" modelAttribute="clothBean"   
			enctype="multipart/form-data" >
<div class="container py-5 " id="outSide">
    <div class="container">
        <div class="col-md-6 d-flex flex-column align-items-center">
            <div class="card-body d-flex justify-content-center">
                <img class="border border-3 rounded-2" style="width: 300px;" height='260px' src='../../listClothes/getProductPhoto?id=${cothBean.id}'/>
            </div>
            <div class="mt-5  ml-3">
<!--                 <div class="btn btn-primary " style="width: 200px;"> -->
<!--                     <input type="file"> -->
<!--                 </div> -->

            </div>

        </div>

        <div class="col-md-6" id="rightColumn">

            <body>
                <div class="container justify-content-center">
                    <div class="container px-3">
                        <div class="d-inline-block ">
                            <h4>產品名稱</h4>
                        </div>
                        <div class="d-inline-block px-3">
                        	<h5><form:input path="name" size='20'/></h5>
                        </div>
                    </div>


                    <div class="container px-3">
                        <div class="d-inline-block ">
                            <h4>產品編號</h4>
                        </div>
                        <div class="d-inline-block px-3">
                        <h5><form:input path="id" size='20'/></h5>
                        </div>
                    </div>


                    <div class="container px-3">
                        <div class="d-inline-block">
                            <h4>產品分類</h4>
                        </div>
                        <div class="d-inline-block px-3">
                            <h5><form:input path="actualPrice" size='20'/></h5>
                        </div>
                    </div>
                    
                    
                    	<div class="container px-3">
                        <div class="d-inline-block">
                            <h4>產品類別</h4>
                        </div>
                        
                        <div class="d-inline-block px-3">
                                       <select type="form-select " aria-label="label for the select" id="formSelect" style="display: block;" >
            							<option value="0" label="請挑選" />
          							<c:forEach var="ClothCategoryBean" items="${ClothCategory}">
            				<option value="${ClothCategoryBean.id}">${ClothCategoryBean.category}</option>
							</c:forEach>
            				<form:errors path="category" cssClass="error"/>
            				</select>
                        </div>
                    </div>
   
                    </div>

                    <div class="form-floating px-3"">
                        <div class=" py-3">
                        <h4>產品亮點</h4>
                    </div>
                    <form:input path="highlight" size='20'/>
                   
                </div>


                <div class="form-floating px-3">
                    <div class=" py-3">
                        <h4>產品描述</h4>
                    </div>
                    <form:textarea class="form-control py-4" path="descrip"  id="TextareaDescrip"
                        style="height: 90px"/>
                    <!-- <label for="floatingTextarea2">產品描述</label> -->
                </div>

              
        </div>
    </div>
</div>
</div>

</form:form>

<div class="row justify-content-center align-items-center py-4 ">

	  <div class="col-2 mt-3">
	       <a href="<c:url value='/productMaintain/DisplayPageProducts?pageNo=${param.pageNo}' />" class="btn btn-primary" >回商品維護頁面</a>    
<!--         <input type="submit" value="回商品維護頁面" class="btn btn-primary" style="width:100px"> -->
    </div>
    <div class="col-2 mt-3">
<!--         <input type="submit" value="確定刪除" class="btn btn-danger" style="width:100px"> -->
        <input type="button" name="delete" value="確定刪除" style="width:100px" class="btn btn-danger"onclick="confirmDelete(${clothBean.id})" /> 
    </div>
</div>


</div>

</div>




























































<div id='main' align='center'>

<div id="backToClothMaintainList">
     <a href="<c:url value='/productMaintain/DisplayPageProducts?pageNo=${param.pageNo}' />" >回維護首頁1</a>    
</div>     
<form:form method="post" modelAttribute="clothBean"   
			enctype="multipart/form-data" >
      
<input type='hidden' id='updateOrDelete' name='_method' > 
  
<table  class="table_color" border="1">
        
   <tr height='40'>
       <td colspan="6" align="center" valign="bottom"> 
           <TABLE style="background:#ffE4C4">
            <TR height='5' >
                <TD align='center' >&nbsp;</TD>
            </TR>
            <TR height='20' >
                <TD  align='center' >
                   <FONT color='#8000FA' size='+2' style="font-weight:900;" >
                      刪除商品資料
                   </FONT>
                </TD>
            </TR>
            <TR height='5' >
                <TD align='center' >&nbsp;</TD>
            </TR>
         </TABLE>
       </td>
   </tr>
   <tr height='36'>
      <td width="45" align="right" class="title_font">商品名稱</td>
      <td colspan="5"> 
          <form:input path="name" size='40'/>
           <form:errors path="name" cssClass="error"/>
      </td>
   </tr>
   <tr height='36'>
      <td width="45" align="right" class="title_font">亮點</td>
      <td width="312" colspan="3">     
           <form:input path="highlight" size='20'/>
           <form:errors path="highlight" cssClass="error"/>
      </td>
      <td width="312" colspan="3">     
           <form:input path="descrip" size='20'/>
           <form:errors path="descrip" cssClass="error"/>
      </td>
      <td width="52" align="right" class="title_font">價格</td>
      <td width="161">
        <form:input path="actualPrice" size='4'/>
           <form:errors path="actualPrice" cssClass="error"/>
       </td>
   </tr>
   <tr height='36'>
      <td width="45" class="title_font" ><div align="right">編號</div></td>
      <td width="160">
           <form:input path="id" size='6'/>
           <form:errors path="id" cssClass="error"/>
      </td>
      <td width="45" class="title_font" ><div align="right">分類</div></td>
      <td width="160">
          <select type="form-select " aria-label="label for the select" id="formSelect" style="display: block;" >
            	<option value="0" label="請挑選" />
          		<c:forEach var="ClothCategoryBean" items="${ClothCategory}">
            	<option value="${ClothCategoryBean.id}">${ClothCategoryBean.category}</option>
<%--             	<form:options  items="${category}" /> --%>
				</c:forEach>
            <form:errors path="category" cssClass="error"/>
            </select>
      </td>

    </tr>

   <tr height='120'>
      <td width="45" align="right" class="title_font">圖片</td>
      <td colspan='5'>
        <table>  
           <tr>
<%--                      src='${pageContext.servletContext.contextPath}/_00_init/getClothImage?id=${clothBean.id}'  /> --%>
             <td><img height='120' width='96' src='../../listClothes/getProductPhoto?id=${cothBean.id}'/>
             </td>
             <td colspan='2'>
                <form:input path="photo" type='file' />
	   	  	 <form:errors path="photo"  cssClass="error" />
             </td>
           </tr>
        </table>
      </td>
</tr>

<tr height='35'>
<td colspan='6' align='center'>
<!--         <input type="button" name="update" value="修改" onclick='updateCloth()'/> -->
        &nbsp;&nbsp;&nbsp;
        <input type="button" name="delete" value="刪除" onclick="confirmDelete(${clothBean.id})" /> 
  </td>
  </tr>
</table>
  <div id="deleteMsg">
         ${ErrMsg.errDBMessage}		 
        <input type="hidden" name="pageNo" value="${param.pageNo}" />
  </div>
</form:form>
<p>&nbsp;</p>

</div>
<!-- 引入共同的頁尾 -->  
<jsp:include page="/fragment/footer.jsp" />
</body>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</html>