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
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository

public class ReservationDao {

	private ReservationDao() {}
	
	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";
	private static final String FIND_RESERVATION_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation WHERE id=?;";
		
	public long create(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_RESERVATION_QUERY);
			
			//pstmt.setInt(1, reservation.getId());
			pstmt.setInt(1, reservation.getClient_id());
			pstmt.setInt(2, reservation.getVehicle_id());
			pstmt.setDate(3, Date.valueOf(reservation.getDebut()));
			pstmt.setDate(4, Date.valueOf(reservation.getFin()));
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public long delete(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_RESERVATION_QUERY);
			
			pstmt.setInt(1, reservation.getId());
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Optional<Reservation> findById(int id) throws DaoException{
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATION_QUERY);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			Integer reservationClientId = rs.getInt("client_id");
			Integer reservationVehicleId = rs.getInt("vehicle_id");
			LocalDate reservationDebut = rs.getDate("debut").toLocalDate();
			LocalDate reservationFin = rs.getDate("fin").toLocalDate();
			
			Reservation reservation = new Reservation(id, reservationClientId, reservationVehicleId, reservationDebut, reservationFin);
			
			return Optional.of(reservation);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public List<Reservation> findResaByClientId(int clientId) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			
			pstmt.setInt(1, clientId);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Reservation> listReservation = new ArrayList<>();
			
			while (rs.next()) {
			
			Integer reservationId = rs.getInt("id");
			Integer reservationClientId = rs.getInt("client_id");
			Integer reservationVehicleId = rs.getInt("vehicle_id");
			LocalDate reservationDebut = rs.getDate("debut").toLocalDate();
			LocalDate reservationFin = rs.getDate("fin").toLocalDate();
			
			Reservation reservation = new Reservation(reservationId, reservationClientId, reservationVehicleId, reservationDebut, reservationFin);
			
			listReservation.add(reservation);

			}
			
			return listReservation;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Reservation> findResaByVehicleId(int vehicleId) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			
			pstmt.setInt(1, vehicleId);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Reservation> listReservation = new ArrayList<>();
			
			while (rs.next()) {
			
			Integer reservationId = rs.getInt("id");
			Integer reservationClientId = rs.getInt("client_id");
			Integer reservationVehicleId = rs.getInt("vehicle_id");
			LocalDate reservationDebut = rs.getDate("debut").toLocalDate();
			LocalDate reservationFin = rs.getDate("fin").toLocalDate();
			
			Reservation reservation = new Reservation(reservationId, reservationClientId, reservationVehicleId, reservationDebut, reservationFin);
			
			listReservation.add(reservation);

			}
			
			return listReservation;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Reservation> findAll() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_QUERY);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Reservation> listReservation = new ArrayList<>();
			
			while (rs.next()) {
				Integer reservationId = rs.getInt("id");
				Integer reservationClientId = rs.getInt("client_id");
				Integer reservationVehicleId = rs.getInt("vehicle_id");
				LocalDate reservationDebut = rs.getDate("debut").toLocalDate();
				LocalDate reservationFin = rs.getDate("fin").toLocalDate();
				
				
				Reservation reservation = new Reservation(reservationId, reservationClientId, reservationVehicleId, reservationDebut, reservationFin);
				
				listReservation.add(reservation);
			}
			return listReservation;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
