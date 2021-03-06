package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/users/details")

public class UserDetailServlet extends HttpServlet {

	public UserDetailServlet() {
	}

	@Autowired
	VehicleService vehicleService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	ClientService clientService;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<Reservation> listRents = new ArrayList<>();
		List<Vehicle> listVehicle = new ArrayList<>();

		Client client = new Client();

		try {
			client = clientService.findById(id);
			listRents = reservationService.findResaByClientId(id);

			for (int i = 0; i < listRents.size(); i++) {
				listVehicle.add(vehicleService.findById(listRents.get(i).getVehicle_id()));
			}
			int nbRents = listRents.size();
			int nbVehicle = listVehicle.size();
			
			request.setAttribute("user", this.clientService.findById(id));
			request.setAttribute("listRents", listRents);
			request.setAttribute("listVehicle", listVehicle);
			request.setAttribute("nbRents", nbRents);
			request.setAttribute("nbVehicle", nbVehicle);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/users/details.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {

	}
}
