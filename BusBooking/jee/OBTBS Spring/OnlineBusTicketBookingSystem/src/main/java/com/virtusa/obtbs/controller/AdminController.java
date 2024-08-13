package com.virtusa.obtbs.controller;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.virtusa.obtbs.dto.BusDTO;
import com.virtusa.obtbs.dto.CustomerDTO;
import com.virtusa.obtbs.exception.NoElementException;
import com.virtusa.obtbs.service.BookingService;
import com.virtusa.obtbs.service.BusService;
import com.virtusa.obtbs.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	BusService busService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BookingService bookingService;
	
	Log log=LogFactory.getLog(AdminController.class);
	
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletebus(@PathVariable("id") int id) throws NoElementException{
		
		busService.deleteBus(id);
		
		return new ResponseEntity<String>("bus deleted",HttpStatus.OK);
		
	}
	@PutMapping("/update")
    public ResponseEntity<BusDTO> updatebus(@RequestBody BusDTO bus) throws NoElementException {
		 
		
		return new ResponseEntity<BusDTO>(busService.updateBus(bus), HttpStatus.OK);
		
	}
	@GetMapping("/getbus/{id}")
	public ResponseEntity<BusDTO> getbus(@PathVariable("id") int id) throws NoElementException{
		
		
		log.info("getting the bus deatils");
		return new ResponseEntity<BusDTO>(busService.getBusByNum(id),HttpStatus.FOUND);
		
	}
	
	@GetMapping("/getcustomers")
	public ResponseEntity<?> getcust() {
		List<CustomerDTO> lc=customerService.getcustlist();
		if(lc.isEmpty()) {
			return new ResponseEntity<String>("No customers", HttpStatus.OK);
		
		}
		
		return new ResponseEntity<List<CustomerDTO>>(lc, HttpStatus.OK);
		}
	
	@PostMapping("/addbus")
	public ResponseEntity<?> addbus(@RequestBody BusDTO bus) {
		 
		busService.addBus(bus);
		return new ResponseEntity<String>("added successfully", HttpStatus.CREATED);
		
	}
	@GetMapping("/viewbuses")
	public ResponseEntity<?> getbuses(){
		
		List<BusDTO> lb=busService.getbuses();
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("no buses available",HttpStatus.OK);
		}
		return new ResponseEntity<List<BusDTO>>(busService.getbuses(), HttpStatus.OK);
	}
	
	@GetMapping("/viewbookingdetails")
	public ResponseEntity<?> getbookingdetails(){
		
		List<BookingDTO> lb=bookingService.gettotalbookingdetails();
		if(lb.isEmpty()) {
			return new ResponseEntity<String>("no booking details", HttpStatus.OK);
		}
		return new ResponseEntity<List<BookingDTO>>(lb, HttpStatus.FOUND);
		
	}
	
	
}
