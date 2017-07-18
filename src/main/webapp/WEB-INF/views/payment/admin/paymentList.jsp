<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Reading List</title>
<link href="<%=request.getContextPath() %>/resources/static/css/bootstrap.css" rel="stylesheet"  />
<link href="<%=request.getContextPath() %>/resources/static/css/main.css" rel="stylesheet"  />
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
		<c:import url="/fragments/admin-nav-bar.jsp"></c:import>
 	</div>

	<h3>Search payment on the basic customer name</h3>
	<form action="<%=request.getContextPath() %>/payment/admin/searchPayment" method="post">
		Input customer name 
		<input type="text" name="customerName" value="${customerName}"/> 
		<input type="submit" name="Search" value="Search" />

	</form>
	<h3>All payment Information</h3>
	<table>
		<thead>
			<tr>
			<th>Transaction Date-Time</th>
			<th>Payment Type</th>
			<th>Amount</th>
			<th>Reservation ID</th>
			<th>Customer name</th>
			<th>Vehicle plat No.</th>
			<th>Brand</th>
			<th>Type</th>
			<th>Model</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${paymentList}" var="list">
				<tr>
				<td><span>${list.paymentDateTime}</span></td>
				<td><span>${list.paymentType}</span></td>
				<td><span>${list.amount}</span></td>
				<td><span>${list.reservation.reservationId}</span></td>
				<td><span>${list.reservation.customer.firstName}  ${list.reservation.customer.lastName}</span></td>
				<td><span>${list.reservation.vehicle.plateNumber}</span></td>
				<td><span>${list.reservation.vehicle.make}</span></td>
				<td><span>${list.reservation.vehicle.vehicleType.name}</span></td>
				<td><span>${list.reservation.vehicle.model}</span></td>
			</tr>
		</c:forEach>
	
		</tbody>
	</table>
</body>

</html>