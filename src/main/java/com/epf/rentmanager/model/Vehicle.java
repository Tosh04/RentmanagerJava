package com.epf.rentmanager.model;
import java.time.LocalDate; 





public class Vehicle {

       private int id;

       private String constructeur;

//       private static String modele;

       private int nb_places;

       public Vehicle(){}

       public Vehicle(int pid, String pconstructeur, int pnb_places){

             id = pid;

             constructeur = pconstructeur;

             //modele = pmodele; en comm car modele existe pas dans BDD SQL

             nb_places = pnb_places;

       }

       public Vehicle(String pconstructeur, int pnb_places){

           constructeur = pconstructeur;

           //modele = pmodele; en comm car modele existe pas dans BDD SQL

           nb_places = pnb_places;

     }
      

       public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getConstructeur() {
		return constructeur;
	}



	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	

	public int getNb_places() {
		return nb_places;
	}



	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	}



	public String toString() {

                return "id : " + this.id

                   + "\nconstructeur : " + this.constructeur

//                   +  "\nmodele : " + this.modele

                      + "\nnb_places : " + this.nb_places;

       }

}

 

 