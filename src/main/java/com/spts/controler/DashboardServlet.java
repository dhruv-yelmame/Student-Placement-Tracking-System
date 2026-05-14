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

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Session Check

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("admin") == null) {

			response.sendRedirect("admin/AdminLogin.html");

			return;
		}

		// Prevent Browser Cache

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		response.setHeader("Pragma", "no-cache");

		response.setDateHeader("Expires", 0);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int totalStudents = 0;

		int totalCompanies = 0;

		int totalPlacements = 0;

		int totalRejected = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement_tracking_system",
					"root", "8010865586");

			// Total Students

			PreparedStatement pstmt1 = conn.prepareStatement("select count(*) from students");

			ResultSet rs1 = pstmt1.executeQuery();

			if (rs1.next()) {

				totalStudents = rs1.getInt(1);
			}

			// Total Companies

			PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from companies");

			ResultSet rs2 = pstmt2.executeQuery();

			if (rs2.next()) {

				totalCompanies = rs2.getInt(1);
			}

			// Total Placements

			PreparedStatement pstmt3 = conn.prepareStatement("select count(*) from placements where status='Selected'");

			ResultSet rs3 = pstmt3.executeQuery();

			if (rs3.next()) {

				totalPlacements = rs3.getInt(1);
			}

			// Total Rejected

			PreparedStatement pstmt4 = conn.prepareStatement("select count(*) from placements where status='Rejected'");

			ResultSet rs4 = pstmt4.executeQuery();

			if (rs4.next()) {

				totalRejected = rs4.getInt(1);
			}

			conn.close();

		}

		catch (Exception e) {

			out.println(e);
		}

		// HTML

		out.println("<html>");

		out.println("<head>");

		out.println("<title>Dashboard</title>");

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
		out.println("background:#f1f5f9;");
		out.println("padding:30px;");
		out.println("font-family:Arial;");
		out.println("}");

		out.println(".dashboard-title{");
		out.println("font-size:35px;");
		out.println("font-weight:bold;");
		out.println("margin-bottom:30px;");
		out.println("color:#1E293B;");
		out.println("}");

		out.println(".card-box{");
		out.println("background:white;");
		out.println("padding:30px;");
		out.println("border-radius:20px;");
		out.println("box-shadow:0px 4px 20px rgba(0,0,0,0.08);");
		out.println("transition:0.3s;");
		out.println("text-align:center;");
		out.println("}");

		out.println(".card-box:hover{");
		out.println("transform:translateY(-5px);");
		out.println("}");

		out.println(".card-icon{");
		out.println("font-size:45px;");
		out.println("margin-bottom:15px;");
		out.println("}");

		out.println(".students{");
		out.println("color:#2563EB;");
		out.println("}");

		out.println(".companies{");
		out.println("color:#16A34A;");
		out.println("}");

		out.println(".placements{");
		out.println("color:#9333EA;");
		out.println("}");

		out.println(".rejected{");
		out.println("color:#DC2626;");
		out.println("}");

		out.println(".card-box h4{");
		out.println("font-size:22px;");
		out.println("margin-bottom:10px;");
		out.println("}");

		out.println(".card-box h1{");
		out.println("font-size:45px;");
		out.println("font-weight:bold;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='dashboard-title'>");

		out.println("<i class='bi bi-speedometer2'></i> ");

		out.println("Admin Dashboard");

		out.println("</div>");

		out.println("<div class='row g-4'>");

		// Students Card

		out.println("<div class='col-md-3'>");

		out.println("<div class='card-box'>");

		out.println("<div class='card-icon students'>");

		out.println("<i class='bi bi-people-fill'></i>");

		out.println("</div>");

		out.println("<h4>Total Students</h4>");

		out.println("<h1>");

		out.println(totalStudents);

		out.println("</h1>");

		out.println("</div>");

		out.println("</div>");

		// Companies Card

		out.println("<div class='col-md-3'>");

		out.println("<div class='card-box'>");

		out.println("<div class='card-icon companies'>");

		out.println("<i class='bi bi-buildings'></i>");

		out.println("</div>");

		out.println("<h4>Total Companies</h4>");

		out.println("<h1>");

		out.println(totalCompanies);

		out.println("</h1>");

		out.println("</div>");

		out.println("</div>");

		// Placements Card

		out.println("<div class='col-md-3'>");

		out.println("<div class='card-box'>");

		out.println("<div class='card-icon placements'>");

		out.println("<i class='bi bi-briefcase-fill'></i>");

		out.println("</div>");

		out.println("<h4>Placements</h4>");

		out.println("<h1>");

		out.println(totalPlacements);

		out.println("</h1>");

		out.println("</div>");

		out.println("</div>");

		// Rejected Card

		out.println("<div class='col-md-3'>");

		out.println("<div class='card-box'>");

		out.println("<div class='card-icon rejected'>");

		out.println("<i class='bi bi-x-circle-fill'></i>");

		out.println("</div>");

		out.println("<h4>Rejected</h4>");

		out.println("<h1>");

		out.println(totalRejected);

		out.println("</h1>");

		out.println("</div>");

		out.println("</div>");

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