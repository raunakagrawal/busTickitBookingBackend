package com.raunak.bus;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.raunak.bus.Entity.Cities;
import com.raunak.bus.Entity.Users;
import com.raunak.bus.Service.ValidationService;

public class ValidationServiceTest {
		
	@SuppressWarnings("unused")
	@Test
	void validateTest() {
		LocalValidatorFactoryBean validator = mock(LocalValidatorFactoryBean.class);
		ValidationService validationservice = new ValidationService(validator);
		Users user = new Users(1,"test@example.com","123","test","test","9876543210","m","2000-01-01","1","123");
		
		Cities city = new Cities(1,"Nagpur",400);
        	ValidationService.validate(city);
        Cities city1 = new Cities(1,null,400);
        	ValidationService.validate(city1);

	}
}
