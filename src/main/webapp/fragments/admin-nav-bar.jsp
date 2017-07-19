<%@ page contentType="text/html;charset=UTF-8"%>

<html xmlns:th="http://www.thymeleaf.org">
<head>
<link
	href="<%=request.getContextPath()%>/resources/static/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/static/css/main.css"
	rel="stylesheet" />
<meta charset="utf-8" />
</head>
<body>
	<div class="row" th:fragment="header">
		<header>
			<div class="nav">
				<ul>
					<li class="home"><a href="welcome">Home</a></li>
					<li class="cars"><a href="#">Car Types</a>
						<ul>
							<li><a href="types/all">Show All </a></li>
							<li><a href="types/add">Add</a></li>
						</ul>
					</li>
					
					<li class="about"><a href="#">Vehicle</a>
						<ul>
							<li><a href="vehicles/all">Show All </a></li>
							<li><a href="vehicles/add">Add</a></li>
						</ul>
					</li>

					<li class="cars"><a href="customers/all">Customers</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/customers/all">View All</a></li>
							<li><a href="<%=request.getContextPath()%>/customers/add">Add</a></li>
						</ul>
					</li>
					
					<li class="cars"><a href="locations/all">Location</a>
						<ul>
							<li><a href="locations/all">Show All </a></li>
							<li><a href="locations/add">Add</a></li>
						</ul>
					</li>
					
					<li class="about"><a href="#">Reservation</a>
 						<ul>
 							<li><a href="<%=request.getContextPath() %>/reservation/admin/list/0">Active </a></li>
 							<li><a href="<%=request.getContextPath() %>/reservation/admin/list/2">History </a></li>
 						</ul> 
 					</li>
					
 					<li class="news"><a href="<%=request.getContextPath() %>/payment/admin/allPayment">Payment</a>
 						<ul>
 							<li><a href="<%=request.getContextPath() %>/payment/admin/allPayment">Show All</a></li>
						</ul>
					</li>
 					
 					<li class="contact"><a href="<%=request.getContextPath() %>/logout">Logout</a></li>
				</ul>
			</div>
		</header>
	</div>
</body>
</html>