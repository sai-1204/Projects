package com.virtusa.obtbs.service;

import java.util.List;

import com.virtusa.obtbs.dto.BookingDTO;
import com.virtusa.obtbs.exception.NoElementException;

public interface BookingService {

	public BookingDTO getbookingdetailsbyid(int id) throws NoElementException;
	public void addbookingdetails(BookingDTO bookingDTO);
	public void deletebookingdetailsbyid(int id) throws NoElementException;
	public List<BookingDTO> getbookingdetailsbyname(String name);
	public List<BookingDTO> gettotalbookingdetails();
	public void deletebookingdetailsbyname(List<BookingDTO> bookingDTOs);
}
