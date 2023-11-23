package com.raunak.bus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raunak.bus.Entity.Users;

public interface UserRepository  extends JpaRepository<Users, Integer> {
	Users findByEmail(String email);
}

