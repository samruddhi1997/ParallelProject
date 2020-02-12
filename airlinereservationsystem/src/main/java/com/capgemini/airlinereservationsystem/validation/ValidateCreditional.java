package com.capgemini.airlinereservationsystem.validation;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.capgemini.airlinereservationsystem.dao.AdminLogin;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;

public class ValidateCreditional {


	public static boolean passwordValidator(String inputAdminName, String inputAdminPassword) throws LoginFailedException {

		boolean status = false;
		try {

			AdminLogin admin = new AdminLogin();
			List<String> login = admin.login();

			String adminName = login.get(0);
			String password = login.get(1);

			if (inputAdminName.equals(adminName)) {
				if (BCrypt.checkpw(inputAdminPassword, password)) {
					status = true;
				} else {
					status = false;
				}
			} else {
				status = false;
			}
			return status;

		} catch (LoginFailedException e) {
			throw new LoginFailedException();
		}
	}
}
