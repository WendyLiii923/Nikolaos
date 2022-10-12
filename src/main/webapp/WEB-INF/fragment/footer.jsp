<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<%--     "<c:url value='/javascript/jquery-1.9.1.js' />" --%>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/css/font-awesome.min.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/css/elegant-icons.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/magnific-popup.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/nice-select.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/css/owl.carousel.min.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/css/slicknav.min.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/style.css' />"
	type="text/css">

<!-- Js Plugins -->
<script src="<c:url value='/js/jquery-3.3.1.min.js' />"></script>
<script src="<c:url value='/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/js/jquery.nice-select.min.js' />"></script>
<script src="<c:url value='/js/jquery.nicescroll.min.js' />"></script>
<script src="<c:url value='/js/jquery.magnific-popup.min.js' />"></script>
<script src="<c:url value='/js/jquery.countdown.min.js' />"></script>
<script src="<c:url value='/js/jquery.slicknav.js' />"></script>
<script src="<c:url value='/js/mixitup.min.js' />"></script>
<script src="<c:url value='/js/main.js' />"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
<c:set var='debug' value='true' scope='application' />
<!-- Footer Section Begin -->
<footer class="footer">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-6 col-sm-6">
				<div class="footer__about">
					<div class="footer__logo">
						<a href="#"><img src="<c:url value='/img/logonew.jpg' />"
							alt=""></a>
					</div>
					<p>
						透過衣服告訴出社會打拼的人們，我們生活就像穿搭。<br>好看與否，其實不在於衣服價格，而是你是否有用心搭配。人生也是一樣，我們都一樣是活著，但用心的活著，肯定比盲目生活的人過得還要精彩。
					</p>
					<a href="#"><img src="<c:url value='/img/payment.png' />"
						alt=""></a>
				</div>
			</div>
			<div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
				<div class="footer__widget">
					<h6>INFO</h6>
					<ul>
						<li><a href="#">How to buy</a></li>
						<li><a href="#">Shipping</a></li>
						<li><a href="#">Returns</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-2 col-md-3 col-sm-6">
				<div class="footer__widget">
					<h6>GET IN TOUCH</h6>
					<ul>
						<li><a href="#">01-2345678</a></li>
						<li><a href="#">nikolaosxxx@gmail.com</a></li>
						<li><a href="#">165 ANTI FRAUD</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
				<div class="footer__widget">
					<h6>NewLetter</h6>
					<div class="footer__newslatter">
						<p>Be the first to know about new arrivals, look products,
							sales & promos!</p>
						<form action="#">
							<input type="text" placeholder="Your email">
							<button type="submit">
								<span class="icon_mail_alt"></span>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="footer__copyright__text">
					<p>
						國立臺北科技大學 JAVA & Android 程式設計人才養成班 第十八屆 第一組<br> 專題成果展作品 非營利使用<br>
						版權問題請聯繫：石驥惟 g057104100@gmail.com
					</p>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- Footer Section End -->