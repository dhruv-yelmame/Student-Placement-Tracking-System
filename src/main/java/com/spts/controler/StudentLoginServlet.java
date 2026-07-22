package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement_tracking_system",
					"root", "8010865586");

			PreparedStatement pstmt = conn.prepareStatement("select * from students " + "where email=? and password=?");

			pstmt.setString(1, email);

			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				// Create Session

				HttpSession session = request.getSession();

				// Session Timeout

				session.setMaxInactiveInterval(30 * 60);

				// Store Session Data

				session.setAttribute("sid", rs.getInt("sid"));

				session.setAttribute("student", rs.getString("name"));

				session.setAttribute("email", rs.getString("email"));

				// Redirect Dashboard

				response.sendRedirect(request.getContextPath() + "/student/StudentDashboard.jsp");
			}

			else {

				out.println("<html>");

				out.println("<head>");

				out.println("<title>");

				out.println("Login Failed");

				out.println("</title>");

				out.println("<link " + "href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' "
						+ "rel='stylesheet'>");

				out.println("<style>");

				out.println("body{");

				out.println("background:#EEF2FF;");

				out.println("display:flex;");

				out.println("justify-content:center;");

				out.println("align-items:center;");

				out.println("height:100vh;");

				out.println("font-family:Arial;");

				out.println("}");

				out.println(".error-box{");

				out.println("background:white;");

				out.println("padding:40px;");

				out.println("border-radius:20px;");

				out.println("box-shadow:0px 5px 20px rgba(0,0,0,0.08);");

				out.println("text-align:center;");

				out.println("}");

				out.println("</style>");

				out.println("</head>");

				out.println("<body>");

				out.println("<div class='error-box'>");

				out.println("<h2 class='text-danger'>");

				out.println("Invalid Email or Password");

				out.println("</h2>");

				out.println("<a href='" + request.getContextPath() + "/student/StudentLogin.jsp' "
						+ "class='btn btn-primary mt-3'>");

				out.println("Back to Login");

				out.println("</a>");

				out.println("</div>");

				out.println("</body>");

				out.println("</html>");
			}

			conn.close();
		}

		catch (Exception e) {

			out.println(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}