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
						Vehicle #<span th:text ="${vehicle.vehicleId}"></span> Detail
					</div>

					<div class="panel-body">

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
								<input readonly="readonly" class="form-control" id="CarBrand"
									name="brand" type="text" th:field="${vehicle.brand}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-xs-2 col-form-label" for="CarType"
								id="CarType-ariaLabel">Car Type :</label>
							<div class="col-xs-10">
								<input readonly="readonly" class="form-control" id="CarType"
									name="type" type="text" th:field="${vehicle.type}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-xs-2 col-form-label" for="CarModel"
								id="CarModel-ariaLabel">Car Model :</label>
							<div class="col-xs-10">
								<input readonly="readonly" class="form-control" id="CarModel"
									name="model" type="number" th:field="${vehicle.model}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-xs-2 col-form-label" id="PlateNumber-ariaLabel">Plate
								Number :</label>
							<div class="col-xs-10">
								<input readonly="readonly" class="form-control"
									id="CarPlateNumber" name="plateNumber" type="text"
									th:field="${vehicle.vehiclePlateNumber}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-xs-2 col-form-label" for="NumberOfSeats"
								id="NumberOfSeats-ariaLabel">Number Of Seats :</label>
							<div class="form-control">
								<input readonly="readonly" class="col-xs-10" id="NumberOfSeats"
									name="numberOfSeats" min="1" step="1" value="2" type="number"
									th:field="${vehicle.numberOfSeats}" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-xs-2 col-form-label" for="DailyPrice"
								id="DailyPrice-ariaLabel">Daily Price:</label>
							<div class="col-xs-10">
								<input readonly="readonly" class="form-control" id="DailyPrice"
									name="dailyPrice" type="text" th:field="${vehicle.dailyPrice}" />
							</div>
						</div>
						<div class="form-group row">
							<div class="col-xs-10">
								<select readonly="readonly" required='required'>
									class="selectpicker">
									<option
										th:attr="selected=${vehicle.isAvailable}? 'selected' : null"
										value="YES">Available For Rent</option>
									<option
										th:attr="selected=!${vehicle.isAvailable}? 'selected' : null"
										value="NO">Not Available For Rent</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>