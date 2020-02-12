package com.capgemini.airlinereservationsystem.service;

public interface AddTicketServiceInterface {

	public int checkTicket(int ticketId, int flightId, double price, int totalTickets, String status);
}
