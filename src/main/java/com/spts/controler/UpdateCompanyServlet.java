package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.model.Company;

import com.spts.service.CompanyService;
import com.spts.service.CompanyServiceImpl;

@WebServlet("/UpdateCompanyServlet")
public class UpdateCompanyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int cid = Integer.parseInt(request.getParameter("cid"));

		CompanyService service = new CompanyServiceImpl();

		Company c = service.getCompanyById(cid);

		out.println("<html>");

		out.println("<head>");

		out.println("<title>");
		out.println("Update Company");
		out.println("</title>");

		out.println(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");

		out.println("<style>");

		out.println("body{");
		out.println("background:#EEF2FF;");
		out.println("font-family:Arial;");
		out.println("padding:40px;");
		out.println("}");

		out.println(".form-box{");
		out.println("background:white;");
		out.println("padding:35px;");
		out.println("border-radius:20px;");
		out.println("max-width:600px;");
		out.println("margin:auto;");
		out.println("box-shadow:0px 5px 20px rgba(0,0,0,0.08);");
		out.println("}");

		out.println(".title{");
		out.println("font-size:30px;");
		out.println("font-weight:bold;");
		out.println("margin-bottom:25px;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='form-box'>");

		out.println("<div class='title'>");

		out.println("Update Company");

		out.println("</div>");

		out.println("<form action='UpdateCompanyServlet' method='post'>");

		out.println(

				"<input type='hidden' " + "name='cid' " + "value='" + c.getCid() + "'>"

		);

		out.println("<div class='mb-3'>");

		out.println("<label>Company Name</label>");

		out.println(

				"<input type='text' " + "name='company_name' " + "class='form-control' " + "value='"
						+ c.getCompany_name() + "' " + "required>"

		);

		out.println("</div>");

		out.println("<div class='mb-3'>");

		out.println("<label>Package</label>");

		out.println(

				"<input type='text' " + "name='company_package' " + "class='form-control' " + "value='"
						+ c.getCompany_package() + "' " + "required>"

		);

		out.println("</div>");

		out.println("<div class='mb-3'>");

		out.println("<label>Location</label>");

		out.println(

				"<input type='text' " + "name='location' " + "class='form-control' " + "value='" + c.getLocation()
						+ "' " + "required>"

		);

		out.println("</div>");

		out.println("<div class='mb-3'>");

		out.println("<label>Criteria</label>");

		out.println(

				"<input type='text' " + "name='criteria' " + "class='form-control' " + "value='" + c.getCriteria()
						+ "' " + "required>"

		);

		out.println("</div>");

		out.println(

				"<button type='submit' " + "class='btn btn-primary w-100'>" + "Update Company" + "</button>"

		);

		out.println("</form>");

		out.println("</div>");

		out.println("</body>");

		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cid = Integer.parseInt(request.getParameter("cid"));

		String company_name = request.getParameter("company_name");

		String company_package = request.getParameter("company_package");

		String location = request.getParameter("location");

		String criteria = request.getParameter("criteria");

		Company c = new Company();

		c.setCid(cid);

		c.setCompany_name(company_name);

		c.setCompany_package(company_package);

		c.setLocation(location);

		c.setCriteria(criteria);

		CompanyService service = new CompanyServiceImpl();

		boolean status = service.updateCompany(c);

		if (status) {

			response.sendRedirect("ViewCompanyServlet");
		}

		else {

			response.getWriter().println(

					"<h2>" + "Company Not Updated" + "</h2>"

			);
		}
	}
}