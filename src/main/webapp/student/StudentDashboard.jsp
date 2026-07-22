<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Student Dashboard</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<style>
body{
	background:#f8f9fa;
}

.sidebar{
	width:240px;
	height:100vh;
	position:fixed;
	background:#0d6efd;
	padding:20px;
}

.main{
	margin-left:240px;
	height:100vh;
}

.topbar{
	height:60px;
	background:#fff;
	padding:15px 25px;
	box-shadow:0 2px 5px rgba(0,0,0,.1);
}

iframe{
	width:100%;
	height:calc(100vh - 60px);
	border:none;
	background:#fff;
}

.sidebar a{
	display:block;
	color:#fff;
	text-decoration:none;
	padding:10px;
	border-radius:6px;
	margin-bottom:8px;
}

.sidebar a:hover{
	background:rgba(255,255,255,.2);
}

@media(max-width:768px){

	.sidebar{
		position:relative;
		width:100%;
		height:auto;
	}

	.main{
		margin-left:0;
		height:auto;
	}

	iframe{
		height:600px;
	}
}
</style>

</head>

<body>

<div class="sidebar text-white">

	<h3 class="text-center">
		<i class="bi bi-mortarboard-fill"></i>
		SPTS
	</h3>

	<p class="text-center small">
		Student Dashboard
	</p>

	<hr>

	<a href="<%=request.getContextPath()%>/StudentDashboardServlet"
		target="contentFrame">
		<i class="bi bi-speedometer2"></i>
		Dashboard
	</a>

	<a href="<%=request.getContextPath()%>/ViewProfileServlet"
		target="contentFrame">
		<i class="bi bi-person-circle"></i>
		View Profile
	</a>

	<a href="<%=request.getContextPath()%>/UpdateProfileServlet"
		target="contentFrame">
		<i class="bi bi-pencil-square"></i>
		Update Profile
	</a>

	<a href="<%=request.getContextPath()%>/StudentViewCompanyServlet"
		target="contentFrame">
		<i class="bi bi-buildings"></i>
		View Companies
	</a>

	<a href="<%=request.getContextPath()%>/StudentPlacementStatusServlet"
		target="contentFrame">
		<i class="bi bi-briefcase-fill"></i>
		Placement Status
	</a>

	<a href="<%=request.getContextPath()%>/StudentLogoutServlet">
		<i class="bi bi-box-arrow-right"></i>
		Logout
	</a>

</div>

<div class="main">

	<div class="topbar">

		<h4 class="mb-0">
			<i class="bi bi-speedometer2"></i>
			Student Dashboard
		</h4>

	</div>

	<iframe
		name="contentFrame"
		src="<%=request.getContextPath()%>/StudentDashboardServlet">
	</iframe>

</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>