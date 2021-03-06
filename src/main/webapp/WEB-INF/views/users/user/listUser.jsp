<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<link th:href="@{/css/bootstrap.css}" rel="stylesheet" media="screen" />
	<link th:href="@{/css/main.css}" rel="stylesheet" media="screen" />
	<meta charset="utf-8" />
	<title>Users</title>
</head> 
<body>
	<div class="container">
		<div class="col-md-12 col-sm-6 col-xs-12">
			<div class="row">
				<div class="panel panel-primary">
					<a href="#" data-th-href="@{/login/admin}">Back</a>
					<div class="panel-heading">User List</div>

					<div class="panel-body">					
						
						<table class="table table-striped">
							<thead class="thead-inverse">
								<tr> 
									<td>Search User: </td>
									<td>	
										<form method="POST"  th:action="@{searchUser}">
											<input   type="text" name="userName"/>
											<input type="submit" value="Search" />
										</form>
									</td>
									<td>	
										<form method="GET"  th:action="@{/login/addUser}"> 
											<input type="submit" value="Add New User" />
										</form>
									</td>
								</tr>
								<tr>
									<th>#ID</th>
									<th>Full Name</th>
									<th>Identification Number</th>
									<th>Contact Number</th>
									<th>Email</th>
									<th>Address</th>
									<th>User Name</th>
									<th>IsActive</th>
									<th>Role</th>
									<th>Delete</th>
									<th>Edit</th>
								</tr>
							</thead>
							<tbody>
								<tr data-th-each="person : ${personList}"
									data-vID="${person.PersonId}">
									<td data-th-text="${person.PersonId}"></td>
									<td data-th-text="${person.name}"></td>
									<td data-th-text="${person.identificationNumber}"></td>
									<td data-th-text="${person.phoneNumber}"></td>
									<td data-th-text="${person.email}"></td>
									<td data-th-text="${person.address}"></td>
									<td data-th-text="${person.account.username}"></td>
									<td data-th-text="${person.account.active}"></td>
									<td data-th-text="${person.account.accountType}"></td>
									<td><a href="#" data-th-href="@{'/user/delete/'+${person.PersonId}}">Delete</a></td> 
									<td><a href="#" data-th-href="@{'/user/update/'+${person.PersonId}}">Edit</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>