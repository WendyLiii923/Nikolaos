<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class='orderline_row col-sm-12'>
		<div class='row'>
			<div class='col-sm-3 align-self-center'>order.id</div>
			<div class='col-sm-5 align-self-center'>order.email</div>
			<div class='col-sm-4 justify-content-right align-self-center'>
				<button class='btn btn-success btn-sm' type='button'
					data-toggle='collapse' data-target='#collapseExample'
					aria-expanded='false' aria-controls='collapseExample'>
					詳細資訊</button>
				<a href=<c:url value='/orders/ordersAlter'/>?" + "id=" + order.id + ">
					<button class='btn btn-primary btn-sm' >修改訂單</button>
				</a>
				<button class='btn btn-danger btn-sm'>取消訂單</button>
			</div>
		</div>
	</div>
	<!-- 訂單編號0800694173的 簡單資訊 End -->

	<!-- 訂單編號0800694173的 詳細資訊 -->
	<div class='collapse' id='collapseExample'
		style='text-align: left; padding: 20px;'>
		<div class='card border-secondary card-body'>
			<!-- 運送資訊表格 -->
			<table class='table table-sm' style='font-size: 8px;'>
				<tr>
					<th scope='row'>配送狀態</th>
					<td>order.ok_tag</td>
				</tr>
				<tr>
					<th scope='row'>配送地址</th>
					<td>order.shipping_address</td>
				</tr>
				<tr>
					<th scope='row'>連絡電話</th>
					<td>order.recip_phone</td>
				</tr>
				<tr>
					<th scope='col'>配送方式</th>
					<td>宅配</td>
				</tr>
				<tr>
					<th scope='row'>收件人</th>
					<td>order.recipient</td>
				</tr>
				<tr>
					<th scope='row'>總金額</th>
					<td>order.total_amount</td>
				</tr>
			</table>
			<!-- 運送資訊表格 End -->
		</div>
		<!-- 中間排版用空白card Start -->
		<div class='card px-3 border-light'></div>
		<!-- 中間排版用空白card End -->
		<div class='card border-secondary card-body'>
			<!-- 商品資訊表格 -->
			<table class='table table-sm' style='font-size: 8px;'>
				<thead class='table-dark'>
					<tr>
						<th scope='col'>商品名稱</th>
						<th scope='col'>尺寸</th>
						<th scope='col'>數量</th>
						<th scope='col'>金額</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope='row'>條紋上衣</th>
						<td>M</td>
						<td>1</td>
						<td>300</td>
					</tr>
					<tr>
						<th scope='row'>超寬牛仔褲</th>
						<td>L</td>
						<td>2</td>
						<td>500</td>
					</tr>
					<tr>
						<th scope='row'>氣質小裙子</th>
						<td>S</td>
						<td>1</td>
						<td>400</td>
					</tr>
				</tbody>
			</table>
			<!-- 商品資訊表格 End -->
		</div>"
	</div>
</body>
</html>