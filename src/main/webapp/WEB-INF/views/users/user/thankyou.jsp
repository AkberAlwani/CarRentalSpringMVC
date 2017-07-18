<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
xmlns:th="http://www.thymeleaf.org">
<head lang="en">

<title>Thank You</title>
<meta charset="utf-8" />
<!-- <meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes" /> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid"> 
			<div class="navbar-header">
				 
				<a class="navbar-brand" href="#">Car Rental</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

				</ul>
			</div> 
		</div> 
	</nav>
	<div class="container">
		<div id="midCol" class="row">
		<div class="col-sm-4 col-sm-offset-4 well">
			
			 
			<form id="thankyou" th:action="@{/login}" method="get" class="form-signin" >
			<h2 class="form-signin-heading">Thank very much for joining us  <span th:text="${msg}" />!!! Please Click on below and login to our page.</h2>
				<button type="submit" class="btn btn-primary">Thank You</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>