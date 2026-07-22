<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Placement Tracking System</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
	rel="stylesheet">

<style>
.hero {
	min-height: 90vh;
	background: linear-gradient(135deg, #0d6efd, #0a58ca);
	color: white;
}

.card:hover {
	transform: translateY(-5px);
	transition: .3s;
}

footer {
	background: #212529;
}
</style>

</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<div class="container">
			<a class="navbar-brand fw-bold" href="#"> <i
				class="bi bi-mortarboard-fill"></i> Institute
			</a>

			<button class="navbar-toggler" data-bs-toggle="collapse"
				data-bs-target="#menu">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="#home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#login">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Hero -->
	<section class="hero d-flex align-items-center" id="home">
		<div class="container">
			<div class="row align-items-center">

				<div class="col-lg-6">
					<h1 class="display-4 fw-bold">Placement Tracking System</h1>

					<p class="lead">Manage students, companies and placement
						activities from one platform.</p>

					<a href="#login" class="btn btn-warning btn-lg"> Get Started </a>
				</div>

				<div class="col-lg-6 text-center">
					<img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
						class="img-fluid w-75">
				</div>

			</div>
		</div>
	</section>

	<!-- About -->
	<section class="py-5 bg-light" id="about">
		<div class="container">

			<h2 class="text-center mb-5">Why Choose Our System?</h2>

			<div class="row g-4">

				<div class="col-md-4">
					<div class="card h-100 shadow text-center p-4">
						<i class="bi bi-buildings fs-1 text-primary"></i>
						<h4>Company Management</h4>
						<p>Add and manage company details.</p>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card h-100 shadow text-center p-4">
						<i class="bi bi-people-fill fs-1 text-success"></i>
						<h4>Student Tracking</h4>
						<p>Track profiles and placement status.</p>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card h-100 shadow text-center p-4">
						<i class="bi bi-briefcase-fill fs-1 text-danger"></i>
						<h4>Placement Records</h4>
						<p>Maintain complete placement history.</p>
					</div>
				</div>

			</div>
		</div>
	</section>

	<!-- Login -->
	<section class="py-5" id="login">
		<div class="container">

			<h2 class="text-center mb-5">Login Portal</h2>

			<div class="row justify-content-center g-4">

				<div class="col-md-4">
					<div class="card shadow text-center p-4">
						<i class="bi bi-person-workspace fs-1 text-primary"></i>

						<h3 class="mt-3">Admin</h3>

						<a href="<%=request.getContextPath()%>/admin/AdminLogin.jsp"
							class="btn btn-primary w-100 mt-3"> Login </a>

					</div>
				</div>

				<div class="col-md-4">
					<div class="card shadow text-center p-4">
						<i class="bi bi-person-circle fs-1 text-success"></i>

						<h3 class="mt-3">Student</h3>

						<a href="<%=request.getContextPath()%>/student/StudentLogin.jsp"
							class="btn btn-success w-100 mt-3"> Login </a>

					</div>
				</div>

			</div>
		</div>
	</section>

	<footer class="text-center text-white py-4">
		<h4>Institute</h4>
		<p class="mb-0">© 2026 Placement Tracking System</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>