package com.capgemini.airlinereservationsystem;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.controller.AdminLoginController;
import com.capgemini.airlinereservationsystem.controller.AdminRegistrationController;
import com.capgemini.airlinereservationsystem.controller.CustomerLoginController;
import com.capgemini.airlinereservationsystem.controller.UserRegistrationController;
import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;

public class Home {

	static Logger log = LogManager.getLogger("admin");

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		log.info("\n\n==================================");
		log.info("Welcome to KingFisher Airlines...");
		log.info("==================================");
		log.info("\n--------------Menu---------------\n");
		log.info("Please Enter 1 to SignIn");
		log.info("Please Enter 2 to SignUp");
		log.info("Please Enter 3 to Check Flights");
		log.info("Please Enter 4 to Contact us");

		int option = scan.nextInt();

		switch (option) {
		case 1:
			log.info("\n----------Login----------\n");
			log.info("Enter 1 to User Login");
			log.info("Enter 2 to Admin Login");
			log.info("Enter 3 to Home");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				CustomerLoginController.customerlogincontroller();
				break;
			case 2:
				AdminLoginController.adminlogincontroller();
				break;
			case 3:
				new Home();
				break;

			default:
				try {
					throw new InvalidOptionException();
				} catch (InvalidOptionException e) {
					log.info(e.getMessage());
					new Home();
				}
				break;
			}
		case 2:
			log.info("\n----------Registration----------\n");
			log.info("Enter 1 to User Registration");
			log.info("Enter 2 to Admin Registration");
			log.info("Enter 3 to Home");
			int reg = scan.nextInt();
			switch (reg) {
			case 1:
				UserRegistrationController.userregistrationcontroller();
				break;
			case 2:
				AdminRegistrationController.adminregistrationcontroller();
				break;
			case 3:
				new Home();
				break;

			default:
				try {
					throw new InvalidOptionException();
				} catch (InvalidOptionException e) {
					log.info(e.getMessage());
					new Home();
				}
				break;
			}
		case 4:
			log.info("Contact US:");
			log.info("Samruddhi\nVinay\nKetki\nRahul");
			log.info("Address: QSpiders Basavanagudi");
			break;
		default:
			try {
				throw new InvalidOptionException();
			} catch (InvalidOptionException e) {
				log.info(e.getMessage());
				new Home();
			}
		}
	}
}