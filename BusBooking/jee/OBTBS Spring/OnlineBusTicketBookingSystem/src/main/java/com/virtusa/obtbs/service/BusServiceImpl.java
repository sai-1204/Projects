package com.virtusa.obtbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.obtbs.dto.BusDTO;
import com.virtusa.obtbs.exception.NoElementException;
import com.virtusa.obtbs.repository.BusRepository;
@Service
public class BusServiceImpl implements BusService{

	@Autowired
	BusRepository busrepository;
	
	@Override
	public BusDTO addBus(BusDTO bus) {
		// TODO Auto-generated method stub
		return busrepository.save(bus);
	}

	@Override
	public List<BusDTO> getbuses() {
		// TODO Auto-generated method stub
		return busrepository.findAll();
	}

	@Override
	public BusDTO getBusByNum(int id) throws NoElementException {
		// TODO Auto-generated method stub
		
		if(busrepository.existsById(id)) {
			return busrepository.findById(id).get();
		}
		else {
			throw new NoElementException("no bus with the given id");
		}
	
	}

	@Override
	public BusDTO updateBus(BusDTO busDTO) throws NoElementException{
		// TODO Auto-generated method stub
		
		int id=busDTO.getBusNumber();
		if(busrepository.existsById(id)) {
		return busrepository.save(busDTO);
		}
		else {
			throw new NoElementException("no bus with the given id");
		}
	}

	@Override
	public void deleteBus(int id) throws NoElementException {
		// TODO Auto-generated method stub
		
		if(busrepository.existsById(id)) {
			busrepository.deleteById(id);
		}
		else {
			throw new NoElementException("no bus with the given id");
		}
	}

	
	
}
