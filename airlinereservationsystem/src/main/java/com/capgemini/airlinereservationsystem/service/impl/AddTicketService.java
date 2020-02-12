package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.AddTicketInterface;
import com.capgemini.airlinereservationsystem.dao.impl.AddTicketDetails;
import com.capgemini.airlinereservationsystem.dto.AddTicketDetailsBean;
import com.capgemini.airlinereservationsystem.service.AddTicketServiceInterface;

public class AddTicketService implements AddTicketServiceInterface {

	public int checkTicket(int ticketId, int flightId, double price, int totalTickets, String status) {

		AddTicketDetailsBean addTicket = new AddTicketDetailsBean();
		
		addTicket.setTicketId(ticketId);
		addTicket.setFlightId(flightId);
		addTicket.setPrice(price);
		addTicket.setTotalTickets(totalTickets);
		String stat = status.toLowerCase();
		addTicket.setStatus(stat);
		
		AddTicketInterface ticket = new AddTicketDetails();
		int res = ticket.addTicket();
		return res;
	}
}
