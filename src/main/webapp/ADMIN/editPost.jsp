<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${service}Book</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<meta name="description" content="Developed By M Abdur Rokib Promy">
<meta name="keywords"
	content="Admin, Bootstrap 3, Template, Theme, Responsive">
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

<style type="text/css">
.left-aside {
	height: 1550px;
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
							<header class="panel-heading"> ${service} Post </header>
							<div class="panel-body table-responsive">
								<div class="sliderList">
									<form action="PostManagerController" method="post">
										<!--  
                                            <div class="form-group col-md-6">
                                                <label class="control-label">ID</label>
                                                <input class="form-control" style="width:25%;" type="text"  name="bid" readonly value="${(s.getId()!=0 && s.getId()!=null)?s.getId():"Auto genarated"}">
                                            </div>
                                            -->
										<div class="form-group col-md-6">
											<label for="exampleSelect1" class="control-label">Title</label>
											<input class="form-control" type="text" name="title" required
												value="${s.getTitle()}">
										</div>
										<div class="col-md-10">
											<div class="left-filter">
												<div class="col-md-10">
													<div class="left-filter">
														<input
															class="btn ${controlActive == 'add' ? 'btn-primary' : 'btn-outline-danger'}"
															name="in" type="submit"
															value="${controlActive == 'add' ? 'Thêm mới' : 'Cập nhật'}">
													</div>
												</div>
											</div>

										</div>
									</form>
								</div>
							</div>
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