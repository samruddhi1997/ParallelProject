package com.capgemini.airlinereservationsystem.service.impl;


import com.capgemini.airlinereservationsystem.dao.impl.ScheduleDetailsDaoImpl;
import com.capgemini.airlinereservationsystem.dto.ScheduleDetailsDto;

public class ScheduleDetailsService {
	public static String scheduleFlight(int flightId) {

		ScheduleDetailsDto add = new ScheduleDetailsDto();
		add.setFlightId(flightId);

		ScheduleDetailsDaoImpl daoImpl = new ScheduleDetailsDaoImpl();
		String res = daoImpl.scheduleFlight();
		return res;
	}

}
