package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dto.UserLoginBean;
import com.capgemini.airlinereservationsystem.validation.ValidateUser;

public class UserLoginService {
	public static boolean loginService(String customerName, String password) {

		UserLoginBean login = new UserLoginBean();
		String customername = customerName.toLowerCase();
		login.setCustomerName(customername);

		boolean res = ValidateUser.passwordValidator(customerName, password);
		return res;

	}
}
