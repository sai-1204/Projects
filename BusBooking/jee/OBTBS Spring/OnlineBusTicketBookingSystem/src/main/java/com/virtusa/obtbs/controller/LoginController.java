package com.virtusa.obtbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.obtbs.dto.AdminDTO;
import com.virtusa.obtbs.dto.CustomerDTO;
import com.virtusa.obtbs.service.AdminService;
import com.virtusa.obtbs.service.CustomerService;

@RestController
@RequestMapping("/login")

public class LoginController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/adminvalidate/{name}/{password}")
	public ResponseEntity<?> validate(@PathVariable("name") String name,@PathVariable("password") String password){
		
		AdminDTO a=null;
		a=adminService.getadmin(name, password);
		if(a!=null) {
			
			return new ResponseEntity<String>("found", HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		
	}
	@PostMapping("/addadmin")
	public AdminDTO add() {
		
		AdminDTO a=new AdminDTO("user","user");
		adminService.addadmin(a);
		return a;
	}
	@RequestMapping("/custvalidate/{name}/{password}")
	public ResponseEntity<?> custvalidate(@PathVariable("name") String name,@PathVariable("password") String password){
		
		CustomerDTO c=null;
		c=customerService.getcust(name, password);
		if(c!=null) {
			
			return new ResponseEntity<String>("customer login successfull", HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("customer not found with the given details", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<?> addcust(@RequestBody CustomerDTO customerDTO) {
		
		customerService.addcust(customerDTO);
		return new ResponseEntity<String>("customer added successfully", HttpStatus.CREATED);
	}
	
	
	
	
}
