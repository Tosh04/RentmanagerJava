package com.epf.rentmanager.model;

import java.time.LocalDate;

 

public class Reservation {

       private int id;

       private int client_id;

       private int vehicle_id;

       private LocalDate debut;

       private LocalDate fin;

      

       public Reservation(int pid, int pclient_id, int pvehicle_id, LocalDate pdebut, LocalDate pfin) {

             id = pid;

             client_id = pclient_id;

             vehicle_id = pvehicle_id;

             debut = pdebut;

             fin= pfin;

       }
       
       public Reservation(int pclient_id, int pvehicle_id, LocalDate pdebut, LocalDate pfin) {

           client_id = pclient_id;

           vehicle_id = pvehicle_id;

           debut = pdebut;

           fin= pfin;

     }

      

       public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getClient_id() {
		return client_id;
	}



	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}



	public int getVehicle_id() {
		return vehicle_id;
	}



	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}



	public LocalDate getDebut() {
		return debut;
	}



	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}



	public LocalDate getFin() {
		return fin;
	}



	public void setFin(LocalDate fin) {
		this.fin = fin;
	}



	public String toString() {

                return "id : " + this.id

                   + "\nclient id : " + this.client_id

                   +  "\nvehicle id : " + this.vehicle_id

                      + "\ndebut : " + this.debut

                      + "\nfin : " + this.fin;

       }

      

}

 

 