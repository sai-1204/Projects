package com.virtusa.obtbs.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passengers_tb")
public class PassengersDTO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String passengername;
	private String passengerEmail;
	
	public PassengersDTO() {
		
	}
	
	public PassengersDTO(String passengername, String passengerEmail) {
		super();
		this.passengername = passengername;
		this.passengerEmail = passengerEmail;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	@Override
	public String toString() {
		return "PassengersDTO [id=" + id + ", passengername=" + passengername + ", passengerEmail=" + passengerEmail
				+ "]";
	}

	
	
	
	
}
