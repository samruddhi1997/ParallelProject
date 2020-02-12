package com.capgemini.airlinereservationsystem.controller;

import java.sql.Date;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.AdminNotFoundException;
import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.exception.UserNotFoundException;
import com.capgemini.airlinereservationsystem.service.impl.AdminRegistrationService;
import com.capgemini.airlinereservationsystem.service.impl.UserRegistrationService;

public class UserRegistrationController {
	static Logger log = new LogManager().getLogger("customer");

	public static void userregistrationcontroller() {
		Scanner scan = new Scanner(System.in);
		log.info("/n---------Customer Registration------/n");
		log.info("\nPlease Enter details\n");
		log.info("Customer ID: ");
		int customerId = scan.nextInt();
		log.info("Customer Name: ");
		String customerName = scan.next();
		log.info("Password: ");
		String password = scan.next();
		log.info("Date Of Birth: ");
		String dob = scan.next();
		log.info("Phone Number: ");
		long phoneNumber = scan.nextLong();
		log.info("Email: ");
		String email = scan.next();
		log.info("Govnment ID: ");
		String govtId = scan.next();
		log.info("Gender: ");
		String gender = scan.next();
		log.info("Nationality: ");
		String nationality = scan.next();

		int res = UserRegistrationService.registrationService(customerId, customerName, password, dob, phoneNumber,
				email, govtId, gender, nationality);

		if (res != 0) {
			log.info("Registration successfull");
		} else {
			try {
				throw new InvalidInputDetailsException();				
			} catch (InvalidInputDetailsException e) {
				log.info(e.getMessage());
			}
		}
		try {
			throw new UserNotFoundException();
		} catch (UserNotFoundException ae) {
			log.info(ae.getMessage());

		}
	}
}
