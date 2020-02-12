package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dto.ScheduleDetailsDto;

public class ScheduleDetailsDaoImpl implements ScheduleDetailsDao {

	static Logger log = new LogManager().getLogger("customer");

	
	public String scheduleFlight() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			con = DriverManager.getConnection(dburl, "root", "root");

			String query = "select*  from flight_details where flight_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,ScheduleDetailsDto.getFlightId());

			ResultSet rs = pstmt.executeQuery();

			String result = "";
			while (rs.next()) {

				result = result + "\n" + "flightId= " + rs.getInt("flight_id") + "\n" + "Arrivaltime " + "\t\t"
						+ "DepartureTime " + "\n" + rs.getString("arrival_time") + "\t\t"
						+ rs.getTime("departure_time");

			}

			return result;
		} catch (Exception e) {
			e.getMessage();
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
