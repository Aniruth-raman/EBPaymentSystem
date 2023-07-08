package com.group2.capstone.EBPaymentSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group2.capstone.EBPaymentSystem.models.Bill;
import com.group2.capstone.EBPaymentSystem.models.MeterReadings;


public interface BillingRepo extends JpaRepository<Bill, Long>{

	@Query(value="select * from bill where property_id = ?1 order by billing_month desc",nativeQuery = true)
	List<Bill> findByProperty(Long id);
	
	
	@Query(value="select * from bill where property_id = ?1 and month(billing_month)=?2 and year(billing_month)=?3",nativeQuery = true)
	Bill findByPropertyAndDate(Long id, int month, int year);
}
