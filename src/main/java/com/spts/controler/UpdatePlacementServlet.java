package com.spts.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.spts.service.PlacementService;
import com.spts.service.PlacementServiceImpl;

@WebServlet("/UpdatePlacementServlet")
public class UpdatePlacementServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));

		String status = request.getParameter("status");

		PlacementService service = new PlacementServiceImpl();

		service.updatePlacementStatus(pid, status);

		response.sendRedirect("ViewPlacementServlet");
	}
}