package com.virtusa.obtbs.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bus_tb")
public class BusDTO {
	@Id
	@Column(name="busnum",nullable = false)
    private int busNumber;
	@Column(name="busname",length = 20,nullable = false)
    private String buName;
	@Column(name="source",length = 20,nullable = false)
    private String source;
	@Column(name="destination",length = 20,nullable = false)
    private String destination;
	@Column(name="date",length = 20,nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate date;
	@Column(name="time",length = 20,nullable = false)
    private String time;
	@Column(name="stationname",length = 20,nullable = false)
    private String stationName;
	@Column(name="availableseats",nullable = false)
    private int availableSeats;
	@Column(name="ticketrice",nullable = false)
    private int ticketPrice;
	@Override
	public String toString() {
		return "Bus [busNumber=" + busNumber + ", buName=" + buName + ", source=" + source + ", destination="
				+ destination + ", date=" + date + ", time=" + time + ", stationName=" + stationName
				+ ", availableSeats=" + availableSeats + ", ticketPrice=" + ticketPrice + "]";
	}
	public int getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public BusDTO() {
		super();
	}
	public BusDTO(int busNumber, String buName, String source, String destination, LocalDate date, String time,
			String stationName, int availableSeats, int ticketPrice) {
		super();
		this.busNumber = busNumber;
		this.buName = buName;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.stationName = stationName;
		this.availableSeats = availableSeats;
		this.ticketPrice = ticketPrice;
	}
	



}
