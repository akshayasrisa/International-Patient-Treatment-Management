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
						src="/images/Med-Logo.jpeg" width="45" height="45"
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
							href="/user/logout" role="button">Logout</a></li>
					</ul>
				</div>

			</nav>
		</div>
		<div id="screen">
			<br>
			<h2>Treatment Plan</h2>
			<br>
			<table>

				<thead>
					<tr>
					    <th>Treatment ID</th>
						<th>Patient ID</th>
						<th>Ailment</th>
						<th>Treatment Package Name</th>
						<th>Test Detail</th>
						<th>Cost</th>
						<th>Specialist Name</th>
						<th>Treatment Commencement Date</th>
						<th>Treatment End Date</th>
						<th>Status</th>
						<th>Initiate Claim</th>
						
											</tr>
				</thead>
				
				
				<c:forEach items="${treatmentplans}" var="treatmentplan">
					<tr>
						<td class="col-left">${treatmentplan.id}</td>
						<td class="col-right">${treatmentplan.patient.id}</td>
						<td class="col-right">${treatmentplan.patient.ailment}</td>
								<td class="col-right">${treatmentplan.packagename}</td>
						<td class="col-right">${treatmentplan.testdetails}</td>
						<td class="col-right">${treatmentplan.cost}</td>
						<td class="col-right">${treatmentplan.specialist}</td>
						<td class="col-right">${treatmentplan.startdate}</td>
						<td class="col-right">${treatmentplan.enddate}</td>
						<td class="col-right">${treatmentplan.status}</td>
						<input type="text" id="disablebtn"
							value="${treatmentplan.status}" hidden />
						<td class="col-right"><a class="btn btn-primary"
							id="cart-btn" href="initiateClaim/${treatmentplan.id}">Initiate
								Claim </a></td>

					</tr>

				</c:forEach>

			</table>
		</div>

	</center>
	<script>
		const isdisable = document.getElementById('disablebtn').value;
		if (isdisable === 'false') {
			console.log(isdisable);
			document.getElementById('cart-btn').style.visibility = "hidden";
		}
	</script>
</body>
</html>