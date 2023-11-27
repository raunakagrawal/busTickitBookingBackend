package com.raunak.bus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raunak.bus.Entity.Passengers;

public interface PassangerRepo  extends JpaRepository<Passengers, Integer>{
		List<Passengers> findBybookingId(Integer bookingId);
}
