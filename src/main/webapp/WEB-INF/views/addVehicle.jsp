<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Vehicles</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Vehicles</h1>
				<p>Add Vehicle</p>
			</div>
 		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newVehicle" class="form-horizontal" >
			<fieldset>
				<legend>Add New Vehicle</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="vehicleId"><spring:message code="addVehicle.form.vehicleId.label"/></label>
					<div class="col-lg-10">
						<form:input id="vehicleId" path="vehicleId" type="text" class="form:input-large"/>
						<form:errors path="vehicleId" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="makeyear"><spring:message code="addVehicle.form.year.label"/></label>
					<div class="col-sm-5">
						<form:input id="makeyear" path="makeyear" type="text" class="form:input-small"/>
						<form:errors path="makeyear" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="make"><spring:message code="addVehicle.form.make.label"/></label>
					<div class="col-sm-3">
						<div class="form:input-prepend">
							<form:input id="make" path="make" type="text" class="form:input-small"/>
							<form:errors path="make" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="plateNumber"><spring:message code="addVehicle.form.plateNumber.label"/></label>
					<div class="col-lg-10">
						<form:textarea id="plateNumber" path="plateNumber" rows = "2"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="dailyRate"><spring:message code="addVehicle.form.dailyRate.label"/></label>
					<div class="col-lg-10">
						<form:textarea id="dailyRate" path="dailyRate" rows = "2"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="dailyFine"><spring:message code="addVehicle.form.dailyFine.label"/></label>
					<div class="col-lg-10">
						<form:textarea id="dailyFine" path="dailyFine" rows = "2"/>
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
