package com.capgemini.airlinereservationsystem.service.impl;


import com.capgemini.airlinereservationsystem.dao.impl.JourneyDetailsDaoImpl;
import com.capgemini.airlinereservationsystem.dto.JourneyDetailsDto;

public class JourneyDetailsService {
	public static String journeyDetails(int flightId) {
		JourneyDetailsDto add = new JourneyDetailsDto();
		add.setFlightId(flightId);

		JourneyDetailsDaoImpl jddi = new JourneyDetailsDaoImpl();
		String res = jddi.journeyDetails();
		return res;
	}

}
