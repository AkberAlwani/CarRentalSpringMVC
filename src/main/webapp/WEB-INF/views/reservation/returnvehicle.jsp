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
	<h1 style="margin-left:120px;">My Reservation Information</h1>
 			<c:forEach items="${reservations}" var="list">
	<table style="border:1px solid gray;margin-top:10px;margin-left:120px;">
		<tbody>
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
					<td colspan="2" style="text-align:center"><div style="border:1px solid;display:inline-block;width:100px;height:20px;padding:5px;background-color:#EAEAEA">
					<a href="<%=request.getContextPath() %>/reservation/return/${list.reservationId}">Return</a></div></td>
				</tr>
		</tbody>
	</table>
			</c:forEach>
</body>

</html>