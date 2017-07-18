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
					<li class="tutorials"><a href="#">Car</a></li>
					<li class="about"><a href="../vehicle/vehicles">Vehicle</a>
						<!-- <ul>
							<li><a href="../vehicle/vehicles">Show All </a></li>
							<li><a href="../vehicle/add">Add</a></li>
						</ul> -->
					</li>
					<li class="about"><a href="<%=request.getContextPath() %>/reservation/admin/list">Reservation</a>
<!-- 						<ul> -->
<%-- 							<li><a href="<%=request.getContextPath() %>/reservation/admin/list">Show All </a></li> --%>
<!-- 						</ul> -->
					</li>
					<li class="news"><a href="<%=request.getContextPath() %>/payment/admin/allPayment">Payment</a>
<!-- 						<ul> -->
<%-- 							<li><a href="<%=request.getContextPath() %>/payment/admin/allPayment">Show All</a></li> --%>
<!-- 						</ul> -->
					</li>
					<li class="contact"><a href="../user/logout">Logout</a></li>
				</ul>
			</div>
		</header>
	</div>
</body>
</html>