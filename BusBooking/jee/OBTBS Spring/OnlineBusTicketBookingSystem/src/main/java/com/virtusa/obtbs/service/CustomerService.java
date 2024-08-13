package com.virtusa.obtbs.service;

import java.time.LocalDate;
import java.util.List;

import com.virtusa.obtbs.dto.BusDTO;
import com.virtusa.obtbs.dto.CustomerDTO;
import com.virtusa.obtbs.exception.NoElementException;

public interface CustomerService {

	public List<BusDTO> getbusbysource(String source);
	public List<BusDTO> getbusbydestination(String dest);
	public List<BusDTO> getbusbysrcdestdate(String source,String dest,LocalDate date);
	public List<BusDTO> getbusbysrcdest(String source,String dest);
	public CustomerDTO getcustbyid(int id) throws NoElementException;
	public CustomerDTO addcust(CustomerDTO cust);
	public void delete(int id)throws NoElementException;
	public CustomerDTO update(CustomerDTO cust)throws NoElementException;
	public List<CustomerDTO> getcustlist();
	public CustomerDTO getcust(String name,String pwd);
	
	
	
	
}
