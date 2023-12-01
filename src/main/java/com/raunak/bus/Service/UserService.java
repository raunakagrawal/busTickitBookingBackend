package com.raunak.bus.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raunak.bus.Dto.LoginDto;
import com.raunak.bus.Dto.UserDto;
import com.raunak.bus.Entity.Users;
import com.raunak.bus.ErrorResponce.ResponseHandler;
import com.raunak.bus.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public ResponseEntity<Object> createUser(Users user) {
	    	Users emailExists = userRepository.findByEmail(user.getEmail());
	    	if (emailExists != null) {
	    		return ResponseHandler.generateResponse("This Email is already registered.", HttpStatus.MULTI_STATUS, null);
            } else {
	        Users newUser = new Users();
	        newUser.setEmail(user.getEmail());
	        newUser.setDob(user.getDob());
	        newUser.setFirstName(user.getFirstName());
	        newUser.setLastName(user.getLastName());
	        newUser.setGender(user.getGender());
	        newUser.setRole(user.getRole());
	        newUser.setPassword(user.getPassword());
	        newUser.setMobileNo(user.getMobileNo());
	        Users savedUser = userRepository.save(newUser);
	        UserDto userDto = convertToUserDto(savedUser);
	        return ResponseHandler.generateResponse("Sucessfully Registered", HttpStatus.OK, userDto);
            }
	    }
	    
	    public UserDto login(LoginDto login) {
	    	Users user = userRepository.findByEmail(login.getEmail());
	    	if(user == null) {
	    		return null;
	    	}
	    	
	    	String userPassword = user.getPassword();
	    	String loginPassword = login.getPassword();
	    	
	    	if(loginPassword.equals(userPassword)) {
	    		UserDto userDto = convertToUserDto(user);
	    		return userDto;
	    	}else {
	    		return null;
	    	}
	    }
    
	    public List<UserDto> getAllUsers() {
	        List<Users> users = (List<Users>) userRepository.findAll();
	        List<UserDto> userDtos = new ArrayList<>();
	
	        for (Users user : users) {
	            UserDto userDto = convertToUserDto(user);
	            userDtos.add(userDto);
	        }
	
	        return userDtos;
	    }
	
	    public UserDto convertToUserDto(Users user) {
	        UserDto userDto = new UserDto();
	        userDto.setId(user.getId());
	        userDto.setFullName(user.getFirstName() + " " + user.getLastName());
	        userDto.setEmail(user.getEmail());
	        userDto.setMobileNo(user.getMobileNo());
	        userDto.setDob(user.getDob());
			LocalDate da = LocalDate.parse(user.getDob());
			LocalDate curDate = LocalDate.now();  
			Integer age = Period.between(da, curDate).getYears();
			userDto.setAge(age);
			
	        if ("1".equals(user.getRole())) {
	            userDto.setRole("Admin");
	        } else {
	        	userDto.setRole("Customer");
	        }
	        
	        if ("m".equals(user.getGender())) {
	        	userDto.setGender("Male");
	        } else {
	        	userDto.setGender("Female");
	        }
	        
	        return userDto;
	    }
	    
	    
}