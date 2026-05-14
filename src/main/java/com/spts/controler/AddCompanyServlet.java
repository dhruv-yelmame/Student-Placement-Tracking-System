package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.model.Company;
import com.spts.service.CompanyService;
import com.spts.service.CompanyServiceImpl;

@WebServlet("/AddCompanyServlet")
public class AddCompanyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		// Session Check

		HttpSession session = request.getSession();

		String admin = (String) session.getAttribute("admin");

		if (admin == null) {

			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin.html");

			return;
		}

		// Form Data

		String company_name = request.getParameter("company_name");

		String company_package = request.getParameter("company_package");

		String location = request.getParameter("location");

		String criteria = request.getParameter("criteria");

		// Object

		Company c = new Company();

		c.setCompany_name(company_name);

		c.setCompany_package(company_package);

		c.setLocation(location);

		c.setCriteria(criteria);

		// Service

		CompanyService service = new CompanyServiceImpl();

		boolean status = service.addCompany(c);

		// Response UI

		out.println("<html>");

		out.println("<head>");

		out.println("<title>Add Company</title>");

		out.println(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");

		out.println("<style>");

		out.println("body{");
		out.println("background:#f1f5f9;");
		out.println("font-family:Arial;");
		out.println("padding:30px;");
		out.println("}");

		out.println(".result-box{");
		out.println("max-width:500px;");
		out.println("margin:auto;");
		out.println("margin-top:100px;");
		out.println("background:white;");
		out.println("padding:40px;");
		out.println("border-radius:20px;");
		out.println("box-shadow:0px 4px 20px rgba(0,0,0,0.08);");
		out.println("text-align:center;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='result-box'>");

		if (status) {

			out.println("<h2 class='text-success mb-4'>");

			out.println("Company Added Successfully");

			out.println("</h2>");

			out.println("<a href='ViewCompanyServlet' class='btn btn-primary me-2'>");

			out.println("View Companies");

			out.println("</a>");

			out.println("<a href='admin/AddCompany.html' class='btn btn-success'>");

			out.println("Add More");

			out.println("</a>");

		} else {

			out.println("<h2 class='text-danger mb-4'>");

			out.println("Company Not Added");

			out.println("</h2>");

			out.println("<a href='admin/AddCompany.html' class='btn btn-primary'>");

			out.println("Try Again");

			out.println("</a>");
		}

		out.println("</div>");

		out.println("</body>");

		out.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}