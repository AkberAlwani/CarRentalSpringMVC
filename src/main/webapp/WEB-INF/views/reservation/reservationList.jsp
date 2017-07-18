<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<link href="/css/bootstrap.css" rel="stylesheet" media="screen" />
<link href="/css/main.css" rel="stylesheet" media="screen" />
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
		<div th:include="../fragments/nav-bar :: header"></div>
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
					<td>${res.person.name}</td>
					<td>${res.vehicle.make} + ${res.vehicle.vehicleType.name} + ${res.vehicle.model}</td>
					<td>
						<a href="<%=request.getContextPath() %>/reservation/delete/${res.reservationId}" onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>