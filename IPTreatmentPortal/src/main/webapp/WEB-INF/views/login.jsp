<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link href="/css/Customize.css" rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="navbar-header" id="h">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div
				class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
				<a class="navbar-brand" href="#"> <img
					src="/images/Med-Logo.jpg" width="45" height="45"
					class="d-inline-block align-top" alt="">

				</a>
			</div>
			<div class="mx-auto order-0">
				<a class="navbar-brand mx-auto" href="#" id="h">International
					Patient Treatment Management</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target=".dual-collapse2">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
				<ul class="navbar-nav ml-auto">


					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>
				</ul>
			</div>

		</nav>
	</div>
	<div class="container-fluid">

		<div class="row">
			<div class="col-lg-3 col-md-2"></div>
			<div class="col-lg-6 col-md-8 login-box">
				<div class="col-lg-12 login-key">
					<i class="fa fa-key" aria-hidden="true"></i>
				</div>
				<h1>${loginMessage}</h1>
				<div class="col-lg-12 login-title">ADMIN LOGIN</div>

				<div class="col-lg-12 login-form">
					<div class="col-lg-12 login-form">

						<form:errors path="usercredentials.*" />
						<form action="/user/homepage" method="post">
							<div class="form-group">
								<label class="form-control-label">USERNAME</label> <input
									type="text" class="form-control"name="userid" placeholder="username" required>
							</div>
							<div class="form-group">
								<label class="form-control-label">PASSWORD</label> <input
									type="password" class="form-control" name="password" placeholder="password" required>
							</div>

							<div class="col-lg-12 loginbttm">
								<div class="col-lg-6 login-btm login-text">
									<!-- Error Message -->
								</div>
								<div class="col-lg-6 login-btm login-button">
									<button type="submit" class="btn btn-outline-primary">LOGIN</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-lg-3 col-md-2"></div>
			</div>
		</div>
	</div>




</body>
</html>
