package com.capgemini.airlinereservationsystem.dto;

public class JourneyDetailsDto {
	private static int flightId;
	private static String flightDay;
	private static String source;
	private static String destination;
	private static String departureTime;
	private static String arrivalTime;

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		JourneyDetailsDto.flightId = flightId;
	}

	public static String getFlightDay() {
		return flightDay;
	}

	public void setFlightDay(String flightDay) {
		JourneyDetailsDto.flightDay = flightDay;
	}

	public static String getSource() {
		return source;
	}

	public void setSource(String source) {
		JourneyDetailsDto.source = source;
	}

	public static String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		JourneyDetailsDto.destination = destination;
	}

	public static String getDepartureTime() {
		return departureTime;
	}

	public static void setDepartureTime(String departureTime) {
		JourneyDetailsDto.departureTime = departureTime;
	}

	public static String getArrivalTime() {
		return arrivalTime;
	}

	public static void setArrivalTime(String arrivalTime) {
		JourneyDetailsDto.arrivalTime = arrivalTime;
	}

}
