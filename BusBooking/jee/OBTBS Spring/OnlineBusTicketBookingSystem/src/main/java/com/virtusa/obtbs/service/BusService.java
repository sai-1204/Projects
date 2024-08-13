package com.virtusa.obtbs.service;

import java.util.List;

import com.virtusa.obtbs.dto.BusDTO;
import com.virtusa.obtbs.exception.NoElementException;

public interface BusService {

	public BusDTO addBus(BusDTO busDTO);
	public List<BusDTO> getbuses();
	public BusDTO getBusByNum(int busDTO) throws NoElementException;
	public BusDTO updateBus(BusDTO busDTO) throws NoElementException;
	public void deleteBus(int id) throws NoElementException ;
	
}
