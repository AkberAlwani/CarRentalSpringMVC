<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<link href="/css/bootstrap.css" rel="stylesheet" media="screen" />
	<link href="/css/main.css" rel="stylesheet" media="screen" />
</head>
<body>
	<h1>Welcome to Car Rental System</h1>
	<h1>Add Reservation</h1>
<%-- 	<h1> For Car Id: <span th:text="${carNumber}" /></h1> --%>
<%-- 	 <form action="#" th:action="@{/reservation/add/}+${carNumber}" th:object="${reservation}" method="post"> --%>
<!-- 	 	<p>PickUp Date: <input type="date" required="required" pattern="yyyy-MM-dd" th:field="*{pickUpDateTime}" /></p> -->
<%-- 	 	 <p th:if="${#fields.hasErrors('pickUpDateTime')}" th:errors="*{pickUpDateTime}">Return Date Error</p> --%>
<!--         <p>Return Date: <input type="date" required="required" pattern="yyyy-MM-dd" th:field="*{returnDateTime}" /></p> -->
<%--         <p th:if="${#fields.hasErrors('returnDateTime')}"  th:errors="*{returnDateTime}">Return Date Error</p> --%>
<!--         <p>Add Payment: <select name="addPayment"> -->
<!-- 						<option value="Yes">Yes</option> -->
<!-- 						<option value="No">No</option> -->
<!-- 				</select></p> -->
<!--         <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p> -->
<!--     </form> -->
    <form:form modelAttribute="reservation" action="/reservation/add/${carNumber}" method="post">
    	<p><form:label path="pickUpDateTime">Pickup Date:</form:label>
    		<form:input path="pickUpDateTime"  type="date" required="required" pattern="yyyy-MM-dd" title="Invalid Pickup Date" />
    	</p>
        <p><form:label path="returnDateTime">Return Date:</form:label>
    		<form:input path="returnDateTime"  type="date" required="required" pattern="yyyy-MM-dd" title="Invalid Return Date" />
    	</p>
		<p>Add Payment: 
			<select name="addPayment">
				<option value="Yes">Yes</option>
				<option value="No">No</option>
			</select>
		</p>
		<p>
			<input type="submit" value="Submit" /> <input type="reset" value="Reset" />
		</p>	
    </form:form>
</body>
</html>
