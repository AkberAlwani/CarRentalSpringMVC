<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Car Rental System</title>
<link rel="shortcut icon" type="image/png" href="/resource/images/favicon.png"/>

</head>
<body>

	<div class="row">
		<c:import url="/fragments/admin-nav-bar.jsp"></c:import>
	</div>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${tagline}</p>
				<p>
					<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
					</security:authorize>
			</div>

			<div class="container">

				<security:authorize access="isAnonymous()">
					<a href="<spring:url value='/customers/add' />"
						class="btn btn-default pull-right"> Register</a>
					<a href="<spring:url value='/login' />"
						class="btn btn-default pull-right"> Login</a>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<a href="<spring:url value="/types/all" />"
						class="btn btn-default pull-right">Car Types</a>
					<a href="<spring:url value="/vehicles/all" />"
						class="btn btn-default pull-right">Vehicle List</a>
					<br>
					<a href="<spring:url value="/products/add" />"
						class="btn btn-default pull-right">Add Product</a>
					<a href="<spring:url value="/products/all" />"
						class="btn btn-default pull-right">Product List</a>
					<br>
					<a href="<spring:url value='/dologout' />"
						class="btn btn-default pull-right"> Logout</a>
				</security:authorize>

				<a href="<spring:url value='/customers' />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span>Go to Guest!
				</a>
			</div>
			<div class="pull-left">
				<h3>${SpecialBlurb}</h3>
			</div>
		</div>
	</section>

</body>
</html>
