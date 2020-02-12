package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;

import com.capgemini.airlinereservationsystem.dto.JourneyDetailsDto;
import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.service.impl.JourneyDetailsService;


public class JourneyDetailsController {
	static org.apache.log4j.Logger log = LogManager.getLogger("customer");
	static Scanner sc = new Scanner(System.in);

	static String res =
	 JourneyDetailsService.journeyDetails(JourneyDetailsDto.getFlightId());

	public static void journey() {
		try {

			log.info("Please Enter FlightId ");
			int flightId = sc.nextInt();
			log.info(JourneyDetailsService.journeyDetails(flightId));
			if (res != null) {
				log.info("Have Happy And Safe Journey..!!!!");
			} else {
				log.info("Please Enter Valid FlightId");
			}
		} catch (InvalidOptionException e) {
			log.info(e.getMessage());
		}

	}

}
