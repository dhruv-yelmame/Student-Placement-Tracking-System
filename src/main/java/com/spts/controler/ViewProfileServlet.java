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

@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		Integer sid = (Integer) session.getAttribute("sid");

		if (sid == null) {

			response.sendRedirect(request.getContextPath() + "/student/StudentLogin.jsp");

			return;
		}

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement_tracking_system",
					"root", "8010865586");

			PreparedStatement pstmt = conn.prepareStatement("select * from students where sid=?");

			pstmt.setInt(1, sid);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				out.println("<!DOCTYPE html>");

				out.println("<html>");

				out.println("<head>");

				out.println("<title>");

				out.println("Student Profile");

				out.println("</title>");

				out.println(
						"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

				out.println(
						"<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css'>");

				out.println("<style>");

				out.println("*{");

				out.println("margin:0;");

				out.println("padding:0;");

				out.println("box-sizing:border-box;");

				out.println("}");

				out.println("body{");

				out.println("background:#EEF2FF;");

				out.println("font-family:Arial,sans-serif;");

				out.println("height:100vh;");

				out.println("display:flex;");

				out.println("justify-content:center;");

				out.println("align-items:center;");

				out.println("padding:15px;");

				out.println("overflow:hidden;");

				out.println("}");

				out.println(".profile-box{");

				out.println("width:100%;");

				out.println("max-width:650px;");

				out.println("background:white;");

				out.println("padding:25px;");

				out.println("border-radius:20px;");

				out.println("box-shadow:0px 5px 20px rgba(0,0,0,0.08);");

				out.println("}");

				out.println(".profile-header{");

				out.println("text-align:center;");

				out.println("margin-bottom:20px;");

				out.println("}");

				out.println(".profile-header i{");

				out.println("font-size:70px;");

				out.println("color:#2563EB;");

				out.println("}");

				out.println(".profile-header h1{");

				out.println("margin-top:10px;");

				out.println("font-size:28px;");

				out.println("color:#111827;");

				out.println("}");

				out.println(".profile-header p{");

				out.println("color:#6B7280;");

				out.println("margin-top:5px;");

				out.println("font-size:14px;");

				out.println("}");

				out.println(".table{");

				out.println("margin-bottom:15px;");

				out.println("}");

				out.println(".table th{");

				out.println("width:35%;");

				out.println("background:#F8FAFC;");

				out.println("padding:10px;");

				out.println("font-size:14px;");

				out.println("}");

				out.println(".table td{");

				out.println("padding:10px;");

				out.println("font-size:14px;");

				out.println("}");

				out.println(".btn-box{");

				out.println("margin-top:15px;");

				out.println("display:flex;");

				out.println("justify-content:center;");

				out.println("}");

				out.println(".btn-update{");

				out.println("background:#2563EB;");

				out.println("color:white;");

				out.println("padding:10px 20px;");

				out.println("border-radius:10px;");

				out.println("text-decoration:none;");

				out.println("font-weight:bold;");

				out.println("font-size:14px;");

				out.println("transition:0.3s;");

				out.println("}");

				out.println(".btn-update:hover{");

				out.println("background:#1D4ED8;");

				out.println("}");

				out.println("</style>");

				out.println("</head>");

				out.println("<body>");

				out.println("<div class='profile-box'>");

				out.println("<div class='profile-header'>");

				out.println("<i class='bi bi-person-circle'></i>");

				out.println("<h1>");

				out.println(rs.getString("name"));

				out.println("</h1>");

				out.println("<p>");

				out.println("Student Placement Profile");

				out.println("</p>");

				out.println("</div>");

				out.println("<table class='table table-bordered'>");

				out.println("<tr>");

				out.println("<th>ID</th>");

				out.println("<td>" + rs.getInt("sid") + "</td>");

				out.println("</tr>");

				out.println("<tr>");

				out.println("<th>Name</th>");

				out.println("<td>" + rs.getString("name") + "</td>");

				out.println("</tr>");

				out.println("<tr>");

				out.println("<th>Email</th>");

				out.println("<td>" + rs.getString("email") + "</td>");

				out.println("</tr>");

				out.println("<tr>");

				out.println("<th>Mobile</th>");

				out.println("<td>" + rs.getString("mobile") + "</td>");

				out.println("</tr>");

				out.println("<tr>");

				out.println("<th>Course</th>");

				out.println("<td>" + rs.getString("course") + "</td>");

				out.println("</tr>");

				out.println("<tr>");

				out.println("<th>Percentage</th>");

				out.println("<td>" + rs.getDouble("percentage") + "%</td>");

				out.println("</tr>");

				out.println("<tr>");

				out.println("<th>Skills</th>");

				out.println("<td>" + rs.getString("skills") + "</td>");

				out.println("</tr>");

				out.println("</table>");

				out.println("<div class='btn-box'>");

				out.println("<a href='UpdateProfileServlet' " + "class='btn-update'>");

				out.println("<i class='bi bi-pencil-square'></i> ");

				out.println("Update Profile");

				out.println("</a>");

				out.println("</div>");

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}