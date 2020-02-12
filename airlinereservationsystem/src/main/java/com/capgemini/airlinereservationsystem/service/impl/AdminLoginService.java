package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.AdminLogin;
import com.capgemini.airlinereservationsystem.dao.AdminRegistrationDaoImpl;
import com.capgemini.airlinereservationsystem.dto.AdminLoginBean;
import com.capgemini.airlinereservationsystem.dto.AdminRegistrationBean;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;
import com.capgemini.airlinereservationsystem.validation.ValidateCreditional;
import com.capgemini.airlinereservationsystem.validation.ValidateUser;

public class AdminLoginService  {
	public static boolean registrationService(String adminName, String password) throws LoginFailedException {

		AdminLoginBean registration = new AdminLoginBean();

		String adminname = adminName.toLowerCase();
		registration.setAdminName(adminname);

		try {
			boolean res = ValidateCreditional.passwordValidator(adminname, password);
			
			return res;
		} catch (LoginFailedException e) {
			throw new LoginFailedException();
		}
	}
}
