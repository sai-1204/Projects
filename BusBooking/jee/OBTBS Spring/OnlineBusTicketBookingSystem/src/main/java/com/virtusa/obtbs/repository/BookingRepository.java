package com.virtusa.obtbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.obtbs.dto.BookingDTO;
@Repository
public interface BookingRepository extends JpaRepository<BookingDTO, Integer>{

	@Query("select b from BookingDTO b where b.custname=:p1")
	public List<BookingDTO> getbookingdetailsbyname(@Param("p1") String name);
	
}
