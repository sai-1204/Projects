package com.virtusa.obtbs.pojo;

import java.time.LocalDate;

public class ResponseBookPojo {

	private int BookingId;
	private LocalDate date;
	private float amount;
	
public ResponseBookPojo() {
	
}



public ResponseBookPojo(int bookingId, LocalDate date, float amount) {
	super();
	BookingId = bookingId;
	this.date = date;
	this.amount = amount;
}



public int getBookingId() {
	return BookingId;
}

public void setBookingId(int bookingId) {
	BookingId = bookingId;
}



public LocalDate getDate() {
	return date;
}



public void setDate(LocalDate date) {
	this.date = date;
}



public float getAmount() {
	return amount;
}

public void setAmount(float amount) {
	this.amount = amount;
}

@Override
public String toString() {
	return "ResponseBookPojo [BookingId=" + BookingId + ", date=" + date + ", amount=" + amount + "]";
}
	


}
