<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<link th:href="@{/css/bootstrap.css}" rel="stylesheet" media="screen" />
	<link th:href="@{/css/main.css}" rel="stylesheet" media="screen" />
	<meta charset="utf-8" />
	<title>User SignUp</title>
</head> 
 
<body>  
		<div class="container">
		<div class="col-md-12 col-sm-6 col-xs-12">
			<div class="row">
				<div class="panel panel-primary">
					<div class="panel-heading">Add User</div>

					<div class="panel-body">
						<form method="POST"  th:action="@{addUser}"> 
													<table class="table table-striped"> 
														<tr>
															<th>Full Name</th> 
															<td><input type="text" placeholder="Full Name" name="name" th:field="*{person.name}"  /></td>
															<td th:if="${#fields.hasErrors('person.name')}" th:errors="*{person.name}">Name error message</td>
															<!-- <td><td th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name Error</td></td> -->
														</tr>
														<tr>
															<th>Identification Number</th>
															<td><input type="text" placeholder="Identification Number" name="identificationNumber" th:field="*{person.identificationNumber}"  /></td>
															<td th:if="${#fields.hasErrors('person.identificationNumber')}" th:errors="*{person.identificationNumber}">Identification Number error message</td>
														</tr>
													 	<tr>
															<th>Phone Number</th>
															<td><input type="text" placeholder="Contact Number" name="phoneNumber" th:field="*{person.phoneNumber}"  /></td> 
															<td th:if="${#fields.hasErrors('person.phoneNumber')}" th:errors="*{person.phoneNumber}">Phone Number Error Message</td>
														</tr> 
														<tr>
															<th>Email Address</th>
															<td><input type="text" placeholder="Email" name="email" th:field="*{person.email}" /></td>
															<td th:if="${#fields.hasErrors('person.email')}" th:errors="*{person.email}">Emails Error Message</td>
														</tr>
														<tr>
															 <th>Street</th>
															 <td><input type="text" placeholder="Street" name="street" th:field="*{address.street}" /></td>
															 <td th:if="${#fields.hasErrors('address.street')}" th:errors="*{address.street}">Street Error Message</td>
														</tr>
														<tr>
															 <th>Zip</th>
															 <td><input type="text" placeholder="Zip" name="zip" th:field="*{address.zip}" /></td>
															 <td th:if="${#fields.hasErrors('address.zip')}" th:errors="*{address.zip}">Zip Error Message</td>
														</tr>
														<tr>
															 <th>City</th>
															 <td><input type="text" placeholder="City" name="city" th:field="*{address.city}" /></td>
															 <td th:if="${#fields.hasErrors('address.city')}" th:errors="*{address.city}">City Error Message</td>
														</tr>
														<tr>
															 <th>State</th>
															 <td><input type="text" placeholder="State" name="state" th:field="*{address.state}" /></td>
															 <td th:if="${#fields.hasErrors('address.state')}" th:errors="*{address.state}">State Error Message</td>
														</tr>
														<tr> 
															 <th>Country</th>
															 <td><input type="text" placeholder="country" name="country" th:field="*{address.country}" /></td>
															 <td th:if="${#fields.hasErrors('address.country')}" th:errors="*{address.country}">Country Error Message</td>
														</tr>
														<tr>
															<th>User Name</th>
															<td><input type="text" placeholder="User Name" name="username" th:field="*{account.username}" /></td>
															<td th:if="${#fields.hasErrors('account.username')}" th:errors="*{account.username}">User NameError Message</td>
														</tr>
														<tr>
															<th>Password</th>
															<td><input type="password" placeholder="Passwprd" name="password" th:field="*{account.password}"  /></td>
															<td th:if="${#fields.hasErrors('account.password')}" th:errors="*{account.password}">Password Error Message</td>
														</tr> 
														<tr>
															<td><input type="submit" value="Submit" /></td>
															<td><input type="reset" value="Reset" /> </td>
														</tr>
													</table>
						 </form>  
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>