<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>Your Book</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">


	<div id="wrapper">
<header id="header">
			<div class="inner">
				<!-- Logo -->
				<a href="./Home" class="logo"> <span class="fa fa-book"></span>
					<span class="title">BOOKING</span>
				</a>


				<!-- Nav -->
				<nav>
					<ul>
						<li><a href="#menu">Menu</a></li>
					</ul>
				</nav>
			</div>
		</header>

		<!-- Menu -->
		<nav id="menu">
			<h2>
				<a href="./User">${sessionScope.user==null? "Menu": ("Welcome ")}${sessionScope.user.getUsername()}</a>
			</h2>
			<ul>
				<li><a href="./Home">Trang chủ</a></li>


				<li><a href="./cart">Kho sản phẩm</a></li>

				<%
				if (session.getAttribute("user") == null) {
				%>
				<li><a href="about.jsp">tiện ích</a></li>

				<li><a href="LoginController?origin=Home"><i
						class="fa fa-sign-in"></i>Đăng nhập</a></li>
				<%
				} else {
				%>
				<li><a href="./Order">Lịch sử đặt hàng</a></li>

				<li><a href="about.jsp">tiện ích</a></li>

				<li><a href="LogoutController"><i class="fa fa-sign-out"></i>Đăng xuất</a></li>
				<%
				}
				%>
			</ul>
		</nav>
		<!-- Main --

		<!-- Main -->
		<div id="main">
			<div>ten: ${sessionScope.user.getUsername()}</div>
			<div>gia : 1000$</div>
			<div>id của phòng : ${id_detail}</div>
			
			 <a href="PayController?id_detail=${id_detail}">
			 <button>
				Xac nhan
			</button>
			 </a>

		</div>

		<!-- Footer -->
		<footer id="footer">
			<div class="inner">
				<section>
					<h2>Contact Info</h2>
					<ul class="alt">
						<li><span class="fa fa-github"></span> <a
							href="https://github.com/anhnndndn">Our Project</a></li>
						<li><span class="fa fa-map-pin"></span> <a
							href="https://goo.gl/maps/ojwCjTqRteiA4B9U7"> BE-119, FBT
								University</a></li>
					</ul>
				</section>

				<ul class="copyright">
					<li>HLV</li>
				</ul>
			</div>
		</footer>

	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/main.js"></script>


</body>
</html>