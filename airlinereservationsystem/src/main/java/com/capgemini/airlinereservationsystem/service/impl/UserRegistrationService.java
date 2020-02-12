package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.AdminRegistrationDaoImpl;
import com.capgemini.airlinereservationsystem.dao.UserRegistration;
import com.capgemini.airlinereservationsystem.dto.AdminRegistrationBean;
import com.capgemini.airlinereservationsystem.dto.UserRegistrationBean;
import com.capgemini.airlinereservationsystem.validation.PasswordEncoder;

public class UserRegistrationService {
	public static int registrationService(int customerId,String customerName,String password,String dob,long phoneNumber,String email,String govtId,String gender,String nationality) {
				
			
		UserRegistrationBean registration=new UserRegistrationBean();
		registration.setCustomerId(customerId);;
		registration.setCustomerName(customerName);
		String enPassword=PasswordEncoder.passwordEncoder(password);
		registration.setPassword(enPassword);
		registration.setDob(dob);
		registration.setPhone_number(phoneNumber);
		registration.setEmail(email);
		registration.setGovtId(govtId);
		registration.setGender(gender);
		registration.setNationality(nationality);
		
		UserRegistration register = new UserRegistration();
		int res = register.login();
		return res;
		
	}

}



