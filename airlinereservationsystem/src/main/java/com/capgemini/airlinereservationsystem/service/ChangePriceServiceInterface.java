package com.capgemini.airlinereservationsystem.service;

public interface ChangePriceServiceInterface {

	public int changePrice(double newPrice, int ticketId, int flightId);
}
