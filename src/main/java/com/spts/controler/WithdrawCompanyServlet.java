package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.spts.service.PlacementService;
import com.spts.service.PlacementServiceImpl;

@WebServlet("/WithdrawCompanyServlet")
public class WithdrawCompanyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Integer sid = (Integer) session.getAttribute("sid");

		if (sid == null) {

			response.sendRedirect(request.getContextPath() + "/student/StudentLogin.html");

			return;
		}

		int cid = Integer.parseInt(request.getParameter("cid"));

		PlacementService service = new PlacementServiceImpl();

		service.withdrawCompany(sid, cid);

		response.sendRedirect("ViewCompanyServlet");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}