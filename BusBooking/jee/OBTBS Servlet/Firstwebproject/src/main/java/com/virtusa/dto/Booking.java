package com.virtusa.dto;

public class Booking {

	String busno;
	String source;
	String destination;
	int seats;
	String mobilenumber;
	int cost;
	public Booking() {
		
	}
	public Booking(String busno, String source, String destination, int seats, String mobilenumber, int cost) {
		super();
		this.busno = busno;
		this.source = source;
		this.destination = destination;
		this.seats = seats;
		this.mobilenumber = mobilenumber;
		this.cost = cost;
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
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
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Booking [busno=" + busno + ", source=" + source + ", destination=" + destination + ", seats=" + seats
				+ ", mobilenumber=" + mobilenumber + ", cost=" + cost + "]";
	}
	
	
	
	
}
