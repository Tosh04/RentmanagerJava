package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Client {

    private int id;

    private String name;

    private String lastname;

    private String email;

    private LocalDate birthdate;

   

    public Client() {}

   

    public Client(int pid, String pname, String plastname, String pemail, LocalDate pbirthdate) {

          id = pid;

          name = pname;

          lastname = plastname;

          email = pemail;

          birthdate = pbirthdate;

    }
    
    public Client(String pname, String plastname, String pemail, LocalDate pbirthdate) {

        name = pname;

        lastname = plastname;

        email = pemail;

        birthdate = pbirthdate;

  }


    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}



	public String toString() {

             return "id : " + this.id

                + "\nname : " + this.name

                +  "\nlastname : " + this.lastname

                   + "\nemail : " + this.email

                   + "\nbirthdate : " + this.birthdate;

    }

   

}



