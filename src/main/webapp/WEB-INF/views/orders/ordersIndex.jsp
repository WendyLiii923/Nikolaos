<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<script >
				window.onload = function () {
					let selectOrder = document.getElementById("selectOrder");
					let orderAll = document.getElementById("orderAll");
					let orderOk = document.getElementById("orderOk");
					let orderUnok = document.getElementById("orderUnok");
					let btnAddOrder = document.getElementById("addOrder");


					
					btnAddOrder.onclick = function () {
						let shipping_address = document.getElementById("shipping_address").value;
						let recipient = document.getElementById("recipient").value;
						let total_amount = document.getElementById("total_amount").value;
						let recip_phone = document.getElementById("recip_phone").value;
						// 						let member_id = document.getElementById("member_id").value;
						var xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function () {
							if (xhr.readyState == 4 && xhr.status == 200) {
								getAddOrder(xhr.responseText);
							}
						}
						// 							var requestString ={
						// 							"shipping_address" : shipping_address,
						// 							"recipient" : recipient.value,
						// 							"total_amount" : total_amount,
						// 							"recip_phone" : recip_phone
						// 							}

						var requestString = "shipping_address=" + shipping_address
							+ "&recipient=" + recipient + "&total_amount="
							+ total_amount + "&recip_phone=" + recip_phone;
						// 							+"&member_id="+member_id;
						var url = "<c:url value='/orders/addOrder' />"
						xhr.open("POST", url);
						// 	xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
						xhr.setRequestHeader("Content-Type",
							"application/x-www-form-urlencoded;charset=utf-8");
						// xhr.send(JSON.stringify(requestString));
						xhr.send(requestString);

					}
					orderUnok.onclick = function () {
						let dataArea = document.getElementById("dataArea");
						var xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function () {
							if (xhr.readyState == 4 && xhr.status == 200) {
								getOrderUnok(xhr.responseText);
							}
						}
						xhr.open("GET", "<c:url value='/orders/ordersAll' />");
						xhr.send();
					}
					orderOk.onclick = function () {
						let dataArea = document.getElementById("dataArea");
						var xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function () {
							if (xhr.readyState == 4 && xhr.status == 200) {
								
								getOrderOk(xhr.responseText);
							}
						}
						xhr.open("GET", "<c:url value='/orders/ordersAll' />");
						xhr.send();
						
					}
					orderAll.onclick = function () {
						let dataArea = document.getElementById("dataArea");
						var xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function () {
							if (xhr.readyState == 4 && xhr.status == 200) {
								getOrderAll(xhr.responseText);
							}
						}
						xhr.open("GET", "<c:url value='/orders/ordersAll' />");
						xhr.send();
					}
					
					selectOrder.onclick = function () {
						var orderId = document.getElementById("orderId");
						if (orderId.value == "") {
							alert("???????????????")
							return;
						}
						var dataArea = document.getElementById("dataArea");
						var xhr = new XMLHttpRequest();

						// 						var a = {
						// 							id : orderId
						// 						}
						var url = "<c:url value='/orders/order' />?" + "id=" + orderId.value;
						// 	xhr.setRequestHeader("Content-Type","text/plain;charset=UTF-8");
						// 	xhr.open("POST", "<c:url value='/order' />");
						// 	xhr.send(JSON.stringify(a));
						xhr.onreadystatechange = function () {
							if (xhr.readyState == 4 && xhr.status == 200) {
								getOrder(xhr.responseText);
						
							}
						}
						xhr.open("GET", url);
						xhr.send();
					}
				}

				function cancelorder() {
					alert("???????????????")
					history.go(0)
				}
				
				function getOrder(data) {
					if (data == "") {
						alert("????????????");
						document.getElementById("orderId").value ="";
						return
					}
					
					var order = JSON.parse(data);
					// var order = data;
					var result = addrest();
					result += "<tr><td>" + order.id + "</td><td>" + order.order_date
						+ "</td><td>" + order.shipping_address + "</td><td>"
						+ order.shipping_date + "</td><td>" + order.recipient
						+ "</td><td>" + order.total_amount
						+ "</td><td>"
						+ "<a href=<c:url value='/orders/cancelOrder'/>?" + "id="  + order.id + ">??????</a>"
						+ "</td><td>" 
						+ order.recip_phone
						+ "</td><td>"
						+ order.ok_tag
						// + "</td><td><button id='updateOrders'>????????????</button></td></tr>";
						+ "</td><td>"
						+ "<a href=<c:url value='/orders/ordersAlter'/>?" + "id=" + order.id + ">??????</a></td></tr>";
					result += "</table>";
					dataArea.innerHTML = result;
				}
				function getOrderAll(data) {
					var orders = JSON.parse(data);
					var result = "";
					for (n = 0; n < orders.length; n++) {
						var order = orders[n];
						result += "<table class='table'><tr><th scope='row'>????????????</th><td>" + order.ok_tag +
							"</td></tr ><tr><th scope='row'>????????????</th><td>" + order.shipping_address +
							"</td></tr><tr><th scope='col'>????????????</th><td>??????</td></tr>" +
							"<tr><th scope='row'>?????????</th> <td>" + order.recipient +
							"</td></tr><tr><th scope='row'>?????????</th><td>" + order.total_amount +
							"</td></tr></table >" +
							"<hr>"
					}
					dataArea.innerHTML = result;
				}
				function getOrderUnok(data) {
					var orders = JSON.parse(data);
					var result = addrest();
					for (n = 0; n < orders.length; n++) {
						var order = orders[n];
						if (!order.ok_tag) {
							result += "<tr><td>" + order.id + "</td><td>"
								+ order.order_date + "</td><td>"
								+ order.shipping_address + "</td><td>"
								+ order.shipping_date + "</td><td>" + order.recipient
								+ "</td><td>" + order.total_amount + "</td><td>"
								+ order.cancel_tag
								+ "</td><td>"
								+ order.recip_phone
								+ "</td><td>"
								+ order.ok_tag
								+ "</td><td>"
								+ "<a href=<c:url value='/orders/ordersAlter'/>?" + "id=" + order.id + ">??????</a></td></tr>";
						}
					}
					result += "</table>";
					dataArea.innerHTML = result;
				}
				function getOrderOk(data) {
					var orders = JSON.parse(data);
					result = addrest();
					for (n = 0; n < orders.length; n++) {
						var order = orders[n];
						if (order.ok_tag) {
							result += "<tr><td>" + order.id + "</td><td>"
								+ order.order_date + "</td><td>"
								+ order.shipping_address + "</td><td>"
								+ order.shipping_date + "</td><td>" + order.recipient
								+ "</td><td>" + order.total_amount + "</td><td>"
								+ order.cancel_tag
								+ "</td><td>"
								+ order.recip_phone
								+ "</td><td>"
								+ order.ok_tag
								+ "</td><td>"
								+ "<a href=<c:url value='/orders/ordersAlter'/>?" + "id=" + order.id + ">??????</a></td></tr>";
						}
					}
					result += "</table>";
					dataArea.innerHTML = result;
				}
				function addrest() {
					var result = "<table border='1'>" + "<tr>" + "<th>????????????</th>"
						+ "<th>????????????</th>" + "<th>??????</th>" + "<th>????????????</th>"
						+ "<th>?????????</th>" + "<th>?????????</th>"
						+ "<th>????????????</th>"
						+ "<th>??????</th>"
						+ "<th>????????????</th>"
						+ "<th>????????????</th>" + "</tr>";
					return result;
				}


			</script>
		</head>

		<body>

			<div>
				<!-- 			<select id='city'> -->
				<!-- 			  <option value='Asia/Taipei'>??????</option> -->
				<!-- 			</select> -->
				<button id="selectOrder">????????????</button>
				<button id="orderAll">????????????</button>
				<button id='orderOk'>??????????????????</button>
				<button id="orderUnok">???????????????</button>



				<!-- <input id="orderId" type="text" value="2" readonly="readonly"> -->
				<input id="orderId" type="text">


				<!-- <div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="check1" /> 
					<label class="form-check-label"/>
				</div>  -->
			</div>
			<hr>
			<div id='dataArea'>&nbsp;</div>
			<hr>
			<div>
				?????????<input id="recipient" type="text"><br>
				????????????<input id="shipping_address" type="text"><br>
				?????????<input id="total_amount" type="text" value="2000" readonly="readonly"><br>
				???????????????<input id="recip_phone" type="text"><br>
				<!-- ????????????<input id="member_id" type="text"><br> -->
				<button id="addOrder">????????????</button>
			</div>
		</body>

		</html>