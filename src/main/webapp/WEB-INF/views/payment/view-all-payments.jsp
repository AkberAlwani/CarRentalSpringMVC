<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>Reading List</title>
	<link href="/css/bootstrap.css" rel="stylesheet" media="screen" />
	<link href="/css/main.css" rel="stylesheet" media="screen" />
</head>


<body>
	<div class="row">
		<div th:include="../fragments/nav-bar :: header"></div>
	</div>

	<h3>Search payment on the basic customer name</h3>
	<form action="../payment/search-payment" method="post">
		Input customer name <input type="text" name="customerName" /> 
		<input type="submit" name="Search" value="Search" />
	</form>
	<h3>All payment Information</h3>
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
					<td>${list.amount}</td>
					<td>${list.reservation.reservationId}</td>
					<td>${list.reservation.customer.firstName} ${list.reservation.customer.lastName}</td>
					<td>${list.reservation.vehicle.plateNumber}</td>
					<td>${list.reservation.vehicle.make}</td>
					<td>${list.reservation.vehicle.vehicleType.name}</td>
					<td>${list.reservation.vehicle.model}</td>
					<c:if test="${isAdmin}">
						<td>
						 	<a href="cancel-payment/${list.paymentId}">Delete</a>
						 </td> 
					 </c:if>
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

	<p>
		Total Reservation Payment: <b>${totalAmount}</b>
	</p>
</body>

</html>