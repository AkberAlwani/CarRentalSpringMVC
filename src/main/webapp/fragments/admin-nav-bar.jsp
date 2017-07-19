<%@ page contentType="text/html;charset=UTF-8"%>

<html xmlns:th="http://www.thymeleaf.org">
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
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
					<li class="home"><a href="<%=request.getContextPath()%>/welcome">Home</a></li>
					<li class="cars"><a href="#">Car Types</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/types/all">Show All </a></li>
							<li><a href="<%=request.getContextPath()%>/types/add">Add</a></li>
						</ul>
					</li>
					
					<li class="about"><a href="#">Vehicle</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/vehicles/all">Show All </a></li>
							<li><a href="<%=request.getContextPath()%>/vehicles/add">Add</a></li>
						</ul>
					</li>

					<li class="cars"><a href="<%=request.getContextPath()%>/customers/all">Customers</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/customers/all">View All</a></li>
							<li><a href="<%=request.getContextPath()%>/customers/add">Add</a></li>
						</ul>
					</li>
					
					<li class="cars"><a href="<%=request.getContextPath()%>/locations/all">Location</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/locations/all">Show All </a></li>
							<li><a href="<%=request.getContextPath()%>/locations/add">Add</a></li>
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