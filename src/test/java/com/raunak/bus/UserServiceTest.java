package com.raunak.bus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.raunak.bus.Dto.UserDto;
import com.raunak.bus.Entity.Users;
import com.raunak.bus.Repository.UserRepository;
import com.raunak.bus.Service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
    private UserRepository userRepository;
	
	@InjectMocks
    private UserService userService;
	
//	@DisplayName("JUnit test for saveEmployee method")
//	@Test
//	void testFindAllEmployees() {
//		
//		List<Users> list = new ArrayList<Users>();
//		
//		Users user1 = new Users(2,"raunak123@gmail.com","123", "Raunak"," Agrawal","4477087606","m","2003/12/04","1","123");
//		Users user2 = new Users(2,"raunak12@gmail.com","123", "Raunak"," Agrawal","4477087606","m","2003/12/04","1","123");
//		Users user3 = new Users(2,"raunak1@gmail.com","123", "Raunak"," Agrawal","4477087606","m","2003/12/04","1","123");
//		
//		list.add(user1);
//		list.add(user2);
//		list.add(user3);
//		
//		List<UserDto> list1 = new ArrayList<UserDto>();
//		
//		UserDto user4 = new UserDto(2,"Raunak Agrawal","raunak1@gmail.com","4477087606","m","1",30,"2003/12/04");
//		UserDto user5 = new UserDto(2,"Raunak Agrawal","raunak2@gmail.com","4477087606","m","1",30,"2003/12/04");
//		UserDto user6 = new UserDto(2,"Raunak Agrawal","raunak3@gmail.com","4477087606","m","1",30,"2003/12/04");
//		
//		list1.add(user4);
//		list1.add(user5);
//		list1.add(user6);
//		
//		when(userRepository.findAll()).thenReturn(list);
//
//	    //test
//	    List<UserDto> empList = userService.getAllUsers();
//
//	    assertEquals(3, empList.size());
//	    verify(userRepository, times(1)).findAll();
//    }	
	@Test
	  void testCreateOrSaveEmployee() {
		Users user1 = new Users(2,"raunak123@gmail.com","123", "Raunak"," Agrawal","4477087606","m","2003/12/04","1","123");

		userService.createUser1(user1);
	         
	    verify(userRepository, times(5)).save(user1);
	  }
}

