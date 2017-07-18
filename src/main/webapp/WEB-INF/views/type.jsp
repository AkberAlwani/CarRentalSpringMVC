<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src="<spring:url value="/resource/js/controllers.js"/>"></script>
<title>Types</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Vehicle Types</h1>
			</div>
		</div>
	</section>
	<section class="container" >
 	
		<div class="row">
 		
			<div class="col-md-5">
				<h3>${type.name}</h3>
				<p>${type.description}</p>
				<p>
					<strong>Type Id: </strong><span class="label label-warning">${type.id}</span>
				</p>
 				<p ng-controller="cartCtrl">
 
 <a href="<spring:url value="/types" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
		</div>

	</section>
</body>
</html>
