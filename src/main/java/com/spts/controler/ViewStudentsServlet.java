package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.spts.model.Student;
import com.spts.service.StudentService;
import com.spts.service.StudentServiceImpl;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String admin = null;

		if (session != null) {

			admin = (String) session.getAttribute("admin");
		}

		if (admin == null) {

			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin.html");

			return;
		}

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		response.setHeader("Pragma", "no-cache");

		response.setDateHeader("Expires", 0);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		StudentService service = new StudentServiceImpl();

		List<Student> list = service.getAllStudents();

		out.println("<!DOCTYPE html>");

		out.println("<html>");

		out.println("<head>");

		out.println("<title>Students</title>");

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
		out.println("background:#EEF2FF;");
		out.println("padding:30px;");
		out.println("font-family:Arial;");
		out.println("}");

		out.println(".table-box{");
		out.println("background:white;");
		out.println("padding:30px;");
		out.println("border-radius:20px;");
		out.println("box-shadow:0px 5px 20px rgba(0,0,0,0.08);");
		out.println("}");

		out.println(".title{");
		out.println("font-size:32px;");
		out.println("font-weight:bold;");
		out.println("margin-bottom:25px;");
		out.println("color:#1E293B;");
		out.println("}");

		out.println(".table{");
		out.println("border-radius:15px;");
		out.println("overflow:hidden;");
		out.println("}");

		out.println(".table th{");
		out.println("background:#2563EB;");
		out.println("color:white;");
		out.println("padding:15px;");
		out.println("text-align:center;");
		out.println("}");

		out.println(".table td{");
		out.println("padding:15px;");
		out.println("vertical-align:middle;");
		out.println("text-align:center;");
		out.println("}");

		out.println(".badge-skill{");
		out.println("background:#E0E7FF;");
		out.println("color:#3730A3;");
		out.println("padding:6px 12px;");
		out.println("border-radius:20px;");
		out.println("font-size:13px;");
		out.println("font-weight:bold;");
		out.println("}");

		out.println(".percentage{");
		out.println("color:#16A34A;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='table-box'>");

		out.println("<div class='title'>");
		out.println("<i class='bi bi-people-fill'></i> ");
		out.println("Student Records");
		out.println("</div>");

		out.println("<table class='table table-hover table-bordered'>");

		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Mobile</th>");
		out.println("<th>Course</th>");
		out.println("<th>Percentage</th>");
		out.println("<th>Skills</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");

		for (Student s : list) {

			out.println("<tr>");

			out.println("<td>" + s.getSid() + "</td>");

			out.println("<td>" + s.getName() + "</td>");

			out.println("<td>" + s.getEmail() + "</td>");

			out.println("<td>" + s.getMobile() + "</td>");

			out.println("<td>" + s.getCourse() + "</td>");

			out.println("<td class='percentage'>" + s.getPercentage() + "%</td>");

			out.println("<td>");
			out.println("<span class='badge-skill'>" + s.getSkills() + "</span>");
			out.println("</td>");

			out.println("<td>");
			
			out.println("<a href='DeleteStudentServlet?sid=" + s.getSid()
			+ "' class='btn btn-danger btn-sm'>");

			out.println("<i class='bi bi-trash-fill'></i> Delete");

			out.println("</a>");

			out.println("</td>");

			out.println("</tr>");
		}

		out.println("</table>");

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