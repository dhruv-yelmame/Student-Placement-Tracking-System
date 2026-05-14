package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.spts.model.Placement;
import com.spts.service.PlacementService;
import com.spts.service.PlacementServiceImpl;

@WebServlet("/ViewPlacementServlet")
public class ViewPlacementServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		PlacementService service = new PlacementServiceImpl();

		List<Placement> list = service.getAllPlacements();

		out.println("<!DOCTYPE html>");

		out.println("<html>");

		out.println("<head>");

		out.println("<title>");

		out.println("Placements");

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

		out.println(".student-name{");

		out.println("color:#1E3A8A;");

		out.println("}");

		out.println(".company-name{");

		out.println("color:#16A34A;");

		out.println("}");

		out.println(".action-btn{");

		out.println("padding:7px 14px;");

		out.println("border-radius:10px;");

		out.println("font-size:14px;");

		out.println("font-weight:bold;");

		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='table-box'>");

		out.println("<div class='title'>");

		out.println("<i class='bi bi-briefcase-fill'></i> ");

		out.println("Placement Records");

		out.println("</div>");

		out.println("<table class='table table-hover table-bordered'>");

		out.println("<tr>");

		out.println("<th>PID</th>");

		out.println("<th>Student Name</th>");

		out.println("<th>Company Name</th>");

		out.println("<th>Apply Date</th>");

		out.println("<th>Status</th>");

		out.println("<th>Action</th>");

		out.println("</tr>");

		for (Placement p : list) {

			out.println("<tr>");

			out.println("<td>");

			out.println(p.getPid());

			out.println("</td>");

			out.println("<td class='student-name'>");

			out.println(p.getStudentName());

			out.println("</td>");

			out.println("<td class='company-name'>");

			out.println(p.getCompanyName());

			out.println("</td>");

			out.println("<td>");

			out.println(p.getApply_date());

			out.println("</td>");

			out.println("<td>");

			if (p.getStatus().equals("Selected")) {

				out.println("<span class='badge bg-success'>Selected</span>");
			}

			else if (p.getStatus().equals("Rejected")) {

				out.println("<span class='badge bg-danger'>Rejected</span>");
			}

			else {

				out.println("<span class='badge bg-warning text-dark'>Applied</span>");
			}

			out.println("</td>");

			out.println("<td>");

			out.println("<a href='UpdatePlacementServlet?pid=" + p.getPid() + "&status=Selected' "
					+ "class='btn btn-success action-btn me-2'>");

			out.println("<i class='bi bi-check-circle-fill'></i> Select");

			out.println("</a>");

			out.println("<a href='UpdatePlacementServlet?pid=" + p.getPid() + "&status=Rejected' "
					+ "class='btn btn-danger action-btn'>");

			out.println("<i class='bi bi-x-circle-fill'></i> Reject");

			out.println("</a>");

			out.println("</td>");

			out.println("</tr>");
		}

		out.println("</table>");

		out.println("</div>");

		out.println("</body>");

		out.println("</html>");
	}
}