package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.AdminRegistrationDaoImpl;
import com.capgemini.airlinereservationsystem.dto.AdminRegistrationBean;
import com.capgemini.airlinereservationsystem.validation.PasswordEncoder;

public class AdminRegistrationService {
	public static int registrationService(int adminId,String adminName,String password,String email,long phoneNumber) {
		AdminRegistrationBean registration=new AdminRegistrationBean();
		registration.setAdminId(adminId);
		registration.setAdminName(adminName);
		String enPassword = PasswordEncoder.passwordEncoder(password);
		registration.setPassword(enPassword);
		registration.setEmail(email);
		registration.setPhone_number(phoneNumber);
		
		AdminRegistrationDaoImpl register = new AdminRegistrationDaoImpl();
		int res = register.adminregistration();
		return res;
		
	}

}
