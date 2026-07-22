package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.spts.model.Student;
import com.spts.service.StudentService;
import com.spts.service.StudentServiceImpl;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {

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

		StudentService service = new StudentServiceImpl();

		Student s = service.getStudentProfile(sid);

		out.println("<!DOCTYPE html>");

		out.println("<html>");

		out.println("<head>");

		out.println("<title>");

		out.println("Update Profile");

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

		out.println("font-family:Arial;");

		out.println("height:100vh;");

		out.println("display:flex;");

		out.println("justify-content:center;");

		out.println("align-items:center;");

		out.println("padding:10px;");

		out.println("overflow:hidden;");

		out.println("}");

		out.println(".form-box{");

		out.println("width:100%;");

		out.println("max-width:580px;");

		out.println("background:white;");

		out.println("padding:22px;");

		out.println("border-radius:20px;");

		out.println("box-shadow:0px 5px 20px rgba(0,0,0,0.08);");

		out.println("}");

		out.println(".title{");

		out.println("font-size:26px;");

		out.println("font-weight:bold;");

		out.println("margin-bottom:18px;");

		out.println("color:#1E293B;");

		out.println("text-align:center;");

		out.println("}");

		out.println(".title i{");

		out.println("color:#2563EB;");

		out.println("margin-right:8px;");

		out.println("}");

		out.println(".form-label{");

		out.println("font-size:14px;");

		out.println("font-weight:bold;");

		out.println("margin-bottom:5px;");

		out.println("color:#374151;");

		out.println("}");

		out.println(".form-control{");

		out.println("height:40px;");

		out.println("border-radius:10px;");

		out.println("margin-bottom:10px;");

		out.println("font-size:14px;");

		out.println("}");

		out.println(".form-control:focus{");

		out.println("box-shadow:none;");

		out.println("border:2px solid #2563EB;");

		out.println("}");

		out.println(".btn-update{");

		out.println("width:100%;");

		out.println("height:42px;");

		out.println("background:#2563EB;");

		out.println("color:white;");

		out.println("border:none;");

		out.println("border-radius:10px;");

		out.println("font-size:15px;");

		out.println("font-weight:bold;");

		out.println("transition:0.3s;");

		out.println("}");

		out.println(".btn-update:hover{");

		out.println("background:#1D4ED8;");

		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='form-box'>");

		out.println("<div class='title'>");

		out.println("<i class='bi bi-person-fill-gear'></i>");

		out.println("Update Profile");

		out.println("</div>");

		out.println("<form method='post'>");

		out.println("<input type='hidden' " + "name='sid' " + "value='" + s.getSid() + "'>");

		out.println("<label class='form-label'>Name</label>");

		out.println("<input type='text' " + "name='name' " + "class='form-control' " + "value='" + s.getName() + "'>");

		out.println("<label class='form-label'>Email</label>");

		out.println(
				"<input type='email' " + "name='email' " + "class='form-control' " + "value='" + s.getEmail() + "'>");

		out.println("<label class='form-label'>Mobile</label>");

		out.println(
				"<input type='text' " + "name='mobile' " + "class='form-control' " + "value='" + s.getMobile() + "'>");

		out.println("<label class='form-label'>Course</label>");

		out.println(
				"<input type='text' " + "name='course' " + "class='form-control' " + "value='" + s.getCourse() + "'>");

		out.println("<label class='form-label'>Percentage</label>");

		out.println("<input type='text' " + "name='percentage' " + "class='form-control' " + "value='"
				+ s.getPercentage() + "'>");

		out.println("<label class='form-label'>Skills</label>");

		out.println(
				"<input type='text' " + "name='skills' " + "class='form-control' " + "value='" + s.getSkills() + "'>");

		out.println("<button type='submit' " + "class='btn-update'>");

		out.println("<i class='bi bi-check-circle-fill'></i> ");

		out.println("Update Profile");

		out.println("</button>");

		out.println("</form>");

		out.println("</div>");

		out.println("</body>");

		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student s = new Student();

		s.setSid(Integer.parseInt(request.getParameter("sid")));

		s.setName(request.getParameter("name"));

		s.setEmail(request.getParameter("email"));

		s.setMobile(request.getParameter("mobile"));

		s.setCourse(request.getParameter("course"));

		s.setPercentage(Double.parseDouble(request.getParameter("percentage")));

		s.setSkills(request.getParameter("skills"));

		StudentService service = new StudentServiceImpl();

		boolean status = service.updateProfile(s);

		if (status) {

			response.sendRedirect("ViewProfileServlet");
		}

		else {

			response.getWriter().println("Profile Not Updated");
		}
	}
}