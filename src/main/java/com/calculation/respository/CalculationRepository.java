package com.calculation.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.calculation.entity.CalculatorEntity;

@Repository
public interface CalculationRepository extends JpaRepository<CalculatorEntity, Long> {

	@Modifying
	@Transactional
	@Query(value = "TRUNCATE TABLE calculation_history", nativeQuery = true)
	void truncateTable();

}
