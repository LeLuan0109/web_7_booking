<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="Model.User"%>
<%
User user = (User) session.getAttribute("user");
if (user == null || !user.isAdmin()) {
	response.sendRedirect("./Home");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Manager</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<meta name="description" content="Developed By M Abdur Rokib Promy">
<meta name="keywords"
	content="ADMIN, Bootstrap 3, Template, Theme, Responsive">
<!-- bootstrap 3.0.2 -->
<link href="./ADMIN/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- font Awesome -->
<link href="./ADMIN/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="./ADMIN/css/ionicons.min.css" rel="stylesheet"
	type="text/css" />
<!-- Morris chart -->
<link href="./ADMIN/css/morris/morris.css" rel="stylesheet"
	type="text/css" />
<link href="./ADMIN/css/jvectormap/jquery-jvectormap-1.2.2.css"
	rel="stylesheet" type="text/css" />
<link href="./ADMIN/css/datepicker/datepicker3.css" rel="stylesheet"
	type="text/css" />
<link href="./ADMIN/css/daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" />
<link href="./ADMIN/css/iCheck/all.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<!-- Theme style -->
<link href="./ADMIN/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/style/homeCss.css" />

<style>
.left-aside {
	height: 100%;
}

img {
	border: 1px solid black;
	border-radius: 2px;
}
</style>
</head>
<body class="skin-black">
	<c:if test="${param['index']==null }">
		<c:set var="index" scope="page" value="1" />
	</c:if>
	<c:if test="${param['index']!=null}">
		<c:set var="index" scope="page" value="${param['index']}" />
	</c:if>
	<!-- header logo: style can be found in header.less -->
	<jsp:include page="./header.jsp" />
	<div class="wrapper row-offcanvas row-offcanvas-left"
		style="height: 100%;">
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="./aside.jsp" />

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side">

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="panel">
							<header class="panel-heading"> Quản lí bài viết </header>
							<!-- <div class="box-header"> -->
							<!-- <h3 class="box-title">Responsive Hover Table</h3> -->

							<div>
								<c:forEach items="${posts}" var="idx">
									<div class="container">
										<div class="container-item">
											<div>
												<img class="img-item" src="assets/img/1.png" alt="lOading" />
											</div>
											<div class="content">
												<p>${idx.getId()}</p>

												<p>${idx.getTitle()}</p>
											</div>
											 <div>
											 <a href="PostManagerController?action=add&idPost=${idx.getId()}">
													<button>Them moi</button>
												</a> 
												<a href="PostManagerController?action=update&idPost=${idx.getId()}">
													<button>Sửa</button>
												</a> 
												<a href="PostManagerController?action=delete&idPost=${idx.getId()}">
													<button>xóa</button>
												</a>
												 <a>
													<button href="PostManagerController?xpage=${xpage-1}">
														xem chi tiết</button>
												</a>
											</div> 
										</div>

										<!-- Show detail modal -->
								</c:forEach>
							</div>
							<!-- </div> -->
							<div class="panel-body table-responsive">
								<div class="sliderList">

									<div class="pagination-arena " style="margin-left: 40%">
										<ul class="pagination">
											<li class="page-item"><a
												href="PostManagerController?xpage=${xpage-1}"
												class="page-link" style="${xpage<3?"display:none":""}">
													<i class="fa fa-angle-left" aria-hidden="true"></i>
											</a></li>
											<c:forEach begin="${1}" end="${numPage}" var="item">
												<li class="page-item ${item==xpage?"active":""}"><a
													href="PostManagerController?xpage=${item}"
													class="page-link "
													style="${(xpage-1>item || xpage+1<item ) ?"display:none;":""}"
                                                           >${item}</a></li>
											</c:forEach>
											<li><a href="PostManagerController?xpage=${xpage+1}"
												class="page-link" style="${xpage+2>numPage?"display:none":""}">
													<i class="fa fa-angle-right" aria-hidden="true"></i>
											</a></li>
										</ul>
									</div>
								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
					</div>
			</section>
			<!-- /.content -->
			<div class="footer-main">Copyright &copy Director, 2014</div>
		</aside>
		<!-- /.right-side -->


	</div>
	<!-- ./wrapper -->



	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#tablepro").DataTable({
				bFilter : false,
				bInfo : false,
				paging : false
			});
		});
	</script>
	<!-- Bootstrap -->
	<script src="./ADMIN/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- Director App -->
	<script src="./ADMIN/js/Director/app.js" type="text/javascript"></script>
</body>
</html>