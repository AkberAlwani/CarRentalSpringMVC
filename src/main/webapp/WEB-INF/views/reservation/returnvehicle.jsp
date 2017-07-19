<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Return Vehicle</title>
<link href="/css/bootstrap.css" rel="stylesheet" media="screen" />
<link href="/css/main.css" rel="stylesheet" media="screen" />
<style>
table {
	border-collapse: collapse;
	width: 80%;
}

th, td, h1 {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}

h3 {
	background-color: #4CAF50;
	color: white;
}
</style>

</head>

<body>
	<div class="row">
		<c:import url="/fragments/customer-nav-bar.jsp"></c:import>
	</div>
	<h1>My Reservation Information</h1>
	<table>
<!-- 		<tr> -->
<!-- 			<th>Reservation ID</th> -->
<!-- 			<th>Daily Rate</th> -->
<!-- 			<th>Daily Fine</th> -->
<!-- 			<th>Brand</th> -->
<!-- 			<th>Model</th> -->
<!-- 			<th>Plate Number</th> -->
<!-- 		</tr> -->
		<tbody>
 			<c:forEach items="${reservations}" var="list">
				<tr>
					<td>Reservation ID</td>
					<td>${list.reservationId}</td>
				</tr>
				<tr>	
					<td>Daily Rate</td>
					<td>${list.vehicle.dailyRate}</td>
				</tr>
				<tr>
					<td>Daily Fine</td>	
					<td>${list.vehicle.dailyFine}</td>
				</tr>
				<tr>
					<td>Brand</td>	
					<td>${list.vehicle.make}</td>
				</tr>
				<tr>
					<td>Model</td>
					<td>${list.vehicle.model}</td>
				</tr>
				<tr>
					<td>Plate Number</td>
					<td>${list.vehicle.plateNumber}</td>
				</tr>
				<tr>
					<td colspan="2"><a href="<%=request.getContextPath() %>/reservation/return/${list.reservationId}">Return</a></td>
				</tr>
				<tr><td colspan="2"><hr /></td></tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>