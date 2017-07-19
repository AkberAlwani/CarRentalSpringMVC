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
	<h1>Customer List</h1>
	<div class="dataTable">
		<table>
			<tr>
				<th>Customer No</th>
				<th>Full Name</th>
				<th>Email</th>
				<th>Phone No</th>
				<th>City</th>
			</tr>
			<c:forEach items="${customers}" var="cust">
				<tr>
					<td>${cust.customerNumber}</td>
					<td>${cust..firstName}  ${customer.lastName}</td>
					<td>${cust.email}</td>
					<td>${cust.phoneNumber}
					<td>${cust.city}	
					
					<td>
						<a href="<%=request.getContextPath() %>/customers/delete/${cust.id}" onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>