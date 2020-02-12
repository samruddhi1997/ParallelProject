package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.Home;
import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;
import com.capgemini.airlinereservationsystem.service.impl.AdminLoginService;

public class AdminLoginController {
	static Logger log = new LogManager().getLogger("admin");

	public static void adminlogincontroller() {
		Scanner scan = new Scanner(System.in);
		log.info("\n==========Admin Login=========");
		log.info("\nPlease Enter Login Credentials\n");
		log.info("User Name");
		String adminName = scan.next();
		log.info("Password");
		String password = scan.next();


		try {
			boolean res = AdminLoginService.registrationService(adminName, password);
			if (res == true) {
				log.info("Login success");
				AdminMainController.checkFlight(adminName);
			} else {
				log.info("Login failed");
				log.info("Enter 1 Login again");
				log.info("Enter 2 to Home");
				int key = scan.nextInt();
				switch (key) {
				case 1:
					AdminLoginController.adminlogincontroller();
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
