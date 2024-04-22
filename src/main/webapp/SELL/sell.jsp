<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<meta name="description" content="Developed By M Abdur Rokib Promy">
<meta name="keywords"
	content="SELL, Bootstrap 3, Template, Theme, Responsive">
<!-- bootstrap 3.0.2 -->
<link href="./SELL/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- font Awesome -->
<link href="./SELL/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="./SELL/css/ionicons.min.css" rel="stylesheet"
	type="text/css" />
<!-- Morris chart -->
<link href="./SELL/css/morris/morris.css" rel="stylesheet"
	type="text/css" />
<link href="./SELL/css/jvectormap/jquery-jvectormap-1.2.2.css"
	rel="stylesheet" type="text/css" />
<link href="./SELL/css/datepicker/datepicker3.css" rel="stylesheet"
	type="text/css" />
<link href="./SELL/css/daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" />
<link href="./SELL/css/iCheck/all.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<!-- Theme style -->
<link href="./SELL/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
</style>

</head>
<body class="skin-black">
	<!-- header logo: style can be found in header.less -->
	<jsp:include page="./header.jsp" />

	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="./aside.jsp" />
		<aside class="right-side">

			<!-- Main content -->
			<section class="content">

				<div class="row" style="margin-bottom: 5px;">


					<div class="col-md-3">
						<div class="sm-st clearfix">
							<span class="sm-st-icon st-red"><i
								class="fa fa-check-square-o"></i></span>
							<div class="sm-st-info">
								<span>${numOrder}</span> Tổng lượng đặt hàng
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="sm-st clearfix">
							<span class="sm-st-icon st-violet"><i class="fa fa-book"></i></span>
							<div class="sm-st-info">
								<span>${numBook}</span> Tổng bài đăng
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="sm-st clearfix">
							<span class="sm-st-icon st-blue"><i class="fa fa-user"></i></span>
							<div class="sm-st-info">
								<span>${numUser}</span> Tổng tài khoản
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="sm-st clearfix">
							<span class="sm-st-icon st-green"><i class="fa fa-money"></i></span>
							<div class="sm-st-info">
								<span>$${earning}</span> Doanh thu
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!-- row end -->
			</section>
			<!-- /.content -->
			<div class="footer-main">Copyright &copy Director, 2014</div>
		</aside>
		<!-- /.right-side -->


	</div>
	<!-- ./wrapper -->
	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="./SELL/js/jquery.min.js" type="text/javascript"></script>

	<!-- jQuery UI 1.10.3 -->
	<script src="./SELL/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
	<!-- Bootstrap -->
	<script src="./SELL/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- daterangepicker -->
	<script src="./SELL/js/plugins/daterangepicker/daterangepicker.js"
		type="text/javascript"></script>

	<script src="./SELL/js/plugins/chart.js" type="text/javascript"></script>

	<script src="./SELL/js/plugins/iCheck/icheck.min.js"
		type="text/javascript"></script>
	<!-- calendar -->
	<script src="./SELL/js/plugins/fullcalendar/fullcalendar.js"
		type="text/javascript"></script>
	<script src="./SELL/js/Director/app.js" type="text/javascript"></script>

	<!-- Director dashboard demo (This is only for demo purposes) -->
	<script src="./SELL/js/Director/dashboard.js" type="text/javascript"></script>

	<script type="text/javascript">
		$('input').on('ifChecked', function(event) {
			// var element = $(this).parent().find('input:checkbox:first');
			// element.parent().parent().parent().addClass('highlight');
			$(this).parents('li').addClass("task-done");
			console.log('ok');
		});
		$('input').on('ifUnchecked', function(event) {
			// var element = $(this).parent().find('input:checkbox:first');
			// element.parent().parent().parent().removeClass('highlight');
			$(this).parents('li').removeClass("task-done");
			console.log('not');
		});
	</script>
	<script>
		$('#noti-box').slimScroll({
			height : '400px',
			size : '5px',
			BorderRadius : '5px'
		});

		$('input[type="checkbox"].flat-grey, input[type="radio"].flat-grey')
				.iCheck({
					checkboxClass : 'icheckbox_flat-grey',
					radioClass : 'iradio_flat-grey'
				});
	</script>
</body>
</html>