package com.raunak.bus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.raunak.bus.Dto.LoginDto;
import com.raunak.bus.Dto.UserDto;
import com.raunak.bus.Entity.Users;
import com.raunak.bus.Repository.UserRepository;
import com.raunak.bus.Service.UserService;

class UserServiceTest {
    @SuppressWarnings("unused")
	@Test
    void testCreateUser() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);
        
        
        Users user = new Users();
        user.setEmail("test@example.com");
        user.setDob("1993-11-29");
        user.setId(1);
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setGender("m");
        user.setMobileNo("9876543210");
        user.setRole("2");
        user.setPassword("123456");
        user.setPasswordConfirm("123456");
        
        UserDto user1 = new UserDto(2,"","","","","",28,"");
        
        when(userRepository.findByEmail("test@example.com")).thenReturn(null);

        when(userRepository.save(any(Users.class))).thenReturn(user);
       //String e = ValidationService.validate(user);
        ResponseEntity<Object> response = userService.createUser(user);
        
        verify(userRepository, times(1)).findByEmail("test@example.com");
        verify(userRepository, times(1)).save(any(Users.class));

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    void testCreateUserWhenExist() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        Users user = new Users();
        user.setEmail("test@example.com");
        user.setDob("1993-11-29");
        user.setId(1);
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setGender("m");
        user.setMobileNo("9876543210");
        user.setRole("2");
        user.setPassword("123456");
        user.setPasswordConfirm("123456");

        when(userRepository.findByEmail("test@example.com")).thenReturn(user);

        when(userRepository.save(any(Users.class))).thenReturn(user);

        ResponseEntity<Object> response = userService.createUser(user);

        verify(userRepository, times(1)).findByEmail("test@example.com");

        assertEquals(HttpStatus.MULTI_STATUS, response.getStatusCode());
    }

    @Test
    void testLogin() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPassword("123456");

        Users user = new Users();
        user.setEmail("test@example.com");
        user.setDob("1993-11-29");
        user.setId(1);
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setGender("m");
        user.setMobileNo("9876543210");
        user.setRole("2");
        user.setPassword("123456");
        user.setPasswordConfirm("123456");

        when(userRepository.findByEmail("test@example.com")).thenReturn(user);

        UserDto loggedInUser = userService.login(loginDto);

        verify(userRepository, times(1)).findByEmail("test@example.com");

        assertEquals("test@example.com", loggedInUser.getEmail());
    }    
    
    @Test
    void testLoginWrongPassword() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPassword("1234");

        Users user = new Users();
        user.setEmail("test@example.com");
        user.setDob("1993-11-29");
        user.setId(1);
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setGender("m");
        user.setMobileNo("9876543210");
        user.setRole("2");
        user.setPassword("123456");
        user.setPasswordConfirm("123456");

        when(userRepository.findByEmail("test@example.com")).thenReturn(user);

        UserDto loggedInUser = userService.login(loginDto);

        verify(userRepository, times(1)).findByEmail("test@example.com");

        assertEquals(null, loggedInUser);
    }    
    @Test
    void testLoginWrongUser() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("test@exam.com");
        loginDto.setPassword("1234");

        Users user = new Users();
        user.setEmail("test@example.com");
        user.setDob("1993-11-29");
        user.setId(1);
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setGender("m");
        user.setMobileNo("9876543210");
        user.setRole("2");
        user.setPassword("123456");
        user.setPasswordConfirm("123456");

        when(userRepository.findByEmail("test@example.com")).thenReturn(user);

        UserDto loggedInUser = userService.login(loginDto);

        assertEquals(null, loggedInUser);
    }    
    @Test
    void testLoginDifferentUser() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPassword("123456");

        Users user = new Users();
        user.setEmail("test@example.com");
        user.setDob("1993-11-29");
        user.setId(1);
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setGender("f");
        user.setMobileNo("9876543210");
        user.setRole("1");
        user.setPassword("123456");
        user.setPasswordConfirm("123456");

        when(userRepository.findByEmail("test@example.com")).thenReturn(user);

        UserDto loggedInUser = userService.login(loginDto);

        verify(userRepository, times(1)).findByEmail("test@example.com");

        assertEquals("test@example.com", loggedInUser.getEmail());
    }

    @SuppressWarnings("unused")
	@Test
    void testGetAllUsers() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        List<Users> usersList = new ArrayList<>();
        Users user = new Users(1,"test@example.com","123","test","test","9876543210","m","2000-01-01","1","123");
        Users user1 = new Users(2,"test1@example.com","1234","test1","test1","9876543210","f","2000-01-01","2","123");
        usersList.add(user);
        
        when(userRepository.findAll()).thenReturn(usersList);
        
        List<UserDto> userDtos = userService.getAllUsers();
        
        for (Users usertoconvert : usersList) {
            UserDto userDto = userService.convertToUserDto(usertoconvert);
        }
        verify(userRepository, times(1)).findAll();

        assertEquals(usersList.size(), userDtos.size());
    }
}
