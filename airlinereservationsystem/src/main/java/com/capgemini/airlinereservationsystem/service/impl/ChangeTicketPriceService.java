package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.ChangeTiketPriceInterface;
import com.capgemini.airlinereservationsystem.dao.impl.ChangeTicketPrice;
import com.capgemini.airlinereservationsystem.dto.ChangeTicketPriceBean;
import com.capgemini.airlinereservationsystem.service.ChangePriceServiceInterface;

public class ChangeTicketPriceService implements ChangePriceServiceInterface {

	public int changePrice(double newPrice, int ticketId, int flightId) {
		
		ChangeTicketPriceBean change = new ChangeTicketPriceBean();
		change.setNewPrice(newPrice);
		change.setTicketId(ticketId);
		change.setFlight_id(flightId);
		
		ChangeTiketPriceInterface ticket = new ChangeTicketPrice();
		int res = ticket.changeTicketPrice();
		return res;
	}
}
