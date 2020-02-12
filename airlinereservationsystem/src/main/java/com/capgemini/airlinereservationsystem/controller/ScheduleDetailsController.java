package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;

import com.capgemini.airlinereservationsystem.service.impl.ScheduleDetailsService;


public class ScheduleDetailsController {
	static org.apache.log4j.Logger log = LogManager.getLogger("customer");

	public static void schedule() {

		Scanner scan = new Scanner(System.in);

		log.info("Please enter below details\n");
		log.info("Flight ID: ");
		int flightId = scan.nextInt();

		String result = ScheduleDetailsService.scheduleFlight(flightId);
		log.info(ScheduleDetailsService.scheduleFlight(flightId));
		if (result != null) {
			System.out.println("Have Happy and Safe Journey..!!!!");
		} else {
			System.out.println("oops.. check back with details");
		}
	}

}
