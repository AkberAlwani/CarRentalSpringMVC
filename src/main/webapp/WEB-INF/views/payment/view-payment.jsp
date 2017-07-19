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
	<h2 style="padding-left: 10px;margin-top: -10px;">Payment View</h2>
	<div class="dataTable">
		<table>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Transaction Date-Time:</td>
					<td>${paymentList.paymentDateTime}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Payment Type:</td>
					<td>${paymentList.paymentType}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Amount:</td>
					<td>${paymentList.amount}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Reservation ID:</td>
					<td>${paymentList.reservation.reservationId}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Customer name:</td>
					<td>${paymentList.reservation.customer.firstName} ${paymentList.reservation.customer.lastName}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Vehicle plat No.:</td>
					<td>${paymentList.reservation.vehicle.plateNumber}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Make:</td>
					<td>${paymentList.reservation.vehicle.make}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Type:</td>
					<td>${paymentList.reservation.vehicle.vehicleType.name}</td>
				</tr>
				<tr>
					<td width="20%" style="padding-left: 20px;font-weight: bold;">Model:</td>
					<td>${paymentList.reservation.vehicle.model}</td>
				</tr>
		</table>
	</div>
</body>
</html>