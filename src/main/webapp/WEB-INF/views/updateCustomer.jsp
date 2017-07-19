<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
</head>
<body>
	<section>
	<div class="row">
			<jsp:include page="/fragments/admin-nav-bar.jsp"></jsp:include>
	</div>
	</section>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customer Profile</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newCustomer" class="form-horizontal"  >
			<fieldset>
				<legend>Change customer profile</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="customerNumber"> Customer Number</label>
					<div class="col-lg-10">
						<form:input id="customerNumber" path="customerNumber" type="text" value ="${newCustoemr.customerNumber}" class="form:input-large"/>
						<form:errors path="customerNumber" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" value="${customer.firstName}" class="form:input-large"/>
						<form:errors path="firstName" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" value="${customer.lastName}" class="form:input-large"/>
						<form:errors path="lastName" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="age">Phone Number</label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="text" value="${customer.phoneNumber}" class="form:input-large"/>
						<form:errors path="phoneNumber" cssClass="text-danger"/>
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="age">Email</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text" value="${customer.email}" class="form:input-large"/>
						<form:errors path="email" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="userName">User Name</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="username" path="account.username" type="text" value="${customer.username}" class="form:input-large"/>
							<form:errors path="account.username" cssClass="text-danger"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password id="password" path="account.password"  value="${customer.account.password}" class="form:input-large"/>
							<form:errors path="account.password" cssClass="text-danger"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="verifyPassword">Verify Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password  path="account.verifyPassword"  value="${customer.account.password}" class="form:input-large"/>
							<form:errors path="account.verifyPassword" cssClass="text-danger"/>
						</div>
					</div>
				</div>

					<div class="form-group">
<!-- 					<label class="control-label col-lg-2" for="authority">Role</label> -->
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input  path="account.authority.authority" type="hidden" value="ROLE_USER" class="form:input-large"/>
							<form:errors path="account.authority.authority" cssClass="text-danger"/>
						</div>
					</div>
				</div>
 
 							<form:hidden path="account.enabled" value="TRUE"  />
 

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
