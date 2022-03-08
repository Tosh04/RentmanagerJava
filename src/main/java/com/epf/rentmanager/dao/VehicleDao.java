package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository

public class VehicleDao {
	
	private VehicleDao() {}
	
	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	
	public long create(Vehicle vehicle) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_VEHICLE_QUERY);
			
			//pstmt.setInt(1, vehicle.getId());
			pstmt.setString(1, vehicle.getConstructeur());
			pstmt.setInt(2, vehicle.getNb_places());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public long delete(Vehicle vehicle) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_VEHICLE_QUERY);
			
			pstmt.setInt(1, vehicle.getId());
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public Optional<Vehicle> findById(int id) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLE_QUERY);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			String vehicleConstructor = rs.getString("constructeur");
			//String vehicleModel = rs.getString("modele"); 
			//en commentaire car la colonne modele n'existe pas dans la requete SQL
			Integer vehicleNbPlace = rs.getInt("nb_places");
			
			Vehicle vehicle = new Vehicle(id, vehicleConstructor, vehicleNbPlace);
			
			return Optional.of(vehicle);
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public List<Vehicle> findAll() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLES_QUERY);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Vehicle> listVehicle = new ArrayList<Vehicle>();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String vehicleConstructor = rs.getString("constructeur");
				Integer vehicleNbPlace = rs.getInt("nb_places");
				
				Vehicle vehicle = new Vehicle(id, vehicleConstructor, vehicleNbPlace);
				
				listVehicle.add(vehicle);
			
			}
			return listVehicle;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
