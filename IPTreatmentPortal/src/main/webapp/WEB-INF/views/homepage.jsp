<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
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
<div class="navbar-header" id="h">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div
			class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
			<a class="navbar-brand" href="#"> <img src="/images/Med-Logo.jpg"
				width="45" height="45" class="d-inline-block align-top" alt="" />

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

				<li class="nav-item"><a class="btn btn-outline-primary"
					href="/user/logout" role="button">Logout</a></li>
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
			<div class="col-lg-12 login-title">Welcome Admin</div>

			<div class="col-lg-12 login-form">
				<div class="col-lg-12 login-form">
					

						<div class="col-lg-12 loginbttm">
							
								<div class="col-lg-3 login-btm login-button">
									<a href="/user/registration"><button type="submit" class="btn btn-outline-primary"
										value="registerpatient" name="registerpatient">Register a Patient</button></a>
								</div>
								
					
								<div class="col-lg-3 login-btm login-button">
									<a href="/user/patients"><button type="submit" class="btn btn-outline-primary"
										value="patients" name="patients">List of Patients</button></a>
								</div>
													
								<div class="col-lg-3 login-btm login-button">
								<form action="/user/specialistdetails" method="post">
									<button type="submit" class="btn btn-outline-primary"
										value="Specialist" name="specialist">List of Specialist</button>
										</form>
								</div>
							

								<div class="col-lg-3 login-btm login-button">
								<form action="/user/packagedetails" method="post">
									<button type="submit" class="btn btn-outline-primary"
										value="packages" name="action">Treatment Packages</button>
								</form>
								</div>
				
						</div>
				
				</div>
			</div>
			<div class="col-lg-3 col-md-2"></div>
		</div>
	</div>
</div>
</body>
</html>