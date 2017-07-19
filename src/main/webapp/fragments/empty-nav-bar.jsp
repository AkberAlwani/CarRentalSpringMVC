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
					<li class="home"></li>
					<li class="cars"></li>
				</ul>
			</div>
		</header>
	</div>
</body>
</html>