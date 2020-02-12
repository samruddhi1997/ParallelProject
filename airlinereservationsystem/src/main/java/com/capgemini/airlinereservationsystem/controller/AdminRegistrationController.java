package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.service.impl.AdminRegistrationService;

public class AdminRegistrationController {
	static Logger log = new LogManager().getLogger("admin");

	public static void adminregistrationcontroller() {
		Scanner scan = new Scanner(System.in);
		log.info("Admin ID: ");
		int admin_id = scan.nextInt();
		log.info("Admin Name: ");
		String admin_name = scan.next();
		log.info("Password: ");
		String password = scan.next();
		log.info("Email: ");
		String email = scan.next();
		log.info("Phone Number: ");
		long phone_number = scan.nextLong();
		int res = AdminRegistrationService.registrationService(admin_id, admin_name, password, email, phone_number);

		if (res != 0) {
			System.out.println("Registration successfull");
		} else {
			try {
				throw new InvalidInputDetailsException();
			} catch (InvalidInputDetailsException e) {
				log.info(e.getMessage());
			}
		}
	}

}