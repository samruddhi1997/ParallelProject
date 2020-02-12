package com.capgemini.airlinereservationsystem.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dao.impl.FlightInformation;
import com.capgemini.airlinereservationsystem.service.FlightInfoServiceInterface;

public class FlightInformationService implements FlightInfoServiceInterface {

	static Logger log = new LogManager().getLogger("admin");
	
	public List<String> flightInfo() {
		
		FlightInformation info = new FlightInformation();
		List<String> result = info.flightInfo();
		return result;
	}
}
