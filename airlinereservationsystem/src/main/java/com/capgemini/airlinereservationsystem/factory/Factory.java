package com.capgemini.airlinereservationsystem.factory;

import com.capgemini.airlinereservationsystem.dao.AddFlightDetailsInterfacae;
import com.capgemini.airlinereservationsystem.dao.impl.AddFlightDetails;

public class Factory {

	public static AddFlightDetailsInterfacae addFlightFactory() {
		AddFlightDetailsInterfacae flight = new AddFlightDetails();
		return flight;
	}
}
