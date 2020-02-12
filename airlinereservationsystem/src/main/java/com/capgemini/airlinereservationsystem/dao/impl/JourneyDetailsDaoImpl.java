package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dto.JourneyDetailsDto;
import com.capgemini.airlinereservationsystem.dto.ScheduleDetailsDto;

public class JourneyDetailsDaoImpl implements JouneyDetailsDao {
	Logger log = new LogManager().getLogger("customer");

	
	public String journeyDetails() {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			con = DriverManager.getConnection(dburl, "root", "root");

			String query = "select*from flight_details where flight_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, JourneyDetailsDto.getFlightId());

			rs = pstmt.executeQuery();

			String result = "";
			while (rs.next()) {

				result = result + "\n" + rs.getInt("flight_id") + "\n" + "Source " + "\t\t" + "\t\t" + "Destination "
						+ "\t\t" + "ArrivalTime" + "\t\t" + "DepartureTime" + "\n"
						+ "\t\t" + rs.getString("source") + "\t\t" + rs.getString("destination") + "\t\t"
						+ rs.getString("arrival_time") + "\t\t" + rs.getString("departure_time");

			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {

			}
		}
		return null;

	}

}
