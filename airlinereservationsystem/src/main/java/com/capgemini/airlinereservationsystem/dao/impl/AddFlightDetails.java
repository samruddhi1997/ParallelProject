package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.capgemini.airlinereservationsystem.dao.AddFlightDetailsInterfacae;
import com.capgemini.airlinereservationsystem.dto.AddFlightDetailsBean;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;

public class AddFlightDetails implements AddFlightDetailsInterfacae {

	public int addFlight() {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			con = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into flight_details values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, AddFlightDetailsBean.getFlightId());
			pstmt.setString(2, AddFlightDetailsBean.getFlightName());
			pstmt.setString(3, AddFlightDetailsBean.getSource());
			pstmt.setString(4, AddFlightDetailsBean.getDestination());
			pstmt.setString(5, AddFlightDetailsBean.getArrivalTime());
			pstmt.setString(6, AddFlightDetailsBean.getDepartureTime());

			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}