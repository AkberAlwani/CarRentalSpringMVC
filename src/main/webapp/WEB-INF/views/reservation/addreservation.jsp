<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link href="/css/bootstrap.css" rel="stylesheet" media="screen" />
<link href="/css/main.css" rel="stylesheet" media="screen" />
<style>
body {
	margin: 0 auto;
}
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
		<c:import url="/fragments/customer-nav-bar.jsp"></c:import>
 	</div>
 	<div style="margin:0 auto;">
	<h1>Welcome to Car Rental System</h1>
	<h1>Add Reservation</h1>
    <form:form modelAttribute="reservation" action="${carNumber}" method="post">
    	<p><form:label path="pickUpDateTime">Pickup Date:</form:label>
    		<form:input path="pickUpDateTime"  type="date" required="required" pattern="yyyy-MM-dd" title="Invalid Pickup Date" />
    	</p>
        <p><form:label path="returnDateTime">Return Date:</form:label>
    		<form:input path="returnDateTime"  type="date" required="required" pattern="yyyy-MM-dd" title="Invalid Return Date" />
    	</p>
<!-- 		<p>Add Payment:  -->
<!-- 			<select name="addPayment"> -->
<!-- 				<option value="Yes">Yes</option> -->
<!-- 				<option value="No">No</option> -->
<!-- 			</select> -->
<!-- 		</p> -->
		<p>
			<input type="submit" value="Submit" /> <input type="reset" value="Reset" />
		</p>	
    </form:form>
    </div>
</body>
</html>
