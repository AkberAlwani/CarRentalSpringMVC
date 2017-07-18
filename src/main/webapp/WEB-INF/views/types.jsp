<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Vehicle Types</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Vehicle Types</h1>
			</div>
		</div>
	</section>

	<section class="container">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
		<security:authorize access="isAuthenticated()">
					<a href="<spring:url value="/types/add" />"
						class="btn btn-default pull-right">Add Type</a>
					
		</security:authorize>
		</div>
		<div class="row">
			<c:forEach items="${types}" var="type">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${type.name}</h3>
							<p>${type.description}</p>
 							<p>
								<a
									href=" <spring:url value="/types/type?id=${type.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
