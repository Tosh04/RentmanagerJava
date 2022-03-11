package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.service.ReservationService;

@WebServlet("/rents/update")

public class RentsUpdateServlet extends HttpServlet {
	@Autowired
	ReservationService reservationService;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	private static final long serialVersionUID = 1L;
	
	int id = 0;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
			Reservation oldReservation = this.reservationService.findById(id);
			
			request.setAttribute("oldReservation", oldReservation);
			String debut = oldReservation.getDebut().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));;
			request.setAttribute("debut", debut);
			String fin = oldReservation.getFin().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));;
			request.setAttribute("fin", fin);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/rents/update.jsp").forward(request, response);
		
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		Integer client_id;
		Integer vehicle_id;
		LocalDate debut;
		LocalDate fin;

		client_id = Integer.parseInt(request.getParameter("client_id"));
		vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
		debut = LocalDate.parse(request.getParameter("begin"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		fin = LocalDate.parse(request.getParameter("end"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
		Reservation reservation = new Reservation(id, client_id, vehicle_id, debut, fin);
		
		try {
			this.reservationService.update(reservation);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		responce.sendRedirect("http://localhost:8080/rentmanager/rents");
		
	}
}
