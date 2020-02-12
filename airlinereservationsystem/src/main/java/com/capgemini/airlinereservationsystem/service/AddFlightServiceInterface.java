package com.capgemini.airlinereservationsystem.service;

public interface AddFlightServiceInterface {

	public int flightService(int flightId, String flightName, String source, String destination,
			String arrivalTime, String departureTime);
}
