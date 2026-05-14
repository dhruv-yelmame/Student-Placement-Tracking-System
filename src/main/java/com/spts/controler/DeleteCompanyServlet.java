package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.spts.service.CompanyService;
import com.spts.service.CompanyServiceImpl;

@WebServlet("/DeleteCompanyServlet")
public class DeleteCompanyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String admin = (String) session.getAttribute("admin");

		// Admin Not Logged In

		if (admin == null) {

			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin.html");

			return;
		}

		int cid = Integer.parseInt(request.getParameter("cid"));

		CompanyService service = new CompanyServiceImpl();

		boolean status = service.deleteCompany(cid);

		if (status) {

			response.sendRedirect("ViewCompanyServlet");

		} else {

			response.getWriter().println(

					"<h2>Company Not Deleted</h2>"

			);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}