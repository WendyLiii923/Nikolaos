<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <script>
            window.onload = function(){
                let updateOrder = document.getElementById("updataOrder");
                let orderId = document.getElementById("orderId").value;

                updateOrder.onclick = function(){
                    let shipping_address = document.getElementById("shipping_address").value;
					let recipient = document.getElementById("recipient").value;
					let recip_phone = document.getElementById("recip_phone").value;
                    var xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function () {
							if (xhr.readyState == 4 && xhr.status == 200) {
								updateOk(xhr.responseText);
							}
						}
                        var requestString = 
                        "id="+orderId+
                        "&shipping_address=" + shipping_address+
                        "&recipient=" + recipient +
                        "&recip_phone=" + recip_phone;
                        var url = "<c:url value='/orders/updataOrders' />";
                        xhr.open("POST", url);
                        xhr.setRequestHeader("Content-Type",
							"application/x-www-form-urlencoded;charset=utf-8");
                        xhr.send(requestString);
                }
            }
            function updateOk (data){
            	alert(data);
                history.go(-1);
            }
            
            </script>
        </head>
        <body>
            <div>
            <table>
            <tr><th>訂單編號</th><td>${order.id}<input type="hidden" id="orderId"  value='${order.id}'></td></tr>
            <tr><th>訂單地址</th><td><input type="text" required  size="30" id="shipping_address" value='${order.shipping_address}'></td></tr>
            <tr><th>收件人</th><td><input type="text" required maxlength="8" size="10" id="recipient" value='${order.recipient}'></td></tr>
            <tr><th>連絡電話</th><td><input type="tel"  required maxlength="10" size="10" id="recip_phone" value='${order.recip_phone}'></td></tr>
            <tr><th>訂單完成</th><td>${order.ok_tag}</td></tr>
            <tr><th>取消訂單</th><td>${order.cancel_tag}</td></tr>
            <tr><th>購買日期</th><td>${order.order_date}</td></tr>
            <tr><th>配送日期</th><td>${order.shipping_date}</td></tr>
            </table>
            </div>
            <a type="button">123</a>
            <button id="updataOrder">確認修改</button>
        </body>
        </html>