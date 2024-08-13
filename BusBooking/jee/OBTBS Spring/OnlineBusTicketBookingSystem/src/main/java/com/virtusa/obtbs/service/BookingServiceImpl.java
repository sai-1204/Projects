package com.virtusa.obtbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.obtbs.dto.BookingDTO;
import com.virtusa.obtbs.dto.BusDTO;
import com.virtusa.obtbs.exception.NoElementException;
import com.virtusa.obtbs.repository.BookingRepository;
import com.virtusa.obtbs.repository.BusRepository;

@Service
public class BookingServiceImpl implements BookingService {

	

	@Autowired
	BookingRepository bookingrepository;
	@Autowired
	BusRepository busRepository;
	
	@Override
	public BookingDTO getbookingdetailsbyid(int id) throws NoElementException{
		// TODO Auto-generated method stub
		if(bookingrepository.existsById(id)) {
			BookingDTO bookingDTO=bookingrepository.findById(id).get();
			return bookingDTO;
		}
		else {
			throw new NoElementException("no booking details found the given"+id);
		}
	}

	@Override
	public void addbookingdetails(BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		bookingrepository.save(bookingDTO);
	}

	@Override
	public void deletebookingdetailsbyid(int id) throws NoElementException{
		// TODO Auto-generated method stub
		if(bookingrepository.existsById(id)) {
			BookingDTO bookingDTO=bookingrepository.findById(id).get();
			int num=bookingDTO.getBookingDetails().getBusNum();
			int nos=bookingDTO.getBookingDetails().getNo_of_seats();
			BusDTO busDTO=busRepository.findById(num).get();
			int avs=busDTO.getAvailableSeats();
			busDTO.setAvailableSeats(avs+nos);
			busRepository.save(busDTO);
			bookingrepository.deleteById(id);
			
		}
		else {
			throw new NoElementException("no booking details found the given"+id);
		}
		
	}

	@Override
	public List<BookingDTO> getbookingdetailsbyname(String name) {
		// TODO Auto-generated method stub
	List<BookingDTO> bookingDTO=	bookingrepository.getbookingdetailsbyname(name);
		return bookingDTO;
	}

	@Override
	public List<BookingDTO> gettotalbookingdetails() {
		// TODO Auto-generated method stub
		
		
		return bookingrepository.findAll();
	}

	@Override
	public void deletebookingdetailsbyname(List<BookingDTO> bookingDTOs) {
		// TODO Auto-generated method stub
		
		for(BookingDTO b:bookingDTOs) {
			int id=b.getBookingid();
			BookingDTO bookingDTO=bookingrepository.findById(id).get();
			int num=bookingDTO.getBookingDetails().getBusNum();
			int nos=bookingDTO.getBookingDetails().getNo_of_seats();
			BusDTO busDTO=busRepository.findById(num).get();
			int avs=busDTO.getAvailableSeats();
			busDTO.setAvailableSeats(avs+nos);
			busRepository.save(busDTO);
			bookingrepository.deleteById(id);
		}
		
	}

	
	
}
