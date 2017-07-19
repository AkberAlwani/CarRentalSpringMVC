<%@ page contentType="text/html;charset=UTF-8" %>  

<html xmlns:th="http://www.thymeleaf.org">
<head>
<link href="<%=request.getContextPath() %>/resources/static/css/bootstrap.css" rel="stylesheet"  />
<link href="<%=request.getContextPath() %>/resources/static/css/main.css" rel="stylesheet"  />
<meta charset="utf-8" />
</head>
<body>
	<div class="row" th:fragment="header">
		<header>
			<div class="nav">
				<ul>
					<li class="home"><a href="../user/homeRedicrect">Home</a></li>
					<li class="cars"><a href="types/all">Car Types</a></li>
					<li class="vehicles"><a href="#">Vehicle</a>
						<ul>
							<li><a href="vehicles/all">Show All </a></li>
							<li><a href="vehicles/add">Add</a></li>
						</ul> 
					</li>
					<li class="about"><a href="<%=request.getContextPath() %>/reservation/admin/list">Reservation</a>
					<li class="cars"><a href="customers/all">View Customers</a></li>
<!-- 						<ul>
<%-- 							<li><a href="<%=request.getContextPath() %>/reservation/admin/list">Show All </a></li> %>
<!-- 						</ul> 
					</li>
					<li class="news"><a href="<%=request.getContextPath() %>/payment/admin/allPayment">Payment</a>
<!-- 						<ul> -->
<%-- 							<li><a href="<%=request.getContextPath() %>/payment/admin/allPayment">Show All</a></li> --%>
<!-- 						</ul> -->
					</li>
					<li class="news"><a href="<%=request.getContextPath() %>/payment/admin/allPayment">Payment</a>
					
					<li class="contact"><a href="../user/logout">Logout</a></li>
				</ul>
			</div>
		</header>
	</div>
</body>
</html>