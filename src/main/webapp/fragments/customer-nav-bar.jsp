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
					
					<li class="about"><a href="#">Vehicle</a>
						<ul>
							<li><a href="vehicles/list">Show All </a></li>
							<li><a href="<%=request.getContextPath()%>/reservation/returnlist">Return</a></li>
						</ul>
					</li>

	
					<li class="about"><a href="#">Reservation</a>
 						<ul>
 							<li><a href="<%=request.getContextPath() %>/reservation/list">Show All</a></li>
 							<li><a href="<%=request.getContextPath() %>/reservation/admin/list/2">History</a></li>
 						</ul> 
 					</li>
					
 					<li class="news"><a href="<%=request.getContextPath() %>/payment/view-all-payment">Payment</a>
 						<ul>
 							<li><a href="<%=request.getContextPath() %>/payment/view-all-payment">Show All</a></li>
						</ul>
					</li>
					
	 
 					
 					<li class="contact"><a href="<%=request.getContextPath() %>/logout">Logout</a></li>
				</ul>
			</div>
		</header>
	</div>
</body>
</html>