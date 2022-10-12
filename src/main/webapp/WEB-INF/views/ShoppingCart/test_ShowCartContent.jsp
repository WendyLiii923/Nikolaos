<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>
    
<%
response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility 
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function confirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='/ShoppingCart/UpdateItem.do?cmd=DEL&id=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}
function modify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		document.forms[0].action="<c:url value='/ShoppingCart/UpdateItem.do?cmd=MOD&id=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57)){
      return false;
   }
   return true;
}
function Checkout(qty) {
	if (qty == 0)  {
		alert("無購買任何商品，不需結帳");
		return false;
	}
	if (confirm("再次確認訂單內容 ? ") ) {
		return true;
	} else {
		return false;
	}
}
function Abort() {
	if (confirm("確定放棄購物 ? ") ) {
		return true;
	} else {
		return false;
	}
}
</script>

<meta charset="UTF-8">
<title>購物清單</title>
 <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
        rel="stylesheet">

</head>
<body >
<!-- style="background:#EBFFEB;" -->

<c:set var="funcName" value="CHE" scope="session"/>
<%-- <jsp:include page="/fragment/topMVC.jsp" /> --%>

<c:choose>
   <c:when test="${ShoppingCart.subtotal > 0}">
      <c:set var="subtotalMessage" value="金額小計:${ShoppingCart.subtotal} 元"/>
      <c:set var="subtotal" value="${ShoppingCart.subtotal}"/>  
   </c:when>
   <c:otherwise>
      <c:set var="subtotalMessage" value="金額小計:  0 元"/>
      <c:set var="subtotal" value="0"/>                
   </c:otherwise>
</c:choose>
              <!-- 引入共同的頁首 -->
               <jsp:include page="../../fragment/header.jsp" /> 

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
              <c:forEach varStatus="vs" var="anEntry" items="${ShoppingCart.content}">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="shopping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>商品</th>
<!--                                     <th>亮點</th> -->
                                    <th>數量</th>
                                    <th>單價</th>
                                    <th>刪除</th>
                                    <th></th>
                                </tr>
                            </thead>
                            
                          
                            <tbody>
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="img/shopping-cart/cart-1.jpg" alt="">
                                        </div>
                                        <div class="product__cart__item__text">
                                            <h6>${anEntry.value.name}</h6>

                                        </div>
                                    </td>
                                    <td class="quantity__item">
                                        <div class="quantity">
                                    <Input id="newQty${vs.index}" style="width:28px;text-align:right" name="newQty" type="text" value="<fmt:formatNumber value="${anEntry.value.quantity}" />" name="qty" onkeypress="return isNumberKey(event)"  />
<!--                                             <div class="pro-qty-2"> -->
<!--                                                 <input type="text" value="1"> -->
<!--                                             </div> -->
                                        </div>
                                    </td>
                                    <td class="cart__price">${anEntry.value.actualPrice}</td>
                                     <td class="cart__close">
                                   <Input type="button" name="delete" value="刪除" onclick="confirmDelete(${anEntry.key})"></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="continue__btn">
              						<a href="<c:url value='/listClothes/DisplayPageProducts' />">繼續購物</a>
                            </div>
                    
                        </div>
                         <div class="col-lg-4 col-md-4 col-sm-4">
                              <div class="continue__btn ">
              						<a href="<c:url value='/ShoppingCart/abort' />" onClick="return Abort();">放棄購物</a>
                            </div>
                    
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4">
                        	
            
                            <div class="continue__btn update__btn">
<!--                                 <a href="#"><i class="fa fa-spinner"></i> Update cart</a> -->
                                <Input type="button" name="update"  value="修改數量" onclick="modify(${anEntry.key}, ${anEntry.value.quantity}, ${vs.index})">
                            </div>
                        </div>
                    </div>
                </div>
       
               
                <div class="col-lg-4">

                    <div class="cart__total">
                        <h6>Cart total</h6>
                        <ul>
                         <c:set var="VAT" value="${subtotal*0.05 + 0.0001}"/>
                            <li>稅 <span><td ><fmt:formatNumber value="${VAT}" pattern="#,###,###" />元</td></span></li>
                            <li>總計 <span> <td align='right'><fmt:formatNumber value="${subtotal + VAT }" pattern="#,###,###" />元</td></span></li>
                        </ul>
<!--                         <a href="#" class="primary-btn">Proceed to checkout</a> -->
                         <a href="<c:url value='/ShoppingCart/checkout' />" class="primary-btn" onClick="return Checkout(${subtotal});">再次確認後結帳</a>
                    </div>
                </div>
                
            </div>
        </div>
         </c:forEach>    
    </section>
    <!-- Shopping Cart Section End -->

















              <!-- 引入共同的頁尾 -->
               <jsp:include page="../../fragment/footer.jsp" /> 
                  <!-- Js Plugins -->
<!--     <script src="js/jquery-3.3.1.min.js"></script> -->
<!--     <script src="js/bootstrap.min.js"></script> -->
<!--     <script src="js/jquery.nice-select.min.js"></script> -->
<!--     <script src="js/jquery.nicescroll.min.js"></script> -->
<!--     <script src="js/jquery.magnific-popup.min.js"></script> -->
<!--     <script src="js/jquery.countdown.min.js"></script> -->
<!--     <script src="js/jquery.slicknav.js"></script> -->
<!--     <script src="js/mixitup.min.js"></script> -->
<!--     <script src="js/owl.carousel.min.js"></script> -->
<!--     <script src="js/main.js"></script> -->
</body>
</html>