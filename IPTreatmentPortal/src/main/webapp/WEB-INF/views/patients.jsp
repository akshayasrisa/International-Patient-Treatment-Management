<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<center>
		<div class="navbar-header" id="h">
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div
					class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
					<a class="navbar-brand" href="#"> <img
						src="/images/Med-Logo.jpg" width="45" height="45"
						class="d-inline-block align-top" alt="" />

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
		<div id="screen">
			<br>
			<h2>List of registered Patients</h2>
			<br>
			<table>

				<thead>
					<tr>
						<th>Patient ID</th>
						<th>Patient Name</th>
						<th>Age</th>
						<th>Ailment</th>
						<th>Treatment Package Name</th>
						<th>Treatment Commencement Date</th>
						<th>Generate Treatment Plan</th>
						

					</tr>
				</thead>
		<c:forEach items="${patients}" var="patient">
					<tr>
						<td class="col-left">${patient.id}</td>
						<td class="col-right">${patient.name}</td>
						<td class="col-right">${patient.age}</td>
								<td class="col-right">${patient.ailment}</td>
						<td class="col-right">${patient.treatmentPackageName}</td>
						<td class="col-right">${patient.treatmentCommencementDate}</td>
						<td class="col-right"><a class="btn btn-primary" href="showPatients">Generate Plan </a></td>

						
					</tr>

				</c:forEach>
			</table>
		</div>

	</center>
</body>
</html>