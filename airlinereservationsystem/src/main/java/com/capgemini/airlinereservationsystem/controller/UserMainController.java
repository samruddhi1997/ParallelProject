package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.validation.CustomerDetailsValidation;

public class UserMainController {
	static Logger log = new LogManager().getLogger("user");

	public static void userMain(String customerName) {
		Scanner sc = new Scanner(System.in);
		log.info("**********************************************");
		log.info("Welcome to Airline Reservation System...");
		log.info("**********************************************");
		log.info("haiii    "+customerName);
		log.info("Please Enter your choice");
		log.info("please Enter 1 to get Customer Details");
		log.info("please Enter 2 to get Schedule Details");
		log.info("please Enter 3 to get Journey Deatails");
		log.info("please Enter 4 to return home");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			CustomerDetailsController.checkCustomer();

			break;
		case 2:
			ScheduleDetailsController.schedule();
			break;
		case 3:
			JourneyDetailsController.journey();
			break;
		case 4:
			break;
		default:
			log.info("invalid choice");
			break;
		}
		sc.close();

	}

}
