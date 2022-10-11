window.onload = function () {
    var UnOkOrders = document.getElementById("UnOkOrders");
    var OkOrders = document.getElementById("OkOrders")
    var cancelOrders = document.getElementById("cancelOrders")
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            getOrder(xhr.responseText);
        }
    }
    xhr.open("GET", "<c:url value='/orders/ordersAll' />");
    xhr.send();
}
function addTableHead() {
    var result = "<div class='orderline_topic row align-items-center'><div class='col-sm-3'>訂單編號</div><div class='col-sm-5'>顧客帳號</div><div class='col-sm-4'>訂單管理</div></div>"
    return result;
}
function result01(){
    var result ="<div class='orderline_row col-sm-12'><div class='row'><div class='col-sm-3 align-self-center'>"
    return result;
}
function result02(){
    var result ="</div><div class='col-sm-5 align-self-center'>"
    return result;
}
function result03(){
    var result ="</div><div class='col-sm-4 justify-content-right align-self-center'><button class='btn btn-success btn-sm' type='button'data-toggle='collapse' data-target='#collapseExample"
    return result;
}
function result04(){
    var result ="'aria-expanded='false' aria-controls='collapseExample'>詳細資訊</button>" 
    return result;
}
function resultAlterStr(){
   var result ="<a href=<c:url value='/orders/orderAlter'/>?id="
        return result
}
function resultAlterEnd(){
   var result ="><button class='btn btn-primary btn-sm' >修改訂單</button></a>" 
        return result
}
function resultCancelStr() {
    var result = "<a href=<c:url value='/orders/orderCancel'/>?id="
    return result;
}
function resultCancelEnd() {
    var result = "><button class='btn btn-danger btn-sm'>取消訂單</button></a>"
    return result;
}
function result05(){
    var result =
                "</div>" +
                "</div>" +
                "</div>" +
                "<div class='collapse' id='collapseExample" 
    return result;
}
function result06(){
    var result ="'" +
                "style='text-align: left; padding: 20px;'>" +
                "<div class='card border-secondary card-body'>" +
                "<table class='table table-sm' style='font-size: 8px;'>" +
                "<tr>" +
                "<th scope='row'>配送狀態</th>" +
                "<td>"
    return result;
}
function result07(){
    var result ="</td>" +
                "</tr>" +
                "<tr>" +
                "<th scope='row'>配送地址</th>" +
                "<td>" 
    return result;
}
function result08(){
    var result ="</td>" +
                "</tr>" +
                "<tr>" +
                "<th scope='row'>連絡電話</th>" +
                "<td>"
    return result;
}
function result09(){
    var result = "</td>" +
                "</tr>" +
                "<tr>" +
                "<th scope='col'>配送方式</th>" +
                "<td>宅配</td>" +
                "</tr>" +
                "<tr>" +
                "<th scope='row'>收件人</th>" +
                "<td>"
    return result;
}
function result10(){
    var result = "</td>" +
                "</tr>" +
                "<tr>" +
                "<th scope='row'>總金額</th>" +
                "<td>" 
    return result;
}
function result11(){
    var result ="</td>" +
                "</tr>" +
                "</table>" +
                "</div>" +
                "<div class='card px-3 border-light'></div>" +
                "<div class='card border-secondary card-body'>" +
                "<table class='table table-sm' style='font-size: 8px;'>" +
                "<thead class='table-dark'>" +
                "<tr>" +
                "<th scope='col'>商品名稱</th>" +
                "<th scope='col'>尺寸</th>" +
                "<th scope='col'>數量</th>" +
                "<th scope='col'>金額</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>" +
                "<tr>" +
                "<th scope='row'>條紋上衣</th>" +
                "<td>M</td>" +
                "<td>1</td>" +
                "<td>300</td>" +
                "</tr>" +
                "<tr>" +
                "<th scope='row'>超寬牛仔褲</th>" +
                "<td>L</td>" +
                "<td>2</td>" +
                "<td>500</td>" +
                "</tr>" +
                "<tr>" +
                "<th scope='row'>氣質小裙子</th>" +
                "<td>S</td>" +
                "<td>1</td>" +
                "<td>400</td>" +
                "</tr>" +
                "</tbody>" +
                "</table>" +
                "</div>" +
                "</div>"
    return result;
}

function getOrder(data) {
        var orders = JSON.parse(data);
        resultUnOkOrder = addTableHead();
        resultOrderOk = addTableHead();
        resultCancelOrder = addTableHead();
        for (n = 0; n < orders.length; n++) {
            var order = orders[n];
            resultStr = result01() + order.id + result02() + order.email + result03() + order.id + result04();
            resultEnd = result05() + order.id + result06() + order.ok_tag + result07() +order.shipping_address + result08() +
                         order.recip_phone +result09() + order.recipient + result10() + order.total_amount + result11()
            if (order.cancel_tag) {
                resultCancelOrder += resultStr + resultEnd
            } else if (order.ok_tag) {
                resultUnOkOrder += resultStr + resultAlterStr() + order.id + resultAlterEnd() + resultCancelStr() 
                                 + order.id + resultCancelEnd() +resultEnd
            } else if (!order.ok_tag) {
                resultOrderOk += resultStr + resultCancelStr() + order.id + resultCancelEnd() + resultEnd

            }
        }
        UnOkOrders.innerHTML = resultUnOkOrder;
        OkOrders.innerHTML = resultOrderOk;
        cancelOrders.innerHTML = resultCancelOrder;
    }