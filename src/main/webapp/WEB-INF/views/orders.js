window.onload = function () {
    let updateOrder = document.getElementById("updataOrder");
    let orderId = document.getElementById("orderId").value;

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
        false
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
            alert("請輸入數字")
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
    updateOrder.onclick = function () {
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
            "id=" + orderId +
            "&shipping_address=" + shipping_address +
            "&recipient=" + recipient +
            "&recip_phone=" + recip_phone;
        var url = "<c:url value='/orders/updataOrders' />";
        xhr.open("POST", url);
        xhr.setRequestHeader("Content-Type",
            "application/x-www-form-urlencoded;charset=utf-8");
        xhr.send(requestString);
    }
}
function updateOk(data) {
    alert(data);
    history.go(-1);
}
function getAddOrder() {
    history.go(0);
}
function getOrder(data) {
    var order = JSON.parse(data);
    // var order = data;
    var result = addrest();
    result += "<tr><td>" + order.id + "</td><td>" + order.order_date
        + "</td><td>" + order.shipping_address + "</td><td>"
        + order.shipping_date + "</td><td>" + order.recipient
        + "</td><td>" + order.total_amount
        // + "</td><td>"
        // + order.cancel_tag
        + "</td><td>" + order.recip_phone
        // 						+ "</td><td>"
        // + order.ok_tag
        // 						+ "</td><td><button id='updateOrders'>修改訂單</button></td></tr>";
        + "</td><td>"
        + "<a href=<c:url value='/orders/ordersAlter'/>?" + "id=" + order.id + ">修改</a></td></tr>";
    result += "</table>";
    dataArea.innerHTML = result;
}
function getOrderAll(data) {
    var orders = JSON.parse(data);
    var result = "";
    for (n = 0; n < orders.length; n++) {
        var order = orders[n];
        result += "<table class='table'><tr><th scope='row'>出貨狀態</th><td>" + order.ok_tag +
            "</td></tr ><tr><th scope='row'>配送地址</th><td>" + order.shipping_address +
            "</td></tr><tr><th scope='col'>配送方式</th><td>宅配</td></tr>" +
            "<tr><th scope='row'>收件人</th> <td>" + order.recipient +
            "</td></tr><tr><th scope='row'>總金額</th><td>" + order.total_amount +
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
                + "<a href=<c:url value='/orders/ordersAlter'/>?" + "id=" + order.id + ">修改</a></td></tr>";
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
                + "<a href=<c:url value='/orders/ordersAlter'/>?" + "id=" + order.id + ">修改</a></td></tr>";
        }
    }
    result += "</table>";
    dataArea.innerHTML = result;
}
function addrest() {
    var result = "<table border='1'>" + "<tr>" + "<th>訂單編號</th>"
        + "<th>訂單日期</th>" + "<th>地址</th>" + "<th>配送日期</th>"
        + "<th>收件人</th>" + "<th>總金額</th>"
        + "<th>取消標記</th>"
        + "<th>電話</th>"
        + "<th>完成寄送</th>"
        + "<th>修改訂單</th>" + "</tr>";
    return result;
}