package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dto.CustomerDetailsDto;
import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.service.impl.CustomerDetailsService;


public class CustomerDetailsController {
	static Logger log = new LogManager().getLogger("user");

	public static void checkCustomer() {
		Scanner scan = new Scanner(System.in);

		String res = CustomerDetailsService.searchForm(CustomerDetailsDto.getCustomerId());

		log.info("please enter customerId:");

		try {
			int customer_id = scan.nextInt();
			log.info(CustomerDetailsService.searchForm(customer_id));

		} catch (InvalidOptionException e) {
			log.info(e.getMessage());
		}

		if (res != null) {
			System.out.println("");
		} else {
			System.out.println("invalid customer_id");
		}

	}

}
