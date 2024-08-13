package com.virtusa.obtbs.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookingdeatils")
public class BookingDTO {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingid;

    private LocalDate date;
    
    private String custname;
    private String custphonenumber;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = BusBookingDTO.class)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private BusBookingDTO bookingDetails;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="passengerslist")
    private List<PassengersDTO> passengersDTO=new ArrayList<PassengersDTO>();
	
	public BookingDTO() {
		
	}

	

	



	public BookingDTO(LocalDate date, String custname, String custphonenumber, BusBookingDTO bookingDetails,
			List<PassengersDTO> passengersDTO) {
		super();
		this.date = date;
		this.custname = custname;
		this.custphonenumber = custphonenumber;
		this.bookingDetails = bookingDetails;
		this.passengersDTO = passengersDTO;
	}







	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	

	public BusBookingDTO getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BusBookingDTO bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public List<PassengersDTO> getPassengersDTO() {
		return passengersDTO;
	}

	public void setPassengersDTO(List<PassengersDTO> passengersDTO) {
		this.passengersDTO = passengersDTO;
	}



	public String getCustname() {
		return custname;
	}



	public void setCustname(String custname) {
		this.custname = custname;
	}






	public String getCustphonenumber() {
		return custphonenumber;
	}







	public void setCustphonenumber(String custphonenumber) {
		this.custphonenumber = custphonenumber;
	}







	@Override
	public String toString() {
		return "BookingDTO [bookingid=" + bookingid + ", date=" + date + ", custname=" + custname + ", custphonenumber="
				+ custphonenumber + ", bookingDetails=" + bookingDetails + ", passengersDTO=" + passengersDTO + "]";
	}









	
}