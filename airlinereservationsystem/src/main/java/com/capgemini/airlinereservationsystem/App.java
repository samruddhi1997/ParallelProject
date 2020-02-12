package com.capgemini.airlinereservationsystem;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.controller.AdminMainController;
import com.capgemini.airlinereservationsystem.dao.impl.AddFlightDetails;
import com.capgemini.airlinereservationsystem.dao.impl.AddTicketDetails;
import com.capgemini.airlinereservationsystem.dao.impl.ChangeTicketPrice;
import com.capgemini.airlinereservationsystem.dao.impl.FlightInformation;
import com.capgemini.airlinereservationsystem.dto.AddTicketDetailsBean;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger log = new LogManager().getLogger("admin");
	
    public static void main( String[] args )
    {
//    		AdminMainController.checkFlight();
    }
}
