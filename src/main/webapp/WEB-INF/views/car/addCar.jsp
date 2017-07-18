<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Add Vehicle</title>
</head>
<body>

	<!--  tr th:each="vehicle: ${allVehicles}">
		<td th:text="${prod.name}">Oranges</td>
		<td th:text="${#numbers.formatDecimal(prod.price, 1, 2)}">0.99</td>
	</tr-->
	<c:forEach items="${vehicles}" var="prod">
		<tr>
		<td>Make${prod.make}</td>
		<td>0.99${#numbers.formatDecimal(prod.price, 1, 2)}</td>
			
		</tr>
	</c:forEach>
</body>
</html>