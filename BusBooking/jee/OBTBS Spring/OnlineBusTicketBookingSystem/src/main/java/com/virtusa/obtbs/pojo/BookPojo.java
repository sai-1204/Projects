package com.virtusa.obtbs.pojo;

import java.util.List;

import com.virtusa.obtbs.dto.BusBookingDTO;
import com.virtusa.obtbs.dto.PassengersDTO;

public class BookPojo {

	
	BusBookingDTO busBookingDTO;
	private int custid;
	List<PassengersDTO> passengersdetails;
	
	public BookPojo() {
		
	}

	

	public BookPojo(BusBookingDTO busBookingDTO, int custid, List<PassengersDTO> passengersdetails) {
		super();
		this.busBookingDTO = busBookingDTO;
		this.custid = custid;
		this.passengersdetails = passengersdetails;
	}



	public BusBookingDTO getBusBookingDTO() {
		return busBookingDTO;
	}

	public void setBusBookingDTO(BusBookingDTO busBookingDTO) {
		this.busBookingDTO = busBookingDTO;
	}

	

	

	public int getCustid() {
		return custid;
	}



	public void setCustid(int custid) {
		this.custid = custid;
	}



	public List<PassengersDTO> getPassengersdetails() {
		return passengersdetails;
	}

	public void setPassengersdetails(List<PassengersDTO> passengersdetails) {
		this.passengersdetails = passengersdetails;
	}



	@Override
	public String toString() {
		return "BookPojo [busBookingDTO=" + busBookingDTO + ", custid=" + custid + ", passengersdetails="
				+ passengersdetails + "]";
	}

	

	

	

}