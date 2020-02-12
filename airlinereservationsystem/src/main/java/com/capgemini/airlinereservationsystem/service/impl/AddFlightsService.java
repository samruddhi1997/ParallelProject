package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.AddFlightDetailsInterfacae;
import com.capgemini.airlinereservationsystem.dto.AddFlightDetailsBean;
import com.capgemini.airlinereservationsystem.factory.Factory;
import com.capgemini.airlinereservationsystem.service.AddFlightServiceInterface;

public class AddFlightsService implements AddFlightServiceInterface {

	public int flightService(int flightId, String flightName, String source, String destination,
			String arrivalTime, String departureTime) {

		AddFlightDetailsBean add = new AddFlightDetailsBean();
		add.setFlightId(flightId);
		String fname = flightName.toLowerCase();
		add.setFlightName(fname);
		String src = source.toLowerCase();
		add.setSource(source);
		String dest = destination.toLowerCase();
		add.setDestination(dest);
		add.setArrivalTime(arrivalTime);
		add.setDepartureTime(departureTime);
		
		AddFlightDetailsInterfacae factory = Factory.addFlightFactory();
		int res = factory.addFlight();
		return res;
	}
}