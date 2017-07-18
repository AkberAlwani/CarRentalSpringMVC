<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<link th:href="@{/css/bootstrap.css}" rel="stylesheet" media="screen" />
<link th:href="@{/css/main.css}" rel="stylesheet" media="screen" />
<meta charset="utf-8" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-6 col-xs-12">

				<div class="panel panel-primary">

					<div class="panel-heading">
						Vehicle #<span th:text="${vehicle.vehicleId}"></span> Update
					</div>

					<div class="panel-body">

						<div th:if="${updated}">
							<p id="updateMessage" class="alert alert-info">Vehicle
								information successful updated.</p>
						</div>

						<form class="form-horizontal row-border"
							th:action="@{/vehicle/update}" method="post" id="addCar">

							<div class="form-group row">
								<label class="col-xs-2 col-form-label" for="vehicleId"
									id="NumberOfSeats-ariaLabel">Vehicle ID :</label>
								<div class="form-control">
									<input class="col-xs-10" id="vehicleId" name="vehicleId"
										type="number" th:field="${vehicle.vehicleId}"
										readonly="readonly" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-xs-2 col-form-label" for="CarBrand"
									id="CarBrand-ariaLabel"> Car Brand :</label>
								<div class="col-xs-10">
									<input class="form-control" id="CarBrand" name="brand"
										type="text" th:field="${vehicle.brand}" /> <span
										class='alert-danger'
										th:if="${#fields.hasErrors('vehicle.brand')}"
										th:errors="${vehicle.brand}">Name Error</span>
								</div>
							</div>

							<div class="form-group row">
								<label class="col-xs-2 col-form-label" for="CarType"
									id="CarType-ariaLabel">Car Type :</label>
								<div class="col-xs-10">

									<input class="form-control" id="CarType" name="type"
										type="text" th:field="${vehicle.type}" /> <span
										class='alert-danger'
										th:if="${#fields.hasErrors('vehicle.type')}"
										th:errors="${vehicle.type}">Name Error</span>
								</div>
							</div>

							<div class="form-group row">
								<label class="col-xs-2 col-form-label" for="CarModel"
									id="CarModel-ariaLabel">Car Model :</label>
								<div class="col-xs-10">
									<input class="form-control" id="CarModel" name="model"
										type="number" th:field="${vehicle.model}" /> <span
										class='alert-danger'
										th:if="${#fields.hasErrors('vehicle.model')}"
										th:errors="${vehicle.model}">Name Error</span>
								</div>
							</div>

							<div class="form-group row">
								<label class="col-xs-2 col-form-label"
									id="PlateNumber-ariaLabel">Plate Number :</label>
								<div class="col-xs-10">
									<input class="form-control" id="CarPlateNumber"
										name="plateNumber" type="text"
										th:field="${vehicle.vehiclePlateNumber}" /> <span
										class='alert-danger'
										th:if="${#fields.hasErrors('vehicle.vehiclePlateNumber')}"
										th:errors="${vehicle.vehiclePlateNumber}">Name Error</span>
								</div>
							</div>

							<div class="form-group row">
								<label class="col-xs-2 col-form-label" for="NumberOfSeats"
									id="NumberOfSeats-ariaLabel">Number Of Seats :</label>
								<div class="form-control">
									<input class="col-xs-10" id="NumberOfSeats"
										name="numberOfSeats" min="1" step="1" value="2" type="number"
										th:field="${vehicle.numberOfSeats}" /> <span
										class='alert-danger'
										th:if="${#fields.hasErrors('vehicle.numberOfSeats')}"
										th:errors="${vehicle.numberOfSeats}">Name Error</span>
								</div>
							</div>

							<div class="form-group row">
								<label class="col-xs-2 col-form-label" for="DailyPrice"
									id="DailyPrice-ariaLabel">Daily Price:</label>
								<div class="col-xs-10">
									<input class="form-control" id="DailyPrice" name="dailyPrice"
										type="text" th:field="${vehicle.dailyPrice}" /> <span
										class='alert-danger'
										th:if="${#fields.hasErrors('vehicle.dailyPrice')}"
										th:errors="${vehicle.dailyPrice}">Name Error</span>
								</div>
							</div>
							<div style="display: none">							
								<input readonly="readonly" type="checkbox" name="isAvailable"
									th:checked="${vehicle.isAvailable} ? 'checked'"/>
							</div>
							<div  class="form-group row">
								<input class="btn-primary" type="submit" value="Update Car" />
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>