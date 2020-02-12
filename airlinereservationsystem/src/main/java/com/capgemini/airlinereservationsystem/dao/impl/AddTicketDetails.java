package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.capgemini.airlinereservationsystem.dao.AddTicketInterface;
import com.capgemini.airlinereservationsystem.dto.AddTicketDetailsBean;

public class AddTicketDetails implements AddTicketInterface {

	public int addTicket() {

		int res = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			con = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into ticket_details values(?,?,?,?,?) ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, AddTicketDetailsBean.getTicketId());
			pstmt.setInt(2, AddTicketDetailsBean.getFlightId());
			pstmt.setDouble(3, AddTicketDetailsBean.getPrice());
			pstmt.setInt(4, AddTicketDetailsBean.getTotalTickets());
			pstmt.setString(5, AddTicketDetailsBean.getStatus());

			res = pstmt.executeUpdate();

			return res;

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
				e2.printStackTrace();
			}
		}
		return res;
	}
}
