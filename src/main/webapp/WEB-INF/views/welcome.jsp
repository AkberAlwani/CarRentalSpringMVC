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
			</div>
			<div class="pull-left">
				<h3>${SpecialBlurb}</h3>
			</div>
		</div>
	</section>

</body>
</html>
