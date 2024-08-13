package com.virtusa.obtbs.service;

import com.virtusa.obtbs.dto.AdminDTO;

public interface AdminService {

	public AdminDTO getadmin(String name,String pwd);
	public AdminDTO addadmin(AdminDTO adminDTO);
	
}
