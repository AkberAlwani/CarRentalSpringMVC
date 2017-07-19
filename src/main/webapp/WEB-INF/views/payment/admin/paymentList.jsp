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

<!-- 	<h3>Search payment on the basic customer name</h3> -->
	<form action="<%=request.getContextPath() %>/payment/admin/searchPayment" method="post" style="margin:0">
		<div style="padding-left: 10px;margin-top: -10px;">
			<span style="font-size: 24px;font-weight: bold;">Input customer name:</span>
			<input type="text" name="customerName" value="${customerName}" style="margin-top: 10px;height: 30px"/> 
			<input type="submit" name="Search" value="Search" style="height: 30px"/>
		</div>
	</form>
<!-- 	<h3 style="padding-left: 10px;">All payment Information</h3> -->
	<table style="width: 100%">
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
			<th></th>
			</tr>
		</thead>
 		
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
					<td>
						<a href="<%=request.getContextPath() %>/payment/admin/viewPayment/${list.paymentId}" >View</a></td>

			</tr>
		</c:forEach>
	
		</tbody>
	</table>
</body>

</html>