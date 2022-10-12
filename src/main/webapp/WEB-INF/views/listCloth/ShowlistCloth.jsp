<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <!DOCTYPE html>
            <html>

            <head>
               <meta charset="UTF-8">
               <title>顯示商品資訊</title>
               <style type="text/css">
                  #paging {
                     position: relative;
                     left: 120px;
                     top: 10px;
                  }

                  #pfirst {
                     position: relative;
                     left: 2px;
                     top: 2px;
                  }

                  #pprev {
                     position: relative;
                     left: 2px;
                     top: 2px;
                  }

                  #pnext {
                     position: relative;
                     left: 2px;
                     top: 2px;
                  }

                  #plast {
                     position: relative;
                     left: 2px;
                     top: 2px;
                  }

                  #main {
                     position: relative;
                     top: 5px;
                     left: 40px;
                     width: 100%;
                  }

                  #content {
                     width: 820px;
                     margin-left: auto;
                     margin-right: auto;
                  }
                  
                      <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
        rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
               </style>
            </head>

            <body style="background:;">
               <!-- 下列敘述設定變數funcName的值為SHO，topMVC.jsp 會用到此變數 -->
               <c:set var="funcName" value="SHO" scope="session" />
               <!-- 引入共同的頁首 -->
               <jsp:include page="../../fragment/header.jsp" />
               <!-- 判斷購物車內是否有商品 -->
               <c:choose>
                  <c:when test="${ShoppingCart.itemNumber > 0}">
                     <!-- 購物車內有一項以上的商品 -->
                     <c:set var="cartContent" value="購物車內有${ShoppingCart.itemNumber}項商品" />
                  </c:when>
                  <c:otherwise>
                     <!-- 購物車內沒有商品 -->
                     <c:set var="cartContent" value="您尚未購買任何商品" />
                  </c:otherwise>
               </c:choose>
               
               
               <!-- <div id='content' style="position:fixed; top:100px; left:130px;"> -->
               <TABLE style="width:820; border:2px solid black; ">
                  <!--   購物車的標題   -->
                  <TR>
                     <TD colspan='4'>
                        <TABLE style="background:; border:1px solid black; width:820px">
                           <TR height='2'>
                              <TH width="270">&nbsp;</TH>
                              <TH width="280">&nbsp;</TH>
                              <TH width="270">&nbsp;</TH>
                           </TR>
                           <TR height='10'>
                              <TD width="240">&nbsp;</TD>
                              <TD width="320" align='center'>
                                 <FONT color='' size='+2' style="font-weight:900;">
                                 ${AppName}
                                 </FONT>
                              </TD>
                              <TD width="270" align='right'>
                                 <FONT color='red' size='-1'>
                                    ${cartContent}
                                 </FONT>
                              </TD>
                           </TR>

                           <TR height='2'>
                              <TD width="270">
                                 <%-- <A
                                    href="<c:url value='/_04_ShoppingCart/ShowCartContent.jsp?pageNo=${pageNo}' />">
                                    --%>
                                    <A href="<c:url value='/_04_ShoppingCart/ShowCartContent?pageNo=${pageNo}' />">
                                       購物清單
                                    </A>
                              </TD>
                              <TD width="280">&nbsp;</TD>
                              <TD width="270" align='right'>
                                 <FONT color='red' size='-1'>
                                    金額小計(OK):
                                    <c:out value="${ShoppingCart.subtotal}" default="0" /> 元
                                 </FONT>
                              </TD>
                           </TR>
                        </TABLE>
                     </TD>
                  </TR>
                  <!-- 	clothMap -->
                  <c:forEach varStatus="stVar" var="entry" items="${products_DPP}">
                  
                  
                  
                      <!-- Shop Details Section Begin -->
    <section class="shop-details">
        <div class="product__details__pic">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="product__details__breadcrumb">
                            <a href="./index.html">Home</a>
                            <a href="./shop.html">Shop</a>
                            <span>Product Details</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-3">
                        <ul class="nav nav-tabs" role="tablist">
                          
                        </ul>
                    </div>
                    <div class="col-lg-6 col-md-9">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__pic__item">
                                    <img  src="getProductPhoto?id=${entry.value.id}" alt="">
                                
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="product__details__content">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-8">
                        <div class="product__details__text">
                                   <h4>商品：${entry.value.name}</h4>
                                    <!-- ClothService->ClothDao 抓商品名稱     -->      
                            		 <h5>$價錢: ${entry.value.actualPrice}</h5>
                                    <!-- ClothService->ClothDao 抓商品價格     -->      
									
								
									<div class="px-4">	
                                    <h4>分類：${entry.value.category}</h4><br>
                                    <!--  ClothService->ClothDao  抓商品分類                      -->
                                    </div>
                                   <div class="px-4">	
                                    亮點：${entry.value.highlight}<br>
                                    <!--  ClothService->ClothDao  抓商品亮點                      -->
                             		

                                    <h5>產品描述：${entry.value.descrip}</h5>
                                    <!--  ClothService->ClothDao  抓商品敘述                      -->
                               
                               
                               
							  <c:choose>
                              <c:when test="${entry.value.stock > 0}">
                                 <!-- 
                        FORM表單的資料會送後端的 
                        _03_listBooks.controller.BuyBookServlet.java來處理 
                   -->
                                 <FORM action="<c:url value='/listClothes/BuyCloth.do' />" method="POST">
                                    購買數量:
                                    <div  class="quantity">
                                    <select name='qty' class="pro-qty" >
                                       <option value="1">1</option>
                                       <option value="2">2</option>
                                       <option value="3">3</option>
                                       <option value="4">4</option>
                                       <option value="5">5</option>
                                       <option value="6">6</option>
                                       <option value="7">7</option>
                                       <option value="8">8</option>
                                       <option value="9">9</option>
                                       <option value="10">10</option>
                                    </select>
                                    </div>
                                    <!-- 這些隱藏欄位都會送到後端 -->
                                    <Input type='hidden' name='id' value='${entry.value.id}'>
                                    <%-- <Input type='hidden' name='pageNo' value='${param.pageNo}'> --%>
                                     <Input type='submit' class="primary-btn" value='加入購物車'><br>
                                 </FORM>

                              </c:when>
                              <c:otherwise>
                                 <font color='blue'>抱歉此產品目前無庫存</font>
                              </c:otherwise>
                           </c:choose>
							
							
							
                           
                            <div class="product__details__cart__option">
                                <div class="quantity">
                                    <div class="pro-qty">
                                        <input type="text" value="1">
                                    </div>
                                </div>
                            
                                
                            </div>
                            <div class="product__details__btns__option">
                                <a href="#"><i class="fa fa-heart"></i> add to wishlist</a>
                                <a href="#"><i class="fa fa-exchange"></i> Add To Compare</a>
                            </div>
                            <div class="product__details__last__option">
                                <h5><span>Guaranteed Safe Checkout</span></h5>
                                <img src="img/shop-details/details-payment.png" alt="">
                    
                            </div>
                            
                            
                            
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <!-- <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-5"
                                        role="tab">Description</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-6" role="tab">Customer
                                        Previews(5)</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-7" role="tab">Additional
                                        information</a>
                                </li>
                            </ul> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Details Section End -->
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                     <!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
                     <!-- <c:set var="rowColor" value="#DEFADE" /> -->
                     <!-- <c:if test="${ stVar.count % 2 == 0 }"> -->
                     <!-- <c:set var="rowColor" value="#FFEBFF" /> -->
                     <!-- </c:if> -->

                     <!-- <TR bgColor="${rowColor}" height='25'> -->
                     <!-- <TD rowspan='3' width='64'> -->
                     <!-- 
                 getImage所對應的Servlet會到資料庫讀取圖片並傳送給前端的瀏覽器
              -->
                     <!--         <img height='100' width='80'  -->

                     <%-- src="<c:url value='/listClothes/getClothImage?id=${entry.value.id}' />"> --%>
                        </TD>

                        <TD height='32' width='560'>
                           <img alt="" src="getProductPhoto?id=${entry.value.id}">

                        </TD>

                        <TD height='32' width='560'>
                           <TABLE border='1'>
                              <TR height='30'>
                                 <TD width='560'>
                                    商品：${entry.value.name}
                                    <!-- ClothService->ClothDao 抓商品名稱     -->
                                 </TD>

                                 <TD width='560'>
                                    分類：${entry.value.category}
                                    <!--  ClothService->ClothDao  抓商品分類                      -->
                                 </TD>

                                 <TD width='560'>
                                    敘述：${entry.value.descrip}
                                    <!--  ClothService->ClothDao  抓商品敘述                      -->
                                 </TD>

                                 <TD width='560'>
                                    亮點：${entry.value.highlight}
                                    <!--  ClothService->ClothDao  抓商品亮點                      -->
                                 </TD>	
                              </TR>
                           </TABLE>
                        </TD>
                        <TD rowspan='3' width='180' align='center'>
                           <c:choose>
                              <c:when test="${entry.value.stock > 0}">
                                 <!-- 
                        FORM表單的資料會送後端的 
                        _03_listBooks.controller.BuyBookServlet.java來處理 
                   -->
                                 <FORM action="<c:url value='/listClothes/BuyCloth.do' />" method="POST">
                                    購買數量:
                                    <select name='qty'>
                                       <option value="1">1</option>
                                       <option value="2">2</option>
                                       <option value="3">3</option>
                                       <option value="4">4</option>
                                       <option value="5">5</option>
                                       <option value="6">6</option>
                                       <option value="7">7</option>
                                       <option value="8">8</option>
                                       <option value="9">9</option>
                                       <option value="10">10</option>
                                    </select>
                                    <!-- 這些隱藏欄位都會送到後端 -->
                                    <Input type='hidden' name='id' value='${entry.value.id}'>
                                    <%-- <Input type='hidden' name='pageNo' value='${param.pageNo}'> --%>
                                       <Input type='submit' value='加入購物車'>
                                 </FORM>

                              </c:when>
                              <c:otherwise>
                                 <font color='blue'>抱歉此產品目前無庫存</font>
                              </c:otherwise>
                           </c:choose>

                        </TD>
                        </TR>
                        <TR height='32' ">
<%--                         bgColor="${rowColor} --%>
                           <TD width='560'>
                              <TABLE border='1'>
                                 <TR height='31'>
                                    <%-- <TD width='420'>作者：${entry.value.author}
                           </TD> --%>
                           <%-- <TD width='140'>出版社：${fn:substring(entry.value.companyBean.name,0,2)}</TD> --%>
                        </TR>
               </TABLE>
               </TD>
               </TR>
               <TR height='32'>
<%--                 bgColor="${rowColor}" --%>
                  <TD width='560'>
                     <TABLE border='1'>
                        <TR height='31'>
                           <%-- <TD width='160'>書號：${entry.value.bookNo}
                  </TD> --%>
                  <TD width='140'>訂價：
                     <fmt:formatNumber value="${entry.value.actualPrice}" pattern="####" />元
                  </TD>


               </TR>
               </TABLE>
               </TD>
               </TR>
               </c:forEach>
               </TABLE>
               <!-- </div> -->
               <!-- 引入共同的頁尾 -->
               <jsp:include page="../../fragment/footer.jsp" />
               
                   <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
            </body>

            </html>