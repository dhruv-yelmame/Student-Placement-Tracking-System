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

@WebServlet("/StudentDashboardServlet")
public class StudentDashboardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		// Existing Session

		HttpSession session = request.getSession(false);

		// Session Validation

		if (session == null || session.getAttribute("sid") == null) {

			response.sendRedirect(request.getContextPath() + "/student/StudentLogin.jsp");

			return;
		}

		// Prevent Browser Cache

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		response.setHeader("Pragma", "no-cache");

		response.setDateHeader("Expires", 0);

		String student = (String) session.getAttribute("student");

		Integer sid = (Integer) session.getAttribute("sid");

		int totalCompanies = 0;

		int totalApplied = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement_tracking_system",
					"root", "8010865586");

			// Total Companies

			PreparedStatement pstmt1 = conn.prepareStatement("select count(*) from companies");

			ResultSet rs1 = pstmt1.executeQuery();

			if (rs1.next()) {

				totalCompanies = rs1.getInt(1);
			}

			// Applied Companies

			PreparedStatement pstmt2 = conn.prepareStatement("select count(*) " + "from placements " + "where sid=?");

			pstmt2.setInt(1, sid);

			ResultSet rs2 = pstmt2.executeQuery();

			if (rs2.next()) {

				totalApplied = rs2.getInt(1);
			}

			out.println("<!DOCTYPE html>");

			out.println("<html lang='en'>");

			out.println("<head>");

			out.println("<meta charset='UTF-8'>");

			out.println("<meta name='viewport' " + "content='width=device-width, initial-scale=1.0'>");

			out.println("<title>");

			out.println("Student Dashboard");

			out.println("</title>");

			out.println("<link " + "href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' "
					+ "rel='stylesheet'>");

			out.println("<link rel='stylesheet' "
					+ "href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css'>");

			out.println("<style>");

			out.println("*{");

			out.println("margin:0;");

			out.println("padding:0;");

			out.println("box-sizing:border-box;");

			out.println("}");

			out.println("body{");

			out.println("background:#EEF2FF;");

			out.println("font-family:Arial,sans-serif;");

			out.println("padding:30px;");

			out.println("}");

			out.println(".dashboard-box{");

			out.println("background:white;");

			out.println("padding:40px;");

			out.println("border-radius:25px;");

			out.println("box-shadow:0px 5px 25px rgba(0,0,0,0.08);");

			out.println("}");

			out.println(".topbar{");

			out.println("display:flex;");

			out.println("justify-content:space-between;");

			out.println("align-items:center;");

			out.println("margin-bottom:35px;");

			out.println("}");

			out.println(".title h1{");

			out.println("font-size:38px;");

			out.println("font-weight:bold;");

			out.println("color:#111827;");

			out.println("}");

			out.println(".title p{");

			out.println("font-size:18px;");

			out.println("color:#6B7280;");

			out.println("margin-top:8px;");

			out.println("}");

			out.println(".profile{");

			out.println("display:flex;");

			out.println("align-items:center;");

			out.println("gap:12px;");

			out.println("font-size:20px;");

			out.println("font-weight:bold;");

			out.println("color:#111827;");

			out.println("}");

			out.println(".profile i{");

			out.println("font-size:42px;");

			out.println("color:#2563EB;");

			out.println("}");

			out.println(".cards{");

			out.println("display:grid;");

			out.println("grid-template-columns:" + "repeat(auto-fit,minmax(260px,1fr));");

			out.println("gap:25px;");

			out.println("}");

			out.println(".card-box{");

			out.println("padding:30px;");

			out.println("border-radius:22px;");

			out.println("color:white;");

			out.println("box-shadow:0px 5px 15px rgba(0,0,0,0.08);");

			out.println("}");

			out.println(".card1{");

			out.println("background:linear-gradient(135deg,#2563EB,#1D4ED8);");

			out.println("}");

			out.println(".card2{");

			out.println("background:linear-gradient(135deg,#059669,#047857);");

			out.println("}");

			out.println(".card-box i{");

			out.println("font-size:50px;");

			out.println("}");

			out.println(".card-box h2{");

			out.println("margin-top:18px;");

			out.println("font-size:40px;");

			out.println("font-weight:bold;");

			out.println("}");

			out.println(".card-box p{");

			out.println("margin-top:10px;");

			out.println("font-size:18px;");

			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='dashboard-box'>");

			// Topbar

			out.println("<div class='topbar'>");

			out.println("<div class='title'>");

			out.println("<h1>");

			out.println("Student Dashboard");

			out.println("</h1>");

			out.println("<p>");

			out.println("Student Placement Tracking System");

			out.println("</p>");

			out.println("</div>");

			out.println("<div class='profile'>");

			out.println("<i class='bi bi-person-circle'></i>");

			out.println(student);

			out.println("</div>");

			out.println("</div>");

			// Cards

			out.println("<div class='cards'>");

			// Total Companies

			out.println("<div class='card-box card1'>");

			out.println("<i class='bi bi-buildings-fill'></i>");

			out.println("<h2>");

			out.println(totalCompanies);

			out.println("</h2>");

			out.println("<p>");

			out.println("Total Companies");

			out.println("</p>");

			out.println("</div>");

			// Applied Companies

			out.println("<div class='card-box card2'>");

			out.println("<i class='bi bi-send-check-fill'></i>");

			out.println("<h2>");

			out.println(totalApplied);

			out.println("</h2>");

			out.println("<p>");

			out.println("Applied Companies");

			out.println("</p>");

			out.println("</div>");

			out.println("</div>");

			out.println("</div>");

			out.println("</body>");

			out.println("</html>");

			conn.close();
		}

		catch (Exception e) {

			out.println(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}