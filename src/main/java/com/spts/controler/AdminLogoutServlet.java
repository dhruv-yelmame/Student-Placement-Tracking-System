package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/AdminLogoutServlet")
public class AdminLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null) {

			session.invalidate();
		}

		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate");

		response.setHeader("Pragma", "no-cache");

		response.setDateHeader("Expires", 0);

		response.sendRedirect("admin/AdminLogin.html");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}