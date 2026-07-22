package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import com.spts.service.PlacementService;
import com.spts.service.PlacementServiceImpl;

@WebServlet("/StudentPlacementStatusServlet")
public class StudentPlacementStatusServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		Integer sid = (Integer) session.getAttribute("sid");

		if (sid == null) {

			response.sendRedirect(

					request.getContextPath() + "/student/StudentLogin.jsp");

			return;
		}

		PlacementService service = new PlacementServiceImpl();

		List<Object[]> list = service.getStudentPlacements(sid);

		out.println("<html>");

		out.println("<head>");

		out.println("<title>");
		out.println("Placement Status");
		out.println("</title>");

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

		out.println(".table th{");
		out.println("background:#2563EB;");
		out.println("color:white;");
		out.println("text-align:center;");
		out.println("}");

		out.println(".table td{");
		out.println("text-align:center;");
		out.println("vertical-align:middle;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='table-box'>");

		out.println("<div class='title'>");

		out.println("<i class='bi bi-briefcase-fill'></i> ");

		out.println("Placement Status");

		out.println("</div>");

		out.println("<table class='table table-bordered table-hover'>");

		out.println("<tr>");

		out.println("<th>PID</th>");

		out.println("<th>Company Name</th>");

		out.println("<th>Package</th>");

		out.println("<th>Apply Date</th>");

		out.println("<th>Status</th>");

		out.println("</tr>");

		for (Object[] obj : list) {

			out.println("<tr>");

			out.println("<td>");
			out.println(obj[0]);
			out.println("</td>");

			out.println("<td>");
			out.println(obj[1]);
			out.println("</td>");

			out.println("<td>");
			out.println(obj[2]);
			out.println(" LPA");
			out.println("</td>");

			out.println("<td>");
			out.println(obj[3]);
			out.println("</td>");

			out.println("<td>");

			String status = obj[4].toString();

			if (status.equals("Selected")) {

				out.println("<span class='badge bg-success'>" + "Selected" + "</span>");

			}

			else if (status.equals("Rejected")) {

				out.println("<span class='badge bg-danger'>" + "Rejected" + "</span>");
			}

			else {

				out.println("<span class='badge bg-warning text-dark'>" + "Applied" + "</span>");
			}

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