package com.raunak.bus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raunak.bus.Entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer>{
	
	
}
