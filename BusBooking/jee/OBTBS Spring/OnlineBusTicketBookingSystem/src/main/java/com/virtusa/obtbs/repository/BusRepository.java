package com.virtusa.obtbs.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.obtbs.dto.BusDTO;
@Repository
public interface BusRepository extends JpaRepository<BusDTO, Integer> {
@Query("select b from BusDTO b where b.busNumber=:p1")
	public BusDTO getBusbyNum(@Param("p1") String num);

@Query("select b from BusDTO b where b.source=:p1")
public List<BusDTO> getBusbySource(@Param("p1") String source);


@Query("select b from BusDTO b where b.destination=:p1")
public List<BusDTO> getBusbyDestination(@Param("p1") String destination);

@Query("select b from BusDTO b where b.source=:p1 and b.destination=:p2 and b.date=:p3")
public List<BusDTO> getBusbySrcDestdate(@Param("p1") String source,@Param("p2") String destination,@Param("p3") LocalDate date);


@Query("select b from BusDTO b where b.source=:p1 and b.destination=:p2")
public List<BusDTO> getBusbySrcDest(@Param("p1") String source,@Param("p2") String destination);



}
