<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
<script type="text/javascript">
function cancelOrder() {
	if (confirm("確定取消此份訂單 ? ") ) {
		// 接收此資料的Servlet會使用 finalDecision 參數的值
		document.forms[0].finalDecision.value = "CANCEL";		
		document.forms[0].action="<c:url value='cancelOrder' />";
		document.forms[0].submit();	
		return;
	} else {
		return;
	}
}
function reconfirmOrder() {
	var sa = document.getElementById('ShippingAddress').value;
	if  (sa === "") {
		window.alert ('出貨地址不能是空白');
		return ; 
	}
	if (confirm("確定送出此份訂單 ? ") ) {
		// 接收此資料的Servlet會使用 finalDecision 參數的值
		document.forms[0].finalDecision.value = "ORDER";
		document.forms[0].action="<c:url value='/ShoppingCart/ProcessOrder.do' />";
// 		document.forms[0].method="POST";
		document.forms[0].submit();
		return;
	} else {
		return;
	}
}
</script>
<meta charset="UTF-8">

<!-- 取得今天的日期，今天的日期應當在最後確認時才取得 -->
<title>訂單明細資訊確認</title>
</head>
<body style="background:;">
<c:set var="funcName" value="CHE" scope="session"/>

<jsp:include page="/fragment/header.jsp" />



    <!-- Checkout Section Begin -->
    <section class="checkout spad">
    <FORM style="margin: 0 auto; width:750px;" action="<c:url value='/ShoppingCart/ProcessOrder.do' />" method="POST" >
        <div class="container">
            <div class="checkout__form">
                <form action="#">
                    <div class="row">
                        <div class="col-lg-6 col-md-4">
<!--                             <h6 class="coupon__code"><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click -->
<!--                                     here</a> to enter your code</h6> -->
                            <h5 class="checkout__title">出貨資料</h5>
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="checkout__input">
                                        <p>會員編號：${loginMember.id} <span></span></p>
                                        <input type="text">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="checkout__input">
                                        <p>客戶姓名：${loginMember.name}<span></span></p>
                                        <input type="text">
                                    </div>
                                </div>
                                    <div class="col-lg-4">
                                    <div class="checkout__input">
                                        <p>地址${loginMember.address}<span></span></p>
                                        <input type="text">
                                    </div>
                                </div>
                            </div>
                     
                            <div class="checkout__input">
                                <p>出貨地址：<span></span></p>
                                  <Input style="background:;" size="60" type="text" id='ShippingAddress' 
                   name="ShippingAddress" value="${loginMember.address}">
                   <!--          	MemberBean.address -->
            		 <font color='red'>${errorMsg.ShippingAddress}</font>
<!--                                 <input type="text" placeholder="Street Address" class="checkout__input__add"> -->
<!--                                 <input type="text" placeholder="Apartment, suite, unite ect (optinal)"> -->
                            </div>
                            <div class="checkout__input">
                                <p>發票抬頭 : </p>
                                <Input style="background:;" size="50" type="text" name="InvoiceTitle" value="" >
                            </div>
                            
                            
                            
                             <div class="checkout__input" >
                              
<!--                                 <Input style="background:;" size="50" type="text" name="InvoiceTitle" value="" > -->
                                <input type="button" class="site-btn"  name="CancelBtn" value="取消訂單" onclick="cancelOrder()">
                            </div>
                            
                            
<c:forEach varStatus="vs" var="entry" items="${ShoppingCart.content}">
                              <div class="checkout__input">
<!--                                 <h4>商品名稱</h4> -->
<!--                                 <input type="text"> -->
<%--                                 ${entry.value.name} --%>
                            </div>
                            
                            <div class="checkout__input">
<!--                                 <h5>產品亮點</h5> -->
<%--                             	${entry.value.highlight} --%>
<!--                                 <input type="text"> -->
                            </div>
