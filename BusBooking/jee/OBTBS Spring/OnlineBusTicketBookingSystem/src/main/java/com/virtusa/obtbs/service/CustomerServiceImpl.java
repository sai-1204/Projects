package com.virtusa.obtbs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.obtbs.dto.BusDTO;
import com.virtusa.obtbs.dto.CustomerDTO;
import com.virtusa.obtbs.exception.NoElementException;
import com.virtusa.obtbs.repository.BusRepository;
import com.virtusa.obtbs.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	BusRepository busRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<BusDTO> getbusbysource(String source) {
		// TODO Auto-generated method stub
		List<BusDTO> bus=busRepository.getBusbySource(source);
		return bus;
	}

	@Override
	public List<BusDTO> getbusbydestination(String dest) {
		// TODO Auto-generated method stub
		return busRepository.getBusbyDestination(dest);
	}

	@Override
	public List<BusDTO> getbusbysrcdestdate(String source, String dest, LocalDate date) {
		// TODO Auto-generated method stub
		return busRepository.getBusbySrcDestdate(source, dest, date);
	}

	
	@Override
	public CustomerDTO addcust(CustomerDTO cust) {
		// TODO Auto-generated method stub
		customerRepository.save(cust);
		return cust;
	}

	@Override
	public void delete(int id) throws NoElementException{
		// TODO Auto-generated method stub
		
		if(customerRepository.existsById(id)) {
		customerRepository.deleteById(id);;
		}
		else {
			throw new NoElementException("no customer with the given id");
		}
	}

	@Override
	public CustomerDTO update(CustomerDTO cust)throws NoElementException {
		// TODO Auto-generated method stub
		int id=cust.getId();
		if(customerRepository.existsById(id)) {
		
		customerRepository.save(cust);
		return cust;
		}
		else {
			throw new NoElementException("no customer with the given id");
		}
		
	}

	@Override
	public List<CustomerDTO> getcustlist() {
		// TODO Auto-generated method stub
		List<CustomerDTO> lc=customerRepository.findAll();
		
		return lc;
	}

	@Override
	public CustomerDTO getcust(String name, String pwd) {
		// TODO Auto-generated method stub
		
		return customerRepository.getcustbynamepwd(name, pwd);
	}

	@Override
	public CustomerDTO getcustbyid(int id) throws NoElementException{
		// TODO Auto-generated method stub
		if(customerRepository.existsById(id)) {
		CustomerDTO cust=customerRepository.findById(id).get();
		return cust;
		}
		else {
			throw new NoElementException("no customer with the given id");
		}
	}

	@Override
	public List<BusDTO> getbusbysrcdest(String source, String dest) {
		// TODO Auto-generated method stub
		return busRepository.getBusbySrcDest(source, dest);
	}

	
	
	
}
