package com.raunak.bus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.raunak.bus.Entity.Roles;
import com.raunak.bus.Repository.RoleRepository;
import com.raunak.bus.Service.RoleService;

@SpringBootTest
class RoleServiceTest {

    @Test
    void testGetAllRoles() {
        RoleRepository roleRepository = mock(RoleRepository.class);

        List<Roles> rolesList = new ArrayList<>();

        when(roleRepository.findAll()).thenReturn(rolesList);

        RoleService roleService = new RoleService(roleRepository);

        List<Roles> resultRoles = roleService.getAllRoles();

        verify(roleRepository, times(1)).findAll();

        assertEquals(rolesList.size(), resultRoles.size());
    }
}