<!--                             <div class="checkout__input"> -->
<!--                                 <p>Postcode / ZIP<span>*</span></p> -->
<!--                                 <input type="text"> -->
<!--                             </div> -->
<!--                             <div class="row"> -->
<!--                                 <div class="col-lg-6"> -->
<!--                                     <div class="checkout__input"> -->
<!--                                         <p>Phone<span>*</span></p> -->
<!--                                         <input type="text"> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <div class="col-lg-6"> -->
<!--                                     <div class="checkout__input"> -->
<!--                                         <p>Email<span>*</span></p> -->
<!--                                         <input type="text"> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </div> -->
                            <div class="">
<!--                                 <label for="acc"> -->
<!--                                     Create an account? -->
<!--                                     <input type="checkbox" id="acc"> -->
<!--                                     <span class="checkmark"></span> -->
<!--                                 </label> -->
                               
                            </div>

                       
                            
 </c:forEach>
                        </div>
                        <div class="col-lg-6 col-md-4">
                        
                        
   <c:forEach varStatus="vs" var="entry" items="${ShoppingCart.content}">
                            <div class="checkout__order">
                                <h4 class="order__title">訂單內容</h4>
                                <div class="checkout__order__products">產品<span>小計</span></div>
                                <ul class="checkout__total__products">
                                    <li>${entry.value.name} <span>${entry.value.actualPrice} </span></li>
                  
                                </ul>
                                
                                   <ul class="checkout__total__products">
                                    <li>數量 <span>${entry.value.quantity} </span></li>
                  
                                </ul>
                                <ul class="checkout__total__all">
                            <li>
            <TD colspan='5' style="text-align:right;font-size: 11pt;" >稅:</TD>
          	<c:set var="VAT" value="${ShoppingCart.subtotal*0.05 + 0.0001}"/>
			<fmt:formatNumber value="${VAT}" pattern="#,###,###" />元</TD>
			</li>

 <li>
  		<TD colspan='5' style="text-align:right;font-size: 11pt;" >總計金額：</TD>
          <TD style="text-align:right;font-size: 11pt;color:#AA0200;" >
          <fmt:formatNumber value="${ShoppingCart.subtotal + VAT }" pattern="#,###,###" />元</TD>
 	</li>
<!--                                     <li>總計 <span>$750.99</span></li> -->
                                </ul>
                                <div class="checkout__input__checkbox">
                                    <label for="acc-or">
                                        Create an account?
                                        <input type="checkbox" id="acc-or">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                         
                                <div class="checkout__input__checkbox">
                                    <label for="payment">
                                        Check Payment
                                        <input type="checkbox" id="payment">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <div class="checkout__input__checkbox">
                                    <label for="paypal">
                                        Paypal
                                        <input type="checkbox" id="paypal">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
       
<!--                                 <button type="submit" class="site-btn">確定送出</button> -->
                                <input type="button" class="site-btn" name="OrderBtn" value="確定送出" onclick="reconfirmOrder()">
                            </div>
    </c:forEach>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        </FORM>
    </section>
    <!-- Checkout Section End -->






























































<div style="text-align:center">
<h4>請確認下列訊息：</h4>
<FORM style="margin: 0 auto; width:750px;" action="<c:url value='/ShoppingCart/ProcessOrder.do' />" method="POST" >
   <TABLE border='1' style="background:; border-color:rgb( 100, 100, 255); border-style: outset; width:810;">
      <TR >
         <TD style="text-align:left; border-color: #FFBD32; border-style: ridge;">
         	會員編號：${loginMember.memberId} 
<!--          	MemberBean.memberId -->
         </TD>
         <TD style="text-align:left; border-color: #FFBD32; border-style: ridge;">
         	客戶姓名：${loginMember.name}
         	<!--          	MemberBean.name -->
         </TD>
         <TD style="text-align:left; border-color: #FFBD32; border-style: ridge;">
