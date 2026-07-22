<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<style>
body{
	background:#f8f9fa;
	padding:30px;
}

.card{
	max-width:700px;
	margin:auto;
}
</style>

</head>

<body>

<div class="card shadow">

	<div class="card-header bg-primary text-white">

		<h3>
			<i class="bi bi-building-add"></i>
			Add Company
		</h3>

	</div>

	<div class="card-body">

		<form action="<%=request.getContextPath()%>/AddCompanyServlet"
			method="post">

			<div class="mb-3">

				<label>Company Name</label>

				<input
					type="text"
					name="company_name"
					class="form-control"
					required>

			</div>

			<div class="mb-3">

				<label>Package</label>

				<input
					type="text"
					name="company_package"
					class="form-control"
					required>

			</div>

			<div class="mb-3">

				<label>Location</label>

				<input
					type="text"
					name="location"
					class="form-control"
					required>

			</div>

			<div class="mb-4">

				<label>Criteria</label>

				<input
					type="text"
					name="criteria"
					class="form-control"
					required>

			</div>

			<button
				class="btn btn-primary w-100">

				Add Company

			</button>

		</form>

	</div>

</div>

</body>
</html>