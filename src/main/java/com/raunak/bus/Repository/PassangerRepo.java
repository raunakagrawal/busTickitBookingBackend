package com.raunak.bus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raunak.bus.Entity.Passengers;

public interface PassangerRepo  extends JpaRepository<Passengers, Integer>{
		List<Passengers> findBybookingId(Integer bookingId);
		List<Passengers> findByJourneyDate(String journeyDate);
		//List<Passengers> findAllByStatusIsNotTrue();
		@Query("SELECT e FROM Passengers e WHERE e.status = FALSE OR e.status IS NULL")
		List<Passengers> findAllByStatusFalseOrNull();
		@Query("SELECT e FROM Passengers e WHERE e.status = FALSE OR e.status IS NULL AND e.journeyDate = :journeyDate")
		List<Passengers> findByJourneyDateWithStatus(String journeyDate);
		
		@Query("DELETE FROM Passengers e WHERE e.daysToDelete > :value")
		void deleteWating(Integer value);
		
		List<Passengers> findByBookedByUser(Integer bookedByUser);;
}