<%--          	訂單日期：<fmt:formatDate value="${SYSTEM.utilDate}" pattern="yyyy-MM-dd"/> --%>
         	訂單日期：${SYSTEM.today}
         </TD>
      </TR>
      <TR>
         <TD colspan='3' style="text-align:left; border-color: #FFBD32; border-style: ridge;">
         	會員地址：${loginMember.address}
         </TD>
      </TR>
      <TR>
         <TD colspan='3' style="text-align:left; border-color: ; border-style: ;">
                   出貨地址：<Input style="background:;" size="60" type="text" id='ShippingAddress' 
                   name="ShippingAddress" value="${loginMember.address}">
                   <!--          	MemberBean.address -->
                   <font color='red'>${errorMsg.ShippingAddress}</font>
         </TD>
      </TR>
      <TR>
         <TD colspan='3' style="text-align:left; border-color: #FFBD32; border-style: ridge;">
                   統一編號：<Input style="background:;" maxlength="8" type="text" 
                   name="BNO" value="">
         </TD>
      </TR>
      <TR>
         <TD colspan='3' style="text-align:left; border-color: #FFBD32; border-style: ridge;">
                                   發票抬頭：<Input style="background:;" size="50" type="text" 
                      name="InvoiceTitle" value="" >
         </TD>
      </TR>
    
      <TR>
         <TD colspan='3'>
         
   <TABLE border='1' style="background:; border-color:rgb( 100, 100, 255); " >
      
     <TR><TH style="text-align:center;font-size: 12pt;" width="350">產品</TH> 
         <TH style="text-align:center;font-size: 12pt;" width="80">亮點</TH>
         <TH style="text-align:center;font-size: 12pt;" width="80">敘述</TH>
         <TH style="text-align:center;font-size: 12pt;" width="80">單價</TH>
         <TH style="text-align:center;font-size: 12pt;" width="60">數量</TH>
         <TH style="text-align:center;font-size: 12pt;" width="110">小計</TH></TR>
     
     <c:forEach varStatus="vs" var="entry" items="${ShoppingCart.content}">
                                                    
        <TR height='16'>
          <TD style="text-align:left  ;font-size: 11pt;">${entry.value.name}</TD>
          <TD style="text-align:center;font-size: 11pt;">
          	${entry.value.highlight}
          </TD>

          <TD style="text-align:right ;font-size: 11pt;">
          	<fmt:formatNumber value="${entry.value.actualPrice}" pattern="#,###" />元
          </TD>
          <TD style="text-align:right ;font-size: 11pt;"> 
          	${entry.value.quantity}
          </TD>
          <TD style="text-align:right ;font-size: 11pt;">
          	<fmt:formatNumber 
          	value="${entry.value.actualPrice* entry.value.quantity}" pattern="#,###,###" />元
          </TD>
        </TR>
     </c:forEach>
     
        <TR height='16'>
          <TD style="text-align:right;font-size: 11pt;" colspan='5' >合計金額：</TD>
          <TD style="text-align:right;font-size: 11pt;" >
          <fmt:formatNumber value="${ShoppingCart.subtotal}" pattern="#,###,###" />元</TD>
                  
        </TR>
        <TR>
          <TD colspan='5' style="text-align:right;font-size: 11pt;" >營業稅：</TD>
          <c:set var="VAT" value="${ShoppingCart.subtotal*0.05 + 0.0001}"/>
          <TD style="text-align:right;font-size: 11pt;" > 
          <fmt:formatNumber value="${VAT}" pattern="#,###,###" />元</TD>
        </TR>
        <TR>
          <TD colspan='5' style="text-align:right;font-size: 11pt;" >總計金額：</TD>
          <TD style="text-align:right;font-size: 11pt;color:#AA0200;" >
          <fmt:formatNumber value="${ShoppingCart.subtotal + VAT }" pattern="#,###,###" />元</TD>
        </TR>
   </TABLE>
          </TD>
      </TR>
 
   </TABLE><P/>
   <input type="hidden" name="finalDecision"  value="">   
   <input type="button" name="OrderBtn"  value="確定送出" onclick="reconfirmOrder()">
   <input type="button" name="CancelBtn" value="取消訂單" onclick="cancelOrder()">
</FORM>
</div>











<jsp:include page="/fragment/footer.jsp" />

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