<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Locations</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Store Location</h1>
			</div>
		</div>
	</section>

	<section class="container">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
		
		</div>
		<div class="row">
			<c:forEach items="${locations}" var="loc">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<p>${loc.location}</p>
							<h3>${loc.city}</h3>
							<h3>${loc.phone}</h3>
							<h3>${loc.zipcode}</h3>
 							<p>
								<a
									href=" <spring:url value="/locations/location?id=${loc.id}" /> "
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
