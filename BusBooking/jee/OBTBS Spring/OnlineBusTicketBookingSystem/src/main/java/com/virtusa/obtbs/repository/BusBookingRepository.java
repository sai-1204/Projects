package com.virtusa.obtbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.obtbs.dto.BusBookingDTO;
@Repository
public interface BusBookingRepository extends JpaRepository<BusBookingDTO, Integer>{

}
