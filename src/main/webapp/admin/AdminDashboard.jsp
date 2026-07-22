<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Admin Dashboard</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<style>
body{
	margin:0;
	background:#f8f9fa;
	font-family:Arial,sans-serif;
}

/* Sidebar */

.sidebar{
	width:240px;
	height:100vh;
	position:fixed;
	left:0;
	top:0;
	background:#0d6efd;
	padding:20px;
	overflow-y:auto;
}

.sidebar h3{
	color:#fff;
	text-align:center;
	font-weight:bold;
}

.sidebar p{
	color:#dbeafe;
	text-align:center;
	font-size:14px;
}

.sidebar hr{
	color:#fff;
}

.sidebar a{
	display:block;
	color:#fff;
	text-decoration:none;
	padding:12px;
	margin-bottom:8px;
	border-radius:8px;
	font-size:16px;
	transition:.3s;
}

.sidebar a:hover{
	background:rgba(255,255,255,.2);
	color:#fff;
}

/* Main */

.main{
	margin-left:240px;
	padding:20px;
	height:100vh;
}

iframe{
	width:100%;
	height:calc(100vh - 40px);
	border:none;
	background:#fff;
	border-radius:10px;
	box-shadow:0 2px 10px rgba(0,0,0,.1);
}

/* Mobile */

@media(max-width:768px){

	.sidebar{
		position:relative;
		width:100%;
		height:auto;
	}

	.main{
		margin-left:0;
		height:auto;
		padding:10px;
	}

	iframe{
		height:600px;
	}
}
</style>

</head>

<body>

<!-- Sidebar -->

<div class="sidebar">

	<h3>Admin Panel</h3>

	<p>Placement Tracking System</p>

	<hr>

	<a href="<%=request.getContextPath()%>/DashboardServlet"
		target="contentFrame">

		<i class="bi bi-speedometer2"></i>
		Dashboard

	</a>

	<a href="<%=request.getContextPath()%>/admin/AddCompany.jsp"
		target="contentFrame">

		<i class="bi bi-building-add"></i>
		Add Company

	</a>

	<a href="<%=request.getContextPath()%>/ViewCompanyServlet"
		target="contentFrame">

		<i class="bi bi-buildings"></i>
		View Companies

	</a>

	<a href="<%=request.getContextPath()%>/ViewStudentsServlet"
		target="contentFrame">

		<i class="bi bi-people-fill"></i>
		View Students

	</a>

	<a href="<%=request.getContextPath()%>/ViewPlacementServlet"
		target="contentFrame">

		<i class="bi bi-briefcase-fill"></i>
		Placements

	</a>

	<a href="<%=request.getContextPath()%>/AdminLogoutServlet"
		target="_top">

		<i class="bi bi-box-arrow-right"></i>
		Logout

	</a>

</div>

<!-- Main Content -->

<div class="main">

	<h3 class="mb-3">

		<i class="bi bi-speedometer2"></i>

		Admin Dashboard

	</h3>

	<iframe
		name="contentFrame"
		src="<%=request.getContextPath()%>/DashboardServlet">

	</iframe>

</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>