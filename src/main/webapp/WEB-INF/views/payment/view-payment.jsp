<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>View Individual Payment</title>
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
	<h1>Payment Information Page</h1>
	<table>
		<tr>
			<th>Reservation ID</th>
			<th>Amount</th>
			<th>Status</th>
			<th>Customer ID</th>
			<th>Customer name</th>
			<th>Vehicle plat No.</th>
			<th>Brand</th>
			<th>Type</th>
			<th>Model</th>
		</tr>
		<tbody>
			
			<c:forEach items="${paymentList}" var="list">
				<tr>
					<td>${list.paymentDateTime}</td>
					<td>${list.paymentType}</td>
					<td>${list.amount}</td>
					<td>${list.reservation.reservationId}</td>
					<td>${list.reservation.customer.firstName} ${list.reservation.customer.lastName}</td>
					<td>${list.reservation.vehicle.plateNumber}</td>
					<td>${list.reservation.vehicle.make}</td>
					<td>${list.reservation.vehicle.vehicleType.name}</td>
					<td>${list.reservation.vehicle.model}</td>
<%-- 				<c:if test="${isAdmin}"> --%>
<%-- 					<td><a href="<%=request.getContextPath() %>/payment/cancel-payment/${list.paymentId}">Delete</a></td> --%>
<%-- 				</c:if> --%>

				<!-- <td><a	th:href="@{~/payment/cancel-payment/{id}(id=${list.paymentId})}">Delete</a></td> -->
				<!-- <td><a	th:href="@{~/payment/update-payment/{id}(id=${list.paymentId})}">Update</a></td> -->
<%-- 				<c:if test="${isAdmin}"> --%>
<%-- 					<td><a href="<%=request.getContextPath() %>/payment/update-payment/${list.paymentId}">Update</a></td> --%>
<%-- 				</c:if> --%>


				<td><a href="<%=request.getContextPath() %>/payment/view-all-payment">View all
						Payments</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>