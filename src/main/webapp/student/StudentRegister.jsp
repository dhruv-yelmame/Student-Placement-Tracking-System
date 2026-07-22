<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Student Registration</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<style>
body {
	background: linear-gradient(135deg, #0d6efd, #0a58ca);
	min-height: 100vh;
}

.register-card {
	border-radius: 15px;
	overflow: hidden;
}

.left-panel {
	background: linear-gradient(135deg, #0f172a, #2563eb);
	color: #fff;
}

.form-control {
	height: 45px;
}
</style>

</head>

<body>

	<div class="container py-5">

		<div class="card shadow register-card">

			<div class="row g-0">

				<!-- Left Panel -->

				<div
					class="col-lg-4 left-panel d-flex flex-column justify-content-center p-5">

					<h2 class="fw-bold">Placement Tracking System</h2>

					<p class="mt-3">Register yourself to apply for companies, track
						placements, and manage your profile from one platform.</p>

				</div>

				<!-- Right Panel -->

				<div class="col-lg-8 p-5">

					<h3 class="text-center fw-bold mb-4">Student Registration</h3>

					<form action="<%=request.getContextPath()%>/StudentRegisterServlet"
						method="post">

						<div class="row">

							<div class="col-md-6 mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									name="name" class="form-control" placeholder="Enter Full Name"
									required>
							</div>

							<div class="col-md-6 mb-3">
								<label class="form-label">Email</label> <input type="email"
									name="email" class="form-control" placeholder="Enter Email"
									required>
							</div>

							<div class="col-md-6 mb-3">
								<label class="form-label">Mobile</label> <input type="text"
									name="mobile" class="form-control" placeholder="Enter Mobile"
									required>
							</div>

							<div class="col-md-6 mb-3">
								<label class="form-label">Course</label> <input type="text"
									name="course" class="form-control" placeholder="Enter Course"
									required>
							</div>

							<div class="col-md-6 mb-3">
								<label class="form-label">Percentage</label> <input
									type="number" step="0.01" name="percentage"
									class="form-control" placeholder="Enter Percentage" required>
							</div>

							<div class="col-md-6 mb-3">
								<label class="form-label">Skills</label> <input type="text"
									name="skills" class="form-control"
									placeholder="Java, SQL, Spring" required>
							</div>

							<div class="col-12 mb-4">
								<label class="form-label">Password</label> <input
									type="password" name="password" class="form-control"
									placeholder="Enter Password" required>
							</div>

						</div>

						<button type="submit" class="btn btn-primary btn-lg w-100">

							<i class="bi bi-person-plus-fill"></i> Register

						</button>

					</form>

					<div class="text-center mt-4">

						Already have an account? <a
							href="<%=request.getContextPath()%>/student/StudentLogin.jsp"
							class="text-decoration-none fw-bold"> Login Here </a>

					</div>

					<div class="text-center mt-3">

						<a href="<%=request.getContextPath()%>/home.jsp"
							class="text-decoration-none"> <i class="bi bi-arrow-left"></i>
							Back to Home

						</a>

					</div>

				</div>

			</div>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
		
	</script>

</body>
</html>