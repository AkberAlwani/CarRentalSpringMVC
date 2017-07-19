<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link href="<%=request.getContextPath() %>/resources/static/css/bootstrap.css" rel="stylesheet"  />
<link href="<%=request.getContextPath() %>/resources/static/css/main.css" rel="stylesheet"  />
<style>




table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}
</style>
</head>
<body>
	<div class="row">
		<c:import url="/fragments/admin-nav-bar.jsp"></c:import>
	</div>
	<h1>Reservations List</h1>
	<div class="dataTable">
		<table>
			<tr>
				<th>Reservation ID</th>
				<th>Pickup Date</th>
				<th>Return Date</th>
				<th>Reservation Date</th>
				<th>Person Name</th>
				<th>Vehicle Name</th>
			</tr>
			<c:forEach items="${reservations}" var="res">
				<tr>
					<td>${res.reservationId}</td>
					<td>${res.pickUpDateTime}</td>
					<td>${res.returnDateTime}</td>
					<td>${res.reservationDateTime}</td>
					<td>${res.customer.firstName}  ${res.customer.lastName}</td>
					<td>${res.vehicle.make} + ${res.vehicle.vehicleType.name} + ${res.vehicle.model}</td>
					<td>
						<a href="<%=request.getContextPath() %>/reservation/cancel/${res.reservationId}" onclick="return confirm('Are you sure?')">Cancel Reservation</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>