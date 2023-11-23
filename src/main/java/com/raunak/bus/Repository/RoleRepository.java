package com.raunak.bus.Repository;

import org.springframework.data.repository.CrudRepository;

import com.raunak.bus.Entity.Roles;


public interface RoleRepository extends CrudRepository <Roles, Long> {

}