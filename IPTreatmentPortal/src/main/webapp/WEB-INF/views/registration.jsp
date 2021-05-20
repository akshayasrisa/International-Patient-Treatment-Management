<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>
	<div class="navbar-header">
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
					<li class="nav-item"><a class="btn btn-outline-primary"
						href="/user/adminhome" role="button">Home</a></li>


					<li class="nav-item"><a class="btn btn-outline-primary"
						href="/user/logout" role="button">Logout</a></li>
				</ul>
			</div>

		</nav>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-2"></div>
			<div class="col-lg-6 col-md-8 login-box">
				<div class="col-lg-12 login-key">
					<i class="fa fa-key" aria-hidden="true"></i>
				</div>
				<div class="col-lg-12 login-title">Patient Registration Form</div>

				<div class="col-lg-12 login-form">
					<div class="col-lg-12 login-form">
						<form action="registerPatient">
							<div class="form-group">
								<label class="form-control-label">Patient ID</label> <input
									type="text" class="form-control" name="id">
							</div>
							<div class="form-group">
								<label class="form-control-label"> Name</label> <input
									type="text" class="form-control" name="name" required>
							</div>
						


							<div class="form-group">
								<label class="form-control-label">Age</label> <input type="number"
									class="form-control" name="age" min="1" max="100" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<label class="input-group-text" for="inputGroupSelect01">Options</label>
								</div>
								<select class="custom-select" id="inputGroupSelect01" name="ailment" required>
									<option selected>Choose...</option>
									<option value="ORTHOPEDICS">Orthopedics</option>
									<option value="UROLOGY">urolgoy</option>
								</select>
							</div>
								<div class="input-group mb-3">
								<div class="input-group-prepend">
									<label class="input-group-text" for="inputGroupSelect01">Options</label>
								</div>
								<select class="custom-select" id="inputGroupSelect01" name="pkg" required>
									<option selected>Choose...</option>
									<option value="package1">Package 1</option>
									<option value="package2">Package 2</option>
								</select>
							</div>

							<div class="form-group">
								<label class="form-control-label">Treatment Commencement
									Date</label> <input type="date" name="date" class="form-control"
									id="startdate"
									min="2021-02-06" required
									>
							</div>




							<div class="col-lg-12 loginbttm">
								<div class="col-lg-6 login-btm login-text">
									<!-- Error Message -->
								</div>
								<div class="col-lg-6 login-btm login-button">
									<button type="submit" class="btn btn-outline-primary">REGISTER</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-lg-3 col-md-2"></div>
			</div>
		</div>
	</div>
	</form>



</body>
</html>