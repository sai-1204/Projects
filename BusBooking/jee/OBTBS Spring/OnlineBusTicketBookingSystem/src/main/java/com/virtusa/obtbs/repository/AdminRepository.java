package com.virtusa.obtbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.obtbs.dto.AdminDTO;


@Repository
public interface AdminRepository extends JpaRepository<AdminDTO, Integer>{

	@Query("select a from AdminDTO a where a.adminName=:p1 and a.adminPassword=:p2")
	public AdminDTO getvalidate(@Param("p1") String name,@Param("p2") String password );
	
	
	
}
