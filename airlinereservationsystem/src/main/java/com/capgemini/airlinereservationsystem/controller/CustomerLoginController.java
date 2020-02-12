package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.Home;
import com.capgemini.airlinereservationsystem.exception.AdminNotFoundException;
import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;
import com.capgemini.airlinereservationsystem.service.impl.UserLoginService;

public class CustomerLoginController {
	static Logger log = new LogManager().getLogger("admin");

	public static void customerlogincontroller() {
		Scanner scan = new Scanner(System.in);
		log.info("\n===========User Login===========\n");
		log.info("\nPlease Enter Login Credentials\n");
		log.info("Customer Name");
		String customer_name = scan.next();
		log.info("Password");
		String password = scan.next();

		try {
			boolean res = UserLoginService.loginService(customer_name, password);
			if (res == true) {
				log.info("Login success");
				UserMainController.userMain(customer_name);
			} else {
				log.info("Login failed");
				log.info("Enter 1 Login again");
				log.info("Enter 2 to Home");
				int key = scan.nextInt();
				switch (key) {
				case 1:
					CustomerLoginController.customerlogincontroller();
					break;
				case 2:
					new Home().main(null);;
					break;
				default:
					try {
						throw new InvalidOptionException();
					} catch (InvalidOptionException e) {
						log.info(e.getMessage());
						new Home().main(null);;
					}
					break;
				}
			}
		} catch (LoginFailedException ae) {
			log.info(ae.getMessage());
		}
	}
}