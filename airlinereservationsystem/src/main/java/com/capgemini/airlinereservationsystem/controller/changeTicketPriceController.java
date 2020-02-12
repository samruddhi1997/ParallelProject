package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dao.ChangeTiketPriceInterface;
import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.service.ChangePriceServiceInterface;
import com.capgemini.airlinereservationsystem.service.impl.ChangeTicketPriceService;

public class changeTicketPriceController {

	static Logger log = new LogManager().getLogger("admin");

	public static void checkPrice() {

		Scanner sc = new Scanner(System.in);

		try {

			log.info("Enter details to update");
			log.info("New Price: ");
			double newPrice = sc.nextDouble();
			log.info("Ticket ID: ");
			int ticketId = sc.nextInt();
			log.info("Flight ID: ");
			int flightId = sc.nextInt();

			ChangePriceServiceInterface service = new ChangeTicketPriceService();
			int res = service.changePrice(newPrice, ticketId, flightId);

			if (res != 0) {
				log.info("New Price updated successfully");
			} else {
				log.info("oops... check back with details");
			}
		} catch (InvalidInputDetailsException e) {
			log.info(e.getMessage());
		}
	}
}
