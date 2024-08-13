package com.virtusa.obtbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.obtbs.dto.AdminDTO;
import com.virtusa.obtbs.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public AdminDTO getadmin(String name, String pwd) {
		// TODO Auto-generated method stub
		
		return adminRepository.getvalidate(name, pwd);
	}

	@Override
	public AdminDTO addadmin(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		return adminRepository.save(adminDTO);
	}

}
