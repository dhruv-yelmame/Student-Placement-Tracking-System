package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import com.spts.model.Company;

import com.spts.service.CompanyService;
import com.spts.service.CompanyServiceImpl;

import com.spts.service.PlacementService;
import com.spts.service.PlacementServiceImpl;

@WebServlet("/StudentViewCompanyServlet")
public class StudentViewCompanyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		Integer sid = (Integer) session.getAttribute("sid");

		if (sid == null) {

			response.sendRedirect(

					request.getContextPath() + "/student/StudentLogin.html"

			);

			return;
		}

		CompanyService service = new CompanyServiceImpl();

		List<Company> list = service.getAllCompanies();

		PlacementService pservice = new PlacementServiceImpl();

		out.println("<!DOCTYPE html>");

		out.println("<html>");

		out.println("<head>");

		out.println("<title>");
		out.println("Available Companies");
		out.println("</title>");

		out.println(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");

		out.println(
				"<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css'>");

		out.println("<style>");

		out.println("*{");
		out.println("margin:0;");
		out.println("padding:0;");
		out.println("box-sizing:border-box;");
		out.println("}");

		out.println("body{");
		out.println("background:#EEF2FF;");
		out.println("padding:30px;");
		out.println("font-family:Arial;");
		out.println("}");

		out.println(".table-box{");
		out.println("background:white;");
		out.println("padding:30px;");
		out.println("border-radius:20px;");
		out.println("box-shadow:0px 5px 20px rgba(0,0,0,0.08);");
		out.println("}");

		out.println(".title{");
		out.println("font-size:32px;");
		out.println("font-weight:bold;");
		out.println("margin-bottom:25px;");
		out.println("color:#1E293B;");
		out.println("}");

		out.println(".table th{");
		out.println("background:#2563EB;");
		out.println("color:white;");
		out.println("text-align:center;");
		out.println("}");

		out.println(".table td{");
		out.println("text-align:center;");
		out.println("vertical-align:middle;");
		out.println("}");

		out.println(".btn-apply{");
		out.println("background:#16A34A;");
		out.println("color:white;");
		out.println("padding:8px 18px;");
		out.println("border-radius:8px;");
		out.println("text-decoration:none;");
		out.println("font-weight:bold;");
		out.println("}");

		out.println(".btn-withdraw{");
		out.println("background:#DC2626;");
		out.println("color:white;");
		out.println("padding:8px 18px;");
		out.println("border-radius:8px;");
		out.println("text-decoration:none;");
		out.println("font-weight:bold;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='table-box'>");

		out.println("<div class='title'>");

		out.println("<i class='bi bi-buildings-fill'></i> ");

		out.println("Available Companies");

		out.println("</div>");

		out.println("<table class='table table-bordered table-hover'>");

		out.println("<tr>");

		out.println("<th>ID</th>");

		out.println("<th>Company</th>");

		out.println("<th>Package</th>");

		out.println("<th>Location</th>");

		out.println("<th>Criteria</th>");

		out.println("<th>Action</th>");

		out.println("</tr>");

		for (Company c : list) {

			out.println("<tr>");

			out.println("<td>");
			out.println(c.getCid());
			out.println("</td>");

			out.println("<td>");
			out.println(c.getCompany_name());
			out.println("</td>");

			out.println("<td>");
			out.println(c.getCompany_package());
			out.println(" LPA");
			out.println("</td>");

			out.println("<td>");
			out.println(c.getLocation());
			out.println("</td>");

			out.println("<td>");
			out.println(c.getCriteria());
			out.println("%");
			out.println("</td>");

			out.println("<td>");

			String status = pservice.getApplicationStatus(sid, c.getCid());

			if (status != null) {

				if (status.equals("Applied")) {

					out.println(

							"<a href='WithdrawCompanyServlet?cid=" + c.getCid() + "' class='btn-withdraw'>"

									+ "<i class='bi bi-x-circle-fill'></i> " + "Withdraw"

									+ "</a>"

					);
				}

				else if (status.equals("Selected")) {

					out.println(

							"<button class='btn btn-success' disabled>"

									+ "<i class='bi bi-check-circle-fill'></i> " + "Selected"

									+ "</button>"

					);
				}

				else if (status.equals("Rejected")) {

					out.println(

							"<button class='btn btn-danger' disabled>"

									+ "<i class='bi bi-x-circle-fill'></i> " + "Rejected"

									+ "</button>"

					);
				}

			}

			else {

				out.println(

						"<a href='ApplyCompanyServlet?cid=" + c.getCid() + "' class='btn-apply'>"

								+ "<i class='bi bi-check-circle-fill'></i> " + "Apply"

								+ "</a>"

				);
			}

			out.println("</td>");

			out.println("</tr>");
		}

		out.println("</table>");

		out.println("</div>");

		out.println("</body>");

		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}