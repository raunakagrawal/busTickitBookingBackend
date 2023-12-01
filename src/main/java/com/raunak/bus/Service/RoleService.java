package com.raunak.bus.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raunak.bus.Entity.Roles;
import com.raunak.bus.Repository.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
    
    public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public List<Roles> getAllRoles() {
        //List<Roles> roles = (List<Roles>) roleRepository.findAll();
        return (List<Roles>) roleRepository.findAll();
    }
    
}
