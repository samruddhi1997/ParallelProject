package com.capgemini.airlinereservationsystem.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.SomeThingWentWrongException;
import com.capgemini.airlinereservationsystem.service.FlightInfoServiceInterface;
import com.capgemini.airlinereservationsystem.service.impl.FlightInformationService;

public class FlightInformationController {

	static Logger log = new LogManager().getLogger("admin");

	public static void flightInfo() {

		log.info("Flight details\n");

		try {
			
			FlightInfoServiceInterface service = new FlightInformationService();
			List<String> result = service.flightInfo();
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.size(); i++) {
				sb.append(result.get(i)+"\t");
			}
			log.info(sb);
		
		} catch (SomeThingWentWrongException e) {
			log.info(e.getMessage());
		}
	}
}
