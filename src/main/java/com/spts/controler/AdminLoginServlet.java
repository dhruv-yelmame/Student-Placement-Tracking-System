package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");

		String password = request.getParameter("password");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/placement_tracking_system",
					"root",
					"8010865586");

			PreparedStatement pstmt = conn.prepareStatement(
					"select * from admins where username=? and password=?");

			pstmt.setString(1, username);

			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				HttpSession session = request.getSession();

				session.setAttribute("admin", username);

				response.sendRedirect("admin/AdminDashboard.html");

			}

			else {

				response.getWriter().println(
						"<h2>Invalid Username or Password</h2>");
			}

			conn.close();

		}

		catch (Exception e) {

			response.getWriter().println(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}