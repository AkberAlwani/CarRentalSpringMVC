<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Vehicles</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Vehicles</h1>
				<p>All the available vehicles to your location</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${vehicles}" var="vehicle">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					    <img src="<c:url value="/resource/images/car${vehicle.vehicleId}.jpg"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${vehicle.make}</h3>
							<p>${vehicle.makeyear}</p>
							<p>${vehicle.model}</p>
							<p>${vehicle.dailyRate}USD</p>
 							<p>
								<a
									href=" <spring:url value="/vehicles/vehicle?id=${vehicle.vehicleId}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span>Details
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
