package com.group2.capstone.EBPaymentSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group2.capstone.EBPaymentSystem.models.MeterReadings;

@Repository
public interface MeterReadingsRepo extends JpaRepository<MeterReadings, Long>{

	@Query(value="select * from meter_readings where meter_meter_id = ?1 and month(Date)=?2 and year(Date)=?3",nativeQuery = true)
	List<MeterReadings> findByMeter(long id, int month, int year);
	
}
