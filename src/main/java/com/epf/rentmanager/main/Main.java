package com.epf.rentmanager.main;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.rentmanager.configuration.AppConfiguration;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

public class Main {
	 
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		ClientService clientService = context.getBean(ClientService.class);
		VehicleService vehicleService = context.getBean(VehicleService.class);
		ReservationService reservationService = context.getBean(ReservationService.class);
		

		
		try {
//			reservationService.create(new Reservation (Integer.valueOf(9), Integer.valueOf(3), LocalDate.of(2022, 01, 21), LocalDate.of(2022,01,31)));
//			clientService.count();
//			clientService.delete(4);
//			System.out.println(vehicleService.findById(5));
			Vehicle vehicle = new Vehicle(3, "Seat", 2);
			vehicleService.update(vehicle);
			System.out.println(vehicleService.findAll());		
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}
