<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Admin Login</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<style>
body {
	background: linear-gradient(135deg, #0d6efd, #0a58ca);
	min-height: 100vh;
}

.login-card {
	max-width: 420px;
	border-radius: 15px;
}

.login-icon {
	font-size: 70px;
	color: #0d6efd;
}
</style>

</head>

<body>

	<div
		class="container vh-100 d-flex justify-content-center align-items-center">

		<div class="card shadow login-card w-100">

			<div class="card-body p-4">

				<div class="text-center mb-4">

					<i class="bi bi-person-circle login-icon"></i>

					<h2 class="fw-bold mt-2">Admin Login</h2>

					<p class="text-muted">Placement Tracking System</p>

				</div>

				<form action="<%=request.getContextPath()%>/AdminLoginServlet"
					method="post">

					<div class="mb-3">

						<input type="text" name="username"
							class="form-control form-control-lg" placeholder="Username"
							required>

					</div>

					<div class="mb-4">

						<input type="password" name="password"
							class="form-control form-control-lg" placeholder="Password"
							required>

					</div>

					<button type="submit" class="btn btn-primary btn-lg w-100">

						<i class="bi bi-box-arrow-in-right"></i> Login

					</button>

				</form>

				<div class="text-center mt-4">

					<a href="<%=request.getContextPath()%>/home.jsp"
						class="text-decoration-none"> <i class="bi bi-arrow-left"></i>
						Back to Home

					</a>

				</div>

			</div>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>