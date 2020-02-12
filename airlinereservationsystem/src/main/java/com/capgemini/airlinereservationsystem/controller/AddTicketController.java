package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.service.AddTicketServiceInterface;
import com.capgemini.airlinereservationsystem.service.impl.AddTicketService;

public class AddTicketController {

	static Logger log = new LogManager().getLogger("admin");

	public static void checkTicket() {

		Scanner sc = new Scanner(System.in);

		try {

			log.info("Enter ticket details");
			log.info("Ticket ID: ");
			int ticketId = sc.nextInt();
			log.info("Flight ID: ");
			int flightId = sc.nextInt();
			log.info("Price: ");
			double price = sc.nextDouble();
			log.info("Total Tickets: ");
			int totalTickets = sc.nextInt();
			log.info("Status: ");
			String status = sc.next();

			AddTicketServiceInterface service = new AddTicketService();
			int res = service.checkTicket(ticketId, flightId, price, totalTickets, status);
			if (res != 0) {
				log.info("Ticket details added successfully");
			} else {
				log.info("oops...  check back with details");
			}
		} catch (InvalidInputDetailsException e) {
			log.info(e.getMessage());
		}
	}
}
