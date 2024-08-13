package com.virtusa.obtbs.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.obtbs.dto.BookingDTO;
import com.virtusa.obtbs.dto.BusBookingDTO;
import com.virtusa.obtbs.dto.BusDTO;
import com.virtusa.obtbs.dto.CustomerDTO;
import com.virtusa.obtbs.dto.PassengersDTO;
import com.virtusa.obtbs.exception.NoElementException;
import com.virtusa.obtbs.pojo.BookPojo;
import com.virtusa.obtbs.pojo.ResponseBookPojo;
import com.virtusa.obtbs.service.BookingService;
import com.virtusa.obtbs.service.BusService;
import com.virtusa.obtbs.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController{

	
	
	@Autowired
	BusService busService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BookingService bookingService;
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<?>  updatecust(@RequestBody CustomerDTO customerDTO)throws NoElementException{
		
		return new ResponseEntity<CustomerDTO>(customerService.update(customerDTO), HttpStatus.OK);
		
	}
	
	@GetMapping("/getcustbyid/{id}")
	public ResponseEntity<?> getcustbyid(@PathVariable("id") int id)throws NoElementException{
		
		return new ResponseEntity<CustomerDTO>(customerService.getcustbyid(id), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<?>  deletecust(@PathVariable("id") int id)throws NoElementException{
		
		customerService.delete(id);
		return new ResponseEntity<String>("customer deleted ", HttpStatus.OK);
		
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletebookingdetails(@PathVariable("id") int id)throws NoElementException{
		
		bookingService.deletebookingdetailsbyid(id);
		return new ResponseEntity<String>("deleted succesfully", HttpStatus.OK);
	}
	
	
	@GetMapping("/getbookdetails/{p1}")
	public ResponseEntity<?> getdetails(@PathVariable("p1") int id)throws NoElementException{
		
		
		return new ResponseEntity<BookingDTO>(bookingService.getbookingdetailsbyid(id), HttpStatus.OK);
		
	}
	@GetMapping("/getbookdetailsbyname/{name}")
	public ResponseEntity<?> getdetailsbyname(@PathVariable("name") String name){
		String name1=name.toLowerCase();
		List<BookingDTO> lb=bookingService.getbookingdetailsbyname(name1);
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("No booking details of "+name, HttpStatus.OK);
		
		}
		return new ResponseEntity<List<BookingDTO>>(lb, HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("/deletebyname/{name}")
	public ResponseEntity<?> getdeletebyname(@PathVariable("name") String name){
		String name1=name.toLowerCase();
		List<BookingDTO> lb=bookingService.getbookingdetailsbyname(name1);
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("Booking details not found with the name "+name, HttpStatus.OK);
		
		}
		bookingService.deletebookingdetailsbyname(lb);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.FOUND);
		
	}
	
	
	
	
	@GetMapping("searchbynum/{id}")
	public ResponseEntity<?> searchbus(@PathVariable("id") int id) throws NoElementException{
		
		return new ResponseEntity<BusDTO>(busService.getBusByNum(id), HttpStatus.FOUND);
		
	}
	
	@GetMapping("searchbysrc/{src}")
	public ResponseEntity<?> getbus(@PathVariable("src") String src){
		
		String src1=src.toLowerCase();
		List<BusDTO> lb=customerService.getbusbysource(src1);
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("sorry buses are not available from "+src, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<BusDTO>>(lb,HttpStatus.FOUND);
		
	}
	@GetMapping("searchbydest/{dest}")
	public ResponseEntity<?> getbusdest(@PathVariable("dest") String dest){
		
		String dest1=dest.toLowerCase();
		List<BusDTO> lb=customerService.getbusbydestination(dest1);
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("sorry buses are not available by the details you entered", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<BusDTO>>(customerService.getbusbydestination(dest1),HttpStatus.FOUND);
		
	}
	@GetMapping("searchbysrcdestdate/{src}/{dest}/{date}")
	public ResponseEntity<?> getbus(@PathVariable("src") String src,@PathVariable("dest") String dest,@PathVariable("date") String date){
		String src1=src.toLowerCase();
		String dest1=dest.toLowerCase();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ld=LocalDate.parse(date, dtf);
		List<BusDTO> lb=customerService.getbusbysrcdestdate(src1, dest1,ld);
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("sorry buses are not available by the details you entered", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<BusDTO>>(lb,HttpStatus.FOUND);
		
	}
	
	
	@GetMapping("searchbysrcdest/{src}/{dest}")
	public ResponseEntity<?> getbusbysrcdest(@PathVariable("src") String src,@PathVariable("dest") String dest){
		String src1=src.toLowerCase();
		String dest1=dest.toLowerCase();
		
		List<BusDTO> lb=customerService.getbusbysrcdest(src, dest1);
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("sorry buses are not available by the details you entered", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<BusDTO>>(lb,HttpStatus.FOUND);
		
	}
	
	
	
	
	
		
		@PostMapping("/bookticket")
		public ResponseEntity<?> bookticket(@RequestBody BookPojo bookPojo) throws NoElementException{
			
			int id=bookPojo.getCustid();
			  CustomerDTO cust=customerService.getcustbyid(id);
			  BusBookingDTO bookingDTO=bookPojo.getBusBookingDTO();
				if(bookingDTO.getNo_of_seats()==0) {
					return new ResponseEntity<String>("no of seats cant be zero",HttpStatus.BAD_REQUEST);
				}
			int c=0;
		List<PassengersDTO> lp=	bookPojo.getPassengersdetails();
			for(PassengersDTO p:lp) {
				
				c=c+1;
			}
			if(bookPojo.getBusBookingDTO().getNo_of_seats()!=c) {
				
				return new ResponseEntity<String>("no of seats and no of passengers are not matched",HttpStatus.BAD_REQUEST);
			}
			
			int busnum=bookingDTO.getBusNum();
			BusDTO busDTO=busService.getBusByNum(busnum);
			if(busDTO.getAvailableSeats()==0) {
				return new ResponseEntity<String>("seats are booked, available seats are zero",HttpStatus.OK);
			}
			String src=bookingDTO.getSource();
			String dest=bookingDTO.getDestination();
			String date=bookingDTO.getDate();
			String src1=src.toLowerCase();
			String dest1=dest.toLowerCase();
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate ld=LocalDate.parse(date, dtf);
			List<BusDTO> lb=customerService.getbusbysrcdestdate(src1, dest1,ld);
			if(lb.isEmpty()) {
				return new ResponseEntity<String>("sorry buses are not available by the details you entered with"+src+dest+date, HttpStatus.BAD_REQUEST);
			}
			if(bookingDTO.getNo_of_seats()>busDTO.getAvailableSeats()) {
			      return new ResponseEntity<String>("sorry seats are not available check the seats and book your ticket",HttpStatus.BAD_REQUEST);	
			}
			ResponseBookPojo responseBookPojo=new ResponseBookPojo();
			float totalamount=0f;
			int availableseats=0;
				
				if(bookingDTO.getNo_of_seats()<=busDTO.getAvailableSeats()) {
					
					totalamount=bookingDTO.getNo_of_seats()*busDTO.getTicketPrice();
					availableseats=busDTO.getAvailableSeats()-bookingDTO.getNo_of_seats();
				}
				
				busDTO.setAvailableSeats(availableseats);
				bookingDTO.setTime(busDTO.getTime());
				bookingDTO.setBusName(busDTO.getBuName());
				bookingDTO.setAmount(totalamount);
				busService.updateBus(busDTO);
					
				  LocalDate localDate = LocalDate.now();
			
	BookingDTO bookdto=new BookingDTO(localDate,cust.getCustname(),cust.getCustphonenumber(),bookingDTO,bookPojo.getPassengersdetails());
	bookingService.addbookingdetails(bookdto);
	responseBookPojo.setAmount(totalamount);
	responseBookPojo.setBookingId(bookdto.getBookingid());
	responseBookPojo.setDate(localDate);
	return new ResponseEntity<ResponseBookPojo>(responseBookPojo, HttpStatus.OK);
	
	
}
}