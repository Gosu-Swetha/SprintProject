package com.cg.ofda.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.ofda.dto.BillDto;

@Repository
public interface IBillRepository extends JpaRepository<BillDto, String>{
	@Query("select b from BillDto b where b.billDate>=:startDate and b.billDate<=:endDate")
	public List<BillDto> viewBillsByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
