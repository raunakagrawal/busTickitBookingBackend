package com.raunak.bus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raunak.bus.Entity.Cities;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {

}
