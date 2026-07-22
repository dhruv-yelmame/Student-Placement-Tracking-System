package com.spts.controler;

import java.io.IOException;

import com.spts.model.Company;
import com.spts.service.CompanyService;
import com.spts.service.CompanyServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddCompanyServlet")
public class AddCompanyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession(false);

		if(session==null || session.getAttribute("admin")==null){

			response.sendRedirect(request.getContextPath()
					+"/admin/AdminLogin.jsp");

			return;
		}

		Company c=new Company();

		c.setCompany_name(request.getParameter("company_name"));
		c.setCompany_package(request.getParameter("company_package"));
		c.setLocation(request.getParameter("location"));
		c.setCriteria(request.getParameter("criteria"));

		CompanyService service=new CompanyServiceImpl();

		boolean status=service.addCompany(c);

		if(status){

			response.sendRedirect(request.getContextPath()
					+"/ViewCompanyServlet");

		}else{

			response.sendRedirect(request.getContextPath()
					+"/admin/AddCompany.jsp");

		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);

	}
}