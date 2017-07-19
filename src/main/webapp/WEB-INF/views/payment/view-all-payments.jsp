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
body {
	margin: 0 auto;
}
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
		<c:import url="/fragments/customer-nav-bar.jsp"></c:import>
	</div>

<!-- 	<h3>Search Payment</h3> -->
	<form action="../payment/search-payment" method="post" style="margin:0">
		<div style="padding-left: 10px;margin-top: -10px;">
			<span style="font-size: 24px;font-weight: bold;">Type Customer Name:</span>
			<input type="text" name="customerName" style="margin-top: 10px;height: 30px"/> 
			<input type="submit" name="Search" value="Search" style="height: 30px" />
		
		</div>
		
<!-- 		Type Customer Name:  -->
	</form>
<!-- 	<h3>All payment Information</h3> -->
	<table>
		<tr>
			<th>Transaction Date</th>
			<th>Payment Type</th>
			<th>Amount</th>
			<th>Reservation ID</th>
			<th>Customer Name</th>
			<th>Plate No.</th>
			<th>Brand</th>
			<th>Type</th>
			<th>Model</th>
		</tr>
		<tbody>
			<c:forEach items="${paymentList}" var="list">
				<tr>
					<td>${list.paymentDateTime}</td>
					<td>${list.paymentType}</td>
					<td>$${list.amount}</td>
					<td>${list.reservation.reservationId}</td>
					<td>${list.reservation.customer.firstName} ${list.reservation.customer.lastName}</td>
					<td>${list.reservation.vehicle.plateNumber}</td>
					<td>${list.reservation.vehicle.make}</td>
					<td>${list.reservation.vehicle.vehicleType.name}</td>
					<td>${list.reservation.vehicle.model}</td>
<%-- 					<c:if test="${isAdmin}"> --%>
<!-- 						<td> -->
<%-- 						 	<a href="cancel-payment/${list.paymentId}">Cancel</a> --%>
<!-- 						 </td>  -->
<%-- 					 </c:if> --%>
					<!-- <td><a th:href="@{cancel-payment/{id}(id=${list.paymentId})}">Delete</a></td> -->
					<!-- <td><a th:href="@{update-payment/{id}(id=${list.paymentId})}">Update</a></td> -->
					<c:if test="${isAdmin}">
						<td>
						<a href="update-payment/${list.paymentId}">Update</a></td> 
					</c:if>
					
					<td><a href="view-payment/${list.paymentId}">View</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div
		style="padding-left: 10px; font-size: 18px; padding-top: 10px; ">
		<p>
			Paid in Total: <b style="color: red">$${totalAmount}</b>
		</p>
	</div>
</body>

</html>