package com.virtusa.obtbs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="busbooking_tb")
public class BusBookingDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="busnum",nullable = false)
	private int busNum;
	@Column(name="busname",length = 20,nullable = false)
	private String busName;
	@Column(name="source",length = 20,nullable = false)
	private String source;
	@Column(name="destination",length = 20,nullable = false)
    private String destination;
	@Column(name="dateofjourney",length = 20,nullable = false)
	private String date;
	@Column(name="time",length = 20,nullable = false)
	private String time;
	@Column(name="seats",nullable = false)
	private int no_of_seats;
	@Column(name="amount",nullable = false)
	private float amount;
	public BusBookingDTO() {
		
	}
	
	@Override
	public String toString() {
		return "BusBookingDTO [id=" + id + ", busNum=" + busNum + ", busName=" + busName + ", source=" + source
				+ ", destination=" + destination + ", date=" + date + ", time=" + time + ", no_of_seats=" + no_of_seats
				+ ", amount=" + amount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBusNum() {
		return busNum;
	}
	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public BusBookingDTO(int busNum, String source, String destination, String date, int no_of_seats) {
		super();
		this.busNum = busNum;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.no_of_seats = no_of_seats;
	}

	public BusBookingDTO(int busNum, String busName, String source, String destination, String date, String time,
			int no_of_seats, float amount) {
		super();
		this.busNum = busNum;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.no_of_seats = no_of_seats;
		this.amount = amount;
	}
	
	
}
