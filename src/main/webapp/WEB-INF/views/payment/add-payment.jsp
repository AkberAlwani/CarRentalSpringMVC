<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="ISO-8859-1" />
	<title>Add Payment</title>
	<link href="/css/bootstrap.css" rel="stylesheet" media="screen" />
	<link href="/css/main.css" rel="stylesheet" media="screen" />
</head>

<body>
	<div class="row">
		<div th:include="../fragments/nav-bar :: header"></div>
	</div>

	<div class="container">
		<div class="col-md-12 col-sm-6 col-xs-12">
			<div class="row">
				<div class="panel panel-primary">
					<div class="panel-heading">Pay your reservation fee</div>

					<form:form modelAttribute="payment" action="pay-bill" method="post">
						<table>
							<tr>
								<td>Amount to be Paid</td>
								<td><form:input path="amount" value="${sessionScope.totalPriceSession}" /></td>
							</tr>

<!-- 							<tr> -->
<!-- 								<td>Amount:</td> -->
<!-- 								<td><input type="text" path="amount" -->
<%-- 									th:value="${session.totalPriceSession}" /></td> --%>
<!-- 							</tr> -->
							<tr>
								<td>Selection Card Type</td>
								<td><select name="paymentType">
										<option value="Credit Card">Credit Card</option>
										<option value="Master Card">Master Card</option>
										<option value="Visa Card">Visa Card</option>
								</select></td>
							</tr>

							<tr>
								<td>Card Number:</td>
								<td><form:input type="text" path="cardNumber" pattern="\d{4}-\d{4}-\d{4}-\d{4}" title="Invalid format!" />(xxxx-xxxx-xxxx-xxxx)</td>
<%-- 								<td th:if="${#fields.hasErrors('cardNumber')}" --%>
<!-- 									th:errors="*{cardNumber}" bgcolor="#FF0000">Card number -->
<!-- 									Error</td> -->
							</tr>


							<tr>
								<td>Expiry Date</td>
								<td><form:input type="text" path="expiryDate" />(mm/yyyy)</td>

<%-- 								<td th:if="${#fields.hasErrors('expiryDate')}" --%>
<!-- 									th:errors="*{expiryDate}" bgcolor="#FF0000"></td> -->
							</tr>

							<tr>
								<td>CVV</td>
								<td><form:input type="text" path="cvvNumber" pattern="\d{3}" title="Invalid format!" />xxx</td>
<%-- 								<td th:if="${#fields.hasErrors('cvvNumber')}" --%>
<!-- 									th:errors="*{cvvNumber}" bgcolor="#FF0000"></td> -->

							</tr>

							<tr>
								<td><input type="submit" value="Pay" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
		</div>
	</div>


</body>

</html>
