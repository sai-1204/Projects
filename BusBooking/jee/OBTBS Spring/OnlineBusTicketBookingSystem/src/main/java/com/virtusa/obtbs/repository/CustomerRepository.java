package com.virtusa.obtbs.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.virtusa.obtbs.dto.CustomerDTO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Integer>{

	
	@Query("select c from CustomerDTO c where c.custname=:p1 and c.custpassword=:p2")
	public CustomerDTO getcustbynamepwd(@Param("p1") String name,@Param("p2") String password);
	
	
}
