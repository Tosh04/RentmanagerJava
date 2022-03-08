package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/cars/create")

public class VehicleCreateServlet extends HttpServlet{

	public VehicleCreateServlet() {}
	
	@Autowired
	VehicleService vehicleService;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/vehicles/create.jsp");
		dispatcher.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		String constructeur;
		int nb_places;
		
		constructeur = request.getParameter("manufacturer");
		nb_places = Integer.parseInt(request.getParameter("seats"));
		
		
		Vehicle vehicle = new Vehicle(constructeur, nb_places);
		
		try {
			vehicleService.create(vehicle);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		responce.sendRedirect("http://localhost:8080/rentmanager/cars");
		
	}
}
