<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link href="<%=request.getContextPath() %>/resources/static/css/bootstrap.css" rel="stylesheet"  />
<link href="<%=request.getContextPath() %>/resources/static/css/main.css" rel="stylesheet"  />
<style>
body {
	margin: 0 auto;
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
	 <h1 style="padding-left:310px;">Add Reservation</h1>
 	
 	<table style="width:100%">
 		<tr>
 			<td style="text-align:center">
 			
			 	<div style="margin:0 auto;">
			    <form:form modelAttribute="reservation" action="${carNumber}" method="post">
			    	<p><form:label path="pickUpDateTime">Pickup Date:</form:label>
			    		<form:input path="pickUpDateTime"  type="date" required="required" pattern="yyyy-MM-dd" title="Invalid Pickup Date" style="height:30px"/>
			    	</p>
			        <p><form:label path="returnDateTime">Return Date:</form:label>
			    		<form:input path="returnDateTime"  type="date" required="required" pattern="yyyy-MM-dd" title="Invalid Return Date" style="height:30px"/>
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
 			</td>
 		</tr>
 	</table>
</body>
</html>
