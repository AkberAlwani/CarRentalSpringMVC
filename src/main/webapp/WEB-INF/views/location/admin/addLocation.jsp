<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Vehicle Type</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Add Location</h1>
			</div>
 		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newLocation" class="form-horizontal" >
			<fieldset>
	
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<form:input type="hidden" id="Id" path="Id" />
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="location"><spring:message code="addType.form.name.label"/></label>
					<div class="col-lg-10">
						<form:input id="location" path="location" type="text" class="form:input-large"/>
						<form:errors path="location" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="city"><spring:message code="addType.form.description.label"/></label>
					<div class="col-lg-10">
						<form:input id="city" path="city" type="text" class="form:input-large"/>
						<form:errors path="city" cssClass="text-danger"/>
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
